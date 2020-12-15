package com.andreasjakl.partslist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.Toast
import com.andreasjakl.partslist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val tag : String = MainActivity::class.java.simpleName
    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: PartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /*
         * A LinearLayoutManager is responsible for measuring and positioning item views within a
         * RecyclerView into a linear list. This means that it can produce either a horizontal or
         * vertical list depending on which parameter you pass in to the LinearLayoutManager
         * constructor. By default, if you don'tag specify an orientation, you get a vertical list.
         * In our case, we want a vertical list, so we don'tag need to pass in an orientation flag to
         * the LinearLayoutManager constructor.
         *
         * There are other LayoutManagers available to display your data in uniform grids,
         * staggered grids, and more! See the developer documentation for more details.
         */
        binding.rvParts.layoutManager = LinearLayoutManager(this)
        /*
         * Use this setting to improve performance if you know that changes in content do not
         * change the child layout size in the RecyclerView
         */
        binding.rvParts.setHasFixedSize(true)

        // Create the PartAdapter
        // 1st parameter: our generated testData. listOf() generates empty list with correct type
        // 2nd parameter: item click handler function (implemented below) as function parameter
        adapter = PartAdapter(listOf(), { partItem : PartData -> partItemClicked(partItem) })
        binding.rvParts.adapter = adapter

        loadPartsAndUpdateList()

    }

    private fun loadPartsAndUpdateList() {
        // TODO Launch a coroutine

            // TODO Call the getPartsAsync function and await its execution.
            // It's located in the Singleton WebAccess.partsApi instance.

            // TODO check if the web response is successful

                // TODO Get the returned & parsed JSON from the web response body.

                // TODO Assign the list to the recycler view.
                // If partsList is null, assign an empty list to the adapter (use the ?: operator)

                // TODO Notify recycler view that data has changed.
                // Makes sure the view re-renders itself

            // TODO else - print error information (web response code) to log or as a toast


    }

    private fun addPart(partItem: PartData) {
        // TODO Launch a coroutine

            // TODO Call the addPartAsync function and await its execution.
            // It's located in the Singleton WebAccess.partsApi instance.

            // TODO Print the webResponse.isSuccessful to the log and/or as a toast

            // TODO Reload the data by calling loadPartsAndUpdateList()

    }


    private fun partItemClicked(partItem : PartData) {
        // Test code to add a new item to the list
        // Will be replaced with UI function soon
        //val newPart = PartData(Random.nextLong(0, 999999), "Infrared sensor")
        //addPart(newPart)
        //return

        Toast.makeText(this, "Clicked: ${partItem.itemName}", Toast.LENGTH_LONG).show()

        // Launch second activity, pass part ID as string parameter
        val showDetailActivityIntent = Intent(this, PartDetailActivity::class.java)
        //showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, partItem.id.toString())
        showDetailActivityIntent.putExtra("ItemId", partItem.id)
        showDetailActivityIntent.putExtra("ItemName", partItem.itemName)
        startActivity(showDetailActivityIntent)
    }


}
