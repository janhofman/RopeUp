package hofy.ropeup.domain.di

import hofy.ropeup.domain.usecase.CreateRouteUseCase
import hofy.ropeup.domain.usecase.RetrieveRoutesUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val domainModule = module {
    single {
        RetrieveRoutesUseCase(
            get(named(REMOTE_QUALIFIER)),
            get(named(LOCAL_QUALIFIER)),
            get()
        )
    }
    single { CreateRouteUseCase(get(named(REMOTE_QUALIFIER)), get(named(LOCAL_QUALIFIER))) }
}

const val LOCAL_QUALIFIER = "database"
const val REMOTE_QUALIFIER = "firestore"