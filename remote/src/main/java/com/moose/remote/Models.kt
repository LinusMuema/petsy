package com.moose.remote

import kotlinx.serialization.Serializable

@Serializable
data class Fact(val fact: String)

@Serializable
data class Image(val link: String)