package com.easycompra.app.data.recipes;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecipeRepository.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/easycompra/app/data/recipes/IngredientStatus;", "", "<init>", "()V", "OK", "Partial", "Missing", "UnitMismatch", "Unlinked", "Lcom/easycompra/app/data/recipes/IngredientStatus$Missing;", "Lcom/easycompra/app/data/recipes/IngredientStatus$OK;", "Lcom/easycompra/app/data/recipes/IngredientStatus$Partial;", "Lcom/easycompra/app/data/recipes/IngredientStatus$UnitMismatch;", "Lcom/easycompra/app/data/recipes/IngredientStatus$Unlinked;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class IngredientStatus {
    public static final int $stable = 0;

    public /* synthetic */ IngredientStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: RecipeRepository.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/easycompra/app/data/recipes/IngredientStatus$OK;", "Lcom/easycompra/app/data/recipes/IngredientStatus;", "available", "", "<init>", "(F)V", "getAvailable", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class OK extends IngredientStatus {
        public static final int $stable = 0;
        private final float available;

        public static /* synthetic */ OK copy$default(OK ok, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = ok.available;
            }
            return ok.copy(f);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getAvailable() {
            return this.available;
        }

        public final OK copy(float available) {
            return new OK(available);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OK) && Float.compare(this.available, ((OK) other).available) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.available);
        }

        public String toString() {
            return "OK(available=" + this.available + ")";
        }

        public OK(float available) {
            super(null);
            this.available = available;
        }

        public final float getAvailable() {
            return this.available;
        }
    }

    private IngredientStatus() {
    }

    /* JADX INFO: compiled from: RecipeRepository.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/easycompra/app/data/recipes/IngredientStatus$Partial;", "Lcom/easycompra/app/data/recipes/IngredientStatus;", "available", "", "deficit", "<init>", "(FF)V", "getAvailable", "()F", "getDeficit", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Partial extends IngredientStatus {
        public static final int $stable = 0;
        private final float available;
        private final float deficit;

        public static /* synthetic */ Partial copy$default(Partial partial, float f, float f2, int i, Object obj) {
            if ((i & 1) != 0) {
                f = partial.available;
            }
            if ((i & 2) != 0) {
                f2 = partial.deficit;
            }
            return partial.copy(f, f2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getAvailable() {
            return this.available;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final float getDeficit() {
            return this.deficit;
        }

        public final Partial copy(float available, float deficit) {
            return new Partial(available, deficit);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Partial)) {
                return false;
            }
            Partial partial = (Partial) other;
            return Float.compare(this.available, partial.available) == 0 && Float.compare(this.deficit, partial.deficit) == 0;
        }

        public int hashCode() {
            return (Float.hashCode(this.available) * 31) + Float.hashCode(this.deficit);
        }

        public String toString() {
            return "Partial(available=" + this.available + ", deficit=" + this.deficit + ")";
        }

        public Partial(float available, float deficit) {
            super(null);
            this.available = available;
            this.deficit = deficit;
        }

        public final float getAvailable() {
            return this.available;
        }

        public final float getDeficit() {
            return this.deficit;
        }
    }

    /* JADX INFO: compiled from: RecipeRepository.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/easycompra/app/data/recipes/IngredientStatus$Missing;", "Lcom/easycompra/app/data/recipes/IngredientStatus;", "deficit", "", "<init>", "(F)V", "getDeficit", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Missing extends IngredientStatus {
        public static final int $stable = 0;
        private final float deficit;

        public static /* synthetic */ Missing copy$default(Missing missing, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                f = missing.deficit;
            }
            return missing.copy(f);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getDeficit() {
            return this.deficit;
        }

        public final Missing copy(float deficit) {
            return new Missing(deficit);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Missing) && Float.compare(this.deficit, ((Missing) other).deficit) == 0;
        }

        public int hashCode() {
            return Float.hashCode(this.deficit);
        }

        public String toString() {
            return "Missing(deficit=" + this.deficit + ")";
        }

        public Missing(float deficit) {
            super(null);
            this.deficit = deficit;
        }

        public final float getDeficit() {
            return this.deficit;
        }
    }

    /* JADX INFO: compiled from: RecipeRepository.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/easycompra/app/data/recipes/IngredientStatus$UnitMismatch;", "Lcom/easycompra/app/data/recipes/IngredientStatus;", "pantryQty", "", "pantryUnit", "", "<init>", "(FLjava/lang/String;)V", "getPantryQty", "()F", "getPantryUnit", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class UnitMismatch extends IngredientStatus {
        public static final int $stable = 0;
        private final float pantryQty;
        private final String pantryUnit;

        public static /* synthetic */ UnitMismatch copy$default(UnitMismatch unitMismatch, float f, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                f = unitMismatch.pantryQty;
            }
            if ((i & 2) != 0) {
                str = unitMismatch.pantryUnit;
            }
            return unitMismatch.copy(f, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final float getPantryQty() {
            return this.pantryQty;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getPantryUnit() {
            return this.pantryUnit;
        }

        public final UnitMismatch copy(float pantryQty, String pantryUnit) {
            Intrinsics.checkNotNullParameter(pantryUnit, "pantryUnit");
            return new UnitMismatch(pantryQty, pantryUnit);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UnitMismatch)) {
                return false;
            }
            UnitMismatch unitMismatch = (UnitMismatch) other;
            return Float.compare(this.pantryQty, unitMismatch.pantryQty) == 0 && Intrinsics.areEqual(this.pantryUnit, unitMismatch.pantryUnit);
        }

        public int hashCode() {
            return (Float.hashCode(this.pantryQty) * 31) + this.pantryUnit.hashCode();
        }

        public String toString() {
            return "UnitMismatch(pantryQty=" + this.pantryQty + ", pantryUnit=" + this.pantryUnit + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UnitMismatch(float pantryQty, String pantryUnit) {
            super(null);
            Intrinsics.checkNotNullParameter(pantryUnit, "pantryUnit");
            this.pantryQty = pantryQty;
            this.pantryUnit = pantryUnit;
        }

        public final float getPantryQty() {
            return this.pantryQty;
        }

        public final String getPantryUnit() {
            return this.pantryUnit;
        }
    }

    /* JADX INFO: compiled from: RecipeRepository.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/easycompra/app/data/recipes/IngredientStatus$Unlinked;", "Lcom/easycompra/app/data/recipes/IngredientStatus;", "<init>", "()V", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Unlinked extends IngredientStatus {
        public static final int $stable = 0;
        public static final Unlinked INSTANCE = new Unlinked();

        private Unlinked() {
            super(null);
        }
    }
}
