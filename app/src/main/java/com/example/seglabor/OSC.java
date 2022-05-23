package com.example.seglabor;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

import com.google.firebase.database.*;
import com.google.firebase.firestore.FirebaseFirestore;

import static com.example.seglabor.example_without_library.osc.Encoder.toOSC;


public class OSC {
    String wert;
    public void oscsenden() {
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://seg-lighthouse-app-default-rtdb.europe-west1.firebasedatabase.app");
        DatabaseReference myRef = database.getReference("Benachrichtigung");
        DatabaseReference LED;
        FirebaseFirestore db = FirebaseFirestore.getInstance();




        //Initial alles auf null setzen, damit die LEDs aus bzw. Schwarz sind!
        for (int i = 0; i < 256; i++) {
            String j = Integer.toString(i);
            LED = database.getReference("LED/LED"+j+"/R");
            LED.setValue(0);
            LED = database.getReference("LED/LED"+j+"/G");
            LED.setValue(0);
            LED = database.getReference("LED/LED"+j+"/B");
            LED.setValue(0);
        }
        LED = database.getReference("LED/LED1");
        //LED1.setValue(1);
        myRef.setValue("Nutzer: Nando");
        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();
        user.put("first", "Ada");
        user.put("last", "Lovelace");
        user.put("born", 1815);

// Add a new document with a generated ID
       /* db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });*/
        // Read from the database
        LED.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                //Log.d(TAG, "Value is: " + value);
                System.out.println("Der Wert ist: "+value);
                wert = value;
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
                System.out.println("Fehler beim auslesen");
            }
        });
           /* // einen DatagrammSocket(UDP) erstellen
            try (DatagramSocket socket = new DatagramSocket()) {

                // den OSC Payload erstellen
                String toSend = toOSC("/lighthouse/lightx2y7", wert, 100, 250);
                System.out.println(toSend.length() + ": " + toSend);

                // ein Packet mit dem Payload, der Adresse und Port erstellen
                DatagramPacket packet = new DatagramPacket(toSend.getBytes(), toSend.length(),
                        InetAddress.getByName("149.222.206.225"), 9000);

                // das Packet senden
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
                    try (DatagramSocket socket = new DatagramSocket()) {

                        // den OSC Payload erstellen
                        String toSend = toOSC("/lighthouse/lightx0y0", 100, 200, 240);
                        System.out.println(toSend.length() + ": " + toSend);

                        // ein Packet mit dem Payload, der Adresse und Port erstellen
                        DatagramPacket packet = new DatagramPacket(toSend.getBytes(), toSend.length(),
                                InetAddress.getByName("149.222.206.225"), 9000);

                        // das Packet senden
                        socket.send(packet);
                    } catch (IOException e) {
                        e.printStackTrace();
            }*/

        }
        public void OSC_thread() {
            Thread newThread = new Thread(() -> {
                oscsenden();
                System.out.println("Thread erstellt");
        });
            newThread.start();
    }
    }
