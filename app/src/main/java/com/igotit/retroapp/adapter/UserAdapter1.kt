package com.igotit.retroapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.igotit.retroapp.InfoFragment
import com.igotit.retroapp.R
import com.igotit.retroapp.model.Model
import com.igotit.retroapp.model.model_user
import com.igotit.retroapp.model.userx

class PlanUserAdapter1 (private val list: List<userx>) : RecyclerView.Adapter<PlanUserAdapter1.UserViewHolder1>(){
var context : Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder1 {
        val inflater = LayoutInflater.from(parent.context)
        context = parent.context

        return UserViewHolder1(inflater,parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: UserViewHolder1, position: Int) {
        val user : userx = list[position]
        holder.bind(user)
        holder.itemView.setOnClickListener {
            Toast.makeText(context,user.name,Toast.LENGTH_SHORT).show()
           // var fragment = InfoFragment()

        }
    }

    class UserViewHolder1(inflater: LayoutInflater, parent:ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(
        R.layout.item_user,parent,false)){
        private var mId : TextView? = null
        private var mName : TextView? = null
        private var mEmail : TextView? = null
        init{
            mId = itemView.findViewById(R.id.txtId)
            mName = itemView.findViewById(R.id.txtName)
            mEmail = itemView.findViewById(R.id.txtEmail)
        }
        fun bind(user : userx){
            mId?.text = user.id
            mName?.text = user.name
            mEmail?.text = user.email
        }
    }
}