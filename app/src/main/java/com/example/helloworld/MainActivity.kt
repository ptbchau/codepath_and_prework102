package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Make helloButton show a toast when being clicked
        val helloButton: Button = findViewById(R.id.helloButton)
        helloButton.setOnClickListener {
            Toast.makeText(
                this,
                R.string.res_hello,
                Toast.LENGTH_SHORT
            ).show()
        }

        // Create an ArrayAdapter using string array and default spinner layout
        val favSpinner: Spinner = findViewById(R.id.favSpinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.fav_options,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            favSpinner.adapter = adapter
        }
        favSpinner.onItemSelectedListener = this
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        // Do not make toast for initial option, which is "Select" instruction
        if (position != 0) {
            Toast.makeText(
                this,
                resources.getStringArray(R.array.fav_res)[position],
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }
}
