package com.raghav.flor

import android.app.Application
import androidx.core.app.ActivityCompat
import com.raghav.data.di.dataModule
import com.raghav.domain.di.domainModule
import com.raghav.framework.di.frameworkModule
import com.raghav.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


import java.security.Permission
import java.util.jar.Manifest

class FlorApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeKoin()
    }

    fun initializeKoin() {
        startKoin {
            androidContext(this@FlorApplication)
            modules(frameworkModule, dataModule, domainModule, presentationModule)
        }
    }
}
