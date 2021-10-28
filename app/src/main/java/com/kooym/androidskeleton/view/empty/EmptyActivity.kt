package com.kooym.androidskeleton.view.empty

import android.os.Bundle
import com.kooym.androidskeleton.R
import com.kooym.androidskeleton.databinding.ActivityEmptyBinding
import com.kooym.androidskeleton.view.base.BaseActivity

class EmptyActivity: BaseActivity<ActivityEmptyBinding>(R.layout.activity_empty) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = EmptyViewModel()

//        binding.viewModel?.init()
    }

}