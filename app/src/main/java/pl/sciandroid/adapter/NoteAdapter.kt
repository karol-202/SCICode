package pl.sciandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_note.*
import pl.sciandroid.R
import pl.sciandroid.model.Note

class NoteAdapter(private val context: Context) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>()
{
	inner class NoteViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer
	{
		fun bind(note: Note)
		{
			textNoteName.text = note.content
			buttonNoteDelete.setOnClickListener { onNoteDeleteListener?.invoke(note) }
		}
	}

	private var onNoteDeleteListener: ((Note) -> Unit)? = null
	var notes = emptyList<Note>()
		set(value)
		{
			field = value
			notifyDataSetChanged()
		}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder
	{
		val view = LayoutInflater.from(context).inflate(R.layout.item_note, parent, false)
		return NoteViewHolder(view)
	}

	override fun onBindViewHolder(holder: NoteViewHolder, position: Int) = holder.bind(notes[position])

	override fun getItemCount() = notes.size

	fun setOnNoteDeleteListener(listener: (Note) -> Unit)
	{
		onNoteDeleteListener = listener
	}
}
