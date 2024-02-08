package gob.imss.necesaif.model.preComprometido;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({
        "clasificacionPresupuestalFarmacia",
        "clasificacionPresupuestalSolicitante",
        "idComp",
        "grupo",
        "generico",
        "especifico",
        "diferenciador",
        "variante",
        "cantidad",
        "tipoDespacho",
        "accion"
})
@JacksonXmlRootElement(localName = "pre-comprometido-entrada")
public class PreComprometidoEntrada {
    @JacksonXmlProperty(localName = "clasificacion-presupuestal-farmacia")
    private String clasificacionPresupuestalFarmacia;
    @JacksonXmlProperty(localName = "clasificacion-presupuestal-solicitante")
    private String clasificacionPresupuestalSolicitante;
    @JacksonXmlProperty
    private String idComp;
    @JacksonXmlProperty
    private String grupo;
    @JacksonXmlProperty
    private String generico;
    @JacksonXmlProperty
    private String especifico;
    @JacksonXmlProperty
    private String diferenciador;
    @JacksonXmlProperty
    private String variante;
    @JacksonXmlProperty
    private int cantidad;
    @JacksonXmlProperty(localName = "tipo-despacho")
    private String tipoDespacho;
    @JacksonXmlProperty
    private int accion;

    public String getClasificacionPresupuestalFarmacia() {
        return clasificacionPresupuestalFarmacia;
    }

    public void setClasificacionPresupuestalFarmacia(String clasificacionPresupuestalFarmacia) {
        this.clasificacionPresupuestalFarmacia = clasificacionPresupuestalFarmacia;
    }

    public String getClasificacionPresupuestalSolicitante() {
        return clasificacionPresupuestalSolicitante;
    }

    public void setClasificacionPresupuestalSolicitante(String clasificacionPresupuestalSolicitante) {
        this.clasificacionPresupuestalSolicitante = clasificacionPresupuestalSolicitante;
    }

    public String getIdComp() {
        return idComp;
    }

    public void setIdComp(String idComp) {
        this.idComp = idComp;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getGenerico() {
        return generico;
    }

    public void setGenerico(String generico) {
        this.generico = generico;
    }

    public String getEspecifico() {
        return especifico;
    }

    public void setEspecifico(String especifico) {
        this.especifico = especifico;
    }

    public String getDiferenciador() {
        return diferenciador;
    }

    public void setDiferenciador(String diferenciador) {
        this.diferenciador = diferenciador;
    }

    public String getVariante() {
        return variante;
    }

    public void setVariante(String variante) {
        this.variante = variante;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipoDespacho() {
        return tipoDespacho;
    }

    public void setTipoDespacho(String tipoDespacho) {
        this.tipoDespacho = tipoDespacho;
    }

    public int getAccion() {
        return accion;
    }

    public void setAccion(int accion) {
        this.accion = accion;
    }
}
