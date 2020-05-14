package com.luisg.mywallet.ui.commands

import android.content.Context
import android.util.Log
import java.io.IOException
import java.io.OutputStreamWriter

class SaveCommand : FileCommand {
    override fun execute(context: Context, fileName: String, vararg arguments: String) {

        try {
            var argumentsString = ""
            arguments.forEach { argumentsString = argumentsString + "\n" + it }
            val outputStringWriter =
                OutputStreamWriter(context.openFileOutput(fileName, Context.MODE_PRIVATE))
            outputStringWriter.write(argumentsString.toString())
            outputStringWriter.close()
        } catch (excepcion: IOException) {
            Log.e("SaveCommand", "File write failed: $excepcion")
        }
    }
}