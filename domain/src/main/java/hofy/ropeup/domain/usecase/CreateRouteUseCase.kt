package hofy.ropeup.domain.usecase

import hofy.ropeup.domain.datasource.ICreateRouteDataSource
import hofy.ropeup.domain.model.RouteDO

class CreateRouteUseCase(
    private val remoteDataSource: ICreateRouteDataSource,
    private val localDataSource: ICreateRouteDataSource
) : UseCase<RouteDO, Unit>() {
    override suspend fun execute(params: RouteDO): Result<Unit> {
        localDataSource.createRoute(params)
        return remoteDataSource.createRoute(params)
    }
}