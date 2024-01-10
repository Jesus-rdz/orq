package gob.imss.necesaif.service;

import gob.imss.necesaif.integration.Constantes;
import gob.imss.necesaif.model.*;
import gob.imss.necesaif.utils.utilityArray;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class appServiceImpl extends JdbcDaoSupport implements appService {
    private final static Logger logger = Logger.getLogger(appServiceImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public xmlResultadoMedicamento consultaMedicamento(xmlConsultaMedicamento input) throws SQLException {
        Connection con = null;
        int iLenght = 0;
        xmlResultadoMedicamento resultadoMedicamento = new xmlResultadoMedicamento();
        RuteoDto farmaciaLocal = new RuteoDto();
        try {
            farmaciaLocal = obtenerDatosConexion(input.getClasificacionPresupuestalSolicitante(), input.getClasificacionPresupuestalFarmacia());
            //Conexion a la nueva local

            logger.info("Conexion realizada a Farmacia local: " + farmaciaLocal.getUrl());
            if(farmaciaLocal != null) {
                //ConsultaMedicamento sp
                CallableStatement call = con.prepareCall("{call SP_SIMF_CONSULTA(?, ?, ?)}");
                call.setString("@pClasPtal", input.getClasificacionPresupuestalFarmacia());
                call.setString("@pMedicamento", input.getDescripcionArticulo());
                call.setString("@pNivAtencion", String.valueOf(input.getNivelAtencion()));
                ResultSet rs = call.executeQuery();
                logger.info("StoreProcedure 'SP_SIMF_CONSULTA' ejecutado.");

                Detalles_Art detalles_art = new Detalles_Art();
                Detalles detalle[] = new Detalles[0];
                while (rs.next()) {
                    iLenght = detalle.length;
                    utilityArray utilityArray = null;
                    detalle = (Detalles[]) utilityArray.resizeArray(detalle, iLenght + 1);
                    detalle[iLenght] = new Detalles();
                    detalle[iLenght].setUnidadMedida(rs.getString("UNIDAD"));
                    detalle[iLenght].setGpo(rs.getString("GPO"));
                    detalle[iLenght].setGen(rs.getString("GEN"));
                    detalle[iLenght].setEsp(rs.getString("ESP"));
                    detalle[iLenght].setDif(rs.getString("DIF"));
                    detalle[iLenght].setVar(rs.getString("VAR"));
                    detalle[iLenght].setBasico(rs.getString("BASICO"));
                    detalle[iLenght].setForma(rs.getString("FORMA"));
                    detalle[iLenght].setUnidadMedida(rs.getString("UNI_MED"));
                    detalle[iLenght].setTipoPresentacion(rs.getString("TIPO_PRES"));
                    detalle[iLenght].setCantidadPresentacion(rs.getFloat("CANT_PRES"));
                    detalle[iLenght].setConcentracion(rs.getString("CONCENTRACION"));
                    //detalle[iLenght].setNivelInventario(rs.getString("NIVELSERVICIO"));
                    detalle[iLenght].setNivelInventario(rs.getString("INV_DISP"));
                    detalle[iLenght].setDescArticulo(rs.getString("DESCRIPCION"));
                    detalle[iLenght].setPresRazonada(rs.getInt("PRES_RAZONADA"));
                    /*falta IC_MEDICAMENTO_GEN*/
                }
                /*validacion de detalle*/
                if (detalle.length == 0) {
                    resultadoMedicamento.setEstatus(Constantes.NOHAYDATOS[0]);
                    resultadoMedicamento.setMensaje(Constantes.NOHAYDATOS[1]);
                } else {
                    detalles_art.setDetalles(detalle);
                    resultadoMedicamento.setDetalles_art(detalles_art);
                    resultadoMedicamento.setEstatus(Constantes.PROC_EXITO[0]);
                    resultadoMedicamento.setMensaje(Constantes.PROC_EXITO[1]);
                }
                /*Cierra conexion a Farmacia Local*/
                rs.close();
            } else {
                resultadoMedicamento.setMensaje(Constantes.ERR_NOINFRUTEO[1]);
                resultadoMedicamento.setEstatus(Constantes.ERR_NOINFRUTEO[0]);
            }
        } catch (Exception e){
            e.printStackTrace();
            resultadoMedicamento.setMensaje(Constantes.ERR_CNXDB[1]);
            resultadoMedicamento.setEstatus(Constantes.ERR_CNXDB[0]);
        }
        return resultadoMedicamento;
    }

    @Override
    public RuteoDto obtenerDatosConexion(String clavePresupuestalOrigen, String clavePresupuestalFarmacia) {
        String sql = "SELECT ID, VERSION, USERNAME, CLAVE_PRESUPUESTAL_ORIGEN, " +
                "DRIVER_CLASS, CLAVE_PRESUPUESTAL_FARMACIA, PASSWORD, URL " +
                "FROM RUTEO " +
                "WHERE CLAVE_PRESUPUESTAL_ORIGEN = ?" +
                "AND CLAVE_PRESUPUESTAL_FARMACIA = ?";
        RuteoDto ruteo = null;
        try{
            ruteo = (RuteoDto) this.getJdbcTemplate().queryForObject(
                    sql, new Object[]{clavePresupuestalOrigen, clavePresupuestalFarmacia},
                    new RowMapper(){
                        public Object mapRow(ResultSet res, int rowNum)
                                throws SQLException {
                            RuteoDto ruteo = new RuteoDto();
                            ruteo.setId(res.getInt("ID"));
                            ruteo.setVersion(res.getInt("VERSION"));
                            ruteo.setUsername(res.getString("USERNAME"));
                            ruteo.setClavePresupuestalOrigen(res.getString("CLAVE_PRESUPUESTAL_ORIGEN"));
                            ruteo.setDriverClass(res.getString("DRIVER_CLASS"));
                            ruteo.setClavePresupuestalFarmacia(res.getString("CLAVE_PRESUPUESTAL_FARMACIA"));
                            ruteo.setPassword(res.getString("PASSWORD"));
                            ruteo.setUrl(res.getString("URL"));
                            return ruteo;
                        }
                    });
        }catch(IncorrectResultSizeDataAccessException exp){
            logger.debug("Conexi�n no encontrada. " + exp.getMessage());
        }
        return ruteo;
    }
}
