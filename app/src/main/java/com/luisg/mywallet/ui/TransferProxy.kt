package com.luisg.mywallet.ui

class TransferProxy {
    val MAX_TRANFER_AMOUNT = 1000000
    val MIN_TRANSFER_AMOUNT = 100

    fun checkTransfer(amount: Double): String {
        return when {
            amount > MAX_TRANFER_AMOUNT -> {
                "La Transacción excede el monto máximo"
            }
            amount < MIN_TRANSFER_AMOUNT -> {
                "La Transacción debe ser mayor a $MIN_TRANSFER_AMOUNT"
            }
            else -> {
                doTransfer(amount)
                "La transferencia se hizo corectamente"
            }
        }
    }

    private fun doTransfer(amount: Double){

    }
}