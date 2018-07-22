package com.company;

import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r;
        System.out.println("Выберите режим игры:");
        System.out.println("Против Компьютера - 1");
        System.out.println("Против Игрока     - 2");
        r = in.nextInt();
        if (r==1) {
            Pve Game = new Pve();
            Game.initMap();
            Game.printMap();



        }
    }
}
