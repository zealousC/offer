package com.example.mianshibaodian.utils;

import android.app.Activity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.Toast;

public class MyTextWatcher {

    /**
     * @param editText editText控件本身
     * @param activity editText控件所在的Activity
     * @return
     */
    public static TextWatcher twPhone(final EditText editText,final Activity activity){
        //设置输入内容为阿拉伯数字
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        //设置输入长度11
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        };
    }

    public static TextWatcher twText(final EditText editText,final Activity activity){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String str = editText.getText().toString().replaceAll("\\s+", "");
                String str2 = editText.getText().toString();
                Log.v("ss",str+str2);
                if (str.length()!=str2.length()){
                    editText.setText(str);
                    editText.setSelection(str.length());
                    Toast showToast = Toast.makeText(activity, "不能使用空格,请更换其他字符", Toast.LENGTH_LONG);
                    showToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    showToast.show();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        };
    }
}
