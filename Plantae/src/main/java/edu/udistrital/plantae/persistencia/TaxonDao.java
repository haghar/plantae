package edu.udistrital.plantae.persistencia;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;
import edu.udistrital.plantae.logicadominio.autenticacion.Usuario;
import edu.udistrital.plantae.logicadominio.taxonomia.EpitetoEspecifico;
import edu.udistrital.plantae.logicadominio.taxonomia.Familia;
import edu.udistrital.plantae.logicadominio.taxonomia.Genero;
import edu.udistrital.plantae.logicadominio.taxonomia.Taxon;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table TAXON.
*/
public class TaxonDao extends AbstractDao<Taxon, Long> {

    public static final String TABLENAME = "TAXON";

    /**
     * Properties of entity Taxon.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Familia = new Property(1, String.class, "familia", false, "FAMILIA");
        public final static Property Genero = new Property(2, String.class, "genero", false, "GENERO");
        public final static Property Especie = new Property(3, String.class, "especie", false, "ESPECIE");
        public final static Property Autor = new Property(4, String.class, "autor", false, "AUTOR");
        public final static Property Rango = new Property(5, String.class, "rango", false, "RANGO");
        public final static Property NombreCientifico = new Property(6, String.class, "nombreCientifico", false, "NOMBRE_CIENTIFICO");
        public final static Property UsuarioId = new Property(7, long.class, "usuarioId", false, "USUARIO_ID");
    };

    private DaoSession daoSession;

    private Query<Taxon> usuario_TaxonesQuery;

    public TaxonDao(DaoConfig config) {
        super(config);
    }
    
    public TaxonDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'TAXON' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'FAMILIA' TEXT," + // 1: familia
                "'GENERO' TEXT," + // 2: genero
                "'ESPECIE' TEXT," + // 3: especie
                "'AUTOR' TEXT," + // 4: autor
                "'RANGO' TEXT," + // 5: rango
                "'NOMBRE_CIENTIFICO' TEXT," + // 6: nombreCientifico
                "'USUARIO_ID' INTEGER NOT NULL );"); // 7: usuarioId
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_TAXON_FAMILIA ON TAXON" +
                " (FAMILIA);");
        db.execSQL("CREATE INDEX " + constraint + "IDX_TAXON_GENERO ON TAXON" +
                " (GENERO);");
        db.execSQL("CREATE INDEX " + constraint + "IDX_TAXON_ESPECIE ON TAXON" +
                " (ESPECIE);");
        db.execSQL("CREATE INDEX " + constraint + "IDX_TAXON_RANGO ON TAXON" +
                " (RANGO);");
        db.execSQL("CREATE INDEX " + constraint + "IDX_TAXON_NOMBRE_CIENTIFICO ON TAXON" +
                " (NOMBRE_CIENTIFICO);");
        db.execSQL("CREATE INDEX " + constraint + "IDX_TAXON_USUARIO_ID ON TAXON" +
                " (USUARIO_ID);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'TAXON'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Taxon entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }

        String nombre = entity.getNombre();
        String rango = null;
        if (entity instanceof Familia){
            if (nombre != null) {
                stmt.bindString(2, nombre);
            }
            rango = "familia";
        }else if (entity instanceof Genero){
            String familia = entity.getTaxonPadre().getNombre();
            if (familia != null) {
                stmt.bindString(2, familia);
            }
            if (nombre != null) {
                stmt.bindString(3, nombre);
            }
            rango = "genero";
        }else if (entity instanceof EpitetoEspecifico){
            String familia = entity.getTaxonPadre().getTaxonPadre().getNombre();
            if (familia != null) {
                stmt.bindString(2, familia);
            }
            String genero = entity.getTaxonPadre().getNombre();
            if (genero != null) {
                stmt.bindString(3, genero);
            }
            if (nombre != null) {
                stmt.bindString(4, nombre);
            }
            rango = "epitetoespecifico";
        }
        /*String familia = entity.getFamilia();
        if (familia != null) {
            stmt.bindString(2, familia);
        }
 
        String genero = entity.getGenero();
        if (genero != null) {
            stmt.bindString(3, genero);
        }
 
        String especie = entity.getEspecie();
        if (especie != null) {
            stmt.bindString(4, especie);
        }*/
 
        String autor = entity.getAutor();
        if (autor != null) {
            stmt.bindString(5, autor);
        }
 
        /*String rango = entity.getRango();*/
        if (rango != null) {
            stmt.bindString(6, rango);
        }
 
        String nombreCientifico = entity.getNombreCientifico();
        if (nombreCientifico != null) {
            stmt.bindString(7, nombreCientifico);
        }
        stmt.bindLong(8, entity.getUsuarioId());
    }

    @Override
    protected void attachEntity(Taxon entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Taxon readEntity(Cursor cursor, int offset) {
        Taxon entity = null;
        String rango = cursor.getString(offset + 5);
        switch (rango) {
            case "familia":
                entity = new Familia();
                break;
            case "genero":
                entity = new Genero();
                break;
            case "epitetoespecifico":
                entity = new EpitetoEspecifico();
                break;
        }
        readEntity(cursor, entity, offset);
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Taxon entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        if (entity instanceof Familia){
            entity.setNombre(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        }else if (entity instanceof Genero){
            Taxon familia = new Familia(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
            entity.setNombre(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
            entity.setTaxonPadre(familia);
        }else if (entity instanceof EpitetoEspecifico){
            Taxon familia = new Familia(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
            Taxon genero = new Genero(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
            entity.setNombre(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
            genero.setTaxonPadre(familia);
            entity.setTaxonPadre(genero);
        }
        /*entity.setFamilia(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setGenero(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setEspecie(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));*/
        entity.setAutor(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        /*entity.setRango(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));*/
        entity.setNombreCientifico(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setUsuarioId(cursor.getLong(offset + 7));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Taxon entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Taxon entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }

    /** Internal query to resolve the "taxones" to-many relationship of Usuario. */
    public List<Taxon> _queryUsuario_Taxones(long usuarioId) {
        synchronized (this) {
            if (usuario_TaxonesQuery == null) {
                QueryBuilder<Taxon> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.UsuarioId.eq(null));
                usuario_TaxonesQuery = queryBuilder.build();
            }
        }
        Query<Taxon> query = usuario_TaxonesQuery.forCurrentThread();
        query.setParameter(0, usuarioId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getUsuarioDao().getAllColumns());
            builder.append(" FROM TAXON T");
            builder.append(" LEFT JOIN USUARIO T0 ON T.'USUARIO_ID'=T0.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }

    protected Taxon loadCurrentDeep(Cursor cursor, boolean lock) {
        Taxon entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Usuario usuario = loadCurrentOther(daoSession.getUsuarioDao(), cursor, offset);
         if(usuario != null) {
            entity.setUsuario(usuario);
        }

        return entity;
    }

    public Taxon loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();

        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);

        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }

    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<Taxon> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Taxon> list = new ArrayList<Taxon>(count);

        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }

    protected List<Taxon> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }


    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Taxon> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
    
}
