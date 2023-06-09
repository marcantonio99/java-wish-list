package org.lessons.java.christmas;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WishList {
    private static final String FILE_PATH = "wishlist.txt";
    public static void main(String[] args) {
        ArrayList<String> giftsList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean goAhead = true;
        while (goAhead) {
            System.out.println("Inserisci il nome del regalo: ");
            String gift = scanner.nextLine();
            giftsList.add(gift);

            System.out.println("Lunghezza della lista: " + giftsList.size());

            System.out.println("Vuoi continuare ad aggiungerne? Si/No: ");
            String answare = scanner.nextLine();
            if (answare.equalsIgnoreCase("No")){
                goAhead = false;
            }
        }
        Collections.sort(giftsList);

        System.out.println("Lista dei regali ordinata: ");
        for (String gift : giftsList){
            System.out.println(gift);
        }

        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            for (String gift : giftsList) {
                writer.write(gift + "\n");
            }
            System.out.println("Lista salvata su file.");
        } catch (IOException e) {
            System.out.println("Si è verificato un errore durante il salvataggio su file: " + e.getMessage());
        }

        // Recupero della lista dal file all'avvio successivo del programma
        ArrayList<String> savedList = new ArrayList<>();
        try (FileReader reader = new FileReader(FILE_PATH);
             Scanner fileScanner = new Scanner(reader)) {
            while (fileScanner.hasNextLine()) {
                String gift = fileScanner.nextLine();
                savedList.add(gift);
            }
            System.out.println("Lista recuperata dal file: ");
            for (String gift : savedList) {
                System.out.println(gift);
            }
        } catch (IOException e) {
            System.out.println("Si è verificato un errore durante il recupero del file: " + e.getMessage());
        }
    }
}
