package com.example.lesson9.ui.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lesson9.Constants
import com.example.lesson9.DataListener
import com.example.lesson9.MainActivity
import com.example.lesson9.R


class SecondFragment : Fragment() {
    companion object {
        const val TAG = Constants.TAG + "Second"
        const val TOTAL_FRAGMENT = 2
    }

    private lateinit var dataViewModel: DataViewModel
    private lateinit var name: EditText
    private lateinit var firstName: EditText
    private lateinit var button: Button
    private var listener: DataListener? = null
    private var swapFragment : Int = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "onCreateView")
        return inflater.inflate(R.layout.second_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name = view.findViewById(R.id.userName)
        firstName = view.findViewById(R.id.first_name)
        button = view.findViewById(R.id.switch_fragment)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "onActivityCreated")
        dataViewModel = ViewModelProvider(requireActivity()).get(DataViewModel::class.java)
        Log.d(TAG, "ViewModel: $dataViewModel")
        name.doOnTextChanged { text, _, _, _ -> listener?.onTextChanged(text.toString(),swapFragment) }
        firstName.doOnTextChanged { text, _, _, _ -> dataViewModel.setText(text.toString())  }
        button.setOnClickListener {
            if (swapFragment < TOTAL_FRAGMENT) swapFragment++ else swapFragment = 1
            (activity as MainActivity?)!!.onNavigationItemSelected2((swapFragment))
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is DataListener) context else null
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
}