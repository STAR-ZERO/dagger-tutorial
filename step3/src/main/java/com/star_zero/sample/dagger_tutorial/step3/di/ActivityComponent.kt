package com.star_zero.sample.dagger_tutorial.step3.di

import com.star_zero.sample.dagger_tutorial.step3.di.scope.ActivityScope
import com.star_zero.sample.dagger_tutorial.step3.ui.MainActivity
import com.star_zero.sample.dagger_tutorial.step3.ui.MainFragment
import com.star_zero.sample.dagger_tutorial.step3.ui.SecondActivity
import dagger.Component

@ActivityScope // 親と子ではScopeを分ける必要がある。この場合は@Singletonの中に、@ActivityScopeがある感じで、@ActivityScopeのほうが生存期間が短い。
@Component(
    modules = [
        ActivityModule::class
    ],

    // dependenciesで親となるComponentを指定する
    dependencies = [AppComponent::class]
)
interface ActivityComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: MainFragment)
    fun inject(activity: SecondActivity)
}