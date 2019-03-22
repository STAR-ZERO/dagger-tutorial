package com.star_zero.sample.dagger_tutorial.step5.di

import android.app.Application
import com.star_zero.sample.dagger_tutorial.step5.data.repository.UserDataRepository
import com.star_zero.sample.dagger_tutorial.step5.data.repository.UserRepository
import dagger.Module
import dagger.Provides

// @BindsInstanceを使ってるので、コンストラクタに引数はいらなくなる
@Module
class AppModule2 {

    // Componentの@BindsInstanceによって渡される
    @Provides
    fun provideUserRepository(application: Application): UserRepository {
        return UserDataRepository(application)
    }
}
