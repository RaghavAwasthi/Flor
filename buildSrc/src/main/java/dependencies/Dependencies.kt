package dependencies

object Dependencies {


    const val coreKTX: String = "androidx.core:core-ktx:${Versions.coreKTX}"
    const val material: String = "com.google.android.material:material:${Versions.material}"
    const val appcompat: String = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val retrofit: String = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val constraintLayout: String = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val kotlin_coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines_version}"
    const val kotlin_coroutines_android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines_version}"


    //Room Database
    const val roomKtx:String= "androidx.room:room-ktx:${Versions.room}"
    const val room:String = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler:String = "androidx.room:room-compiler:${Versions.room}"

    //Depencency Injection
    const val koinAndroid:String= "io.insert-koin:koin-android:${Versions.koin}"
    const val koinCore:String= "io.insert-koin:koin-core:${Versions.koin}"

    // Lifeycle
    const val lifecyleRuntimeKtx= "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecyle_version}"

    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val newRelic= "com.newrelic.agent.android:android-agent:${Versions.newrelic}"
    const val kotlinStdLib= "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinStdLib}"
    const val workRuntimeKtx= "androidx.work:work-runtime-ktx:${Versions.workManager}"
    const val tfliteSupport="org.tensorflow:tensorflow-lite-support:${Versions.tfliteSupport}"
    const val tfliteMetaData="org.tensorflow:tensorflow-lite-metadata:${Versions.tfliteMetaData}"
    const val tflite="org.tensorflow:tensorflow-lite:${Versions.tflite}"
    const val zeroTurnAroundZip= "org.zeroturnaround:zt-zip:${Versions.zeroTurnAroundZip}"
    const val leakCanary="com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"

}