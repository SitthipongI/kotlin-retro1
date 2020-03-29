package com.igotit.retroapp

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.igotit.retroapp.adapter.PlanUserAdapter
import com.igotit.retroapp.model.model_user
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    lateinit var MainContext  : AppCompatActivity

    private val lists = listOf(
        model_user("1","aaa","aaa@aaa.com"),
        model_user("1","aaa","aaa@aaa.com"),
        model_user("1","aaa","aaa@aaa.com"),
        model_user("1","aaa","aaa@aaa.com"),
        model_user("1","aaa","aaa@aaa.com"),
        model_user("1","aaa","aaa@aaa.com"),
        model_user("1","aaa","aaa@aaa.com"),
        model_user("1","aaa","aaa@aaa.com"),
        model_user("1","aaa","aaa@aaa.com"),
        model_user("1","aaa","aaa@aaa.com"),
        model_user("1","aaa","aaa@aaa.com"),
        model_user("1","aaa","aaa@aaa.com"),
        model_user("1","aaa","aaa@aaa.com"),
        model_user("1","aaa","aaa@aaa.com"),
        model_user("1","aaa","aaa@aaa.com"),
        model_user("1","aaa","aaa@aaa.com")
    )

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        this.MainContext = context as AppCompatActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance= true
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_home,container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycle_home.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = PlanUserAdapter(lists)
        }
    }

    companion object {
        fun newInstance(): HomeFragment = HomeFragment()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.menu_home,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.itemId
        if (id == R.id.action_menu1){
            Toast.makeText(activity, "Settings 1", Toast.LENGTH_SHORT).show()
        }
        if (id == R.id.action_menu2){
            Toast.makeText(activity, "Settings 2", Toast.LENGTH_SHORT).show()
        }
        if (id == R.id.action_menu3){

            Toast.makeText(activity, "Settings 3 ", Toast.LENGTH_SHORT).show()

            val fragment = CarFragment.newInstance()
            val fm = activity!!.supportFragmentManager
            val ft = fm.beginTransaction()
            ft.replace(R.id.container,fragment)
            ft.addToBackStack(null)
            ft.commit()
        }
        return super.onOptionsItemSelected(item)
    }
}