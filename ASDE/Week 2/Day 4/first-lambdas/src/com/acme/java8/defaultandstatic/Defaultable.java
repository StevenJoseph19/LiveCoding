package com.acme.java8.defaultandstatic;

public class Defaultable implements DefaultStaticInterface {

    // Implementation of square abstract method
    @Override
    public void square(int a) {
        System.out.println(a * a);
    }

    public static void main(String[] args) {
        Defaultable d = new Defaultable();
        d.square(4);

        // Static method executed
        DefaultStaticInterface.show();
    }
}
