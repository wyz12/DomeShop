package com.zxwl.myzxwl.domeshop;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2018/3/7.
 */

public class Adapter extends BaseAdapter {
    private ArrayList<persenter> list;
    private Context context;



    public HashMap<Integer, Boolean> states = new HashMap<Integer, Boolean>();
    private int selectID;
    private OnMyCheckChangedListener mCheckChange;

    public Adapter(ArrayList<persenter> list, Context context ) {
        this.list = list;
        this.context = context;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    public void setSelectID(int position) {
        selectID = position;
    }
    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final HH hh;
        if(view==null){
            hh= new HH();
            view = LayoutInflater.from(context).inflate(R.layout.layout_bj, null);

            hh.name = view.findViewById(R.id.name);
            hh.xz = view.findViewById(R.id.xz);
            view.setTag(hh);
        }else{
            hh = (HH) view.getTag();
        }

        hh.name.setText(list.get(i).getName());
        hh.xz.setChecked(list.get(i).isRoid());
        hh.xz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //把所有的按钮的状态设置为没选中
                for (int i = 0; i < getCount(); i++) {
                    states.put(i, false);
                }
                //然后设置点击的那个按钮设置状态为选中
                states.put(i, true);    //这样所有的条目中只有一个被选中！
                notifyDataSetChanged();//刷新适配器

                //这一句的意思跟下面的一样，不过这个是itemClick的点击监听，而下面的是RadioButton的点击监听。
                selectID = i;

                /**
                 * 在MyListView中使用mListViewAdapter.setOncheckChanged
                 * 来监听RadioButton的点击事件，（当然，首先要判空）
                 * 当我们按下单选按钮时，我们把按下的item的位置赋值给selectID
                 * ，然后在上面的if语句中判断当前点击的位置与selectID的位置
                 * 是否相等，如果不相等，那么说明按下了新的位置，那么就把原来位置上的选择取消掉，
                 * 在新的位置让单选按钮显示选中状态就可以了。
                 */
                if (mCheckChange != null)
                    mCheckChange.setSelectID(selectID);

            }
        });

        //上面是点击后设置状态，但是也是需要设置显示样式,通过判断状态设置显示的样式
        if (states.get((Integer) i) == null || states.get((Integer) i) == false) {  //true说明没有被选中
            hh.xz.setChecked(false);
        } else {
           hh.xz.setChecked(true);
        }


        return view;
    }
    public void setOncheckChanged(OnMyCheckChangedListener l) {
        mCheckChange = l;
    }

    // 回調接口
    public interface OnMyCheckChangedListener {
        void setSelectID(int selectID);
    }
    class  HH{
        private TextView name;
        private RadioButton xz;
    }
}
