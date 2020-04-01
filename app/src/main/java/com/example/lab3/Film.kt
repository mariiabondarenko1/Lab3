package com.example.lab3

import android.os.Parcel
import android.os.Parcelable

//Клас для представлення даних. Використовує інтерфейс Parcelable для коректної передачі даних з однієї активності в іншу
class Film (val title:String?, val year:Int, val genre:String?, val photo:Int, val description:String?) : Parcelable{

    //Конструктор класу
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    ) {}


    //Метод, що зпередає дані
    override fun writeToParcel(parcel: Parcel, flags: Int) {
       parcel.writeString(title)
        parcel.writeInt(year)
        parcel.writeString(genre)
        parcel.writeInt(photo)
        parcel.writeString(description)
    }

    //Обовязкові функції для перевизначення
    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<Film> {
        override fun createFromParcel(parcel: Parcel): Film {
            return Film(parcel)
        }

        override fun newArray(size: Int): Array<Film?> {
            return arrayOfNulls(size)
        }
    }
}