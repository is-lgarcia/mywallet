package com.luisg.mywallet.ui.home.data

import android.app.AlertDialog
import android.content.Context

class MessageFactory {
    companion object{
        val TYPE_ERROR = "typeError"
        val TYPE_SUCCES = "typeSucces"
    }

    fun getDialog(context: Context, type: String): AlertDialog.Builder{
        when (type){
            TYPE_ERROR -> {
               return AlertDialog.Builder(context)
                    .setMessage("Existe un error al obtener el contenido")
            }
            TYPE_SUCCES ->{
                return AlertDialog.Builder(context)
                    .setMessage("Existe un error al obtener el contenido")
            }
        }
        return AlertDialog.Builder(context)
            .setMessage("Tipo no reconocido")
    }
}