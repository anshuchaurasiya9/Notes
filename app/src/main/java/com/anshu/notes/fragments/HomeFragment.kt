package com.anshu.notes.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.anshu.notes.R
import com.anshu.notes.ViewModel.NotesViewModel
import com.anshu.notes.adapters.NotesAdapter
import com.anshu.notes.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    val viewModel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        binding.btnAddNotes.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_homeFragment_to_createNotesFragment)
        }


        viewModel.getNotes().observe(viewLifecycleOwner) { notesList ->

            binding.rcvHome.layoutManager = GridLayoutManager(requireContext(), 2)
            binding.rcvHome.adapter = NotesAdapter(requireContext(), notesList)
        }



        return binding.root
    }


}