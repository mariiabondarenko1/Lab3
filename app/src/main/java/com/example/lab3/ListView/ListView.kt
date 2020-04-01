package com.example.lab3.ListView

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ListView
import com.example.lab3.Film
import com.example.lab3.OneFilmView
import com.example.lab3.R


class ListView : AppCompatActivity() {

    private var film: MutableList<Film> = ArrayList()//Створення масиву для збереженя даних

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        //Заповнюємо масив даними
        val list: ListView = findViewById(R.id.listView)

        film.add(Film("Бойцевский клуб", 1999, "Драмма, Триллер", R.drawable.first_film, "Терзаемый хронической бессонницей и отчаянно пытающийся вырваться из мучительно " +
                "скучной жизни клерк встречает некоего Тайлера Дардена, харизматического торговца мылом с извращенной философией. Тайлер уверен, что самосовершенствование — удел слабых, а саморазрушение " +
                "— единственное, ради чего стоит жить."))
        film.add(Film("Джокер", 2019, "Драмма, Криминальный фильм", R.drawable.second_film,"Готэм, начало 1980-х годов. Комик Артур Флек живет с больной матерью, " +
                "которая с детства учит его «ходить с улыбкой». Пытаясь нести в мир хорошее и дарить людям радость, " +
                "Артур сталкивается с человеческой жестокостью и постепенно приходит к выводу, что этот мир получит от него не добрую улыбку, а ухмылку злодея Джокера."))
        film.add(Film("Джентельмены", 2019, "Криминальный фильм, Бойевик", R.drawable.third_film,"Талантливый выпускник Оксфорда, применив свой уникальный ум " +
                "и невиданную дерзость, придумал нелегальную схему обогащения с использованием поместья обедневшей английской аристократии. Однако когда " +
                "он решает продать свой бизнес влиятельному клану миллиардеров из США, на его пути встают не менее обаятельные, но жесткие джентльмены. " +
                "Намечается обмен любезностями, который точно не обойдется без перестрелок и парочки несчастных случаев."))

        val myAdapter = ListAdapter(this, film)//Створення об'єкту адаптера
        list.adapter = myAdapter //Передача адаптера до віджету списка

        //Код для обробки при натиснені на будь-який один пункт списку
        list.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, OneFilmView::class.java)//Створюємо намір
            intent.putExtra("position", position)//Передаємо у намір позицію натиснутого пункта списку
            intent.putParcelableArrayListExtra("list", ArrayList(film))//Передаємо у намір всі дані
            this.startActivity(intent)//Відкриваємо нову активність
        }
    }
}