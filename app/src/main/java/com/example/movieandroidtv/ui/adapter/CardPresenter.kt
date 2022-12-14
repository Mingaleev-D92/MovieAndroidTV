package com.example.movieandroidtv.ui.adapter

import android.view.ViewGroup
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import com.bumptech.glide.Glide
import com.example.movieandroidtv.model.Movie
import com.example.movieandroidtv.ui.common.loadUrl

/**
 * @author : Mingaleev D
 * @data : 16/10/2022
 */

class CardPresenter : Presenter() {
  override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
    val cardView = ImageCardView(parent.context).apply {
      isFocusable = true
      isFocusableInTouchMode = true
      setMainImageDimensions(176, 313)
    }
    return ViewHolder(cardView)
  }

  override fun onBindViewHolder(viewHolder: ViewHolder, item: Any?) {
    val movie = item as Movie
    with(viewHolder.view as ImageCardView) {
      titleText = movie.title
      contentText = movie.year.toString()

      mainImageView.loadUrl(movie.poster)
    }
  }

  override fun onUnbindViewHolder(viewHolder: ViewHolder) {
    with(viewHolder.view as ImageCardView) {
      mainImage = null
    }
  }
}
