package pl.sciandroid

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import pl.sciandroid.database.databaseModule
import pl.sciandroid.repository.repositoryModule
import pl.sciandroid.viewmodel.viewModelModule

class SCICodeApplication : Application()
{
	override fun onCreate()
	{
		super.onCreate()
		startKoin {
			androidContext(this@SCICodeApplication)
			modules(databaseModule() + repositoryModule() + viewModelModule())
		}
	}
}
