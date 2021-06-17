package org.d3if4203.assesment2.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.d3if4203.assesment2.databinding.FragmentSaranBinding
import org.d3if4203.assesment2.network.ApiService
import org.d3if4203.assesment2.network.MainModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HalamanSaran : Fragment() {
    private lateinit var binding: FragmentSaranBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentSaranBinding.inflate(layoutInflater, container, false)
        getDataApi()
        return binding.root
    }

    private fun getDataApi(){
        ApiService.endpoint.getData()
            .enqueue(object : Callback<MainModel>{

                override fun onResponse(call: Call<MainModel>, response: Response<MainModel>) {
                    showLoadingIndicator(false)
                    if (response.isSuccessful) {
                        val hasil = response.body()
                        showDataInternet(hasil!!)
                    }
                }

                override fun onFailure(call: Call<MainModel>, t: Throwable) {
                    printLog( t.toString() )
                    showLoadingIndicator(true)
                }
            })
    }

    private fun showLoadingIndicator(loadingIndicator: Boolean) {
        when(loadingIndicator) {
            true -> binding.progressBar.visibility = View.VISIBLE
            false -> binding.progressBar.visibility = View.GONE
        }
    }
    private fun printLog(message: String) {
        Log.d("MainActivity", message)
    }

    private fun showDataInternet(data: MainModel) {
        val results = data.result
      for (result in results){
          printLog("title : ${result.title}")
      }
    }
}