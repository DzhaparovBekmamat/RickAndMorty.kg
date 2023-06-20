package com.example.myapplication.ui.fragments.characterFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.core.UIState
import com.example.myapplication.data.model.MainResponse
import com.example.myapplication.data.model.Result
import com.example.myapplication.databinding.FragmentCharacterBinding
import dagger.hilt.android.AndroidEntryPoint

@Suppress("CAST_NEVER_SUCCEEDS")
@AndroidEntryPoint
class CharacterFragment : Fragment() {
    private var page: Int = 1
    private lateinit var binding: FragmentCharacterBinding
    private val viewModel by lazy { ViewModelProvider(requireActivity())[CharacterViewModel::class.java] }
    private val adapter by lazy { CharacterAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewCharacter.adapter = adapter
        fetchData()
        binding.swipeRefreshLayout.setOnRefreshListener {
            page++
            fetchData()
            binding.swipeRefreshLayout.isRefreshing = false
        }
    }

    private fun fetchData() {
        viewModel.getDetailCharacter(id)

        viewModel.livedataDetail.observe(viewLifecycleOwner) {
            when (it) {
                is UIState.Error -> isError(it.message)
                is UIState.Loading -> isLoading()
                is UIState.Success -> isSuccess(it.data)
            }
        }
    }

    private fun isSuccess(data: MainResponse<Result>?) {
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
