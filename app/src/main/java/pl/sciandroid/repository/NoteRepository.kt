package pl.sciandroid.repository

import androidx.lifecycle.LiveData
import pl.sciandroid.model.Note

interface NoteRepository
{
	val notes: LiveData<List<Note>>

	suspend fun insertNote(note: Note)

	suspend fun deleterNote(note: Note)
}
