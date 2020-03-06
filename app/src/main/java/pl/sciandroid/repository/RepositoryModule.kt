package pl.sciandroid.repository

import org.koin.dsl.module

fun repositoryModule() = module {
	single<NoteRepository> { NoteRepositoryImpl(get()) }
}
