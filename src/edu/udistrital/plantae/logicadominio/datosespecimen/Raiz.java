package edu.udistrital.plantae.logicadominio.datosespecimen;

/**
 * @author Sosa G., Mateus A.
 * @version 1.0
 * @created 26-Jun-2013 12:09:15 AM
 */
public class Raiz {

	private long alturaDelCono;
	private String diametroDeLasRaices;
	private String diametroEnLaBase;
	private String formaDeLasEspinas;
	private boolean raizArmada;
	private String tamañoDeLasEspinas;
	private String descripcion;
	private int raizID;



	public void finalize() throws Throwable {

	}

	public Raiz(){

	}

	public long getalturaDelCono(){
		return alturaDelCono;
	}

	public String getdescripcion(){
		return descripcion;
	}

	public String getdiametroDeLasRaices(){
		return diametroDeLasRaices;
	}

	public String getdiametroEnLaBase(){
		return diametroEnLaBase;
	}

	public String getformaDeLasEspinas(){
		return formaDeLasEspinas;
	}

	public String gettamañoDeLasEspinas(){
		return tamañoDeLasEspinas;
	}

	public boolean israizArmada(){
		return raizArmada;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setalturaDelCono(long newVal){
		alturaDelCono = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setdescripcion(String newVal){
		descripcion = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setdiametroDeLasRaices(String newVal){
		diametroDeLasRaices = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setdiametroEnLaBase(String newVal){
		diametroEnLaBase = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setformaDeLasEspinas(String newVal){
		formaDeLasEspinas = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setraizArmada(boolean newVal){
		raizArmada = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void settamañoDeLasEspinas(String newVal){
		tamañoDeLasEspinas = newVal;
	}

	public int getraizID(){
		return raizID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setraizID(int newVal){
		raizID = newVal;
	}

}