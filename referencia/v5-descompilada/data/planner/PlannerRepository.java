package com.easycompra.app.data.planner;

import android.content.Context;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.easycompra.app.data.pantry.PantryDao;
import com.easycompra.app.data.pantry.PantryDatabase;
import com.easycompra.app.data.recipes.RecipeDao;
import com.easycompra.app.data.recipes.RecipeDatabase;
import com.easycompra.app.data.recipes.RecipeRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: PlannerRepository.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00132\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0086@¢\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u001eH\u0086@¢\u0006\u0002\u0010#J&\u0010$\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u001eH\u0086@¢\u0006\u0002\u0010'J\u0016\u0010(\u001a\u00020)2\u0006\u0010\u0016\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006+"}, d2 = {"Lcom/easycompra/app/data/planner/PlannerRepository;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "dao", "Lcom/easycompra/app/data/planner/PlannerDao;", "pantryDao", "Lcom/easycompra/app/data/pantry/PantryDao;", "recipeDao", "Lcom/easycompra/app/data/recipes/RecipeDao;", "recipeRepo", "Lcom/easycompra/app/data/recipes/RecipeRepository;", "fmt", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "Ljava/time/format/DateTimeFormatter;", "observeWeek", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/easycompra/app/data/planner/PlannerEntry;", "weekStart", "Ljava/time/LocalDate;", "setSlot", "", "entry", "(Lcom/easycompra/app/data/planner/PlannerEntry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearSlot", "date", "", "slot", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteEntry", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "moveEntry", "newDate", "newSlot", "(Lcom/easycompra/app/data/planner/PlannerEntry;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "analyzeWeek", "Lcom/easycompra/app/data/planner/WeekAnalysis;", "(Ljava/time/LocalDate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PlannerRepository {
    public static final int $stable = 8;
    private final Context context;
    private final PlannerDao dao;
    private final DateTimeFormatter fmt;
    private final PantryDao pantryDao;
    private final RecipeDao recipeDao;
    private final RecipeRepository recipeRepo;

    /* JADX INFO: renamed from: com.easycompra.app.data.planner.PlannerRepository$analyzeWeek$1, reason: invalid class name */
    /* JADX INFO: compiled from: PlannerRepository.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.data.planner.PlannerRepository", f = "PlannerRepository.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5}, l = {MotionEventCompat.AXIS_GENERIC_12, AccessibilityNodeInfoCompat.MAX_NUMBER_OF_PREFETCHED_NODES, 51, 78, 96, 98}, m = "analyzeWeek", n = {"this", "today", "this", "today", "recipeEntries", "missingMap", "defrostList", "entry", "this", "today", "recipeEntries", "missingMap", "defrostList", "entry", "this", "today", "recipeEntries", "missingMap", "defrostList", "entry", "entryDate", "daysUntil", "this", "recipeEntries", "missingMap", "defrostList", "this", "missingMap", "defrostList", "allPantry", "destination$iv$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$6", "L$7", "I$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlannerRepository.this.analyzeWeek(null, this);
        }
    }

    /* JADX INFO: renamed from: com.easycompra.app.data.planner.PlannerRepository$moveEntry$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PlannerRepository.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.data.planner.PlannerRepository", f = "PlannerRepository.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {36, MotionEventCompat.AXIS_GENERIC_6, MotionEventCompat.AXIS_GENERIC_7}, m = "moveEntry", n = {"this", "entry", "newDate", "newSlot", "this", "entry", "newDate", "newSlot"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
    static final class C07101 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C07101(Continuation<? super C07101> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlannerRepository.this.moveEntry(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.easycompra.app.data.planner.PlannerRepository$setSlot$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: PlannerRepository.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.easycompra.app.data.planner.PlannerRepository", f = "PlannerRepository.kt", i = {0, 0}, l = {27, MotionEventCompat.AXIS_RELATIVE_Y}, m = "setSlot", n = {"this", "entry"}, s = {"L$0", "L$1"})
    static final class C07111 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C07111(Continuation<? super C07111> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PlannerRepository.this.setSlot(null, this);
        }
    }

    public PlannerRepository(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.dao = PlannerDatabase.INSTANCE.get(this.context).plannerDao();
        this.pantryDao = PantryDatabase.INSTANCE.get(this.context).pantryDao();
        this.recipeDao = RecipeDatabase.INSTANCE.get(this.context).recipeDao();
        this.recipeRepo = new RecipeRepository(this.context);
        this.fmt = DateTimeFormatter.ISO_LOCAL_DATE;
    }

    public final Flow<List<PlannerEntry>> observeWeek(LocalDate weekStart) {
        Intrinsics.checkNotNullParameter(weekStart, "weekStart");
        PlannerDao plannerDao = this.dao;
        String str = weekStart.format(this.fmt);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        String str2 = weekStart.plusDays(6L).format(this.fmt);
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return plannerDao.observeRange(str, str2);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0068 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object setSlot(PlannerEntry entry, Continuation<? super Unit> continuation) {
        C07111 c07111;
        PlannerRepository plannerRepository;
        PlannerDao plannerDao;
        if (continuation instanceof C07111) {
            c07111 = (C07111) continuation;
            if ((c07111.label & Integer.MIN_VALUE) != 0) {
                c07111.label -= Integer.MIN_VALUE;
            } else {
                c07111 = new C07111(continuation);
            }
        } else {
            c07111 = new C07111(continuation);
        }
        Object $result = c07111.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c07111.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                plannerRepository = this;
                PlannerDao plannerDao2 = plannerRepository.dao;
                String date = entry.getDate();
                String mealSlot = entry.getMealSlot();
                c07111.L$0 = plannerRepository;
                c07111.L$1 = entry;
                c07111.label = 1;
                if (plannerDao2.deleteSlot(date, mealSlot, c07111) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                plannerDao = plannerRepository.dao;
                c07111.L$0 = null;
                c07111.L$1 = null;
                c07111.label = 2;
                if (plannerDao.insert(entry, c07111) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                entry = (PlannerEntry) c07111.L$1;
                plannerRepository = (PlannerRepository) c07111.L$0;
                ResultKt.throwOnFailure($result);
                plannerDao = plannerRepository.dao;
                c07111.L$0 = null;
                c07111.L$1 = null;
                c07111.label = 2;
                if (plannerDao.insert(entry, c07111) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final Object clearSlot(String date, String slot, Continuation<? super Unit> continuation) {
        Object objDeleteSlot = this.dao.deleteSlot(date, slot, continuation);
        return objDeleteSlot == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteSlot : Unit.INSTANCE;
    }

    public final Object deleteEntry(String id, Continuation<? super Unit> continuation) {
        Object objDeleteById = this.dao.deleteById(id, continuation);
        return objDeleteById == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDeleteById : Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x009a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x00c2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object moveEntry(PlannerEntry plannerEntry, String str, String newSlot, Continuation<? super Unit> continuation) {
        C07101 c07101;
        String newDate;
        PlannerEntry entry;
        PlannerRepository plannerRepository;
        String newSlot2;
        PlannerDao plannerDao;
        PlannerDao plannerDao2;
        PlannerEntry plannerEntryCopy;
        if (continuation instanceof C07101) {
            c07101 = (C07101) continuation;
            if ((c07101.label & Integer.MIN_VALUE) != 0) {
                c07101.label -= Integer.MIN_VALUE;
            } else {
                c07101 = new C07101(continuation);
            }
        } else {
            c07101 = new C07101(continuation);
        }
        Object $result = c07101.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (c07101.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                newDate = str;
                entry = plannerEntry;
                PlannerDao plannerDao3 = this.dao;
                String id = entry.getId();
                c07101.L$0 = this;
                c07101.L$1 = entry;
                c07101.L$2 = newDate;
                c07101.L$3 = newSlot;
                c07101.label = 1;
                if (plannerDao3.deleteById(id, c07101) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                plannerRepository = this;
                newSlot2 = newSlot;
                plannerDao = plannerRepository.dao;
                c07101.L$0 = plannerRepository;
                c07101.L$1 = entry;
                c07101.L$2 = newDate;
                c07101.L$3 = newSlot2;
                c07101.label = 2;
                if (plannerDao.deleteSlot(newDate, newSlot2, c07101) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                plannerDao2 = plannerRepository.dao;
                PlannerEntry plannerEntry2 = entry;
                plannerEntryCopy = plannerEntry2.copy((249 & 1) != 0 ? plannerEntry2.id : null, (249 & 2) != 0 ? plannerEntry2.date : newDate, (249 & 4) != 0 ? plannerEntry2.mealSlot : newSlot2, (249 & 8) != 0 ? plannerEntry2.recipeId : null, (249 & 16) != 0 ? plannerEntry2.displayName : null, (249 & 32) != 0 ? plannerEntry2.servings : 0.0f, (249 & 64) != 0 ? plannerEntry2.notes : null, (249 & 128) != 0 ? plannerEntry2.createdAt : 0L);
                c07101.L$0 = null;
                c07101.L$1 = null;
                c07101.L$2 = null;
                c07101.L$3 = null;
                c07101.label = 3;
                if (plannerDao2.insert(plannerEntryCopy, c07101) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                newSlot2 = (String) c07101.L$3;
                newDate = (String) c07101.L$2;
                entry = (PlannerEntry) c07101.L$1;
                plannerRepository = (PlannerRepository) c07101.L$0;
                ResultKt.throwOnFailure($result);
                plannerDao = plannerRepository.dao;
                c07101.L$0 = plannerRepository;
                c07101.L$1 = entry;
                c07101.L$2 = newDate;
                c07101.L$3 = newSlot2;
                c07101.label = 2;
                if (plannerDao.deleteSlot(newDate, newSlot2, c07101) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                plannerDao2 = plannerRepository.dao;
                PlannerEntry plannerEntry3 = entry;
                plannerEntryCopy = plannerEntry3.copy((249 & 1) != 0 ? plannerEntry3.id : null, (249 & 2) != 0 ? plannerEntry3.date : newDate, (249 & 4) != 0 ? plannerEntry3.mealSlot : newSlot2, (249 & 8) != 0 ? plannerEntry3.recipeId : null, (249 & 16) != 0 ? plannerEntry3.displayName : null, (249 & 32) != 0 ? plannerEntry3.servings : 0.0f, (249 & 64) != 0 ? plannerEntry3.notes : null, (249 & 128) != 0 ? plannerEntry3.createdAt : 0L);
                c07101.L$0 = null;
                c07101.L$1 = null;
                c07101.L$2 = null;
                c07101.L$3 = null;
                c07101.label = 3;
                if (plannerDao2.insert(plannerEntryCopy, c07101) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 2:
                newSlot2 = (String) c07101.L$3;
                newDate = (String) c07101.L$2;
                entry = (PlannerEntry) c07101.L$1;
                plannerRepository = (PlannerRepository) c07101.L$0;
                ResultKt.throwOnFailure($result);
                plannerDao2 = plannerRepository.dao;
                PlannerEntry plannerEntry4 = entry;
                plannerEntryCopy = plannerEntry4.copy((249 & 1) != 0 ? plannerEntry4.id : null, (249 & 2) != 0 ? plannerEntry4.date : newDate, (249 & 4) != 0 ? plannerEntry4.mealSlot : newSlot2, (249 & 8) != 0 ? plannerEntry4.recipeId : null, (249 & 16) != 0 ? plannerEntry4.displayName : null, (249 & 32) != 0 ? plannerEntry4.servings : 0.0f, (249 & 64) != 0 ? plannerEntry4.notes : null, (249 & 128) != 0 ? plannerEntry4.createdAt : 0L);
                c07101.L$0 = null;
                c07101.L$1 = null;
                c07101.L$2 = null;
                c07101.L$3 = null;
                c07101.label = 3;
                if (plannerDao2.insert(plannerEntryCopy, c07101) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 3:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x018f  */
    /* JADX WARN: Code duplicated, block: B:35:0x01ba A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:39:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:126:0x049f -> B:127:0x04ab). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x01c8 -> B:31:0x0189). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x030b -> B:77:0x030f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object analyzeWeek(java.time.LocalDate r35, kotlin.coroutines.Continuation<? super com.easycompra.app.data.planner.WeekAnalysis> r36) {
        /*
            Method dump skipped, instruction units count: 1682
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easycompra.app.data.planner.PlannerRepository.analyzeWeek(java.time.LocalDate, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
