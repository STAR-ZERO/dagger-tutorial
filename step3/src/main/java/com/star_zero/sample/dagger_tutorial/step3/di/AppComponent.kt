package com.star_zero.sample.dagger_tutorial.step3.di

import com.star_zero.sample.dagger_tutorial.step3.data.repository.UserRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {
    // 子のComponentからも使えるようにする
    fun userRepository(): UserRepository
}
