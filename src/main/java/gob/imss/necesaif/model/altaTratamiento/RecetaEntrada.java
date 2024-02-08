package gob.imss.necesaif.model.altaTratamiento;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.xml.datatype.XMLGregorianCalendar;
import java.util.List;

@JsonPropertyOrder({"detalle", "numeroDocumento", "tipoReceta", "fechaFinVigencia", "fechaInicioVigencia"})
public class RecetaEntrada {
    @JacksonXmlProperty
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<DetalleEntrada> detalle;
    @JacksonXmlProperty(localName = "numero-documento")
    private String numeroDocumento;
    @JacksonXmlProperty(localName = "tipo-receta")
    private int tipoReceta;
    @JacksonXmlProperty(localName = "fecha-fin-vigencia")
    private XMLGregorianCalendar fechaFinVigencia;
    @JacksonXmlProperty(localName = "fecha-inicio-vigencia")
    private XMLGregorianCalendar fechaInicioVigencia;

    public List<DetalleEntrada> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetalleEntrada> detalle) {
        this.detalle = detalle;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public int getTipoReceta() {
        return tipoReceta;
    }

    public void setTipoReceta(int tipoReceta) {
        this.tipoReceta = tipoReceta;
    }

    public XMLGregorianCalendar getFechaFinVigencia() {
        return fechaFinVigencia;
    }

    public void setFechaFinVigencia(XMLGregorianCalendar fechaFinVigencia) {
        this.fechaFinVigencia = fechaFinVigencia;
    }

    public XMLGregorianCalendar getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    public void setFechaInicioVigencia(XMLGregorianCalendar fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }
}
