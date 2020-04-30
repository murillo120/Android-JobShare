package com.js.jobshare

import com.js.jobshare.models.User
import com.js.jobshare.viewmodels.ViewModelMain
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ViewModelMain() }
}

val modelzModule = module {
    factory { User() }
}