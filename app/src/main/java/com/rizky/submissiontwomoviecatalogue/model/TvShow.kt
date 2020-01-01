package com.rizky.submissiontwomoviecatalogue.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShow(
    var tvShowTitle: String,
    var tvShowDescription: String,
    var tvShowPoster: Int,
    var tvShowSeason: String
) : Parcelable