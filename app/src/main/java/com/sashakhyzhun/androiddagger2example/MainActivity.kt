package com.sashakhyzhun.androiddagger2example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dagger.Component
import dagger.Module
import dagger.Provides
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

/**
 * is annotated with @Module, and that tells Dagger 2
 * this is where we stores the @Provides functions within.
 */
@Module
class Bag @Inject constructor() {
    /**
     * You could name the class <Something>Module
     * as that’s the conventional way others called it.
     */
    @Provides
    fun sayLoveDagger2(): Info = Info("Love Dagger 2")
}

class Info(val text: String)

/**
 * Component - it's like the place where your items will be initiated.
 * */
@Component(modules = [Bag::class])
interface MagicBox { // <bla-bla-bla>Component
    /**
     * Note I use poke just to make it different from other tutorial, so
     * you know you could name it anything. Almost every other example I see,
     * people call it inject. In a group project I recommend follow this convention,
     * so everyone could understand your code.
     */
    fun poke(app: MainActivity) // inject()
}