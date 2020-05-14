package com.luisg.mywallet.ui.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.luisg.mywallet.R
import com.luisg.mywallet.ui.home.FavoriteTransfer
import com.luisg.mywallet.ui.home.HomeContract
import com.luisg.mywallet.ui.home.data.MessageFactory
import com.luisg.mywallet.ui.home.data.MessageFactory.Companion.TYPE_ERROR
import com.luisg.mywallet.ui.home.presenter.HomePresenter
import com.luisg.mywallet.ui.observable.AvailableBalanceObservable
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeContract.View {

    private val favoriteTransferAdapter = FavoriteTransferAdapter()
    lateinit var homePresenter: HomeContract.Presenter
    private val availableBalanceObservable = AvailableBalanceObservable()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        homePresenter = HomePresenter(this)
        homePresenter.retrieveFavoriteTransfer()
        circularProgress.setProgressWithAnimation(
            70f,
            1000,
            AccelerateDecelerateInterpolator(),
            500
        )
        Picasso
            .get()
            .load("https://scontent-mia3-2.xx.fbcdn.net/v/t31.0-8/10848654_10203985038001158_8899025347317878124_o.jpg?_nc_cat=103&_nc_sid=09cbfe&_nc_oc=AQkDw2oe881tpzN_tWf-FTuFDdfUCroiXMP1538ajkHQm7QkRKtahKAwtwt3af6FgPo&_nc_ht=scontent-mia3-2.xx&oh=6056a3e96fcac832460eb0980392b46c&oe=5ED745A6")
            .into(profilePhotoImageView)

        /*availableBalanceObservable.addObserver(object : Observer{
            override fun notifyChange(newValue: Double) {
                amountValueTextView.text = "$ $newValue"
            }
        })*/
        homePresenter.getPercetageLiveData().observe(this, Observer<String>{value ->
            percentageText.text = value
        })
    }

    private fun initRecyclerView() {
        favoriteTransfersRecyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        favoriteTransfersRecyclerView.adapter = favoriteTransferAdapter
    }

    override fun showLoader() {
        homeLoader.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        homeLoader.visibility = View.GONE
    }

    override fun showFavoriteTransfer(favoriteTransfer: List<FavoriteTransfer>) {
        favoriteTransferAdapter.setData(favoriteTransfer)
        /*val dialogFactory = MessageFactory()
        context?.let {
            val errorDialog = dialogFactory.getDialog(it, TYPE_ERROR)
            errorDialog.show()
        }*/

    }
}