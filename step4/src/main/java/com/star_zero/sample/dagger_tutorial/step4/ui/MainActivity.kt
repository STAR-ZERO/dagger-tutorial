package com.star_zero.sample.dagger_tutorial.step4.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.star_zero.sample.dagger_tutorial.step4.App
import com.star_zero.sample.dagger_tutorial.step4.R
import com.star_zero.sample.dagger_tutorial.step4.data.repository.UserRepository
import com.star_zero.sample.dagger_tutorial.step4.di.ActivityModule
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appComponent = (application as App).appComponent
        // dependenciesとは異なり、親（AppComponent）から子（ActivityComponent）を取得する
        val activityComponent = appComponent.activityComponent()
            .activityModule(ActivityModule(this))
            .build()

        activityComponent.inject(this)

        Timber.d("userRepository: $userRepository")
        Timber.d("fragmentManager: $fragmentManager")
    }
}
