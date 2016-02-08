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
import edu.udistrital.plantae.logicadominio.recoleccion.ColectorSecundario;
import edu.udistrital.plantae.logicadominio.recoleccion.Viaje;
import edu.udistrital.plantae.logicadominio.recoleccion.ViajeColectorSecundario;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table VIAJE_COLECTOR_SECUNDARIO.
*/
public class ViajeColectorSecundarioDao extends AbstractDao<ViajeColectorSecundario, Long> {

    public static final String TABLENAME = "VIAJE_COLECTOR_SECUNDARIO";

    /**
     * Properties of entity ViajeColectorSecundario.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property ViajeID = new Property(1, Long.class, "viajeID", false, "VIAJE_ID");
        public final static Property ColectorSecundarioID = new Property(2, Long.class, "colectorSecundarioID", false, "COLECTOR_SECUNDARIO_ID");
    };

    private DaoSession daoSession;

    private Query<ViajeColectorSecundario> colectorSecundario_ViajesQuery;
    private Query<ViajeColectorSecundario> viaje_ColectoresSecundariosQuery;

    public ViajeColectorSecundarioDao(DaoConfig config) {
        super(config);
    }
    
    public ViajeColectorSecundarioDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'VIAJE_COLECTOR_SECUNDARIO' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'VIAJE_ID' INTEGER," + // 1: viajeID
                "'COLECTOR_SECUNDARIO_ID' INTEGER);"); // 2: colectorSecundarioID
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_VIAJE_COLECTOR_SECUNDARIO_VIAJE_ID_COLECTOR_SECUNDARIO_ID ON VIAJE_COLECTOR_SECUNDARIO" +
                " (VIAJE_ID,COLECTOR_SECUNDARIO_ID);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'VIAJE_COLECTOR_SECUNDARIO'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ViajeColectorSecundario entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long viajeID = entity.getViajeID();
        if (viajeID != null) {
            stmt.bindLong(2, viajeID);
        }
 
        Long colectorSecundarioID = entity.getColectorSecundarioID();
        if (colectorSecundarioID != null) {
            stmt.bindLong(3, colectorSecundarioID);
        }
    }

    @Override
    protected void attachEntity(ViajeColectorSecundario entity) {
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
    public ViajeColectorSecundario readEntity(Cursor cursor, int offset) {
        ViajeColectorSecundario entity = new ViajeColectorSecundario();
        readEntity(cursor, entity, offset);
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ViajeColectorSecundario entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setViajeID(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setColectorSecundarioID(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(ViajeColectorSecundario entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(ViajeColectorSecundario entity) {
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
    
    /** Internal query to resolve the "viajes" to-many relationship of ColectorSecundario. */
    public List<ViajeColectorSecundario> _queryColectorSecundario_Viajes(Long colectorSecundarioID) {
        synchronized (this) {
            if (colectorSecundario_ViajesQuery == null) {
                QueryBuilder<ViajeColectorSecundario> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.ColectorSecundarioID.eq(null));
                colectorSecundario_ViajesQuery = queryBuilder.build();
            }
        }
        Query<ViajeColectorSecundario> query = colectorSecundario_ViajesQuery.forCurrentThread();
        query.setParameter(0, colectorSecundarioID);
        return query.list();
    }

    /** Internal query to resolve the "colectoresSecundarios" to-many relationship of Viaje. */
    public List<ViajeColectorSecundario> _queryViaje_ColectoresSecundarios(Long viajeID) {
        synchronized (this) {
            if (viaje_ColectoresSecundariosQuery == null) {
                QueryBuilder<ViajeColectorSecundario> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.ViajeID.eq(null));
                viaje_ColectoresSecundariosQuery = queryBuilder.build();
            }
        }
        Query<ViajeColectorSecundario> query = viaje_ColectoresSecundariosQuery.forCurrentThread();
        query.setParameter(0, viajeID);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getColectorSecundarioDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getViajeDao().getAllColumns());
            builder.append(" FROM VIAJE_COLECTOR_SECUNDARIO T");
            builder.append(" LEFT JOIN COLECTOR_SECUNDARIO T0 ON T.'COLECTOR_SECUNDARIO_ID'=T0.'_id'");
            builder.append(" LEFT JOIN VIAJE T1 ON T.'VIAJE_ID'=T1.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected ViajeColectorSecundario loadCurrentDeep(Cursor cursor, boolean lock) {
        ViajeColectorSecundario entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        ColectorSecundario colectorSecundario = loadCurrentOther(daoSession.getColectorSecundarioDao(), cursor, offset);
        entity.setColectorSecundario(colectorSecundario);
        offset += daoSession.getColectorSecundarioDao().getAllColumns().length;

        Viaje viaje = loadCurrentOther(daoSession.getViajeDao(), cursor, offset);
        entity.setViaje(viaje);

        return entity;    
    }

    public ViajeColectorSecundario loadDeep(Long key) {
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
    public List<ViajeColectorSecundario> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<ViajeColectorSecundario> list = new ArrayList<ViajeColectorSecundario>(count);
        
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
    
    protected List<ViajeColectorSecundario> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<ViajeColectorSecundario> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}