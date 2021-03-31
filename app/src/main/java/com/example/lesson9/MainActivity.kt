package com.example.lesson9

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.lesson9.ui.main.FirstFragment
import com.example.lesson9.ui.main.ThirdFragment

class MainActivity : AppCompatActivity(), DataListener {
    private lateinit var firstFragment: FirstFragment
    private lateinit var thirdFragment: ThirdFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        setContentView(R.layout.main_activity)
        val saved = supportFragmentManager.findFragmentByTag("firstFragment")
        firstFragment = saved as FirstFragment? ?: FirstFragment.newInstance()
        if (savedInstanceState == null) {
            showFragment(firstFragment,"firstFragment")
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

    override fun onTextChanged(text: String, swapFragment: Int) {
        if (swapFragment == 1) {
            firstFragment.setMessage(text)
            Log.d(TAG, "onTextChanged")
        } else {
            thirdFragment.setMessage(text)
            Log.d(TAG, "onTextChanged")
        }
    }

    fun onNavigationItemSelected2(swapFragment: Int) {
        if (swapFragment == 1) {
            val saved = supportFragmentManager.findFragmentByTag("firstFragment")
            firstFragment = saved as FirstFragment? ?: FirstFragment.newInstance()
            showFragment(firstFragment,"firstFragment")
        } else {
            val saved = supportFragmentManager.findFragmentByTag("thirdFragment")
            thirdFragment = saved as ThirdFragment? ?: ThirdFragment.newInstance()
            showFragment(thirdFragment,"thirdFragment")
        }
    }

    private fun showFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment, tag)
            .commit()
        Log.d(TAG, tag)
    }
}