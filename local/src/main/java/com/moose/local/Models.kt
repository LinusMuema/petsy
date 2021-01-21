package com.moose.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Animal(
    @PrimaryKey
    val name: String,
    val fact: String,
    val images: List<String>
)