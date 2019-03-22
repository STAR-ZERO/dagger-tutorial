package com.star_zero.sample.dagger_tutorial.step3.ui

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.star_zero.sample.dagger_tutorial.step3.data.repository.UserRepository
import timber.log.Timber
import javax.inject.Inject

class MainFragment : Fragment() {

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    lateinit var activityFragmentManager: FragmentManager

    override fun onAttach(context: Context) {
        super.onAttach(context)

        // MainActivityで作ったComponentを使ってInjectする
        val activityComponent = (requireActivity() as MainActivity).activityComponent
        activityComponent.inject(this)

        // MainActivityと同じインスタンス
        Timber.d("userRepository: $userRepository")
        // MainActivityと同じインスタンスを使ってるので同じインスタンス
        Timber.d("fragmentManager: $activityFragmentManager")
    }

}