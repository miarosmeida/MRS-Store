package com.example.mrsstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class RvDbActivity : AppCompatActivity() {
    private lateinit var rv_tampilanku: RecyclerView
    lateinit var userDBHelperProduct: DBHelperProduct
    private var list: ArrayList<DBModelProduct> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv_db)
        rv_tampilanku = findViewById(R.id.rv_tampilkan)
        rv_tampilanku.setHasFixedSize(true)
        userDBHelperProduct = DBHelperProduct(this)
        list.addAll(userDBHelperProduct.fullData())
        rv_tampilanku.layoutManager = LinearLayoutManager(this)
        var cardData = DbAdapterProduct(list)
        rv_tampilanku.adapter = cardData
    }
}