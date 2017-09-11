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
    private char[]  word ,userGuess;

    private String player_1 , player_2; //variables for storing the players names
    private int playerplaying = 1, playedTurns = 0, hangingStage = 0;

    private Scanner scanner = new Scanner(System.in);

    public void play(){
        printheader();
        userWordInput();
        switchTurn();
        getuserinput();
        reset();
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
            System.out.println(getUserGuess());
            System.out.print(((playerplaying == 1)? player_1: player_2));
            System.out.println(" enter your guess for the word:");
            input = scanner.nextLine();
            if ((input.length() == 1)) {
                if(checkIfInWord(input.charAt(0))){
                    if(checkWin()){
                        break;
                    }else{
                        System.out.println("That character is in the word" );
                    }

                }else{
                    hangingStage++;
                }
            } else {
            //todo add code for whole word entery
            }

        }
    }

    private void userWordInput(){
        while(true) {
            System.out.print(((playerplaying == 1)? player_1: player_2));
            System.out.println(" enter the word to be guessed");
            String input = scanner.nextLine();
            word = input.toCharArray();
            if (input.length() > 1) {
                userGuess = new char[input.length()];
                for (int i = 0; i < input.length() ; i++) {
                    userGuess[i] = '_';
                }
                switchTurn();
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
    /**     getUserGuess()
     * gets the char[] and makes an string with spaces between the chars
     *
     * @return the String with the current progress for the word.
     *
     * */
    public String getUserGuess() {
        String temp = "";
        for (int i = 0; i < userGuess.length ; i++) {
            temp += userGuess[i] + " ";
        }
        return temp;

    }

    private boolean checkIfInWord(char input){
        int foundChars = 0;
        char c;

        for (int i = 0; i < word.length; i++) {
            c = word[i];
            if(c == input){
                foundChars++;
                userGuess[i] = c;
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
        word = "".toCharArray();
        userGuess = "".toCharArray();
    }

    private void switchTurn(){
        playerplaying = ((playerplaying == 1) ? 2 : 1);
    }

    private boolean checkWin(){
        String wordToGuess, guess;
        wordToGuess = charArrayToString(word);
        guess = charArrayToString(userGuess);
        System.out.println("Debug: "+wordToGuess + guess);
        if(wordToGuess.equals(guess)){
            System.out.println("winner winner chicken dinner!!");
            System.out.print(((playerplaying == 1)? player_1: player_2));
            System.out.println(" you win!\n\n");
            switchTurn();
            return true;
        }
        else return false;
    }
    private String charArrayToString(char[] input){
        String output = "";
        for (int i = 0; i < input.length; i++) {
            output += input[i];
        }
        return output;
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
