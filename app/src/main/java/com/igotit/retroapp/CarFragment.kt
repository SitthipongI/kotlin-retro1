package com.igotit.retroapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.igotit.retroapp.adapter.PlanUserAdapter
import com.igotit.retroapp.adapter.PlanUserAdapter1
import com.igotit.retroapp.adapter.UserAdapter
import com.igotit.retroapp.api.apiuser
import com.igotit.retroapp.model.*
import kotlinx.android.synthetic.main.fragment_car.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


class CarFragment : Fragment(){
    var userList = ArrayList<UserResponse>()
    var lists = ArrayList<userx>()
    lateinit var toolbar : ActionBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootview = inflater.inflate(R.layout.fragment_car,container,false)
       // toolbar.title = "Car 123"
        return rootview
    }
    companion object {
        fun newInstance(): CarFragment = CarFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Car 123"
        getjsonobj()
    }
    fun getjsonobj(){

        var api = apiuser.create()
        var call = api.getjsonobj1()
        call.enqueue(object : Callback<UserResponse1>{
            override fun onFailure(call: Call<UserResponse1>, t: Throwable) {
                Log.d("TAG9","******** Fail: " + t.message)
            }

            override fun onResponse(call: Call<UserResponse1>, response: Response<UserResponse1>) {
                Log.d("TAG9","****** Response: " + response.body()!!.info)
                lists.addAll(response.body()!!.info)
                recycleview.apply {
                    layoutManager = LinearLayoutManager(activity)
                    adapter = PlanUserAdapter1(lists)
                }
            }
        })
    }
    fun getScalar(){
        var url = "http://192.168.1.3"
        var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(url)
           // .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var api : apiuser = retrofit.create(apiuser::class.java)
        val call = api.get2User()
        call.enqueue(object : Callback<Data>{
            override fun onFailure(call: Call<Data>, t: Throwable) {
                Log.d("TAG9","******* Fail!!! 2324 :" + t.message)
            }
            override fun onResponse(
                call: Call<Data>,
                response: Response<Data>
            ) {
                Log.d("TAG9","****** response: " + response.body())
            }
        })

    }

}