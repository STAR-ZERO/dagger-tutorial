package com.star_zero.sample.dagger_tutorial.step1.ui

import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.whenever
import com.star_zero.sample.dagger_tutorial.step1.data.repository.UserRepository
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class MainViewModelTest {

    // === インスタンス生成時に引数に必要なオブジェクトを作って振る舞いを変更する ===
    @Test
    fun getName1() {
        val viewModel = MainViewModel(object : UserRepository {
            override fun getName(): String {
                return "Hoge"
            }
        })

        assertThat(viewModel.getName()).isEqualTo("Hoge")
    }

    // === Mockitoを使って振る舞いを変更する ===
    @Mock
    lateinit var userRepository: UserRepository

    @InjectMocks
    lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun getName2() {
        whenever(userRepository.getName()).thenReturn("Foo")
        assertThat(viewModel.getName()).isEqualTo("Foo")
    }
}