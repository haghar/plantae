package edu.udistrital.plantae.logicadominio.ubicacion;

/**
 * @author Sosa G., Mateus A.
 * @version 1.0
 * @created 26-Jun-2013 11:33:38 PM
 */
public abstract class Region {

	private String nombre;
	private int regionID;

	public Region(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param nombre
	 */
	public Region(String nombre){

	}

	/**
	 * 
	 * @param region
	 */
	public void agregarRegion(Region region){

	}

	/**
	 * 
	 * @param region
	 */
	public Region getRegionHijo(int region){
		return null;
	}

	public String getnombre(){
		return nombre;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setnombre(String newVal){
		nombre = newVal;
	}

	public int getregionID(){
		return regionID;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setregionID(int newVal){
		regionID = newVal;
	}

}