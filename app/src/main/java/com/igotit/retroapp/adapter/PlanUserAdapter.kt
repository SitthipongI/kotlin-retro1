package com.igotit.retroapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.igotit.retroapp.R
import com.igotit.retroapp.model.Model
import com.igotit.retroapp.model.model_user

class PlanUserAdapter (private val list: List<model_user>) : RecyclerView.Adapter<PlanUserAdapter.UserViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return UserViewHolder(inflater,parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user:model_user = list[position]
        holder.bind(user)
    }

    class UserViewHolder(inflater: LayoutInflater, parent:ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(
        R.layout.item_user,parent,false)){
        private var mId : TextView? = null
        private var mName : TextView? = null
        private var mEmail : TextView? = null
        init{
            mId = itemView.findViewById(R.id.txtId)
            mName = itemView.findViewById(R.id.txtName)
            mEmail = itemView.findViewById(R.id.txtEmail)
        }
        fun bind(user : model_user){
            mId?.text = user.id
            mName?.text = user.name
            mEmail?.text = user.email
        }
    }
}