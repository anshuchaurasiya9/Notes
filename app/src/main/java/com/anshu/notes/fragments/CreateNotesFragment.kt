package com.anshu.notes.fragments

import android.os.Bundle
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.anshu.notes.Model.Notes
import com.anshu.notes.R
import com.anshu.notes.ViewModel.NotesViewModel
import com.anshu.notes.databinding.FragmentCreateNotesBinding
import java.util.*

class CreateNotesFragment : Fragment() {

    lateinit var binding: FragmentCreateNotesBinding
    val viewModel: NotesViewModel by viewModels()
    var priority: String = "1"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreateNotesBinding.inflate(layoutInflater, container, false)
        binding.btnSaveNotes.setOnClickListener {
            createNotes(it)
        }

        binding.pGreen.setImageResource(R.drawable.ic_done)

        binding.pGreen.setOnClickListener {
            priority = "1"
            binding.pGreen.setImageResource(R.drawable.ic_done)
            binding.pRed.setImageResource(0)
            binding.pYellow.setImageResource(0)
        }

        binding.pYellow.setOnClickListener {
            priority = "2"
            binding.pYellow.setImageResource(R.drawable.ic_done)
            binding.pRed.setImageResource(0)
            binding.pGreen.setImageResource(0)
        }

        binding.pRed.setOnClickListener {
            priority = "2"
            binding.pRed.setImageResource(R.drawable.ic_done)
            binding.pGreen.setImageResource(0)
            binding.pYellow.setImageResource(0)
        }

        return binding.root

    }

    private fun createNotes(it: View?) {

        val title = binding.edtTitle.text
        val subTitle = binding.edtSubTitle.text
        val notes = binding.edtNotes.text
        val d = Date()
        val notesDate: CharSequence = DateFormat.format("MMMM d, yyyy ", d.time)

        val data = Notes(
            id = null,
            title = title.toString(),
            subTitle = subTitle.toString(),
            notes = notes.toString(),
            date = notesDate.toString(),
            priority
        )
        viewModel.addNotes(data)
        Toast.makeText(requireContext(), "Notes added Succesfully", Toast.LENGTH_SHORT).show()

        Navigation.findNavController(it!!).navigate(R.id.action_createNotesFragment_to_homeFragment)
    }


}