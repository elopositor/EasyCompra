package com.easycompra.app.ui.recipes;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateEditRecipeScreen.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/easycompra/app/ui/recipes/StepDraft;", "", "id", "", "description", "timeMinutes", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getDescription", "getTimeMinutes", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
final /* data */ class StepDraft {
    private final String description;
    private final String id;
    private final String timeMinutes;

    public StepDraft() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ StepDraft copy$default(StepDraft stepDraft, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stepDraft.id;
        }
        if ((i & 2) != 0) {
            str2 = stepDraft.description;
        }
        if ((i & 4) != 0) {
            str3 = stepDraft.timeMinutes;
        }
        return stepDraft.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTimeMinutes() {
        return this.timeMinutes;
    }

    public final StepDraft copy(String id, String description, String timeMinutes) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(timeMinutes, "timeMinutes");
        return new StepDraft(id, description, timeMinutes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StepDraft)) {
            return false;
        }
        StepDraft stepDraft = (StepDraft) other;
        return Intrinsics.areEqual(this.id, stepDraft.id) && Intrinsics.areEqual(this.description, stepDraft.description) && Intrinsics.areEqual(this.timeMinutes, stepDraft.timeMinutes);
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.description.hashCode()) * 31) + this.timeMinutes.hashCode();
    }

    public String toString() {
        return "StepDraft(id=" + this.id + ", description=" + this.description + ", timeMinutes=" + this.timeMinutes + ")";
    }

    public StepDraft(String id, String description, String timeMinutes) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(timeMinutes, "timeMinutes");
        this.id = id;
        this.description = description;
        this.timeMinutes = timeMinutes;
    }

    public /* synthetic */ StepDraft(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? UUID.randomUUID().toString() : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    public final String getId() {
        return this.id;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getTimeMinutes() {
        return this.timeMinutes;
    }
}
