package com.star_zero.sample.dagger_tutorial.step4.di

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.star_zero.sample.dagger_tutorial.step4.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @ActivityScope
    @Provides
    fun provideFragmentManager(): FragmentManager {
        return activity.supportFragmentManager
    }
}