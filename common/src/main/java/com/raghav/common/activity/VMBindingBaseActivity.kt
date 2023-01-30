package com.raghav.common.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.raghav.common.BaseViewModel
import java.lang.reflect.ParameterizedType

abstract class VMBindingBaseActivity<  VM : BaseViewModel, B : ViewBinding> :
    BindingBaseActivity<B>() {

    protected lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?, binding: B) {
        viewModel =
            ViewModelProvider(this, defaultViewModelProviderFactory)[getViewModelClass()]
        onCreate(savedInstanceState, viewModel, binding)

    }

    protected abstract fun onCreate(savedInstanceState: Bundle?, viewModel: VM, binding: B)

    private fun getViewModelClass(): Class<VM> {
        val type = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        return type as Class<VM>
    }

}