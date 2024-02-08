package gob.imss.necesaif.model.cancelaMedicamento;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JsonPropertyOrder({"clasificacionPresupuestal", "tratamiento"})
@JacksonXmlRootElement(localName = "cancelacion-tratamiento-entrada")
public class CancelaTratamientoSalida {
    @JacksonXmlProperty(localName = "codigo")
    private String estatus;
    @JacksonXmlProperty(localName = "descripcion")
    private String mensaje;
    @JacksonXmlProperty(localName = "clasificacion-presupuestal")
    private String clasificacionPresupuestal;
    @JacksonXmlElementWrapper(localName = "tratamiento", useWrapping = false)
    private List<Tratamiento> tratamiento;

    public String getClasificacionPresupuestal() {
        return clasificacionPresupuestal;
    }

    public void setClasificacionPresupuestal(String clasificacionPresupuestal) {
        this.clasificacionPresupuestal = clasificacionPresupuestal;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Tratamiento> getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(List<Tratamiento> tratamiento) {
        this.tratamiento = tratamiento;
    }
}
