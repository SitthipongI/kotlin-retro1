package com.igotit.retroapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import com.igotit.retroapp.adapter.RecyclePlan
import com.igotit.retroapp.adapter.UserAdapter
import com.igotit.retroapp.api.ApiInterface
import com.igotit.retroapp.model.*
import kotlinx.android.synthetic.main.fragment_plane.*
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PlaneFragment : Fragment(){

    private var list: ArrayList<userx> = ArrayList<userx>()
    private lateinit var recyclerPlan : RecyclerView
    lateinit var adapter : UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       // recyclerPlan = PlaneFragment(list,this)
        val rootView = inflater.inflate(R.layout.fragment_plane,container,false)
        recyclerPlan = rootView.findViewById(R.id.recycleview_plan) as RecyclerView
        recyclerPlan.layoutManager = LinearLayoutManager(activity)


        return rootView
    }
    companion object {
        fun newInstance(): PlaneFragment = PlaneFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //getData()
    }
    fun getData(){
        val gson = GsonBuilder()
            .setLenient()
            .create()

        var retrofit = Retrofit.Builder()
            .baseUrl("http://10.10.21.2/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        var apiService = retrofit.create(ApiInterface::class.java)
        val call : Call<UserResponse> = apiService.getData()
        call.enqueue(object : Callback<UserResponse>{
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.d("TAG9","**** Fail: " + t.message)
            }

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {

               // var data : UserResponse? = response.body()
                //var tmp1 : List<model_user> = response.body()!!.info
                //Log.d("TAG9","tmp1 :" + tmp1)
                //list.addAll(data!!.info)
                //Log.d("TAG9","**** response: " + response.body()+"\n ***** List:" + list.size)

              //  recycleview_plan.layoutManager = LinearLayoutManager(activity)
               // recycleview_plan.adapter = UserAdapter(list)
                //recyclerPlan.adapter = UserAdapter(list)
                /*
                recycleview_plan.apply {
                    layoutManager = LinearLayoutManager(activity)
                    adapter = UserAdapter(list)
                   // Log.d("TAG9","**** Lis apply : " + list.toString())
                }*/
            }
        })
    }
}