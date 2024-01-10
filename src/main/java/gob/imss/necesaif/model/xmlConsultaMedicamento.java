package gob.imss.necesaif.model;

public class xmlConsultaMedicamento {
	
	private String clasificacionPresupuestalFarmacia; 
	private String clasificacionPresupuestalSolicitante;
	private String descripcionArticulo;
	private Integer nivelAtencion;

	public String getClasificacionPresupuestalFarmacia() {
		return clasificacionPresupuestalFarmacia;
	}

	public void setClasificacionPresupuestalFarmacia(
			String clasificacionPresupuestalFarmacia) {
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

	public xmlConsultaMedicamento(String clasificacionPresupuestalFarmacia,
			String clasificacionPresupuestalSolicitante,
			String descripcionArticulo, Integer nivelAtencion) {
		super();
		this.clasificacionPresupuestalFarmacia = clasificacionPresupuestalFarmacia;
		this.clasificacionPresupuestalSolicitante = clasificacionPresupuestalSolicitante;
		this.descripcionArticulo = descripcionArticulo;
		this.nivelAtencion = nivelAtencion;
	}
}
