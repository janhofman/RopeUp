package hofy.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


//TODO add firebase ID and restrict duplicity
@Entity
data class DbRoute(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "grade") val grade: String?,
    @ColumnInfo(name = "length") val length: Int?
)