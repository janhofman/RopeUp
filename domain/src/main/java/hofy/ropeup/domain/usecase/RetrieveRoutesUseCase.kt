package hofy.ropeup.domain.usecase

import hofy.ropeup.domain.datasource.IGetRoutesDataSource
import hofy.ropeup.domain.datasource.IInsertRoutesDataSource
import hofy.ropeup.domain.model.RouteDO

class RetrieveRoutesUseCase(
    private val dataSource: IGetRoutesDataSource,
    private val databaseDataSource: IGetRoutesDataSource,
    private val insertDataSource: IInsertRoutesDataSource
) : UseCase<Unit, List<RouteDO>>() {
    override suspend fun execute(params: Unit): Result<List<RouteDO>> {
        val routesResult = dataSource.getRoutes()
        return if (routesResult.isSuccess) {
            insertDataSource.insertRoutes(routesResult.getOrDefault(listOf()))
            routesResult
        } else {
            databaseDataSource.getRoutes()
        }
    }
}