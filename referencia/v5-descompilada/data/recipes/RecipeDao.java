package com.easycompra.app.data.recipes;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: RecipeDao.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H'J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H§@¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000eJ(\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH§@¢\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ\u0016\u0010 \u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ\u0016\u0010!\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\t¨\u0006\""}, d2 = {"Lcom/easycompra/app/data/recipes/RecipeDao;", "", "observeAll", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/easycompra/app/data/recipes/RecipeWithDetails;", "getById", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertRecipe", "", "recipe", "Lcom/easycompra/app/data/recipes/RecipeEntity;", "(Lcom/easycompra/app/data/recipes/RecipeEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertIngredient", "ingredient", "Lcom/easycompra/app/data/recipes/IngredientEntity;", "(Lcom/easycompra/app/data/recipes/IngredientEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertStep", "step", "Lcom/easycompra/app/data/recipes/RecipeStepEntity;", "(Lcom/easycompra/app/data/recipes/RecipeStepEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRecipe", "setFavorite", "fav", "", "ts", "", "(Ljava/lang/String;ZJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteIngredientsOf", "recipeId", "deleteStepsOf", "deleteRecipe", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface RecipeDao {
    Object deleteIngredientsOf(String str, Continuation<? super Unit> continuation);

    Object deleteRecipe(String str, Continuation<? super Unit> continuation);

    Object deleteStepsOf(String str, Continuation<? super Unit> continuation);

    Object getById(String str, Continuation<? super RecipeWithDetails> continuation);

    Object insertIngredient(IngredientEntity ingredientEntity, Continuation<? super Unit> continuation);

    Object insertRecipe(RecipeEntity recipeEntity, Continuation<? super Unit> continuation);

    Object insertStep(RecipeStepEntity recipeStepEntity, Continuation<? super Unit> continuation);

    Flow<List<RecipeWithDetails>> observeAll();

    Object setFavorite(String str, boolean z, long j, Continuation<? super Unit> continuation);

    Object updateRecipe(RecipeEntity recipeEntity, Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: RecipeDao.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object setFavorite$default(RecipeDao recipeDao, String str, boolean z, long j, Continuation continuation, int i, Object obj) {
            long jCurrentTimeMillis;
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setFavorite");
            }
            if ((i & 4) == 0) {
                jCurrentTimeMillis = j;
            } else {
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            return recipeDao.setFavorite(str, z, jCurrentTimeMillis, continuation);
        }
    }
}
