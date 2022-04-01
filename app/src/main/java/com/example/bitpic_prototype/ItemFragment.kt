package com.example.bitpic_prototype

import android.app.Notification
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar;
import com.example.bitpic_prototype.placeholder.PlaceholderContent
import com.google.android.material.navigation.NavigationView

import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.Navigation
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.NonCancellable.start


/**
 * A fragment representing a list of Items.
 */
class ItemFragment : Fragment(), NavigationView.OnNavigationItemSelectedListener {
    private var mViewPager: ViewPager? = null
    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)
        val toolbar: Toolbar = view.findViewById(R.id.toolbar)
        (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)
        var profilebtn: ImageView = view.findViewById(R.id.profile)
        var bottomNav: BottomNavigationView = view.findViewById(R.id.bottomNavigationView)
        var drawer: DrawerLayout= view.findViewById(R.id.drawer_layout)
        var nav:NavigationView = view.findViewById(R.id.nav_view)
        nav.setNavigationItemSelectedListener(this)
        toolbar.setTitle("")


        profilebtn.setOnClickListener{
            parentFragmentManager.beginTransaction().replace(R.id.fragment_container,UserProfileFragment()).commit()
        }

        bottomNav.setOnItemSelectedListener{ item ->
            when (item.itemId) {
                R.id.explore -> {
                    parentFragmentManager.beginTransaction().replace(R.id.fragment_container,ExploreFragment()).commit()
                    true
                }
                R.id.home -> {
                    parentFragmentManager.beginTransaction().replace(R.id.fragment_container,ListFragment()).commit()
                }
                R.id.add -> {
                    parentFragmentManager.beginTransaction().replace(R.id.fragment_container,CreateNew()).commit()
                }
            }
            true
        }


        var toggle = ActionBarDrawerToggle(activity as AppCompatActivity?, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)

        toggle.syncState()

        if(savedInstanceState == null){
            parentFragmentManager.beginTransaction().replace(R.id.fragment_container, ListFragment()).commit()
        }
        return view
    }


    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ItemFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.nav_com1 ->{
                parentFragmentManager.beginTransaction().replace(R.id.fragment_container, community()).commit()
                true
            }
            R.id.nav_com2 ->{
                parentFragmentManager.beginTransaction().replace(R.id.fragment_container, community()).commit()
                true
            }
            R.id.nav_com3 ->{
                parentFragmentManager.beginTransaction().replace(R.id.fragment_container, community()).commit()
                true
            }
            R.id.nav_com4 ->{
                parentFragmentManager.beginTransaction().replace(R.id.fragment_container, community()).commit()
                true
            }
            R.id.nav_com5 ->{
                parentFragmentManager.beginTransaction().replace(R.id.fragment_container, community()).commit()
                true
            }
            R.id.nav_person1 ->{
                parentFragmentManager.beginTransaction().replace(R.id.fragment_container, UserProfileFragment()).commit()
                true
            }
            R.id.nav_person2 ->{
                parentFragmentManager.beginTransaction().replace(R.id.fragment_container, UserProfileFragment()).commit()
                true
            }
            R.id.nav_person3 ->{
                parentFragmentManager.beginTransaction().replace(R.id.fragment_container, UserProfileFragment()).commit()
                true
            }
            R.id.nav_person4 ->{
                parentFragmentManager.beginTransaction().replace(R.id.fragment_container, UserProfileFragment()).commit()
                true
            }
            R.id.community_person_search ->{
                parentFragmentManager.beginTransaction().replace(R.id.fragment_container,UserProfileFragment()).commit()
            }
            else -> {
                false
            }
        }
        println("closed")
        var drawer : DrawerLayout = view!!.findViewById(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}