package com.star_zero.sample.dagger_tutorial.step5.di

import android.app.Application
import com.star_zero.sample.dagger_tutorial.step5.data.repository.UserDataRepository
import com.star_zero.sample.dagger_tutorial.step5.data.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val application: Application) {

    @Provides
    fun provideUserRepository(): UserRepository {
        return UserDataRepository(application)
    }
}
