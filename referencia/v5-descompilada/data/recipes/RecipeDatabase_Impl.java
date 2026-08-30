package com.easycompra.app.data.recipes;

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

/* JADX INFO: loaded from: classes6.dex */
public final class RecipeDatabase_Impl extends RecipeDatabase {
    private volatile RecipeDao _recipeDao;

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(final DatabaseConfiguration config) {
        SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) { // from class: com.easycompra.app.data.recipes.RecipeDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(final SupportSQLiteDatabase db) {
                db.execSQL("CREATE TABLE IF NOT EXISTS `recipes` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `category` TEXT NOT NULL, `photoUrl` TEXT NOT NULL, `prepTimeMinutes` INTEGER NOT NULL, `baseServings` INTEGER NOT NULL, `difficulty` TEXT NOT NULL, `notes` TEXT NOT NULL, `isFavorite` INTEGER NOT NULL, `createdAt` INTEGER NOT NULL, `updatedAt` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                db.execSQL("CREATE TABLE IF NOT EXISTS `recipe_ingredients` (`id` TEXT NOT NULL, `recipeId` TEXT NOT NULL, `name` TEXT NOT NULL, `baseQuantity` REAL NOT NULL, `unit` TEXT NOT NULL, `linkedProductId` TEXT, `ingredientNotes` TEXT NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`recipeId`) REFERENCES `recipes`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_recipe_ingredients_recipeId` ON `recipe_ingredients` (`recipeId`)");
                db.execSQL("CREATE TABLE IF NOT EXISTS `recipe_steps` (`id` TEXT NOT NULL, `recipeId` TEXT NOT NULL, `stepNumber` INTEGER NOT NULL, `description` TEXT NOT NULL, `timeMinutes` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`recipeId`) REFERENCES `recipes`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_recipe_steps_recipeId` ON `recipe_steps` (`recipeId`)");
                db.execSQL(RoomMasterTable.CREATE_QUERY);
                db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '2887bccaf9179f62cea89380e76c622b')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(final SupportSQLiteDatabase db) {
                db.execSQL("DROP TABLE IF EXISTS `recipes`");
                db.execSQL("DROP TABLE IF EXISTS `recipe_ingredients`");
                db.execSQL("DROP TABLE IF EXISTS `recipe_steps`");
                List<? extends RoomDatabase.Callback> _callbacks = RecipeDatabase_Impl.this.mCallbacks;
                if (_callbacks != null) {
                    for (RoomDatabase.Callback _callback : _callbacks) {
                        _callback.onDestructiveMigration(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onCreate(final SupportSQLiteDatabase db) {
                List<? extends RoomDatabase.Callback> _callbacks = RecipeDatabase_Impl.this.mCallbacks;
                if (_callbacks != null) {
                    for (RoomDatabase.Callback _callback : _callbacks) {
                        _callback.onCreate(db);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(final SupportSQLiteDatabase db) {
                RecipeDatabase_Impl.this.mDatabase = db;
                db.execSQL("PRAGMA foreign_keys = ON");
                RecipeDatabase_Impl.this.internalInitInvalidationTracker(db);
                List<? extends RoomDatabase.Callback> _callbacks = RecipeDatabase_Impl.this.mCallbacks;
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
                HashMap<String, TableInfo.Column> _columnsRecipes = new HashMap<>(11);
                _columnsRecipes.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, 1));
                _columnsRecipes.put(HintConstants.AUTOFILL_HINT_NAME, new TableInfo.Column(HintConstants.AUTOFILL_HINT_NAME, "TEXT", true, 0, null, 1));
                _columnsRecipes.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, 1));
                _columnsRecipes.put("photoUrl", new TableInfo.Column("photoUrl", "TEXT", true, 0, null, 1));
                _columnsRecipes.put("prepTimeMinutes", new TableInfo.Column("prepTimeMinutes", "INTEGER", true, 0, null, 1));
                _columnsRecipes.put("baseServings", new TableInfo.Column("baseServings", "INTEGER", true, 0, null, 1));
                _columnsRecipes.put("difficulty", new TableInfo.Column("difficulty", "TEXT", true, 0, null, 1));
                _columnsRecipes.put("notes", new TableInfo.Column("notes", "TEXT", true, 0, null, 1));
                _columnsRecipes.put("isFavorite", new TableInfo.Column("isFavorite", "INTEGER", true, 0, null, 1));
                _columnsRecipes.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, 1));
                _columnsRecipes.put("updatedAt", new TableInfo.Column("updatedAt", "INTEGER", true, 0, null, 1));
                HashSet<TableInfo.ForeignKey> _foreignKeysRecipes = new HashSet<>(0);
                HashSet<TableInfo.Index> _indicesRecipes = new HashSet<>(0);
                TableInfo _infoRecipes = new TableInfo("recipes", _columnsRecipes, _foreignKeysRecipes, _indicesRecipes);
                TableInfo _existingRecipes = TableInfo.read(db, "recipes");
                if (!_infoRecipes.equals(_existingRecipes)) {
                    return new RoomOpenHelper.ValidationResult(false, "recipes(com.easycompra.app.data.recipes.RecipeEntity).\n Expected:\n" + _infoRecipes + "\n Found:\n" + _existingRecipes);
                }
                HashMap<String, TableInfo.Column> _columnsRecipeIngredients = new HashMap<>(7);
                _columnsRecipeIngredients.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, 1));
                _columnsRecipeIngredients.put("recipeId", new TableInfo.Column("recipeId", "TEXT", true, 0, null, 1));
                _columnsRecipeIngredients.put(HintConstants.AUTOFILL_HINT_NAME, new TableInfo.Column(HintConstants.AUTOFILL_HINT_NAME, "TEXT", true, 0, null, 1));
                _columnsRecipeIngredients.put("baseQuantity", new TableInfo.Column("baseQuantity", "REAL", true, 0, null, 1));
                _columnsRecipeIngredients.put("unit", new TableInfo.Column("unit", "TEXT", true, 0, null, 1));
                _columnsRecipeIngredients.put("linkedProductId", new TableInfo.Column("linkedProductId", "TEXT", false, 0, null, 1));
                _columnsRecipeIngredients.put("ingredientNotes", new TableInfo.Column("ingredientNotes", "TEXT", true, 0, null, 1));
                HashSet<TableInfo.ForeignKey> _foreignKeysRecipeIngredients = new HashSet<>(1);
                _foreignKeysRecipeIngredients.add(new TableInfo.ForeignKey("recipes", "CASCADE", "NO ACTION", Arrays.asList("recipeId"), Arrays.asList("id")));
                HashSet<TableInfo.Index> _indicesRecipeIngredients = new HashSet<>(1);
                _indicesRecipeIngredients.add(new TableInfo.Index("index_recipe_ingredients_recipeId", false, Arrays.asList("recipeId"), Arrays.asList("ASC")));
                TableInfo _infoRecipeIngredients = new TableInfo("recipe_ingredients", _columnsRecipeIngredients, _foreignKeysRecipeIngredients, _indicesRecipeIngredients);
                TableInfo _existingRecipeIngredients = TableInfo.read(db, "recipe_ingredients");
                if (!_infoRecipeIngredients.equals(_existingRecipeIngredients)) {
                    return new RoomOpenHelper.ValidationResult(false, "recipe_ingredients(com.easycompra.app.data.recipes.IngredientEntity).\n Expected:\n" + _infoRecipeIngredients + "\n Found:\n" + _existingRecipeIngredients);
                }
                HashMap<String, TableInfo.Column> _columnsRecipeSteps = new HashMap<>(5);
                _columnsRecipeSteps.put("id", new TableInfo.Column("id", "TEXT", true, 1, null, 1));
                _columnsRecipeSteps.put("recipeId", new TableInfo.Column("recipeId", "TEXT", true, 0, null, 1));
                _columnsRecipeSteps.put("stepNumber", new TableInfo.Column("stepNumber", "INTEGER", true, 0, null, 1));
                _columnsRecipeSteps.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, 1));
                _columnsRecipeSteps.put("timeMinutes", new TableInfo.Column("timeMinutes", "INTEGER", true, 0, null, 1));
                HashSet<TableInfo.ForeignKey> _foreignKeysRecipeSteps = new HashSet<>(1);
                _foreignKeysRecipeSteps.add(new TableInfo.ForeignKey("recipes", "CASCADE", "NO ACTION", Arrays.asList("recipeId"), Arrays.asList("id")));
                HashSet<TableInfo.Index> _indicesRecipeSteps = new HashSet<>(1);
                _indicesRecipeSteps.add(new TableInfo.Index("index_recipe_steps_recipeId", false, Arrays.asList("recipeId"), Arrays.asList("ASC")));
                TableInfo _infoRecipeSteps = new TableInfo("recipe_steps", _columnsRecipeSteps, _foreignKeysRecipeSteps, _indicesRecipeSteps);
                TableInfo _existingRecipeSteps = TableInfo.read(db, "recipe_steps");
                if (!_infoRecipeSteps.equals(_existingRecipeSteps)) {
                    return new RoomOpenHelper.ValidationResult(false, "recipe_steps(com.easycompra.app.data.recipes.RecipeStepEntity).\n Expected:\n" + _infoRecipeSteps + "\n Found:\n" + _existingRecipeSteps);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "2887bccaf9179f62cea89380e76c622b", "d33e489dbc6cb98aed67346522ac310c");
        SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
        SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
        return _helper;
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        HashMap<String, String> _shadowTablesMap = new HashMap<>(0);
        HashMap<String, Set<String>> _viewTables = new HashMap<>(0);
        return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "recipes", "recipe_ingredients", "recipe_steps");
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
        _db.execSQL("DELETE FROM `recipes`");
        _db.execSQL("DELETE FROM `recipe_ingredients`");
        _db.execSQL("DELETE FROM `recipe_steps`");
        super.setTransactionSuccessful();
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<>();
        _typeConvertersMap.put(RecipeDao.class, RecipeDao_Impl.getRequiredConverters());
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

    @Override // com.easycompra.app.data.recipes.RecipeDatabase
    public RecipeDao recipeDao() {
        RecipeDao recipeDao;
        if (this._recipeDao != null) {
            return this._recipeDao;
        }
        synchronized (this) {
            if (this._recipeDao == null) {
                this._recipeDao = new RecipeDao_Impl(this);
            }
            recipeDao = this._recipeDao;
        }
        return recipeDao;
    }
}
