package com.andreasjakl.partslist

import android.os.Bundle
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
