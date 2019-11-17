package com.example.algorithmbyjava.SearchAlgorithm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.algorithmbyjava.Data;
import com.example.algorithmbyjava.R;

public class SearchLinearActivity extends AppCompatActivity {
    private TextView result;
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_linear);

        initView();
    }

    private void initView() {
        ((TextView)findViewById(R.id.content)).setText("private int linearSearch(int[] a, int key) {\n" +
                "        for (int i = 0; i < a.length; i++) {\n" +
                "            if (a[i] == key)\n" +
                "                return i;\n" +
                "        }\n" +
                "        return -1;  // 返回0表示没找到\n" +
                "    }");
        findViewById(R.id.run).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearSearch(Data.array, Integer.parseInt(input.getText().toString()));
            }
        });
        result = findViewById(R.id.result);
        input = findViewById(R.id.input_number);
    }

    private int linearSearch(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                result.setText(key + "所在的位置是：" + (i+1));
                return i;
            }
        }
        result.setText("未找到"+key);
        return -1;  // 返回0表示没找到
    }
    /**
     * 1.1顺序查找优化，添加哨兵
     * 注意 这里将a[0]设置为哨兵 那么a[0]就不能用来存储需要查找的数据
     * 如果找到 返回的数据表示在数组中索引所在的位置 从0开始的 也就是说如果返回的是1的话 是数组的第二个元素  所以可以在返回的结果上+1
     * 同样 这儿哨兵也可以放在数组的尾巴上 a[n-1] = key
     * 下面的写法不对
     */
    private int guard_search(int[] a, int key){

        int i = a.length;
        a[0] = key;  // 哨兵
        while (a[i] != key)
            i--;
        return i;  // 返回0表示没找到
    }
}
