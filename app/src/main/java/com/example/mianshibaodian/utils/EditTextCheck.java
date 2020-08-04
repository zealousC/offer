package com.example.mianshibaodian.utils;

import android.app.Activity;
import android.widget.EditText;

public class EditTextCheck {

    public static void etcPhone(final EditText editText, final Activity activity){
        editText.setOnFocusChangeListener(MyOnFocusChange.fcPhone(editText,activity));
    }
    public static void etcText(final EditText editText, final Activity activity){
        editText.addTextChangedListener(MyTextWatcher.twText(editText, activity));
        editText.setOnFocusChangeListener(MyOnFocusChange.fcText(editText, activity));
    }
    public static void etcPassword(final EditText editText, final Activity activity){
        editText.addTextChangedListener(MyTextWatcher.twText(editText, activity));
        editText.setOnFocusChangeListener(MyOnFocusChange.fcPassword(editText, activity));
    }
}
