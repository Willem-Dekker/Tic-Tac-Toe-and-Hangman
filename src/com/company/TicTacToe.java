package com.company;

import java.util.Scanner;

/**
 * Created by Willem Spoelstra on 7-9-2017.
     __  ___          __        ____
    /  |/  /___ _____/ /__     / __ )__  ___
   / /|_/ / __ `/ __  / _ \   / __  / / / (_)
  / /  / / /_/ / /_/ /  __/  / /_/ / /_/ /
 /_/  /_/\__,_/\__,_/\___/  /_____/\__, (_)
                                  /____/
  _       ___ ____                  _____                  __     __
 | |     / (_) / /__  ____ ___     / ___/____  ____  ___  / /____/ /__________ _
 | | /| / / / / / _ \/ __ `__ \    \__ \/ __ \/ __ \/ _ \/ / ___/ __/ ___/ __ `/
 | |/ |/ / / / /  __/ / / / / /   ___/ / /_/ / /_/ /  __/ (__  ) /_/ /  / /_/ /
 |__/|__/_/_/_/\___/_/ /_/ /_/   /____/ .___/\____/\___/_/____/\__/_/   \__,_/
                                     /_/

 */

// todo make java docs for the methods
public class TicTacToe {
    private Scanner scanner = new Scanner(System.in);


    private int playerplaying = 1, playedTurns = 0;
    private String player_1 , player_2; //variables for storing the players names
    private String [][] playing_board = new String[][]{
            {"1","2","3"},
            {"4","5","6"},
            {"7","8","9"}
    };
    public TicTacToe(){

    }

    private void print_playing_board(){
        for (int i=0; i < 3; i++ ){
            for (int j = 0; j < 3; j++) {
                System.out.print("[" + playing_board[i][j] + "]" + ((j<2) ? "\t" : "\n" ));
            }
        }
    }

    private boolean check_move(int number){
        if(number>9){
            return false;
        }
        String value = getDataFromCell(number);
        if (value.compareTo("X") == 0 || value.compareTo("0") == 0){
            return false;
        }else{
            return true;
        }
    }

    private void storeMove(int block, int player){
            int x,y;
            x = (block-1)/3;
            y = block-(x*3);
            playing_board[x][y-1] = (player == 1) ? "X" : "0";
    }

    private String getDataFromCell(int number){
        int x,y;
        x = (number-1)/3;
        y = number-(x*3);
        return playing_board[x][y-1];
    }

    private void getUserInput(){
        boolean accepted = false;
        int input;
        while(true){
            if(!accepted){
                System.out.print(((playerplaying == 1)? getPlayer_1(): getPlayer_2()) + "'s turn \n" +
                        "enter your choice:");
                input = scanner.nextInt();
                if(check_move(input)){
                    storeMove(input,playerplaying);
                    playedTurns++;
                    playerplaying = (playerplaying == 1) ? 2 : 1;
                    accepted = true;
                }else{
                    System.out.println("Move not possible");
                }
            }else{
                break;
            }
        }
    }

    private boolean checkWin(){
        String outputRow = "";
        String outputColumn = "";
        for (int j = 0; j < 3 ; j++) {
            for (int i = 0; i < 3; i++) {
                outputRow += playing_board[j][i];
                outputColumn += playing_board[i][j];

            }
            if (outputRow.equals("XXX") || outputRow.equals("000")) {
                print_playing_board();
                System.out.println((outputRow.equals("XXX") ? player_1 : player_2) + " has won!!!!");
                return true;

            }if (outputColumn.equals("XXX") || outputColumn.equals("000")) {
                print_playing_board();
                System.out.println((outputColumn.equals("XXX") ? player_1 : player_2) + " has won!!!!");
                return true;

            }else{
                outputColumn = "";
                outputRow = "";
            }
        }
        String leftToRight = playing_board[0][0] + playing_board[1][1] + playing_board[2][2];
        String rightToLeft = playing_board[2][2] + playing_board[1][1] + playing_board[1][1];
        if (leftToRight.equals("XXX") || leftToRight.equals("000")) {
            print_playing_board();
            System.out.println((leftToRight.equals("XXX") ? player_1 : player_2) + " has won!!!!");
            return true;

        }if (rightToLeft.equals("XXX") || rightToLeft.equals("000")) {
            print_playing_board();
            System.out.println((rightToLeft.equals("XXX") ? player_1 : player_2) + " has won!!!!");
            return true;

        }
        return false;
    }

    private void reset(){
        Integer z = 1;
        playedTurns = 0;
        for (int i=0; i < 3; i++ ){
            for (int j = 0; j < 3; j++) {
                playing_board[i][j] = z.toString();
                z++;
            }
        }

    }

    public void play(){

        printHeader();
        while(true){
            if(!checkWin()){
                print_playing_board();
                getUserInput();
               }else if (playedTurns == 9 && !checkWin()){
                print_playing_board();
                System.out.println("DRAW! try again");
                reset();
                break;
            }else{
                   reset();
                   break;
            }

        }



    }

    private void printHeader() {

        System.out.println("  _______     ______          ______         ");
        System.out.println(" /_  __(_)___/_  __/___ _____/_  __/___  ___ ");
        System.out.println("  / / / / ___// / / __ `/ ___// / / __ \\/ _ \\");
        System.out.println(" / / / / /__ / / / /_/ / /__ / / / /_/ /  __/");
        System.out.println("/_/ /_/\\___//_/  \\__,_/\\___//_/  \\____/\\___/ \n");

    }

    public String getPlayer_1() {
        return player_1;
    }

    public void setPlayer_1(String player_1) {
        this.player_1 = player_1;
    }

    public String getPlayer_2() {
        return player_2;
    }

    public void setPlayer_2(String player_2) {
        this.player_2 = player_2;
    }

}
