package gob.imss.necesaif.model;

public class xmlResultadoMedicamento {

    private String clasificacionPresupuestal;
	private String estatus;
	private String mensaje;
	private Detalles_Art detalles_art;

	public String getClasificacionPresupuestal() {
		return clasificacionPresupuestal;
	}
	public void setClasificacionPresupuestal(String clasificacionPresupuestal) {
		this.clasificacionPresupuestal = clasificacionPresupuestal;
	}
	public Detalles_Art getDetalles_art() {
		return detalles_art;
	}
	public void setDetalles_art(Detalles_Art detalles_art) {
		this.detalles_art = detalles_art;
    }
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

}