package com.scappworks.whereshouldieat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.google.android.material.button.MaterialButton
import com.scappworks.whereshouldieat.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FilterFragment : DialogFragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val filterSubmitButton = view.findViewById<MaterialButton>(R.id.filter_submit_button)
        val hours = resources.getStringArray(R.array.all_hours) + "Any"
        val categories = resources.getStringArray(R.array.categories) + "Any"
        val hoursAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item,
                R.id.dropdown_item_inside, hours)
        val categoriesAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item,
                R.id.dropdown_item_inside, categories)
        val hoursView = view.findViewById<AutoCompleteTextView>(R.id.all_hours_inside)
        hoursView?.setAdapter(hoursAdapter)
        val categoriesView = view.findViewById<AutoCompleteTextView>(R.id.category_dropdown_inside)
        categoriesView?.setAdapter(categoriesAdapter)

        filterSubmitButton.setOnClickListener {
            // FRAGMENT BUNDLE DATA FOR MAIN ACTIVITY UPON COMPLETION OF FRAGMENT
            val hoursSelection = hoursView.text.toString()
            val categorySelection = categoriesView.text.toString()
            var filtered = false

            if (hoursSelection.isNotEmpty() && categorySelection.isNotEmpty()) {
                if (hoursSelection == "Any" && categorySelection == "Any") {
                    setFragmentResult("filters", bundleOf("filtered?" to filtered))
                } else {
                    filtered = true

                    setFragmentResult("filters", bundleOf(
                            "filterHoursBundleKey" to hoursSelection,
                            "filterCategoryBundleKey" to categorySelection,
                            "filtered" to filtered))
                }
                
                activity?.supportFragmentManager?.popBackStack()
            } else {
                val failedToast = when {
                    categorySelection.isEmpty() && hoursSelection.isNotEmpty() ->
                        Toast.makeText(context, getString(R.string.choose_category), Toast.LENGTH_SHORT)
                    hoursSelection.isEmpty() && categorySelection.isNotEmpty() ->
                        Toast.makeText(context, getString(R.string.choose_hours), Toast.LENGTH_SHORT)
                    else -> Toast.makeText(context, getString(R.string.choose_hours_and_category), Toast.LENGTH_SHORT)
                }

                failedToast.show()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                FilterFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}