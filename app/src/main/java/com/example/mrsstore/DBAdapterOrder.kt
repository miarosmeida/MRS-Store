package com.example.mrsstore

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DBAdapterOrder (private val listDataku: ArrayList<DBModelOrder>): RecyclerView.Adapter<DBAdapterOrder.CardViewHolder>() {
    inner class CardViewHolder(itemV: View): RecyclerView.ViewHolder(itemV) {
        var tvidku: TextView = itemV.findViewById(R.id.tv_idku)
        var tvidprodku: TextView = itemV.findViewById(R.id.tv_idproduku)
        var tvnamcustku: TextView = itemV.findViewById(R.id.tv_namcustku)
        var tvalamatku: TextView = itemV.findViewById(R.id.tv_Alamatku)
        var tvjumlahku: TextView = itemV.findViewById(R.id.tv_jmlhku)
        var tvtotalku: TextView = itemV.findViewById(R.id.tv_totalku)
        var btnDelete: Button = itemV.findViewById(R.id.btndeleteo)
        var btnUpdate: Button = itemV.findViewById(R.id.btnupdateo)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_data_order, parent, false)
        return CardViewHolder(view)
    }
    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val dataku = listDataku[position]
        holder.tvidku.text = dataku.idp
        holder.tvidprodku.text = dataku.idprod
        holder.tvnamcustku.text = dataku.nama
        holder.tvalamatku.text = dataku.alamat
        holder.tvjumlahku.text = dataku.jumlah
        holder.tvtotalku.text = dataku.total

        holder.btnDelete.setOnClickListener {
            var adapterDBHelperOrder: DBHelperOrder
            adapterDBHelperOrder = DBHelperOrder(holder.itemView.context)
            adapterDBHelperOrder.deleteData(dataku.idp)
            listDataku.removeAt(position)
            notifyDataSetChanged()
        }
        holder.btnUpdate.setOnClickListener {
            val pindahUp = Intent(holder.itemView.context, UpdateOrderActivity::class.java)
            val bundle = Bundle()
            bundle.putString("idpku", dataku.idp)
            bundle.putString("idprodku", dataku.idprod)
            bundle.putString("namcustku", dataku.nama)
            bundle.putString("alamatku", dataku.alamat)
            bundle.putString("jumlahku", dataku.jumlah)
            bundle.putString("totalku", dataku.total)
            pindahUp.putExtras(bundle)
            holder.itemView.context.startActivity(pindahUp)
        }
    }

    override fun getItemCount(): Int {
        return listDataku.size
    }
}
