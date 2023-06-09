package org.lessons.java.christmas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WishList {
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
    }
}
