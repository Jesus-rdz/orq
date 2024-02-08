package gob.imss.necesaif.model.altaTratamiento;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "alta-tratamiento-salida")
public class AltaTratamientoSalida {
    @JacksonXmlProperty(localName = "codigo")
    private String estatus;
    @JacksonXmlProperty(localName = "descripcion")
    private String mensaje;
    @JacksonXmlProperty(localName = "clasificacion-presupuestal")
    private String clasificacionPresupuestal;
    @JacksonXmlProperty
    private List<Tratamiento> tratamiento;

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
    public String getClasificacionPresupuestal() {
        return clasificacionPresupuestal;
    }

    public void setClasificacionPresupuestal(String clasificacionPresupuestal) {
        this.clasificacionPresupuestal = clasificacionPresupuestal;
    }

    public List<Tratamiento> getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(List<Tratamiento> tratamiento) {
        this.tratamiento = tratamiento;
    }

    public class Tratamiento {
        @JacksonXmlProperty(localName = "numero-documento")
        private String numeroDocumento;

        public String getNumeroDocumento() {
            return numeroDocumento;
        }

        public void setNumeroDocumento(String numeroDocumento) {
            this.numeroDocumento = numeroDocumento;
        }
    }
}
