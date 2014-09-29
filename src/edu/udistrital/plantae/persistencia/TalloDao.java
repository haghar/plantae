package edu.udistrital.plantae.persistencia;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.internal.SqlUtils;
import edu.udistrital.plantae.logicadominio.datosespecimen.ColorEspecimen;
import edu.udistrital.plantae.logicadominio.datosespecimen.Tallo;

import java.util.ArrayList;
import java.util.List;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table TALLO.
*/
public class TalloDao extends AbstractDao<Tallo, Long> {

    public static final String TABLENAME = "TALLO";

    /**
     * Properties of entity Tallo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property AlturaDelTallo = new Property(1, String.class, "alturaDelTallo", false, "ALTURA_DEL_TALLO");
        public final static Property DiametroDelTallo = new Property(2, String.class, "diametroDelTallo", false, "DIAMETRO_DEL_TALLO");
        public final static Property DisposicionDeLasEspinas = new Property(3, String.class, "disposicionDeLasEspinas", false, "DISPOSICION_DE_LAS_ESPINAS");
        public final static Property FormaDelTallo = new Property(4, String.class, "formaDelTallo", false, "FORMA_DEL_TALLO");
        public final static Property LongitudEntrenudos = new Property(5, String.class, "longitudEntrenudos", false, "LONGITUD_ENTRENUDOS");
        public final static Property NaturalezaDelTallo = new Property(6, String.class, "naturalezaDelTallo", false, "NATURALEZA_DEL_TALLO");
        public final static Property Descripcion = new Property(7, String.class, "descripcion", false, "DESCRIPCION");
        public final static Property DesnudoCubierto = new Property(8, Boolean.class, "desnudoCubierto", false, "DESNUDO_CUBIERTO");
        public final static Property EntrenudosConspicuos = new Property(9, Boolean.class, "entrenudosConspicuos", false, "ENTRENUDOS_CONSPICUOS");
        public final static Property Espinas = new Property(10, Boolean.class, "espinas", false, "ESPINAS");
        public final static Property ColorDelTalloID = new Property(11, Long.class, "colorDelTalloID", false, "COLOR_DEL_TALLO_ID");
    };

    private DaoSession daoSession;


    public TalloDao(DaoConfig config) {
        super(config);
    }
    
    public TalloDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'TALLO' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'ALTURA_DEL_TALLO' TEXT," + // 1: alturaDelTallo
                "'DIAMETRO_DEL_TALLO' TEXT," + // 2: diametroDelTallo
                "'DISPOSICION_DE_LAS_ESPINAS' TEXT," + // 3: disposicionDeLasEspinas
                "'FORMA_DEL_TALLO' TEXT," + // 4: formaDelTallo
                "'LONGITUD_ENTRENUDOS' TEXT," + // 5: longitudEntrenudos
                "'NATURALEZA_DEL_TALLO' TEXT," + // 6: naturalezaDelTallo
                "'DESCRIPCION' TEXT," + // 7: descripcion
                "'DESNUDO_CUBIERTO' INTEGER," + // 8: desnudoCubierto
                "'ENTRENUDOS_CONSPICUOS' INTEGER," + // 9: entrenudosConspicuos
                "'ESPINAS' INTEGER," + // 10: espinas
                "'COLOR_DEL_TALLO_ID' INTEGER);"); // 11: colorDelTalloID
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_TALLO_COLOR_DEL_TALLO_ID ON TALLO" +
                " (COLOR_DEL_TALLO_ID);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'TALLO'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Tallo entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String alturaDelTallo = entity.getAlturaDelTallo();
        if (alturaDelTallo != null) {
            stmt.bindString(2, alturaDelTallo);
        }
 
        String diametroDelTallo = entity.getDiametroDelTallo();
        if (diametroDelTallo != null) {
            stmt.bindString(3, diametroDelTallo);
        }
 
        String disposicionDeLasEspinas = entity.getDisposicionDeLasEspinas();
        if (disposicionDeLasEspinas != null) {
            stmt.bindString(4, disposicionDeLasEspinas);
        }
 
        String formaDelTallo = entity.getFormaDelTallo();
        if (formaDelTallo != null) {
            stmt.bindString(5, formaDelTallo);
        }
 
        String longitudEntrenudos = entity.getLongitudEntrenudos();
        if (longitudEntrenudos != null) {
            stmt.bindString(6, longitudEntrenudos);
        }
 
        String naturalezaDelTallo = entity.getNaturalezaDelTallo();
        if (naturalezaDelTallo != null) {
            stmt.bindString(7, naturalezaDelTallo);
        }
 
        String descripcion = entity.getDescripcion();
        if (descripcion != null) {
            stmt.bindString(8, descripcion);
        }
 
        Boolean desnudoCubierto = entity.getDesnudoCubierto();
        if (desnudoCubierto != null) {
            stmt.bindLong(9, desnudoCubierto ? 1l: 0l);
        }
 
        Boolean entrenudosConspicuos = entity.getEntrenudosConspicuos();
        if (entrenudosConspicuos != null) {
            stmt.bindLong(10, entrenudosConspicuos ? 1l: 0l);
        }
 
        Boolean espinas = entity.getEspinas();
        if (espinas != null) {
            stmt.bindLong(11, espinas ? 1l: 0l);
        }
 
        Long colorDelTalloID = entity.getColorDelTalloID();
        if (colorDelTalloID != null) {
            stmt.bindLong(12, colorDelTalloID);
        }
    }

    @Override
    protected void attachEntity(Tallo entity) {
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
    public Tallo readEntity(Cursor cursor, int offset) {
        Tallo entity = new Tallo();
        readEntity(cursor, entity, offset);
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Tallo entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setAlturaDelTallo(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDiametroDelTallo(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setDisposicionDeLasEspinas(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setFormaDelTallo(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setLongitudEntrenudos(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setNaturalezaDelTallo(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setDescripcion(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setDesnudoCubierto(cursor.isNull(offset + 8) ? null : cursor.getShort(offset + 8) != 0);
        entity.setEntrenudosConspicuos(cursor.isNull(offset + 9) ? null : cursor.getShort(offset + 9) != 0);
        entity.setEspinas(cursor.isNull(offset + 10) ? null : cursor.getShort(offset + 10) != 0);
        entity.setColorDelTalloID(cursor.isNull(offset + 11) ? null : cursor.getLong(offset + 11));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Tallo entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Tallo entity) {
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
            SqlUtils.appendColumns(builder, "T0", daoSession.getColorEspecimenDao().getAllColumns());
            builder.append(" FROM TALLO T");
            builder.append(" LEFT JOIN COLOR_ESPECIMEN T0 ON T.'COLOR_DEL_TALLO_ID'=T0.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Tallo loadCurrentDeep(Cursor cursor, boolean lock) {
        Tallo entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        ColorEspecimen colorDelTallo = loadCurrentOther(daoSession.getColorEspecimenDao(), cursor, offset);
        entity.setColorDelTallo(colorDelTallo);

        return entity;    
    }

    public Tallo loadDeep(Long key) {
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
    public List<Tallo> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Tallo> list = new ArrayList<Tallo>(count);
        
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
    
    protected List<Tallo> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Tallo> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
