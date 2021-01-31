package com.example.mrsstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class OrderActivity2 : AppCompatActivity() {
    lateinit var userDBHelperOrder:DBHelperOrder
    lateinit var inputid: EditText
    lateinit var inputidproduk: EditText
    lateinit var inputnamacust: EditText
    lateinit var inputalamat: EditText
    lateinit var inputjumlah: EditText
    lateinit var inputtotal: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order2)
        inputid = findViewById(R.id.input_id)
        inputidproduk = findViewById(R.id.input_idproduk)
        inputnamacust = findViewById(R.id.input_nama)
        inputalamat = findViewById(R.id.input_alamat)
        inputjumlah = findViewById(R.id.jumlah)
        inputtotal = findViewById(R.id.tharga)
        userDBHelperOrder = DBHelperOrder(this)
    }
    fun addData(v: View){
        var idin = inputid.text.toString()
        var idprodin = inputidproduk.text.toString()
        var namain = inputnamacust.text.toString()
        var alamatin = inputalamat.text.toString()
        var jumlahin = inputjumlah.text.toString()
        var totalin = inputtotal.text.toString()
        userDBHelperOrder.insertData(idin, idprodin, namain, alamatin, jumlahin, totalin)
        inputid.setText("")
        inputidproduk.setText("")
        inputnamacust.setText("")
        inputalamat.setText("")
        inputjumlah.setText("")
        inputtotal.setText("")
    }
    fun showAll(v: View){
//        var pindah = Intent(this, MainActivity2::class.java)
        var pindah = Intent(this, RvDbOrderActivity::class.java)
        startActivity(pindah)
    }
}