package com.example.covid_19.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covid_19.R
import com.example.covid_19.adapter.ProvinceAdapter
import com.example.covid_19.api.RetrofitClient
import com.example.covid_19.databinding.ActivityProvinceBinding
import com.example.covid_19.model.ProvinceResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProvinceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProvinceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProvinceBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.rvProvince.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getProvinsi().enqueue(object :
            Callback<ArrayList<ProvinceResponse>> {
            override fun onResponse(call: Call<ArrayList<ProvinceResponse>>, response: Response<ArrayList<ProvinceResponse>>) {
                val list = response.body()
                val adapter = ProvinceAdapter(this@ProvinceActivity, list!!)
                binding.rvProvince.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<ProvinceResponse>>, t: Throwable) {
                Toast.makeText(this@ProvinceActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}