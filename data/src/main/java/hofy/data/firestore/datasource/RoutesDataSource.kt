package hofy.data.firestore.datasource

import hofy.data.firestore.FirestoreManager
import hofy.ropeup.domain.datasource.IGetRoutesDataSource
import hofy.ropeup.domain.model.RouteDO

class RoutesDataSource(private val firestoreManager: FirestoreManager) : IGetRoutesDataSource {
    override suspend fun getRoutes(): Result<List<RouteDO>> {
        val result = firestoreManager.getRoutes()
        return if (result.isSuccess) {
            val data = result.getOrNull() ?: listOf()
            Result.success(data.map {
                RouteDO(it.name, it.length, it.grade)
            })
        } else {
            Result.failure(result.exceptionOrNull() ?: Exception())
        }
    }
}