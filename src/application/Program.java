package application;

import entities.Champion;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite os dados do primeiro campeão:");
        Champion champion1 = Champion.createChampion(sc);
        System.out.println();

        System.out.println("Digite os dados do segundo campeão:");
        Champion champion2 = Champion.createChampion(sc);
        System.out.println();

        System.out.print("Quantos turnos você deseja executar? ");
        int numTurns = sc.nextInt();

        for (int turns = 1; turns <= numTurns && !combatEnded(champion1, champion2); turns++) {
            System.out.println();
            System.out.println("Resualtado do turno " + turns + ":");
            executeTurn(champion1, champion2);
            displayStatus(champion1, champion2);
        }
        System.out.println();
        System.out.println("FIM DO COMBATE");

        sc.close();
    }

    private static void executeTurn(Champion champion1, Champion champion2) {
        champion1.takeDamage(champion2);
        champion2.takeDamage(champion1);
    }

    private static void displayStatus(Champion champion1, Champion champion2) {
        System.out.println(champion1.status());
        System.out.println(champion2.status());
    }

    private static boolean combatEnded(Champion champion1, Champion champion2) {
        return champion1.getLife() == 0 || champion2.getLife() == 0;
    }
}