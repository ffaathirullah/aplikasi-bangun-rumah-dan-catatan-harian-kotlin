package org.d3if4203.assesment2.ui


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.d3if4203.assesment2.databinding.AdapterCatatanBinding
import org.d3if4203.assesment2.db.Catatan

class CatatanAdapter (var catatans: ArrayList<Catatan>, var listener: OnAdapterListener) : RecyclerView.Adapter<CatatanAdapter.CatatanViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatatanViewHolder {
        val itemBinding = AdapterCatatanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatatanViewHolder(itemBinding, listener)
    }

    override fun getItemCount() = catatans.size

    class CatatanViewHolder(private val itemBinding: AdapterCatatanBinding,   var listener: OnAdapterListener) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(catatan: Catatan) {
            itemBinding.textTitle.text = catatan.judul
        }
        fun bind2(catatan: Catatan) {
            itemBinding.textDesx.text = catatan.catatan
        }
        fun bind3(catatan: Catatan ) {
            itemBinding.textDesx.setOnClickListener {
                listener.onClick(catatan)
            }
        }
        fun bind4(catatan: Catatan ) {
            itemBinding.iconEdit.setOnClickListener {
                listener.onUpdate(catatan)
            }
        }
        fun bind5(catatan: Catatan ) {
            itemBinding.iconDelete.setOnClickListener {
                listener.onDelete(catatan)
            }
        }
    }

    override fun onBindViewHolder(holder: CatatanViewHolder, position: Int) {
        val catatan = catatans[position]
        holder.bind(catatan)
        holder.bind2(catatan)
        holder.bind3(catatan)
        holder.bind4(catatan)
        holder.bind5(catatan)
    }


    fun setData(newList: List<Catatan>) {
        catatans.clear()
        catatans.addAll(newList)
    }

    interface OnAdapterListener {
        fun onClick(catatan: Catatan)
        fun onUpdate(catatan: Catatan)
         fun onDelete(catatan: Catatan)
    }


}

