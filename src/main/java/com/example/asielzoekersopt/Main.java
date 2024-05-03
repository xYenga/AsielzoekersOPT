package com.example.asielzoekersopt;

import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welkom bij de AZC!");
        System.out.println("U kunt hieronder inloggen om te beginnen.");
        System.out.println();
        System.out.print("Gebruikersnaam: ");
        String gebruikersnaam = scan.nextLine();
        System.out.print("    Wachtwoord: ");
        String wachtwoord = scan.nextLine();
        System.out.println(gebruikersnaam + " " +wachtwoord);

    }
}
