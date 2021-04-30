package com.scappworks.whereshouldieat.room;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ$\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\'J$\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\'J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\nH\'J\u0019\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/scappworks/whereshouldieat/room/LocationDAO;", "", "delete", "", "model", "Lcom/scappworks/whereshouldieat/room/Location;", "(Lcom/scappworks/whereshouldieat/room/Location;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFilteredLocationsSpecific", "Lkotlinx/coroutines/flow/Flow;", "", "category", "", "hours", "getFilteredLocationsUnspecific", "getOrderedLocations", "insertLocation", "location", "app_debug"})
public abstract interface LocationDAO {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM location_table ORDER BY location_name ASC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.scappworks.whereshouldieat.room.Location>> getOrderedLocations();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM location_table WHERE category LIKE :category AND always_open LIKE :hours ORDER BY location_name ASC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.scappworks.whereshouldieat.room.Location>> getFilteredLocationsSpecific(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    java.lang.String hours);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM location_table WHERE category LIKE :category OR always_open LIKE :hours ORDER BY location_name ASC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.scappworks.whereshouldieat.room.Location>> getFilteredLocationsUnspecific(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    java.lang.String hours);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object insertLocation(@org.jetbrains.annotations.NotNull()
    com.scappworks.whereshouldieat.room.Location location, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM location_table")
    public abstract java.lang.Object deleteAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p0);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Delete()
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.scappworks.whereshouldieat.room.Location model, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
}