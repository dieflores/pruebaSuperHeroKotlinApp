package com.example.superheroprueba

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.superheroprueba.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val mFragment = MainFragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerFrame, MainFragment.newInstance())
            .commitNow()
    }
}