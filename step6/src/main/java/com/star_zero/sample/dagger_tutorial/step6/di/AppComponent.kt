package com.star_zero.sample.dagger_tutorial.step6.di

import com.star_zero.sample.dagger_tutorial.step6.ui.MainActivity
import dagger.Component

@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {
    fun inject(activity: MainActivity)
}
