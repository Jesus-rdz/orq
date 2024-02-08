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
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
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
        try {
            ruteo = jdbcTemplate.queryForObject(
                    SQLConstants.QS_RUTEO_FARMACIA, new Object[]{clavePresupuestalOrigen, clavePresupuestalFarmacia},
                    (res, rowNum) -> {
                        RuteoDto ruteoDto = new RuteoDto();
                        ruteoDto.setId(res.getInt("ID"));
                        ruteoDto.setVersion(res.getInt("VERSION"));
                        ruteoDto.setUsername(res.getString("USERNAME"));
                        ruteoDto.setClavePresupuestalOrigen(res.getString("CLAVE_PRESUPUESTAL_ORIGEN"));
                        ruteoDto.setDriverClass(res.getString("DRIVER_CLASS"));
                        ruteoDto.setClavePresupuestalFarmacia(res.getString("CLAVE_PRESUPUESTAL_FARMACIA"));
                        ruteoDto.setPassword(res.getString("PASSWORD"));
                        ruteoDto.setUrl(res.getString("URL"));
                        return ruteoDto;
                    });
        } catch (IncorrectResultSizeDataAccessException exp) {
            logger.debug("Conexión no encontrada. " + exp.getMessage());
        }
        logger.info(ruteo.getUrl());
        return ruteo;
    }

    @Override
    public Connection conexionConFarmacia(RuteoDto farmaciaLocal) throws SQLException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(farmaciaLocal.getDriverClass());
        dataSource.setUrl(farmaciaLocal.getUrl());
        dataSource.setUsername(farmaciaLocal.getUsername());
        dataSource.setPassword(farmaciaLocal.getPassword());
        return dataSource.getConnection();
    }
}
