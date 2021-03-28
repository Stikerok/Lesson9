package com.example.lesson9

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.lesson9.ui.main.Constants
import com.example.lesson9.ui.main.DataListener
import com.example.lesson9.ui.main.FirstFragment
import com.example.lesson9.ui.main.ThirdFragment
import com.example.lesson9.ui.main.FirstFragment.Companion as FirstFragment1

class MainActivity : AppCompatActivity(), DataListener {
    private lateinit var firstFragment: FirstFragment
    private lateinit var thirdFragment: ThirdFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        setContentView(R.layout.main_activity)
        val saved = supportFragmentManager.findFragmentByTag("First")
        firstFragment = saved as FirstFragment? ?: FirstFragment1.newInstance()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, firstFragment, "First")
                .commit()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    companion object {
        const val TAG = Constants.TAG + "Main activity"
    }

    override fun onTextChanged(text: String) {
        firstFragment.setMessage(text)
        Log.d(TAG, "onTextChanged")
    }

    fun onNavigationItemSelected2(gg: Boolean) {
        if (gg) {
            val saved = supportFragmentManager.findFragmentByTag("First")
            firstFragment = saved as FirstFragment? ?: FirstFragment.newInstance()
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, firstFragment, "First")
                .commit()
            Log.d(TAG, "FIRST")
        } else {
            val saved = supportFragmentManager.findFragmentByTag("Third")
            thirdFragment = saved as ThirdFragment? ?: ThirdFragment.newInstance()
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, thirdFragment, "Third")
                .commit()
            Log.d(TAG, "THIRD")
        }
    }
}