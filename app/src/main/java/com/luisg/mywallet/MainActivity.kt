package com.luisg.mywallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.luisg.mywallet.ui.commands.FileCommandsManager
import com.luisg.mywallet.ui.commands.ReadCommand
import com.luisg.mywallet.ui.commands.SaveCommand

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)

        val commandsManager = FileCommandsManager()
        val saveCommand = SaveCommand()
        val readCommand = ReadCommand()
        commandsManager.putCommand("SaveCommand",saveCommand)
        commandsManager.putCommand("ReadCommand", readCommand)

        commandsManager
            .getCommand("SaveComand")
            .execute(this, "exampleFile","Hola mi nombre es Luis Garcia", "My Wallet")

        commandsManager.getCommand("SaveComand")
            .execute(this, "exampleFile")
    }
}
