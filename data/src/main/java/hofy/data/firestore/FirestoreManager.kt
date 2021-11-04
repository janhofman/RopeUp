package hofy.data.firestore

import com.google.firebase.firestore.FirebaseFirestore
import hofy.data.firestore.model.FbRoute
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withTimeout
import java.util.concurrent.TimeoutException

class FirestoreManager(private val firestore: FirebaseFirestore) {
    suspend fun getRoutes(): Result<List<FbRoute>> {
        return safeFirestoreCall {
            Result.success(
                firestore.collection(FirestoreNodes.ROUTES).get().await()
                    .toObjects(FbRoute::class.java)
            )
        }
    }

    suspend fun createRoute(route: FbRoute): Result<Unit> {
        return safeFirestoreCall {
            val doc = firestore.collection(FirestoreNodes.ROUTES).document()
            doc.set(route).await()
            Result.success(Unit)
        }
    }

}

suspend fun <T : Any> safeFirestoreCall(call: suspend () -> Result<T>): Result<T> {
    return try {
        withTimeout(5000) {
            call()
        }
        Result.failure(TimeoutException())
    } catch (e: Exception) {
        Result.failure(e)
    }
}