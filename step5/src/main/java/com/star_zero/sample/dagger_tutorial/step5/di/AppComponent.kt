package com.star_zero.sample.dagger_tutorial.step5.di

import com.star_zero.sample.dagger_tutorial.step5.ui.MainActivity
import dagger.Component

@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {

    // このパターンだとstep1やstep2等と同じ使い方になる

    // https://google.github.io/dagger/api/2.21/dagger/Component.Builder.html
    @Component.Builder
    interface Builder {
        // Componentを返すメソッドは必須
        fun build(): AppComponent

        // Moduleを１つ引数にするメソッドを定義して、戻り値にBuilder自身を返す
        fun appModule(appModule: AppModule): Builder
    }

    fun inject(activity: MainActivity)
}
