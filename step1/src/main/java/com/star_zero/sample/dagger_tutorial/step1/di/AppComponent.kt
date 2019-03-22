package com.star_zero.sample.dagger_tutorial.step1.di

import com.star_zero.sample.dagger_tutorial.step1.ui.MainActivity
import dagger.Component

@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {
    // Injectしたいフィールドを持つクラスを引数にしたメソッドを作る
    fun inject(activity: MainActivity)
}
