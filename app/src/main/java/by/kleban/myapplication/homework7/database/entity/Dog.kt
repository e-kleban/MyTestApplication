package by.kleban.myapplication.homework7.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_dog")
data class Dog(
    val breed: String,
    val ref: String,
    val congratulation: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
