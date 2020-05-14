package com.luisg.mywallet.ui.home

import androidx.lifecycle.LiveData

interface HomeContract {
    interface View{
        fun showLoader()
        fun hideLoader()
        fun showFavoriteTransfer(favoriteTransfer: List<FavoriteTransfer>)
    }
    interface Presenter{
        fun retrieveFavoriteTransfer()
        fun getPercetageLiveData(): LiveData<String>
    }

    interface OnResponseCallback{
        fun onResponse(favoriteList: List<FavoriteTransfer>)
    }
}