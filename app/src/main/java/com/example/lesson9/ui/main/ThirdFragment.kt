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
import androidx.lifecycle.Observer
import com.example.lesson9.Constants
import com.example.lesson9.R

class ThirdFragment : Fragment() {

    companion object {
        fun newInstance() = ThirdFragment()
        const val TAG = Constants.TAG + "ThirdFragment"
    }

    private lateinit var dataViewModel: DataViewModel
    private lateinit var message: TextView
    private lateinit var message2: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "onCreateView")
        return inflater.inflate(R.layout.first_fragment, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "onActivityCreated")
        dataViewModel = ViewModelProvider(requireActivity()).get(DataViewModel::class.java)
        Log.d(TAG, "ViewModel: $dataViewModel")
        dataViewModel.getText().observe(this,
            Observer<String> { t -> message2.text = t })

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        message = view.findViewById(R.id.message)
        message2 = view.findViewById(R.id.message2)

    }

    fun setMessage(text: String) {
        message.text = text
    }
}
