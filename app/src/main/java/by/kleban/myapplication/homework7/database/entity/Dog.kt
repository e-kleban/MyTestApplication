package by.kleban.myapplication.homework7.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "table_dog")
data class Dog(
    val breed: String,
    val ref: String,
    val description: String
): Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
