package com.luisg.mywallet.ui.transfer.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TransferEntity::class], version = 1)
abstract class AplicationDatabase : RoomDatabase() {

    abstract fun getDAO () : TransferDAO

    companion object {
        private var INSTANCES: AplicationDatabase? = null

        fun getAppDatabase(context: Context): AplicationDatabase? {
            if (INSTANCES == null) {
                INSTANCES = Room.databaseBuilder(
                    context.applicationContext,
                    AplicationDatabase::class.java,
                    "myWalletDatabase"
                ).allowMainThreadQueries().build()
            }
            return INSTANCES
        }

        fun destroyInstance() {
            INSTANCES = null
        }
    }
}