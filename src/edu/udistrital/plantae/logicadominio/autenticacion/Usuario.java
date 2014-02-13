package edu.udistrital.plantae.logicadominio.autenticacion;
import java.util.HashMap;

import android.text.TextUtils;

/**
 * @author Sosa G., Mateus A.
 * @version 1.0
 * @created 19-May-2013 11:50:35 PM
 */
public class Usuario {

	private String nombreUsuario;
	private String contraseña;
	private HashMap<String, String> erroresCredenciales;
	private Sesion sesion;
	private int usuarioID;
	private static Usuario usuario;

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param nombreUsuario
	 * @param contraseña
	 */
	private Usuario(String nombreUsuario, String contraseña){
		this.nombreUsuario=nombreUsuario;
		this.contraseña=contraseña;
	}

	/**
	 * 
	 * @param datosRegistro    datosRegistro
	 * @param databaseHelper 
	 */
	public static HashMap<String, String> validarDatosRegistro(HashMap<String,String> datosRegistro){
		// TODO validar datos de un nuevo usuario
		String email = datosRegistro.get("email");
		String password = datosRegistro.get("password");
		String institution = datosRegistro.get("institution");
		String fullName = datosRegistro.get("fullname");
		HashMap<String, String> errores = new HashMap<String, String>();
		
		/* Verificar la disponibilidad del nombre de usuario / email */
		
		if (password.length()<6){
			errores.put("password", "short");
		} else if (password.matches("^[a-zA-Z0-9 ]*$")){
			errores.put("password", "simple");
		}
		if (!fullName.matches("[a-zA-Z ]+")){
			errores.put("fullname", "chars");
		}
		/*if (!fieldNumber.matches("[a-zA-Z]*[0-9]+")){
			errores.put("fieldnumber", "chars");
		}*/
		if (!institution.matches("^[a-zA-Z0-9 ]*$")){
			errores.put("institution", "chars");
		}
		return errores;
	}

	/**
	 * 
	 * @param contraseña
	 * @param usuario
	 */
	public Sesion validarDatosInicioSesion(){
		// Variable initialization
		boolean cancel = false;
		erroresCredenciales = new HashMap<String, String>();
		if (TextUtils.isEmpty(contraseña)) {
			// Add to the HashMap the error code.
			erroresCredenciales.put("mPassword", "La contraseña esta vacia");
			// Put the cancel flag to true.
			cancel = true;
		} else if (contraseña.length() < 4) {
			// Add to the HashMap the error code.
			erroresCredenciales.put("mPassword", "La contraseña es muy corta");
			cancel = true;
		}

		// Check for a valid email address.
		if (TextUtils.isEmpty(nombreUsuario)) {
			// Add to the HashMap the error code.
			erroresCredenciales.put("mEmail", "El usuario esta vacio");
			cancel = true;
		} else if (!nombreUsuario.contains("@")) {
			// Add to the HashMap the error code.
			erroresCredenciales.put("mEmail", "El usuario debe contener @");
			cancel = true;
		}

		if (cancel) {
			// There was an error; don't attempt login, return null
			return null;
		} else {
			// TODO Check username and password in database
			
			sesion = Sesion.iniciarSesion(this);
			return sesion;
		}
	}

	public HashMap<String, String> geterroresCredenciales(){
		return erroresCredenciales;
	}

	public String getcontraseña(){
		return contraseña;
	}

	public String getnombreUsuario(){
		return nombreUsuario;
	}

	/**
	 * 
	 * @param contraseña
	 * @param nombreUsuario
	 */
	public static Usuario getUsuario(String nombreUsuario, String contraseña){
		if (usuario == null){
			usuario = new Usuario(nombreUsuario, contraseña);
		}
		return usuario;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setnombreUsuario(String newVal){
		nombreUsuario = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setcontraseña(String newVal){
		contraseña = newVal;
	}
	
	public int getUsuarioID() {
		return usuarioID;
	}


}
