package com.example.retrofitfetchlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.retrofitfetchlivedata.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        getdata()

        binding.GetData.setOnClickListener {
            getdata()
        }
    }

    private fun getdata() {
        RetrofitInstance.apiinterface.getData().enqueue(object : Callback<ResponseDataclass?> {
            override fun onResponse(
                call: Call<ResponseDataclass?>,
                response: Response<ResponseDataclass?>
            ) {
                binding.brand.setText(response.body()?.title)
                binding.category.setText(response.body()?.category)
                binding.desc.setText(response.body()?.description)

            }

            override fun onFailure(call: Call<ResponseDataclass?>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.localizedMessage }",Toast.LENGTH_SHORT).show()
            }
        })
    }
}