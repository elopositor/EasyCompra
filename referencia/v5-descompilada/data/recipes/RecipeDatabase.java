package com.easycompra.app.data.recipes;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RecipeDatabase.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/easycompra/app/data/recipes/RecipeDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "recipeDao", "Lcom/easycompra/app/data/recipes/RecipeDao;", "Companion", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class RecipeDatabase extends RoomDatabase {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile RecipeDatabase instance;

    public abstract RecipeDao recipeDao();

    /* JADX INFO: compiled from: RecipeDatabase.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/easycompra/app/data/recipes/RecipeDatabase$Companion;", "", "<init>", "()V", "instance", "Lcom/easycompra/app/data/recipes/RecipeDatabase;", "get", "context", "Landroid/content/Context;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RecipeDatabase get(Context context) {
            RecipeDatabase recipeDatabase;
            Intrinsics.checkNotNullParameter(context, "context");
            RecipeDatabase recipeDatabase2 = RecipeDatabase.instance;
            if (recipeDatabase2 == null) {
                synchronized (this) {
                    recipeDatabase = RecipeDatabase.instance;
                    if (recipeDatabase == null) {
                        Context applicationContext = context.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                        RoomDatabase roomDatabaseBuild = Room.databaseBuilder(applicationContext, RecipeDatabase.class, "recipes.db").build();
                        RecipeDatabase it = (RecipeDatabase) roomDatabaseBuild;
                        Companion companion = RecipeDatabase.INSTANCE;
                        RecipeDatabase.instance = it;
                        recipeDatabase = (RecipeDatabase) roomDatabaseBuild;
                    }
                }
                return recipeDatabase;
            }
            return recipeDatabase2;
        }
    }
}
