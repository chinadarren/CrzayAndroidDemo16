package com.example.cl.crzayandroiddemo16;

import android.app.Activity;
import android.net.sip.SipRegistrationListener;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {
    private String[] names = new String[]{"虎头", "弄玉", "李清照", "李白"};
    private String[] descs = new String[]{"可爱的小孩", "一个擅长音乐的女孩", "一个擅长文学的女性", "浪漫主义诗人"};
    private int[] imageIds = new int[]{R.drawable.tiger, R.drawable.nongyu, R.drawable.qingzhao, R.drawable.libai};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建一个List集合，List集合的元素是Map
         //
        List<Map<String,Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0;i < names.length;i++){
            Map<String,Object> listItem = new HashMap<String, Object>();
            listItem.put("header",imageIds[i]);
            listItem.put("personNmae",names[i]);
            listItem.put("desc",descs[i]);
            listItems.add(listItem);
        }
        //创建一个SimpleAdapter
        //5个参数，
        // 第2个参数是一个List<? extends Map<String,?>>类型的集合对象，
        //该集合中每个Map<String,?>对象生成一个列表项
        //第3个参数指定一个界面布局的ID，例如此处指定的R.layout.simple_item，
        //这意味着使用/res/layout/simple_item.xml文件作为列表项组件
        //第4个参数是一个String类型的参数，该参数决定提取Map<String,?>对象中那些key
        //对应的value来生成列表项。
        //第5个参数是一个int[]类型的参数，该参数决定填充那些组件。
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,
                R.layout.simple_item,
                new String[] {"header","personName","desc",},
                new int[]{R.id.header,R.id.name,R.id.desc});
        ListView list = (ListView) findViewById(R.id.mylist);
        //为ListView设置Adapter
        list.setAdapter(simpleAdapter);
        //为ListView的列表项的单击事件绑定时间监听
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //第postiion项背单击时激发该方法
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(names[position] + "被单击了");
            }
        });
        //为ListView 的列表项的选中时间绑定事件监听
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            第position项背选中时激发该方法
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(names[position] + "被选中了");
            }
        });
    }


}
