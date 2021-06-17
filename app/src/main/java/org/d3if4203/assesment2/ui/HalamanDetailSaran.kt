package org.d3if4203.assesment2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import org.d3if4203.assesment2.R
import org.d3if4203.assesment2.databinding.FragmentDetailSaranBinding


class HalamanDetailSaran : Fragment() {
    private val args: HalamanDetailSaranArgs by navArgs()
    private lateinit var binding: FragmentDetailSaranBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentDetailSaranBinding.inflate(layoutInflater, container, false)
        pengaturan()
        return binding.root
    }

    fun pengaturan(){
        binding.judul.text = args.title
        binding.textView3.text = args.saran
        this.context?.let {
            Glide.with(this)
                .load(args.image )
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(binding.imageView2)
        }
    }

}