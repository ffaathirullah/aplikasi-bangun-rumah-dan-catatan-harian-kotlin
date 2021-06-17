package org.d3if4203.assesment2.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.d3if4203.assesment2.R
import org.d3if4203.assesment2.databinding.AdapterSaranBinding
import org.d3if4203.assesment2.db.Catatan
import org.d3if4203.assesment2.network.MainModel

class SaranAdapter (var results : ArrayList<MainModel.Result>, var listener: OnAdapterListener) : RecyclerView.Adapter<SaranAdapter.SaranViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaranViewHolder {
        val itemBinding = AdapterSaranBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SaranViewHolder(itemBinding, listener)
    }

    override fun getItemCount() = results.size

    class SaranViewHolder(private val binding: AdapterSaranBinding, var listener: OnAdapterListener) : RecyclerView.ViewHolder(binding.root) {

        fun bind1(hasil : MainModel.Result){
            binding.textView.text = hasil.title
        }

        fun bind2 (hasil : MainModel.Result){
            Glide.with(binding.imageView)
                .load(hasil.image)
                .placeholder(R.drawable.placeholder)
                .centerCrop()
                .into(binding.imageView)
        }

        fun bind3 (hasil : MainModel.Result){
            binding.textView.setOnClickListener {
                listener.onClick(hasil)
            }
        }
    }

    override fun onBindViewHolder(holder: SaranViewHolder, position: Int) {
        val result = results[position]
        holder.bind1(result)
        holder.bind2(result)
        holder.bind3(result)
    }

    fun setData(data: List<MainModel.Result>){
        this.results.clear()
        this.results.addAll(data)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(hasil: MainModel.Result)
    }
}