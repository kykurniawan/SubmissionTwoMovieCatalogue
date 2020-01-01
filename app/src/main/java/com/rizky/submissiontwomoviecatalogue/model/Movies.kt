package com.rizky.submissiontwomoviecatalogue.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movies(
    var movieTitle: String,
    var movieDescription: String,
    var moviePoster: Int,
    var movieRelease: String,
    var movieDirector: String
) : Parcelable