package org.d3if4203.assesment2.ui


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.d3if4203.assesment2.databinding.AdapterCatatanBinding
import org.d3if4203.assesment2.db.Catatan

class CatatanAdapter (var catatans: ArrayList<Catatan>) : RecyclerView.Adapter<CatatanAdapter.CatatanViewHolder>() {

    class CatatanViewHolder(private val itemBinding: AdapterCatatanBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(catatan: Catatan) {
            itemBinding.textTitle.text = catatan.judul
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatatanViewHolder {
        val itemBinding = AdapterCatatanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatatanViewHolder(itemBinding)
    }

    override fun getItemCount() = catatans.size


    fun setData(newList: List<Catatan>) {
        catatans.clear()
        catatans.addAll(newList)
    }

    override fun onBindViewHolder(holder: CatatanViewHolder, position: Int) {
        val catatan = catatans[position]
        holder.bind(catatan)
    }

}

