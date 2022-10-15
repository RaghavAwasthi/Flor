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
    const val room:String = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler:String = "androidx.room:room-compiler:${Versions.room}"



}