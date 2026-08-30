package com.easycompra.app.data.pantry;

import androidx.autofill.HintConstants;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes11.dex */
public final class PantryDatabase_Impl extends PantryDatabase {
    private volatile PantryDao _pantryDao;

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(final DatabaseConfiguration config) {
        SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) { // from class: com.easycompra.app.data.pantry.PantryDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(final SupportSQLiteDatabase db) {
                db.execSQL("CREATE TABLE IF NOT EXISTS `pantry_products` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `needsToBuy` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `pantry_locations` (`id` TEXT NOT NULL, `productId` TEXT NOT NULL, `category` TEXT NOT NULL, `subcategory` TEXT NOT NULL, `description` TEXT NOT NULL, `quantity` REAL NOT NULL, `unit` TEXT NOT NULL, `updatedAt` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`productId`) REFERENCES `pantry_products`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_pantry_locations_productId` ON `pantry_locations` (`productId`)");
                db.execSQL(RoomMasterTable.CREATE_QUERY);
                db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '6902f1f3b70433cfc6582ef508f7e1b3')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(final SupportSQLiteDatabase db) {
                db.execSQL("DROP TABLE IF EXISTS `pantry_products`");
                db.execSQL("DROP TABLE IF EXISTS `pantry_locations`");
                List<? extends RoomDatabase.Callback> _callbacks = PantryDatabase_Impl.this.mCallbacks;
                if (_callbacks != null) {
                    for (RoomDatabase.Callback _callback : _callbacks) {
                        _callback.onDestructiveMigration(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(final SupportSQLiteDatabase db) {
                List<? extends RoomDatabase.Callback> _callbacks = PantryDatabase_Impl.this.mCallbacks;
                if (_callbacks != null) {
                    for (RoomDatabase.Callback _callback : _callbacks) {
                        _callback.onCreate(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(final SupportSQLiteDatabase db) {
                PantryDatabase_Impl.this.mDatabase = db;
                db.execSQL("PRAGMA foreign_keys = ON");
                PantryDatabase_Impl.this.internalInitInvalidationTracker(db);
                List<? extends RoomDatabase.Callback> _callbacks = PantryDatabase_Impl.this.mCallbacks;
                if (_callbacks != null) {
                    for (RoomDatabase.Callback _callback : _callbacks) {
                        _callback.onOpen(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(final SupportSQLiteDatabase db) {
                DBUtil.dropFtsSyncTriggers(db);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(final SupportSQLiteDatabase db) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public RoomOpenHelper.ValidationResult onValidateSchema(final SupportSQLiteDatabase db) {
                HashMap<String, TableInfo.Column> _columnsPantryProducts = new HashMap<>(4);
                _columnsPantryProducts.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, 1));
                _columnsPantryProducts.put(HintConstants.AUTOFILL_HINT_NAME, new TableInfo.Column(HintConstants.AUTOFILL_HINT_NAME, "TEXT", true, 0, null, 1));
                _columnsPantryProducts.put("needsToBuy", new TableInfo.Column("needsToBuy", "INTEGER", true, 0, null, 1));
                _columnsPantryProducts.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, 1));
                HashSet<TableInfo.ForeignKey> _foreignKeysPantryProducts = new HashSet<>(0);
                HashSet<TableInfo.Index> _indicesPantryProducts = new HashSet<>(0);
                TableInfo _infoPantryProducts = new TableInfo("pantry_products", _columnsPantryProducts, _foreignKeysPantryProducts, _indicesPantryProducts);
                TableInfo _existingPantryProducts = TableInfo.read(db, "pantry_products");
                if (!_infoPantryProducts.equals(_existingPantryProducts)) {
                    return new RoomOpenHelper.ValidationResult(false, "pantry_products(com.easycompra.app.data.pantry.PantryProductEntity).\n Expected:\n" + _infoPantryProducts + "\n Found:\n" + _existingPantryProducts);
                }
                HashMap<String, TableInfo.Column> _columnsPantryLocations = new HashMap<>(8);
                _columnsPantryLocations.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, 1));
                _columnsPantryLocations.put("productId", new TableInfo.Column("productId", "TEXT", true, 0, null, 1));
                _columnsPantryLocations.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, 1));
                _columnsPantryLocations.put("subcategory", new TableInfo.Column("subcategory", "TEXT", true, 0, null, 1));
                _columnsPantryLocations.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, 1));
                _columnsPantryLocations.put("quantity", new TableInfo.Column("quantity", "REAL", true, 0, null, 1));
                _columnsPantryLocations.put("unit", new TableInfo.Column("unit", "TEXT", true, 0, null, 1));
                _columnsPantryLocations.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, 1));
                HashSet<TableInfo.ForeignKey> _foreignKeysPantryLocations = new HashSet<>(1);
                _foreignKeysPantryLocations.add(new TableInfo.ForeignKey("pantry_products", "CASCADE", "NO ACTION", Arrays.asList("productId"), Arrays.asList("id")));
                HashSet<TableInfo.Index> _indicesPantryLocations = new HashSet<>(1);
                _indicesPantryLocations.add(new TableInfo.Index("index_pantry_locations_productId", false, Arrays.asList("productId"), Arrays.asList("ASC")));
                TableInfo _infoPantryLocations = new TableInfo("pantry_locations", _columnsPantryLocations, _foreignKeysPantryLocations, _indicesPantryLocations);
                TableInfo _existingPantryLocations = TableInfo.read(db, "pantry_locations");
                if (!_infoPantryLocations.equals(_existingPantryLocations)) {
                    return new RoomOpenHelper.ValidationResult(false, "pantry_locations(com.easycompra.app.data.pantry.PantryLocationEntity).\n Expected:\n" + _infoPantryLocations + "\n Found:\n" + _existingPantryLocations);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "6902f1f3b70433cfc6582ef508f7e1b3", "5c3060df1ae2b89841924e67bc960793");
        SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
        SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
        return _helper;
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        HashMap<String, String> _shadowTablesMap = new HashMap<>(0);
        HashMap<String, Set<String>> _viewTables = new HashMap<>(0);
        return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "pantry_products", "pantry_locations");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
        if (1 == 0) {
            try {
                _db.execSQL("PRAGMA foreign_keys = FALSE");
            } finally {
                super.endTransaction();
                if (1 == 0) {
                    _db.execSQL("PRAGMA foreign_keys = TRUE");
                }
                _db.query("PRAGMA wal_checkpoint(FULL)").close();
                if (!_db.inTransaction()) {
                    _db.execSQL("VACUUM");
                }
            }
        }
        super.beginTransaction();
        if (1 != 0) {
            _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
        }
        _db.execSQL("DELETE FROM `pantry_products`");
        _db.execSQL("DELETE FROM `pantry_locations`");
        super.setTransactionSuccessful();
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<>();
        _typeConvertersMap.put(PantryDao.class, PantryDao_Impl.getRequiredConverters());
        return _typeConvertersMap;
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<>();
        return _autoMigrationSpecsSet;
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
        List<Migration> _autoMigrations = new ArrayList<>();
        return _autoMigrations;
    }

    @Override // com.easycompra.app.data.pantry.PantryDatabase
    public PantryDao pantryDao() {
        PantryDao pantryDao;
        if (this._pantryDao != null) {
            return this._pantryDao;
        }
        synchronized (this) {
            if (this._pantryDao == null) {
                this._pantryDao = new PantryDao_Impl(this);
            }
            pantryDao = this._pantryDao;
        }
        return pantryDao;
    }
}
