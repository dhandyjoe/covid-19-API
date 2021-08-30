package com.example.covid_19.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.covid_19.api.RetrofitClient
import com.example.covid_19.databinding.ActivityMainBinding
import com.example.covid_19.model.IndonesiaResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)

        showIndonesia()

        binding.btnProvince.setOnClickListener {
            val intent = Intent(this, ProvinceActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showIndonesia() {
        RetrofitClient.instance.getIndonesia()
            .enqueue(object : Callback<ArrayList<IndonesiaResponse>> {
                override fun onResponse(
                    call: Call<ArrayList<IndonesiaResponse>>,
                    response: Response<ArrayList<IndonesiaResponse>>
                ) {
                    val indonesia = response.body()?.get(0)
                    val positif = indonesia?.positif
                    val sembuh = indonesia?.sembuh
                    val meninggal = indonesia?.meninggal

                    binding.tvSembuh.text = sembuh
                    binding.tvMeninggal.text = meninggal
                    binding.tvPositif.text = positif
                }

                override fun onFailure(call: Call<ArrayList<IndonesiaResponse>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
    }
}