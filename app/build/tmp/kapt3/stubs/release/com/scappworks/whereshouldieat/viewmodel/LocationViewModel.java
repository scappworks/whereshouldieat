package com.scappworks.whereshouldieat.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bJ\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR&\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\n\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/scappworks/whereshouldieat/viewmodel/LocationViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/scappworks/whereshouldieat/room/LocationRepository;", "(Lcom/scappworks/whereshouldieat/room/LocationRepository;)V", "allLocations", "Landroidx/lifecycle/LiveData;", "", "Lcom/scappworks/whereshouldieat/room/Location;", "getAllLocations", "()Landroidx/lifecycle/LiveData;", "filteredLocations", "getFilteredLocations", "setFilteredLocations", "(Landroidx/lifecycle/LiveData;)V", "delete", "Lkotlinx/coroutines/Job;", "location", "insert", "setFilter", "category", "", "all_hours", "app_release"})
public final class LocationViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.scappworks.whereshouldieat.room.Location>> allLocations = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.LiveData<java.util.List<com.scappworks.whereshouldieat.room.Location>> filteredLocations;
    private final com.scappworks.whereshouldieat.room.LocationRepository repository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.scappworks.whereshouldieat.room.Location>> getAllLocations() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.scappworks.whereshouldieat.room.Location>> getFilteredLocations() {
        return null;
    }
    
    public final void setFilteredLocations(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LiveData<java.util.List<com.scappworks.whereshouldieat.room.Location>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job insert(@org.jetbrains.annotations.NotNull()
    com.scappworks.whereshouldieat.room.Location location) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job delete(@org.jetbrains.annotations.NotNull()
    com.scappworks.whereshouldieat.room.Location location) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job setFilter(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    java.lang.String all_hours) {
        return null;
    }
    
    public LocationViewModel(@org.jetbrains.annotations.NotNull()
    com.scappworks.whereshouldieat.room.LocationRepository repository) {
        super();
    }
}