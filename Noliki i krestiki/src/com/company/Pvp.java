
    package com.company;

import java.util.Random;
import java.util.Scanner;

    public class Pvp {
        private static char[][] map = new char[3][3];
        private static Scanner in = new Scanner (System.in);
        private static Random rand = new Random();
        private static final int CONSTANT_ONE = 1;

        public static void initMap() {

            for (int i = 0; i < 3; i++){
                for(int j =0; j < 3; j++){
                    map[i][j] = '*';
                }
            }
        }
        public static void printMap() {
            System.out.print("Режим Игрок против Игрока. Игрок 1 играет крестиками. Игрок 2 ноликами. Удачи!");
            System.out.println("");
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
        public static void main (String[] args){
            initMap();
            printMap();
            while (true){
                humanTurn1();
                printMap();
                if (checkWin('X')){
                    System.out.println("Победил ИГРОК  1!!!");
                    break;
                }
                if (isMapFull()){
                    System.out.println("Ничья!!!");
                    break;
                }
                humanTurn2();
                printMap();
                if (checkWin('0')){
                    System.out.println("Победил ИГРОК 2!!!");
                    break;
                }
                if (isMapFull()) break;
            }
            int counter1=0, counter2=0;
            if (checkWin('X') ){

                System.out.println("Счётчик побед");
                System.out.println("Игрок 1:" +" " + ++counter1);
            } if (checkWin('0')){
                System.out.println("Счётчик побед");
                System.out.println("Игрок 2:" +" " + ++counter2);
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

        private static void humanTurn1() {
            int x, y;
            do{
                System.out.println("Введите координаты x y");
                x = in.nextInt() - 1;
                y = in.nextInt()- 1;
            } while (!isCellEmpty(x, y));
            map[x][y] = 'X';
        }

        private static void humanTurn2() {
            int x, y;
            do{
                System.out.println("Введите координаты x y");
                x = in.nextInt() -1;
                y = in.nextInt()-1;
            } while (!isCellEmpty(x, y));
            map[x][y] = '0';
        }
        private static boolean isMapFull() {
            for( int i = 0; i<3; i++) {
                for(int j = 0; j<3; j++){
                    if (map[i][j] == '*') return false;
                }
            }
            return true;
        }


        public static boolean isCellEmpty(int x, int y) {
            if (x < 0 || x>2 ||y<0 || y>2) return false;
            if (map[y][x] != '*') return false;
            return true;
        }


}
