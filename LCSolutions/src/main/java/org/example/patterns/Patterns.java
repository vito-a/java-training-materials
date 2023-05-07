package org.example.patterns;

import org.example.patterns.action.SloganAction;

import java.nio.file.FileSystems;

public class Patterns {
    public static void main(String[] args) {
        // System.setProperty("user.dir", ".");
        System.out.println(System.getProperty("user.dir").toString());
        System.out.println(FileSystems.getDefault().toString());
        SloganAction firstObject = new SloganAction ();
        firstObject.printSlogan();
    }
}