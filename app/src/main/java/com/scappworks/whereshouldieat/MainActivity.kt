package com.scappworks.whereshouldieat

import LocationListAdapter
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.scappworks.whereshouldieat.fragments.AddLocationFragment
import com.scappworks.whereshouldieat.fragments.FilterFragment
import com.scappworks.whereshouldieat.room.Location
import com.scappworks.whereshouldieat.room.LocationApplication
import com.scappworks.whereshouldieat.viewmodel.AddLocationViewModel
import com.scappworks.whereshouldieat.viewmodel.LocationViewModel
import com.scappworks.whereshouldieat.viewmodel.LocationViewModelFactory
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val locationViewModel: LocationViewModel by viewModels {
        LocationViewModelFactory((application as LocationApplication).repository)
    }

    // STATIC OBJECT TO PERSIST VALUE ACROSS DESTROY/CREATE CALLS
    companion object {
        private var filter = false
        private var lastNumber = -1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addLocationEditText = findViewById<TextInputEditText>(R.id.add_location_edittext_inside)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = LocationListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // FRAGMENT BUNDLE DATA FOR MAIN ACTIVITY UPON COMPLETION OF FRAGMENT
        supportFragmentManager.setFragmentResultListener("filters", this) { key, bundle ->
            val filteredHours = bundle.getString("filterHoursBundleKey")
            val filteredCategories = bundle.getString("filterCategoryBundleKey")
            val isFiltered = bundle.getBoolean("filtered")

            if (isFiltered) {
                //  NULL CHECK ONLY BECAUSE BUNDLE CONTENTS ARE OF TYPE 'String?'
                if (filteredCategories != null && filteredHours != null) {
                    filter = isFiltered
                    locationViewModel.setFilter(filteredCategories, filteredHours)
                }
            } else {
                    filter = isFiltered
                }

                if (filter) {
                    locationViewModel.filteredLocations.observe(this, Observer { locations ->
                        locations?.let {adapter.submitList(it)}
                    })
                } else {
                    locationViewModel.allLocations.observe(this, Observer { locations ->
                        locations?.let { adapter.submitList(it) }
                    })
                }
        }

        if (filter) {
            locationViewModel.filteredLocations.observe(this, Observer { locations ->
                locations?.let {adapter.submitList(it)}
            })
        } else {
            locationViewModel.allLocations.observe(this, Observer { locations ->
                locations?.let { adapter.submitList(it) }
            })
        }

        adapter.setSelectedLocation(lastNumber)

        // ADD LOCATION BUTTON
        val addButton = findViewById<FloatingActionButton>(R.id.add_location_button)
        addButton.setOnClickListener {
            if (TextUtils.isEmpty(addLocationEditText.text)) {
                Toast.makeText(this, R.string.empty_not_saved, Toast.LENGTH_SHORT).show()
                closeKeyboard(addLocationEditText, it)
            } else {
                val addLocationViewModel: AddLocationViewModel by viewModels()
                addLocationViewModel.setLocation(addLocationEditText.text.toString())
                closeKeyboard(addLocationEditText, it)

                // ADD LOCATION FRAGMENT
                    // COMMIT RUNS THE BLOCK OF CODE AT THE END OF FRAGMENT CREATION
                    supportFragmentManager.commit {
                        AddLocationFragment.newInstance(addLocationEditText.text.toString(), "")
                        setReorderingAllowed(true).add<AddLocationFragment>(R.id.add_location_fragment)
                        addToBackStack(null)
                }
            }
        }

        // DELETE LOCATION BUTTON
        val deleteButton = findViewById<FloatingActionButton>(R.id.delete_location_button)
        deleteButton.setOnClickListener {
            if (TextUtils.isEmpty(addLocationEditText.text)) {
                Toast.makeText(this, R.string.empty_not_deleted, Toast.LENGTH_SHORT).show()
                closeKeyboard(addLocationEditText, it)
            } else {
                val hours = resources.getStringArray(R.array.all_hours)
                val categories = resources.getStringArray(R.array.categories)
                var exists = false
                var deleted = false

                for (i in hours.indices) {
                    for (j in categories.indices) {
                        locationViewModel.allLocations.observe(this, {
                            locations ->
                            exists = locations.contains(Location(addLocationEditText.text.toString()
                                    .toLowerCase(Locale.ROOT).trim(), categories[j], hours[i]))
                        })

                        if (exists) {
                            locationViewModel.delete(Location(addLocationEditText.text.toString()
                                    .toLowerCase(Locale.ROOT).trim(), categories[j], hours[i]))

                            deleted = true
                        }
                    }
                }

                if (deleted) {
                    Toast.makeText(this, R.string.location_deleted, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, R.string.missing_location, Toast.LENGTH_SHORT).show()
                }

                closeKeyboard(addLocationEditText, it)
            }
        }

        // CHOOSE LOCATION BUTTON
        val chooseButton = findViewById<FloatingActionButton>(R.id.choose_location_button)
        chooseButton.setOnClickListener {
            if (filter) {
                if (locationViewModel.filteredLocations.value!!.isNotEmpty()) {
                    var randomInt = locationViewModel.filteredLocations.value.let { v ->
                        Random.nextInt(
                            0,
                            v!!.size
                        )
                    }

                    // ENSURE THAT THE RANDOM NUMBER HASN'T ALREADY BEEN USED, AND THE REPOSITORY
                    // CONTAINS MORE THAN 1 LOCATION
                    while (randomInt == lastNumber && locationViewModel.filteredLocations.value!!.size > 1) {
                        randomInt = locationViewModel.filteredLocations.value.let { v ->
                            Random.nextInt(
                                0,
                                v!!.size
                            )
                        }
                    }

                    lastNumber = randomInt
                    adapter.setSelectedLocation(randomInt)
                    recyclerView.scrollToPosition(adapter.getSelectedLocation())
                    adapter.notifyDataSetChanged()
                    closeKeyboard(addLocationEditText, it)

                } else {
                    Toast.makeText(this, R.string.locations_empty, Toast.LENGTH_SHORT).show()
                    closeKeyboard(addLocationEditText, it)
                }
            }
            else {
                if (locationViewModel.allLocations.value!!.isNotEmpty()) {
                    var randomInt = locationViewModel.allLocations.value.let { v ->
                        Random.nextInt(
                            0,
                            v!!.size
                        )
                    }

                    // ENSURE THAT THE RANDOM NUMBER HASN'T ALREADY BEEN USED, AND THE REPOSITORY
                    // CONTAINS MORE THAN 1 LOCATION
                    while (randomInt == lastNumber && locationViewModel.allLocations.value!!.size > 1) {
                        randomInt = locationViewModel.allLocations.value.let { v ->
                            Random.nextInt(
                                0,
                                v!!.size
                            )
                        }
                    }

                    lastNumber = randomInt
                    adapter.setSelectedLocation(randomInt)
                    recyclerView.scrollToPosition(adapter.getSelectedLocation())
                    adapter.notifyDataSetChanged()
                    closeKeyboard(addLocationEditText, it)

                } else {
                    Toast.makeText(this, R.string.locations_empty, Toast.LENGTH_SHORT).show()
                    closeKeyboard(addLocationEditText, it)
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putBoolean("FILTERED", filter)
        outState.putInt("LAST_NUMBER", lastNumber)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        filter = savedInstanceState.getBoolean("FILTERED")
        lastNumber = savedInstanceState.getInt("LAST_NUMBER")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.view_filter, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.options_menu -> {
                //  FILTER FRAGMENT
                    // COMMIT RUNS THE BLOCK OF CODE AT THE END OF FRAGMENT CREATION
                    supportFragmentManager.commit {
                        setReorderingAllowed(true).add<FilterFragment>(R.id.filter_fragment)
                        addToBackStack(null)
                    }
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun closeKeyboard(edit: EditText, view: View) {
        // INPUTMETHODMANAGER USED TO HIDE KEYBOARD ON BUTTON PRESS
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(view.windowToken, 0)
        edit.text?.clear()
        edit.clearFocus()
    }
}