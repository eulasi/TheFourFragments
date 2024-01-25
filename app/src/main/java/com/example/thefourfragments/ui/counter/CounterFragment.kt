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

    private var _binding: FragmentCounterBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

//        var counter = 0

        val counterViewModel =
            ViewModelProvider(this).get(CounterViewModel::class.java)

        _binding = FragmentCounterBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Look in more detail
        binding.apply {
            add.setOnClickListener {
                counterViewModel.addCounter(1)
            }

            clear.setOnClickListener {
                counterViewModel.clearCounter()
            }

//            homeViewModel.counter.observe(viewLifecycleOwner, {})
            counterViewModel.counter.observe(viewLifecycleOwner) { counter ->
                counterValue.text = counter.toString()
            }
        }

        val counter: TextView = binding.counterValue
        counterViewModel.text.observe(viewLifecycleOwner) {
            counter.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}