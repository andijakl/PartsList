package com.andresjakl.partslist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
         * A LinearLayoutManager is responsible for measuring and positioning item views within a
         * RecyclerView into a linear list. This means that it can produce either a horizontal or
         * vertical list depending on which parameter you pass in to the LinearLayoutManager
         * constructor. By default, if you don't specify an orientation, you get a vertical list.
         * In our case, we want a vertical list, so we don't need to pass in an orientation flag to
         * the LinearLayoutManager constructor.
         *
         * There are other LayoutManagers available to display your data in uniform grids,
         * staggered grids, and more! See the developer documentation for more details.
         */
        rv_parts.layoutManager = LinearLayoutManager(this)
        /*
         * Use this setting to improve performance if you know that changes in content do not
         * change the child layout size in the RecyclerView
         */
        rv_parts.hasFixedSize()
        var testData = createTestData()
        //rv_parts.adapter = PartAdapter(testData)

        // Create the PartAdapter
        // 1st parameter: our generated testData
        // 2nd parameter: item click handler function (implemented below) as function parameter
        rv_parts.adapter = PartAdapter(testData, { partItem : PartData -> partItemClicked(partItem) })


        // ---------------------------------------------------------
        // Kotlin Language Features

        // Create new class instance
        var calcTest = ClassWithConstructorProperties(10, 20)
        // Print calculation results
        Log.d("Tests", "Calculation result: " + calcTest.calculate())

        // Call a function, supplying a lambda to the function parameter
        testFunctionParameters( {a : Int, b : Int -> a + b } )
    }

    private fun partItemClicked(partItem : PartData) {
        Toast.makeText(this, "Clicked: ${partItem.itemName}", Toast.LENGTH_LONG).show()

        // Launch second activity, pass part ID as string parameter
        val showDetailActivityIntent = Intent(this, PartDetailActivity::class.java)
        showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, partItem.id.toString())
        startActivity(showDetailActivityIntent)
    }


    private fun createTestData() : List<PartData> {
        var partList = ArrayList<PartData>()
        partList.add(PartData(100411, "LED Green 568 nm, 5mm"))
        partList.add(PartData(101119, "Aluminium Capacitor 4.7μF"))
        partList.add(PartData(101624, "Potentiometer 500kΩ"))
        return partList
    }

    /**
     * Defines a class with a constructor. Its parameters are automatically available
     * as properties in the class. Note that the keyword "constructor" is optional
     * and could be stripped.
     */
    class ClassWithConstructorProperties constructor (var a: Int, var b: Int) {
        fun calculate() : Int {
            return a + b;
        }
    }

    private fun testFunctionParameters(performCalculation: (Int, Int) -> Int) {
        Log.d("Tests", "Calculation result: " + performCalculation(1, 2))
    }

}
