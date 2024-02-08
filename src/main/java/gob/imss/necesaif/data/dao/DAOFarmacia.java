package gob.imss.necesaif.data.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import gob.imss.necesaif.integration.constants.Constantes;
import gob.imss.necesaif.integration.constants.SQLConstants;
import gob.imss.necesaif.integration.repository.DAORuteo;
import gob.imss.necesaif.model.*;
import gob.imss.necesaif.model.altaTratamiento.AltaTratamientoEntrada;
import gob.imss.necesaif.model.altaTratamiento.AltaTratamientoSalida;
import gob.imss.necesaif.model.cancelaMedicamento.CancelaTratamientoEntrada;
import gob.imss.necesaif.model.cancelaMedicamento.CancelaTratamientoSalida;
import gob.imss.necesaif.model.consultaMedicamento.ConsultaMedicamentoEntrada;
import gob.imss.necesaif.model.consultaMedicamento.ConsultaMedicamentoSalida;
import gob.imss.necesaif.model.consultaMedicamento.DetalleArticulo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class DAOFarmacia {
    private final static Logger logger = Logger.getLogger(DAOFarmacia.class);

    @Autowired
    private DAORuteo daoRuteo;

    public ConsultaMedicamentoSalida exeConsultaMedicamento(ConsultaMedicamentoEntrada entrada) {
        ConsultaMedicamentoSalida salida = new ConsultaMedicamentoSalida();
        try {
            RuteoDto farmaciaLocal = daoRuteo.obtenerDatosConexion(entrada.getClasificacionPresupuestalSolicitante(), entrada.getClasificacionPresupuestalFarmacia());
            if(farmaciaLocal != null) {
            //Conexion a la nueva local
            Connection con = daoRuteo.conexionConFarmacia(farmaciaLocal);
            logger.info("Conexion realizada a Farmacia local: " + farmaciaLocal.getUrl());
                //ConsultaMedicamento sp
                CallableStatement call = con.prepareCall(SQLConstants.SP_SIMF_CONSULTA);
                call.setString("@pClasPtal", entrada.getClasificacionPresupuestalFarmacia());
                call.setString("@pMedicamento", entrada.getDescripcionArticulo());
                call.setString("@pNivAtencion", String.valueOf(entrada.getNivelAtencion()));
                ResultSet rs = call.executeQuery();
                logger.info("StoreProcedure 'SP_SIMF_CONSULTA' ejecutado.");

                List<DetalleArticulo> listDetalleArticulo = new ArrayList<>();
                while (rs.next()) {
                    DetalleArticulo detalleArticulo = new DetalleArticulo();
                    detalleArticulo.setUnidadMedida(rs.getString("UNIDAD"));
                    detalleArticulo.setGrupo(rs.getString("GPO"));
                    detalleArticulo.setGenerico(rs.getString("GEN"));
                    detalleArticulo.setEspecifico(rs.getString("ESP"));
                    detalleArticulo.setDiferenciador(rs.getString("DIF"));
                    detalleArticulo.setVariante(rs.getString("VAR"));
                    detalleArticulo.setBasico(rs.getString("BASICO"));
                    detalleArticulo.setForma(rs.getString("FORMA"));
                    detalleArticulo.setUnidadMedida(rs.getString("UNI_MED"));
                    detalleArticulo.setTipoPresentacion(rs.getString("TIPO_PRES"));
                    detalleArticulo.setCantidadPresentacion(rs.getFloat("CANT_PRES"));
                    detalleArticulo.setConcentracion(rs.getInt("CONCENTRACION"));
                    detalleArticulo.setNivelServicio(rs.getInt("NIVELSERVICIO"));
                    detalleArticulo.setDescripcionArticulo(rs.getString("DESCRIPCION"));
                    detalleArticulo.setInventarioDisponible(rs.getInt("INV_DISP"));
                    detalleArticulo.setPrescripcionRazonada(rs.getInt("PRES_RAZONADA"));
                    detalleArticulo.setMedicamentoGenerico(rs.getInt("IC_MEDICAMENTO_GEN"));
                    listDetalleArticulo.add(detalleArticulo);
                }
                /*validacion de detalle*/
                if (listDetalleArticulo.size() == 0) {
                    salida.setEstatus(Constantes.NOHAYDATOS[0]);
                    salida.setMensaje(Constantes.NOHAYDATOS[1]);
                } else {
                    salida.setClavePresupuestal(entrada.getClasificacionPresupuestalFarmacia());
                    salida.setDetalleArticulo(listDetalleArticulo);
                    salida.setEstatus(Constantes.PROC_EXITO[0]);
                    salida.setMensaje(Constantes.PROC_EXITO[1]);
                }
                /*Cierra conexion a Farmacia Local*/
                rs.close();
            } else {
                salida.setMensaje(Constantes.ERR_NOINFRUTEO[1]);
                salida.setEstatus(Constantes.ERR_NOINFRUTEO[0]);
            }
        } catch (Exception e){
            e.printStackTrace();
            salida.setMensaje(Constantes.ERR_CNXDB[1]);
            salida.setEstatus(Constantes.ERR_CNXDB[0]);
        }
        return salida;
    }

    public AltaTratamientoSalida exeAltaTratamiento(AltaTratamientoEntrada entrada) throws JsonProcessingException {
        AltaTratamientoSalida salida = new AltaTratamientoSalida();
        final XmlMapper xmlMapper = new XmlMapper();
        final String xmlTratamiento = xmlMapper.writeValueAsString(entrada.getTratamiento());
        logger.info("xmlMapper: " + xmlTratamiento.replace("ArrayList", "tratamiento")
                .replace("<item>", "").replace("</item>", "").replace("<", "<ns0:"));
        try {
            RuteoDto farmaciaLocal = daoRuteo.obtenerDatosConexion(entrada.getClasificacionPresupuestalSolicitante(), entrada.getClasificacionPresupuestalFarmacia());
            //Conexion a la nueva local
            if(farmaciaLocal != null) {
                Connection con = daoRuteo.conexionConFarmacia(farmaciaLocal);
                logger.info("Conexion realizada a Farmacia local: " + farmaciaLocal.getUrl());
                //SP_SIMF_TRATAMIENTO(xmlTratamiento, pMensaje)
                CallableStatement call = con.prepareCall(SQLConstants.SP_SIMF_TRATAMIENTO);
                call.registerOutParameter(1, java.sql.Types.INTEGER);
                call.registerOutParameter("@pMensaje", java.sql.Types.VARCHAR);
                call.setString("@pXMLTratamiento", xmlTratamiento);
                call.setString("@pMensaje", "");
                //Llama a ejecutar el StoreProcedure de alta
                call.execute();
                logger.info("StoreProcedure 'SP_SIMF_TRATAMIENTO' ejecutado.");
                if(call.getString(1)!=null) {
                    salida.setEstatus(call.getString(1));
                    salida.setMensaje(call.getString("@pMensaje"));
                }else {
                    salida.setEstatus(Constantes.ERR_ACTUALIZARSP[0]);
                    salida.setMensaje(Constantes.ERR_ACTUALIZARSP[1]);
                }
                con.close();
            }else {
                salida.setEstatus(Constantes.ERR_NOINFRUTEO[0]);
                salida.setMensaje(Constantes.ERR_NOINFRUTEO[1]);
            }
        } catch (Exception e){
            e.printStackTrace();
            salida.setEstatus(Constantes.ERR_CNXDB[0]);
            salida.setMensaje(Constantes.ERR_CNXDB[1]);
        }
        return salida;
    }

    public CancelaTratamientoSalida exeCancelaTratamiento(int tipo, CancelaTratamientoEntrada entrada) {
        CancelaTratamientoSalida salida = new CancelaTratamientoSalida();
        try {
            RuteoDto farmaciaLocal = daoRuteo.obtenerDatosConexion(entrada.getClasificacionPresupuestal(), entrada.getClasificacionPresupuestalFarmacia());
            //Conexion a la nueva local
            Connection con = daoRuteo.conexionConFarmacia(farmaciaLocal);
            logger.info("Conexion realizada a Farmacia local: " + farmaciaLocal.getUrl());
            if (farmaciaLocal != null) {
                //SP_SIMF_CANCELA(@pTipo, @pNodocto, @pMensaje)
                CallableStatement call = con.prepareCall(SQLConstants.SP_SIMF_CANCELA);
                call.registerOutParameter(1, java.sql.Types.INTEGER);
                call.registerOutParameter("@pMensaje", java.sql.Types.VARCHAR);
                call.setInt("@pTipo", tipo);
                call.setString("@pNodocto", entrada.getNumeroReceta());
                call.setString("@pMensaje", "");
                //Llama a ejecutar el StoreProcedure de cancela
                call.execute();
                logger.info("StoreProcedure 'SP_SIMF_CANCELA' ejecutado.");
                if(call.getString(1)!=null) {
                    salida.setEstatus(call.getString(1));
                    salida.setMensaje(call.getString("@pMensaje"));
                }else {
                    salida.setEstatus(Constantes.ERR_ACTUALIZARSP[0]);
                    salida.setMensaje(Constantes.ERR_ACTUALIZARSP[1]);
                }
                con.close();
            } else {
                salida.setEstatus(Constantes.ERR_NOINFRUTEO[0]);
                salida.setMensaje(Constantes.ERR_NOINFRUTEO[1]);
            }
        } catch (Exception e){
            e.printStackTrace();
            salida.setEstatus(Constantes.ERR_CNXDB[0]);
            salida.setMensaje(Constantes.ERR_CNXDB[1]);
        }
        return salida;
    }
}
