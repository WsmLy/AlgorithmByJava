package com.example.algorithmbyjava.SearchAlgorithm;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.algorithmbyjava.Data;
import com.example.algorithmbyjava.R;

/**
 * 折半查找（二分查找）必须基于顺序存储
 */
public class SearchBinaryActivity extends AppCompatActivity {
    private TextView result;
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_linear);

        initView();
    }

    private void initView() {
        ((TextView)findViewById(R.id.content)).setText("int low,mid,high;\n" +
                "        low = 0;\n" +
                "        high = a.length-1;\n" +
                "        while (low <= high) {\n" +
                "\n" +
                "            mid = (low + high) / 2;\n" +
                "\n" +
                "            if (a[mid] < key)\n" +
                "                low = mid + 1;\n" +
                "            else if(a[mid] > key)\n" +
                "                high = mid - 1;\n" +
                "            else\n" +
                "                return mid;\n" +
                "        }\n" +
                "        return -1;");
        findViewById(R.id.run).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("所在位置是："+binarySearch(Data.array, Integer.parseInt(input.getText().toString())));
            }
        });
        result = findViewById(R.id.result);
        input = findViewById(R.id.input_number);
    }

    private int binarySearch(int[] a, int key){

        int low,mid,high;
        low = 0;
        high = a.length-1;
        while (low <= high) {

            mid = (low + high) / 2;

            if (a[mid] < key)
                low = mid + 1;
            else if(a[mid] > key)
                high = mid - 1;
            else
                return mid;
        }
        return -1;  // 找不到 返回0
    }

    /**
     * 插值查找：折半查找的优化
     * mid换成mid = low + (high - low) * (key - a[low]) / (a[high] - a[low]);
     */
    int Insert_Search(int[] a, int key){

        int low,mid,high;

        low = 1;
        high = a.length;

        while (low < high) {

            mid = low + (high - low) * (key - a[low]) / (a[high] - a[low]);

            if (a[mid] < key)
                low =  mid + 1;
            else if(a[mid] > key)
                high = mid - 1;
            else
                return mid;
        }
        return 0;  // 没找到 返回0
    }

    /**
     * 斐波那契查找
     * 第一次见，感觉是二分的变种
     * 看不懂
     */
//    int Fibonacci_Search(int[] a, int key){
//
//        int low, mid, high, i, k = 0;
//        low = 1;
//        high = n;
//
//        while (n > F[k] - 1)
//            k++;
//
//        for (i = n; i < F[k] - 1; i++)
//            a[i] = a[n];
//
//        while (low <= high) {
//
//            mid = low + F[k-1]-1;
//
//            if (key < a[mid]) {
//                high = mid - 1;
//                k = k - 1;
//            }else if (key > a[mid]){
//                low = mid + 1;
//                k = k - 2;
//            }else{
//                if (mid <= n)
//                    return mid;  // 若相等则说明mid即为查找到的位置
//                else
//                    return n;
//            }
//        }
//        return 0;
//    }
}
