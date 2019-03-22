package com.star_zero.sample.dagger_tutorial.step5.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.star_zero.sample.dagger_tutorial.step5.App
import com.star_zero.sample.dagger_tutorial.step5.R
import com.star_zero.sample.dagger_tutorial.step5.data.repository.UserRepository
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appComponent2 = (application as App).appComponent2
        appComponent2.inject(this)

        Timber.d("userRepository: $userRepository")
    }
}
