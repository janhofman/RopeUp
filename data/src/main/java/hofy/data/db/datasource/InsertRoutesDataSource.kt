package hofy.data.db.datasource

import hofy.data.db.RopeUpDb
import hofy.data.db.model.DbRoute
import hofy.ropeup.domain.datasource.IInsertRoutesDataSource
import hofy.ropeup.domain.model.RouteDO

class InsertRoutesDataSource(private val db: RopeUpDb) : IInsertRoutesDataSource {
    override suspend fun insertRoutes(routes: List<RouteDO>) {
        db.routeDao()
            .insertAll(
                *routes.map { DbRoute(name = it.name, length = it.length, grade = it.grade) }
                    .toTypedArray()
            )
    }
}