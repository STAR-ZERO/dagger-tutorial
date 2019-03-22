package com.star_zero.sample.dagger_tutorial.step3.data.repository

class UserDataRepository(private val baseURL: String) : UserRepository {
    override fun getName(): String {
        return "Sample Name, baseURL=$baseURL"
    }
}