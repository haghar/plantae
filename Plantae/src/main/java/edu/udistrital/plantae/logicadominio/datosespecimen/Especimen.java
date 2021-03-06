package edu.udistrital.plantae.logicadominio.datosespecimen;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import de.greenrobot.dao.DaoException;
import edu.udistrital.plantae.logicadominio.recoleccion.ColectorPrincipal;
import edu.udistrital.plantae.logicadominio.recoleccion.ColectorSecundario;
import edu.udistrital.plantae.logicadominio.recoleccion.Viaje;
import edu.udistrital.plantae.logicadominio.recoleccion.ViajeColectorSecundario;
import edu.udistrital.plantae.logicadominio.taxonomia.IdentidadTaxonomica;
import edu.udistrital.plantae.logicadominio.ubicacion.Localidad;
import edu.udistrital.plantae.persistencia.ColectorPrincipalDao;
import edu.udistrital.plantae.persistencia.ColorEspecimenDao;
import edu.udistrital.plantae.persistencia.DaoSession;
import edu.udistrital.plantae.persistencia.EspecimenColectorSecundarioDao;
import edu.udistrital.plantae.persistencia.EspecimenDao;
import edu.udistrital.plantae.persistencia.FenologiaDao;
import edu.udistrital.plantae.persistencia.FlorDao;
import edu.udistrital.plantae.persistencia.FotografiaDao;
import edu.udistrital.plantae.persistencia.FrutoDao;
import edu.udistrital.plantae.persistencia.HabitatDao;
import edu.udistrital.plantae.persistencia.HabitoDao;
import edu.udistrital.plantae.persistencia.HojaDao;
import edu.udistrital.plantae.persistencia.IdentidadTaxonomicaDao;
import edu.udistrital.plantae.persistencia.InflorescenciaDao;
import edu.udistrital.plantae.persistencia.LocalidadDao;
import edu.udistrital.plantae.persistencia.MuestraAsociadaDao;
import edu.udistrital.plantae.persistencia.RaizDao;
import edu.udistrital.plantae.persistencia.TalloDao;
import edu.udistrital.plantae.persistencia.ViajeDao;

/**
 * @author Sosa G., Mateus A.
 * @version 1.0
 * @created 26-Jun-2013 12:09:14 AM
 */
public class Especimen implements Cloneable {

    private Long id;
    private String numeroDeColeccion;
    private String abundancia;
    private String descripcionEspecimen;
    private Long alturaDeLaPlanta;
    private Long dap;
    private Date fechaInicial;
    private Date fechaFinal;
    private String metodoColeccion;
    private String estacionDelAño;
    private Long habitoID;
    private Long habitatID;
    private Long fenologiaID;
    private Long localidadID;
    private long viajeID;
    private long colectorPrincipalID;
    private Long raizID;
    private Long talloID;
    private Long inflorescenciaID;
    private Long frutoID;
    private Long florID;
    private Long hojaID;
    private String tipo;

    /** Used to resolve relations */
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    private transient EspecimenDao myDao;

    private Etiqueta etiqueta;
    private Habito habito;
    private Long habito__resolvedKey;

    private Habitat habitat;
    private Long habitat__resolvedKey;

    private Fenologia fenologia;
    private Long fenologia__resolvedKey;

    private Localidad localidad;
    private Long localidad__resolvedKey;

    private Inflorescencia inflorescencia;
    private Long inflorescencia__resolvedKey;

    private ColectorPrincipal colectorPrincipal;
    private Long colectorPrincipal__resolvedKey;

    private Viaje viaje;
    private Long viaje__resolvedKey;

    private Hoja hoja;
    private Long hoja__resolvedKey;

    private Fruto fruto;
    private Long fruto__resolvedKey;

    private Tallo tallo;
    private Long tallo__resolvedKey;

    private Raiz raiz;
    private Long raiz__resolvedKey;

    private Flor flor;
    private Long flor__resolvedKey;

