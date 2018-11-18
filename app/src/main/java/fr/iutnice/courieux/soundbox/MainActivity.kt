package fr.iutnice.courieux.soundbox

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import fr.iutnice.courieux.soundbox.fragment.FragmentCategoryAmbiance
import fr.iutnice.courieux.soundbox.fragment.FragmentCategoryAnimal
import fr.iutnice.courieux.soundbox.fragment.FragmentCategoryJingle
import fr.iutnice.courieux.soundbox.fragment.FragmentHome
import fr.iutnice.courieux.soundbox.sound.SoundList
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ClassCastException

class MainActivity : AppCompatActivity() {

    //ToolBar
    val drawerToogle by lazy{
        ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ToolBar
        setSupportActionBar(toolbar)

        navigationView.setNavigationItemSelectedListener {
            selectDrawItem(it)
            true
        }

        //ToolBar
        drawerLayout.addDrawerListener(drawerToogle)

        replaceFragment(FragmentHome.newInstance())

        var soundList = SoundList()
        //soundList.add(Sound("cow",SoundCategory.ANIMAL, ))
    }

    //ToolBar
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        drawerToogle.syncState()
    }

    //ToolBar
    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        drawerToogle.onConfigurationChanged(newConfig)
    }


   /* override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.fragment_menu, menu)
        return true
    }*/

    private fun selectDrawItem(item: MenuItem) {
        var fragment: Fragment? = null
        val fragmentClass = when (item.itemId) {
            R.id.fragmentCategoryAnimalItem -> FragmentCategoryAnimal::class.java
            R.id.fragmentCategoryAmbianceItem -> FragmentCategoryAmbiance::class.java
            R.id.fragmentCategoryJingleItem -> FragmentCategoryJingle::class.java
            else -> FragmentHome::class.java
        }
        try {
            fragment = fragmentClass.newInstance() as Fragment
        } catch (e: ClassCastException) {
            e.printStackTrace()
        }
        replaceFragment(fragment)
        drawerLayout.closeDrawer(GravityCompat.START)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        /*var fragment : Fragment = when (item?.itemId) {
            R.id.fragmentHomeItem -> FragmentHome.newInstance()
            R.id.fragmentCategoryAnimalItem -> FragmentCategoryAnimal.newInstance()
            R.id.fragmentCategoryAmbianceItem -> FragmentCategoryAmbiance.newInstance()
            R.id.fragmentCategoryJingleItem -> FragmentCategoryJingle.newInstance()
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
        replaceFragment(fragment)
        return true*/
        return if(drawerToogle.onOptionsItemSelected(item)) true else super.onOptionsItemSelected(item)
    }

    fun replaceFragment(fragment: Fragment?) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment!!)
        fragmentTransaction.commit()
    }
}
