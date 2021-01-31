package com.example.mrsstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class UpdateProductActivity : AppCompatActivity() {
    lateinit var userDBHelperProduct: DBHelperProduct
    lateinit var inputidprod: EditText
    lateinit var inputnamap: EditText
    lateinit var inputharga: EditText
    lateinit var inputwarna: EditText
    lateinit var inputstok: EditText
    lateinit var idprodg: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_product)
        inputidprod = findViewById(R.id.idu)
        inputnamap = findViewById(R.id.input_namau)
        inputharga = findViewById(R.id.input_hargau)
        inputwarna = findViewById(R.id.input_warnau)
        inputstok = findViewById(R.id.stoku)
        userDBHelperProduct = DBHelperProduct(this)
        val bundle =  intent.extras
        if (bundle != null){
            idprodg = bundle.getString("idk").toString()
            inputidprod.setText(bundle.getString("idprodukk"))
            inputnamap.setText(bundle.getString("namapk"))
            inputharga.setText(bundle.getString("hargak"))
            inputwarna.setText(bundle.getString("warnak"))
            inputstok.setText(bundle.getString("stokk"))
        }
        userDBHelperProduct = DBHelperProduct(this)
    }
    fun cancelData(v: View){
        val exit = Intent(this, RvDbActivity::class.java)
        startActivity(exit)
    }
    fun updateData(v: View){
        var namapin = inputnamap.text.toString()
        var hargain = inputharga.text.toString()
        var warnain = inputwarna.text.toString()
        var stokin = inputstok.text.toString()
        var idprodin = idprodg
        userDBHelperProduct.updateData( idprodin, namapin, hargain, warnain, stokin)
        val exit = Intent(this, RvDbActivity::class.java)
        startActivity(exit)
    }
}