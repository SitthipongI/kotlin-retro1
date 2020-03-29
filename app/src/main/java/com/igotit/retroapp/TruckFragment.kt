package com.igotit.retroapp

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.fragment_truck.*

class TruckFragment : Fragment() {

    val myViews : Array<Int> = arrayOf(R.layout.layout_one,
                                        R.layout.layout_two,
                                        R.layout.layout_three)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_truck, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val tabLayout = view.findViewById(R.id.tab_layout)

        tab_layout.setupWithViewPager(myViewPager)
        configureTabLayout()
        myViewPager.adapter = MyAdapter(myViews,activity!!.applicationContext)
    }
    private fun configureTabLayout(){
        tab_layout.addTab(tab_layout.newTab().setText("Test"))
        //tab_layout.addTab(tab_layout.newTab().setIcon())
    }

    companion object {
        fun newInstance(): TruckFragment = TruckFragment()
    }
}
class MyAdapter(private val theViews:Array<Int>,private val theContext:Context) : PagerAdapter(){
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getCount(): Int {
        return theViews.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val thisView = theViews[position]
        val inflater = LayoutInflater.from(theContext)
        val layout = inflater.inflate(thisView,container,false) as ViewGroup
        container.addView(layout)
        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title: String? = null
        if (position == 0){
            title = "First"
        }else if (position == 1){
            title = "Second"
        }else {
            title = "Third"
        }
        return "TAB " + title
        // return super.getPageTitle(position)
    }
}