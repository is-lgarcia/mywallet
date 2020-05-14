package com.luisg.mywallet.ui.home.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.luisg.mywallet.R
import com.luisg.mywallet.ui.home.FavoriteTransfer
import com.squareup.picasso.Picasso

class FavoriteTransferViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: FavoriteTransfer) {
        val photoImageView = view.findViewById<ImageView>(R.id.profilePhotoImageView)
        Picasso.get().load(item.photoUrl).into(photoImageView)
        val nameText = view.findViewById<TextView>(R.id.nameTextView)
        nameText.text = item.name
        val transferAmount = view.findViewById<TextView>(R.id.transferredAmountTextView)
        transferAmount.text = item.amount.toString()
        val transferTime = view.findViewById<TextView>(R.id.transferTimeTextView)
        transferTime.text = item.date
    }
}