package com.example.pythonintegrated;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {

    TextView t;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t=findViewById(R.id.tv);
        b=findViewById(R.id.bt);

        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }

        Python py = Python.getInstance();
        PyObject pobj = py.getModule("kasa1");
        PyObject x = pobj.callAttr("main");
        if(x!=null)
            t.setText(x.toString());
        else
            t.setText("Error");

//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                PyObject obj=pobj.callAttr("main");
//
//            }
//        });


        Log.e("TAG", x.toString());
    }
}