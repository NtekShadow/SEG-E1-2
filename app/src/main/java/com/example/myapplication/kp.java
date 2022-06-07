package com.example.myapplication;

        import java.io.BufferedWriter;
        import java.io.FileWriter;
        import java.io.IOException;
        import java.io.PrintWriter;

public class kp {

    public static void main(String[] args) {

        PrintWriter pWriter = null;

        try {

            // Schreibt die Datei. append ist auf false gesetzt.
            FileWriter fw = new FileWriter("datei.bat", false);

            BufferedWriter bw = new BufferedWriter(fw);
            pWriter = new PrintWriter(bw);

            pWriter.println("javac C:\\Users\\fabia\\Dropbox\\EntwicklungsOrdner\\SimpleMatics\\test1.java & cd C:\\Users\\fabia\\Dropbox\\EntwicklungsOrdner\\SimpleMatics\\ & java test1 > C:\\Users\\fabia\\Dropbox\\EntwicklungsOrdner\\SimpleMatics\\ausgabe1.txt");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pWriter != null) {
                pWriter.flush();
                pWriter.close();
            }

        }

    }
  }
