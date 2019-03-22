package com.star_zero.sample.dagger_tutorial.step3.di

import com.star_zero.sample.dagger_tutorial.step3.data.repository.UserDataRepository
import com.star_zero.sample.dagger_tutorial.step3.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val baseURL: String) {

    @Singleton
    @Provides
    fun provideUserRepository(): UserRepository {
        return UserDataRepository(baseURL)
    }
}
