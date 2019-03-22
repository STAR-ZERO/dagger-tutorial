package com.star_zero.sample.dagger_tutorial.step1.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.star_zero.sample.dagger_tutorial.step1.R
import com.star_zero.sample.dagger_tutorial.step1.data.repository.UserRepository
import com.star_zero.sample.dagger_tutorial.step1.di.AppModule
import com.star_zero.sample.dagger_tutorial.step1.di.DaggerAppComponent
import timber.log.Timber
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    // フィールドインジェクション
    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    lateinit var viewModel: MainViewModel // AACのViewModelではないので普通にインスタンスを作れる

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.d("onCreate")

        val appComponent = DaggerAppComponent.builder()
            .appModule(AppModule("https://example.com")) // Moduleに引数がある場合はインスタンスを作って渡す必要がある
            .build()
        appComponent.inject(this)

        Timber.d("userRepository.getName = ${userRepository.getName()}")
        Timber.d("viewModel.getName = ${viewModel.getName()}")
    }
}
