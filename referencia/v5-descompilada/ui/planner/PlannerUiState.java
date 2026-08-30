package com.easycompra.app.ui.planner;

import com.easycompra.app.data.planner.PlannerEntry;
import com.easycompra.app.data.planner.WeekAnalysis;
import com.easycompra.app.data.recipes.RecipeWithDetails;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: PlannerViewModel.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010$\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\b0*2\u0006\u0010+\u001a\u00020\u0003J\u000e\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u00100\u001a\u00020\nHÆ\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\f0\u0007HÆ\u0003J\u0017\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u00104\u001a\u00020\u0012HÆ\u0003Ju\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u00106\u001a\u00020\u00122\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0005HÖ\u0001J\t\u00109\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u001f\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078F¢\u0006\u0006\u001a\u0004\b%\u0010\u001aR\u0011\u0010&\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006:"}, d2 = {"Lcom/easycompra/app/ui/planner/PlannerUiState;", "", "weekStart", "Ljava/time/LocalDate;", "selectedDayIndex", "", "entries", "", "Lcom/easycompra/app/data/planner/PlannerEntry;", "analysis", "Lcom/easycompra/app/data/planner/WeekAnalysis;", "allRecipes", "Lcom/easycompra/app/data/recipes/RecipeWithDetails;", "editingSlot", "Lkotlin/Pair;", "", "editingEntry", "showMoveDialog", "", "<init>", "(Ljava/time/LocalDate;ILjava/util/List;Lcom/easycompra/app/data/planner/WeekAnalysis;Ljava/util/List;Lkotlin/Pair;Lcom/easycompra/app/data/planner/PlannerEntry;Z)V", "getWeekStart", "()Ljava/time/LocalDate;", "getSelectedDayIndex", "()I", "getEntries", "()Ljava/util/List;", "getAnalysis", "()Lcom/easycompra/app/data/planner/WeekAnalysis;", "getAllRecipes", "getEditingSlot", "()Lkotlin/Pair;", "getEditingEntry", "()Lcom/easycompra/app/data/planner/PlannerEntry;", "getShowMoveDialog", "()Z", "weekDates", "getWeekDates", "weekLabel", "getWeekLabel", "()Ljava/lang/String;", "entriesForDate", "", "date", "entryStatusForDate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class PlannerUiState {
    public static final int $stable = 8;
    private final List<RecipeWithDetails> allRecipes;
    private final WeekAnalysis analysis;
    private final PlannerEntry editingEntry;
    private final Pair<String, String> editingSlot;
    private final List<PlannerEntry> entries;
    private final int selectedDayIndex;
    private final boolean showMoveDialog;
    private final LocalDate weekStart;

    public PlannerUiState() {
        this(null, 0, null, null, null, null, null, false, 255, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final LocalDate getWeekStart() {
        return this.weekStart;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSelectedDayIndex() {
        return this.selectedDayIndex;
    }

    public final List<PlannerEntry> component3() {
        return this.entries;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final WeekAnalysis getAnalysis() {
        return this.analysis;
    }

    public final List<RecipeWithDetails> component5() {
        return this.allRecipes;
    }

    public final Pair<String, String> component6() {
        return this.editingSlot;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final PlannerEntry getEditingEntry() {
        return this.editingEntry;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getShowMoveDialog() {
        return this.showMoveDialog;
    }

    public final PlannerUiState copy(LocalDate weekStart, int selectedDayIndex, List<PlannerEntry> entries, WeekAnalysis analysis, List<RecipeWithDetails> allRecipes, Pair<String, String> editingSlot, PlannerEntry editingEntry, boolean showMoveDialog) {
        Intrinsics.checkNotNullParameter(weekStart, "weekStart");
        Intrinsics.checkNotNullParameter(entries, "entries");
        Intrinsics.checkNotNullParameter(analysis, "analysis");
        Intrinsics.checkNotNullParameter(allRecipes, "allRecipes");
        return new PlannerUiState(weekStart, selectedDayIndex, entries, analysis, allRecipes, editingSlot, editingEntry, showMoveDialog);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlannerUiState)) {
            return false;
        }
        PlannerUiState plannerUiState = (PlannerUiState) other;
        return Intrinsics.areEqual(this.weekStart, plannerUiState.weekStart) && this.selectedDayIndex == plannerUiState.selectedDayIndex && Intrinsics.areEqual(this.entries, plannerUiState.entries) && Intrinsics.areEqual(this.analysis, plannerUiState.analysis) && Intrinsics.areEqual(this.allRecipes, plannerUiState.allRecipes) && Intrinsics.areEqual(this.editingSlot, plannerUiState.editingSlot) && Intrinsics.areEqual(this.editingEntry, plannerUiState.editingEntry) && this.showMoveDialog == plannerUiState.showMoveDialog;
    }

    public int hashCode() {
        return (((((((((((((this.weekStart.hashCode() * 31) + Integer.hashCode(this.selectedDayIndex)) * 31) + this.entries.hashCode()) * 31) + this.analysis.hashCode()) * 31) + this.allRecipes.hashCode()) * 31) + (this.editingSlot == null ? 0 : this.editingSlot.hashCode())) * 31) + (this.editingEntry != null ? this.editingEntry.hashCode() : 0)) * 31) + Boolean.hashCode(this.showMoveDialog);
    }

    public String toString() {
        return "PlannerUiState(weekStart=" + this.weekStart + ", selectedDayIndex=" + this.selectedDayIndex + ", entries=" + this.entries + ", analysis=" + this.analysis + ", allRecipes=" + this.allRecipes + ", editingSlot=" + this.editingSlot + ", editingEntry=" + this.editingEntry + ", showMoveDialog=" + this.showMoveDialog + ")";
    }

    public PlannerUiState(LocalDate weekStart, int selectedDayIndex, List<PlannerEntry> entries, WeekAnalysis analysis, List<RecipeWithDetails> allRecipes, Pair<String, String> pair, PlannerEntry editingEntry, boolean showMoveDialog) {
        Intrinsics.checkNotNullParameter(weekStart, "weekStart");
        Intrinsics.checkNotNullParameter(entries, "entries");
        Intrinsics.checkNotNullParameter(analysis, "analysis");
        Intrinsics.checkNotNullParameter(allRecipes, "allRecipes");
        this.weekStart = weekStart;
        this.selectedDayIndex = selectedDayIndex;
        this.entries = entries;
        this.analysis = analysis;
        this.allRecipes = allRecipes;
        this.editingSlot = pair;
        this.editingEntry = editingEntry;
        this.showMoveDialog = showMoveDialog;
    }

    public /* synthetic */ PlannerUiState(LocalDate localDate, int i, List list, WeekAnalysis weekAnalysis, List list2, Pair pair, PlannerEntry plannerEntry, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? PlannerViewModelKt.currentWeekStart() : localDate, (i2 & 2) != 0 ? PlannerViewModelKt.todayIndex() : i, (i2 & 4) != 0 ? CollectionsKt.emptyList() : list, (i2 & 8) != 0 ? new WeekAnalysis(null, null, null, false, 15, null) : weekAnalysis, (i2 & 16) != 0 ? CollectionsKt.emptyList() : list2, (i2 & 32) != 0 ? null : pair, (i2 & 64) == 0 ? plannerEntry : null, (i2 & 128) != 0 ? false : z);
    }

    public final LocalDate getWeekStart() {
        return this.weekStart;
    }

    public final int getSelectedDayIndex() {
        return this.selectedDayIndex;
    }

    public final List<PlannerEntry> getEntries() {
        return this.entries;
    }

    public final WeekAnalysis getAnalysis() {
        return this.analysis;
    }

    public final List<RecipeWithDetails> getAllRecipes() {
        return this.allRecipes;
    }

    public final Pair<String, String> getEditingSlot() {
        return this.editingSlot;
    }

    public final PlannerEntry getEditingEntry() {
        return this.editingEntry;
    }

    public final boolean getShowMoveDialog() {
        return this.showMoveDialog;
    }

    public final List<LocalDate> getWeekDates() {
        Iterable $this$map$iv = new IntRange(0, 6);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        Iterator<Integer> it = $this$map$iv.iterator();
        while (it.hasNext()) {
            int item$iv$iv = ((IntIterator) it).nextInt();
            destination$iv$iv.add(this.weekStart.plusDays(item$iv$iv));
        }
        return (List) destination$iv$iv;
    }

    public final String getWeekLabel() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("d MMM");
        return this.weekStart.format(fmt) + " – " + this.weekStart.plusDays(6L).format(fmt);
    }

    public final Map<String, PlannerEntry> entriesForDate(LocalDate date) {
        Intrinsics.checkNotNullParameter(date, "date");
        String dateStr = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        Iterable $this$filter$iv = this.entries;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            PlannerEntry it = (PlannerEntry) element$iv$iv;
            if (Intrinsics.areEqual(it.getDate(), dateStr)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$associateBy$iv = (List) destination$iv$iv;
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        Map destination$iv$iv2 = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv2 : $this$associateBy$iv) {
            PlannerEntry it2 = (PlannerEntry) element$iv$iv2;
            destination$iv$iv2.put(it2.getMealSlot(), element$iv$iv2);
        }
        return destination$iv$iv2;
    }

    public final int entryStatusForDate(LocalDate date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return entriesForDate(date).size();
    }
}
