package com.winfooz.homescreen.data.model

import com.google.gson.annotations.SerializedName

data class News(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)