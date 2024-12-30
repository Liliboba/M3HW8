package com.example.m3hw8

import CakeAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.m3hw8.databinding.FragmentCakeBinding

class CakeFragment : Fragment() {

    private lateinit var binding: FragmentCakeBinding
    private lateinit var cakeAdapter: CakeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCakeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cakeList = listOf(
            CakeModel("Chocolate Cake", "45 $"),
            CakeModel("Vanilla Cake", "15 $"),
            CakeModel("Red Velvet Cake", "100 $")
        )

        cakeAdapter = CakeAdapter(cakeList){
            findNavController().navigate(R.id.action_cakeFragment_to_cakeDetailFragment)
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = cakeAdapter
        }
    }
}
