package com.kooym.androidskeleton.view.empty

import android.util.Log
import com.kooym.androidskeleton.network.retrofit.RetrofitClient
import com.kooym.androidskeleton.utils.Dlog
import com.kooym.androidskeleton.view.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class EmptyViewModel: BaseViewModel() {
    private val instance = RetrofitClient.getClient()

    fun init(){
        if(instance!=null){
            addDisposable(instance.test()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                }, {Dlog.e("")})
            )
        }
    }
}