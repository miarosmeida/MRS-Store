package com.example.mrsstore

import android.provider.BaseColumns

object DBInfo {
    class UserTable: BaseColumns {
        companion object {
            val TABLE_NAME = "user"
            val COL_EMAIL = "email"
            val COL_PASS = "pass"
            val COL_FULLNAME = "fullname"
            val COL_ALAMAT = "alamat"
            val COL_JK = "jeniskelamin"
            val COL_JUMLAH = "jumlah"
        }
    }

}