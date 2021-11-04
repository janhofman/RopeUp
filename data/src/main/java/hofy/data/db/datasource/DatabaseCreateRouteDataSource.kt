package hofy.data.db.datasource

import hofy.data.db.RopeUpDb
import hofy.data.db.model.DbRoute
import hofy.ropeup.domain.datasource.ICreateRouteDataSource
import hofy.ropeup.domain.model.RouteDO

class DatabaseCreateRouteDataSource(private val db: RopeUpDb) : ICreateRouteDataSource {
    override suspend fun createRoute(routeDO: RouteDO): Result<Unit> {
        db.routeDao().insert(
            DbRoute(
                name = routeDO.name,
                length = routeDO.length,
                grade = routeDO.grade,

                )
        )
        return Result.success(Unit)
    }
}