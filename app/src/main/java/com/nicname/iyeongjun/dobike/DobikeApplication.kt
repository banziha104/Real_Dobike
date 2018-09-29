package com.nicname.iyeongjun.dobike

import com.nicname.iyeongjun.dobike.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlin.properties.Delegates

//private var realm : Realm by Delegates.notNull()
//private var realmConfig : RealmConfiguration by Delegates.notNull()

class DobikeApplication : DaggerApplication(){

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

}