package ca.zitao.ln.ui

import android.app.Activity
import ca.zitao.ln.ui.NavigationDrawerFragment
import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.view.Menu
import android.view.MenuItem
import android.app.ActionBar
import ca.zitao.ln.R

public class MainActivity() : Activity(), NavigationDrawerFragment.NavigationDrawerCallbacks {

  /**
   * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
   */
  private var mNavigationDrawerFragment: NavigationDrawerFragment? = null

  /**
   * Used to store the last screen title. For use in {@link #restoreActionBar()}.
   */
  private var mTitle: CharSequence = ""

  override fun onCreate(savedInstanceState: Bundle?) {
    super<Activity>.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    mNavigationDrawerFragment = getFragmentManager().findFragmentById(R.id.navigation_drawer) as NavigationDrawerFragment
    mTitle = getTitle() ?: ""

    // Set up the drawer.
    mNavigationDrawerFragment?.setUp(R.id.navigation_drawer, findViewById(R.id.drawer_layout) as DrawerLayout)
  }

  override fun onNavigationDrawerItemSelected(position: Int) {
    // update the main content by replacing fragments
    val fragmentManager = getFragmentManager()
    fragmentManager!!.beginTransaction()!!.replace(R.id.container, SavedChaptersFragment())!!.commit()
  }

  public fun onSectionAttached(number: Int) {
    when (number) {
      1 -> {
        mTitle = getString(R.string.title_section1)!!
      }
      2 -> {
        mTitle = getString(R.string.title_section2)!!
      }
      3 -> {
        mTitle = getString(R.string.title_section3)!!
      }
      else -> {
      }
    }
  }

  public fun restoreActionBar() {
    val actionBar = getActionBar()
    actionBar?.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD)
    actionBar?.setDisplayShowTitleEnabled(true)
    actionBar?.setTitle(mTitle)
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    if (!(mNavigationDrawerFragment?.isDrawerOpen() ?: false)) {
      // Only show items in the action bar relevant to this screen
      // if the drawer is not showing. Otherwise, let the drawer
      // decide what to show in the action bar.
      getMenuInflater()!!.inflate(R.menu.main, menu)
      restoreActionBar()
      return true
    }
    return super<Activity>.onCreateOptionsMenu(menu)
  }

  override fun onOptionsItemSelected(item: MenuItem?): Boolean {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    val id = item?.getItemId()
    if (id == R.id.action_settings) {
      return true
    }
    return super<Activity>.onOptionsItemSelected(item)
  }
}