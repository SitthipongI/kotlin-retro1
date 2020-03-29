package com.igotit.retroapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.igotit.retroapp.R
import com.igotit.retroapp.model.Model
import com.igotit.retroapp.model.model_user
import com.igotit.retroapp.model.userx
import kotlinx.android.synthetic.main.item_user.view.*
import java.util.zip.Inflater

class RecyclePlan (val items: ArrayList<userx>) : RecyclerView.Adapter<RecyclePlan.viewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder?.tvId?.text = items.get(position).id
        holder?.tvName?.text = items.get(position).name
        holder?.tvEmail?.text = items.get(position).email
    }

    class viewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvId = view?.txtId
        val tvName = view?.txtName
        val tvEmail = view?.txtEmail

    }
}