package pl.sciandroid.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import pl.sciandroid.model.Note

@Entity
data class NoteEntity(@PrimaryKey(autoGenerate = true) val id: Long,
					  val content: String)
{
	companion object
	{
		fun fromModel(note: Note) = NoteEntity(note.id ?: 0, note.content)
	}

	fun toModel() = Note(id, content)
}
