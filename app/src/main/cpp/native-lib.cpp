#include <jni.h>
#include <string>

//region java call jni
extern "C" JNIEXPORT jstring JNICALL
Java_test_mvvm_myapplication_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}


extern "C" JNIEXPORT jstring JNICALL
Java_test_mvvm_myapplication_MainActivity_hi(JNIEnv *env,jobject /* this */){
    std::string hello = "i am hi hi";
    return env->NewStringUTF(hello.c_str());
};

extern "C" JNIEXPORT jstring JNICALL
Java_test_mvvm_demo_video_VideoActivity_hihiss(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

//endregion


