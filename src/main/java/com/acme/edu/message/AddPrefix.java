package com.acme.edu.message;

class AddPrefix {
    static String addPrefix(long messsage){
        return "primitive: ";
    }

    static String addPrefix(char messsage){
        return "char: ";
    }

    static String addPrefix(String messsage){
        return "string: ";
    }

    static String addPrefix(Object messsage){
        return "reference: ";
    }

    static String addPrefix(boolean messsage){
        return "primitive: ";
    }

    static String addPrefix(int[] messsage){
        return "primitives array: ";
    }

    static String addPrefix(int[][] messsage){
        return "primitives matrix: ";
    }
}
