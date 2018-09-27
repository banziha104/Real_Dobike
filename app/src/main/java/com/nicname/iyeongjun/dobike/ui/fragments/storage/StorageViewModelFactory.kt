package com.nicname.iyeongjun.dobike.ui.fragments.storage

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider


class StorageViewModelFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return StorageViewModel() as T
    }
}