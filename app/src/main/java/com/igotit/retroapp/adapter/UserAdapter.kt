package com.igotit.retroapp.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.igotit.retroapp.R
import com.igotit.retroapp.model.userx
import kotlinx.android.synthetic.main.item_user.view.*
import java.lang.reflect.Member

class UserAdapter (val items: ArrayList<userx>): RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtId?.text = items.get(position).id
        holder.txtName?.text = items[position].name
        //holder.tvName?.text = items.get(position).name
        holder.txtEmail?.text = items.get(position).email
        Log.d("TAG9","****** onBind: " + items.get(position).name)
    }
    class ViewHolder(row: View) : RecyclerView.ViewHolder(row){
        var txtId = row.txtId
        var txtName = row.txtName
        var txtEmail = row.txtEmail

            init{
                this.txtId = row.findViewById(R.id.txtId)
                this.txtName = row.findViewById(R.id.txtName)
                this.txtEmail = row.findViewById(R.id.txtEmail)
            }

    }
}