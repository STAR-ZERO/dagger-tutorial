package com.star_zero.sample.dagger_tutorial.step6.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.star_zero.sample.dagger_tutorial.step6.App
import com.star_zero.sample.dagger_tutorial.step6.R
import com.star_zero.sample.dagger_tutorial.step6.di.Foo
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var noNamedString: String

    @Inject
    @field:Named("hoge") // 注意: 単純に@Named("hoge")って書くと動かない
    lateinit var namedString: String

    @Inject
    @field:Foo // 注意: 単純に@Fooって書くと動かない
    lateinit var namedAnnotationString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appComponent = (application as App).appComponent
        appComponent.inject(this)

        // それぞれAppModuleの@Providesに指定したNamedに合わせたインスタンスがinjectされる
        Timber.d("noNamedString: $noNamedString")
        Timber.d("namedString: $namedString")
        Timber.d("namedAnnotationString: $namedAnnotationString")
    }
}
