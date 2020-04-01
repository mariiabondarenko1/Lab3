package com.example.lab3.RecyclerView

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3.Film
import com.example.lab3.OneFilmView
import com.example.lab3.R
import kotlinx.android.synthetic.main.row_card_view.view.*

class RecyclerAdapter(private var list: MutableList<Film>) : RecyclerView.Adapter<RecyclerAdapter.FilmViewHolder>() {

    //Створення ViewHolder
    override fun onCreateViewHolder(vG: ViewGroup, i: Int): FilmViewHolder {
        val v: View = LayoutInflater.from(vG.context) // Вказуємо і заповнюємо макет для кожного елемента RecycleView
            .inflate(R.layout.row_card_view, vG, false)
        return FilmViewHolder(v) //Передаємо макет в конструктор ViewHolder
    }

    //Отримання кількості записів
    override fun getItemCount() = list.size

    // Встановлюємо значення текстових полів та ресурс зображенн
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.title.text = list[position].title
        holder.genre.text = list[position].genre
        holder.year.text = list[position].year.toString()
        holder.image.setImageResource(list[position].photo)

        //Обробник для натискання на будь-який пункт в RecyclerView
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.constrain.context, OneFilmView::class.java) //Створюємо намір
            intent.putExtra("position", position)//Передаємо у намір позицію натиснутого пункта списку
            intent.putParcelableArrayListExtra("list", ArrayList(list))//Передаємо у намір всі дані
            holder.constrain.context.startActivity(intent)//Відкриваємо нову активність
        }
    }

    //Клас ViewHolder для даних Film
    class FilmViewHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.imageView
        var title: TextView = itemView.title
        var year: TextView = itemView.year
        var genre: TextView = itemView.genre
        var constrain: ConstraintLayout = itemView.constrain
    }

}