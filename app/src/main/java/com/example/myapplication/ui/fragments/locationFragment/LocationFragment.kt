package com.example.myapplication.ui.fragments.locationFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.core.UIState
import com.example.myapplication.data.model.Location
import com.example.myapplication.data.model.MainResponse
import com.example.myapplication.databinding.FragmentLocationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationFragment : Fragment() {
    private var page: Int = 1
    private lateinit var binding: FragmentLocationBinding
    private val viewModel by lazy { ViewModelProvider(requireActivity())[LocationViewModel::class.java] }
    private val adapter by lazy { LocationAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentLocationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewLocation.adapter = adapter
        fetchData()
        binding.swipeRefreshLayout.setOnRefreshListener {
            page++
            fetchData()
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun fetchData() {
        viewModel.getDetailLocation()
        viewModel.livedataDetail.observe(viewLifecycleOwner) {
            when (it) {
                is UIState.Error -> isError(it.message)
                is UIState.Loading -> isLoading()
                is UIState.Success -> isSuccess(it.data)
            }
        }
    }

    private fun isSuccess(data: MainResponse<Location>?) {
        adapter.submitList(data?.results)
    }

    private fun isLoading() {
        Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
    }

    private fun isError(message: String?) {
        Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
        Log.e("ololo", message.toString())
    }
}