package com.example.lesson9

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.example.lesson9.ui.main.Constants
import com.example.lesson9.ui.main.MainFragment
import com.example.lesson9.ui.main.SecondFragment

class MainActivity : AppCompatActivity(), SecondFragment.Secondlistener {
    lateinit var mainFragment: MainFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        setContentView(R.layout.main_activity)
        val saved = supportFragmentManager.findFragmentByTag("Second")
        mainFragment = saved as MainFragment? ?: MainFragment.newInstance()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, mainFragment,"Second")
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

    override fun onText(text: String) {
        mainFragment.setText(text)
    }
}