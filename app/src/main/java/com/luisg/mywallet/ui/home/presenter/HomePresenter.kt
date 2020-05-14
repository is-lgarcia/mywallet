package com.luisg.mywallet.ui.home.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.luisg.mywallet.ui.home.FavoriteTransfer
import com.luisg.mywallet.ui.home.HomeContract
import com.luisg.mywallet.ui.home.data.HomeInteractor
import com.luisg.mywallet.ui.home.data.User

class HomePresenter(private val view: HomeContract.View) : HomeContract.Presenter {

    private val homeInteractor = HomeInteractor()
    private val percentageLiveData:  MutableLiveData<String> = MutableLiveData()

    override fun retrieveFavoriteTransfer(){

        view.showLoader()

        homeInteractor.retrieveFavoriteTransferFromCache(object: HomeContract.OnResponseCallback{
            override fun onResponse(favoriteList: List<FavoriteTransfer>) {

                val user = User.Builder()
                    .setUsername("Luis")
                    .setPassword("Luis1234")
                    .build()

                percentageLiveData.value = "40%"

                view.hideLoader()
                view.showFavoriteTransfer(favoriteList)
            }
        })
    }

    override fun getPercetageLiveData() : LiveData<String> = percentageLiveData
}