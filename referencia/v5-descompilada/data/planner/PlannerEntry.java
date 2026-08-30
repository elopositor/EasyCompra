package com.easycompra.app.data.planner;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlannerEntry.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\fHÆ\u0003J[\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2 = {"Lcom/easycompra/app/data/planner/PlannerEntry;", "", "id", "", "date", "mealSlot", "recipeId", "displayName", "servings", "", "notes", "createdAt", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;J)V", "getId", "()Ljava/lang/String;", "getDate", "getMealSlot", "getRecipeId", "getDisplayName", "getServings", "()F", "getNotes", "getCreatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class PlannerEntry {
    public static final int $stable = 0;
    private final long createdAt;
    private final String date;
    private final String displayName;
    private final String id;
    private final String mealSlot;
    private final String notes;
    private final String recipeId;
    private final float servings;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDate() {
        return this.date;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMealSlot() {
        return this.mealSlot;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getRecipeId() {
        return this.recipeId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final float getServings() {
        return this.servings;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getNotes() {
        return this.notes;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final PlannerEntry copy(String id, String date, String mealSlot, String recipeId, String displayName, float servings, String notes, long createdAt) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(mealSlot, "mealSlot");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(notes, "notes");
        return new PlannerEntry(id, date, mealSlot, recipeId, displayName, servings, notes, createdAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlannerEntry)) {
            return false;
        }
        PlannerEntry plannerEntry = (PlannerEntry) other;
        return Intrinsics.areEqual(this.id, plannerEntry.id) && Intrinsics.areEqual(this.date, plannerEntry.date) && Intrinsics.areEqual(this.mealSlot, plannerEntry.mealSlot) && Intrinsics.areEqual(this.recipeId, plannerEntry.recipeId) && Intrinsics.areEqual(this.displayName, plannerEntry.displayName) && Float.compare(this.servings, plannerEntry.servings) == 0 && Intrinsics.areEqual(this.notes, plannerEntry.notes) && this.createdAt == plannerEntry.createdAt;
    }

    public int hashCode() {
        return (((((((((((((this.id.hashCode() * 31) + this.date.hashCode()) * 31) + this.mealSlot.hashCode()) * 31) + (this.recipeId == null ? 0 : this.recipeId.hashCode())) * 31) + this.displayName.hashCode()) * 31) + Float.hashCode(this.servings)) * 31) + this.notes.hashCode()) * 31) + Long.hashCode(this.createdAt);
    }

    public String toString() {
        return "PlannerEntry(id=" + this.id + ", date=" + this.date + ", mealSlot=" + this.mealSlot + ", recipeId=" + this.recipeId + ", displayName=" + this.displayName + ", servings=" + this.servings + ", notes=" + this.notes + ", createdAt=" + this.createdAt + ")";
    }

    public PlannerEntry(String id, String date, String mealSlot, String recipeId, String displayName, float servings, String notes, long createdAt) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(mealSlot, "mealSlot");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(notes, "notes");
        this.id = id;
        this.date = date;
        this.mealSlot = mealSlot;
        this.recipeId = recipeId;
        this.displayName = displayName;
        this.servings = servings;
        this.notes = notes;
        this.createdAt = createdAt;
    }

    public /* synthetic */ PlannerEntry(String str, String str2, String str3, String str4, String str5, float f, String str6, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? UUID.randomUUID().toString() : str, str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? 1.0f : f, (i & 64) != 0 ? "" : str6, (i & 128) != 0 ? System.currentTimeMillis() : j);
    }

    public final String getId() {
        return this.id;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getMealSlot() {
        return this.mealSlot;
    }

    public final String getRecipeId() {
        return this.recipeId;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final float getServings() {
        return this.servings;
    }

    public final String getNotes() {
        return this.notes;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }
}
