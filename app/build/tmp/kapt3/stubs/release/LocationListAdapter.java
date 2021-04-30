
import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0012\u0013B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"LLocationListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/scappworks/whereshouldieat/room/Location;", "LLocationListAdapter$LocationViewHolder;", "()V", "selectedLocationNumber", "", "getSelectedLocation", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelectedLocation", "i", "LocationViewHolder", "LocationsComparator", "app_release"})
public final class LocationListAdapter extends androidx.recyclerview.widget.ListAdapter<com.scappworks.whereshouldieat.room.Location, LocationListAdapter.LocationViewHolder> {
    private int selectedLocationNumber = -1;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public LocationListAdapter.LocationViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    LocationListAdapter.LocationViewHolder holder, int position) {
    }
    
    public final void setSelectedLocation(int i) {
    }
    
    public final int getSelectedLocation() {
        return 0;
    }
    
    public LocationListAdapter() {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"LLocationListAdapter$LocationViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "card", "Landroidx/cardview/widget/CardView;", "getCard", "()Landroidx/cardview/widget/CardView;", "locationItemView", "Landroid/widget/TextView;", "getLocationItemView", "()Landroid/widget/TextView;", "bind", "", "text", "", "Companion", "app_release"})
    public static final class LocationViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView locationItemView = null;
        @org.jetbrains.annotations.NotNull()
        private final androidx.cardview.widget.CardView card = null;
        @org.jetbrains.annotations.NotNull()
        public static final LocationListAdapter.LocationViewHolder.Companion Companion = null;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getLocationItemView() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.cardview.widget.CardView getCard() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.Nullable()
        java.lang.String text) {
        }
        
        public LocationViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"LLocationListAdapter$LocationViewHolder$Companion;", "", "()V", "create", "LLocationListAdapter$LocationViewHolder;", "parent", "Landroid/view/ViewGroup;", "app_release"})
        public static final class Companion {
            
            @org.jetbrains.annotations.NotNull()
            public final LocationListAdapter.LocationViewHolder create(@org.jetbrains.annotations.NotNull()
            android.view.ViewGroup parent) {
                return null;
            }
            
            private Companion() {
                super();
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"LLocationListAdapter$LocationsComparator;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/scappworks/whereshouldieat/room/Location;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_release"})
    public static final class LocationsComparator extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.scappworks.whereshouldieat.room.Location> {
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.scappworks.whereshouldieat.room.Location oldItem, @org.jetbrains.annotations.NotNull()
        com.scappworks.whereshouldieat.room.Location newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.scappworks.whereshouldieat.room.Location oldItem, @org.jetbrains.annotations.NotNull()
        com.scappworks.whereshouldieat.room.Location newItem) {
            return false;
        }
        
        public LocationsComparator() {
            super();
        }
    }
}