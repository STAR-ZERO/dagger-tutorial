package com.star_zero.sample.dagger_tutorial.step4.di

import com.star_zero.sample.dagger_tutorial.step4.di.scope.ActivityScope
import com.star_zero.sample.dagger_tutorial.step4.ui.MainActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent( // @Subcomponentを使って子であることを明示的に指定
    modules = [
        ActivityModule::class
    ]
)
interface ActivityComponent {

    // Builderを使う（step5で説明）
    @Subcomponent.Builder
    interface Builder {
        fun activityModule(activityModule: ActivityModule): Builder
        fun build(): ActivityComponent
    }

    fun inject(activity: MainActivity)
}