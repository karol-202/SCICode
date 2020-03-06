package pl.sciandroid.repository

import androidx.lifecycle.map
import pl.sciandroid.database.dao.NoteDao
import pl.sciandroid.database.entity.NoteEntity
import pl.sciandroid.model.Note

class NoteRepositoryImpl(private val noteDao: NoteDao) : NoteRepository
{
	override val notes get() = noteDao.getNotes().map { it.map(NoteEntity::toModel) }

	override suspend fun insertNote(note: Note) = noteDao.insertNote(NoteEntity.fromModel(note))

	override suspend fun deleterNote(note: Note) = noteDao.deleteNote(NoteEntity.fromModel(note))
}
