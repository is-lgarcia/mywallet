package com.luisg.mywallet.ui.observable

class AvailableBalanceObservable: Observable {

    private val amountObserverList: ArrayList<Observer> = arrayListOf()
    private var amount: Double = 0.0

    fun changeAmount(newValue: Double){
        amount = newValue
        notifyObserver(amount)
    }

    override fun addObserver(observer: Observer) {
        amountObserverList.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        amountObserverList.remove(observer)
    }

    override fun notifyObserver(newValue: Double) {
        amountObserverList.forEach{
            it.notifyChange(newValue)
        }
    }
}