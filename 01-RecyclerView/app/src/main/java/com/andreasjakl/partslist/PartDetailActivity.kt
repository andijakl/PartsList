package com.andreasjakl.partslist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andreasjakl.partslist.databinding.ActivityPartDetailBinding

class PartDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPartDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPartDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intentThatStartedThisActivity = intent

        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
            val partId = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEXT)
            binding.tvItemId.text = partId
        }
    }
}
