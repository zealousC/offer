package com.example.mianshibaodian.utils;

import android.app.Activity;
import android.text.InputFilter;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * editText焦点监听
 */
public class MyOnFocusChange {
    /**
     * @param editText editText控件本身
     * @param activity editText控件所在的Activity
     * @return
     */
    public static View.OnFocusChangeListener fcPhone(final EditText editText, final Activity activity) {
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        return new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    // TODO nothing 有焦点
                    editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
                    String str = editText.getText().toString();
                    String str2 = editText.getText().toString().replaceAll("\\s+", "");
                    if (str.length()!=str2.length()){//判断是否有空格
                        editText.setText(str2);
                    }
                } else {
                    editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(13)});
                    String phoneStr = editText.getText().toString();
                    int phoneLength = phoneStr.replaceAll("\\s+", "").length();
                    // 判断一下手机号码是否合理，并将手机号码格式化成 xxx-xxxx-xxxx 的形式
                    if (phoneLength == 11) {
                        String formatPhoneNumber = phoneStr.substring(0, 3) + " " + phoneStr.substring(3, 7) + " " + phoneStr.substring(7);
                        editText.setText(formatPhoneNumber);
                    } else {
                        Toast showToast = null;
                        String mag = "号码长度有误，请输入11位正确号码";
                        if (showToast == null){
                            showToast = Toast.makeText(activity, mag, Toast.LENGTH_LONG);
                            showToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                        }else {
                            showToast.setText(mag);
                        }
                        showToast.show();
                    }
                }
            }
        };
    }

    public static View.OnFocusChangeListener fcText(final EditText editText, final Activity activity) {
        return new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus){
                    String str = editText.getText().toString().replaceAll("\\s+", "");
                    Toast showToast = null;
                    String mag = "";
                    if (str.length() > 12) {
                        if (showToast==null){
                            mag = "昵称已达到最大长度";
                            showToast = Toast.makeText(activity, mag, Toast.LENGTH_LONG);
                            showToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                        }else {
                            showToast.setText(mag);
                        }
                        showToast.show();
                    }else if (str.length()<2){
                        mag = "昵称已达到最大长度";
                        if (showToast==null){
                            showToast = Toast.makeText(activity, mag, Toast.LENGTH_LONG);
                            showToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                        }else {
                            showToast.setText(mag);
                        }
                        showToast.show();
                    }
                }
            }
        };
    }
    public static View.OnFocusChangeListener fcPassword(final EditText editText, final Activity activity) {
        return new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus){
                    String str = editText.getText().toString().replaceAll("\\s+", "");
                    Toast showToast = null;
                    String mag = "";
                    if (str.length() > 12) {
                        mag = "密码已达到最大长度";
                        if (showToast==null){
                            showToast = Toast.makeText(activity, mag, Toast.LENGTH_LONG);
                            showToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                        }else {
                            showToast.setText(mag);
                        }
                        showToast.show();
                    }else if (str.length()<6){
                        mag = "密码不能小于6位";
                        if (showToast==null){
                            showToast = Toast.makeText(activity, mag, Toast.LENGTH_LONG);
                            showToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                        }else {
                            showToast.setText(mag);
                        }
                        showToast.show();
                    }
                }
            }
        };
    }
}
