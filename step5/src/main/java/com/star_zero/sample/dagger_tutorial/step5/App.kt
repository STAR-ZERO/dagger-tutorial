package com.star_zero.sample.dagger_tutorial.step5

import android.app.Application
import com.star_zero.sample.dagger_tutorial.step5.di.AppComponent2
import com.star_zero.sample.dagger_tutorial.step5.di.DaggerAppComponent2
import timber.log.Timber

class App : Application() {

//    val appComponent: AppComponent by lazy {
//        DaggerAppComponent.builder()
//            .appModule(AppModule(this))
//            .build()
//    }

    val appComponent2: AppComponent2 by lazy {
        DaggerAppComponent2.builder()
            // Moduleのインスタンスは不要になって、@BindsInstanceの引数のみ設定すれば良い
            .application(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}