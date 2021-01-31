package com.example.mrsstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class UpdateOrderActivity : AppCompatActivity() {
    lateinit var userDBHelperOrder: DBHelperOrder
    lateinit var inputid: EditText
    lateinit var inputidprod: EditText
    lateinit var inputnamacust: EditText
    lateinit var inputalamat: EditText
    lateinit var inputjumlah: EditText
    lateinit var inputtotal: EditText
    lateinit var idpg: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_order)
        inputid = findViewById(R.id.idu)
        inputidprod = findViewById(R.id.idproduku)
        inputnamacust = findViewById(R.id.namau)
        inputalamat = findViewById(R.id.alamatu)
        inputjumlah = findViewById(R.id.jumlahu)
        inputtotal = findViewById(R.id.thargau)
        userDBHelperOrder = DBHelperOrder(this)
        val bundle =  intent.extras
        if (bundle != null){
            idpg = bundle.getString("idk").toString()
            inputid.setText(bundle.getString("idk"))
            inputidprod.setText(bundle.getString("idprodukk"))
            inputnamacust.setText(bundle.getString("namacustk"))
            inputalamat.setText(bundle.getString("alamatk"))
            inputjumlah.setText(bundle.getString("jumlahk"))
            inputtotal.setText(bundle.getString("telpk"))
        }
        userDBHelperOrder = DBHelperOrder(this)
    }
    fun cancelData(v: View){
        val exit = Intent(this, RvDbOrderActivity::class.java)
        startActivity(exit)
    }
    fun updateData(v: View){
        var idprodin = inputidprod.text.toString()
        var namain = inputnamacust.text.toString()
        var alamatin = inputalamat.text.toString()
        var jumlahin = inputjumlah.text.toString()
        var totalin = inputtotal.text.toString()
        var idin = idpg
        userDBHelperOrder.updateData(idin, idprodin, namain, alamatin, jumlahin, totalin)
        val exit = Intent(this, RvDbOrderActivity::class.java)
        startActivity(exit)
    }
}