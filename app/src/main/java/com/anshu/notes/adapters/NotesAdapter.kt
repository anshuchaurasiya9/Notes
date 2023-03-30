package com.anshu.notes.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anshu.notes.Model.Notes
import com.anshu.notes.R
import com.anshu.notes.databinding.ItemNotesBinding
import com.anshu.notes.fragments.HomeFragment

class NotesAdapter(val requireContext: Context, val notesList: List<Notes>) :
    RecyclerView.Adapter<NotesAdapter.notesViewHolder>() {

    class notesViewHolder(val binding: ItemNotesBinding) : RecyclerView.ViewHolder(binding.root) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notesViewHolder {
        return notesViewHolder(
            ItemNotesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = notesList.size

    override fun onBindViewHolder(holder: notesViewHolder, position: Int) {
        val data = notesList[position]
        holder.binding.notesTitle.text = data.title
        holder.binding.notesSubTitle.text = data.subTitle
        holder.binding.notesDate.text = data.date

        when (data.priority) {
            "1" -> {
                holder.binding.notePriority.setBackgroundResource(R.drawable.green_dot)
            }
            "2" -> {
                holder.binding.notePriority.setBackgroundResource(R.drawable.yellow_dot)

            }
            "3" -> {
                holder.binding.notePriority.setBackgroundResource(R.drawable.red_dot)
            }
        }

        holder.binding.root.setOnClickListener{
        }
    }
}