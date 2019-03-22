package com.star_zero.sample.dagger_tutorial.step6

import android.app.Application
import com.star_zero.sample.dagger_tutorial.step6.di.AppComponent
import com.star_zero.sample.dagger_tutorial.step6.di.DaggerAppComponent
import timber.log.Timber

class App : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().build()
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}