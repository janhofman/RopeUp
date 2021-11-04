package hofy.ropeup.domain.datasource

import hofy.ropeup.domain.model.RouteDO

interface ICreateRouteDataSource {
    suspend fun createRoute(routeDO: RouteDO): Result<Unit>
}