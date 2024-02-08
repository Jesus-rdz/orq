package gob.imss.necesaif.model.cancelaMedicamento;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonPropertyOrder({"clasificacionPresupuestal", "clasificacionPresupuestalFarmacia", "numeroReceta", "tratamiento"})
@JacksonXmlRootElement(localName = "cancelacion-tratamiento-entrada")
public class CancelaTratamientoEntrada {
    @JacksonXmlProperty(localName = "clasificacion-presupuestal")
    private String clasificacionPresupuestal;
    @JacksonXmlProperty(localName = "clasificacion-presupuestal-farmacia")
    private String clasificacionPresupuestalFarmacia;
    @JacksonXmlProperty(localName = "numero-receta")
    private String numeroReceta;
    @JacksonXmlProperty(localName = "tratamiento")
    private String tratamiento;

    public String getClasificacionPresupuestal() {
        return clasificacionPresupuestal;
    }

    public void setClasificacionPresupuestal(String clasificacionPresupuestal) {
        this.clasificacionPresupuestal = clasificacionPresupuestal;
    }

    public String getClasificacionPresupuestalFarmacia() {
        return clasificacionPresupuestalFarmacia;
    }

    public void setClasificacionPresupuestalFarmacia(String clasificacionPresupuestalFarmacia) {
        this.clasificacionPresupuestalFarmacia = clasificacionPresupuestalFarmacia;
    }

    public String getNumeroReceta() {
        return numeroReceta;
    }

    public void setNumeroReceta(String numeroReceta) {
        this.numeroReceta = numeroReceta;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

}
