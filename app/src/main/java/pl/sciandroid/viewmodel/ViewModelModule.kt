package pl.sciandroid.viewmodel

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun viewModelModule() = module {
	viewModel { NoteViewModel(get()) }
}
