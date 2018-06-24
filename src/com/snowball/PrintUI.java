package com.snowball;

/**
 * Created by snow on 2018. 6. 24..
 */
public class PrintUI extends PrintDataAb {
    public void printText(String args[]){
        for (int i = 0; i<args.length; i++) {
            System.out.print("[*] ");
            System.out.println(args[i]);
        }
    }
    public void printInterface(){
        System.out.println("---------------------------------------------------");
        System.out.println("\t\tWeather Info");
        System.out.println("\t\tCopyright (c) by ChangIn Baek 2018");
        System.out.println("---------------------------------------------------");
    }
}
