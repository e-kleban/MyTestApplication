package by.kleban.myapplication

import java.io.Serializable

data class Card(
    val congratulation: String,
    val ref: String
) : Serializable {
}