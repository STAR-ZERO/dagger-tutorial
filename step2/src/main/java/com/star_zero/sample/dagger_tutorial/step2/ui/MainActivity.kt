package com.star_zero.sample.dagger_tutorial.step2.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.star_zero.sample.dagger_tutorial.step2.App
import com.star_zero.sample.dagger_tutorial.step2.R
import com.star_zero.sample.dagger_tutorial.step2.data.repository.HogeRepository
import com.star_zero.sample.dagger_tutorial.step2.data.repository.UserRepository
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    lateinit var hogeRepository: HogeRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appComponent = (application as App).appComponent
        appComponent.inject(this)

        Timber.d("userRepository: $userRepository")
        Timber.d("hogeRepository: $hogeRepository")

        findViewById<Button>(R.id.button).setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}
