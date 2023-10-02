package com.example.ejemplo;

import java.io.IOException;

public class Exercise1 {
    public static void main(String[] args) {
        /* 
            We use try/catch in our code cuz we have to handle two exceptions: 
            - IOException (Command error)
            - InterruptedException (waitFor() error)
        */
        
        try {
            // Init variables
            String arg = "";

            // First we are checking that the user enter an argument
            if (args.length > 0) {
                arg = args[0];
                System.out.println("Comando usado: " + arg);
            } else {
                System.out.println("Introduce un comando");
                System.exit(2);
            }

            // Create a process and execute the specific command (arg)
            Process comando = Runtime.getRuntime().exec(arg);

            // Save the exitCode
            int exitCode = comando.waitFor();
            System.out.println("Exit code: " + exitCode);

        // Exception IOException
        } catch (IOException e) {
            System.out.println("Error en el comando: " + e.getMessage());

        // Exception InterruptedException
        } catch (InterruptedException e) {
            System.out.println("Error en el waitFor: " + e.getMessage());
        }
    }
}

