package com.xxpffxx.lab5

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.xxpffxx.lab5.data.Android
import com.xxpffxx.lab5.data.DataStorage


class MainActivity : AppCompatActivity(), OnItemClickListener {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val android = DataStorage.getVersionsList()
        val adapter = AndroidAdapter(this, android, this)

        val list = findViewById<RecyclerView>(R.id.androidList)
        list.adapter = adapter

        val decoration = DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL)
        decoration.setDrawable(ContextCompat.getDrawable(this, R.color.grey)!!)
        list.addItemDecoration(decoration)
    }

    override fun onItemClicked(android: Android) {
        val intent = Intent(this, DetailsActivity::class.java).apply { putExtra(android::class.java.canonicalName, android) }
        startActivity(intent);
    }

}