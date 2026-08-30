package com.easycompra.app.data.planner;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes15.dex */
public final class PlannerDao_Impl implements PlannerDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<PlannerEntry> __insertionAdapterOfPlannerEntry;
    private final SharedSQLiteStatement __preparedStmtOfDeleteById;
    private final SharedSQLiteStatement __preparedStmtOfDeleteSlot;
    private final EntityDeletionOrUpdateAdapter<PlannerEntry> __updateAdapterOfPlannerEntry;

    public PlannerDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfPlannerEntry = new EntityInsertionAdapter<PlannerEntry>(__db) { // from class: com.easycompra.app.data.planner.PlannerDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `planner_entries` (`id`,`date`,`mealSlot`,`recipeId`,`displayName`,`servings`,`notes`,`createdAt`) VALUES (?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final PlannerEntry entity) {
                statement.bindString(1, entity.getId());
                statement.bindString(2, entity.getDate());
                statement.bindString(3, entity.getMealSlot());
                if (entity.getRecipeId() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getRecipeId());
                }
                statement.bindString(5, entity.getDisplayName());
                statement.bindDouble(6, entity.getServings());
                statement.bindString(7, entity.getNotes());
                statement.bindLong(8, entity.getCreatedAt());
            }
        };
        this.__updateAdapterOfPlannerEntry = new EntityDeletionOrUpdateAdapter<PlannerEntry>(__db) { // from class: com.easycompra.app.data.planner.PlannerDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `planner_entries` SET `id` = ?,`date` = ?,`mealSlot` = ?,`recipeId` = ?,`displayName` = ?,`servings` = ?,`notes` = ?,`createdAt` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final PlannerEntry entity) {
                statement.bindString(1, entity.getId());
                statement.bindString(2, entity.getDate());
                statement.bindString(3, entity.getMealSlot());
                if (entity.getRecipeId() == null) {
                    statement.bindNull(4);
                } else {
                    statement.bindString(4, entity.getRecipeId());
                }
                statement.bindString(5, entity.getDisplayName());
                statement.bindDouble(6, entity.getServings());
                statement.bindString(7, entity.getNotes());
                statement.bindLong(8, entity.getCreatedAt());
                statement.bindString(9, entity.getId());
            }
        };
        this.__preparedStmtOfDeleteById = new SharedSQLiteStatement(__db) { // from class: com.easycompra.app.data.planner.PlannerDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM planner_entries WHERE id = ?";
            }
        };
        this.__preparedStmtOfDeleteSlot = new SharedSQLiteStatement(__db) { // from class: com.easycompra.app.data.planner.PlannerDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM planner_entries WHERE date = ? AND mealSlot = ?";
            }
        };
    }

    @Override // com.easycompra.app.data.planner.PlannerDao
    public Object insert(final PlannerEntry entry, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.easycompra.app.data.planner.PlannerDao_Impl.5
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                PlannerDao_Impl.this.__db.beginTransaction();
                try {
                    PlannerDao_Impl.this.__insertionAdapterOfPlannerEntry.insert(entry);
                    PlannerDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    PlannerDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.easycompra.app.data.planner.PlannerDao
    public Object update(final PlannerEntry entry, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.easycompra.app.data.planner.PlannerDao_Impl.6
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                PlannerDao_Impl.this.__db.beginTransaction();
                try {
                    PlannerDao_Impl.this.__updateAdapterOfPlannerEntry.handle(entry);
                    PlannerDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    PlannerDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.easycompra.app.data.planner.PlannerDao
    public Object deleteById(final String id, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.easycompra.app.data.planner.PlannerDao_Impl.7
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement _stmt = PlannerDao_Impl.this.__preparedStmtOfDeleteById.acquire();
                _stmt.bindString(1, id);
                try {
                    PlannerDao_Impl.this.__db.beginTransaction();
                    try {
                        _stmt.executeUpdateDelete();
                        PlannerDao_Impl.this.__db.setTransactionSuccessful();
                        Unit unit = Unit.INSTANCE;
                        PlannerDao_Impl.this.__db.endTransaction();
                        PlannerDao_Impl.this.__preparedStmtOfDeleteById.release(_stmt);
                        return unit;
                    } catch (Throwable th) {
                        PlannerDao_Impl.this.__db.endTransaction();
                        throw th;
                    }
                } catch (Throwable th2) {
                    PlannerDao_Impl.this.__preparedStmtOfDeleteById.release(_stmt);
                    throw th2;
                }
            }
        }, $completion);
    }

    @Override // com.easycompra.app.data.planner.PlannerDao
    public Object deleteSlot(final String date, final String slot, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.easycompra.app.data.planner.PlannerDao_Impl.8
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement _stmt = PlannerDao_Impl.this.__preparedStmtOfDeleteSlot.acquire();
                _stmt.bindString(1, date);
                _stmt.bindString(2, slot);
                try {
                    PlannerDao_Impl.this.__db.beginTransaction();
                    try {
                        _stmt.executeUpdateDelete();
                        PlannerDao_Impl.this.__db.setTransactionSuccessful();
                        Unit unit = Unit.INSTANCE;
                        PlannerDao_Impl.this.__db.endTransaction();
                        PlannerDao_Impl.this.__preparedStmtOfDeleteSlot.release(_stmt);
                        return unit;
                    } catch (Throwable th) {
                        PlannerDao_Impl.this.__db.endTransaction();
                        throw th;
                    }
                } catch (Throwable th2) {
                    PlannerDao_Impl.this.__preparedStmtOfDeleteSlot.release(_stmt);
                    throw th2;
                }
            }
        }, $completion);
    }

    @Override // com.easycompra.app.data.planner.PlannerDao
    public Flow<List<PlannerEntry>> observeRange(final String from, final String to) {
        final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire("SELECT * FROM planner_entries WHERE date >= ? AND date <= ? ORDER BY date, mealSlot", 2);
        _statement.bindString(1, from);
        _statement.bindString(2, to);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"planner_entries"}, new Callable<List<PlannerEntry>>() { // from class: com.easycompra.app.data.planner.PlannerDao_Impl.9
            @Override // java.util.concurrent.Callable
            public List<PlannerEntry> call() throws Exception {
                String _tmpRecipeId;
                Cursor _cursor = DBUtil.query(PlannerDao_Impl.this.__db, _statement, false, null);
                try {
                    int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
                    int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
                    int _cursorIndexOfMealSlot = CursorUtil.getColumnIndexOrThrow(_cursor, "mealSlot");
                    int _cursorIndexOfRecipeId = CursorUtil.getColumnIndexOrThrow(_cursor, "recipeId");
                    int _cursorIndexOfDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "displayName");
                    int _cursorIndexOfServings = CursorUtil.getColumnIndexOrThrow(_cursor, "servings");
                    int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
                    int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
                    List<PlannerEntry> _result = new ArrayList<>(_cursor.getCount());
                    while (_cursor.moveToNext()) {
                        String _tmpId = _cursor.getString(_cursorIndexOfId);
                        String _tmpDate = _cursor.getString(_cursorIndexOfDate);
                        String _tmpMealSlot = _cursor.getString(_cursorIndexOfMealSlot);
                        if (_cursor.isNull(_cursorIndexOfRecipeId)) {
                            _tmpRecipeId = null;
                        } else {
                            _tmpRecipeId = _cursor.getString(_cursorIndexOfRecipeId);
                        }
                        String _tmpDisplayName = _cursor.getString(_cursorIndexOfDisplayName);
                        float _tmpServings = _cursor.getFloat(_cursorIndexOfServings);
                        String _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
                        long _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
                        PlannerEntry _item = new PlannerEntry(_tmpId, _tmpDate, _tmpMealSlot, _tmpRecipeId, _tmpDisplayName, _tmpServings, _tmpNotes, _tmpCreatedAt);
                        _result.add(_item);
                    }
                    return _result;
                } finally {
                    _cursor.close();
                }
            }

            protected void finalize() {
                _statement.release();
            }
        });
    }

    @Override // com.easycompra.app.data.planner.PlannerDao
    public Object getRange(final String from, final String to, final Continuation<? super List<PlannerEntry>> $completion) {
        final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire("SELECT * FROM planner_entries WHERE date >= ? AND date <= ? ORDER BY date, mealSlot", 2);
        _statement.bindString(1, from);
        _statement.bindString(2, to);
        CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, false, _cancellationSignal, new Callable<List<PlannerEntry>>() { // from class: com.easycompra.app.data.planner.PlannerDao_Impl.10
            @Override // java.util.concurrent.Callable
            public List<PlannerEntry> call() throws Exception {
                String _tmpRecipeId;
                Cursor _cursor = DBUtil.query(PlannerDao_Impl.this.__db, _statement, false, null);
                try {
                    int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
                    int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
                    int _cursorIndexOfMealSlot = CursorUtil.getColumnIndexOrThrow(_cursor, "mealSlot");
                    int _cursorIndexOfRecipeId = CursorUtil.getColumnIndexOrThrow(_cursor, "recipeId");
                    int _cursorIndexOfDisplayName = CursorUtil.getColumnIndexOrThrow(_cursor, "displayName");
                    int _cursorIndexOfServings = CursorUtil.getColumnIndexOrThrow(_cursor, "servings");
                    int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
                    int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
                    List<PlannerEntry> _result = new ArrayList<>(_cursor.getCount());
                    while (_cursor.moveToNext()) {
                        String _tmpId = _cursor.getString(_cursorIndexOfId);
                        String _tmpDate = _cursor.getString(_cursorIndexOfDate);
                        String _tmpMealSlot = _cursor.getString(_cursorIndexOfMealSlot);
                        if (_cursor.isNull(_cursorIndexOfRecipeId)) {
                            _tmpRecipeId = null;
                        } else {
                            _tmpRecipeId = _cursor.getString(_cursorIndexOfRecipeId);
                        }
                        String _tmpDisplayName = _cursor.getString(_cursorIndexOfDisplayName);
                        float _tmpServings = _cursor.getFloat(_cursorIndexOfServings);
                        String _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
                        long _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
                        PlannerEntry _item = new PlannerEntry(_tmpId, _tmpDate, _tmpMealSlot, _tmpRecipeId, _tmpDisplayName, _tmpServings, _tmpNotes, _tmpCreatedAt);
                        _result.add(_item);
                    }
                    return _result;
                } finally {
                    _cursor.close();
                    _statement.release();
                }
            }
        }, $completion);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
