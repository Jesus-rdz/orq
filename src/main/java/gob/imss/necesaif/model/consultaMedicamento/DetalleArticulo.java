package gob.imss.necesaif.model.consultaMedicamento;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

public class DetalleArticulo {
	@JacksonXmlProperty
	private String basico;
	@JacksonXmlProperty(localName = "cantidad-presentacion")
	private float cantidadPresentacion;
	@JacksonXmlProperty
	private int concentracion; //int
	@JacksonXmlProperty(localName = "descripcion-articulo")
	private String descripcionArticulo;
	@JacksonXmlProperty
	private String diferenciador;
	@JacksonXmlProperty
	private String especifico;
	@JacksonXmlProperty
	private String forma;
	@JacksonXmlProperty
	private String generico;
	@JacksonXmlProperty
	private String grupo;
	@JacksonXmlProperty(localName = "medicamento-generico")
	private int medicamentoGenerico; //int
	@JacksonXmlProperty(localName = "nivel-inventario")
	private int inventarioDisponible; //int
	@JacksonXmlProperty(localName = "prescripcion-razonada")
	private int prescripcionRazonada; //int
	@JacksonXmlProperty(localName = "tipo-presentacion")
	private String tipoPresentacion;
	@JacksonXmlProperty(localName = "unidad-medida")
	private String unidadMedida;
	@JacksonXmlProperty
	private String variante;
	@JacksonXmlProperty(localName = "nivel-servicio")
	private int nivelServicio; //int

	public String getBasico() {
		return basico;
	}

	public void setBasico(String basico) {
		this.basico = basico;
	}

	public float getCantidadPresentacion() {
		return cantidadPresentacion;
	}

	public void setCantidadPresentacion(float cantidadPresentacion) {
		this.cantidadPresentacion = cantidadPresentacion;
	}

	public int getConcentracion() {
		return concentracion;
	}

	public void setConcentracion(int concentracion) {
		this.concentracion = concentracion;
	}

	public String getDescripcionArticulo() {
		return descripcionArticulo;
	}

	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}

	public String getDiferenciador() {
		return diferenciador;
	}

	public void setDiferenciador(String diferenciador) {
		this.diferenciador = diferenciador;
	}

	public String getEspecifico() {
		return especifico;
	}

	public void setEspecifico(String especifico) {
		this.especifico = especifico;
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}

	public String getGenerico() {
		return generico;
	}

	public void setGenerico(String generico) {
		this.generico = generico;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public int getMedicamentoGenerico() {
		return medicamentoGenerico;
	}

	public void setMedicamentoGenerico(int medicamentoGenerico) {
		this.medicamentoGenerico = medicamentoGenerico;
	}

	public int getInventarioDisponible() {
		return inventarioDisponible;
	}

	public void setInventarioDisponible(int inventarioDisponible) {
		this.inventarioDisponible = inventarioDisponible;
	}

	public int getPrescripcionRazonada() {
		return prescripcionRazonada;
	}

	public void setPrescripcionRazonada(int prescripcionRazonada) {
		this.prescripcionRazonada = prescripcionRazonada;
	}

	public String getTipoPresentacion() {
		return tipoPresentacion;
	}

	public void setTipoPresentacion(String tipoPresentacion) {
		this.tipoPresentacion = tipoPresentacion;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public String getVariante() {
		return variante;
	}

	public void setVariante(String variante) {
		this.variante = variante;
	}

	public int getNivelServicio() {
		return nivelServicio;
	}

	public void setNivelServicio(int nivelServicio) {
		this.nivelServicio = nivelServicio;
	}

}