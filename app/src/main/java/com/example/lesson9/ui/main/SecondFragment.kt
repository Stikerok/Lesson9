package com.example.lesson9.ui.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lesson9.R

class SecondFragment : Fragment() {
    companion object {
        fun newInstance() = SecondFragment()
        const val TAG = Constants.TAG + "Second"
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var input1: EditText
    private lateinit var input2: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "onCreateView")
        return inflater.inflate(R.layout.second_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        input1 = view.findViewById(R.id.userName)
        input2 = view.findViewById(R.id.user)
        input1.doOnTextChanged { text, start, before, count ->  listener?.onText(text.toString())}
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "onActivityCreated")
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }
    var listener: Secondlistener?= null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is Secondlistener) context else null
        Log.d(TAG, "onAttach")
    }

    override fun onStart() {
        super.onStart()

        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.d(TAG, "onResume")
    }

    override fun onStop() {
        Log.d(TAG, "onStop")

        super.onStop()
    }

    override fun onDestroyView() {
        Log.d(TAG, "onDestroyView")

        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")

        super.onDestroy()
    }

    override fun onDetach() {
        Log.d(TAG, "onDetach")

        super.onDetach()
    }

    interface Secondlistener {
        fun onText(text: String)
    }
}