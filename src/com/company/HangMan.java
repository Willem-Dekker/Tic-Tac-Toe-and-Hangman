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

    private String player_1 , player_2; //variables for storing the players names
    private int playerplaying = 1, playedTurns = 0, wordlength = 0, hangingStage = 0;

    Scanner scanner = new Scanner(System.in);

    public void play(){
        printheader();
        for (int i = 0; i <10 ; i++) {
            printHangman(i);
        }
    }

    private void getuserinput(){
        String input;
        while(true){
            System.out.println("Enter your guess for the word:");
            input = scanner.next();
            if ((input.length() > 1)) {
                if(checkword(input)){
                    return;
                }
            } else {
                if(checkIfInWord(input)){
                    return;
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

    private boolean checkword(String input){
        if(input.equals(word)){
            return true;
        }else{
            return false;
        }

    }

    private boolean checkIfInWord(String input){
        int foundChars = 0;

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

}
