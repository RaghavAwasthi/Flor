package com.raghav.flor

import android.animation.TimeInterpolator
import android.animation.ValueAnimator


inline fun getValueAnimator(
    forward: Boolean = true,
    duration: Long,
    interpolator: TimeInterpolator,
    crossinline updateListener: (progress: Float) -> Unit
): ValueAnimator {

    val animator =
        if (forward) ValueAnimator.ofFloat(0f, 1f)
        else ValueAnimator.ofFloat(1f, 0f)
    animator.apply {
        addUpdateListener { updateListener(it.animatedValue as Float) }
        this.duration = duration
        this.interpolator = interpolator
    }
    return animator
}