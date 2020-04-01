package com.example.lab3

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.actvity_one_item.*


@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class OneFilmView: AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actvity_one_item)

        //Приймаємо дані, які були отправлені с іншої активності
        val position: Int = getIntent().getIntExtra("position", 0)
        val list = getIntent().getParcelableArrayListExtra<Film>("list")

        //Додаємо ці дані у нову активність actvity_one_item)
        titleTextView.text = list[position].title
        yearTextView.text = "Год выпуска: " + list[position].year
        genreTextView.text = "Жанр: "  + list[position].genre
        imageView.setImageResource(list[position].photo)
        descTextView.text = "Описание: "  + list[position].description
    }

}