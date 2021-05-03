package com.xxpffxx.lab5

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.xxpffxx.lab5.data.Android
import java.util.*
import cz.quanti.quase.loremkotlinum.Lorem

class DetailsActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val avatar = findViewById<ImageView>(R.id.avatar)
        val title = findViewById<TextView>(R.id.Title)
        val date = findViewById<TextView>(R.id.date)
        val overview_text = findViewById<TextView>(R.id.overview_text)
        intent.getParcelableExtra<Android>(Android::class.java.canonicalName)?.let { a ->
            avatar.setImageResource(a.imageAndroid)
            title.text = a.title
            a.releaseDate.also { date.text = "${it[Calendar.DAY_OF_MONTH]}/${it[Calendar.MONTH]}/${it[Calendar.YEAR]}" }
            overview_text.text = Lorem.paragraphs()
        }
    }
}