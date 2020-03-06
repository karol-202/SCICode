package pl.sciandroid.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel
import pl.sciandroid.R
import pl.sciandroid.adapter.NoteAdapter
import pl.sciandroid.database.dao.NoteDao
import pl.sciandroid.model.Note
import pl.sciandroid.viewmodel.NoteViewModel

class MainActivity : AppCompatActivity()
{
	private val noteViewModel by viewModel<NoteViewModel>()

	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val noteAdapter = NoteAdapter(this)
		noteAdapter.setOnNoteDeleteListener {
			noteViewModel.removeNote(it)
		}

		noteViewModel.notes.observe(this, Observer {
			noteAdapter.notes = it
		})

		recyclerNotes.layoutManager = LinearLayoutManager(this)
		recyclerNotes.adapter = noteAdapter

		buttonNoteAdd.setOnClickListener {
			val content = editTextNote.text.toString()
			noteViewModel.addNote(content)

			editTextNote.text.clear()
		}
	}
}
