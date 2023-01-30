package com.raghav.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class SuspendUseCase<OutputParams, InputParams:UseCaseParams>(val dispatcher: CoroutineDispatcher):BaseUseCase<OutputParams, InputParams>() {

     suspend fun execute(params: InputParams):StateFullResult<OutputParams>
    {
           return try{
               withContext(dispatcher)
               {
                   launch(params)
               }
            }
            catch (ex:Exception)
            {
                StateFullResult.failed(ex)
            }

    }


   protected abstract suspend fun launch(params: InputParams):StateFullResult<OutputParams>
}