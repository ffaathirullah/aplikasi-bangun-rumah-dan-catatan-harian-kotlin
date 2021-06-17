package org.d3if4203.assesment2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if4203.assesment2.R
import org.d3if4203.assesment2.databinding.FragmentUpdateBinding
import org.d3if4203.assesment2.db.Catatan
import org.d3if4203.assesment2.db.CatatanDB

class HalamanUpdate : Fragment() {
    private val args: HalamanUpdateArgs by navArgs()
    private val db by lazy { this.context?.let { CatatanDB(it) } }
    private lateinit var binding: FragmentUpdateBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdateBinding.inflate(layoutInflater, container, false)
        getTitle()
        getCatatan()
        setupLstener()
//        Toast.makeText(context, "NumCorrect: ${args.catatanId}, NumQuestions: ", Toast.LENGTH_LONG).show()

        return binding.root
    }
    private fun getCatatan(){
            binding.editCatatan.setText(args.catatan)
    }
    private fun getTitle(){
            binding.editTitle.setText(args.judul)
    }
    private fun setupLstener(){

        binding.btnUpdate.setOnClickListener {view: View ->
            CoroutineScope(Dispatchers.IO).launch {
                db?.catatanDao()?.updateCatatan(
                    Catatan(
                        args.catatanId,
                        binding.editTitle.text.toString(),
                        binding.editCatatan.text.toString()

                    )
                )
            }
            view.findNavController().navigate(R.id.action_halamanUpdate_to_halamanCatatan)
        }
    }
}