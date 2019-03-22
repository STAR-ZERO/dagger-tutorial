package com.star_zero.sample.dagger_tutorial.step5.data.repository

import android.app.Application

class UserDataRepository(private val application: Application) : UserRepository {
    override fun getName(): String {
        return "PackageName: ${application.packageName}"
    }
}