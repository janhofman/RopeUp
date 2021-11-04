package hofy.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import hofy.data.db.dao.RouteDao
import hofy.data.db.model.DbRoute

@Database(entities = [DbRoute::class], version = 2)
abstract class RopeUpDb : RoomDatabase() {
    abstract fun routeDao(): RouteDao
}