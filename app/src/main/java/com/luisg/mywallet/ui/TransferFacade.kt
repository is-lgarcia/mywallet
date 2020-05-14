package com.luisg.mywallet.ui

class TransferFacade {
    val analitycsManager = AnalitycsManager()
    val securityManager = SecurityManager()
    val transferManager = TransferManager()

    fun transfer(){
        val token = securityManager.getToken()
        analitycsManager.registerTransfer(token)
        transferManager.transfer(token)
    }
}