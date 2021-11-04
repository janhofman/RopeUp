package hofy.ropeup.domain.usecase

abstract class UseCase<PARAMS, DATA> {
    abstract suspend fun execute(params: PARAMS): Result<DATA>
}