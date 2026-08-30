package com.easycompra.app.data.planner;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlannerDatabase.kt */
/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/easycompra/app/data/planner/PlannerDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "plannerDao", "Lcom/easycompra/app/data/planner/PlannerDao;", "Companion", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class PlannerDatabase extends RoomDatabase {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile PlannerDatabase instance;

    public abstract PlannerDao plannerDao();

    /* JADX INFO: compiled from: PlannerDatabase.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/easycompra/app/data/planner/PlannerDatabase$Companion;", "", "<init>", "()V", "instance", "Lcom/easycompra/app/data/planner/PlannerDatabase;", "get", "context", "Landroid/content/Context;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PlannerDatabase get(Context context) {
            PlannerDatabase plannerDatabase;
            Intrinsics.checkNotNullParameter(context, "context");
            PlannerDatabase plannerDatabase2 = PlannerDatabase.instance;
            if (plannerDatabase2 == null) {
                synchronized (this) {
                    plannerDatabase = PlannerDatabase.instance;
                    if (plannerDatabase == null) {
                        Context applicationContext = context.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                        RoomDatabase roomDatabaseBuild = Room.databaseBuilder(applicationContext, PlannerDatabase.class, "planner.db").build();
                        PlannerDatabase it = (PlannerDatabase) roomDatabaseBuild;
                        Companion companion = PlannerDatabase.INSTANCE;
                        PlannerDatabase.instance = it;
                        plannerDatabase = (PlannerDatabase) roomDatabaseBuild;
                    }
                }
                return plannerDatabase;
            }
            return plannerDatabase2;
        }
    }
}
