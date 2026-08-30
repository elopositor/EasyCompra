package com.easycompra.app.data.pantry;

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

/* JADX INFO: loaded from: classes11.dex */
public final class PantryDao_Impl implements PantryDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<PantryLocationEntity> __deletionAdapterOfPantryLocationEntity;
    private final EntityInsertionAdapter<PantryLocationEntity> __insertionAdapterOfPantryLocationEntity;
    private final EntityInsertionAdapter<PantryProductEntity> __insertionAdapterOfPantryProductEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteProduct;
    private final SharedSQLiteStatement __preparedStmtOfSetNeedsToBuy;
    private final SharedSQLiteStatement __preparedStmtOfUpdateQuantity;
    private final EntityDeletionOrUpdateAdapter<PantryLocationEntity> __updateAdapterOfPantryLocationEntity;
    private final EntityDeletionOrUpdateAdapter<PantryProductEntity> __updateAdapterOfPantryProductEntity;

    public PantryDao_Impl(final RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfPantryProductEntity = new EntityInsertionAdapter<PantryProductEntity>(__db) { // from class: com.easycompra.app.data.pantry.PantryDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `pantry_products` (`id`,`name`,`needsToBuy`,`createdAt`) VALUES (?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, PantryProductEntity pantryProductEntity) {
                supportSQLiteStatement.bindString(1, pantryProductEntity.getId());
                supportSQLiteStatement.bindString(2, pantryProductEntity.getName());
                supportSQLiteStatement.bindLong(3, pantryProductEntity.getNeedsToBuy() ? 1L : 0L);
                supportSQLiteStatement.bindLong(4, pantryProductEntity.getCreatedAt());
            }
        };
        this.__insertionAdapterOfPantryLocationEntity = new EntityInsertionAdapter<PantryLocationEntity>(__db) { // from class: com.easycompra.app.data.pantry.PantryDao_Impl.2
            @Override // androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "INSERT OR REPLACE INTO `pantry_locations` (`id`,`productId`,`category`,`subcategory`,`description`,`quantity`,`unit`,`updatedAt`) VALUES (?,?,?,?,?,?,?,?)";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(final SupportSQLiteStatement statement, final PantryLocationEntity entity) {
                statement.bindString(1, entity.getId());
                statement.bindString(2, entity.getProductId());
                statement.bindString(3, entity.getCategory());
                statement.bindString(4, entity.getSubcategory());
                statement.bindString(5, entity.getDescription());
                statement.bindDouble(6, entity.getQuantity());
                statement.bindString(7, entity.getUnit());
                statement.bindLong(8, entity.getUpdatedAt());
            }
        };
        this.__deletionAdapterOfPantryLocationEntity = new EntityDeletionOrUpdateAdapter<PantryLocationEntity>(__db) { // from class: com.easycompra.app.data.pantry.PantryDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "DELETE FROM `pantry_locations` WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final PantryLocationEntity entity) {
                statement.bindString(1, entity.getId());
            }
        };
        this.__updateAdapterOfPantryProductEntity = new EntityDeletionOrUpdateAdapter<PantryProductEntity>(__db) { // from class: com.easycompra.app.data.pantry.PantryDao_Impl.4
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `pantry_products` SET `id` = ?,`name` = ?,`needsToBuy` = ?,`createdAt` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, PantryProductEntity pantryProductEntity) {
                supportSQLiteStatement.bindString(1, pantryProductEntity.getId());
                supportSQLiteStatement.bindString(2, pantryProductEntity.getName());
                supportSQLiteStatement.bindLong(3, pantryProductEntity.getNeedsToBuy() ? 1L : 0L);
                supportSQLiteStatement.bindLong(4, pantryProductEntity.getCreatedAt());
                supportSQLiteStatement.bindString(5, pantryProductEntity.getId());
            }
        };
        this.__updateAdapterOfPantryLocationEntity = new EntityDeletionOrUpdateAdapter<PantryLocationEntity>(__db) { // from class: com.easycompra.app.data.pantry.PantryDao_Impl.5
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            protected String createQuery() {
                return "UPDATE OR ABORT `pantry_locations` SET `id` = ?,`productId` = ?,`category` = ?,`subcategory` = ?,`description` = ?,`quantity` = ?,`unit` = ?,`updatedAt` = ? WHERE `id` = ?";
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(final SupportSQLiteStatement statement, final PantryLocationEntity entity) {
                statement.bindString(1, entity.getId());
                statement.bindString(2, entity.getProductId());
                statement.bindString(3, entity.getCategory());
                statement.bindString(4, entity.getSubcategory());
                statement.bindString(5, entity.getDescription());
                statement.bindDouble(6, entity.getQuantity());
                statement.bindString(7, entity.getUnit());
                statement.bindLong(8, entity.getUpdatedAt());
                statement.bindString(9, entity.getId());
            }
        };
        this.__preparedStmtOfUpdateQuantity = new SharedSQLiteStatement(__db) { // from class: com.easycompra.app.data.pantry.PantryDao_Impl.6
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE pantry_locations SET quantity = ?, updatedAt = ? WHERE id = ?";
            }
        };
        this.__preparedStmtOfSetNeedsToBuy = new SharedSQLiteStatement(__db) { // from class: com.easycompra.app.data.pantry.PantryDao_Impl.7
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE pantry_products SET needsToBuy = ? WHERE id = ?";
            }
        };
        this.__preparedStmtOfDeleteProduct = new SharedSQLiteStatement(__db) { // from class: com.easycompra.app.data.pantry.PantryDao_Impl.8
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM pantry_products WHERE id = ?";
            }
        };
    }

    @Override // com.easycompra.app.data.pantry.PantryDao
    public Object insertProduct(final PantryProductEntity product, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.easycompra.app.data.pantry.PantryDao_Impl.9
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                PantryDao_Impl.this.__db.beginTransaction();
                try {
                    PantryDao_Impl.this.__insertionAdapterOfPantryProductEntity.insert(product);
                    PantryDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    PantryDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.easycompra.app.data.pantry.PantryDao
    public Object insertLocation(final PantryLocationEntity location, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.easycompra.app.data.pantry.PantryDao_Impl.10
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                PantryDao_Impl.this.__db.beginTransaction();
                try {
                    PantryDao_Impl.this.__insertionAdapterOfPantryLocationEntity.insert(location);
                    PantryDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    PantryDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.easycompra.app.data.pantry.PantryDao
    public Object deleteLocation(final PantryLocationEntity location, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.easycompra.app.data.pantry.PantryDao_Impl.11
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                PantryDao_Impl.this.__db.beginTransaction();
                try {
                    PantryDao_Impl.this.__deletionAdapterOfPantryLocationEntity.handle(location);
                    PantryDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    PantryDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.easycompra.app.data.pantry.PantryDao
    public Object updateProduct(final PantryProductEntity product, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.easycompra.app.data.pantry.PantryDao_Impl.12
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                PantryDao_Impl.this.__db.beginTransaction();
                try {
                    PantryDao_Impl.this.__updateAdapterOfPantryProductEntity.handle(product);
                    PantryDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    PantryDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.easycompra.app.data.pantry.PantryDao
    public Object updateLocation(final PantryLocationEntity location, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.easycompra.app.data.pantry.PantryDao_Impl.13
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                PantryDao_Impl.this.__db.beginTransaction();
                try {
                    PantryDao_Impl.this.__updateAdapterOfPantryLocationEntity.handle(location);
                    PantryDao_Impl.this.__db.setTransactionSuccessful();
                    return Unit.INSTANCE;
                } finally {
                    PantryDao_Impl.this.__db.endTransaction();
                }
            }
        }, $completion);
    }

    @Override // com.easycompra.app.data.pantry.PantryDao
    public Object updateQuantity(final String id, final float qty, final long ts, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.easycompra.app.data.pantry.PantryDao_Impl.14
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement _stmt = PantryDao_Impl.this.__preparedStmtOfUpdateQuantity.acquire();
                _stmt.bindDouble(1, qty);
                _stmt.bindLong(2, ts);
                _stmt.bindString(3, id);
                try {
                    PantryDao_Impl.this.__db.beginTransaction();
                    try {
                        _stmt.executeUpdateDelete();
                        PantryDao_Impl.this.__db.setTransactionSuccessful();
                        Unit unit = Unit.INSTANCE;
                        PantryDao_Impl.this.__db.endTransaction();
                        PantryDao_Impl.this.__preparedStmtOfUpdateQuantity.release(_stmt);
                        return unit;
                    } catch (Throwable th) {
                        PantryDao_Impl.this.__db.endTransaction();
                        throw th;
                    }
                } catch (Throwable th2) {
                    PantryDao_Impl.this.__preparedStmtOfUpdateQuantity.release(_stmt);
                    throw th2;
                }
            }
        }, $completion);
    }

    @Override // com.easycompra.app.data.pantry.PantryDao
    public Object setNeedsToBuy(final String id, final boolean needs, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.easycompra.app.data.pantry.PantryDao_Impl.15
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement supportSQLiteStatementAcquire = PantryDao_Impl.this.__preparedStmtOfSetNeedsToBuy.acquire();
                supportSQLiteStatementAcquire.bindLong(1, needs ? 1L : 0L);
                supportSQLiteStatementAcquire.bindString(2, id);
                try {
                    PantryDao_Impl.this.__db.beginTransaction();
                    try {
                        supportSQLiteStatementAcquire.executeUpdateDelete();
                        PantryDao_Impl.this.__db.setTransactionSuccessful();
                        Unit unit = Unit.INSTANCE;
                        PantryDao_Impl.this.__db.endTransaction();
                        PantryDao_Impl.this.__preparedStmtOfSetNeedsToBuy.release(supportSQLiteStatementAcquire);
                        return unit;
                    } catch (Throwable th) {
                        PantryDao_Impl.this.__db.endTransaction();
                        throw th;
                    }
                } catch (Throwable th2) {
                    PantryDao_Impl.this.__preparedStmtOfSetNeedsToBuy.release(supportSQLiteStatementAcquire);
                    throw th2;
                }
            }
        }, $completion);
    }

    @Override // com.easycompra.app.data.pantry.PantryDao
    public Object deleteProduct(final String id, final Continuation<? super Unit> $completion) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Unit>() { // from class: com.easycompra.app.data.pantry.PantryDao_Impl.16
            @Override // java.util.concurrent.Callable
            public Unit call() throws Exception {
                SupportSQLiteStatement _stmt = PantryDao_Impl.this.__preparedStmtOfDeleteProduct.acquire();
                _stmt.bindString(1, id);
                try {
                    PantryDao_Impl.this.__db.beginTransaction();
                    try {
                        _stmt.executeUpdateDelete();
                        PantryDao_Impl.this.__db.setTransactionSuccessful();
                        Unit unit = Unit.INSTANCE;
                        PantryDao_Impl.this.__db.endTransaction();
                        PantryDao_Impl.this.__preparedStmtOfDeleteProduct.release(_stmt);
                        return unit;
                    } catch (Throwable th) {
                        PantryDao_Impl.this.__db.endTransaction();
                        throw th;
                    }
                } catch (Throwable th2) {
                    PantryDao_Impl.this.__preparedStmtOfDeleteProduct.release(_stmt);
                    throw th2;
                }
            }
        }, $completion);
    }

    @Override // com.easycompra.app.data.pantry.PantryDao
    public Flow<List<PantryProductWithLocations>> observeAll() {
        final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire("SELECT * FROM pantry_products ORDER BY name COLLATE NOCASE ASC", 0);
        return CoroutinesRoom.createFlow(this.__db, true, new String[]{"pantry_locations", "pantry_products"}, new Callable<List<PantryProductWithLocations>>() { // from class: com.easycompra.app.data.pantry.PantryDao_Impl.17
            @Override // java.util.concurrent.Callable
            public List<PantryProductWithLocations> call() throws Exception {
                PantryDao_Impl.this.__db.beginTransaction();
                try {
                    boolean z = true;
                    Cursor _cursor = DBUtil.query(PantryDao_Impl.this.__db, _statement, true, null);
                    try {
                        int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
                        int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, HintConstants.AUTOFILL_HINT_NAME);
                        int _cursorIndexOfNeedsToBuy = CursorUtil.getColumnIndexOrThrow(_cursor, "needsToBuy");
                        int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
                        ArrayMap<String, ArrayList<PantryLocationEntity>> _collectionLocations = new ArrayMap<>();
                        while (_cursor.moveToNext()) {
                            String _tmpKey = _cursor.getString(_cursorIndexOfId);
                            if (!_collectionLocations.containsKey(_tmpKey)) {
                                _collectionLocations.put(_tmpKey, new ArrayList<>());
                            }
                        }
                        _cursor.moveToPosition(-1);
                        PantryDao_Impl.this.__fetchRelationshippantryLocationsAscomEasycompraAppDataPantryPantryLocationEntity(_collectionLocations);
                        List<PantryProductWithLocations> _result = new ArrayList<>(_cursor.getCount());
                        while (_cursor.moveToNext()) {
                            String _tmpId = _cursor.getString(_cursorIndexOfId);
                            String _tmpName = _cursor.getString(_cursorIndexOfName);
                            int _tmp = _cursor.getInt(_cursorIndexOfNeedsToBuy);
                            boolean _tmpNeedsToBuy = _tmp != 0 ? z : false;
                            long _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
                            PantryProductEntity _tmpProduct = new PantryProductEntity(_tmpId, _tmpName, _tmpNeedsToBuy, _tmpCreatedAt);
                            String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
                            ArrayList<PantryLocationEntity> _tmpLocationsCollection = _collectionLocations.get(_tmpKey_1);
                            int _cursorIndexOfId2 = _cursorIndexOfId;
                            PantryProductWithLocations _item = new PantryProductWithLocations(_tmpProduct, _tmpLocationsCollection);
                            _result.add(_item);
                            _cursorIndexOfId = _cursorIndexOfId2;
                            _cursorIndexOfName = _cursorIndexOfName;
                            z = true;
                        }
                        PantryDao_Impl.this.__db.setTransactionSuccessful();
                        _cursor.close();
                        PantryDao_Impl.this.__db.endTransaction();
                        return _result;
                    } catch (Throwable th) {
                        _cursor.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    PantryDao_Impl.this.__db.endTransaction();
                    throw th2;
                }
            }

            protected void finalize() {
                _statement.release();
            }
        });
    }

    @Override // com.easycompra.app.data.pantry.PantryDao
    public Flow<Integer> observeEmptyCount() {
        final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire("SELECT COUNT(*) FROM pantry_locations WHERE quantity <= 0", 0);
        return CoroutinesRoom.createFlow(this.__db, false, new String[]{"pantry_locations"}, new Callable<Integer>() { // from class: com.easycompra.app.data.pantry.PantryDao_Impl.18
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                Integer _result;
                Cursor _cursor = DBUtil.query(PantryDao_Impl.this.__db, _statement, false, null);
                try {
                    if (_cursor.moveToFirst()) {
                        int _tmp = _cursor.getInt(0);
                        _result = Integer.valueOf(_tmp);
                    } else {
                        _result = 0;
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

    @Override // com.easycompra.app.data.pantry.PantryDao
    public Object getProductWithLocations(final String id, final Continuation<? super PantryProductWithLocations> $completion) {
        final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire("SELECT * FROM pantry_products WHERE id = ?", 1);
        _statement.bindString(1, id);
        CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, true, _cancellationSignal, new Callable<PantryProductWithLocations>() { // from class: com.easycompra.app.data.pantry.PantryDao_Impl.19
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public PantryProductWithLocations call() throws Exception {
                PantryProductWithLocations _result;
                PantryDao_Impl.this.__db.beginTransaction();
                try {
                    boolean z = true;
                    Cursor _cursor = DBUtil.query(PantryDao_Impl.this.__db, _statement, true, null);
                    try {
                        int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
                        int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, HintConstants.AUTOFILL_HINT_NAME);
                        int _cursorIndexOfNeedsToBuy = CursorUtil.getColumnIndexOrThrow(_cursor, "needsToBuy");
                        int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
                        ArrayMap<String, ArrayList<PantryLocationEntity>> _collectionLocations = new ArrayMap<>();
                        while (_cursor.moveToNext()) {
                            String _tmpKey = _cursor.getString(_cursorIndexOfId);
                            if (!_collectionLocations.containsKey(_tmpKey)) {
                                _collectionLocations.put(_tmpKey, new ArrayList<>());
                            }
                        }
                        _cursor.moveToPosition(-1);
                        PantryDao_Impl.this.__fetchRelationshippantryLocationsAscomEasycompraAppDataPantryPantryLocationEntity(_collectionLocations);
                        if (_cursor.moveToFirst()) {
                            String _tmpId = _cursor.getString(_cursorIndexOfId);
                            String _tmpName = _cursor.getString(_cursorIndexOfName);
                            int _tmp = _cursor.getInt(_cursorIndexOfNeedsToBuy);
                            if (_tmp == 0) {
                                z = false;
                            }
                            boolean _tmpNeedsToBuy = z;
                            long _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
                            PantryProductEntity _tmpProduct = new PantryProductEntity(_tmpId, _tmpName, _tmpNeedsToBuy, _tmpCreatedAt);
                            String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
                            ArrayList<PantryLocationEntity> _tmpLocationsCollection = _collectionLocations.get(_tmpKey_1);
                            _result = new PantryProductWithLocations(_tmpProduct, _tmpLocationsCollection);
                        } else {
                            _result = null;
                        }
                        PantryDao_Impl.this.__db.setTransactionSuccessful();
                        _cursor.close();
                        _statement.release();
                        PantryDao_Impl.this.__db.endTransaction();
                        return _result;
                    } catch (Throwable th) {
                        _cursor.close();
                        _statement.release();
                        throw th;
                    }
                } catch (Throwable th2) {
                    PantryDao_Impl.this.__db.endTransaction();
                    throw th2;
                }
            }
        }, $completion);
    }

    @Override // com.easycompra.app.data.pantry.PantryDao
    public Object searchByName(final String query, final Continuation<? super List<PantryProductWithLocations>> $completion) {
        final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire("SELECT * FROM pantry_products WHERE LOWER(name) LIKE '%' || LOWER(?) || '%' ORDER BY name COLLATE NOCASE", 1);
        _statement.bindString(1, query);
        CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, true, _cancellationSignal, new Callable<List<PantryProductWithLocations>>() { // from class: com.easycompra.app.data.pantry.PantryDao_Impl.20
            @Override // java.util.concurrent.Callable
            public List<PantryProductWithLocations> call() throws Exception {
                PantryDao_Impl.this.__db.beginTransaction();
                try {
                    boolean z = true;
                    Cursor _cursor = DBUtil.query(PantryDao_Impl.this.__db, _statement, true, null);
                    try {
                        int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
                        int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, HintConstants.AUTOFILL_HINT_NAME);
                        int _cursorIndexOfNeedsToBuy = CursorUtil.getColumnIndexOrThrow(_cursor, "needsToBuy");
                        int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
                        ArrayMap<String, ArrayList<PantryLocationEntity>> _collectionLocations = new ArrayMap<>();
                        while (_cursor.moveToNext()) {
                            String _tmpKey = _cursor.getString(_cursorIndexOfId);
                            if (!_collectionLocations.containsKey(_tmpKey)) {
                                _collectionLocations.put(_tmpKey, new ArrayList<>());
                            }
                        }
                        _cursor.moveToPosition(-1);
                        PantryDao_Impl.this.__fetchRelationshippantryLocationsAscomEasycompraAppDataPantryPantryLocationEntity(_collectionLocations);
                        List<PantryProductWithLocations> _result = new ArrayList<>(_cursor.getCount());
                        while (_cursor.moveToNext()) {
                            String _tmpId = _cursor.getString(_cursorIndexOfId);
                            String _tmpName = _cursor.getString(_cursorIndexOfName);
                            int _tmp = _cursor.getInt(_cursorIndexOfNeedsToBuy);
                            boolean _tmpNeedsToBuy = _tmp != 0 ? z : false;
                            long _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
                            PantryProductEntity _tmpProduct = new PantryProductEntity(_tmpId, _tmpName, _tmpNeedsToBuy, _tmpCreatedAt);
                            String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
                            ArrayList<PantryLocationEntity> _tmpLocationsCollection = _collectionLocations.get(_tmpKey_1);
                            int _cursorIndexOfId2 = _cursorIndexOfId;
                            PantryProductWithLocations _item = new PantryProductWithLocations(_tmpProduct, _tmpLocationsCollection);
                            _result.add(_item);
                            _cursorIndexOfId = _cursorIndexOfId2;
                            _cursorIndexOfName = _cursorIndexOfName;
                            z = true;
                        }
                        PantryDao_Impl.this.__db.setTransactionSuccessful();
                        _cursor.close();
                        _statement.release();
                        PantryDao_Impl.this.__db.endTransaction();
                        return _result;
                    } catch (Throwable th) {
                        _cursor.close();
                        _statement.release();
                        throw th;
                    }
                } catch (Throwable th2) {
                    PantryDao_Impl.this.__db.endTransaction();
                    throw th2;
                }
            }
        }, $completion);
    }

    @Override // com.easycompra.app.data.pantry.PantryDao
    public Object getAll(final Continuation<? super List<PantryProductWithLocations>> $completion) {
        final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire("SELECT * FROM pantry_products ORDER BY name COLLATE NOCASE", 0);
        CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
        return CoroutinesRoom.execute(this.__db, true, _cancellationSignal, new Callable<List<PantryProductWithLocations>>() { // from class: com.easycompra.app.data.pantry.PantryDao_Impl.21
            @Override // java.util.concurrent.Callable
            public List<PantryProductWithLocations> call() throws Exception {
                PantryDao_Impl.this.__db.beginTransaction();
                try {
                    boolean z = true;
                    Cursor _cursor = DBUtil.query(PantryDao_Impl.this.__db, _statement, true, null);
                    try {
                        int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
                        int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, HintConstants.AUTOFILL_HINT_NAME);
                        int _cursorIndexOfNeedsToBuy = CursorUtil.getColumnIndexOrThrow(_cursor, "needsToBuy");
                        int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
                        ArrayMap<String, ArrayList<PantryLocationEntity>> _collectionLocations = new ArrayMap<>();
                        while (_cursor.moveToNext()) {
                            String _tmpKey = _cursor.getString(_cursorIndexOfId);
                            if (!_collectionLocations.containsKey(_tmpKey)) {
                                _collectionLocations.put(_tmpKey, new ArrayList<>());
                            }
                        }
                        _cursor.moveToPosition(-1);
                        PantryDao_Impl.this.__fetchRelationshippantryLocationsAscomEasycompraAppDataPantryPantryLocationEntity(_collectionLocations);
                        List<PantryProductWithLocations> _result = new ArrayList<>(_cursor.getCount());
                        while (_cursor.moveToNext()) {
                            String _tmpId = _cursor.getString(_cursorIndexOfId);
                            String _tmpName = _cursor.getString(_cursorIndexOfName);
                            int _tmp = _cursor.getInt(_cursorIndexOfNeedsToBuy);
                            boolean _tmpNeedsToBuy = _tmp != 0 ? z : false;
                            long _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
                            PantryProductEntity _tmpProduct = new PantryProductEntity(_tmpId, _tmpName, _tmpNeedsToBuy, _tmpCreatedAt);
                            String _tmpKey_1 = _cursor.getString(_cursorIndexOfId);
                            ArrayList<PantryLocationEntity> _tmpLocationsCollection = _collectionLocations.get(_tmpKey_1);
                            int _cursorIndexOfId2 = _cursorIndexOfId;
                            PantryProductWithLocations _item = new PantryProductWithLocations(_tmpProduct, _tmpLocationsCollection);
                            _result.add(_item);
                            _cursorIndexOfId = _cursorIndexOfId2;
                            _cursorIndexOfName = _cursorIndexOfName;
                            z = true;
                        }
                        PantryDao_Impl.this.__db.setTransactionSuccessful();
                        _cursor.close();
                        _statement.release();
                        PantryDao_Impl.this.__db.endTransaction();
                        return _result;
                    } catch (Throwable th) {
                        _cursor.close();
                        _statement.release();
                        throw th;
                    }
                } catch (Throwable th2) {
                    PantryDao_Impl.this.__db.endTransaction();
                    throw th2;
                }
            }
        }, $completion);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void __fetchRelationshippantryLocationsAscomEasycompraAppDataPantryPantryLocationEntity(final ArrayMap<String, ArrayList<PantryLocationEntity>> _map) {
        Set<String> __mapKeySet = _map.keySet();
        if (__mapKeySet.isEmpty()) {
            return;
        }
        if (_map.getSize() > 999) {
            RelationUtil.recursiveFetchArrayMap(_map, true, new Function1() { // from class: com.easycompra.app.data.pantry.PantryDao_Impl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return this.f$0.lambda$__fetchRelationshippantryLocationsAscomEasycompraAppDataPantryPantryLocationEntity$0((ArrayMap) obj);
                }
            });
            return;
        }
        StringBuilder _stringBuilder = StringUtil.newStringBuilder();
        _stringBuilder.append("SELECT `id`,`productId`,`category`,`subcategory`,`description`,`quantity`,`unit`,`updatedAt` FROM `pantry_locations` WHERE `productId` IN (");
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
            int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "productId");
            if (_itemKeyIndex != -1) {
                while (_cursor.moveToNext()) {
                    String _tmpKey = _cursor.getString(_itemKeyIndex);
                    ArrayList<PantryLocationEntity> _tmpRelation = _map.get(_tmpKey);
                    if (_tmpRelation != null) {
                        String _tmpId = _cursor.getString(0);
                        String _tmpProductId = _cursor.getString(1);
                        String _tmpCategory = _cursor.getString(2);
                        String _tmpSubcategory = _cursor.getString(3);
                        String _tmpDescription = _cursor.getString(4);
                        float _tmpQuantity = _cursor.getFloat(5);
                        String _tmpUnit = _cursor.getString(6);
                        long _tmpUpdatedAt = _cursor.getLong(7);
                        PantryLocationEntity _item_1 = new PantryLocationEntity(_tmpId, _tmpProductId, _tmpCategory, _tmpSubcategory, _tmpDescription, _tmpQuantity, _tmpUnit, _tmpUpdatedAt);
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
    public /* synthetic */ Unit lambda$__fetchRelationshippantryLocationsAscomEasycompraAppDataPantryPantryLocationEntity$0(ArrayMap map) {
        __fetchRelationshippantryLocationsAscomEasycompraAppDataPantryPantryLocationEntity(map);
        return Unit.INSTANCE;
    }
}
