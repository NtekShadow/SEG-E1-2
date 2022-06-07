package com.example.myapplication;

import static com.example.myapplication.Encoder.toOSC;

import android.os.StrictMode;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;


public class Firebase
{
    String wert, ledNr;
    int r, g, b;
    int bl;


    public void verbindungFirebase() {
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://seg-lighthouse-app-default-rtdb.europe-west1.firebasedatabase.app");
        DatabaseReference myRef = database.getReference("Benachrichtigung");
        DatabaseReference LED;
        DatabaseReference LED1;
        DatabaseReference LED2;
        DatabaseReference LED3;
        DatabaseReference LED4;
        DatabaseReference LED5;
        DatabaseReference LED6;
        DatabaseReference LED7;
        DatabaseReference LED8;
        DatabaseReference LED9;
        DatabaseReference LED10;
        DatabaseReference LED11;
        DatabaseReference LED12;
        DatabaseReference LED13;
        DatabaseReference LED14;
        DatabaseReference LED15;
        DatabaseReference LED16;
        DatabaseReference LED17;
        DatabaseReference LED18;
        DatabaseReference LED19;
        DatabaseReference LED20;
        DatabaseReference LED21;
        DatabaseReference LED22;
        DatabaseReference LED23;
        DatabaseReference LED24;
        DatabaseReference LED25;
        DatabaseReference LED26;
        DatabaseReference LED27;
        DatabaseReference LED28;
        DatabaseReference LED29;
        DatabaseReference LED30;
        DatabaseReference LED31;
        DatabaseReference LED32;
        DatabaseReference LED33;
        DatabaseReference LED34;
        DatabaseReference LED35;
        DatabaseReference LED36;
        DatabaseReference LED37;
        DatabaseReference LED38;/*
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;
        DatabaseReference LED;*/

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
//
        //Initial alles auf null setzen, damit die LEDs aus bzw. Schwarz sind!
        for (int i = 0; i < 256; i++) {
            String j = Integer.toString(i);
            LED = database.getReference("LED/"+j+"/R");
            LED.setValue(0);
            LED = database.getReference("LED/"+j+"/G");
            LED.setValue(0);
            LED = database.getReference("LED/"+j+"/B");
            LED.setValue(0);
        }

        myRef.setValue("Nutzer: Nando 07.06.22");
        LED = database.getReference("LED/1");
        OSC_Senden senden = new OSC_Senden(0, 0, 0);
        LED.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Map<String, Object> value = (Map<String, Object>) dataSnapshot.getValue();
                System.out.println(value.get("R"));
                b = Integer.parseInt(value.get("B").toString());
                r = Integer.parseInt(value.get("R").toString());
                g = Integer.parseInt(value.get("G").toString());
                firebaseThread1();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Fehler beim auslesen!");
            }
        });
        LED1 = database.getReference("LED/2");
        LED1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Map<String, Object> value = (Map<String, Object>) dataSnapshot.getValue();
                System.out.println(value.get("R"));
                b = Integer.parseInt(value.get("B").toString());
                r = Integer.parseInt(value.get("R").toString());
                g = Integer.parseInt(value.get("G").toString());
                firebaseThread1();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Fehler beim auslesen!");
            }
        });
    }

    public void firebaseThread() {
        Thread newThread = new Thread(() -> {
            verbindungFirebase();
            System.out.println("Thread erstellt");
        });
        newThread.start();
    }
    public void firebaseThread1() {
        Thread newThread = new Thread(() -> {
            OSC_Senden senden = new OSC_Senden(r, g, b);
            senden.doInBackground();
            System.out.println("Thread 1 erstellt");
        });
        newThread.start();
    }
}
