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
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //creating an scanner for reading the input of players.
        String input;
        TicTacToe ticTacToe = new TicTacToe();
        HangMan hangMan = new HangMan();
        boolean setup = true;
        System.out.println(
                "     __  ___          __        ____\n" +
                        "    /  |/  /___ _____/ /__     / __ )__  ___\n" +
                        "   / /|_/ / __ `/ __  / _ \\   / __  / / / (_)\n" +
                        "  / /  / / /_/ / /_/ /  __/  / /_/ / /_/ /\n" +
                        " /_/  /_/\\__,_/\\__,_/\\___/  /_____/\\__, (_)\n" +
                        "                                  /____/\n" +
                        " _       ___ ____                  _____                  __     __\n" +
                        "| |     / (_) / /__  ____ ___     / ___/____  ____  ___  / /____/ /__________ _\n" +
                        "| | /| / / / / / _ \\/ __ `__ \\    \\__ \\/ __ \\/ __ \\/ _ \\/ / ___/ __/ ___/ __ `/\n" +
                        "| |/ |/ / / / /  __/ / / / / /   ___/ / /_/ / /_/ /  __/ (__  ) /_/ /  / /_/ /\n" +
                        "|__/|__/_/_/_/\\___/_/ /_/ /_/   /____/ .___/\\____/\\___/_/____/\\__/_/   \\__,_/\n" +
                        "                                    /_/\n\n");




        while(true){
            if (setup){
                System.out.println("Enter Name of Player 1");
                ticTacToe.setPlayer_1(scanner.nextLine());

                System.out.println("Enter Name of Player 2");
                ticTacToe.setPlayer_2(scanner.nextLine());
                setup = false;
            }else{
                System.out.print("Make an selection\n" +
                        "(T) ->  TicTacToe\n" +
                        "(H) ->  Hangman (Coming Soon!!)\n" +
                        "(Q) ->  Quit\n");
                input = scanner.nextLine();
                if(input.equals("T")||input.equals("t")) {
                    ticTacToe.play();
                }else if(input.equals("H")||input.equals("h")){
                    hangMan.play();
                }else if(input.equals("Q")||input.equals("q")){
                    break;
                }else{
                    System.out.println("Syntax ERROR!!! try again");
                }
            }
        }
    }


}
