package com.example.notes.note_list

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.domain.entity.entity.MyDataNote
import com.example.notes.databinding.NotesItemBinding
import com.squareup.picasso.Picasso

class NotesAdapter : ListAdapter<MyDataNote, NotesAdapter.NotesViewHolder>(NoteDiffCheck()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = NotesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val item = getItem(position)
        holder.bindData(item)
    }


    // As a user I want to send my complainments to BANK


    inner class NotesViewHolder(private val notesItemBinding: NotesItemBinding) : ViewHolder(notesItemBinding.root) {
        fun bindData(note: MyDataNote) {
            notesItemBinding.title.text = note.title
            notesItemBinding.subTitle.text = note.subtitle
//            notesItemBinding.noteIcon.load("") {
////                listener(
////                    onError = { _, _ ->
////                        Toast.makeText(notesItemBinding.root.context, "Fail", Toast.LENGTH_LONG).show()
////                    },
////                    onSuccess = { _, _ ->
////                        Toast.makeText(notesItemBinding.root.context, "Success", Toast.LENGTH_LONG).show()
////                    }
////                )
//            }
        }
    }

    private class NoteDiffCheck : DiffUtil.ItemCallback<MyDataNote>() {
        override fun areItemsTheSame(oldItem: MyDataNote, newItem: MyDataNote): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: MyDataNote, newItem: MyDataNote): Boolean {
            return oldItem.title == newItem.title && oldItem.subtitle == newItem.subtitle
        }
    }

}