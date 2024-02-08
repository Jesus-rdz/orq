package gob.imss.necesaif.model.altaTratamiento;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

@JsonPropertyOrder({"cantidad", "diferenciador", "especifico", "generico", "grupo", "id", "tipoDespacho", "variante"})
public class DetalleEntrada {
    @JacksonXmlProperty
    private String cantidad;
    @JacksonXmlProperty
    private String diferenciador;
    @JacksonXmlProperty
    private String especifico;
    @JacksonXmlProperty
    private String generico;
    @JacksonXmlProperty
    private String grupo;
    @JacksonXmlProperty
    private String id;
    @JacksonXmlProperty(localName = "tipo-despacho")
    private String tipoDespacho;
    @JacksonXmlProperty
    private String variante;

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getDiferenciador() {
        return diferenciador;
    }

    public void setDiferenciador(String diferenciador) {
        this.diferenciador = diferenciador;
    }

    public String getEspecifico() {
        return especifico;
    }

    public void setEspecifico(String especifico) {
        this.especifico = especifico;
    }

    public String getGenerico() {
        return generico;
    }

    public void setGenerico(String generico) {
        this.generico = generico;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoDespacho() {
        return tipoDespacho;
    }

    public void setTipoDespacho(String tipoDespacho) {
        this.tipoDespacho = tipoDespacho;
    }

    public String getVariante() {
        return variante;
    }

    public void setVariante(String variante) {
        this.variante = variante;
    }
}
