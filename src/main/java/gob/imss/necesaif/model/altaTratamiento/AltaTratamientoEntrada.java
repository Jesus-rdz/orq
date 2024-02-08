package gob.imss.necesaif.model.altaTratamiento;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "alta-tratamiento-entrada")
@JsonPropertyOrder({"clasificacionPresupuestalFarmacia", "clasificacionPresupuestalSolicitante", "idComp", "tratamiento"})
public class AltaTratamientoEntrada {
    @JacksonXmlProperty(localName = "clasificacion-presupuestal-farmacia")
    private String clasificacionPresupuestalFarmacia;
    @JacksonXmlProperty(localName = "clasificacion-presupuestal-solicitante")
    private String clasificacionPresupuestalSolicitante;
    @JacksonXmlProperty(localName = "id-comp")
    private String idComp;
    @JacksonXmlElementWrapper(localName = "tratamiento", useWrapping = false)
    private List<TratamientoEntrada> tratamiento;

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

    public List<TratamientoEntrada> getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(List<TratamientoEntrada> tratamiento) {
        this.tratamiento = tratamiento;
    }

}
