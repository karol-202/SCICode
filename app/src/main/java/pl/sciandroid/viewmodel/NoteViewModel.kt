package pl.sciandroid.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pl.sciandroid.model.Note
import pl.sciandroid.repository.NoteRepository

class NoteViewModel(private val noteRepository: NoteRepository) : ViewModel()
{
	val notes = noteRepository.notes

	fun addNote(content: String) = viewModelScope.launch {
		noteRepository.insertNote(Note(content = content))
	}

	fun removeNote(note: Note) = viewModelScope.launch {
		noteRepository.deleterNote(note)
	}
}
