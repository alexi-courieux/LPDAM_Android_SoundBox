package fr.iutnice.courieux.soundbox

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import fr.iutnice.courieux.soundbox.fragment.*
import fr.iutnice.courieux.soundbox.sound.Sound
import fr.iutnice.courieux.soundbox.sound.SoundCategory
import fr.iutnice.courieux.soundbox.sound.SoundList
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ClassCastException

class MainActivity() : AppCompatActivity() {

    init {
        MainActivity.instance = this
    }

    companion object {
        var instance:MainActivity? = null
    }

    var soundList = SoundList()

    /** Construct a new ActionBarDrawerToggle.**/
    val drawerToogle by lazy{
        ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setSupportActionBar(toolbar)

        navigationView.setNavigationItemSelectedListener {
            selectDrawItem(it)
            true
        }


        drawerLayout.addDrawerListener(drawerToogle)

        replaceFragment(FragmentHome.newInstance())

        //Fill the sound list
        soundList.add(Sound("cow", SoundCategory.ANIMAL, R.raw.animal_cow))
        soundList.add(Sound("cat", SoundCategory.ANIMAL, R.raw.animal_cat))
        soundList.add(Sound("dog", SoundCategory.ANIMAL, R.raw.animal_dog))
        soundList.add(Sound("epic", SoundCategory.JINGLE, R.raw.jingle_epic))
        soundList.add(Sound("guitar", SoundCategory.JINGLE, R.raw.jingle_guitar))
        soundList.add(Sound("strange", SoundCategory.JINGLE, R.raw.jingle_strange))
        soundList.add(Sound("success", SoundCategory.JINGLE, R.raw.jingle_success))
    }

    /** method to synchronize after the DrawerLayout's instance state has been restored **/
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        /** Synchronize the state of the drawer indicator/affordance with the linked DrawerLayout. **/
        drawerToogle.syncState()
    }

    /** This method is passed a Configuration object that specifies the new device configuration **/
    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        drawerToogle.onConfigurationChanged(newConfig)
    }


    private fun selectDrawItem(item: MenuItem) {
        var fragment: Fragment? = null
        val fragmentClass = when (item.itemId) {
            R.id.fragmentCategoryAnimalItem -> FragmentCategoryAnimal::class.java
            R.id.fragmentCategoryAmbianceItem -> FragmentCategoryAmbiance::class.java
            R.id.fragmentCategoryJingleItem -> FragmentCategoryJingle::class.java
            R.id.fragmentGraphicalElementItem -> FragmentGraphicalElement::class.java
            R.id.fragmentCreatedBy -> FragmentCreatedBy::class.java
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
        return if(drawerToogle.onOptionsItemSelected(item)) true else super.onOptionsItemSelected(item)
    }

    /**Replace the content fragment by another one**/
    fun replaceFragment(fragment: Fragment?) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment!!)
        fragmentTransaction.commit()
    }
}
