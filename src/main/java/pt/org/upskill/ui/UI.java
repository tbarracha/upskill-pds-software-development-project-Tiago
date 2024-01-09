package pt.org.upskill.ui;

import java.util.Scanner;

public class UI implements Runnable{
    protected Scanner input = new Scanner(System.in);

    public void  printTitle(String title) {
        System.out.println();
        System.out.println(title.toUpperCase());
        System.out.println("-----------");
    }

    public void run() { };
}
