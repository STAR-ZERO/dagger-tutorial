package com.star_zero.sample.dagger_tutorial.step1.ui

import com.star_zero.sample.dagger_tutorial.step1.data.repository.UserRepository
import javax.inject.Inject

// サンプル用のViewModelでAACのViewModelではないので、普通にインスタンスを作る

// コンストラクタインジェクション
class MainViewModel @Inject constructor(
    private val userRepository: UserRepository
) {

    fun getName(): String {
        return userRepository.getName()
    }
}