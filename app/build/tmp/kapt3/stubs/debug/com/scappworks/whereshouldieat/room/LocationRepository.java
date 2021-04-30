package com.scappworks.whereshouldieat.room;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\"\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R&\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/scappworks/whereshouldieat/room/LocationRepository;", "", "locationDAO", "Lcom/scappworks/whereshouldieat/room/LocationDAO;", "(Lcom/scappworks/whereshouldieat/room/LocationDAO;)V", "allHours", "", "allLocations", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/scappworks/whereshouldieat/room/Location;", "getAllLocations", "()Lkotlinx/coroutines/flow/Flow;", "category", "filteredLocations", "getFilteredLocations", "setFilteredLocations", "(Lkotlinx/coroutines/flow/Flow;)V", "delete", "", "location", "(Lcom/scappworks/whereshouldieat/room/Location;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "c", "ah", "app_debug"})
public final class LocationRepository {
    private java.lang.String category = "";
    private java.lang.String allHours = "";
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.scappworks.whereshouldieat.room.Location>> allLocations = null;
    @org.jetbrains.annotations.NotNull()
    private kotlinx.coroutines.flow.Flow<? extends java.util.List<com.scappworks.whereshouldieat.room.Location>> filteredLocations;
    private final com.scappworks.whereshouldieat.room.LocationDAO locationDAO = null;
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.scappworks.whereshouldieat.room.Location>> getAllLocations() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.scappworks.whereshouldieat.room.Location>> getFilteredLocations() {
        return null;
    }
    
    public final void setFilteredLocations(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.flow.Flow<? extends java.util.List<com.scappworks.whereshouldieat.room.Location>> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    @kotlin.Suppress(names = {"RedundantSuspendModifier"})
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.scappworks.whereshouldieat.room.Location location, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.scappworks.whereshouldieat.room.Location>> setFilteredLocations(@org.jetbrains.annotations.NotNull()
    java.lang.String c, @org.jetbrains.annotations.NotNull()
    java.lang.String ah) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    public final java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.scappworks.whereshouldieat.room.Location location, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    public LocationRepository(@org.jetbrains.annotations.NotNull()
    com.scappworks.whereshouldieat.room.LocationDAO locationDAO) {
        super();
    }
}