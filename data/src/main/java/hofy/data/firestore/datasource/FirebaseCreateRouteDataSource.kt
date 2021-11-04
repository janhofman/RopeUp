package hofy.data.firestore.datasource

import hofy.data.firestore.FirestoreManager
import hofy.data.firestore.model.FbRoute
import hofy.ropeup.domain.datasource.ICreateRouteDataSource
import hofy.ropeup.domain.model.RouteDO

class FirebaseCreateRouteDataSource(private val firestoreManager: FirestoreManager) :
    ICreateRouteDataSource {
    override suspend fun createRoute(routeDO: RouteDO): Result<Unit> {
        return firestoreManager.createRoute(
            FbRoute(
                routeDO.name,
                routeDO.length,
                routeDO.grade
            )
        )
    }
}