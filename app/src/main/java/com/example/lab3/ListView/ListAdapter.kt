package com.example.lab3.ListView

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.lab3.Film
import com.example.lab3.R
import kotlinx.android.synthetic.main.row_list_view.view.*

class ListAdapter(context: Context, private var data: MutableList<Film>) : BaseAdapter(){

    //об'єкт LayoutInflater, який буде використовуватись для отримання дерева об'єктів UI з макета
    private var inflater: LayoutInflater = LayoutInflater.from(context)

    // Метод повертає корінь дерева об'єктів UI, які відображають пункт списку
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        // Перетворюємо макет в дерево об'єктів
        val view: View = inflater.inflate(R.layout.row_list_view, parent, false)
        //Отримуємо з активності віджети
        val title = view.titleFilm
        val image = view.iconlv
        val year = view.yearFilm
        val genre = view.genreFilm

        //Заповнюємо даними віджети
        title.text = data[position].title
        image.setImageResource(data[position].photo)
        genre.text = data[position].genre
        year.text = data[position].year.toString()

        return view
    }

    // Отримання елемента даних, пов’язаний із вказаною позицією в наборі даних
    override fun getItem(position: Int): Any? = data[position]
    // Отримання ідентифікатора рядка, пов’язаний із вказаною позицією у списку
    override fun getItemId(position: Int): Long = position.toLong()
    // Отримання кількості елементів у наборі даних
    override fun getCount(): Int = data.size
}
