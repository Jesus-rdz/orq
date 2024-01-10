package gob.imss.necesaif.service;

import gob.imss.necesaif.model.RuteoDto;
import gob.imss.necesaif.model.xmlConsultaMedicamento;
import gob.imss.necesaif.model.xmlResultadoMedicamento;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public interface appService {
    xmlResultadoMedicamento consultaMedicamento(xmlConsultaMedicamento xmlConsultaMedicamento) throws SQLException;
    RuteoDto  obtenerDatosConexion(String clavePresupuestalOrigen, String clavePresupuestalFarmacia);
}
