package com.scappworks.whereshouldieat.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.google.android.material.button.MaterialButton
import com.scappworks.whereshouldieat.viewmodel.LocationViewModel
import com.scappworks.whereshouldieat.R
import com.scappworks.whereshouldieat.room.Location
import com.scappworks.whereshouldieat.viewmodel.AddLocationViewModel
import java.util.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AddLocationFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private val locationViewModel: LocationViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_location, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val hours = resources.getStringArray(R.array.all_hours)
        val categories = resources.getStringArray(R.array.categories)
        val hoursAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item,
                R.id.dropdown_item_inside, hours)
        val categoriesAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item,
                R.id.dropdown_item_inside, categories)
        val hoursView = view.findViewById<AutoCompleteTextView>(R.id.all_hours_inside)
        hoursView.setAdapter(hoursAdapter)
        val categoriesView = view.findViewById<AutoCompleteTextView>(R.id.category_dropdown_inside)
        categoriesView.setAdapter(categoriesAdapter)
        val locationView = view.findViewById<TextView>(R.id.fragment_location_textview)
        val finishButton = view.findViewById<MaterialButton>(R.id.fragment_submit_button)

        finishButton.setOnClickListener {
            val chosenCategories = categoriesView.text.toString()
            val chosenHours = hoursView.text.toString()

            if (chosenCategories.isNotEmpty() && chosenHours.isNotEmpty()) {
                // INSERT NEW LOCATION INTO DATABASE
                locationViewModel.insert(Location(locationView.text.toString()
                        .toLowerCase(Locale.ROOT).trim(), chosenCategories, chosenHours))
                Toast.makeText(view.context, R.string.location_saved, Toast.LENGTH_SHORT).show()
                // DESTROY FRAGMENT AFTER INSERTING NEW WORD
                activity?.supportFragmentManager?.popBackStack()
            } else {
                val failedToast = when {
                    chosenCategories.isEmpty() && chosenHours.isNotEmpty() ->
                        Toast.makeText(context, R.string.choose_category, Toast.LENGTH_SHORT)
                    chosenHours.isEmpty() && chosenCategories.isNotEmpty() ->
                        Toast.makeText(context, R.string.choose_hours, Toast.LENGTH_SHORT)
                    else -> Toast.makeText(context, R.string.choose_hours_and_category, Toast.LENGTH_SHORT)
                }

                failedToast.show()
            }
        }

        // VIEWMODEL FOR GETTING DATA FROM THE PARENT ACTIVITY
        val addLocationViewModel: AddLocationViewModel by activityViewModels()

        addLocationViewModel.location.observe(viewLifecycleOwner,
                Observer { it -> locationView.text = it })
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddLocationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}