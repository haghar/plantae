package edu.udistrital.plantae.persistencia;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.internal.SqlUtils;
import edu.udistrital.plantae.logicadominio.datosespecimen.ColorEspecimen;
import edu.udistrital.plantae.logicadominio.datosespecimen.Inflorescencia;

import java.util.ArrayList;
import java.util.List;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table INFLORESCENCIA.
*/
public class InflorescenciaDao extends AbstractDao<Inflorescencia, Long> {

    public static final String TABLENAME = "INFLORESCENCIA";

    /**
     * Properties of entity Inflorescencia.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property NaturalezaDeLasBracteasPedunculares = new Property(1, String.class, "naturalezaDeLasBracteasPedunculares", false, "NATURALEZA_DE_LAS_BRACTEAS_PEDUNCULARES");
        public final static Property NaturalezaDelProfilo = new Property(2, String.class, "naturalezaDelProfilo", false, "NATURALEZA_DEL_PROFILO");
        public final static Property PosicionDeLasBracteasPedunculares = new Property(3, String.class, "posicionDeLasBracteasPedunculares", false, "POSICION_DE_LAS_BRACTEAS_PEDUNCULARES");
        public final static Property PosicionDeLasInflorescencias = new Property(4, String.class, "posicionDeLasInflorescencias", false, "POSICION_DE_LAS_INFLORESCENCIAS");
        public final static Property Raquilas = new Property(5, String.class, "raquilas", false, "RAQUILAS");
        public final static Property Raquis = new Property(6, String.class, "raquis", false, "RAQUIS");
        public final static Property TamañoDeLasBracteasPedunculares = new Property(7, String.class, "tamañoDeLasBracteasPedunculares", false, "TAMAÑO_DE_LAS_BRACTEAS_PEDUNCULARES");
        public final static Property TamañoDelPedunculo = new Property(8, String.class, "tamañoDelPedunculo", false, "TAMAÑO_DEL_PEDUNCULO");
        public final static Property TamañoDelProfilo = new Property(9, String.class, "tamañoDelProfilo", false, "TAMAÑO_DEL_PROFILO");
        public final static Property TamañoDelRaquis = new Property(10, String.class, "tamañoDelRaquis", false, "TAMAÑO_DEL_RAQUIS");
        public final static Property TamañoDeRaquilas = new Property(11, String.class, "tamañoDeRaquilas", false, "TAMAÑO_DE_RAQUILAS");
        public final static Property Descripcion = new Property(12, String.class, "descripcion", false, "DESCRIPCION");
        public final static Property InflorescenciaSolitaria = new Property(13, Boolean.class, "inflorescenciaSolitaria", false, "INFLORESCENCIA_SOLITARIA");
        public final static Property NumeroDeLasBracteasPedunculares = new Property(14, Integer.class, "numeroDeLasBracteasPedunculares", false, "NUMERO_DE_LAS_BRACTEAS_PEDUNCULARES");
        public final static Property NumeroDeRaquilas = new Property(15, Integer.class, "numeroDeRaquilas", false, "NUMERO_DE_RAQUILAS");
        public final static Property ColorDeLaInflorescenciaEnFlorID = new Property(16, Long.class, "colorDeLaInflorescenciaEnFlorID", false, "COLOR_DE_LA_INFLORESCENCIA_EN_FLOR_ID");
        public final static Property ColorDeLaInflorescenciaEnFrutoID = new Property(17, Long.class, "colorDeLaInflorescenciaEnFrutoID", false, "COLOR_DE_LA_INFLORESCENCIA_EN_FRUTO_ID");
    };

    private DaoSession daoSession;


    public InflorescenciaDao(DaoConfig config) {
        super(config);
    }
    
    public InflorescenciaDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'INFLORESCENCIA' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'NATURALEZA_DE_LAS_BRACTEAS_PEDUNCULARES' TEXT," + // 1: naturalezaDeLasBracteasPedunculares
                "'NATURALEZA_DEL_PROFILO' TEXT," + // 2: naturalezaDelProfilo
                "'POSICION_DE_LAS_BRACTEAS_PEDUNCULARES' TEXT," + // 3: posicionDeLasBracteasPedunculares
                "'POSICION_DE_LAS_INFLORESCENCIAS' TEXT," + // 4: posicionDeLasInflorescencias
                "'RAQUILAS' TEXT," + // 5: raquilas
                "'RAQUIS' TEXT," + // 6: raquis
                "'TAMAÑO_DE_LAS_BRACTEAS_PEDUNCULARES' TEXT," + // 7: tamañoDeLasBracteasPedunculares
                "'TAMAÑO_DEL_PEDUNCULO' TEXT," + // 8: tamañoDelPedunculo
                "'TAMAÑO_DEL_PROFILO' TEXT," + // 9: tamañoDelProfilo
                "'TAMAÑO_DEL_RAQUIS' TEXT," + // 10: tamañoDelRaquis
                "'TAMAÑO_DE_RAQUILAS' TEXT," + // 11: tamañoDeRaquilas
                "'DESCRIPCION' TEXT," + // 12: descripcion
                "'INFLORESCENCIA_SOLITARIA' INTEGER," + // 13: inflorescenciaSolitaria
                "'NUMERO_DE_LAS_BRACTEAS_PEDUNCULARES' INTEGER," + // 14: numeroDeLasBracteasPedunculares
                "'NUMERO_DE_RAQUILAS' INTEGER," + // 15: numeroDeRaquilas
                "'COLOR_DE_LA_INFLORESCENCIA_EN_FLOR_ID' INTEGER," + // 16: colorDeLaInflorescenciaEnFlorID
                "'COLOR_DE_LA_INFLORESCENCIA_EN_FRUTO_ID' INTEGER);"); // 17: colorDeLaInflorescenciaEnFrutoID
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_INFLORESCENCIA_COLOR_DE_LA_INFLORESCENCIA_EN_FLOR_ID ON INFLORESCENCIA" +
                " (COLOR_DE_LA_INFLORESCENCIA_EN_FLOR_ID);");
        db.execSQL("CREATE INDEX " + constraint + "IDX_INFLORESCENCIA_COLOR_DE_LA_INFLORESCENCIA_EN_FRUTO_ID ON INFLORESCENCIA" +
                " (COLOR_DE_LA_INFLORESCENCIA_EN_FRUTO_ID);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'INFLORESCENCIA'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Inflorescencia entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String naturalezaDeLasBracteasPedunculares = entity.getNaturalezaDeLasBracteasPedunculares();
        if (naturalezaDeLasBracteasPedunculares != null) {
            stmt.bindString(2, naturalezaDeLasBracteasPedunculares);
        }
 
        String naturalezaDelProfilo = entity.getNaturalezaDelProfilo();
        if (naturalezaDelProfilo != null) {
            stmt.bindString(3, naturalezaDelProfilo);
        }
 
        String posicionDeLasBracteasPedunculares = entity.getPosicionDeLasBracteasPedunculares();
        if (posicionDeLasBracteasPedunculares != null) {
            stmt.bindString(4, posicionDeLasBracteasPedunculares);
        }
 
        String posicionDeLasInflorescencias = entity.getPosicionDeLasInflorescencias();
        if (posicionDeLasInflorescencias != null) {
            stmt.bindString(5, posicionDeLasInflorescencias);
        }
 
        String raquilas = entity.getRaquilas();
        if (raquilas != null) {
            stmt.bindString(6, raquilas);
        }
 
        String raquis = entity.getRaquis();
        if (raquis != null) {
            stmt.bindString(7, raquis);
        }
 
        String tamañoDeLasBracteasPedunculares = entity.getTamañoDeLasBracteasPedunculares();
        if (tamañoDeLasBracteasPedunculares != null) {
            stmt.bindString(8, tamañoDeLasBracteasPedunculares);
        }
 
        String tamañoDelPedunculo = entity.getTamañoDelPedunculo();
        if (tamañoDelPedunculo != null) {
            stmt.bindString(9, tamañoDelPedunculo);
        }
 
        String tamañoDelProfilo = entity.getTamañoDelProfilo();
        if (tamañoDelProfilo != null) {
            stmt.bindString(10, tamañoDelProfilo);
        }
 
        String tamañoDelRaquis = entity.getTamañoDelRaquis();
        if (tamañoDelRaquis != null) {
            stmt.bindString(11, tamañoDelRaquis);
        }
 
        String tamañoDeRaquilas = entity.getTamañoDeRaquilas();
        if (tamañoDeRaquilas != null) {
            stmt.bindString(12, tamañoDeRaquilas);
        }
 
        String descripcion = entity.getDescripcion();
        if (descripcion != null) {
            stmt.bindString(13, descripcion);
        }
 
        Boolean inflorescenciaSolitaria = entity.getInflorescenciaSolitaria();
        if (inflorescenciaSolitaria != null) {
            stmt.bindLong(14, inflorescenciaSolitaria ? 1l: 0l);
        }
 
        Integer numeroDeLasBracteasPedunculares = entity.getNumeroDeLasBracteasPedunculares();
        if (numeroDeLasBracteasPedunculares != null) {
            stmt.bindLong(15, numeroDeLasBracteasPedunculares);
        }
 
        Integer numeroDeRaquilas = entity.getNumeroDeRaquilas();
        if (numeroDeRaquilas != null) {
            stmt.bindLong(16, numeroDeRaquilas);
        }
 
        Long colorDeLaInflorescenciaEnFlorID = entity.getColorDeLaInflorescenciaEnFlorID();
        if (colorDeLaInflorescenciaEnFlorID != null) {
            stmt.bindLong(17, colorDeLaInflorescenciaEnFlorID);
        }
 
        Long colorDeLaInflorescenciaEnFrutoID = entity.getColorDeLaInflorescenciaEnFrutoID();
        if (colorDeLaInflorescenciaEnFrutoID != null) {
            stmt.bindLong(18, colorDeLaInflorescenciaEnFrutoID);
        }
    }

    @Override
    protected void attachEntity(Inflorescencia entity) {
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
    public Inflorescencia readEntity(Cursor cursor, int offset) {
        Inflorescencia entity = new Inflorescencia();
        readEntity(cursor, entity, offset);
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Inflorescencia entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setNaturalezaDeLasBracteasPedunculares(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setNaturalezaDelProfilo(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setPosicionDeLasBracteasPedunculares(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setPosicionDeLasInflorescencias(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setRaquilas(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setRaquis(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setTamañoDeLasBracteasPedunculares(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setTamañoDelPedunculo(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setTamañoDelProfilo(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setTamañoDelRaquis(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setTamañoDeRaquilas(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setDescripcion(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setInflorescenciaSolitaria(cursor.isNull(offset + 13) ? null : cursor.getShort(offset + 13) != 0);
        entity.setNumeroDeLasBracteasPedunculares(cursor.isNull(offset + 14) ? null : cursor.getInt(offset + 14));
        entity.setNumeroDeRaquilas(cursor.isNull(offset + 15) ? null : cursor.getInt(offset + 15));
        entity.setColorDeLaInflorescenciaEnFlorID(cursor.isNull(offset + 16) ? null : cursor.getLong(offset + 16));
        entity.setColorDeLaInflorescenciaEnFrutoID(cursor.isNull(offset + 17) ? null : cursor.getLong(offset + 17));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Inflorescencia entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Inflorescencia entity) {
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
            builder.append(',');
            SqlUtils.appendColumns(builder, "T1", daoSession.getColorEspecimenDao().getAllColumns());
            builder.append(" FROM INFLORESCENCIA T");
            builder.append(" LEFT JOIN COLOR_ESPECIMEN T0 ON T.'COLOR_DE_LA_INFLORESCENCIA_EN_FLOR_ID'=T0.'_id'");
            builder.append(" LEFT JOIN COLOR_ESPECIMEN T1 ON T.'COLOR_DE_LA_INFLORESCENCIA_EN_FRUTO_ID'=T1.'_id'");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected Inflorescencia loadCurrentDeep(Cursor cursor, boolean lock) {
        Inflorescencia entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        ColorEspecimen colorDeLaInflorescenciaEnFlor = loadCurrentOther(daoSession.getColorEspecimenDao(), cursor, offset);
        entity.setColorDeLaInflorescenciaEnFlor(colorDeLaInflorescenciaEnFlor);
        offset += daoSession.getColorEspecimenDao().getAllColumns().length;

        ColorEspecimen colorDeLaInflorescenciaEnFruto = loadCurrentOther(daoSession.getColorEspecimenDao(), cursor, offset);
        entity.setColorDeLaInflorescenciaEnFruto(colorDeLaInflorescenciaEnFruto);

        return entity;    
    }

    public Inflorescencia loadDeep(Long key) {
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
    public List<Inflorescencia> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<Inflorescencia> list = new ArrayList<Inflorescencia>(count);
        
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
    
    protected List<Inflorescencia> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<Inflorescencia> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}