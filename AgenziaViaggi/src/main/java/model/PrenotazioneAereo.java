package model;

import java.sql.Date;

public class PrenotazioneAereo {
	private int id;
	private String nomeCliente;
	private String cfCliente;
	private String cognomeCliente;
	private String compagniaAerea;
	private int nAdulti;
	private int nBambini;
	private Date dataPartenza;
	private Date dataArrivo;
	private String da;
	private String a;
	private double importoPagato;
	private boolean bagagli;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getCfCliente() {
		return cfCliente;
	}
	public void setCfCliente(String cfCliente) {
		this.cfCliente = cfCliente;
	}
	public String getCognomeCliente() {
		return cognomeCliente;
	}
	public void setCognomeCliente(String cognomeCliente) {
		this.cognomeCliente = cognomeCliente;
	}
	public String getCompagniaAerea() {
		return compagniaAerea;
	}
	public void setCompagniaAerea(String compagniaAerea) {
		this.compagniaAerea = compagniaAerea;
	}
	public int getnAdulti() {
		return nAdulti;
	}
	public void setnAdulti(int nAdulti) {
		this.nAdulti = nAdulti;
	}
	public int getnBambini() {
		return nBambini;
	}
	public void setnBambini(int nBambini) {
		this.nBambini = nBambini;
	}
	public Date getDataPartenza() {
		return dataPartenza;
	}
	public void setDataPartenza(Date dataPartenza) {
		this.dataPartenza = dataPartenza;
	}
	public Date getDataArrivo() {
		return dataArrivo;
	}
	public void setDataArrivo(Date dataArrivo) {
		this.dataArrivo = dataArrivo;
	}
	public String getDa() {
		return da;
	}
	public void setDa(String da) {
		this.da = da;
	}

	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public double getImportoPagato() {
		return importoPagato;
	}
	public void setImportoPagato(double importoPagato) {
		this.importoPagato = importoPagato;
	}
	public boolean isBagagli() {
		return bagagli;
	}
	public void setBagagli(boolean bagagli) {
		this.bagagli = bagagli;
	}
	
	public PrenotazioneAereo() {}

	public PrenotazioneAereo(int id, String nomeCliente, String cfCliente, String cognomeCliente, String compagniaAerea,
			int nAdulti, int nBambini, Date dataPartenza, Date dataArrivo, String da, String a, double importoPagato,
			boolean bagagli) {
		super();
		this.id = id;
		this.nomeCliente = nomeCliente;
		this.cfCliente = cfCliente;
		this.cognomeCliente = cognomeCliente;
		this.compagniaAerea = compagniaAerea;
		this.nAdulti = nAdulti;
		this.nBambini = nBambini;
		this.dataPartenza = dataPartenza;
		this.dataArrivo = dataArrivo;
		this.da = da;
		this.a = a;
		this.importoPagato = importoPagato;
		this.bagagli = bagagli;
	}

}
