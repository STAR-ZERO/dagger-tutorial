package com.star_zero.sample.dagger_tutorial.step3.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.star_zero.sample.dagger_tutorial.step3.App
import com.star_zero.sample.dagger_tutorial.step3.R
import com.star_zero.sample.dagger_tutorial.step3.data.repository.UserRepository
import com.star_zero.sample.dagger_tutorial.step3.di.ActivityModule
import com.star_zero.sample.dagger_tutorial.step3.di.DaggerActivityComponent
import timber.log.Timber
import javax.inject.Inject

class SecondActivity : AppCompatActivity() {

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val appComponent = (application as App).appComponent
        val activityComponent = DaggerActivityComponent.builder()
            .appComponent(appComponent)
            .activityModule(ActivityModule(this))
            .build()

        activityComponent.inject(this)

        // MainActivityと同じインスタンス
        Timber.d("userRepository: $userRepository")
        // MainActivityとは異なるインスタンス
        Timber.d("fragmentManager: $fragmentManager")
    }
}