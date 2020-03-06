package pl.sciandroid.database

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

fun databaseModule() = module {
	single { AppDatabase.create(androidContext()) }
	single { get<AppDatabase>().noteDao() }
}
