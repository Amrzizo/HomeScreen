package com.winfooz.homescreen.di.component

import android.app.Application
import com.winfooz.homescreen.base.BaseApplication
import com.winfooz.homescreen.di.module.ActivityBindingModule
import com.winfooz.homescreen.di.module.ApplicationModule
import com.winfooz.homescreen.di.module.ContextModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class, ApplicationModule::class, AndroidSupportInjectionModule::class, ActivityBindingModule::class])
interface ApplicationComponent : AndroidInjector<DaggerApplication?> {
    fun inject(application: BaseApplication?)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application?): Builder?
        fun build(): ApplicationComponent?
    }
}