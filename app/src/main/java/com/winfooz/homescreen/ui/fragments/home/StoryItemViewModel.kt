package com.winfooz.homescreen.ui.fragments.home

import androidx.databinding.ObservableField
import com.winfooz.homescreen.R
import com.winfooz.homescreen.data.model.Story
import com.winfooz.homescreen.ui.base.BaseItemViewModel

class StoryItemViewModel(val story: Story) : BaseItemViewModel() {
    var storyUrl = ObservableField("")
    var storyTitle = ObservableField("")
    var storyViewed = ObservableField(false)

    override fun getLayoutId(): Int {
        return R.layout.story_item_layout
    }

    init {
        storyUrl.set(story.image)
        storyViewed.set(story.viewed)
        storyTitle.set(story.title)
    }
}