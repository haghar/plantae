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
import edu.udistrital.plantae.logicadominio.taxonomia.Taxon;
import edu.udistrital.plantae.logicadominio.taxonomia.Uso;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table USO.
*/
public class UsoDao extends AbstractDao<Uso, Long> {

    public static final String TABLENAME = "USO";

    /**
     * Properties of entity Uso.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Descripcion = new Property(1, String.class, "descripcion", false, "DESCRIPCION");
        public final static Property UsuarioID = new Property(2, Long.class, "usuarioID", false, "USUARIO_ID");
        public final static Property TaxonID = new Property(3, long.class, "taxonID", false, "TAXON_ID");
    };

    private DaoSession daoSession;

    private Query<Uso> usuario_UsosQuery;
    private Query<Uso> taxon_UsosQuery;

    public UsoDao(DaoConfig config) {
        super(config);
    }
    
    public UsoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'USO' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'DESCRIPCION' TEXT," + // 1: descripcion
                "'USUARIO_ID' INTEGER," + // 2: usuarioID
                "'TAXON_ID' INTEGER NOT NULL );"); // 3: taxonID
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_USO_USUARIO_ID ON USO" +
                " (USUARIO_ID);");
        db.execSQL("CREATE INDEX " + constraint + "IDX_USO_TAXON_ID ON USO" +
                " (TAXON_ID);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'USO'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Uso entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String descripcion = entity.getDescripcion();
        if (descripcion != null) {
            stmt.bindString(2, descripcion);
        }
 
        Long usuarioID = entity.getUsuarioID();
        if (usuarioID != null) {
            stmt.bindLong(3, usuarioID);
        }
        stmt.bindLong(4, entity.getTaxonID());
    }

    @Override
    protected void attachEntity(Uso entity) {
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
    public Uso readEntity(Cursor cursor, int offset) {
        Uso entity = new Uso();
        readEntity(cursor, entity, offset);
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Uso entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setDescripcion(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setUsuarioID(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setTaxonID(cursor.getLong(offset + 3));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Uso entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Uso entity) {
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
    
    /** Internal query to resolve the "usos" to-many relationship of Usuario. */
    public List<Uso> _queryUsuario_Usos(Long usuarioID) {
        synchronized (this) {
            if (usuario_UsosQuery == null) {
                QueryBuilder<Uso> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.UsuarioID.eq(null));
                usuario_UsosQuery = queryBuilder.build();
            }
        }
        Query<Uso> query = usuario_UsosQuery.forCurrentThread();
        query.setParameter(0, usuarioID);
        return query.list();
    }

    /** Internal query to resolve the "usos" to-many relationship of Taxon. */
    public List<Uso> _queryTaxon_Usos(long taxonID) {
        synchronized (this) {
            if (taxon_UsosQuery == null) {
                QueryBuilder<Uso> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.TaxonID.eq(null));
                taxon_UsosQuery = queryBuilder.build();
            }
        }
        Query<Uso> query = taxon_UsosQuery.forCurrentThread();
        query.setParameter(0, taxonID);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getUsuarioDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getTaxonDao().getAllColumns());
            builder.append(" FROM USO T");
            builder.append(" LEFT JOIN USUARIO T0 ON T.'USUARIO_ID'=T0.'_id'");
            builder.append(" LEFT JOIN TAXON T1 ON T.'TAXON_ID'=T1.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Uso loadCurrentDeep(Cursor cursor, boolean lock) {
        Uso entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Usuario usuario = loadCurrentOther(daoSession.getUsuarioDao(), cursor, offset);
        entity.setUsuario(usuario);
        offset += daoSession.getUsuarioDao().getAllColumns().length;

        Taxon taxon = loadCurrentOther(daoSession.getTaxonDao(), cursor, offset);
         if(taxon != null) {
            entity.setTaxon(taxon);
        }

        return entity;    
    }

    public Uso loadDeep(Long key) {
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
    public List<Uso> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Uso> list = new ArrayList<Uso>(count);
        
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
    
    protected List<Uso> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Uso> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
