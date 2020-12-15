package com.andreasjakl.partslist

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.IOException
import androidx.appcompat.app.AppCompatActivity
import com.andreasjakl.partslist.databinding.ActivityPartDetailBinding

class PartDetailActivity : AppCompatActivity() {
    private val tag : String = PartDetailActivity::class.java.simpleName
    private lateinit var binding: ActivityPartDetailBinding

    /**
     * Item ID that was supplied to this activity when it was created.
     * Saved as extra instance variable to make sure we keep it, even
     * if it'd be for example changed by the user.
     */
    private var originalItemId : Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPartDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Save the original item ID
        originalItemId = intent.getLongExtra("ItemId", 0)
        // Parse the parameters out of the intent and assign the values
        // to the UI elements.
        binding.tvItemId.text = originalItemId.toString()
        binding.etItemName.setText(intent.getStringExtra("ItemName"))

        // Set click listeners for the button to delete this element
        binding.btDelete.setOnClickListener {
            deletePart(originalItemId)
        }

        // Set click listeners for the button to update this element
        binding.btUpdate.setOnClickListener {
            updatePart(originalItemId,
                    PartData(originalItemId, binding.etItemName.text.toString()))
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
