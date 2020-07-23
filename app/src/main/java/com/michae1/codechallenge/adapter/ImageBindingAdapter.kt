package com.michae1.codechallenge.adapter

import android.graphics.BitmapFactory
import android.util.Base64
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.michae1.codechallenge.R
import com.michae1.codechallenge.network.ApiService
import javax.inject.Inject


/**
 *
 * Created by Michae1 (michae1wan@live.com) on 7/23/2020.
 */
@BindingAdapter("imageEncodedString")
fun loadImage(imageView: ImageView, encodedString: String?) {
    if (encodedString != null) {
        val imageBytes = Base64.decode(encodedString, Base64.DEFAULT)
        val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
        Glide
            .with(imageView.context)
            .asBitmap()
            .placeholder(R.drawable.placeholder)
            .load(decodedImage)
            .centerCrop()
            .into(imageView)
    }
    else {
        Glide
            .with(imageView.context)
            .asBitmap()
            .load(R.drawable.placeholder)
            .into(imageView)
    }
}
