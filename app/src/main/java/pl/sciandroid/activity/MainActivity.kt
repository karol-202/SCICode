package pl.sciandroid.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pl.sciandroid.R

class MainActivity : AppCompatActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}
}
