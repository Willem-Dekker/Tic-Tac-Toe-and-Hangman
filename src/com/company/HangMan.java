package com.company;

import java.util.Scanner;

/**
 * Created by Willem Spoelstra on 8-9-2017.
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
public class HangMan {
    private String  word = "",userGuess = "" ;
//todo word to char[] userGuess to char[]
    //word.toCharArray()
    private String player_1 , player_2; //variables for storing the players names
    private int playerplaying = 1, playedTurns = 0, wordlength = 0, hangingStage = 0;

    private Scanner scanner = new Scanner(System.in);

    public void play(){
        printheader();
        userWordInput();
        printHangman(hangingStage);
        getuserinput();
        for (int i = 0; i <10 ; i++) {
            printHangman(i);
        }
    }

    private void getuserinput(){
        String input;
        if(1 == playerplaying){
            playerplaying = 2;
        }else{
            playerplaying = 1;
        }
        while(true){
            printHangman(hangingStage);
            System.out.println(userGuess);
            System.out.print(((playerplaying == 1)? player_1: player_2));
            System.out.println(" enter your guess for the word:");
            input = scanner.nextLine();
            if ((input.length() == 1)) {
                if(checkIfInWord(input.charAt(0))){
                    hangingStage++;
                    System.out.println("That character is in the word" );
                    //printHangman(hangingStage);
                }
            } else {
                if(checkIfInWord(input.charAt(0))){
                    hangingStage++;
                    //printHangman(hangingStage);
                }
            }

        }
    }

    private void userWordInput(){
        while(true) {
            System.out.println("Enter the word to be guessed");
            String input = scanner.nextLine();
            if (input.length() > 1) {
                for (int i = 0; i < input.length() ; i++) {
                    userGuess += "_";
                }
                break;
            }else{
                System.out.println("ERROR!");
            }
        }
    }
    //todo add fuction for checking the whole word
    private boolean checkword(String input){
        if(input.equals(word)){
            return true;
        }else{
            return false;
        }

    }

    public String getWord() {
        return word;
    }

    private boolean checkIfInWord(char input){
        int foundChars = 0;
        char c;
        for (int i = 0; i < word.length() ; i++) {
            c=word.charAt(i);
            if(c == input){
                foundChars++;
                String temp = userGuess.substring(0,i-1) + c + userGuess.substring(i+1);
                userGuess = temp;
            }
        }
        if(foundChars > 0){
            return true;
        }else {
            return false;
        }
    }

    private void reset(){
        playedTurns = 0;
        hangingStage = 0;
        wordlength = 0;
        word = "";
        userGuess = "";
    }

    private void printheader(){
        System.out.println("    __                                          ");
        System.out.println("   / /_  ____ _____  ____ _____ ___  ____ _____ ");
        System.out.println("  / __ \\/ __ `/ __ \\/ __ `/ __ `__ \\/ __ `/ __ \\");
        System.out.println(" / / / / /_/ / / / / /_/ / / / / / / /_/ / / / /");
        System.out.println("/_/ /_/\\__,_/_/ /_/\\__, /_/ /_/ /_/\\__,_/_/ /_/ ");
        System.out.println("                  /____/                        \n");
    }

    private void printHangman(int stage){
        switch (stage){
            case 0:
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                break;
            case 1:
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("    _|___");
                break;
            case 2:
                System.out.println("");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("    _|___");
                break;
            case 3:
                System.out.println("      _______");
                System.out.println("     |/");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("    _|___");
                break;
            case 4:
                System.out.println("      _______");
                System.out.println("     |/      |");
                System.out.println("     |      (_)");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("    _|___");
                break;
            case 5:
                System.out.println("      _______");
                System.out.println("     |/      |");
                System.out.println("     |      (_)");
                System.out.println("     |       |");
                System.out.println("     |       |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("    _|___");
                break;
            case 6:
                System.out.println("      _______");
                System.out.println("     |/      |");
                System.out.println("     |      (_)");
                System.out.println("     |      \\|");
                System.out.println("     |       |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("    _|___");
                break;
            case 7:
                System.out.println("      _______");
                System.out.println("     |/      |");
                System.out.println("     |      (_)");
                System.out.println("     |      \\|/");
                System.out.println("     |       |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("    _|___");
                break;
            case 8:
                System.out.println("      _______");
                System.out.println("     |/      |");
                System.out.println("     |      (_)");
                System.out.println("     |      \\|/");
                System.out.println("     |       |");
                System.out.println("     |      /");
                System.out.println("     |");
                System.out.println("    _|___");
                break;
            case 9:
                System.out.println("      _______");
                System.out.println("     |/      |");
                System.out.println("     |      (_)");
                System.out.println("     |      \\|/");
                System.out.println("     |       |");
                System.out.println("     |      / \\");
                System.out.println("     |");
                System.out.println("    _|___");
                break;
        }

    }

    public void setPlayer_1(String player_1) {
        this.player_1 = player_1;
    }

    public void setPlayer_2(String player_2) {
        this.player_2 = player_2;
    }
}
