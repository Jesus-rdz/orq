package gob.imss.necesaif.model.cancelaMedicamento;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

@JsonPropertyOrder({"estatusTratamiento", "numeroTratamiento", "receta"})
public class Tratamiento {
    @JacksonXmlProperty(localName = "estatus-tratamiento")
    private String estatusTratamiento;
    @JacksonXmlProperty(localName = "numero-tratamiento")
    private String numeroTratamiento;
    @JacksonXmlElementWrapper(localName = "tratamiento", useWrapping = false)
    private List<Receta> receta;

    public String getNumeroTratamiento() {
        return numeroTratamiento;
    }

    public void setNumeroTratamiento(String numeroTratamiento) {
        this.numeroTratamiento = numeroTratamiento;
    }

    public String getEstatusTratamiento() {
        return estatusTratamiento;
    }

    public void setEstatusTratamiento(String estatusTratamiento) {
        this.estatusTratamiento = estatusTratamiento;
    }

    public List<Receta> getReceta() {
        return receta;
    }

    public void setReceta(List<Receta> receta) {
        this.receta = receta;
    }
}
