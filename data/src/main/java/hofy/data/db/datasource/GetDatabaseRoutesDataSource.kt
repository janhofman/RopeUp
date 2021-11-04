package hofy.data.db.datasource

import hofy.data.db.RopeUpDb
import hofy.ropeup.domain.datasource.IGetRoutesDataSource
import hofy.ropeup.domain.model.RouteDO

class GetDatabaseRoutesDataSource(private val db: RopeUpDb) : IGetRoutesDataSource {
    override suspend fun getRoutes(): Result<List<RouteDO>> {
        return Result.success(db.routeDao().getAll().map {
            RouteDO(it.name, it.length, it.grade)
        })
    }
}