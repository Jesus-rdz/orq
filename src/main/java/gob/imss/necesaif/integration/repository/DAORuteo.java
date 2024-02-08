package gob.imss.necesaif.integration.repository;

import gob.imss.necesaif.model.RuteoDto;

import java.sql.Connection;
import java.sql.SQLException;


public interface DAORuteo {
    RuteoDto obtenerDatosConexion(String clavePresupuestalOrigen, String clavePresupuestalFarmacia);
    Connection conexionConFarmacia(RuteoDto farmaciaLocal) throws SQLException;
}
