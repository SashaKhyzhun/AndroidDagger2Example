package com.sashakhyzhun.androiddagger2example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dagger.Component
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

/**
 * This tutorial helps me.
 * https://medium.com/@elye.project/dagger-2-for-dummies-in-kotlin-with-one-page-simple-code-project-618a5f9f2fe8
 */
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var info: Info

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMagicBox.create().poke(this)
        textView.text = info.text
    }
}

class Info @Inject constructor() {
    val text = "Hello Dagger 2"
}

/**
 * Component - it's like the place where your items will be initiated.
 * */
@Component
interface MagicBox { // <bla-bla-bla>Component
    fun poke(app: MainActivity) // inject()
}