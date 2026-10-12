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

        boolean var=true;
        String str="";
        Double num1=0.0;
        Double num2=0.0;
        boolean datiValidi= false;

        while (var) {
            do {
                try {
                    str= in.readLine();
                    num1=Double.parseDouble(in.readLine());
                    num2=Double.parseDouble(in.readLine());
                    if (str.equals("+") || str.equals("-") || str.equals("/") || str.equals("*") || str.equals("exit")) {
                        datiValidi=true;
                    } else {
                        out.println("opertatore non valido");
                    }

                    
                } catch (NumberFormatException e) {
                    out.println("Errore: inserimento numeri sbagliato");
                    datiValidi=false;
                }
                
                    
            } while (datiValidi);
                
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
                    if(num2==0){
                        out.println("ERR-0:divided_by_zero");
                        break;
                    }else{
                        ris=num1/num2;
                    }
                    break;
                case "exit":
                    System.out.println("Disconnesso");
                    var=false;
                    break;
                default:
                    break;
            }
            out.println("Risposta: " + ris);
        }

    }
}