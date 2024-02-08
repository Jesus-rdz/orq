package gob.imss.necesaif.model.preComprometido;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({
        "estatus",
        "mensaje"
})
@JacksonXmlRootElement(localName = "pre-comprometido-salida")
public class PreComprometidoSalida {
    @JacksonXmlProperty
    private String estatus;
    @JacksonXmlProperty
    private String mensaje;

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
}
