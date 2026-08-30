package com.easycompra.app.data.recipes;

import android.content.Context;
import androidx.autofill.HintConstants;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.easycompra.app.data.pantry.PantryDao;
import com.easycompra.app.data.pantry.PantryDatabase;
import com.easycompra.app.data.pantry.PantryProductWithLocations;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: RecipeRepository.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bJt\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\fH\u0086@¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010#J\u0016\u0010$\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010%J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\f2\u0006\u0010(\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010%J$\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\f2\u0006\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020-H\u0086@¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010%R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/easycompra/app/data/recipes/RecipeRepository;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "dao", "Lcom/easycompra/app/data/recipes/RecipeDao;", "pantryDao", "Lcom/easycompra/app/data/pantry/PantryDao;", "observeAll", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/easycompra/app/data/recipes/RecipeWithDetails;", "save", "", "id", "", HintConstants.AUTOFILL_HINT_NAME, "category", "photoUrl", "prepTimeMinutes", "", "baseServings", "difficulty", "notes", "isFavorite", "", "ingredients", "Lcom/easycompra/app/data/recipes/IngredientEntity;", "steps", "Lcom/easycompra/app/data/recipes/RecipeStepEntity;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;ZLjava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toggleFavorite", "current", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchPantry", "Lcom/easycompra/app/data/pantry/PantryProductWithLocations;", "query", "compareWithPantry", "Lcom/easycompra/app/data/recipes/IngredientResult;", "recipe", "servings", "", "(Lcom/easycompra/app/data/recipes/RecipeWithDetails;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markPantryNeedsBuy", "productId", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RecipeRepository {
    public static final int $stable = 0;
    private final RecipeDao dao;
    private final PantryDao pantryDao;

    /* JADX INFO: renamed from: com.easycompra.app.data.recipes.RecipeRepository$compareWithPantry$1, reason: invalid class name */
    /* JADX INFO: compiled from: RecipeRepository.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.data.recipes.RecipeRepository", f = "RecipeRepository.kt", i = {0, 0, 0, 0, 0}, l = {74}, m = "compareWithPantry", n = {"this", "destination$iv$iv", "ingredient", "factor", "scaled"}, s = {"L$0", "L$1", "L$3", "F$0", "F$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        float F$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RecipeRepository.this.compareWithPantry(null, 0.0f, this);
        }
    }

    /* JADX INFO: renamed from: com.easycompra.app.data.recipes.RecipeRepository$save$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RecipeRepository.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.data.recipes.RecipeRepository", f = "RecipeRepository.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4}, l = {AccessibilityNodeInfoCompat.MAX_NUMBER_OF_PREFETCHED_NODES, 51, 52, 53, 55}, m = "save", n = {"this", "ingredients", "steps", "recipeId", "this", "ingredients", "steps", "recipeId", "this", "ingredients", "steps", "recipeId", "this", "steps", "recipeId", "this", "recipeId", "index$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0", "L$1", "I$0"})
    static final class C07121 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C07121(Continuation<? super C07121> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RecipeRepository.this.save(null, null, null, null, 0, 0, null, null, false, null, null, this);
        }
    }

    public RecipeRepository(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.dao = RecipeDatabase.INSTANCE.get(context).recipeDao();
        this.pantryDao = PantryDatabase.INSTANCE.get(context).pantryDao();
    }

    public final Flow<List<RecipeWithDetails>> observeAll() {
        return this.dao.observeAll();
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0111 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:33:0x0125 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:37:0x0138  */
    /* JADX WARN: Code duplicated, block: B:40:0x0179 A[LOOP:1: B:35:0x0132->B:40:0x0179, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:45:0x0192  */
    /* JADX WARN: Code duplicated, block: B:47:0x019a  */
    /* JADX WARN: Code duplicated, block: B:51:0x01d9 A[LOOP:0: B:43:0x018c->B:51:0x01d9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:55:0x01d8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x0178 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object save(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6, boolean isFavorite, List<IngredientEntity> list, List<RecipeStepEntity> list2, Continuation<? super Unit> continuation) {
        C07121 c07121;
        RecipeRepository recipeRepository;
        Iterable iterable;
        List ingredients;
        String recipeId;
        RecipeDao recipeDao;
        RecipeDao recipeDao2;
        Iterator it;
        RecipeRepository recipeRepository2;
        String recipeId2;
        Iterable iterable2;
        int index$iv;
        String recipeId3;
        Iterator it2;
        RecipeDao recipeDao3;
        IngredientEntity ingredientEntityCopy$default;
        int index$iv2;
        RecipeDao recipeDao4;
        RecipeStepEntity recipeStepEntityCopy$default;
        if (continuation instanceof C07121) {
            c07121 = (C07121) continuation;
            if ((c07121.label & Integer.MIN_VALUE) != 0) {
                c07121.label -= Integer.MIN_VALUE;
            } else {
                c07121 = new C07121(continuation);
            }
        } else {
            c07121 = new C07121(continuation);
        }
        Object $result = c07121.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c07121.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                recipeRepository = this;
                iterable = list2;
                ingredients = list;
                String id = str;
                if (id == null) {
                    id = UUID.randomUUID().toString();
                    Intrinsics.checkNotNullExpressionValue(id, "toString(...)");
                }
                String recipeId4 = id;
                RecipeEntity recipe = new RecipeEntity(recipeId4, str2, str3, str4, i, i2, str5, str6, isFavorite, 0L, System.currentTimeMillis(), 512, null);
                RecipeDao recipeDao5 = recipeRepository.dao;
                c07121.L$0 = recipeRepository;
                c07121.L$1 = ingredients;
                c07121.L$2 = iterable;
                c07121.L$3 = recipeId4;
                c07121.label = 1;
                if (recipeDao5.insertRecipe(recipe, c07121) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                recipeId = recipeId4;
                recipeDao = recipeRepository.dao;
                c07121.L$0 = recipeRepository;
                c07121.L$1 = ingredients;
                c07121.L$2 = iterable;
                c07121.L$3 = recipeId;
                c07121.label = 2;
                if (recipeDao.deleteIngredientsOf(recipeId, c07121) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                recipeDao2 = recipeRepository.dao;
                c07121.L$0 = recipeRepository;
                c07121.L$1 = ingredients;
                c07121.L$2 = iterable;
                c07121.L$3 = recipeId;
                c07121.label = 3;
                if (recipeDao2.deleteStepsOf(recipeId, c07121) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                List $this$forEach$iv = ingredients;
                it = $this$forEach$iv.iterator();
                recipeRepository2 = recipeRepository;
                recipeId2 = recipeId;
                iterable2 = iterable;
                while (it.hasNext()) {
                    Object element$iv = it.next();
                    IngredientEntity it3 = (IngredientEntity) element$iv;
                    recipeDao3 = recipeRepository2.dao;
                    ingredientEntityCopy$default = IngredientEntity.copy$default(it3, null, recipeId2, null, 0.0f, null, null, null, 125, null);
                    c07121.L$0 = recipeRepository2;
                    c07121.L$1 = iterable2;
                    c07121.L$2 = recipeId2;
                    c07121.L$3 = it;
                    c07121.label = 4;
                    if (recipeDao3.insertIngredient(ingredientEntityCopy$default, c07121) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                Iterable $this$forEachIndexed$iv = iterable2;
                index$iv = 0;
                recipeId3 = recipeId2;
                it2 = $this$forEachIndexed$iv.iterator();
                while (it2.hasNext()) {
                    Object item$iv = it2.next();
                    index$iv2 = index$iv + 1;
                    if (index$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    RecipeStepEntity step = (RecipeStepEntity) item$iv;
                    int i3 = index$iv;
                    recipeDao4 = recipeRepository2.dao;
                    recipeStepEntityCopy$default = RecipeStepEntity.copy$default(step, null, recipeId3, i3 + 1, null, 0, 25, null);
                    c07121.L$0 = recipeRepository2;
                    c07121.L$1 = recipeId3;
                    c07121.L$2 = it2;
                    c07121.L$3 = null;
                    c07121.I$0 = index$iv2;
                    c07121.label = 5;
                    if (recipeDao4.insertStep(recipeStepEntityCopy$default, c07121) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    index$iv = index$iv2;
                }
                return Unit.INSTANCE;
            case 1:
                recipeId = (String) c07121.L$3;
                iterable = (List) c07121.L$2;
                ingredients = (List) c07121.L$1;
                recipeRepository = (RecipeRepository) c07121.L$0;
                ResultKt.throwOnFailure($result);
                recipeDao = recipeRepository.dao;
                c07121.L$0 = recipeRepository;
                c07121.L$1 = ingredients;
                c07121.L$2 = iterable;
                c07121.L$3 = recipeId;
                c07121.label = 2;
                if (recipeDao.deleteIngredientsOf(recipeId, c07121) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                recipeDao2 = recipeRepository.dao;
                c07121.L$0 = recipeRepository;
                c07121.L$1 = ingredients;
                c07121.L$2 = iterable;
                c07121.L$3 = recipeId;
                c07121.label = 3;
                if (recipeDao2.deleteStepsOf(recipeId, c07121) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                List $this$forEach$iv2 = ingredients;
                it = $this$forEach$iv2.iterator();
                recipeRepository2 = recipeRepository;
                recipeId2 = recipeId;
                iterable2 = iterable;
                while (it.hasNext()) {
                    Object element$iv2 = it.next();
                    IngredientEntity it4 = (IngredientEntity) element$iv2;
                    recipeDao3 = recipeRepository2.dao;
                    ingredientEntityCopy$default = IngredientEntity.copy$default(it4, null, recipeId2, null, 0.0f, null, null, null, 125, null);
                    c07121.L$0 = recipeRepository2;
                    c07121.L$1 = iterable2;
                    c07121.L$2 = recipeId2;
                    c07121.L$3 = it;
                    c07121.label = 4;
                    if (recipeDao3.insertIngredient(ingredientEntityCopy$default, c07121) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                Iterable $this$forEachIndexed$iv2 = iterable2;
                index$iv = 0;
                recipeId3 = recipeId2;
                it2 = $this$forEachIndexed$iv2.iterator();
                while (it2.hasNext()) {
                    Object item$iv2 = it2.next();
                    index$iv2 = index$iv + 1;
                    if (index$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    RecipeStepEntity step2 = (RecipeStepEntity) item$iv2;
                    int i4 = index$iv;
                    recipeDao4 = recipeRepository2.dao;
                    recipeStepEntityCopy$default = RecipeStepEntity.copy$default(step2, null, recipeId3, i4 + 1, null, 0, 25, null);
                    c07121.L$0 = recipeRepository2;
                    c07121.L$1 = recipeId3;
                    c07121.L$2 = it2;
                    c07121.L$3 = null;
                    c07121.I$0 = index$iv2;
                    c07121.label = 5;
                    if (recipeDao4.insertStep(recipeStepEntityCopy$default, c07121) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    index$iv = index$iv2;
                }
                return Unit.INSTANCE;
            case 2:
                recipeId = (String) c07121.L$3;
                iterable = (List) c07121.L$2;
                ingredients = (List) c07121.L$1;
                recipeRepository = (RecipeRepository) c07121.L$0;
                ResultKt.throwOnFailure($result);
                recipeDao2 = recipeRepository.dao;
                c07121.L$0 = recipeRepository;
                c07121.L$1 = ingredients;
                c07121.L$2 = iterable;
                c07121.L$3 = recipeId;
                c07121.label = 3;
                if (recipeDao2.deleteStepsOf(recipeId, c07121) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                List $this$forEach$iv3 = ingredients;
                it = $this$forEach$iv3.iterator();
                recipeRepository2 = recipeRepository;
                recipeId2 = recipeId;
                iterable2 = iterable;
                while (it.hasNext()) {
                    Object element$iv3 = it.next();
                    IngredientEntity it5 = (IngredientEntity) element$iv3;
                    recipeDao3 = recipeRepository2.dao;
                    ingredientEntityCopy$default = IngredientEntity.copy$default(it5, null, recipeId2, null, 0.0f, null, null, null, 125, null);
                    c07121.L$0 = recipeRepository2;
                    c07121.L$1 = iterable2;
                    c07121.L$2 = recipeId2;
                    c07121.L$3 = it;
                    c07121.label = 4;
                    if (recipeDao3.insertIngredient(ingredientEntityCopy$default, c07121) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                Iterable $this$forEachIndexed$iv3 = iterable2;
                index$iv = 0;
                recipeId3 = recipeId2;
                it2 = $this$forEachIndexed$iv3.iterator();
                while (it2.hasNext()) {
                    Object item$iv3 = it2.next();
                    index$iv2 = index$iv + 1;
                    if (index$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    RecipeStepEntity step3 = (RecipeStepEntity) item$iv3;
                    int i5 = index$iv;
                    recipeDao4 = recipeRepository2.dao;
                    recipeStepEntityCopy$default = RecipeStepEntity.copy$default(step3, null, recipeId3, i5 + 1, null, 0, 25, null);
                    c07121.L$0 = recipeRepository2;
                    c07121.L$1 = recipeId3;
                    c07121.L$2 = it2;
                    c07121.L$3 = null;
                    c07121.I$0 = index$iv2;
                    c07121.label = 5;
                    if (recipeDao4.insertStep(recipeStepEntityCopy$default, c07121) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    index$iv = index$iv2;
                }
                return Unit.INSTANCE;
            case 3:
                recipeId = (String) c07121.L$3;
                iterable = (List) c07121.L$2;
                ingredients = (List) c07121.L$1;
                recipeRepository = (RecipeRepository) c07121.L$0;
                ResultKt.throwOnFailure($result);
                List $this$forEach$iv4 = ingredients;
                it = $this$forEach$iv4.iterator();
                recipeRepository2 = recipeRepository;
                recipeId2 = recipeId;
                iterable2 = iterable;
                while (it.hasNext()) {
                    Object element$iv4 = it.next();
                    IngredientEntity it6 = (IngredientEntity) element$iv4;
                    recipeDao3 = recipeRepository2.dao;
                    ingredientEntityCopy$default = IngredientEntity.copy$default(it6, null, recipeId2, null, 0.0f, null, null, null, 125, null);
                    c07121.L$0 = recipeRepository2;
                    c07121.L$1 = iterable2;
                    c07121.L$2 = recipeId2;
                    c07121.L$3 = it;
                    c07121.label = 4;
                    if (recipeDao3.insertIngredient(ingredientEntityCopy$default, c07121) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                Iterable $this$forEachIndexed$iv4 = iterable2;
                index$iv = 0;
                recipeId3 = recipeId2;
                it2 = $this$forEachIndexed$iv4.iterator();
                while (it2.hasNext()) {
                    Object item$iv4 = it2.next();
                    index$iv2 = index$iv + 1;
                    if (index$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    RecipeStepEntity step4 = (RecipeStepEntity) item$iv4;
                    int i6 = index$iv;
                    recipeDao4 = recipeRepository2.dao;
                    recipeStepEntityCopy$default = RecipeStepEntity.copy$default(step4, null, recipeId3, i6 + 1, null, 0, 25, null);
                    c07121.L$0 = recipeRepository2;
                    c07121.L$1 = recipeId3;
                    c07121.L$2 = it2;
                    c07121.L$3 = null;
                    c07121.I$0 = index$iv2;
                    c07121.label = 5;
                    if (recipeDao4.insertStep(recipeStepEntityCopy$default, c07121) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    index$iv = index$iv2;
                }
                return Unit.INSTANCE;
            case 4:
                it = (Iterator) c07121.L$3;
                recipeId2 = (String) c07121.L$2;
                iterable2 = (List) c07121.L$1;
                recipeRepository2 = (RecipeRepository) c07121.L$0;
                ResultKt.throwOnFailure($result);
                while (it.hasNext()) {
                    Object element$iv5 = it.next();
                    IngredientEntity it7 = (IngredientEntity) element$iv5;
                    recipeDao3 = recipeRepository2.dao;
                    ingredientEntityCopy$default = IngredientEntity.copy$default(it7, null, recipeId2, null, 0.0f, null, null, null, 125, null);
                    c07121.L$0 = recipeRepository2;
                    c07121.L$1 = iterable2;
                    c07121.L$2 = recipeId2;
                    c07121.L$3 = it;
                    c07121.label = 4;
                    if (recipeDao3.insertIngredient(ingredientEntityCopy$default, c07121) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                Iterable $this$forEachIndexed$iv5 = iterable2;
                index$iv = 0;
                recipeId3 = recipeId2;
                it2 = $this$forEachIndexed$iv5.iterator();
                while (it2.hasNext()) {
                    Object item$iv5 = it2.next();
                    index$iv2 = index$iv + 1;
                    if (index$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    RecipeStepEntity step5 = (RecipeStepEntity) item$iv5;
                    int i7 = index$iv;
                    recipeDao4 = recipeRepository2.dao;
                    recipeStepEntityCopy$default = RecipeStepEntity.copy$default(step5, null, recipeId3, i7 + 1, null, 0, 25, null);
                    c07121.L$0 = recipeRepository2;
                    c07121.L$1 = recipeId3;
                    c07121.L$2 = it2;
                    c07121.L$3 = null;
                    c07121.I$0 = index$iv2;
                    c07121.label = 5;
                    if (recipeDao4.insertStep(recipeStepEntityCopy$default, c07121) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    index$iv = index$iv2;
                }
                return Unit.INSTANCE;
            case 5:
                index$iv = c07121.I$0;
                it2 = (Iterator) c07121.L$2;
                recipeId3 = (String) c07121.L$1;
                recipeRepository2 = (RecipeRepository) c07121.L$0;
                ResultKt.throwOnFailure($result);
                while (it2.hasNext()) {
                    Object item$iv6 = it2.next();
                    index$iv2 = index$iv + 1;
                    if (index$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    RecipeStepEntity step6 = (RecipeStepEntity) item$iv6;
                    int i8 = index$iv;
                    recipeDao4 = recipeRepository2.dao;
                    recipeStepEntityCopy$default = RecipeStepEntity.copy$default(step6, null, recipeId3, i8 + 1, null, 0, 25, null);
                    c07121.L$0 = recipeRepository2;
                    c07121.L$1 = recipeId3;
                    c07121.L$2 = it2;
                    c07121.L$3 = null;
                    c07121.I$0 = index$iv2;
                    c07121.label = 5;
                    if (recipeDao4.insertStep(recipeStepEntityCopy$default, c07121) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    index$iv = index$iv2;
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object toggleFavorite(String id, boolean current, Continuation<? super Unit> continuation) {
        Object favorite$default = RecipeDao.DefaultImpls.setFavorite$default(this.dao, id, !current, 0L, continuation, 4, null);
        return favorite$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? favorite$default : Unit.INSTANCE;
    }

    public final Object delete(String id, Continuation<? super Unit> continuation) {
        Object objDeleteRecipe = this.dao.deleteRecipe(id, continuation);
        return objDeleteRecipe == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteRecipe : Unit.INSTANCE;
    }

    public final Object searchPantry(String query, Continuation<? super List<PantryProductWithLocations>> continuation) {
        return query.length() < 2 ? CollectionsKt.emptyList() : this.pantryDao.searchByName(query, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:18:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:19:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:21:0x00ed A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:25:0x0107  */
    /* JADX WARN: Code duplicated, block: B:53:0x0208 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00b7 -> B:55:0x0234). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00ee -> B:23:0x0103). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object compareWithPantry(com.easycompra.app.data.recipes.RecipeWithDetails r26, float r27, kotlin.coroutines.Continuation<? super java.util.List<com.easycompra.app.data.recipes.IngredientResult>> r28) {
        /*
            Method dump skipped, instruction units count: 588
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easycompra.app.data.recipes.RecipeRepository.compareWithPantry(com.easycompra.app.data.recipes.RecipeWithDetails, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object markPantryNeedsBuy(String productId, Continuation<? super Unit> continuation) {
        Object needsToBuy = this.pantryDao.setNeedsToBuy(productId, true, continuation);
        return needsToBuy == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? needsToBuy : Unit.INSTANCE;
    }
}
