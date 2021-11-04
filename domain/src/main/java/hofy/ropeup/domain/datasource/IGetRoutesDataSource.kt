package hofy.ropeup.domain.datasource

import hofy.ropeup.domain.model.RouteDO

interface IGetRoutesDataSource {
    suspend fun getRoutes(): Result<List<RouteDO>>
}