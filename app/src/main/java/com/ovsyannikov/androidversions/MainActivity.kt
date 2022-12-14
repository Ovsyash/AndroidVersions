package com.ovsyannikov.androidversions

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val android = DataStorage.getVersionsList()
        val versions = DataStorage.getVersionsList()
        val adapter = AndroidAdapter(this, versions) {position ->
            val androids = android[position]
            val intent = DetailsActivity.createIntent(this, androids)
            startActivity(intent)
        }
        val list = findViewById<RecyclerView>(R.id.android_recyclerView)
        list.adapter = adapter

        val decoration = DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL)
        decoration.setDrawable(ContextCompat.getDrawable(this, R.color.grey)!!)
        list.addItemDecoration(decoration)
    }
}