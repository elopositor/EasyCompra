package com.easycompra.app.data.recipes;

import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecipeEntity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\"\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\rHÆ\u0003J\t\u0010*\u001a\u00020\u000fHÆ\u0003J\t\u0010+\u001a\u00020\u000fHÆ\u0003Jw\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fHÆ\u0001J\u0013\u0010-\u001a\u00020\r2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\bHÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001f¨\u00061"}, d2 = {"Lcom/easycompra/app/data/recipes/RecipeEntity;", "", "id", "", HintConstants.AUTOFILL_HINT_NAME, "category", "photoUrl", "prepTimeMinutes", "", "baseServings", "difficulty", "notes", "isFavorite", "", "createdAt", "", "updatedAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;ZJJ)V", "getId", "()Ljava/lang/String;", "getName", "getCategory", "getPhotoUrl", "getPrepTimeMinutes", "()I", "getBaseServings", "getDifficulty", "getNotes", "()Z", "getCreatedAt", "()J", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class RecipeEntity {
    public static final int $stable = 0;
    private final int baseServings;
    private final String category;
    private final long createdAt;
    private final String difficulty;
    private final String id;
    private final boolean isFavorite;
    private final String name;
    private final String notes;
    private final String photoUrl;
    private final int prepTimeMinutes;
    private final long updatedAt;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPhotoUrl() {
        return this.photoUrl;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getPrepTimeMinutes() {
        return this.prepTimeMinutes;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getBaseServings() {
        return this.baseServings;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getDifficulty() {
        return this.difficulty;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getNotes() {
        return this.notes;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getIsFavorite() {
        return this.isFavorite;
    }

    public final RecipeEntity copy(String id, String name, String category, String photoUrl, int prepTimeMinutes, int baseServings, String difficulty, String notes, boolean isFavorite, long createdAt, long updatedAt) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(photoUrl, "photoUrl");
        Intrinsics.checkNotNullParameter(difficulty, "difficulty");
        Intrinsics.checkNotNullParameter(notes, "notes");
        return new RecipeEntity(id, name, category, photoUrl, prepTimeMinutes, baseServings, difficulty, notes, isFavorite, createdAt, updatedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecipeEntity)) {
            return false;
        }
        RecipeEntity recipeEntity = (RecipeEntity) other;
        return Intrinsics.areEqual(this.id, recipeEntity.id) && Intrinsics.areEqual(this.name, recipeEntity.name) && Intrinsics.areEqual(this.category, recipeEntity.category) && Intrinsics.areEqual(this.photoUrl, recipeEntity.photoUrl) && this.prepTimeMinutes == recipeEntity.prepTimeMinutes && this.baseServings == recipeEntity.baseServings && Intrinsics.areEqual(this.difficulty, recipeEntity.difficulty) && Intrinsics.areEqual(this.notes, recipeEntity.notes) && this.isFavorite == recipeEntity.isFavorite && this.createdAt == recipeEntity.createdAt && this.updatedAt == recipeEntity.updatedAt;
    }

    public int hashCode() {
        return (((((((((((((((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.category.hashCode()) * 31) + this.photoUrl.hashCode()) * 31) + Integer.hashCode(this.prepTimeMinutes)) * 31) + Integer.hashCode(this.baseServings)) * 31) + this.difficulty.hashCode()) * 31) + this.notes.hashCode()) * 31) + Boolean.hashCode(this.isFavorite)) * 31) + Long.hashCode(this.createdAt)) * 31) + Long.hashCode(this.updatedAt);
    }

    public String toString() {
        return "RecipeEntity(id=" + this.id + ", name=" + this.name + ", category=" + this.category + ", photoUrl=" + this.photoUrl + ", prepTimeMinutes=" + this.prepTimeMinutes + ", baseServings=" + this.baseServings + ", difficulty=" + this.difficulty + ", notes=" + this.notes + ", isFavorite=" + this.isFavorite + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ")";
    }

    public RecipeEntity(String id, String name, String category, String photoUrl, int prepTimeMinutes, int baseServings, String difficulty, String notes, boolean isFavorite, long createdAt, long updatedAt) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(photoUrl, "photoUrl");
        Intrinsics.checkNotNullParameter(difficulty, "difficulty");
        Intrinsics.checkNotNullParameter(notes, "notes");
        this.id = id;
        this.name = name;
        this.category = category;
        this.photoUrl = photoUrl;
        this.prepTimeMinutes = prepTimeMinutes;
        this.baseServings = baseServings;
        this.difficulty = difficulty;
        this.notes = notes;
        this.isFavorite = isFavorite;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public /* synthetic */ RecipeEntity(String str, String str2, String str3, String str4, int i, int i2, String str5, String str6, boolean z, long j, long j2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? 0 : i, (i3 & 32) != 0 ? 4 : i2, (i3 & 64) != 0 ? RecipeDifficulty.MEDIUM : str5, (i3 & 128) != 0 ? "" : str6, (i3 & 256) != 0 ? false : z, (i3 & 512) != 0 ? System.currentTimeMillis() : j, (i3 & 1024) != 0 ? System.currentTimeMillis() : j2);
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getCategory() {
        return this.category;
    }

    public final String getPhotoUrl() {
        return this.photoUrl;
    }

    public final int getPrepTimeMinutes() {
        return this.prepTimeMinutes;
    }

    public final int getBaseServings() {
        return this.baseServings;
    }

    public final String getDifficulty() {
        return this.difficulty;
    }

    public final String getNotes() {
        return this.notes;
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }
}
