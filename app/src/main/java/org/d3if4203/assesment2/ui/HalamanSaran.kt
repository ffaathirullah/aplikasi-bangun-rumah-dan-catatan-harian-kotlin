package org.d3if4203.assesment2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import org.d3if4203.assesment2.databinding.FragmentSaranBinding
import org.d3if4203.assesment2.network.ApiService
import org.d3if4203.assesment2.network.MainModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HalamanSaran : Fragment() {
    private lateinit var binding: FragmentSaranBinding
    private lateinit   var saranAdapter: SaranAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentSaranBinding.inflate(layoutInflater, container, false)
        getDataApi()
        setupRecyclerView()
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        setupRecyclerView()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDataApi()
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
                    showLoadingIndicator(false)
                    Toast.makeText(context, "Internet Bermasalah Coba lagi", Toast.LENGTH_SHORT).show()
                }
            })
    }

    private fun showLoadingIndicator(loadingIndicator: Boolean) {
        when(loadingIndicator) {
            true -> binding.progressBar.visibility = View.VISIBLE
            false -> binding.progressBar.visibility = View.GONE
        }
    }

    private fun showDataInternet(data: MainModel) {
        val results = data.result
        saranAdapter.setData(results)
    }

    private fun setupRecyclerView(){
      saranAdapter = SaranAdapter(arrayListOf(), object : SaranAdapter.OnAdapterListener{
          override fun onClick(hasil: MainModel.Result) {
              view?.findNavController()?.navigate(HalamanSaranDirections.actionSaranFragmentToHalamanDetailSaran(hasil.title, hasil.image, hasil.desc))
          }

      })
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = saranAdapter
        }
    }
}