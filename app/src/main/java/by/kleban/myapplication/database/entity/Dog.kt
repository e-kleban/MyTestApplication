package by.kleban.myapplication.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_dog")
data class Dog(
    val breed: String,
    val ref: String,
    val description: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
