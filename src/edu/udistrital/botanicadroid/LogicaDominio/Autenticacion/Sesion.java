package edu.udistrital.botanicadroid.LogicaDominio.Autenticacion;
import edu.udistrital.botanicadroid.LogicaDominio.LoginFilter.UsernameFilterGeneric;

/**
 * @author Sosa G., Mateus A.
 * @version 1.0
 * @created 10-may-2013 03:41:58 p.m.
 */
public class Sesion {

	private Sesion sesion;
	private Usuario usuario;
	public Usuario m_Usuario;
	public Sesion m_Sesion;



	public void finalize() throws Throwable {

	}

	/**
	 * 
	 */
	private Sesion(){

	}

	/**
	 * 
	 * @param contraseņa
	 * @param nombreUsuario
	 */
	public static Sesion iniciarSesion(String contraseņa, String nombreUsuario){
		return null;
	}

	public boolean cerrarSesion(){
		return false;
	}

	/**
	 * 
	 * @param contraseņa
	 * @param nombreUsuario
	 */
	private static Usuario validarDatosInicioSesion(String contraseņa, String nombreUsuario){
		return null;
	}

}