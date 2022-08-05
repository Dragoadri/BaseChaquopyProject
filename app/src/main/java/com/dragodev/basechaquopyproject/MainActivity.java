package com.dragodev.basechaquopyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        startPython();
        getPyModule();

    }

    private void initViews() {
        textView = findViewById(R.id.textView);
    }

    private void startPython() {
        if (!Python.isStarted()){
            Python.start(new AndroidPlatform(this));
        }
    }

    private  void getPyModule() {
        //crear instancia de python
        Python py = Python.getInstance();
        //Crear objeto de python
        PyObject pyObj= py.getModule("main");
        //Llamar a funcion
        PyObject obj = pyObj.callAttr("mainFunc");
        String str = obj.toString();
        textView.setText(str);

    }
}