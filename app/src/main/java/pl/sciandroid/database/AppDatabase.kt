package pl.sciandroid.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pl.sciandroid.database.dao.NoteDao
import pl.sciandroid.database.entity.NoteEntity

@Database(entities = [ NoteEntity::class ], version = 1)
abstract class AppDatabase : RoomDatabase()
{
	companion object
	{
		fun create(context: Context) = Room
			.databaseBuilder(context, AppDatabase::class.java, "local")
			.build()
	}

	abstract fun noteDao(): NoteDao
}
