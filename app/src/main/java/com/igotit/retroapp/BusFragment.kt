package com.igotit.retroapp

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.igotit.retroapp.dbhelper.DBOpenHelper
import com.igotit.retroapp.dbhelper.Name
import kotlinx.android.synthetic.main.fragment_bus.*

class BusFragment : Fragment() {

//val context: Context = activity

  override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // recyclerPlan = PlaneFragment(list,this)
        val rootView = inflater.inflate(R.layout.fragment_bus,container,false)
        return rootView
    }
    companion object {
        fun newInstance(): BusFragment = BusFragment()

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val context:Context = activity!!.applicationContext
        val dbHandle = DBOpenHelper(context,null)

        btnAddToDb.setOnClickListener {
            val user = Name(etName.text.toString())
            dbHandle.addName(user)
            Toast.makeText(context,etName.text.toString() + " Added",Toast.LENGTH_SHORT).show()
            etName.setText("")
            readDB()
        }
        btnShowDB.setOnClickListener {
            readDB()
        }
    }
    private fun readDB(){
        val context:Context = activity!!.applicationContext
        val dbHandle = DBOpenHelper(context,null)
        tvDisplayName.text = ""
        val cursor = dbHandle.getAllName()
        cursor!!.moveToFirst()
        tvDisplayName.append((cursor.getString(cursor.getColumnIndex(DBOpenHelper.COLUMN_NAME))))
        while(cursor.moveToNext()){
            tvDisplayName.append("\n")
            tvDisplayName.append((cursor.getString(cursor.getColumnIndex(DBOpenHelper.COLUMN_NAME))))
        }
        cursor.close()
    }
}
