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
    private int playerplaying = 1, hangingStage = 0;

    private Scanner scanner = new Scanner(System.in);
    /**     play()
     * the main controller of the game.
     *
     * */
    public void play(){
        printHeader();
        userWordInput();
        switchTurn();
        getuserinput();
        reset();
    }

    /**     getuserinput()
     * gets the user input for guessing the word
     *  this function regulates the whole guess part of the game
     *
     * */
    private void getuserinput(){
        String input;
        if(1 == playerplaying){
            playerplaying = 2;
        }else{
            playerplaying = 1;
        }
        while(true){
            if(hangingStage<9) {
                printHangman(hangingStage);
                System.out.println(getUserGuess());
                System.out.print(((playerplaying == 1) ? player_1 : player_2));
                System.out.println(" enter your guess for the word:");
                input = scanner.nextLine();

                if ((input.length() == 1)) {
                    if (checkIfInWord(input.charAt(0))) {
                        if (checkWin()) {
                            break;
                        } else {
                            System.out.println("That character is in the word");
                        }

                    } else {
                        hangingStage++;

                    }
                } else {
                    if (checkword(input)) {
                        if (checkWin()) {
                            break;
                        } else {
                            hangingStage++;
                        }

                    } else {
                        hangingStage++;
                    }

                }
            }else{
                System.out.print(((playerplaying == 1) ? player_1 : player_2));
                System.out.println(" looses this game better luck next time\n");
                break;
            }

        }
    }

    /**     userWordInput()
     * asks the user for an word checks for valid input and stores it in the global variable
     *
     * */
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

    /**     checkword()
     * checks if the string inputted is the words that needs
     * to be guessed
     *
     * @param input the string entered by the user that needs to be checked
     *
     * @return true or false depending if string is the same
     *
     * */
    private boolean checkword(String input){
        if(input.equals(charArrayToString(word))){
            userGuess = input.toCharArray();
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

    /**     checkIfInWord()
     * checks is the char is in the word
     *
     * @param input char that needs to be checked
     *
     * @return true if the character is in word else false
     *
     * */
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
        return foundChars > 0;
    }

    /**     reset()
     * resets the global variables
     *
     * */
    private void reset(){
        hangingStage = 0;
        //switchTurn();
        word = "".toCharArray();
        userGuess = "".toCharArray();
    }

    /**     switchTurn()
     * Switches the user that is playing
     *
     * */
    private void switchTurn(){
        playerplaying = ((playerplaying == 1) ? 2 : 1);
    }

    /**     checkWin()
     * checks if the win condition is met
     *
     * @return true if win condition is met else false
     *
     * */
    private boolean checkWin(){
        String wordToGuess, guess;
        wordToGuess = charArrayToString(word);
        guess = charArrayToString(userGuess);
        if(wordToGuess.equals(guess)){
            System.out.println("winner winner chicken dinner!!");
            System.out.print(((playerplaying == 1)? player_1: player_2));
            System.out.println(" you win!\n\n");
            return true;
        }
        else return false;
    }

    /**     charArrayToString()
     * converts chararray to string.
     *
     * @param input the char array that needs to be converted
     *
     * @return the String with the current progress for the word.
     *
     * */
    private String charArrayToString(char[] input){
        String output = "";
        for (int i = 0; i < input.length; i++) {
            output += input[i];
        }
        return output;
    }

    /**     printHeader()
     * prints the header of the game
     *
     * */
    private void printHeader(){
        System.out.println("    __                                          ");
        System.out.println("   / /_  ____ _____  ____ _____ ___  ____ _____ ");
        System.out.println("  / __ \\/ __ `/ __ \\/ __ `/ __ `__ \\/ __ `/ __ \\");
        System.out.println(" / / / / /_/ / / / / /_/ / / / / / / /_/ / / / /");
        System.out.println("/_/ /_/\\__,_/_/ /_/\\__, /_/ /_/ /_/\\__,_/_/ /_/ ");
        System.out.println("                  /____/                        \n");
    }

    /**     printHangman()
     * Prints the current stage of the hangman game
     *
     * @param stage the current stage of the game
     *
     * */
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

    /**     setPlayer_1()
     * sets the name value of player_1
     * @param player_1 the Sting that needs to be set for player 1
     *
     * */
    protected void setPlayer_1(String player_1) {
        this.player_1 = player_1;
    }

    /**     setPlayer_2()
     * sets the name value of player_2
     * @param player_2 the Sting that needs to be set for player 2
     *
     * */
    protected void setPlayer_2(String player_2) {
        this.player_2 = player_2;
    }
}
