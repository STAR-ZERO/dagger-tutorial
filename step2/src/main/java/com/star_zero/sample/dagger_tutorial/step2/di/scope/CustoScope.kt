package com.star_zero.sample.dagger_tutorial.step2.di.scope

import javax.inject.Scope

// Scopeはこんな感じで自分で定義できる
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class CustoScope