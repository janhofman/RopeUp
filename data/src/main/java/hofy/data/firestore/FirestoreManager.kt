package hofy.data.firestore

import com.google.firebase.firestore.FirebaseFirestore
import hofy.data.firestore.model.FbRoute
import kotlinx.coroutines.tasks.await

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
        call()
    } catch (e: Exception) {
        // An exception was thrown when calling the API so we're converting this to an IOException
        Result.failure(e)
    }
}