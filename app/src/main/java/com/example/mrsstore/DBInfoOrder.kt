package com.example.mrsstore

import android.provider.BaseColumns

object DBInfoOrder{

    class UserInput: BaseColumns {
    companion object {

        val TABLE_NAME = "order"
        val COL_ID = "idp"
        val COL_IDPROD = "idprod"
        val COL_NAMA = "nama"
        val COL_ALAMAT = "alamat"
        val COL_JUMLAH = "jumlah"
        val COL_TOTAL = "total"

    }
}
}