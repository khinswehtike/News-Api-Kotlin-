package com.example.newsapikotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsapikotlin.ui.ArticleListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null){
            val articleFragment=ArticleListFragment()
            supportFragmentManager.beginTransaction().add(R.id.screenContainer,articleFragment)
                .commit()
        }
    }
}
