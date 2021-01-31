package com.example.mrsstore

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DbAdapterProduct (private val listData: ArrayList<DBModelProduct>): RecyclerView.Adapter<DbAdapterProduct.CardViewHolder>() {
    inner class CardViewHolder(itemV: View): RecyclerView.ViewHolder(itemV) {
        var tvidprodku: TextView = itemV.findViewById(R.id.tv_idproduku)
        var tvnamaku: TextView = itemV.findViewById(R.id.tv_namaku)
        var tvhargaku: TextView = itemV.findViewById(R.id.tv_hargaku)
        var tvwarnaku: TextView = itemV.findViewById(R.id.tv_warnaku)
        var tvstokku: TextView = itemV.findViewById(R.id.tv_stokku)
        var btnDelete: Button = itemV.findViewById(R.id.btndelete)
        var btnUpdate: Button = itemV.findViewById(R.id.btnupdate)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_data_product, parent, false)
        return CardViewHolder(view)
    }
    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val dataku = listData[position]
        holder.tvidprodku.text = dataku.idprod
        holder.tvnamaku.text = dataku.namap
        holder.tvhargaku.text = dataku.harga
        holder.tvwarnaku.text = dataku.warna
        holder.tvstokku.text = dataku.stok

        holder.btnDelete.setOnClickListener {
            var adapterDBHelperProduct: DBHelperProduct
            adapterDBHelperProduct = DBHelperProduct(holder.itemView.context)
            adapterDBHelperProduct.deleteData(dataku.idprod)
            listData.removeAt(position)
            notifyDataSetChanged()
        }
        holder.btnUpdate.setOnClickListener {
            val pindahUp = Intent(holder.itemView.context, UpdateProductActivity::class.java)
            val bundle = Bundle()
            bundle.putString("idprodku", dataku.idprod)
            bundle.putString("namaku", dataku.namap)
            bundle.putString("hargaku", dataku.harga)
            bundle.putString("warnaku", dataku.warna)
            bundle.putString("stokku", dataku.stok)
            pindahUp.putExtras(bundle)
            holder.itemView.context.startActivity(pindahUp)
        }
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}