package pl.sciandroid.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import pl.sciandroid.database.entity.NoteEntity

@Dao
interface NoteDao
{
	@Insert
	suspend fun insertNote(note: NoteEntity)

	@Delete
	suspend fun deleteNote(note: NoteEntity)

	@Query("SELECT * FROM NoteEntity")
	fun getNotes(): LiveData<List<NoteEntity>>
}
