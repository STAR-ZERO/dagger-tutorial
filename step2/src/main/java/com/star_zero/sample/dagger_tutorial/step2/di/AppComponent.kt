package com.star_zero.sample.dagger_tutorial.step2.di

import com.star_zero.sample.dagger_tutorial.step2.ui.MainActivity
import com.star_zero.sample.dagger_tutorial.step2.ui.SecondActivity
import dagger.Component
import javax.inject.Singleton

@Singleton // Componentの生存期間のScopeを指定。雑に言うとScopeは生存期間の名前。
@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(activity: SecondActivity)
}
