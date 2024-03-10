package com.example.thefourfragments.ui.counter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.thefourfragments.databinding.FragmentCounterBinding
class CounterFragment : Fragment() {

    // Step 1: Declare a nullable property for accessing views in the layout
    private var _binding: FragmentCounterBinding? = null

    // Step 2: Declare a non-nullable property to safely access _binding between onCreateView and onDestroyView
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Step 3: Initialize ViewModel to manage counter data and logic
        val counterViewModel = ViewModelProvider(this).get(CounterViewModel::class.java)

        // Step 4: Inflate the layout using FragmentCounterBinding
        _binding = FragmentCounterBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Step 5: Set onClickListeners for add and clear buttons to interact with ViewModel
        binding.apply {
            add.setOnClickListener {
                counterViewModel.addCounter(1)
            }

            clear.setOnClickListener {
                counterViewModel.clearCounter()
            }

            // Step 6: Observe counter LiveData to update counterValue TextView
            counterViewModel.counter.observe(viewLifecycleOwner) { counter ->
                counterValue.text = counter.toString()
            }
        }

        // Step 7: Observe text LiveData to update counterValue TextView with custom text
        val counter: TextView = binding.counterValue
        counterViewModel.text.observe(viewLifecycleOwner) {
            counter.text = it
        }

        // Step 8: Return the root view
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Step 9: Set _binding to null to avoid memory leaks
        _binding = null
    }
}
