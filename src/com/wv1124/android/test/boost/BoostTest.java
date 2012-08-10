
package com.wv1124.android.test.boost;

import com.wv1124.android.test.NativeApi;
import com.wv1124.android.test.TestCaseActivity;

/**
 * @author wangwei0312
 */
public class BoostTest extends TestCaseActivity {

    public void testBoostTimer() {
        String ret = "Success";
        if (!ret.equals(NativeApi.testBoostTimer())) {
            throw new Error("testBoostTimer Fail");
        }
    }
}
