package hofy.ropeup.domain.datasource

import hofy.ropeup.domain.model.RouteDO

interface IInsertRoutesDataSource {
    suspend fun insertRoutes(routes: List<RouteDO>)
}