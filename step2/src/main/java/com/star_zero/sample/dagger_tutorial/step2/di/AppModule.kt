package com.star_zero.sample.dagger_tutorial.step2.di

import com.star_zero.sample.dagger_tutorial.step2.data.repository.HogeDataRepository
import com.star_zero.sample.dagger_tutorial.step2.data.repository.HogeRepository
import com.star_zero.sample.dagger_tutorial.step2.data.repository.UserDataRepository
import com.star_zero.sample.dagger_tutorial.step2.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val baseURL: String) {

    @Singleton // Scopeを指定することでComponentが生存してる間は同じインスタンスが使われる
    @Provides
    fun provideUserRepository(): UserRepository {
        return UserDataRepository(baseURL)
    }

//    @CustoScope AppComponentが@Singletonを使ってるので、他のScopeは使用できない
//    @Provides
//    fun provideUserRepository(): UserRepository {
//        return UserDataRepository(baseURL)
//    }

    @Provides
    fun provideHogeRepository(): HogeRepository {
        return HogeDataRepository()
    }
}
