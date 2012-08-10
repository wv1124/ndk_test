
package com.wv1124.android.test;

import java.util.Map;
import java.util.TreeMap;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

import com.wv1124.android.test.boost.BoostTest;

public class MainActivity extends ListActivity {
    
    private Map<String, Intent> intentMap = new TreeMap<String, Intent>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        initClassList();
        
        initView();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    private void initView() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1);
        for (String s : intentMap.keySet()) {
            adapter.add(s);
        }

        setListAdapter(adapter);

        getListView().setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                String value = (String)getListAdapter().getItem(arg2);
                Intent intent = intentMap.get(value);

                if (intent != null) {
                    startActivity(intent);
                }
            }
        });
    }

    /**
     * initialize the list of test class
     */
    private void initClassList() {
        
        intentMap.put(getString(R.string.boost_test), new Intent(this, BoostTest.class));
        
    }

}
