#include <string.h>
#include <jni.h>

jstring Java_com_wv1124_android_test_NativeApi_testBoostTimer(JNIEnv* env,
		jclass thiz) {

	return (*env)->NewStringUTF(env, "Hello from JNI !");
}



