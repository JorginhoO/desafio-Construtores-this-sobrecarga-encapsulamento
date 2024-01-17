package entities;

import java.util.Scanner;

public class Champion {
    private String name;
    private int life;
    private int attack;
    private int armor;

    public Champion() {
    }

    public Champion(String name, int life, int attack, int armor) {
        this.name = name;
        this.life = life;
        this.attack = attack;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void takeDamage(Champion attacker) {
        int damage = attacker.attack - this.armor;

        // Se o dano for menor ou igual a 0, então pelo menos 1 de vida é perdido
        if (damage <= 0) {
            if (this.life > 0) {
                this.life--; // Reduz a vida em 1, se for maior que 0
            }
        } else {
            this.life -= damage; // Reduz a vida pelo dano, se for maior que 0
        }

        // Garante que a vida não seja menor que 0
        this.life = Math.max(this.life, 0);
    }

    private int calculateDamage(Champion attacker) {
        return attacker.attack - this.armor;
    }

    public String status() {
        if (this.life == 0) {
            return this.name + ": 0 de vida (morreu)";
        } else {
            return this.name + ": " + this.life + " de vida";
        }
    }

    public static Champion createChampion(Scanner sc) {
        System.out.print("Nome: ");
        String name = sc.next();

        System.out.print("Vida inicial: ");
        int initialLife = sc.nextInt();

        System.out.print("Ataque: ");
        int attack = sc.nextInt();

        System.out.print("Armadura: ");
        int armour = sc.nextInt();

        return new Champion(name, initialLife, attack, armour);
    }
}