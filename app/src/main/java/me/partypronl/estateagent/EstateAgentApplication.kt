package me.partypronl.estateagent

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class EstateAgentApplication : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        initializeKoin()
    }

    private fun initializeKoin() {
        startKoin {
            androidContext(this@EstateAgentApplication)
            modules(KoinApplicationModule().module)
        }
    }
}

