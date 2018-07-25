package com.company;

import java.util.Random;
import java.util.Scanner;

public class Pve {
    public static char[][] map = new char[3][3];
    public static Scanner in = new Scanner (System.in);
    public static Random rand = new Random();
    public static final int CONSTANT_ONE = 1;

    public static void initMap() {
        for (int i = 0; i < 3; i++){
            for(int j =0; j < 3; j++){
                map[i][j] = '*';
            }
        }
    }
    public static void printMap() {
        System.out.println("0  1  2  3");
        for(int i = 0; i<3; i++){
            System.out.print((i+1) +"  " );
            for ( int j = 0; j < 3; j++) {
                System.out.print( map[i][j] + "  ");
            }
            System.out.println("");
        }
        System.out.print("");
    }
    public static void theGame (){
        initMap();
        printMap();
        while (true){
            humanTurn();
            printMap();
            if (checkWin('X')){
                System.out.println("Победил ИГРОК!!!");
                break;
            }
            if (isMapFull()){
                System.out.println("Ничья!!!");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin('0')){
                System.out.println("Победил КОМПЬЮТЕР!!!");
                break;
            }
            if (isMapFull()) break;
        }
        int counter1=0, counter2=0;
        if (checkWin('X') ){

            System.out.println("Счётчик побед");
            System.out.println("Игрок :" +" " + ++counter1);
        } if (checkWin('0')){
            System.out.println("Счётчик побед");
            System.out.println("Компьютер:" +" " + ++counter2);
        }
        System.out.println("Game Over");
    }

    public static boolean checkWin (char ox) {
        if (map[0][0]== ox && map[0][1] == ox && map[1][2] == ox) return true;
        if (map[1][0]== ox && map[1][1] == ox && map[1][2] == ox) return true;
        if (map[2][0]== ox && map[2][1] == ox && map[2][2] == ox) return true;

        if (map[0][0]== ox && map[1][0] == ox && map[2][0] == ox) return true;
        if (map[0][1]== ox && map[1][1] == ox && map[2][1] == ox) return true;
        if (map[0][2]== ox && map[1][2] == ox && map[2][2] == ox) return true;

        if (map[0][0]== ox && map[1][1] == ox && map[2][2] == ox) return true;
        if (map[2][0]== ox && map[1][1] == ox && map[0][2] == ox) return true;
        return false;
    }

    public static void humanTurn() {
        int x, y;
        do{
            System.out.println("Введите координаты x y");
            x = in.nextInt() - 1;
            y = in.nextInt() - 1;
//            x--;
//            y--;
        } while (!isCellEmpty(x, y));
        map[x][y] = 'X';
    }

    public static boolean isMapFull() {
        for( int i = 0; i<3; i++) {
            for(int j = 0; j<3; j++){
                if (map[i][j] == '*') return false;
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(3);
            y = rand.nextInt(3);
            // if()
        } while (!isCellEmpty(x,y));
        map[y][x] = '0';
    }
    public static boolean isCellEmpty(int x, int y) {
        ;
        if (x < 0 || x>2 ||y<0 || y>2) return false;
        if (map[y][x] != '*') return false;
        return true;
    }

}

