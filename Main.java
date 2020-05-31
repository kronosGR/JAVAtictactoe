package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here

        char x = 'X';
        char o = 'O';
        char turn = x;
        boolean error=false;

        Scanner sc = new Scanner(System.in);
        String cells = "         ";

        printTable(cells);

        //get new coordinates
        while (true){
            System.out.print("Enter the coordinates: ");
            String cordString= sc.nextLine();
            //check if number
            if (isNumbers(cordString)){
                String[] coords = cordString.split(" ");
                int cRow = Integer.parseInt(coords[1]);
                int cCol = Integer.parseInt(coords[0]);

                //check if inside 1-3
                if (cRow<4 && cRow>0 &&cCol<4 && cCol>0){
                    String posS = cCol+" "+ cRow;
                    int pos = 0;
                    switch (posS){
                        case "1 3":
                            pos=0;
                            break;
                        case "2 3":
                            pos=1;
                            break;
                        case "3 3":
                            pos=2;
                            break;
                        case "1 2":
                            pos=3;
                            break;
                        case "2 2":
                            pos=4;
                            break;
                        case "3 2":
                            pos=5;
                            break;
                        case "1 1":
                            pos=6;
                            break;
                        case "2 1":
                            pos=7;
                            break;
                        case "3 1":
                            pos=8;
                            break;
                    }

                    char charAtPosition = cells.charAt(pos);
                    if (charAtPosition != 'X' && charAtPosition !='O'){
                        cells = cells.substring(0,pos) + turn + cells.substring(pos+1);
                        if (isWin(turn, cells)){
                            printTable(cells);
                            System.out.println(turn + " wins");
                            break;
                        }
                        else if(!isWin(turn, cells) && !cells.contains(" ")){
                            printTable(cells);
                            System.out.println("Draw");
                            break;
                        }
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        error = true;
                    }

                }else {
                    System.out.println("Coordinates should be from 1 to 3!");
                    error = true;
                }
            } else {
                System.out.println("You should enter numbers!");
                error = true;
            }

            if (error){
                error = false;
            } else{
                printTable(cells);
                turn = changeTurn(turn);
            }


        }

//

    }

    //check if a win
    private static boolean isWin(char XO, String cells){
        if (cells.charAt(0)==XO && cells.charAt(2)==XO && cells.charAt(1)==XO)
            return true;
        else if (cells.charAt(3)==XO && cells.charAt(4)==XO && cells.charAt(5)==XO)
            return true;
        else if (cells.charAt(6)==XO && cells.charAt(7)==XO && cells.charAt(8)==XO)
            return true;
        else if (cells.charAt(0)==XO && cells.charAt(4)==XO && cells.charAt(8)==XO)
            return true;
        else if (cells.charAt(2)==XO && cells.charAt(4)==XO && cells.charAt(6)==XO)
            return true;
        else if (cells.charAt(0)==XO && cells.charAt(3)==XO && cells.charAt(6)==XO)
            return true;
        else if (cells.charAt(1)==XO && cells.charAt(4)==XO && cells.charAt(7)==XO)
            return true;
        else if (cells.charAt(2)==XO && cells.charAt(5)==XO && cells.charAt(8)==XO)
            return true;

        return false;
    }

    //print the talbe
    private static void printTable(String cells){
        System.out.println("---------");
        System.out.print("| ");
        for (int xx=1;xx<=9;++xx){
            System.out.print(cells.charAt(xx-1));
            System.out.print(" ");
            if (xx%3 ==0){
                if (xx%9 !=0)
                    System.out.println("|");
                System.out.print("| ");
            }
        }
        System.out.println();
        System.out.println("---------");
    }

    private  static boolean isNumbers(String cells){
        boolean isNum = true;
        for (int i=0; i<cells.length(); i++){
            if (cells.charAt(i)==' '){

            } else {
                if (Character.isDigit(cells.charAt(i)))
                    isNum = true;
                else
                    return false;

            }
        }
        return  isNum;
    }

    //change the turn
    private static char changeTurn(char turn){
        if (turn == 'X')
            return 'O';
        else
            return 'X';
    }
}
