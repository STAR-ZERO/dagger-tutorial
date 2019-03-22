package com.star_zero.sample.dagger_tutorial.step6.di

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class AppModule {

    @Provides
    fun providesNoNamedString(): String {
        return "No named"
    }

    // 同じ型の別のインスタンスを依存解決する場合は@Namedを使って分けれる
    @Named("hoge")
    @Provides
    fun providesNamedString(): String {
        return "Named hoge"
    }

    // 自分でアノテーションを作ることもできる
    @Foo
    @Provides
    fun providesNamedAnnotationString(): String {
        return "Named annotation"
    }

    // 同じ型で同じNamedまたは無指定が複数ある場合はビルドエラー
//    @Provides
//    fun providesNoNamedString2(): String {
//        return "No named2"
//    }
//
//    @Named("hoge")
//    @Provides
//    fun providesNamedString2(): String {
//        return "Named hoge2"
//    }
}
