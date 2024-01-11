package gob.imss.necesaif.model;

public class xmlResultadoMedicamento {

	private String estatus;
	private String mensaje;
    private String clavePresupuestal;
	private Detalles_Art detalles_art;

	public String getClavePresupuestal() {
		return clavePresupuestal;
	}
	public void setClavePresupuestal(String clavePresupuestal) {
		this.clavePresupuestal = clavePresupuestal;
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