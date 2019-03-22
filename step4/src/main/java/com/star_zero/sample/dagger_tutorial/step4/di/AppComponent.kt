package com.star_zero.sample.dagger_tutorial.step4.di

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {

    // dependenciesと異なり、親から子を指定する
    // 戻り値にBuilderを使うことで、Moduleインスタンスを渡すことができるようにする
    // （Moduleインスタンスがすべてデフォルトコンストラクタの場合は直接ActivityComponentを返すことも可能）
    fun activityComponent(): ActivityComponent.Builder
}
