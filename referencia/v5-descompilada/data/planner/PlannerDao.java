package com.easycompra.app.data.planner;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: PlannerDao.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H'J$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/easycompra/app/data/planner/PlannerDao;", "", "observeRange", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/easycompra/app/data/planner/PlannerEntry;", "from", "", "to", "getRange", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "", "entry", "(Lcom/easycompra/app/data/planner/PlannerEntry;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "deleteById", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSlot", "date", "slot", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface PlannerDao {
    Object deleteById(String str, Continuation<? super Unit> continuation);

    Object deleteSlot(String str, String str2, Continuation<? super Unit> continuation);

    Object getRange(String str, String str2, Continuation<? super List<PlannerEntry>> continuation);

    Object insert(PlannerEntry plannerEntry, Continuation<? super Unit> continuation);

    Flow<List<PlannerEntry>> observeRange(String from, String to);

    Object update(PlannerEntry plannerEntry, Continuation<? super Unit> continuation);
}
