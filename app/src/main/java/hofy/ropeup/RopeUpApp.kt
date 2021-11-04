package hofy.ropeup

import android.app.Application
import hofy.data.di.dataModule
import hofy.ropeup.domain.di.domainModule
import hofy.ropeup.presentation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RopeUpApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@RopeUpApp)
            modules(
                viewModelModule,
                dataModule,
                domainModule
            )
        }
    }
}