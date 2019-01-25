package com.andresjakl.partslist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_part_detail.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PartDetailActivity : AppCompatActivity() {
    private val tag : String = PartDetailActivity::class.java.simpleName
    /**
     * Item ID that was supplied to this activity when it was created.
     * Saved as extra instance variable to make sure we keep it, even
     * if it'd be for example changed by the user.
     */
    private var originalItemId : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_part_detail)

        // Save the original item ID
        originalItemId = intent.getLongExtra("ItemId", 0)
        // Parse the parameters out of the intent and assign the values
        // to the UI elements.
        tv_item_id.text = originalItemId.toString()
        et_item_name.setText(intent.getStringExtra("ItemName"))

        // Set click listeners for the button to delete this element
        bt_delete.setOnClickListener {
            deletePart(originalItemId)
        }

        // Set click listeners for the button to update this element
        bt_update.setOnClickListener {
            updatePart(originalItemId,
                    PartData(originalItemId, et_item_name.text.toString()))
        }
    }


    private fun deletePart(itemId : Long) {
        // TODO Launch a coroutine

            // TODO Call the deletePartAsync function and await its execution.
            // It's located in the Singleton WebAccess.partsApi instance.

            // TODO Print the webResponse.isSuccessful to the log and/or as a toast



    }

    private fun updatePart(originalItemId: Long, newItem: PartData) {
        // TODO Launch a coroutine

            // TODO Call the updatePartAsync function and await its execution.
            // It's located in the Singleton WebAccess.partsApi instance.

            // TODO Print the webResponse.isSuccessful to the log and/or as a toast

    }
}
