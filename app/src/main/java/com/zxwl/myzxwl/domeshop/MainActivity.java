package com.zxwl.myzxwl.domeshop;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private ArrayList<String> mNames=new ArrayList<>();

    private XCFlowLayout xcf_hot_words;
    private EditText serach;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initChildViews();
        initView();
        final ArrayList<persenter> strings = new ArrayList<persenter>();
        strings.add(new persenter("aaaa",false));
        strings.add(new persenter("bbbb",false));
        strings.add(new persenter("ffff",false));
        strings.add(new persenter("eeee",false));
        strings.add(new persenter("dddd",false));
        strings.add(new persenter("cccc",false));

        final Adapter adapter = new Adapter(strings, MainActivity.this);
        list.setAdapter(adapter);

        adapter.setOncheckChanged(new Adapter.OnMyCheckChangedListener() {
            @Override
            public void setSelectID(int selectID) {
                mNames.clear();
                mNames.add(strings.get(selectID).getName());
                initChildViews();
                Toast.makeText(MainActivity.this, ""+selectID, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initChildViews() {




        // TODO Auto-generated method stub
        xcf_hot_words = (XCFlowLayout) findViewById(R.id.xcf_hot_words);
        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = 5;
        lp.rightMargin = 5;
        lp.topMargin = 5;
        lp.bottomMargin = 5;
        for (int i = 0; i < mNames.size(); i++) {
            TextView view = new TextView(this);
            view.setText(mNames.get(i));
            view.setTextColor(Color.WHITE);
            view.setBackgroundDrawable(getResources().getDrawable(R.drawable.sss));
            xcf_hot_words.removeAllViews();
            xcf_hot_words.addView(view, lp);
            final int finalI = i;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    xcf_hot_words.removeAllViews();
                    Toast.makeText(MainActivity.this, "" + finalI, Toast.LENGTH_SHORT).show();
                }
            });
        }


    }

    private void initView() {
        serach = (EditText) findViewById(R.id.serach);
        list = (ListView) findViewById(R.id.list);
    }
}
