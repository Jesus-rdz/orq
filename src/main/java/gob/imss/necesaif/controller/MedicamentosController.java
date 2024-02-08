package gob.imss.necesaif.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import gob.imss.necesaif.model.altaTratamiento.AltaTratamientoEntrada;
import gob.imss.necesaif.model.altaTratamiento.AltaTratamientoSalida;
import gob.imss.necesaif.model.cancelaMedicamento.CancelaTratamientoEntrada;
import gob.imss.necesaif.model.cancelaMedicamento.CancelaTratamientoSalida;
import gob.imss.necesaif.model.consultaMedicamento.ConsultaMedicamentoEntrada;
import gob.imss.necesaif.model.consultaMedicamento.ConsultaMedicamentoSalida;
import gob.imss.necesaif.service.appService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value="/xmlPrueba", consumes=MediaType.APPLICATION_XML_VALUE, produces=MediaType.APPLICATION_XML_VALUE)
    public ConsultaMedicamentoSalida medicamentosXmlPrueba(@RequestBody ConsultaMedicamentoEntrada entrada) throws JsonProcessingException {
        final XmlMapper xmlMapper = new XmlMapper();
        final String xml = xmlMapper.writeValueAsString(entrada);
        logger.info("input: " + xml);
        return servicio.consultaMedicamento(entrada);
    }

    @PostMapping(value = "/consultaMedicamento", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ConsultaMedicamentoSalida medicamentos(@RequestBody ConsultaMedicamentoEntrada entrada) {
        return servicio.consultaMedicamento(entrada);
    }

    @PostMapping(value = "/altaTratamiento", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public AltaTratamientoSalida altaTratamiento(@RequestBody AltaTratamientoEntrada entrada) {
        return servicio.altaTratamiento(entrada);
    }

    @PostMapping(value = "/xmlAltaTratamiento", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public AltaTratamientoSalida xmlAltaTratamiento(@RequestBody AltaTratamientoEntrada entrada) throws JsonProcessingException {
        final XmlMapper xmlMapper = new XmlMapper();
        final String xml = xmlMapper.writeValueAsString(entrada);
        logger.info("input: " + xml);
        return servicio.altaTratamiento(entrada);
    }

    @PostMapping(value = "/cancelaTratamiento", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public CancelaTratamientoSalida cancelaTratamiento(@RequestBody CancelaTratamientoEntrada entrada) {
        return servicio.cancelaTratamiento(entrada);
    }

    @PostMapping(value = "/xmlCancelaTratamiento", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public CancelaTratamientoSalida xmlCancelaTratamiento(@RequestBody CancelaTratamientoEntrada entrada) throws JsonProcessingException {
        final XmlMapper xmlMapper = new XmlMapper();
        final String xml = xmlMapper.writeValueAsString(entrada);
        logger.info("input: " + xml);
        return servicio.cancelaTratamiento(entrada);
    }
}
