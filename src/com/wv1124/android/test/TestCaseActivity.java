
package com.wv1124.android.test;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class TestCaseActivity extends ListActivity {

    static{
        System.loadLibrary("ndk_test");
    }
    
    private static String TAG = "TestCaseActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.main);
        initContentView();
    }

    protected void initContentView() {
        final Map<String, Method> testMethodMap = new TreeMap<String, Method>();
        Method[] methods = this.getClass().getMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().startsWith("test") && !methods[i].getName().equals("test")) {
                testMethodMap.put(methods[i].getName(), methods[i]);
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1);
        for (String s : testMethodMap.keySet()) {
            adapter.add(s);
        }

        setListAdapter(adapter);

        getListView().setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                String value = (String)getListAdapter().getItem(arg2);
                Method testMethod = testMethodMap.get(value);

                if (testMethod != null) {
                    try {
                        Log.d(TAG,
                                "run test " + this.getClass().getName() + "."
                                        + testMethod.getName());

                        testMethod.invoke(TestCaseActivity.this, null);

                        Toast.makeText(getApplicationContext(), " PASS...." + testMethod.getName(),
                                Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Log.e(TAG, "[" + this.getClass().getName() + "." + testMethod.getName()
                                + "()] FAIL : " + e.getClass().getName() + ":" + e.getMessage(), e);

                        Toast.makeText(getApplicationContext(),
                                "[Exception]" + testMethod.getName() + ":" + e.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}
