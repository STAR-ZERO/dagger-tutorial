package com.star_zero.sample.dagger_tutorial.step1.di

import com.star_zero.sample.dagger_tutorial.step1.data.repository.UserDataRepository
import com.star_zero.sample.dagger_tutorial.step1.data.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val baseURL: String) {
    // （Moduleのコンストラクタ引数よりはstep5で説明する、@BindsInstanceを使うほうが推奨。）

    @Provides
    fun provideUserRepository(): UserRepository {
        return UserDataRepository(baseURL)
    }
}
