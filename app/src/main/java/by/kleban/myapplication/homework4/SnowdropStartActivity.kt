package by.kleban.myapplication.homework4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import by.kleban.myapplication.R


class SnowdropStartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snowdrop_start)

        val viewModel = ViewModelProvider(this).get(SnowdropStartViewModel::class.java)
        viewModel.screenLiveData.observe(this) { screen ->
            val fragment = createFragment(screen)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .apply { if (screen != Screen.START) addToBackStack(null) }
                .commit()
        }
    }

    fun createFragment(screen: Screen): Fragment {
        return when (screen) {
            Screen.START -> SnowdropStartFragment()
            Screen.ADD -> SnowdropAddFragment()
            Screen.SHOW -> SnowdropShowFragment()
        }
    }
}