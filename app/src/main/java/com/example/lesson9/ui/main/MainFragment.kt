package com.example.lesson9.ui.main

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.lesson9.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
        const val TAG = Constants.TAG + "MainFragment"
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "onCreateView")
        return inflater.inflate(R.layout.main_fragment, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "onActivityCreated")
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

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
    lateinit var message : TextView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message = view.findViewById(R.id.message)

    }
    fun setText(text: String) {
        message.text=text
    }
}
