package gob.imss.necesaif.integration.repository;

import gob.imss.necesaif.model.RuteoDto;

public interface DAORuteo {
    RuteoDto obtenerDatosConexion(String clavePresupuestalOrigen, String clavePresupuestalFarmacia);
}
