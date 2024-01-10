package gob.imss.necesaif.integration.repository.impl;

import gob.imss.necesaif.integration.constants.SQLConstants;
import gob.imss.necesaif.integration.repository.DAORuteo;
import gob.imss.necesaif.model.RuteoDto;
import gob.imss.necesaif.service.appServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class DAORuteoImpl implements DAORuteo {
    private final static Logger logger = Logger.getLogger(appServiceImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public DAORuteoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public RuteoDto obtenerDatosConexion(String clavePresupuestalOrigen, String clavePresupuestalFarmacia) {
        RuteoDto ruteo = null;
        try{
            ruteo = (RuteoDto) jdbcTemplate.queryForObject(
                    SQLConstants.QS_RUTEO_FARMACIA, new Object[]{clavePresupuestalOrigen, clavePresupuestalFarmacia},
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
        logger.info(ruteo.getUrl());
        return ruteo;
    }
}
