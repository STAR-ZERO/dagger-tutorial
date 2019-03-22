package com.star_zero.sample.dagger_tutorial.step3.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.star_zero.sample.dagger_tutorial.step3.App
import com.star_zero.sample.dagger_tutorial.step3.R
import com.star_zero.sample.dagger_tutorial.step3.data.repository.UserRepository
import com.star_zero.sample.dagger_tutorial.step3.di.ActivityComponent
import com.star_zero.sample.dagger_tutorial.step3.di.ActivityModule
import com.star_zero.sample.dagger_tutorial.step3.di.DaggerActivityComponent
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    lateinit var fragmentManager: FragmentManager

    val activityComponent: ActivityComponent by lazy {
        val appComponent = (application as App).appComponent
        DaggerActivityComponent.builder()
            .appComponent(appComponent) // 親のAppComponentインスタンスを設定する
            .activityModule(ActivityModule(this))
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityComponent.inject(this)

        Timber.d("userRepository: $userRepository")
        Timber.d("fragmentManager: $fragmentManager")

        findViewById<Button>(R.id.button).setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        // 確認用Fragment作成
        fragmentManager.beginTransaction()
            .add(MainFragment(), "TAG")
            .commit()
    }
}
