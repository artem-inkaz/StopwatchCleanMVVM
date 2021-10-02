package ui.smartpro.stopwatchcleanmvvm.app

import android.app.Application
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ui.smartpro.stopwatchcleanmvvm.di.appModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(applicationContext)
            if (BuildConfig.DEBUG)
                printLogger()
            modules(
                arrayListOf(
                    appModule
                )
            )
        }
    }
}