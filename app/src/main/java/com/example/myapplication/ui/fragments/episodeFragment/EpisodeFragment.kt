package com.example.myapplication.ui.fragments.episodeFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.core.UIState
import com.example.myapplication.data.model.Episode
import com.example.myapplication.data.model.MainResponse
import com.example.myapplication.databinding.FragmentEpisodeBinding
import dagger.hilt.android.AndroidEntryPoint

@Suppress("CAST_NEVER_SUCCEEDS")
@AndroidEntryPoint
class EpisodeFragment : Fragment() {
    private var page: Int = 1
    private lateinit var binding: FragmentEpisodeBinding
    private val viewModel by lazy { ViewModelProvider(requireActivity())[EpisodeViewModel::class.java] }
    private val adapter by lazy { EpisodeAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentEpisodeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewEpisode.adapter = adapter
        fetchData()
        binding.swipeRefreshLayout.setOnRefreshListener {
            page++
            fetchData()
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun fetchData() {
        viewModel.getDetailEpisode()
        viewModel.livedataDetail.observe(viewLifecycleOwner) {
            when (it) {
                is UIState.Error -> isError(it.message)
                is UIState.Loading -> isLoading()
                is UIState.Success -> isSuccess(it.data)
            }
        }
    }

    private fun isSuccess(data: MainResponse<Episode>?) {
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

