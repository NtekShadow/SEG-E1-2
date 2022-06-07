package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File txt = new File("txt.txt");

        try {
            FileWriter writer = new FileWriter(txt, true);
            writer.write("los");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Firebase firebase = new Firebase();
        firebase.firebaseThread();
        /*firebase.firebaseThread1();
        OSC_Senden senden = new OSC_Senden();
        new OSC_Senden().execute();
        */
    }
}