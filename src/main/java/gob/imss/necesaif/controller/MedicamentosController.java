package gob.imss.necesaif.controller;

import gob.imss.necesaif.model.xmlConsultaMedicamento;
import gob.imss.necesaif.model.xmlResultadoMedicamento;
import gob.imss.necesaif.service.appService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class MedicamentosController {

    @Autowired
    private appService servicio;

    private final static Logger logger = Logger.getLogger(MedicamentosController.class);

    @GetMapping()
    public String healthz () {
        logger.info("API Active");
        return "ok";
    }

    @PostMapping(value="/consultaMedicamento", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public xmlResultadoMedicamento medicamentos(@RequestBody xmlConsultaMedicamento ConsultaMedicamento) throws SQLException {
        return servicio.consultaMedicamento(ConsultaMedicamento);
    }

    @PostMapping(value = "xmlPrueba", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public xmlResultadoMedicamento medicamentosXmlPrueba(@RequestBody xmlConsultaMedicamento medicamento) throws SQLException {
        
        
        return servicio.consultaMedicamento(medicamento);
    }
    

}
