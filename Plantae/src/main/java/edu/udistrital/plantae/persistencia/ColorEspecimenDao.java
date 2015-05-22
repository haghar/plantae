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
import edu.udistrital.plantae.logicadominio.datosespecimen.ColorEspecimen;
import edu.udistrital.plantae.logicadominio.datosespecimen.ColorMunsell;
import edu.udistrital.plantae.logicadominio.datosespecimen.Especimen;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table COLOR_ESPECIMEN.
*/
public class ColorEspecimenDao extends AbstractDao<ColorEspecimen, Long> {

    public static final String TABLENAME = "COLOR_ESPECIMEN";

    /**
     * Properties of entity ColorEspecimen.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Nombre = new Property(1, String.class, "nombre", false, "NOMBRE");
        public final static Property Descripcion = new Property(2, String.class, "descripcion", false, "DESCRIPCION");
        public final static Property OrganoDeLaPlanta = new Property(3, String.class, "organoDeLaPlanta", false, "ORGANO_DE_LA_PLANTA");
        public final static Property ColorRGB = new Property(4, Integer.class, "colorRGB", false, "COLOR_RGB");
        public final static Property ColorMunsellID = new Property(5, Long.class, "colorMunsellID", false, "COLOR_MUNSELL_ID");
        public final static Property UsuarioID = new Property(6, Long.class, "usuarioID", false, "USUARIO_ID");
        public final static Property EspecimenID = new Property(7, Long.class, "especimenID", false, "ESPECIMEN_ID");
    };

    private DaoSession daoSession;

    private Query<ColorEspecimen> especimen_ColoresQuery;
    private Query<ColorEspecimen> usuario_ColoresEspecimenQuery;

    public ColorEspecimenDao(DaoConfig config) {
        super(config);
    }
    
    public ColorEspecimenDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'COLOR_ESPECIMEN' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'NOMBRE' TEXT," + // 1: nombre
                "'DESCRIPCION' TEXT," + // 2: descripcion
                "'ORGANO_DE_LA_PLANTA' TEXT," + // 3: organoDeLaPlanta
                "'COLOR_RGB' INTEGER," + // 4: colorRGB
                "'COLOR_MUNSELL_ID' INTEGER," + // 5: colorMunsellID
                "'USUARIO_ID' INTEGER," + // 6: usuarioID
                "'ESPECIMEN_ID' INTEGER);"); // 7: especimenID
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_COLOR_ESPECIMEN_NOMBRE ON COLOR_ESPECIMEN" +
                " (NOMBRE);");
        db.execSQL("CREATE INDEX " + constraint + "IDX_COLOR_ESPECIMEN_COLOR_MUNSELL_ID ON COLOR_ESPECIMEN" +
                " (COLOR_MUNSELL_ID);");
        db.execSQL("CREATE INDEX " + constraint + "IDX_COLOR_ESPECIMEN_USUARIO_ID ON COLOR_ESPECIMEN" +
                " (USUARIO_ID);");
        db.execSQL("CREATE INDEX " + constraint + "IDX_COLOR_ESPECIMEN_ESPECIMEN_ID ON COLOR_ESPECIMEN" +
                " (ESPECIMEN_ID);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'COLOR_ESPECIMEN'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ColorEspecimen entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String nombre = entity.getNombre();
        if (nombre != null) {
            stmt.bindString(2, nombre);
        }
 
        String descripcion = entity.getDescripcion();
        if (descripcion != null) {
            stmt.bindString(3, descripcion);
        }
 
        String organoDeLaPlanta = entity.getOrganoDeLaPlanta();
        if (organoDeLaPlanta != null) {
            stmt.bindString(4, organoDeLaPlanta);
        }

        Integer colorRGB = entity.getColorRGB();
        if (colorRGB != null) {
            stmt.bindLong(5, colorRGB);
        }

        Long colorMunsellID = entity.getColorMunsellID();
        if (colorMunsellID != null) {
            stmt.bindLong(6, colorMunsellID);
        }
 
        Long usuarioID = entity.getUsuarioID();
        if (usuarioID != null) {
            stmt.bindLong(7, usuarioID);
        }

        Long especimenID = entity.getEspecimenID();
        if (especimenID != null) {
            stmt.bindLong(8, especimenID);
        }
    }

    @Override
    protected void attachEntity(ColorEspecimen entity) {
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
    public ColorEspecimen readEntity(Cursor cursor, int offset) {
        ColorEspecimen entity = new ColorEspecimen();
        readEntity(cursor, entity, offset);
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ColorEspecimen entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setNombre(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDescripcion(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setOrganoDeLaPlanta(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setColorRGB(cursor.isNull(offset + 4) ? null : cursor.getInt(offset + 4));
        entity.setColorMunsellID(cursor.isNull(offset + 5) ? null : cursor.getLong(offset + 5));
        entity.setUsuarioID(cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6));
        entity.setEspecimenID(cursor.isNull(offset + 7) ? null : cursor.getLong(offset + 7));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(ColorEspecimen entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(ColorEspecimen entity) {
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
    
    /** Internal query to resolve the "colores" to-many relationship of Especimen. */
    public List<ColorEspecimen> _queryEspecimen_Colores(Long especimenID) {
        synchronized (this) {
            if (especimen_ColoresQuery == null) {
                QueryBuilder<ColorEspecimen> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.EspecimenID.eq(null));
                especimen_ColoresQuery = queryBuilder.build();
            }
        }
        Query<ColorEspecimen> query = especimen_ColoresQuery.forCurrentThread();
        query.setParameter(0, especimenID);
        return query.list();
    }

    /** Internal query to resolve the "coloresEspecimen" to-many relationship of Usuario. */
    public List<ColorEspecimen> _queryUsuario_ColoresEspecimen(Long usuarioID) {
        synchronized (this) {
            if (usuario_ColoresEspecimenQuery == null) {
                QueryBuilder<ColorEspecimen> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.UsuarioID.eq(null));
                usuario_ColoresEspecimenQuery = queryBuilder.build();
            }
        }
        Query<ColorEspecimen> query = usuario_ColoresEspecimenQuery.forCurrentThread();
        query.setParameter(0, usuarioID);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getColorMunsellDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getEspecimenDao().getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T2", daoSession.getUsuarioDao().getAllColumns());
            builder.append(" FROM COLOR_ESPECIMEN T");
            builder.append(" LEFT JOIN COLOR_MUNSELL T0 ON T.'COLOR_MUNSELL_ID'=T0.'_id'");
            builder.append(" LEFT JOIN ESPECIMEN T1 ON T.'ESPECIMEN_ID'=T1.'_id'");
            builder.append(" LEFT JOIN USUARIO T2 ON T.'USUARIO_ID'=T2.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected ColorEspecimen loadCurrentDeep(Cursor cursor, boolean lock) {
        ColorEspecimen entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        ColorMunsell colorMunsell = loadCurrentOther(daoSession.getColorMunsellDao(), cursor, offset);
        entity.setColorMunsell(colorMunsell);
        offset += daoSession.getColorMunsellDao().getAllColumns().length;

        Especimen especimen = loadCurrentOther(daoSession.getEspecimenDao(), cursor, offset);
        entity.setEspecimen(especimen);
        offset += daoSession.getEspecimenDao().getAllColumns().length;

        Usuario usuario = loadCurrentOther(daoSession.getUsuarioDao(), cursor, offset);
        entity.setUsuario(usuario);

        return entity;    
    }

    public ColorEspecimen loadDeep(Long key) {
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
    public List<ColorEspecimen> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<ColorEspecimen> list = new ArrayList<ColorEspecimen>(count);
        
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
    
    protected List<ColorEspecimen> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<ColorEspecimen> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
