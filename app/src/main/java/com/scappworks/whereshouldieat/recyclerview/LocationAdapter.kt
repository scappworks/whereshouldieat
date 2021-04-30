import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.scappworks.whereshouldieat.room.Location
import com.scappworks.whereshouldieat.R

class LocationListAdapter : ListAdapter<Location, LocationListAdapter.LocationViewHolder>(LocationsComparator()) {

    private var selectedLocationNumber = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val current = getItem(position)

        if (selectedLocationNumber == position) {
            holder.card.setCardBackgroundColor(Color.parseColor("#ffd000"))
            holder.locationItemView.setTextColor(Color.parseColor("#0095cc"))
            holder.itemView.setPadding(20,15,20,15)
        } else {
            holder.card.setCardBackgroundColor(Color.parseColor("#a200ff"))
            holder.locationItemView.setTextColor(Color.parseColor("#610099"))
            holder.itemView.setPadding(5,5,5,5)
        }

        holder.bind(current.location_name)
    }

    class LocationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val locationItemView: TextView = itemView.findViewById(R.id.textView_inside)
        val card: CardView = itemView.findViewById(R.id.textView_outside)

        fun bind(text: String?) {
            locationItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): LocationViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return LocationViewHolder(view)
            }
        }
    }

    class LocationsComparator : DiffUtil.ItemCallback<Location>() {
        override fun areItemsTheSame(oldItem: Location, newItem: Location): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Location, newItem: Location): Boolean {
            return oldItem.location_name == newItem.location_name
        }
    }

    fun setSelectedLocation(i: Int) {
        selectedLocationNumber = i
    }

    fun getSelectedLocation(): Int {
        return selectedLocationNumber
    }
}