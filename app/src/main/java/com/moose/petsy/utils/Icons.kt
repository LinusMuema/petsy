package com.moose.petsy.utils

import com.moose.petsy.R

data class Icon(val drawable: Int, val name: String)

object Icons {

    val list: List<Icon> = listOf(
        Icon(R.drawable.ic_dog, "dogs"),
        Icon(R.drawable.ic_cat, "cats"),
        Icon(R.drawable.ic_bird, "birds"),
        Icon(R.drawable.ic_fox, "foxes"),
        Icon(R.drawable.ic_panda, "pandas"),
        Icon(R.drawable.ic_kangaroo, "kangaroos"),
        Icon(R.drawable.ic_koala, "koalas"),
        Icon(R.drawable.ic_raccoon, "raccoons"),
        Icon(R.drawable.ic_red_panda, "red_pandas"),
    )
}