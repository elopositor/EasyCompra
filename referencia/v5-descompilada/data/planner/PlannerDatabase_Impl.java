package com.easycompra.app.data.planner;

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

/* JADX INFO: loaded from: classes15.dex */
public final class PlannerDatabase_Impl extends PlannerDatabase {
    private volatile PlannerDao _plannerDao;

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(final DatabaseConfiguration config) {
        SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) { // from class: com.easycompra.app.data.planner.PlannerDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(final SupportSQLiteDatabase db) {
                db.execSQL("CREATE TABLE IF NOT EXISTS `planner_entries` (`id` TEXT NOT NULL, `date` TEXT NOT NULL, `mealSlot` TEXT NOT NULL, `recipeId` TEXT, `displayName` TEXT NOT NULL, `servings` REAL NOT NULL, `notes` TEXT NOT NULL, `createdAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_planner_entries_date` ON `planner_entries` (`date`)");
                db.execSQL(RoomMasterTable.CREATE_QUERY);
                db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '8b5b77d0520f8d35c8e8015ea882fe0e')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(final SupportSQLiteDatabase db) {
                db.execSQL("DROP TABLE IF EXISTS `planner_entries`");
                List<? extends RoomDatabase.Callback> _callbacks = PlannerDatabase_Impl.this.mCallbacks;
                if (_callbacks != null) {
                    for (RoomDatabase.Callback _callback : _callbacks) {
                        _callback.onDestructiveMigration(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(final SupportSQLiteDatabase db) {
                List<? extends RoomDatabase.Callback> _callbacks = PlannerDatabase_Impl.this.mCallbacks;
                if (_callbacks != null) {
                    for (RoomDatabase.Callback _callback : _callbacks) {
                        _callback.onCreate(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(final SupportSQLiteDatabase db) {
                PlannerDatabase_Impl.this.mDatabase = db;
                PlannerDatabase_Impl.this.internalInitInvalidationTracker(db);
                List<? extends RoomDatabase.Callback> _callbacks = PlannerDatabase_Impl.this.mCallbacks;
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
                HashMap<String, TableInfo.Column> _columnsPlannerEntries = new HashMap<>(8);
                _columnsPlannerEntries.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, 1));
                _columnsPlannerEntries.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, 1));
                _columnsPlannerEntries.put("mealSlot", new TableInfo.Column("mealSlot", "TEXT", true, 0, null, 1));
                _columnsPlannerEntries.put("recipeId", new TableInfo.Column("recipeId", "TEXT", false, 0, null, 1));
                _columnsPlannerEntries.put("displayName", new TableInfo.Column("displayName", "TEXT", true, 0, null, 1));
                _columnsPlannerEntries.put("servings", new TableInfo.Column("servings", "REAL", true, 0, null, 1));
                _columnsPlannerEntries.put("notes", new TableInfo.Column("notes", "TEXT", true, 0, null, 1));
                _columnsPlannerEntries.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, 1));
                HashSet<TableInfo.ForeignKey> _foreignKeysPlannerEntries = new HashSet<>(0);
                HashSet<TableInfo.Index> _indicesPlannerEntries = new HashSet<>(1);
                _indicesPlannerEntries.add(new TableInfo.Index("index_planner_entries_date", false, Arrays.asList("date"), Arrays.asList("ASC")));
                TableInfo _infoPlannerEntries = new TableInfo("planner_entries", _columnsPlannerEntries, _foreignKeysPlannerEntries, _indicesPlannerEntries);
                TableInfo _existingPlannerEntries = TableInfo.read(db, "planner_entries");
                if (!_infoPlannerEntries.equals(_existingPlannerEntries)) {
                    return new RoomOpenHelper.ValidationResult(false, "planner_entries(com.easycompra.app.data.planner.PlannerEntry).\n Expected:\n" + _infoPlannerEntries + "\n Found:\n" + _existingPlannerEntries);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "8b5b77d0520f8d35c8e8015ea882fe0e", "4cf2c7a94e215b502dc01c6d60697561");
        SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
        SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
        return _helper;
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        HashMap<String, String> _shadowTablesMap = new HashMap<>(0);
        HashMap<String, Set<String>> _viewTables = new HashMap<>(0);
        return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "planner_entries");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            _db.execSQL("DELETE FROM `planner_entries`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            _db.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!_db.inTransaction()) {
                _db.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<>();
        _typeConvertersMap.put(PlannerDao.class, PlannerDao_Impl.getRequiredConverters());
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

    @Override // com.easycompra.app.data.planner.PlannerDatabase
    public PlannerDao plannerDao() {
        PlannerDao plannerDao;
        if (this._plannerDao != null) {
            return this._plannerDao;
        }
        synchronized (this) {
            if (this._plannerDao == null) {
                this._plannerDao = new PlannerDao_Impl(this);
            }
            plannerDao = this._plannerDao;
        }
        return plannerDao;
    }
}
