package org.d3if4203.assesment2.ui
import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if4203.assesment2.R
import org.d3if4203.assesment2.databinding.FragmentCatatanBinding
import org.d3if4203.assesment2.db.Catatan
import org.d3if4203.assesment2.db.CatatanDB

class HalamanCatatan : Fragment() {
    private var catatanId = 0
    private lateinit var binding: FragmentCatatanBinding
    lateinit var catatanAdapter: CatatanAdapter
    private val db by lazy { this.context?.let { CatatanDB(it) } }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentCatatanBinding.inflate(layoutInflater, container, false)
        nextHalaman()
        setupRecyclerView()
        return binding.root
    }

    private fun loadData(){
        CoroutineScope(Dispatchers.IO).launch {
            db?.catatanDao()?.getCatatans()?.let { catatanAdapter.setData(it) }
            withContext(Dispatchers.Main) {
                catatanAdapter.notifyDataSetChanged()
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        catatanAdapter = CatatanAdapter(arrayListOf(), object : CatatanAdapter.OnAdapterListener {
            override fun onClick(catatan: Catatan) {
            }

            override fun onUpdate(catatan: Catatan) {
            }

            override fun onDelete(catatan: Catatan) {
                deleteAlert(catatan)
            }

        })
        loadData()
        CoroutineScope(Dispatchers.IO).launch {
            val catatan = db!!.catatanDao().getCatatans()
            withContext(Dispatchers.Main){
                catatanAdapter.setData(catatan)
            }
            Log.d("MainActivity", "dbRespons : $catatan")

        }
        super.onCreate(savedInstanceState)

    }
    private fun deleteAlert(catatan: Catatan){
        val dialog = AlertDialog.Builder(this.context)
        dialog.apply {
            setTitle("Konfirmasi Hapus")
            setMessage("Apakah anda benar ingin menghapus ${catatan.judul}?")
            setNegativeButton("Batal") { dialogInterface, i ->
                dialogInterface.dismiss()
            }
            setPositiveButton("Hapus") { dialogInterface, i ->
                CoroutineScope(Dispatchers.IO).launch {
                    db?.catatanDao()?.deleteCatatan(catatan)
                    dialogInterface.dismiss()
                    loadData()
                }
            }
        }
        dialog.show()
    }

    fun nextHalaman (){
        binding.btnBuat.setOnClickListener {view: View ->
            view.findNavController().navigate(R.id.action_halamanCatatan_to_halamanEdit)
        }
    }
    private fun setupRecyclerView () {
        catatanAdapter = CatatanAdapter(arrayListOf(),  object : CatatanAdapter.OnAdapterListener {
            override fun onClick(catatan: Catatan) {
            }

            override fun onUpdate(catatan: Catatan) {
                val catatan1 = catatan.id
                view?.findNavController()?.navigate(HalamanCatatanDirections.actionHalamanCatatanToHalamanUpdate(catatan1, catatan.judul, catatan.catatan))
            }

            override fun onDelete(catatan: Catatan) {
              deleteAlert(catatan)
            }

        })
        binding.listCatatan.apply {
            layoutManager = LinearLayoutManager(this.context)
            adapter = catatanAdapter
            }
        }


}