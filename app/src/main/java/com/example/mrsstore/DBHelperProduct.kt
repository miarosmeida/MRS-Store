package com.example.mrsstore

import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelperProduct  (context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        val DATABASE_NAME = "Product.db"
        val DATABASE_VERSION = 1
        private val SQL_CREATE_ENTRIES =
                "CREATE TABLE " + DBInfoProduct.UserInput.TABLE_NAME + " (" +  DBInfoProduct.UserInput.COL_IDPROD + " TEXT, " +
                        DBInfoProduct.UserInput.COL_NAMAP + " VARCHAR(200), " +  DBInfoProduct.UserInput.COL_HARGA +
                        " VARCHAR(30), " +  DBInfoProduct.UserInput.COL_WARNA + " VARCHAR(35)," +  DBInfoProduct.UserInput.COL_STOK + " VARCHAR(15) )"
        private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " +  DBInfoProduct.UserInput.TABLE_NAME
    }
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    @Throws(SQLiteConstraintException::class)
    fun insertData(idprodin: String, namapin: String, hargain: String, warnain: String, stokin: String): Boolean {
        val db = writableDatabase
        val namatablet =  DBInfoProduct.UserInput.TABLE_NAME
        val idprodt =  DBInfoProduct.UserInput.COL_IDPROD
        val namapt = DBInfoProduct.UserInput.COL_NAMAP
        val hargat =  DBInfoProduct.UserInput.COL_HARGA
        val warnat = DBInfoProduct.UserInput.COL_WARNA
        val stokt = DBInfoProduct.UserInput.COL_STOK


        var sql = "INSERT INTO "+ namatablet +"("+idprodt+", "+namapt+", "+hargat+", "+warnat+","+stokt+") " +
                "VALUES('"+idprodin+"', '"+namapin+"', '"+hargain+"', '"+warnain+"', '"+stokin+"')"
        db.execSQL(sql)
        return true
    }
    fun fullData():ArrayList<DBModelProduct>{
        val products = arrayListOf<DBModelProduct>()
        val db = writableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery("SELECT * FROM "+  DBInfoProduct.UserInput.TABLE_NAME, null)
        }catch (e: SQLException){
            db.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList()
        }

        var idprodt: String
        var namapt: String
        var hargat: String
        var warnat: String
        var stokt: String
        if (cursor!!.moveToFirst()){
            while (cursor.isAfterLast==false){
                idprodt = cursor.getString(cursor.getColumnIndex( DBInfoProduct.UserInput.COL_IDPROD))
                namapt = cursor.getString(cursor.getColumnIndex( DBInfoProduct.UserInput.COL_NAMAP))
                hargat = cursor.getString(cursor.getColumnIndex( DBInfoProduct.UserInput.COL_HARGA))
                warnat = cursor.getString(cursor.getColumnIndex( DBInfoProduct.UserInput.COL_WARNA))
                stokt = cursor.getString(cursor.getColumnIndex( DBInfoProduct.UserInput.COL_STOK))

                products.add(DBModelProduct(idprodt, namapt, hargat, warnat, stokt))
                cursor.moveToNext()
            }
        }
        return  products
    }
    fun deleteData(idin: String){
        val db = writableDatabase
        val namatablet = DBInfoProduct.UserInput.TABLE_NAME
        val idt= DBInfoProduct.UserInput.COL_IDPROD
        val sql = "DELETE FROM " +namatablet+ " WHERE " +idt+"='"+idin+"'"
        db.execSQL(sql)
    }
    fun updateData(idprodin: String, namapin: String, hargain: String, warnain: String, stokin: String) {
        val db = writableDatabase
        val namatablet = DBInfoProduct.UserInput.TABLE_NAME
        val idprodt = DBInfoProduct.UserInput.COL_IDPROD
        val namapt = DBInfoProduct.UserInput.COL_NAMAP
        val hargat = DBInfoProduct.UserInput.COL_HARGA
        val warnat = DBInfoProduct.UserInput.COL_WARNA
        val stokt = DBInfoProduct.UserInput.COL_STOK
        var sql = "UPDATE " + namatablet + " SET " +
                namapt + "='" + namapin + "', " + hargat + "='" + hargain +
                "', " + warnat + "='" + warnain + "', " + stokt + "='" + stokin + "' " +
                "WHERE " + idprodt + "='" + idprodin + "'"
        db.execSQL(sql)

    }

}
