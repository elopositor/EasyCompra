package com.easycompra.app.data.recipes;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.autofill.HintConstants;
import androidx.collection.ArrayMap;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.RelationUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes6.dex */
public final class RecipeDao_Impl implements RecipeDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<IngredientEntity> __insertionAdapterOfIngredientEntity;
    private final EntityInsertionAdapter<RecipeEntity> __insertionAdapterOfRecipeEntity;
    private final EntityInsertionAdapter<RecipeStepEntity> __insertionAdapterOfRecipeStepEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteIngredientsOf;
    private final SharedSQLiteStatement __preparedStmtOfDeleteRecipe;
    private final SharedSQLiteStatement __preparedStmtOfDeleteStepsOf;
    private final SharedSQLiteStatement __preparedStmtOfSetFavorite;
    private final EntityDeletionOrUpdateAdapter<RecipeEntity> __updateAdapterOfRecipeEntity;

    public RecipeDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfRecipeEntity = new EntityInsertionAdapter<RecipeEntity>(__db) { // from class: com.easycompra.app.data.recipes.RecipeDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `recipes` (`id`,`name`,`category`,`photoUrl`,`prepTimeMinutes`,`baseServings`,`difficulty`,`notes`,`isFavorite`,`createdAt`,`updatedAt`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, RecipeEntity recipeEntity) {
                supportSQLiteStatement.bindString(1, recipeEntity.getId());
                supportSQLiteStatement.bindString(2, recipeEntity.getName());
                supportSQLiteStatement.bindString(3, recipeEntity.getCategory());
                supportSQLiteStatement.bindString(4, recipeEntity.getPhotoUrl());
                supportSQLiteStatement.bindLong(5, recipeEntity.getPrepTimeMinutes());
                supportSQLiteStatement.bindLong(6, recipeEntity.getBaseServings());
                supportSQLiteStatement.bindString(7, recipeEntity.getDifficulty());
                supportSQLiteStatement.bindString(8, recipeEntity.getNotes());
                supportSQLiteStatement.bindLong(9, recipeEntity.isFavorite() ? 1L : 0L);
                supportSQLiteStatement.bindLong(10, recipeEntity.getCreatedAt());
                supportSQLiteStatement.bindLong(11, recipeEntity.getUpdatedAt());
            }
        };
        this.__insertionAdapterOfIngredientEntity = new EntityInsertionAdapter<IngredientEntity>(__db) { // from class: com.easycompra.app.data.recipes.RecipeDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `recipe_ingredients` (`id`,`recipeId`,`name`,`baseQuantity`,`unit`,`linkedProductId`,`ingredientNotes`) VALUES (?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final IngredientEntity entity) {
                statement.bindString(1, entity.getId());
                statement.bindString(2, entity.getRecipeId());
                statement.bindString(3, entity.getName());
                statement.bindDouble(4, entity.getBaseQuantity());
                statement.bindString(5, entity.getUnit());
                if (entity.getLinkedProductId() == null) {
                    statement.bindNull(6);
                } else {
                    statement.bindString(6, entity.getLinkedProductId());
                }
                statement.bindString(7, entity.getIngredientNotes());
            }
        };
        this.__insertionAdapterOfRecipeStepEntity = new EntityInsertionAdapter<RecipeStepEntity>(__db) { // from class: com.easycompra.app.data.recipes.RecipeDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `recipe_steps` (`id`,`recipeId`,`stepNumber`,`description`,`timeMinutes`) VALUES (?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final RecipeStepEntity entity) {
                statement.bindString(1, entity.getId());
                statement.bindString(2, entity.getRecipeId());
                statement.bindLong(3, entity.getStepNumber());
                statement.bindString(4, entity.getDescription());
                statement.bindLong(5, entity.getTimeMinutes());
            }
        };
        this.__updateAdapterOfRecipeEntity = new EntityDeletionOrUpdateAdapter<RecipeEntity>(__db) { // from class: com.easycompra.app.data.recipes.RecipeDao_Impl.4
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `recipes` SET `id` = ?,`name` = ?,`category` = ?,`photoUrl` = ?,`prepTimeMinutes` = ?,`baseServings` = ?,`difficulty` = ?,`notes` = ?,`isFavorite` = ?,`createdAt` = ?,`updatedAt` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, RecipeEntity recipeEntity) {
                supportSQLiteStatement.bindString(1, recipeEntity.getId());
                supportSQLiteStatement.bindString(2, recipeEntity.getName());
                supportSQLiteStatement.bindString(3, recipeEntity.getCategory());
                supportSQLiteStatement.bindString(4, recipeEntity.getPhotoUrl());
                supportSQLiteStatement.bindLong(5, recipeEntity.getPrepTimeMinutes());
                supportSQLiteStatement.bindLong(6, recipeEntity.getBaseServings());
                supportSQLiteStatement.bindString(7, recipeEntity.getDifficulty());
                supportSQLiteStatement.bindString(8, recipeEntity.getNotes());
                supportSQLiteStatement.bindLong(9, recipeEntity.isFavorite() ? 1L : 0L);
                supportSQLiteStatement.bindLong(10, recipeEntity.getCreatedAt());
                supportSQLiteStatement.bindLong(11, recipeEntity.getUpdatedAt());
                supportSQLiteStatement.bindString(12, recipeEntity.getId());
            }
        };
        this.__preparedStmtOfSetFavorite = new SharedSQLiteStatement(__db) { // from class: com.easycompra.app.data.recipes.RecipeDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE recipes SET isFavorite = ?, updatedAt = ? WHERE id = ?";
            }
        };
        this.__preparedStmtOfDeleteIngredientsOf = new SharedSQLiteStatement(__db) { // from class: com.easycompra.app.data.recipes.RecipeDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM recipe_ingredients WHERE recipeId = ?";
            }
        };
        this.__preparedStmtOfDeleteStepsOf = new SharedSQLiteStatement(__db) { // from class: com.easycompra.app.data.recipes.RecipeDao_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM recipe_steps WHERE recipeId = ?";
            }
        };
        this.__preparedStmtOfDeleteRecipe = new SharedSQLiteStatement(__db) { // from class: com.easycompra.app.data.recipes.RecipeDao_Impl.8
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM recipes WHERE id = ?";
            }
        };
    }

    @Override // com.easycompra.app.data.recipes.RecipeDao
    public Object insertRecipe(final RecipeEntity recipe, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.easycompra.app.data.recipes.RecipeDao_Impl.9
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                RecipeDao_Impl.this.__db.beginTransaction();
                try {
                    RecipeDao_Impl.this.__insertionAdapterOfRecipeEntity.insert(recipe);
                    RecipeDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    RecipeDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.easycompra.app.data.recipes.RecipeDao
    public Object insertIngredient(final IngredientEntity ingredient, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.easycompra.app.data.recipes.RecipeDao_Impl.10
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                RecipeDao_Impl.this.__db.beginTransaction();
                try {
                    RecipeDao_Impl.this.__insertionAdapterOfIngredientEntity.insert(ingredient);
                    RecipeDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    RecipeDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.easycompra.app.data.recipes.RecipeDao
    public Object insertStep(final RecipeStepEntity step, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.easycompra.app.data.recipes.RecipeDao_Impl.11
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                RecipeDao_Impl.this.__db.beginTransaction();
                try {
                    RecipeDao_Impl.this.__insertionAdapterOfRecipeStepEntity.insert(step);
                    RecipeDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    RecipeDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.easycompra.app.data.recipes.RecipeDao
    public Object updateRecipe(final RecipeEntity recipe, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.easycompra.app.data.recipes.RecipeDao_Impl.12
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                RecipeDao_Impl.this.__db.beginTransaction();
                try {
                    RecipeDao_Impl.this.__updateAdapterOfRecipeEntity.handle(recipe);
                    RecipeDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    RecipeDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.easycompra.app.data.recipes.RecipeDao
    public Object setFavorite(final String id, final boolean fav, final long ts, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.easycompra.app.data.recipes.RecipeDao_Impl.13
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement supportSQLiteStatementAcquire = RecipeDao_Impl.this.__preparedStmtOfSetFavorite.acquire();
                supportSQLiteStatementAcquire.bindLong(1, fav ? 1L : 0L);
                supportSQLiteStatementAcquire.bindLong(2, ts);
                supportSQLiteStatementAcquire.bindString(3, id);
                try {
                    RecipeDao_Impl.this.__db.beginTransaction();
                    try {
                        supportSQLiteStatementAcquire.executeUpdateDelete();
                        RecipeDao_Impl.this.__db.setTransactionSuccessful();
                        Unit unit = Unit.INSTANCE;
                        RecipeDao_Impl.this.__db.endTransaction();
                        RecipeDao_Impl.this.__preparedStmtOfSetFavorite.release(supportSQLiteStatementAcquire);
                        return unit;
                    } catch (Throwable th) {
                        RecipeDao_Impl.this.__db.endTransaction();
                        throw th;
                    }
                } catch (Throwable th2) {
                    RecipeDao_Impl.this.__preparedStmtOfSetFavorite.release(supportSQLiteStatementAcquire);
                    throw th2;
                }
            }
        }, $completion);
    }

    @Override // com.easycompra.app.data.recipes.RecipeDao
    public Object deleteIngredientsOf(final String recipeId, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.easycompra.app.data.recipes.RecipeDao_Impl.14
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement _stmt = RecipeDao_Impl.this.__preparedStmtOfDeleteIngredientsOf.acquire();
                _stmt.bindString(1, recipeId);
                try {
                    RecipeDao_Impl.this.__db.beginTransaction();
                    try {
                        _stmt.executeUpdateDelete();
                        RecipeDao_Impl.this.__db.setTransactionSuccessful();
                        Unit unit = Unit.INSTANCE;
                        RecipeDao_Impl.this.__db.endTransaction();
                        RecipeDao_Impl.this.__preparedStmtOfDeleteIngredientsOf.release(_stmt);
                        return unit;
                    } catch (Throwable th) {
                        RecipeDao_Impl.this.__db.endTransaction();
                        throw th;
                    }
                } catch (Throwable th2) {
                    RecipeDao_Impl.this.__preparedStmtOfDeleteIngredientsOf.release(_stmt);
                    throw th2;
                }
            }
        }, $completion);
    }

    @Override // com.easycompra.app.data.recipes.RecipeDao
    public Object deleteStepsOf(final String recipeId, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.easycompra.app.data.recipes.RecipeDao_Impl.15
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement _stmt = RecipeDao_Impl.this.__preparedStmtOfDeleteStepsOf.acquire();
                _stmt.bindString(1, recipeId);
                try {
                    RecipeDao_Impl.this.__db.beginTransaction();
                    try {
                        _stmt.executeUpdateDelete();
                        RecipeDao_Impl.this.__db.setTransactionSuccessful();
                        Unit unit = Unit.INSTANCE;
                        RecipeDao_Impl.this.__db.endTransaction();
                        RecipeDao_Impl.this.__preparedStmtOfDeleteStepsOf.release(_stmt);
                        return unit;
                    } catch (Throwable th) {
                        RecipeDao_Impl.this.__db.endTransaction();
                        throw th;
                    }
                } catch (Throwable th2) {
                    RecipeDao_Impl.this.__preparedStmtOfDeleteStepsOf.release(_stmt);
                    throw th2;
                }
            }
        }, $completion);
    }

    @Override // com.easycompra.app.data.recipes.RecipeDao
    public Object deleteRecipe(final String id, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.easycompra.app.data.recipes.RecipeDao_Impl.16
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement _stmt = RecipeDao_Impl.this.__preparedStmtOfDeleteRecipe.acquire();
                _stmt.bindString(1, id);
                try {
                    RecipeDao_Impl.this.__db.beginTransaction();
                    try {
                        _stmt.executeUpdateDelete();
                        RecipeDao_Impl.this.__db.setTransactionSuccessful();
                        Unit unit = Unit.INSTANCE;
                        RecipeDao_Impl.this.__db.endTransaction();
                        RecipeDao_Impl.this.__preparedStmtOfDeleteRecipe.release(_stmt);
                        return unit;
                    } catch (Throwable th) {
                        RecipeDao_Impl.this.__db.endTransaction();
                        throw th;
                    }
                } catch (Throwable th2) {
                    RecipeDao_Impl.this.__preparedStmtOfDeleteRecipe.release(_stmt);
                    throw th2;
                }
            }
        }, $completion);
    }

    @Override // com.easycompra.app.data.recipes.RecipeDao
    public Flow<List<RecipeWithDetails>> observeAll() {
        final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire("SELECT * FROM recipes ORDER BY name COLLATE NOCASE ASC", 0);
        return CoroutinesRoom.createFlow(this.__db, true, new String[]{"recipe_ingredients", "recipe_steps", "recipes"}, new Callable<List<RecipeWithDetails>>() { // from class: com.easycompra.app.data.recipes.RecipeDao_Impl.17
            @Override // java.util.concurrent.Callable
            public List<RecipeWithDetails> call() throws Exception {
                RecipeDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor _cursor = DBUtil.query(RecipeDao_Impl.this.__db, _statement, true, null);
                    try {
                        int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
                        int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, HintConstants.AUTOFILL_HINT_NAME);
                        int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
                        int _cursorIndexOfPhotoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "photoUrl");
                        int _cursorIndexOfPrepTimeMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "prepTimeMinutes");
                        int _cursorIndexOfBaseServings = CursorUtil.getColumnIndexOrThrow(_cursor, "baseServings");
                        int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
                        int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
                        int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
                        int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
                        int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
                        ArrayMap<String, ArrayList<IngredientEntity>> _collectionIngredients = new ArrayMap<>();
                        ArrayMap<String, ArrayList<RecipeStepEntity>> _collectionSteps = new ArrayMap<>();
                        while (_cursor.moveToNext()) {
                            String _tmpKey = _cursor.getString(_cursorIndexOfId);
                            if (!_collectionIngredients.containsKey(_tmpKey)) {
                                _collectionIngredients.put(_tmpKey, new ArrayList<>());
                            }
                            String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
                            if (!_collectionSteps.containsKey(_tmpKey_1)) {
                                _collectionSteps.put(_tmpKey_1, new ArrayList<>());
                            }
                            _cursorIndexOfUpdatedAt = _cursorIndexOfUpdatedAt;
                        }
                        int _cursorIndexOfUpdatedAt2 = _cursorIndexOfUpdatedAt;
                        _cursor.moveToPosition(-1);
                        RecipeDao_Impl.this.__fetchRelationshiprecipeIngredientsAscomEasycompraAppDataRecipesIngredientEntity(_collectionIngredients);
                        RecipeDao_Impl.this.__fetchRelationshiprecipeStepsAscomEasycompraAppDataRecipesRecipeStepEntity(_collectionSteps);
                        List<RecipeWithDetails> _result = new ArrayList<>(_cursor.getCount());
                        while (_cursor.moveToNext()) {
                            String _tmpId = _cursor.getString(_cursorIndexOfId);
                            String _tmpName = _cursor.getString(_cursorIndexOfName);
                            String _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
                            String _tmpPhotoUrl = _cursor.getString(_cursorIndexOfPhotoUrl);
                            int _tmpPrepTimeMinutes = _cursor.getInt(_cursorIndexOfPrepTimeMinutes);
                            int _tmpBaseServings = _cursor.getInt(_cursorIndexOfBaseServings);
                            String _tmpDifficulty = _cursor.getString(_cursorIndexOfDifficulty);
                            String _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
                            int _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
                            boolean _tmpIsFavorite = _tmp != 0;
                            long _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
                            int _cursorIndexOfName2 = _cursorIndexOfName;
                            int _cursorIndexOfName3 = _cursorIndexOfUpdatedAt2;
                            long _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfName3);
                            RecipeEntity _tmpRecipe = new RecipeEntity(_tmpId, _tmpName, _tmpCategory, _tmpPhotoUrl, _tmpPrepTimeMinutes, _tmpBaseServings, _tmpDifficulty, _tmpNotes, _tmpIsFavorite, _tmpCreatedAt, _tmpUpdatedAt);
                            String _tmpKey_2 = _cursor.getString(_cursorIndexOfId);
                            _cursorIndexOfUpdatedAt2 = _cursorIndexOfName3;
                            ArrayList<IngredientEntity> _tmpIngredientsCollection = _collectionIngredients.get(_tmpKey_2);
                            String _tmpKey_3 = _cursor.getString(_cursorIndexOfId);
                            int _cursorIndexOfId2 = _cursorIndexOfId;
                            ArrayList<RecipeStepEntity> _tmpStepsCollection = _collectionSteps.get(_tmpKey_3);
                            RecipeWithDetails _item = new RecipeWithDetails(_tmpRecipe, _tmpIngredientsCollection, _tmpStepsCollection);
                            _result.add(_item);
                            _cursorIndexOfCategory = _cursorIndexOfCategory;
                            _cursorIndexOfName = _cursorIndexOfName2;
                            _cursorIndexOfId = _cursorIndexOfId2;
                            _cursorIndexOfPhotoUrl = _cursorIndexOfPhotoUrl;
                        }
                        RecipeDao_Impl.this.__db.setTransactionSuccessful();
                        _cursor.close();
                        RecipeDao_Impl.this.__db.endTransaction();
                        return _result;
                    } catch (Throwable th) {
                        _cursor.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    RecipeDao_Impl.this.__db.endTransaction();
                    throw th2;
                }
            }

            protected void finalize() {
                _statement.release();
            }
        });
    }

    @Override // com.easycompra.app.data.recipes.RecipeDao
    public Object getById(final String id, final Continuation<? super RecipeWithDetails> $completion) {
        final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire("SELECT * FROM recipes WHERE id = ?", 1);
        _statement.bindString(1, id);
        CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, true, _cancellationSignal, new Callable<RecipeWithDetails>() { // from class: com.easycompra.app.data.recipes.RecipeDao_Impl.18
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public RecipeWithDetails call() throws Exception {
                RecipeWithDetails _result;
                RecipeDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor _cursor = DBUtil.query(RecipeDao_Impl.this.__db, _statement, true, null);
                    try {
                        int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
                        int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, HintConstants.AUTOFILL_HINT_NAME);
                        int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
                        int _cursorIndexOfPhotoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "photoUrl");
                        int _cursorIndexOfPrepTimeMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "prepTimeMinutes");
                        int _cursorIndexOfBaseServings = CursorUtil.getColumnIndexOrThrow(_cursor, "baseServings");
                        int _cursorIndexOfDifficulty = CursorUtil.getColumnIndexOrThrow(_cursor, "difficulty");
                        int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
                        int _cursorIndexOfIsFavorite = CursorUtil.getColumnIndexOrThrow(_cursor, "isFavorite");
                        int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
                        int _cursorIndexOfUpdatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "updatedAt");
                        ArrayMap<String, ArrayList<IngredientEntity>> _collectionIngredients = new ArrayMap<>();
                        ArrayMap<String, ArrayList<RecipeStepEntity>> _collectionSteps = new ArrayMap<>();
                        while (_cursor.moveToNext()) {
                            String _tmpKey = _cursor.getString(_cursorIndexOfId);
                            if (!_collectionIngredients.containsKey(_tmpKey)) {
                                _collectionIngredients.put(_tmpKey, new ArrayList<>());
                            }
                            String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
                            if (!_collectionSteps.containsKey(_tmpKey_1)) {
                                _collectionSteps.put(_tmpKey_1, new ArrayList<>());
                            }
                            _cursorIndexOfUpdatedAt = _cursorIndexOfUpdatedAt;
                        }
                        int _cursorIndexOfUpdatedAt2 = _cursorIndexOfUpdatedAt;
                        _cursor.moveToPosition(-1);
                        RecipeDao_Impl.this.__fetchRelationshiprecipeIngredientsAscomEasycompraAppDataRecipesIngredientEntity(_collectionIngredients);
                        RecipeDao_Impl.this.__fetchRelationshiprecipeStepsAscomEasycompraAppDataRecipesRecipeStepEntity(_collectionSteps);
                        if (_cursor.moveToFirst()) {
                            String _tmpId = _cursor.getString(_cursorIndexOfId);
                            String _tmpName = _cursor.getString(_cursorIndexOfName);
                            String _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
                            String _tmpPhotoUrl = _cursor.getString(_cursorIndexOfPhotoUrl);
                            int _tmpPrepTimeMinutes = _cursor.getInt(_cursorIndexOfPrepTimeMinutes);
                            int _tmpBaseServings = _cursor.getInt(_cursorIndexOfBaseServings);
                            String _tmpDifficulty = _cursor.getString(_cursorIndexOfDifficulty);
                            String _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
                            int _tmp = _cursor.getInt(_cursorIndexOfIsFavorite);
                            boolean _tmpIsFavorite = _tmp != 0;
                            long _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
                            long _tmpUpdatedAt = _cursor.getLong(_cursorIndexOfUpdatedAt2);
                            RecipeEntity _tmpRecipe = new RecipeEntity(_tmpId, _tmpName, _tmpCategory, _tmpPhotoUrl, _tmpPrepTimeMinutes, _tmpBaseServings, _tmpDifficulty, _tmpNotes, _tmpIsFavorite, _tmpCreatedAt, _tmpUpdatedAt);
                            String _tmpKey_2 = _cursor.getString(_cursorIndexOfId);
                            ArrayList<IngredientEntity> _tmpIngredientsCollection = _collectionIngredients.get(_tmpKey_2);
                            String _tmpKey_3 = _cursor.getString(_cursorIndexOfId);
                            ArrayList<RecipeStepEntity> _tmpStepsCollection = _collectionSteps.get(_tmpKey_3);
                            _result = new RecipeWithDetails(_tmpRecipe, _tmpIngredientsCollection, _tmpStepsCollection);
                        } else {
                            _result = null;
                        }
                        RecipeDao_Impl.this.__db.setTransactionSuccessful();
                        _cursor.close();
                        _statement.release();
                        RecipeDao_Impl.this.__db.endTransaction();
                        return _result;
                    } catch (Throwable th) {
                        _cursor.close();
                        _statement.release();
                        throw th;
                    }
                } catch (Throwable th2) {
                    RecipeDao_Impl.this.__db.endTransaction();
                    throw th2;
                }
            }
        }, $completion);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshiprecipeIngredientsAscomEasycompraAppDataRecipesIngredientEntity(final ArrayMap<String, ArrayList<IngredientEntity>> _map) {
        String _tmpLinkedProductId;
        Set<String> __mapKeySet = _map.keySet();
        if (__mapKeySet.isEmpty()) {
            return;
        }
        if (_map.getSize() > 999) {
            RelationUtil.recursiveFetchArrayMap(_map, true, new Function1() { // from class: com.easycompra.app.data.recipes.RecipeDao_Impl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return this.f$0.lambda$__fetchRelationshiprecipeIngredientsAscomEasycompraAppDataRecipesIngredientEntity$0((ArrayMap) obj);
                }
            });
            return;
        }
        StringBuilder _stringBuilder = StringUtil.newStringBuilder();
        _stringBuilder.append("SELECT `id`,`recipeId`,`name`,`baseQuantity`,`unit`,`linkedProductId`,`ingredientNotes` FROM `recipe_ingredients` WHERE `recipeId` IN (");
        int _inputSize = __mapKeySet.size();
        StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
        _stringBuilder.append(")");
        String _sql = _stringBuilder.toString();
        int _argCount = _inputSize + 0;
        RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
        int _argIndex = 1;
        for (String _item : __mapKeySet) {
            _stmt.bindString(_argIndex, _item);
            _argIndex++;
        }
        Cursor _cursor = DBUtil.query(this.__db, _stmt, false, null);
        try {
            int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "recipeId");
            if (_itemKeyIndex == -1) {
                return;
            }
            while (_cursor.moveToNext()) {
                String _tmpKey = _cursor.getString(_itemKeyIndex);
                ArrayList<IngredientEntity> _tmpRelation = _map.get(_tmpKey);
                if (_tmpRelation != null) {
                    String _tmpId = _cursor.getString(0);
                    String _tmpRecipeId = _cursor.getString(1);
                    String _tmpName = _cursor.getString(2);
                    float _tmpBaseQuantity = _cursor.getFloat(3);
                    String _tmpUnit = _cursor.getString(4);
                    if (_cursor.isNull(5)) {
                        _tmpLinkedProductId = null;
                    } else {
                        _tmpLinkedProductId = _cursor.getString(5);
                    }
                    String _tmpIngredientNotes = _cursor.getString(6);
                    IngredientEntity _item_1 = new IngredientEntity(_tmpId, _tmpRecipeId, _tmpName, _tmpBaseQuantity, _tmpUnit, _tmpLinkedProductId, _tmpIngredientNotes);
                    _tmpRelation.add(_item_1);
                }
                _itemKeyIndex = _itemKeyIndex;
            }
        } finally {
            _cursor.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$__fetchRelationshiprecipeIngredientsAscomEasycompraAppDataRecipesIngredientEntity$0(ArrayMap map) {
        __fetchRelationshiprecipeIngredientsAscomEasycompraAppDataRecipesIngredientEntity(map);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshiprecipeStepsAscomEasycompraAppDataRecipesRecipeStepEntity(final ArrayMap<String, ArrayList<RecipeStepEntity>> _map) {
        Set<String> __mapKeySet = _map.keySet();
        if (__mapKeySet.isEmpty()) {
            return;
        }
        if (_map.getSize() > 999) {
            RelationUtil.recursiveFetchArrayMap(_map, true, new Function1() { // from class: com.easycompra.app.data.recipes.RecipeDao_Impl$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return this.f$0.lambda$__fetchRelationshiprecipeStepsAscomEasycompraAppDataRecipesRecipeStepEntity$1((ArrayMap) obj);
                }
            });
            return;
        }
        StringBuilder _stringBuilder = StringUtil.newStringBuilder();
        _stringBuilder.append("SELECT `id`,`recipeId`,`stepNumber`,`description`,`timeMinutes` FROM `recipe_steps` WHERE `recipeId` IN (");
        int _inputSize = __mapKeySet.size();
        StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
        _stringBuilder.append(")");
        String _sql = _stringBuilder.toString();
        int _argCount = _inputSize + 0;
        RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
        int _argIndex = 1;
        for (String _item : __mapKeySet) {
            _stmt.bindString(_argIndex, _item);
            _argIndex++;
        }
        Cursor _cursor = DBUtil.query(this.__db, _stmt, false, null);
        try {
            int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "recipeId");
            if (_itemKeyIndex != -1) {
                while (_cursor.moveToNext()) {
                    String _tmpKey = _cursor.getString(_itemKeyIndex);
                    ArrayList<RecipeStepEntity> _tmpRelation = _map.get(_tmpKey);
                    if (_tmpRelation != null) {
                        String _tmpId = _cursor.getString(0);
                        String _tmpRecipeId = _cursor.getString(1);
                        int _tmpStepNumber = _cursor.getInt(2);
                        String _tmpDescription = _cursor.getString(3);
                        int _tmpTimeMinutes = _cursor.getInt(4);
                        RecipeStepEntity _item_1 = new RecipeStepEntity(_tmpId, _tmpRecipeId, _tmpStepNumber, _tmpDescription, _tmpTimeMinutes);
                        _tmpRelation.add(_item_1);
                    }
                    _itemKeyIndex = _itemKeyIndex;
                }
                _cursor.close();
                return;
            }
            _cursor.close();
        } catch (Throwable th) {
            _cursor.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$__fetchRelationshiprecipeStepsAscomEasycompraAppDataRecipesRecipeStepEntity$1(ArrayMap map) {
        __fetchRelationshiprecipeStepsAscomEasycompraAppDataRecipesRecipeStepEntity(map);
        return Unit.INSTANCE;
    }
}
