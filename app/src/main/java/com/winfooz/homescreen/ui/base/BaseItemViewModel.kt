package com.winfooz.homescreen.ui.base

import androidx.annotation.LayoutRes

abstract class BaseItemViewModel {
    @LayoutRes
    abstract fun getLayoutId(): Int
}