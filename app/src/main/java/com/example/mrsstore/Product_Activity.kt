package com.example.mrsstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class Product_Activity : AppCompatActivity() {
    lateinit var userDBHelperProduct: DBHelperProduct
    lateinit var inputidproduk: EditText
    lateinit var inputnamap: EditText
    lateinit var inputharga: EditText
    lateinit var inputwarna: EditText
    lateinit var inputstok: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_)
        inputidproduk = findViewById(R.id.input_id)
        inputnamap = findViewById(R.id.input_nama)
        inputharga = findViewById(R.id.input_harga)
        inputwarna = findViewById(R.id.input_warna)
        inputharga = findViewById(R.id.input_harga)
        userDBHelperProduct = DBHelperProduct(this)
    }
    fun addData(v: View){
        var idprodin = inputidproduk.text.toString()
        var namapin = inputnamap.text.toString()
        var hargain = inputharga.text.toString()
        var warnain = inputwarna.text.toString()
        var stokin = inputstok.text.toString()
        userDBHelperProduct.insertData(idprodin, namapin, hargain, warnain, stokin)
        inputidproduk.setText("")
        inputnamap.setText("")
        inputharga.setText("")
        inputwarna.setText("")
        inputstok.setText("")
    }
    fun showAll(v: View){
//        var pindah = Intent(this, MainActivity2::class.java)
        var pindah = Intent(this, RvDbActivity::class.java)
        startActivity(pindah)
    }
}