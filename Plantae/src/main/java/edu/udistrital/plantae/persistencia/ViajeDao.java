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
import edu.udistrital.plantae.logicadominio.recoleccion.ColectorPrincipal;
import edu.udistrital.plantae.logicadominio.recoleccion.Proyecto;
import edu.udistrital.plantae.logicadominio.recoleccion.Viaje;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table VIAJE.
*/
public class ViajeDao extends AbstractDao<Viaje, Long> {

    public static final String TABLENAME = "VIAJE";

    /**
     * Properties of entity Viaje.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Nombre = new Property(1, String.class, "nombre", false, "NOMBRE");
        public final static Property ColectorPrincipalID = new Property(2, Long.class, "colectorPrincipalID", false, "COLECTOR_PRINCIPAL_ID");
        public final static Property ProyectoID = new Property(3, Long.class, "proyectoID", false, "PROYECTO_ID");
    };

    private DaoSession daoSession;

    private Query<Viaje> colectorPrincipal_ViajesQuery;
    private Query<Viaje> proyecto_ViajesQuery;

    public ViajeDao(DaoConfig config) {
        super(config);
    }
    
    public ViajeDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'VIAJE' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'NOMBRE' TEXT," + // 1: nombre
                "'COLECTOR_PRINCIPAL_ID' INTEGER," + // 2: colectorPrincipalID
                "'PROYECTO_ID' INTEGER);"); // 3: proyectoID
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_VIAJE_NOMBRE ON VIAJE" +
                " (NOMBRE);");
        db.execSQL("CREATE INDEX " + constraint + "IDX_VIAJE_COLECTOR_PRINCIPAL_ID ON VIAJE" +
                " (COLECTOR_PRINCIPAL_ID);");
        db.execSQL("CREATE INDEX " + constraint + "IDX_VIAJE_PROYECTO_ID ON VIAJE" +
                " (PROYECTO_ID);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'VIAJE'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Viaje entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String nombre = entity.getNombre();
        if (nombre != null) {
            stmt.bindString(2, nombre);
        }
 
        Long colectorPrincipalID = entity.getColectorPrincipalID();
        if (colectorPrincipalID != null) {
            stmt.bindLong(3, colectorPrincipalID);
        }
 
        Long proyectoID = entity.getProyectoID();
        if (proyectoID != null) {
            stmt.bindLong(4, proyectoID);
        }
    }

    @Override
    protected void attachEntity(Viaje entity) {
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
    public Viaje readEntity(Cursor cursor, int offset) {
        Viaje entity = new Viaje();
        readEntity(cursor, entity, offset);
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Viaje entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setNombre(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setColectorPrincipalID(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setProyectoID(cursor.isNull(offset + 3) ? null : cursor.getLong(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Viaje entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Viaje entity) {
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
    
    /** Internal query to resolve the "viajes" to-many relationship of ColectorPrincipal. */
    public List<Viaje> _queryColectorPrincipal_Viajes(Long colectorPrincipalID) {
        synchronized (this) {
            if (colectorPrincipal_ViajesQuery == null) {
                QueryBuilder<Viaje> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.ColectorPrincipalID.eq(null));
                colectorPrincipal_ViajesQuery = queryBuilder.build();
            }
        }
        Query<Viaje> query = colectorPrincipal_ViajesQuery.forCurrentThread();
        query.setParameter(0, colectorPrincipalID);
        return query.list();
    }

    /** Internal query to resolve the "viajes" to-many relationship of Proyecto. */
    public List<Viaje> _queryProyecto_Viajes(Long proyectoID) {
        synchronized (this) {
            if (proyecto_ViajesQuery == null) {
                QueryBuilder<Viaje> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.ProyectoID.eq(null));
                proyecto_ViajesQuery = queryBuilder.build();
            }
        }
        Query<Viaje> query = proyecto_ViajesQuery.forCurrentThread();
        query.setParameter(0, proyectoID);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getColectorPrincipalDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getProyectoDao().getAllColumns());
            builder.append(" FROM VIAJE T");
            builder.append(" LEFT JOIN COLECTOR_PRINCIPAL T0 ON T.'COLECTOR_PRINCIPAL_ID'=T0.'_id'");
            builder.append(" LEFT JOIN PROYECTO T1 ON T.'PROYECTO_ID'=T1.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Viaje loadCurrentDeep(Cursor cursor, boolean lock) {
        Viaje entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        ColectorPrincipal colectorPrincipal = loadCurrentOther(daoSession.getColectorPrincipalDao(), cursor, offset);
        entity.setColectorPrincipal(colectorPrincipal);
        offset += daoSession.getColectorPrincipalDao().getAllColumns().length;

        Proyecto proyecto = loadCurrentOther(daoSession.getProyectoDao(), cursor, offset);
        entity.setProyecto(proyecto);

        return entity;    
    }

    public Viaje loadDeep(Long key) {
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
    public List<Viaje> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Viaje> list = new ArrayList<Viaje>(count);
        
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
    
    protected List<Viaje> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Viaje> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
