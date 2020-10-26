package com.js.jobshare

import com.js.jobshare.models.Job
import com.js.jobshare.models.User
import com.js.jobshare.viewmodels.ViewModelUser
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ViewModelUser() }
}

val modelzModule = module {
    factory { User() }
    factory { Job() }
}