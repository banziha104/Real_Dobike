
package com.nicname.iyeongjun.dobike.ui.fragments.theme

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.nicname.iyeongjun.dobike.R
import com.nicname.iyeongjun.gwangju_contest.extension.plusAssign
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ThemeFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: ThemeViewModelFactory
    lateinit var viewModel : ThemeViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProviders.of(this, viewModelFactory)[ThemeViewModel::class.java]

        return inflater.inflate(R.layout.fragment_theme, container, false)
    }

}
