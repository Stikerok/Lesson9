package com.example.lesson9.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel : ViewModel() {
    private val text: MutableLiveData<String> = MutableLiveData()

    fun getText(): LiveData<String> {
        Log.d(TAG, "getText $this")
        return text
    }

    fun setText(text: String) {
        Log.d(TAG, "setText $text ($this)")
        this.text.value = text
    }

    companion object {
        const val TAG = Constants.TAG + "_vm"
    }
}