    private List<EspecimenColectorSecundario> colectoresSecundarios;
    private List<MuestraAsociada> muestrasAsociadas;
    private List<ColorEspecimen> colores;
    private List<Fotografia> fotografias;
    private List<IdentidadTaxonomica> determinaciones;

    /** called by internal mechanisms, do not call yourself. */
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getEspecimenDao() : null;
    }

	public Especimen(){
        //colectoresSecundarios = new ArrayList<>();
	}

	public void finalize() throws Throwable {
	}

	/**
	 * 
	 * @param numeroDeColector el número de colector del nuevo espécimen.
	 */
	protected Especimen(String numeroDeColector, long viajeID, long colectorPrincipalID){
        this.numeroDeColeccion = numeroDeColector;
        this.viajeID = viajeID;
        this.colectorPrincipalID = colectorPrincipalID;
        colectoresSecundarios = new ArrayList<>();
	}

    /**
     * Agrega todos los colectores secundarios del viaje al espécimen actual
     */
	public void agregarTodosColectores(){
        for (ViajeColectorSecundario viajeColectorSecundario:viaje.getColectoresSecundarios()) {
            EspecimenColectorSecundario especimenColectorSecundario = new EspecimenColectorSecundario();
            especimenColectorSecundario.setColectorSecundario(viajeColectorSecundario.getColectorSecundario());
            especimenColectorSecundario.setEspecimen(this);
            daoSession.getEspecimenColectorSecundarioDao().insert(especimenColectorSecundario);
            colectoresSecundarios.add(especimenColectorSecundario);
        }
	}

    public Object clone(){
        try {
            // clone shallow locality habitat and colectors
            Especimen clone = (Especimen) super.clone();
            clone.setId(null);
            clone.setNumeroDeColeccion(null);
            clone.setAbundancia(null);
            clone.setDescripcionEspecimen(null);
            clone.setAlturaDeLaPlanta(null);
            clone.setDap(null);
            clone.setMetodoColeccion(null);
            clone.setHabitoID(null);
            clone.setFenologiaID(null);
            clone.setRaizID(null);
            clone.setTalloID(null);
            clone.setInflorescenciaID(null);
            clone.setFrutoID(null);
            clone.setFlorID(null);
            clone.setHojaID(null);
            clone.setLocalidad(getLocalidad());
            clone.setHabitat(getHabitat());
            clone.setColectoresSecundarios(getColectoresSecundarios());
            return clone;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public Long getId() {
        return id;
    }

    /**
     *
     * @param id el identificador único de la base de datos del espécimen
     */
    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroDeColeccion() {
        return numeroDeColeccion;
    }

    public void setNumeroDeColeccion(String numeroDeColeccion) {
        this.numeroDeColeccion = numeroDeColeccion;
    }

    public String getAbundancia() {
        return abundancia;
    }

    public void setAbundancia(String abundancia) {
        this.abundancia = abundancia;
    }

    public String getDescripcionEspecimen() {
        return descripcionEspecimen;
    }

    public void setDescripcionEspecimen(String descripcionEspecimen) {
        this.descripcionEspecimen = descripcionEspecimen;
    }

    public Long getAlturaDeLaPlanta() {
        return alturaDeLaPlanta;
    }

    public void setAlturaDeLaPlanta(Long alturaDeLaPlanta) {
        this.alturaDeLaPlanta = alturaDeLaPlanta;
    }

    public Long getDap() {
        return dap;
    }

    public void setDap(Long dap) {
        this.dap = dap;
    }

    public Date getFechaInicial(){
        return fechaInicial;
    }

    /**
     *
     * @param fechaInicial la fecha inicial de la captura del espécimen
     */
    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal(){
        return fechaFinal;
    }

    /**
     *
     * @param fechaFinal la fecha final de la captura del espécimen
     */
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getMetodoColeccion() {
        return metodoColeccion;
    }

    /**
     *
     * @param metodoColeccion el método de coleccion del espécimen
     */
    public void setMetodoColeccion(String metodoColeccion) {
        this.metodoColeccion = metodoColeccion;
    }

    public String getEstacionDelAño() {
        return estacionDelAño;
    }

    /**
     *
     * @param estacionDelAño la estación del año en la que se capturó e espécimen
     */
    public void setEstacionDelAño(String estacionDelAño) {
        this.estacionDelAño = estacionDelAño;
    }

    public Long getHabitoID() {
        return habitoID;
    }

    public void setHabitoID(Long habitoID) {
        this.habitoID = habitoID;
    }

    public Long getHabitatID() {
        return habitatID;
    }

    public void setHabitatID(Long habitatID) {
        this.habitatID = habitatID;
    }

    public Long getFenologiaID() {
        return fenologiaID;
    }

    public void setFenologiaID(Long fenologiaID) {
        this.fenologiaID = fenologiaID;
    }

    public Long getLocalidadID() {
        return localidadID;
    }

    public void setLocalidadID(Long localidadID) {
        this.localidadID = localidadID;
    }

    public long getViajeID() {
        return viajeID;
    }

    public void setViajeID(long viajeID) {
        this.viajeID = viajeID;
    }

    public long getColectorPrincipalID() {
        return colectorPrincipalID;
    }

    public void setColectorPrincipalID(long colectorPrincipalID) {
        this.colectorPrincipalID = colectorPrincipalID;
    }

    public Long getRaizID() {
        return raizID;
    }

    public void setRaizID(Long raizID) {
        this.raizID = raizID;
    }

    public Long getTalloID() {
        return talloID;
    }

    public void setTalloID(Long talloID) {
        this.talloID = talloID;
    }

    public Long getInflorescenciaID() {
        return inflorescenciaID;
    }

    public void setInflorescenciaID(Long inflorescenciaID) {
        this.inflorescenciaID = inflorescenciaID;
    }

    public Long getFrutoID() {
        return frutoID;
    }

    public void setFrutoID(Long frutoID) {
        this.frutoID = frutoID;
    }

    public Long getFlorID() {
        return florID;
    }

    public void setFlorID(Long florID) {
        this.florID = florID;
    }

    public Long getHojaID() {
        return hojaID;
    }

    public void setHojaID(Long hojaID) {
        this.hojaID = hojaID;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /** To-one relationship, resolved on first access. */
    public Habito getHabito() {
        Long __key = this.habitoID;
        if (habito__resolvedKey == null || !habito__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            HabitoDao targetDao = daoSession.getHabitoDao();
            Habito habitoNew = targetDao.load(__key);
            synchronized (this) {
                habito = habitoNew;
            	habito__resolvedKey = __key;
            }
        }
        return habito;
    }

	/**
	 *
	 * @param habito el hábito del espécimen
	 */
    public void setHabito(Habito habito) {
        synchronized (this) {
            this.habito = habito;
            habitoID = habito == null ? null : habito.getId();
            habito__resolvedKey = habitoID;
        }
    }

    /** To-one relationship, resolved on first access. */
    public Habitat getHabitat() {
        Long __key = this.habitatID;
        if (habitat__resolvedKey == null || !habitat__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            HabitatDao targetDao = daoSession.getHabitatDao();
            Habitat habitatNew = targetDao.load(__key);
            synchronized (this) {
                habitat = habitatNew;
            	habitat__resolvedKey = __key;
            }
        }
        return habitat;
    }

	/**
	 *
	 * @param habitat el hábitat del espécimen
	 */
    public void setHabitat(Habitat habitat) {
        synchronized (this) {
            this.habitat = habitat;
            habitatID = habitat == null ? null : habitat.getId();
            habitat__resolvedKey = habitatID;
        }
    }

    /** To-one relationship, resolved on first access. */
    public Fenologia getFenologia() {
        Long __key = this.fenologiaID;
        if (fenologia__resolvedKey == null || !fenologia__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FenologiaDao targetDao = daoSession.getFenologiaDao();
            Fenologia fenologiaNew = targetDao.load(__key);
            synchronized (this) {
                fenologia = fenologiaNew;
            	fenologia__resolvedKey = __key;
            }
        }
        return fenologia;
    }

    public void setFenologia(Fenologia fenologia) {
        synchronized (this) {
            this.fenologia = fenologia;
            fenologiaID = fenologia == null ? null : fenologia.getId();
            fenologia__resolvedKey = fenologiaID;
        }
    }

    /** To-one relationship, resolved on first access. */
    public Localidad getLocalidad() {
        Long __key = this.localidadID;
        if (localidad__resolvedKey == null || !localidad__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            LocalidadDao targetDao = daoSession.getLocalidadDao();
            Localidad localidadNew = targetDao.load(__key);
            synchronized (this) {
                localidad = localidadNew;
            	localidad__resolvedKey = __key;
            }
        }
        return localidad;
    }

	/**
	 *
	 * @param localidad la localidad del espécimen
	 */
    public void setLocalidad(Localidad localidad) {
        synchronized (this) {
            this.localidad = localidad;
            localidadID = localidad == null ? null : localidad.getId();
            localidad__resolvedKey = localidadID;
        }
    }

    /** To-one relationship, resolved on first access. */
    public Inflorescencia getInflorescencia() {
        Long __key = this.inflorescenciaID;
        if (inflorescencia__resolvedKey == null || !inflorescencia__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            InflorescenciaDao targetDao = daoSession.getInflorescenciaDao();
            Inflorescencia inflorescenciaNew = targetDao.load(__key);
            synchronized (this) {
                inflorescencia = inflorescenciaNew;
            	inflorescencia__resolvedKey = __key;
            }
        }
        return inflorescencia;
    }

    public void setInflorescencia(Inflorescencia inflorescencia) {
        synchronized (this) {
            this.inflorescencia = inflorescencia;
            inflorescenciaID = inflorescencia == null ? null : inflorescencia.getId();
            inflorescencia__resolvedKey = inflorescenciaID;
        }
    }

    /** To-one relationship, resolved on first access. */
    public ColectorPrincipal getColectorPrincipal() {
        long __key = this.colectorPrincipalID;
        if (colectorPrincipal__resolvedKey == null || !colectorPrincipal__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ColectorPrincipalDao targetDao = daoSession.getColectorPrincipalDao();
            ColectorPrincipal colectorPrincipalNew = targetDao.load(__key);
            synchronized (this) {
                colectorPrincipal = colectorPrincipalNew;
            	colectorPrincipal__resolvedKey = __key;
            }
        }
        return colectorPrincipal;
    }

    public void setColectorPrincipal(ColectorPrincipal colectorPrincipal) {
        if (colectorPrincipal == null) {
            throw new DaoException("To-one property 'colectorPrincipalID' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.colectorPrincipal = colectorPrincipal;
            colectorPrincipalID = colectorPrincipal.getId();
            colectorPrincipal__resolvedKey = colectorPrincipalID;
        }
    }

    /** To-one relationship, resolved on first access. */
    public Viaje getViaje() {
        long __key = this.viajeID;
        if (viaje__resolvedKey == null || !viaje__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ViajeDao targetDao = daoSession.getViajeDao();
            Viaje viajeNew = targetDao.load(__key);
            synchronized (this) {
                viaje = viajeNew;
            	viaje__resolvedKey = __key;
            }
        }
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        if (viaje == null) {
            throw new DaoException("To-one property 'viajeID' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.viaje = viaje;
            viajeID = viaje.getId();
            viaje__resolvedKey = viajeID;
        }
    }

    /** To-one relationship, resolved on first access. */
    public Hoja getHoja() {
        Long __key = this.hojaID;
        if (hoja__resolvedKey == null || !hoja__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            HojaDao targetDao = daoSession.getHojaDao();
            Hoja hojaNew = targetDao.load(__key);
            synchronized (this) {
                hoja = hojaNew;
            	hoja__resolvedKey = __key;
            }
        }
        return hoja;
    }

    public void setHoja(Hoja hoja) {
        synchronized (this) {
            this.hoja = hoja;
            hojaID = hoja == null ? null : hoja.getId();
            hoja__resolvedKey = hojaID;
        }
    }

    /** To-one relationship, resolved on first access. */
    public Fruto getFruto() {
        Long __key = this.frutoID;
        if (fruto__resolvedKey == null || !fruto__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FrutoDao targetDao = daoSession.getFrutoDao();
            Fruto frutoNew = targetDao.load(__key);
            synchronized (this) {
                fruto = frutoNew;
            	fruto__resolvedKey = __key;
            }
        }
        return fruto;
    }

    public void setFruto(Fruto fruto) {
        synchronized (this) {
            this.fruto = fruto;
            frutoID = fruto == null ? null : fruto.getId();
            fruto__resolvedKey = frutoID;
        }
    }

    /** To-one relationship, resolved on first access. */
    public Tallo getTallo() {
        Long __key = this.talloID;
        if (tallo__resolvedKey == null || !tallo__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TalloDao targetDao = daoSession.getTalloDao();
            Tallo talloNew = targetDao.load(__key);
            synchronized (this) {
                tallo = talloNew;
            	tallo__resolvedKey = __key;
            }
        }
        return tallo;
    }

    public void setTallo(Tallo tallo) {
        synchronized (this) {
            this.tallo = tallo;
            talloID = tallo == null ? null : tallo.getId();
            tallo__resolvedKey = talloID;
        }
    }

    /** To-one relationship, resolved on first access. */
    public Raiz getRaiz() {
        Long __key = this.raizID;
        if (raiz__resolvedKey == null || !raiz__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            RaizDao targetDao = daoSession.getRaizDao();
            Raiz raizNew = targetDao.load(__key);
            synchronized (this) {
                raiz = raizNew;
            	raiz__resolvedKey = __key;
            }
        }
        return raiz;
    }

    public void setRaiz(Raiz raiz) {
        synchronized (this) {
            this.raiz = raiz;
            raizID = raiz == null ? null : raiz.getId();
            raiz__resolvedKey = raizID;
        }
    }

    /** To-one relationship, resolved on first access. */
    public Flor getFlor() {
        Long __key = this.florID;
        if (flor__resolvedKey == null || !flor__resolvedKey.equals(__key)) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FlorDao targetDao = daoSession.getFlorDao();
            Flor florNew = targetDao.load(__key);
            synchronized (this) {
                flor = florNew;
            	flor__resolvedKey = __key;
            }
        }
        return flor;
    }

    public void setFlor(Flor flor) {
        synchronized (this) {
            this.flor = flor;
            florID = flor == null ? null : flor.getId();
            flor__resolvedKey = florID;
        }
    }

	public Etiqueta getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(Etiqueta etiqueta) {
		this.etiqueta = etiqueta;
	}

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<EspecimenColectorSecundario> getColectoresSecundarios() {
        if (colectoresSecundarios == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            EspecimenColectorSecundarioDao targetDao = daoSession.getEspecimenColectorSecundarioDao();
            List<EspecimenColectorSecundario> colectoresSecundariosNew = targetDao._queryEspecimen_ColectoresSecundarios(id);
            synchronized (this) {
                if(colectoresSecundarios == null) {
                    colectoresSecundarios = colectoresSecundariosNew;
                }
            }
        }
        return colectoresSecundarios;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
	public void setColectoresSecundarios(List<EspecimenColectorSecundario> colectoresSecundarios) {
		this.colectoresSecundarios = colectoresSecundarios;
	}

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<MuestraAsociada> getMuestrasAsociadas() {
        if (muestrasAsociadas == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MuestraAsociadaDao targetDao = daoSession.getMuestraAsociadaDao();
            List<MuestraAsociada> muestrasAsociadasNew = targetDao._queryEspecimen_MuestrasAsociadas(id);
            synchronized (this) {
                if(muestrasAsociadas == null) {
                    muestrasAsociadas = muestrasAsociadasNew;
                }
            }
        }
        return muestrasAsociadas;
    }

	public void setMuestrasAsociadas(List<MuestraAsociada> muestrasAsociadas) {
		this.muestrasAsociadas = muestrasAsociadas;
	}

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<ColorEspecimen> getColores() {
        if (colores == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ColorEspecimenDao targetDao = daoSession.getColorEspecimenDao();
            List<ColorEspecimen> coloresNew = targetDao._queryEspecimen_Colores(id);
            synchronized (this) {
                if(colores == null) {
                    colores = coloresNew;
                }
            }
        }
        return colores;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    public synchronized void setColores(List<ColorEspecimen> colores) {
        this.colores = colores;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<Fotografia> getFotografias() {
        if (fotografias == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FotografiaDao targetDao = daoSession.getFotografiaDao();
            List<Fotografia> fotografiasNew = targetDao._queryEspecimen_Fotografias(id);
            synchronized (this) {
                if(fotografias == null) {
                    fotografias = fotografiasNew;
                }
            }
        }
        return fotografias;
    }

	public void setFotografias(List<Fotografia> fotografias) {
		this.fotografias = fotografias;
	}

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    public List<IdentidadTaxonomica> getDeterminaciones() {
        if (determinaciones == null) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            IdentidadTaxonomicaDao targetDao = daoSession.getIdentidadTaxonomicaDao();
            List<IdentidadTaxonomica> determinacionesNew = targetDao._queryEspecimen_Determinaciones(id);
            synchronized (this) {
                if(determinaciones == null) {
                    determinaciones = determinacionesNew;
                }
            }
        }
        return determinaciones;
    }

    public void setDeterminaciones(List<IdentidadTaxonomica> determinaciones) {
        this.determinaciones = determinaciones;
    }

    public IdentidadTaxonomica getDeterminacionActual() {
        IdentidadTaxonomica determinacionActual = null;
        if (getDeterminaciones() != null) {
            for (IdentidadTaxonomica identidadTaxonomica:determinaciones) {
                if (determinacionActual == null || determinacionActual.getFechaIdentificacion().before(identidadTaxonomica.getFechaIdentificacion())) {
                    determinacionActual = identidadTaxonomica;
                }
            }
        }
        return determinacionActual;
    }

    /**
     * Agrega una nueva muestra al espécimen
     * @param muestraAsociada La muestra a agregar
     */
	public void agregarMuestraAsociada(MuestraAsociada muestraAsociada){

	}

    /**
     * Asocia el colector secundario al especimen. Solo debe llamarse luego de guardar el especimen.
     * @param colectorSecundario el colector secunadrio a agregar al especimen.
     */
    public void agregarColector(ColectorSecundario colectorSecundario) {
        if (this.id == null) {
            throw new IllegalStateException("El espécimen aún no ha sido guardado.");
        }
        EspecimenColectorSecundario especimenColectorSecundario = new EspecimenColectorSecundario();
        especimenColectorSecundario.setColectorSecundario(colectorSecundario);
        especimenColectorSecundario.setEspecimen(this);
        colectoresSecundarios.add(especimenColectorSecundario);
    }

    /**
     * Quita el colector secundario especificado del espécimen
     * @param colectorSecundario El colector secundario a quitar
     */
	public void quitarColector(ColectorSecundario colectorSecundario){

	}

	/**
	 * 
	 * @param fotografía la fotografia para agregar al espécimen
	 */
	public void agregarFotografia(Fotografia fotografía){

	}

    public String aString() {
        String string = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        if (fechaInicial != null) {
            string = string + "Collecting date: " + simpleDateFormat.format(fechaInicial);
        }
        if (alturaDeLaPlanta != null) {
            string = string + (string.equals("") ? "Altura de la planta: ":", Altura de la planta: ") + alturaDeLaPlanta;
        }
        if (dap != null) {
            string = string + (string.equals("") ? "DAP: ":", DAP: ") + dap;
        }
        if (habito != null) {
            string = string + (string.equals("") ? "Hábito: ":", Hábito: ") + habito;
        }
        if (habitat != null) {
            string = string + (string.equals("") ? "Hábitat: ":", Hábitat: ") + habitat;
        }
        if (fenologia != null) {
            string = string + (string.equals("") ? "Fenología: ":", Fenología: ") + fenologia;
        }
        if (getFlor() != null) {
            string = string + (string.equals("") ? "Flor: ":", Flor: ") + flor.aString();
        }
        if (getFruto() != null) {
            string = string + (string.equals("") ? "Fruto: ":", Fruto: ") + fruto.aString();
        }
        if (getInflorescencia() != null) {
            string = string + (string.equals("") ? "Inflorescencia: ":", Inflorescencia: ") + inflorescencia.aString();
        }
        if (getTallo() != null) {
            string = string + (string.equals("") ? "Tallo: ":", Tallo: ") + tallo.aString();
        }
        if (getHoja() != null) {
            string = string + (string.equals("") ? "Hoja: ":", Hoja: ") + hoja.aString();
        }
        if (getRaiz() != null) {
            string = string + (string.equals("") ? "Raiz: ":", Raiz: ") + raiz.aString();
        }
        if (getColores() != null) {
            for (ColorEspecimen colorEspecimen:colores) {
                if (colorEspecimen.getOrganoDeLaPlanta() == null) {
                    string = string + (string.equals("") ? "":", ") + colorEspecimen.aString();
                }
            }
        }
        return string;
    }

    @Override
    public String toString() {
        return "Especimen{" +
                "id=" + id +
                ", numeroDeColeccion='" + numeroDeColeccion + '\'' +
                ", abundancia='" + abundancia + '\'' +
                ", descripcionEspecimen='" + descripcionEspecimen + '\'' +
                ", alturaDeLaPlanta=" + alturaDeLaPlanta +
                ", dap=" + dap +
                ", fechaInicial=" + fechaInicial +
                ", fechaFinal=" + fechaFinal +
                ", metodoColeccion='" + metodoColeccion + '\'' +
                ", estacionDelAño='" + estacionDelAño + '\'' +
                ", habitoID=" + habitoID +
                ", habitatID=" + habitatID +
                ", fenologiaID=" + fenologiaID +
                ", localidadID=" + localidadID +
                ", viajeID=" + viajeID +
                ", colectorPrincipalID=" + colectorPrincipalID +
                ", raizID=" + raizID +
                ", talloID=" + talloID +
                ", inflorescenciaID=" + inflorescenciaID +
                ", frutoID=" + frutoID +
                ", florID=" + florID +
                ", hojaID=" + hojaID +
                ", tipo='" + tipo + '\'' +
                ", daoSession=" + daoSession +
                ", myDao=" + myDao +
                ", etiqueta=" + etiqueta +
                ", habito=" + habito +
                ", habito__resolvedKey=" + habito__resolvedKey +
                ", habitat=" + habitat +
                ", habitat__resolvedKey=" + habitat__resolvedKey +
                ", fenologia=" + fenologia +
                ", fenologia__resolvedKey=" + fenologia__resolvedKey +
                ", localidad=" + localidad +
                ", localidad__resolvedKey=" + localidad__resolvedKey +
                ", inflorescencia=" + inflorescencia +
                ", inflorescencia__resolvedKey=" + inflorescencia__resolvedKey +
                ", colectorPrincipal=" + colectorPrincipal +
                ", colectorPrincipal__resolvedKey=" + colectorPrincipal__resolvedKey +
                ", viaje=" + viaje +
                ", viaje__resolvedKey=" + viaje__resolvedKey +
                ", hoja=" + hoja +
                ", hoja__resolvedKey=" + hoja__resolvedKey +
                ", fruto=" + fruto +
                ", fruto__resolvedKey=" + fruto__resolvedKey +
                ", tallo=" + tallo +
                ", tallo__resolvedKey=" + tallo__resolvedKey +
                ", raiz=" + raiz +
                ", raiz__resolvedKey=" + raiz__resolvedKey +
                ", flor=" + flor +
                ", flor__resolvedKey=" + flor__resolvedKey +
                ", colectoresSecundarios=" + colectoresSecundarios +
                ", muestrasAsociadas=" + muestrasAsociadas +
                ", colores=" + colores +
                ", fotografias=" + fotografias +
                ", determinaciones=" + determinaciones +
                '}';
    }
}