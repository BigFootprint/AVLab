//
// Created by liquanmin on 2019/4/15.
//

#include "com_footprint_avlab_teclab_jni_Mp3Endocder.h"
#include <jni.h>
#include <string.h>
#include <android/log.h>

#define LOG_TAG "Mp3Endocder" // 这个是自定义的LOG的标识
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)

JNIEXPORT void JNICALL Java_com_footprint_avlab_teclab_jni_Mp3Endocder_encode
  (JNIEnv *, jobject){
     LOGI("encoder encode");
}