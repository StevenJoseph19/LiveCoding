package com.acme.java8;

import java.io.File;
import java.io.FileFilter;

public class FirstLambda {

    public static void main(String[] args) {
//        FileFilter filter = new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                return pathname.getName().endsWith(".java");
//            }
//        };

        FileFilter filterLambda = (File pathname) ->
                pathname.getName().endsWith(".java");

        File dir = new File("C:\\Online Training\\ACE\\ASDE\\Training Materials\\Week 2\\Day 4\\1.  Introduction to Lambda Expressions in Java 8\\Source Code");

//        File[] files = dir.listFiles(filter);
        File[] files = dir.listFiles(filterLambda);

        for(File f:files)
            System.out.println(f);
    }
}
