#include <string.h>
#include <jni.h>
#include <boost_test/include/TimerTest.h>

jstring Java_com_wv1124_android_test_NativeApi_testBoostTimer(JNIEnv* env,
		jclass thiz) {
	TimerTest t;
	return env->NewStringUTF(t.time_test1());
}















