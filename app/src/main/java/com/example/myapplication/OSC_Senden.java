package com.example.myapplication;
//keine Ahnugn wie aber momentan geht es mit einer LED!

import static com.example.myapplication.Encoder.toOSC;

import android.os.AsyncTask;
import android.os.StrictMode;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class OSC_Senden extends AsyncTask<String, Void, Void> {
    int r, g, b;

    OSC_Senden(int r, int g, int b){
        this.r = r;
        this.b = b;
        this.g = g;
    }
    @Override
    protected Void doInBackground(String... strings) {
        Encoder encoder = new Encoder();
        try (DatagramSocket socket = new DatagramSocket()) {
                // den OSC Payload erstellen
                Firebase firebase = new Firebase();
                    String toSend = toOSC("/lighthouse/lightx"+"0"+"y0", this.r, this.g, this.b);
                    DatagramPacket packet = new DatagramPacket(toSend.getBytes(), toSend.length(),
                            InetAddress.getByName("149.222.206.225"), 9000);
                    // das Packet senden
                    socket.send(packet);

                System.out.println(toSend.length() + ": " + toSend);
                System.out.println(r + " " + g + " " + b);

/*
                // ein Packet mit dem Payload, der Adresse und Port erstellen
                DatagramPacket packet = new DatagramPacket(toSend.getBytes(), toSend.length(),
                        InetAddress.getByName("149.222.206.225"), 9000);
                // das Packet senden
                socket.send(packet);*/
                System.out.println("gesendet!");
            } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
