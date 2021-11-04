package hofy.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import hofy.data.db.model.DbRoute

@Dao
interface RouteDao {
    @Insert
    suspend fun insert(route: DbRoute)

    @Insert
    suspend fun insertAll(vararg routes: DbRoute)

    @Query("SELECT * FROM DbRoute")
    fun getAll(): List<DbRoute>

}