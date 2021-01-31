package com.example.mrsstore

import android.provider.BaseColumns

object DBInfoProduct  {

    class UserInput: BaseColumns {
    companion object {

        val TABLE_NAME = "product"
        val COL_IDPROD = "idprod"
        val COL_NAMAP = "namap"
        val COL_HARGA = "harga"
        val COL_WARNA = "warna"
        val COL_STOK = "stok"

    }
}
}