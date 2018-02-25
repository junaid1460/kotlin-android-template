package com.crook.twitterbot

import android.content.Intent
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import java.util.logging.LogManager
import java.util.logging.Logger

class FirstRunActivity : AppCompatActivity() {

    /**
     * The [android.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * [FragmentPagerAdapter] derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [android.support.v4.app.FragmentStatePagerAdapter].
     */
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    /**
     * The [ViewPager] that will host the section contents.
     */
    private var mViewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_run)
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container) as ViewPager
        mViewPager!!.adapter = mSectionsPagerAdapter

        mViewPager!!.setOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(p0: Int) {
              //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
               // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onPageSelected(p0: Int) {
                var mvp = findViewById(R.id.container) as ViewPager
                var fb = findViewById(R.id.fab) as FloatingActionButton
                android.util.Log.i("page",p0.toString() + " , " + mvp.adapter.count)
                if(p0 == (mvp.adapter.count -1)){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        fb.setImageDrawable(resources.getDrawable(R.drawable.ic_fab_done,applicationContext.theme))
                    }else{
                        fb.setImageDrawable(resources.getDrawable(R.drawable.ic_fab_done))
                    }
                }else{
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        fb.setImageDrawable(resources.getDrawable(R.drawable.ic_fab_next,applicationContext.theme))
                    }else{
                        fb.setImageDrawable(resources.getDrawable(R.drawable.ic_fab_next))
                    }
                }
            }
        })
        val currentPage = 0;
        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener(View.OnClickListener {
            var mvp = findViewById(R.id.container) as ViewPager
            if(mvp.currentItem < mvp.childCount)
                mvp.setCurrentItem(mvp.currentItem + 1, true)
            else{

                    var intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()


            }
        })

    }


    /**
     * A placeholder fragment containing a simple view.
     */
    class PlaceholderFragment : Fragment() {

        override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            val rootView = inflater!!.inflate(R.layout.fragment_first_run, container, false)

            return rootView
        }

        fun getCurrent():Int{
            return arguments.getInt(ARG_SECTION_NUMBER)
        }
        companion object {
            /**
             * The fragment argument representing the section number for this
             * fragment.
             */
            private val ARG_SECTION_NUMBER = "section_number"

            /**
             * Returns a new instance of this fragment for the given section
             * number.
             */
            fun newInstance(sectionNumber: Int): PlaceholderFragment {
                val fragment = PlaceholderFragment()
                val args = Bundle()
                args.putInt(ARG_SECTION_NUMBER, sectionNumber)
                fragment.arguments = args
                return fragment
            }
        }
    }

    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1)
        }



        override fun getCount(): Int {
            // Show 3 total pages.
            return 3
        }
    }
}
