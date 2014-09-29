package edu.udistrital.plantae.persistencia;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.internal.SqlUtils;
import edu.udistrital.plantae.logicadominio.autenticacion.Persona;
import edu.udistrital.plantae.logicadominio.recoleccion.ColectorPrincipal;

import java.util.ArrayList;
import java.util.List;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table COLECTOR_PRINCIPAL.
*/
public class ColectorPrincipalDao extends AbstractDao<ColectorPrincipal, Long> {

    public static final String TABLENAME = "COLECTOR_PRINCIPAL";

    /**
     * Properties of entity ColectorPrincipal.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property NumeroColeccionActual = new Property(1, String.class, "numeroColeccionActual", false, "NUMERO_COLECCION_ACTUAL");
        public final static Property TipoCapturaDatos = new Property(2, Integer.class, "tipoCapturaDatos", false, "TIPO_CAPTURA_DATOS");
        public final static Property PersonaID = new Property(3, long.class, "personaID", false, "PERSONA_ID");
    };

    private DaoSession daoSession;


    public ColectorPrincipalDao(DaoConfig config) {
        super(config);
    }
    
    public ColectorPrincipalDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'COLECTOR_PRINCIPAL' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'NUMERO_COLECCION_ACTUAL' TEXT," + // 1: numeroColeccionActual
                "'TIPO_CAPTURA_DATOS' INTEGER," + // 2: tipoCapturaDatos
                "'PERSONA_ID' INTEGER NOT NULL );"); // 3: personaID
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_COLECTOR_PRINCIPAL_PERSONA_ID ON COLECTOR_PRINCIPAL" +
                " (PERSONA_ID);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'COLECTOR_PRINCIPAL'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ColectorPrincipal entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String numeroColeccionActual = entity.getNumeroColeccionActual();
        if (numeroColeccionActual != null) {
            stmt.bindString(2, numeroColeccionActual);
        }
 
        Integer tipoCapturaDatos = entity.getTipoCapturaDatos();
        if (tipoCapturaDatos != null) {
            stmt.bindLong(3, tipoCapturaDatos);
        }
        stmt.bindLong(4, entity.getPersonaID());
    }

    @Override
    protected void attachEntity(ColectorPrincipal entity) {
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
    public ColectorPrincipal readEntity(Cursor cursor, int offset) {
        ColectorPrincipal entity = new ColectorPrincipal();
        readEntity(cursor, entity, offset);
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ColectorPrincipal entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setNumeroColeccionActual(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTipoCapturaDatos(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setPersonaID(cursor.getLong(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(ColectorPrincipal entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(ColectorPrincipal entity) {
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
    
    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getPersonaDao().getAllColumns());
            builder.append(" FROM COLECTOR_PRINCIPAL T");
            builder.append(" LEFT JOIN PERSONA T0 ON T.'PERSONA_ID'=T0.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected ColectorPrincipal loadCurrentDeep(Cursor cursor, boolean lock) {
        ColectorPrincipal entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Persona persona = loadCurrentOther(daoSession.getPersonaDao(), cursor, offset);
        if(persona != null) {
            entity.setPersona(persona);
        }

        return entity;    
    }

    public ColectorPrincipal loadDeep(Long key) {
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
    public List<ColectorPrincipal> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<ColectorPrincipal> list = new ArrayList<ColectorPrincipal>(count);
        
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
    
    protected List<ColectorPrincipal> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<ColectorPrincipal> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
