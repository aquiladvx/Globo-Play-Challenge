package com.debcomp.aql.globoplaychallenge.features.details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.debcomp.aql.globoplaychallenge.R

class DetailsAcivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_show)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val id = intent.getIntExtra(EXTRA_SHOW_ID, 0)
        Toast.makeText(this, id.toString(), Toast.LENGTH_SHORT).show()
    }


    companion object {

        private const val EXTRA_SHOW_ID = "EXTRA_SHOW_ID_DETAIL"

        fun start(context: Context, showId: Int): Intent {
            return Intent(context, DetailsAcivity::class.java)
                .apply { putExtra(EXTRA_SHOW_ID, showId) }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
            else -> return super.onOptionsItemSelected(item)
        }
        return false
    }
}