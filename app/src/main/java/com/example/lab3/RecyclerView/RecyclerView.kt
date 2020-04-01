package com.example.lab3.RecyclerView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab3.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3.Film


class RecyclerView : AppCompatActivity() {

    private var films: MutableList<Film> = ArrayList()//Створення масиву для збереженя даних


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        //Заповнюємо масив даними
        films.add(Film("Бойцевский клуб", 1999, "Драмма, Триллер", R.drawable.first_film, "Терзаемый хронической бессонницей и отчаянно пытающийся вырваться из мучительно " +
                "скучной жизни клерк встречает некоего Тайлера Дардена, харизматического торговца мылом с извращенной философией. Тайлер уверен, что самосовершенствование — удел слабых, а саморазрушение " +
                "— единственное, ради чего стоит жить."))
        films.add(Film("Джокер", 2019, "Драмма, Криминальный фильм", R.drawable.second_film,"Готэм, начало 1980-х годов. Комик Артур Флек живет с больной матерью, " +
                "которая с детства учит его «ходить с улыбкой». Пытаясь нести в мир хорошее и дарить людям радость, " +
                "Артур сталкивается с человеческой жестокостью и постепенно приходит к выводу, что этот мир получит от него не добрую улыбку, а ухмылку злодея Джокера."))
        films.add(Film("Джентельмены", 2019, "Криминальный фильм, Бойевик", R.drawable.third_film,"Талантливый выпускник Оксфорда, применив свой уникальный ум " +
                "и невиданную дерзость, придумал нелегальную схему обогащения с использованием поместья обедневшей английской аристократии. Однако когда " +
                "он решает продать свой бизнес влиятельному клану миллиардеров из США, на его пути встают не менее обаятельные, но жесткие джентльмены. " +
                "Намечается обмен любезностями, который точно не обойдется без перестрелок и парочки несчастных случаев."))

        val viewManager: RecyclerView.LayoutManager = LinearLayoutManager(this)//Створюємо обєкт LinearLayoutManager
        val viewAdapter: RecyclerView.Adapter<*> = RecyclerAdapter(films) //Створюємо адаптер для доступу до масиву даних
        val recyclerView: RecyclerView = findViewById(R.id.recyclerview) //Отримуємо доступ до recyclerview у нашій активності
        recyclerView.apply {
            setHasFixedSize(true)// Розмір RecyclerView не буде змінюватись
            layoutManager = viewManager // Змінюємо менеджер компанування
            adapter = viewAdapter //Змінюємо адаптер
        }
    }
}