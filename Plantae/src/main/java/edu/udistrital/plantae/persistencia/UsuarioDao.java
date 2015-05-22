package edu.udistrital.plantae.persistencia;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import edu.udistrital.plantae.logicadominio.autenticacion.Usuario;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table USUARIO.
*/
public class UsuarioDao extends AbstractDao<Usuario, Long> {

    public static final String TABLENAME = "USUARIO";

    /**
     * Properties of entity Usuario.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property NombreUsuario = new Property(1, String.class, "nombreUsuario", false, "NOMBRE_USUARIO");
        public final static Property Contraseña = new Property(2, String.class, "contraseña", false, "CONTRASEÑA");
    };

    private DaoSession daoSession;


    public UsuarioDao(DaoConfig config) {
        super(config);
    }
    
    public UsuarioDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'USUARIO' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'NOMBRE_USUARIO' TEXT UNIQUE ," + // 1: nombreUsuario
                "'CONTRASEÑA' TEXT);"); // 2: contraseña
        // Add Indexes
        db.execSQL("CREATE INDEX " + constraint + "IDX_USUARIO_NOMBRE_USUARIO ON USUARIO" +
                " (NOMBRE_USUARIO);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'USUARIO'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Usuario entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String nombreUsuario = entity.getNombreUsuario();
        if (nombreUsuario != null) {
            stmt.bindString(2, nombreUsuario);
        }
 
        String contraseña = entity.getContraseña();
        if (contraseña != null) {
            stmt.bindString(3, contraseña);
        }
    }

    @Override
    protected void attachEntity(Usuario entity) {
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
    public Usuario readEntity(Cursor cursor, int offset) {
        Usuario entity = Usuario.getUsuario(null, null);
        readEntity(cursor, entity, offset);
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Usuario entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setNombreUsuario(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setContraseña(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Usuario entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Usuario entity) {
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

}
