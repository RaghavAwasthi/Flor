package com.raghav.presentation.states

open class State<T>(
    open var isLoading: Boolean = false,
    open var isSuccess: Boolean = false,
    open var payload: T?= null
)
