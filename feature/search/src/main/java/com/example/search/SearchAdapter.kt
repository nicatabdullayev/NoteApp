package com.example.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.abbtech.domain.entities.response_models.NoteResponseModel
import com.example.search.databinding.NotesItemBinding

class SearchAdapter : ListAdapter<NoteResponseModel, SearchAdapter.NotesViewHolder>(NoteDiffCheck()) {

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
        fun bindData(note: NoteResponseModel) {
            notesItemBinding.title.text = note.title
            notesItemBinding.subTitle.text = note.subTitle
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

    private class NoteDiffCheck : DiffUtil.ItemCallback<NoteResponseModel>() {
        override fun areItemsTheSame(oldItem: NoteResponseModel, newItem: NoteResponseModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: NoteResponseModel, newItem: NoteResponseModel): Boolean {
            return oldItem.title == newItem.title && oldItem.subTitle == newItem.subTitle
        }
    }

}