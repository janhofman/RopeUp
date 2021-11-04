package hofy.data.di

import androidx.room.Room
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import hofy.data.db.RopeUpDb
import hofy.data.db.datasource.DatabaseCreateRouteDataSource
import hofy.data.db.datasource.GetDatabaseRoutesDataSource
import hofy.data.db.datasource.InsertRoutesDataSource
import hofy.data.firestore.FirestoreManager
import hofy.data.firestore.datasource.FirebaseCreateRouteDataSource
import hofy.data.firestore.datasource.RoutesDataSource
import hofy.ropeup.domain.datasource.ICreateRouteDataSource
import hofy.ropeup.domain.datasource.IGetRoutesDataSource
import hofy.ropeup.domain.datasource.IInsertRoutesDataSource
import hofy.ropeup.domain.di.LOCAL_QUALIFIER
import hofy.ropeup.domain.di.REMOTE_QUALIFIER
import org.koin.core.qualifier.named
import org.koin.dsl.module


val dataModule = module {
    single {
        Room.databaseBuilder(
            get(),
            RopeUpDb::class.java, "database-rope-up"
        ).build()
    }

    single { Firebase.firestore }
    single { FirestoreManager(get()) }
    single<IInsertRoutesDataSource> { InsertRoutesDataSource(get()) }
    single<IGetRoutesDataSource>(named(REMOTE_QUALIFIER)) { RoutesDataSource(get()) }
    single<IGetRoutesDataSource>(named(LOCAL_QUALIFIER)) { GetDatabaseRoutesDataSource(get()) }
    single<ICreateRouteDataSource>(named(REMOTE_QUALIFIER)) { FirebaseCreateRouteDataSource(get()) }
    single<ICreateRouteDataSource>(named(LOCAL_QUALIFIER)) { DatabaseCreateRouteDataSource(get()) }
}