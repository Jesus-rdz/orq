package gob.imss.necesaif.model.consultaMedicamento;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "consulta-medicamento-salida")
public class ConsultaMedicamentoSalida {
	@JacksonXmlProperty(localName = "codigo")
    private String estatus;
	@JacksonXmlProperty(localName = "descripcion")
    private String mensaje;
    @JacksonXmlProperty(localName = "clave-presupuestal")
    private String clavePresupuestal;
	@JacksonXmlProperty(localName = "detalle-articulo")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<DetalleArticulo> detalleArticulo;

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

    public String getClavePresupuestal() {
        return clavePresupuestal;
    }

    public void setClavePresupuestal(String clavePresupuestal) {
        this.clavePresupuestal = clavePresupuestal;
    }

    public List<DetalleArticulo> getDetalleArticulo() {
        return detalleArticulo;
    }

    public void setDetalleArticulo(List<DetalleArticulo> detalleArticulo) {
        this.detalleArticulo = detalleArticulo;
    }
}