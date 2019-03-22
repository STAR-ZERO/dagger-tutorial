package com.star_zero.sample.dagger_tutorial.step5.di

import android.app.Application
import com.star_zero.sample.dagger_tutorial.step5.ui.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        AppModule2::class
    ]
)
interface AppComponent2 {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent2

        // ここの引数がModuleの各@Providesの注入される
        @BindsInstance
        fun application(application: Application): Builder
    }

    fun inject(activity: MainActivity)
}
