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
        if (r == 1) {
            System.out.println("Игрок против компьютера. Let Skynet be true!!!");
            System.out.println("");

            Pve Game1 = new Pve();
            Game1.initMap();
            Game1.printMap();
            // Game1.checkWin() = char ox;
            Game1.isMapFull();
            Game1.humanTurn();
            Game1.aiTurn();
            Game1.theGame();
            // Game1.isCellEmpty();

//            public static boolean isCellEmpty(int x, int y) {
//                ;
//                if (x < 0 || x>2 ||y<0 || y>2) return false;
//                if (map[y][x] != '*') return false;
//                return true;
//            }

        } else if (r == 2) {
            System.out.println("Игрок против игрока. Разбейте друг другу лица");
            Pvp Game2 = new Pvp();
            Game2.initMap();
            Game2.printMap();
            // Game2.checkWin() = char ox;
            Game2.isMapFull();
            Game2.humanTurn1();
            Game2.humanTurn2();
            Game2.theGame2();
            // Game1.isCellEmpty();
        } else {
            System.out.println("Запустите программу заново и введите 1 или 2 !!!");
        }
    }
}


