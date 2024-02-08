package gob.imss.necesaif.model.cancelaMedicamento;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Receta {
    @JacksonXmlProperty(localName = "estatus-receta")
    private String estatusReceta;
    @JacksonXmlProperty(localName = "mensaje-receta")
    private String mensajeReceta;
    @JacksonXmlProperty(localName = "numero-documento")
    private String numeroDocumento;

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getEstatusReceta() {
        return estatusReceta;
    }

    public void setEstatusReceta(String estatusReceta) {
        this.estatusReceta = estatusReceta;
    }

    public String getMensajeReceta() {
        return mensajeReceta;
    }

    public void setMensajeReceta(String mensajeReceta) {
        this.mensajeReceta = mensajeReceta;
    }
}
