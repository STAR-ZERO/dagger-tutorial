package com.star_zero.sample.dagger_tutorial.step4

import android.app.Application
import com.star_zero.sample.dagger_tutorial.step4.di.AppComponent
import com.star_zero.sample.dagger_tutorial.step4.di.AppModule
import com.star_zero.sample.dagger_tutorial.step4.di.DaggerAppComponent
import timber.log.Timber

class App : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule("https://example.com"))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}