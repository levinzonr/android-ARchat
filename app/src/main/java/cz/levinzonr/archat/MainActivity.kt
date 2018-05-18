package cz.levinzonr.archat

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import cz.levinzonr.archat.ui.main.MainFragment
import cz.levinzonr.archat.ui.preferences.PreferencesFragment
import kotlinx.android.synthetic.main.main_activity.*
import cz.levinzonr.archat.R
class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.navigation_home -> {
                supportFragmentManager?.beginTransaction()
                        ?.replace(R.id.container, MainFragment.newInstance())?.commit()
                true
            }
            R.id.navigation_settings -> {
                supportFragmentManager?.beginTransaction()
                        ?.replace(R.id.container, PreferencesFragment())?.commit()
                true
            }
            else -> false
        }
    }
}
