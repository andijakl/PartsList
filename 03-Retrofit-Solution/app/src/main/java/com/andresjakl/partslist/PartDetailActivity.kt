package com.andresjakl.partslist

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_part_detail.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException

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
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val webResponse = WebAccess.partsApi.deletePartAsync(itemId).await()
                Log.e(tag, "Delete success: ${webResponse.isSuccessful}")
                Toast.makeText(applicationContext, "Deleted: $itemId: ${webResponse.isSuccessful}", Toast.LENGTH_LONG).show()
            } catch (e: IOException) {
                // Error with network request
                Log.e(tag, "Exception " + e.printStackTrace())
                Toast.makeText(this@PartDetailActivity, "Exception ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun updatePart(originalItemId: Long, newItem: PartData) {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val webResponse = WebAccess.partsApi.updatePartAsync(originalItemId, newItem).await()
                Log.e(tag, "Update success: ${webResponse.isSuccessful}")
                Toast.makeText(applicationContext, "Updated: $originalItemId: ${webResponse.isSuccessful}", Toast.LENGTH_LONG).show()
            } catch (e: IOException) {
                // Error with network request
                Log.e(tag, "Exception " + e.printStackTrace())
                Toast.makeText(this@PartDetailActivity, "Exception ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
}
