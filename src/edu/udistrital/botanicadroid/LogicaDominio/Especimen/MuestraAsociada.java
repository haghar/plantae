package edu.udistrital.botanicadroid.LogicaDominio.Especimen;

/**
 * @author Sosa G., Mateus A.
 * @version 1.0
 * @created 10-may-2013 03:41:57 p.m.
 */
public class MuestraAsociada {

	private String descripcion;
	private String metodoDeTratamiento;
	private Especimen especimen;
	public Especimen m_Especimen;



	public void finalize() throws Throwable {

	}

	public MuestraAsociada(){

	}

	public String getmetodoDeTratamiento(){
		return metodoDeTratamiento;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setmetodoDeTratamiento(String newVal){
		metodoDeTratamiento = newVal;
	}

	public String getdescripcion(){
		return descripcion;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setdescripcion(String newVal){
		descripcion = newVal;
	}

}