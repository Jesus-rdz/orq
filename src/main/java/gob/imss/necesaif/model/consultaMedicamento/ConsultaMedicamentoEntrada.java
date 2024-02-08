package gob.imss.necesaif.model.consultaMedicamento;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "consulta-medicamento-entrada")
public class ConsultaMedicamentoEntrada {
	@JacksonXmlProperty(localName = "clasificacion-presupuestal-farmacia")
	private String clasificacionPresupuestalFarmacia;
	@JacksonXmlProperty(localName = "clasificacion-presupuestal-solicitante")
	private String clasificacionPresupuestalSolicitante;
	@JacksonXmlProperty(localName = "descripcion-articulo")
	private String descripcionArticulo;
	@JacksonXmlProperty(localName = "nivel-atencion")
	private Integer nivelAtencion;

	public String getClasificacionPresupuestalFarmacia() {
		return clasificacionPresupuestalFarmacia;
	}

	public void setClasificacionPresupuestalFarmacia(String clasificacionPresupuestalFarmacia) {
		this.clasificacionPresupuestalFarmacia = clasificacionPresupuestalFarmacia;
	}

	public String getClasificacionPresupuestalSolicitante() {
		return clasificacionPresupuestalSolicitante;
	}

	public void setClasificacionPresupuestalSolicitante(
			String clasificacionPresupuestalSolicitante) {
		this.clasificacionPresupuestalSolicitante = clasificacionPresupuestalSolicitante;
	}

	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}

	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}

	public Integer getNivelAtencion() {
		return nivelAtencion;
	}

	public void setNivelAtencion(Integer nivelAtencion) {
		this.nivelAtencion = nivelAtencion;
	}

	public ConsultaMedicamentoEntrada(String clasificacionPresupuestalFarmacia,
                                      String clasificacionPresupuestalSolicitante,
                                      String descripcionArticulo, Integer nivelAtencion) {
		super();
		this.clasificacionPresupuestalFarmacia = clasificacionPresupuestalFarmacia;
		this.clasificacionPresupuestalSolicitante = clasificacionPresupuestalSolicitante;
		this.descripcionArticulo = descripcionArticulo;
		this.nivelAtencion = nivelAtencion;
	}

}
