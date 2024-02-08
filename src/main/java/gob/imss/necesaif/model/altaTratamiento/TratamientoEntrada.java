package gob.imss.necesaif.model.altaTratamiento;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;
@JsonPropertyOrder({"agregado", "curp", "diagnostico", "matricula", "noTratamiento", "nombreMedico", "nss", "receta"})
public class TratamientoEntrada {
    @JacksonXmlProperty
    private String agregado;

    @JacksonXmlProperty
    private String curp;

    @JacksonXmlProperty
    private String diagnostico;

    @JacksonXmlProperty
    private String matricula;

    @JacksonXmlProperty(localName = "no-tratamiento")
    private String noTratamiento;

    @JacksonXmlProperty(localName = "nombre-medico")
    private String nombreMedico;

    @JacksonXmlProperty
    private String nss;

    @JacksonXmlProperty
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<RecetaEntrada> receta;

    public String getAgregado() {
        return agregado;
    }

    public void setAgregado(String agregado) {
        this.agregado = agregado;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNoTratamiento() {
        return noTratamiento;
    }

    public void setNoTratamiento(String noTratamiento) {
        this.noTratamiento = noTratamiento;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public List<RecetaEntrada> getReceta() {
        return receta;
    }

    public void setReceta(List<RecetaEntrada> receta) {
        this.receta = receta;
    }
}
