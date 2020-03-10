package com.winfooz.homescreen.data.model

import com.google.gson.annotations.SerializedName

data class Story(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("viewed")
	val viewed: Boolean? = null,

	@field:SerializedName("title")
	val title: String? = null
)