package com.easycompra.app.ui.recipes;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CreateEditRecipeScreen.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.easycompra.app.ui.recipes.CreateEditRecipeScreenKt$CreateEditRecipeScreen$1$1", f = "CreateEditRecipeScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CreateEditRecipeScreenKt$CreateEditRecipeScreen$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<String> $pantryQuery$delegate;
    final /* synthetic */ RecipeViewModel $viewModel;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CreateEditRecipeScreenKt$CreateEditRecipeScreen$1$1(RecipeViewModel recipeViewModel, MutableState<String> mutableState, Continuation<? super CreateEditRecipeScreenKt$CreateEditRecipeScreen$1$1> continuation) {
        super(2, continuation);
        this.$viewModel = recipeViewModel;
        this.$pantryQuery$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CreateEditRecipeScreenKt$CreateEditRecipeScreen$1$1(this.$viewModel, this.$pantryQuery$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CreateEditRecipeScreenKt$CreateEditRecipeScreen$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                if (CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$47(this.$pantryQuery$delegate).length() >= 2) {
                    this.$viewModel.searchPantry(CreateEditRecipeScreenKt.CreateEditRecipeScreen$lambda$47(this.$pantryQuery$delegate));
                } else {
                    this.$viewModel.clearPantrySearch();
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
