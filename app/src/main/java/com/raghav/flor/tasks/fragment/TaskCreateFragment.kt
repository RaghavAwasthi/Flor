package com.raghav.flor.tasks.fragment

import com.raghav.common.fragment.VMBindingBaseFragment
import com.raghav.flor.databinding.FragmentTaskCreateBinding
import com.raghav.presentation.viewmodels.TaskViewModel


class TaskCreateFragment :VMBindingBaseFragment<TaskViewModel, FragmentTaskCreateBinding>()
{
    override fun getViewBinding(): FragmentTaskCreateBinding {
        return FragmentTaskCreateBinding.inflate(layoutInflater)
    }


    override fun onCreateView(binding: FragmentTaskCreateBinding, viewModel: TaskViewModel) {


    }


}