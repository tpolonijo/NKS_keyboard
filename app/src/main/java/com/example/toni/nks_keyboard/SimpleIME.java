package com.example.toni.nks_keyboard;

import android.app.Activity;
import android.graphics.Point;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputConnection;

import java.util.List;

public class SimpleIME extends InputMethodService implements KeyboardView.OnKeyboardActionListener {
    
    private KeyboardView kv;
    private Keyboard keyboard;

    @Override
    public View onCreateInputView() {
        kv = (KeyboardView)getLayoutInflater().inflate(R.layout.keyboard, null);
        keyboard = new Keyboard(this, R.xml.qwertz);
        kv.setKeyboard(keyboard);
        kv.setOnKeyboardActionListener(this);
        return kv;
    }

    @Override
    public void onPress(int primaryCode) {
        List<Keyboard.Key> keys = keyboard.getKeys();
        for (Keyboard.Key key : keys){
            //Log.e(String.valueOf(key.height), String.valueOf(key.width));
        }
        //Keyboard.Row row1, row2, row3, row4;
        Keyboard.Key key1, key2, key3, key4, key5, key6, key7, key8, key9, key0;
        key1 = keys.get(0);
        key2 = keys.get(1);
        key3 = keys.get(2);
        key4 = keys.get(3);
        key5 = keys.get(4);
        key6 = keys.get(5);
        key7 = keys.get(6);
        key8 = keys.get(7);
        key9 = keys.get(8);
        key0 = keys.get(9);
        if(primaryCode == 65){
//            key0.width = key0.width/(20/9);
//            key1.width = key1.width/(20/9);
//            key2.width = key2.width/(20/9);
//            key3.width = key3.width/(20/9);
//            key4.width = key4.width/(20/9);
//            key5.width = key5.width/(20/9);
            key6.width = key6.width*2;
//            key7.width = key7.width/(20/9);
//            key8.width = key8.width/(20/9);
//            key9.width = key9.width/(20/9);
        }
        if(primaryCode == 83){
            key6.width = key6.width/2;
        }
        kv.invalidateAllKeys();
        //onUpdateViewShown();

    }

    @Override
    public void onRelease(int primaryCode) {

    }

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection inputConnection = getCurrentInputConnection();

        if(inputConnection != null) {
            switch(primaryCode) {
                case Keyboard.KEYCODE_DELETE:
                    CharSequence selectedText=inputConnection.getSelectedText(0);

                    if(TextUtils.isEmpty(selectedText)) {
                        inputConnection.deleteSurroundingText(1, 0);
                    } else {
                        inputConnection.commitText("", 1);
                    }
                    break;
                default:
                    char code = (char) primaryCode;
                    inputConnection.commitText(String.valueOf(code), 1);
            }
        }
    }

    @Override
    public void onText(CharSequence text) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }

}