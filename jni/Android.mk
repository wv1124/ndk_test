LOCAL_PATH := $(call my-dir)

   include $(CLEAR_VARS)

   LOCAL_MODULE    := ndk_test
   LOCAL_SRC_FILES := com_wv1124_android_test_NativeApi.cpp

   include $(BUILD_SHARED_LIBRARY)
