package edu.udistrital.plantae.logicadominio.datosespecimen;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.udistrital.plantae.logicadominio.taxonomia.IdentidadTaxonomica;

/**
 * @author Mateus A., Sosa G.
 * @version 1.0
 * @created 08-Oct-2013 5:21:33 PM
 */
public class BuilderEspecimenDetallado extends BuilderEspecimen {

    private Especimen especimen;

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

    private List<EspecimenColectorSecundario> colectoresSecundarios;
    private List<MuestraAsociada> muestrasAsociadas;
    private List<ColorEspecimen> colores;
    private List<Fotografia> fotografias;
    private IdentidadTaxonomica identidadTaxonomica;

    public BuilderEspecimenDetallado(String numeroDeColeccion, long viajeID, long colectorPrincipalID){
        this.numeroDeColeccion = numeroDeColeccion;
        this.viajeID = viajeID;
        this.colectorPrincipalID = colectorPrincipalID;
    }

    public BuilderEspecimenDetallado alturaDeLaPlanta(Long alturaDeLaPlanta) {
        this.alturaDeLaPlanta = alturaDeLaPlanta;
        return this;
    }

    public BuilderEspecimenDetallado dap(Long dap) {
        this.dap = dap;
        return this;
    }

    public BuilderEspecimenDetallado fechaInicial(Date fechaInicial){
        this.fechaInicial = fechaInicial;
        return this;
    }
    public BuilderEspecimenDetallado fechaFinal(Date fechaFinal){
        this.fechaFinal = fechaFinal;
        return this;
    }
    public BuilderEspecimenDetallado metodoColeccion(String metodoColeccion){
        this.metodoColeccion = metodoColeccion;
        return this;
    }
    public BuilderEspecimenDetallado estacionDelAño(String estacionDelAño){
        this.estacionDelAño = estacionDelAño;
        return this;
    }
    public BuilderEspecimenDetallado habitoID(Long habitoID){
        this.habitoID = habitoID;
        return this;
    }
    public BuilderEspecimenDetallado habitatID(Long habitatID){
        this.habitatID = habitatID;
        return this;
    }
    public BuilderEspecimenDetallado fenologiaID(Long fenologiaID){
        this.fenologiaID = fenologiaID;
        return this;
    }

    public BuilderEspecimenDetallado abundancia(String abundancia) {
        this.abundancia = abundancia;
        return this;
    }
    public BuilderEspecimenDetallado descripcionEspecimen(String descripcionEspecimen) {
        this.descripcionEspecimen = descripcionEspecimen;
        return this;
    }
    public BuilderEspecimenDetallado localidadID(Long localidadID){
        this.localidadID = localidadID;
        return this;
    }

    public BuilderEspecimenDetallado raizID(Long raizID){
        this.raizID = raizID;
        return this;
    }
    public BuilderEspecimenDetallado talloID(Long talloID){
        this.talloID = talloID;
        return this;
    }
    public BuilderEspecimenDetallado inflorescenciaID(Long inflorescenciaID){
        this.inflorescenciaID = inflorescenciaID;
        return this;
    }
    public BuilderEspecimenDetallado frutoID(Long frutoID){
        this.frutoID = frutoID;
        return this;
    }
    public BuilderEspecimenDetallado florID(Long florID){
        this.florID = florID;
        return this;
    }
    public BuilderEspecimenDetallado hojaID(Long hojaID){
        this.hojaID = hojaID;
        return this;
    }

    public BuilderEspecimenDetallado colectoresSecundarios(List<EspecimenColectorSecundario> colectoresSecundarios){
        this.colectoresSecundarios = colectoresSecundarios;
        return this;
    }
    public BuilderEspecimenDetallado muestrasAsociadas(List<MuestraAsociada> muestrasAsociadas){
        this.muestrasAsociadas = muestrasAsociadas;
        return this;
    }
    public BuilderEspecimenDetallado colores(List<ColorEspecimen> colores) {
        this.colores = colores;
        return this;
    }
    public BuilderEspecimenDetallado fotografias(List<Fotografia> fotografias){
        this.fotografias = fotografias;
        return this;
    }
    public BuilderEspecimenDetallado identidadTaxonomica(IdentidadTaxonomica identidadTaxonomica){
        this.identidadTaxonomica = identidadTaxonomica;
        return this;
    }

    public void finalize() throws Throwable {
        super.finalize();
    }

    /**
     * Construye un objeto {@link edu.udistrital.plantae.logicadominio.datosespecimen.Especimen} Especimen en base a los atributos de la clase.
     */
    public void build() {
        especimen = new Especimen(numeroDeColeccion, viajeID, colectorPrincipalID);
        especimen.setFechaInicial(fechaInicial);
        especimen.setFechaFinal(new Date(System.currentTimeMillis()));
        especimen.setMetodoColeccion(metodoColeccion);
        especimen.setEstacionDelAño(estacionDelAño);
        especimen.setColectoresSecundarios(colectoresSecundarios);
        especimen.setLocalidadID(localidadID);
        if (identidadTaxonomica != null) {
            List<IdentidadTaxonomica> determinaciones = new ArrayList<IdentidadTaxonomica>(1);
            determinaciones.add(identidadTaxonomica);
            especimen.setDeterminaciones(determinaciones);
        }
        especimen.setHabitatID(habitatID);
        especimen.setHabitoID(habitoID);
        especimen.setFenologiaID(fenologiaID);
        especimen.setAlturaDeLaPlanta(alturaDeLaPlanta);
        especimen.setDap(dap);
        especimen.setAbundancia(abundancia);
        especimen.setDescripcionEspecimen(descripcionEspecimen);
        especimen.setColores(colores);
        especimen.setMuestrasAsociadas(muestrasAsociadas);
        especimen.setFlorID(florID);
        especimen.setRaizID(raizID);
        especimen.setTalloID(talloID);
        especimen.setInflorescenciaID(inflorescenciaID);
        especimen.setFrutoID(frutoID);
        especimen.setHojaID(hojaID);
        especimen.setFotografias(fotografias);
        especimen.setTipo("ED");
    }

    /**
     * Solo debe ser llamado despues de llamar a {@link #build()}
     * @return el especimen construido
     */
    public Especimen getEspecimen(){
        return especimen;
    }

}