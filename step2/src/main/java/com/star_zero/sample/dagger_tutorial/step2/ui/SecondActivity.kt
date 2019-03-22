package com.star_zero.sample.dagger_tutorial.step2.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.star_zero.sample.dagger_tutorial.step2.App
import com.star_zero.sample.dagger_tutorial.step2.R
import com.star_zero.sample.dagger_tutorial.step2.data.repository.HogeRepository
import com.star_zero.sample.dagger_tutorial.step2.data.repository.UserRepository
import timber.log.Timber
import javax.inject.Inject

class SecondActivity: AppCompatActivity() {

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    lateinit var hogeRepository: HogeRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val appComponent = (application as App).appComponent
        appComponent.inject(this)

        // Scopeを指定しているので、同一Componentの場合は同じインスタンスが使われる（MainActivityと同じインスタンス）
        Timber.d("userRepository: $userRepository")
        // Scopeがないので、毎回インスタンスが生成される（このActivityが起動されるたび違うインスタンス）
        Timber.d("hogeRepository: $hogeRepository")
    }
}