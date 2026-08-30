package com.easycompra.app.data.recipes;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecipeStepEntity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/easycompra/app/data/recipes/RecipeStepEntity;", "", "id", "", "recipeId", "stepNumber", "", "description", "timeMinutes", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)V", "getId", "()Ljava/lang/String;", "getRecipeId", "getStepNumber", "()I", "getDescription", "getTimeMinutes", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class RecipeStepEntity {
    public static final int $stable = 0;
    private final String description;
    private final String id;
    private final String recipeId;
    private final int stepNumber;
    private final int timeMinutes;

    public static /* synthetic */ RecipeStepEntity copy$default(RecipeStepEntity recipeStepEntity, String str, String str2, int i, String str3, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = recipeStepEntity.id;
        }
        if ((i3 & 2) != 0) {
            str2 = recipeStepEntity.recipeId;
        }
        String str4 = str2;
        if ((i3 & 4) != 0) {
            i = recipeStepEntity.stepNumber;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            str3 = recipeStepEntity.description;
        }
        String str5 = str3;
        if ((i3 & 16) != 0) {
            i2 = recipeStepEntity.timeMinutes;
        }
        return recipeStepEntity.copy(str, str4, i4, str5, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRecipeId() {
        return this.recipeId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getStepNumber() {
        return this.stepNumber;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getTimeMinutes() {
        return this.timeMinutes;
    }

    public final RecipeStepEntity copy(String id, String recipeId, int stepNumber, String description, int timeMinutes) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(recipeId, "recipeId");
        Intrinsics.checkNotNullParameter(description, "description");
        return new RecipeStepEntity(id, recipeId, stepNumber, description, timeMinutes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecipeStepEntity)) {
            return false;
        }
        RecipeStepEntity recipeStepEntity = (RecipeStepEntity) other;
        return Intrinsics.areEqual(this.id, recipeStepEntity.id) && Intrinsics.areEqual(this.recipeId, recipeStepEntity.recipeId) && this.stepNumber == recipeStepEntity.stepNumber && Intrinsics.areEqual(this.description, recipeStepEntity.description) && this.timeMinutes == recipeStepEntity.timeMinutes;
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.recipeId.hashCode()) * 31) + Integer.hashCode(this.stepNumber)) * 31) + this.description.hashCode()) * 31) + Integer.hashCode(this.timeMinutes);
    }

    public String toString() {
        return "RecipeStepEntity(id=" + this.id + ", recipeId=" + this.recipeId + ", stepNumber=" + this.stepNumber + ", description=" + this.description + ", timeMinutes=" + this.timeMinutes + ")";
    }

    public RecipeStepEntity(String id, String recipeId, int stepNumber, String description, int timeMinutes) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(recipeId, "recipeId");
        Intrinsics.checkNotNullParameter(description, "description");
        this.id = id;
        this.recipeId = recipeId;
        this.stepNumber = stepNumber;
        this.description = description;
        this.timeMinutes = timeMinutes;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ RecipeStepEntity(String str, String str2, int i, String str3, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        int i4;
        if ((i3 & 16) == 0) {
            i4 = i2;
        } else {
            i4 = 0;
        }
        this(str, str2, i, str3, i4);
    }

    public final String getId() {
        return this.id;
    }

    public final String getRecipeId() {
        return this.recipeId;
    }

    public final int getStepNumber() {
        return this.stepNumber;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getTimeMinutes() {
        return this.timeMinutes;
    }
}
