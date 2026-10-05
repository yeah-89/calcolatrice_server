package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        ServerSocket ss = new ServerSocket(3000);
        Socket s = ss.accept();
        System.out.println("connessione riuscita");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        while (true) {
            Double num1=Double.parseDouble(in.readLine());
            Double num2=Double.parseDouble(in.readLine());
            String str= in.readLine();
            

            if(num1==0 && num2==0){
                break;
            }
            double ris=0;

            switch (str) {
                case "+":
                    ris=num1+num2;
                    break;
                case "-":
                    ris=num1-num2;
                    break;
                case "*":
                    ris=num1*num2;
                    break;
                case "/":
                    ris=num1/num2;
                    break;
                default:
                    break;
            }
            out.println("Risposta: " );
        }

        System.out.println("Disconnesso");
    }
}