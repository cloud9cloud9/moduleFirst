package ua.nalezhytyi.moduleFirst;

import java.util.Arrays;
import java.util.Scanner;

public class ModuleFirstTheSecondTask {
    //22   Ход коня по шахматной доске. Вводится текущее положение
    // коня и клетка в которую пробуют его передвинуть за 1 ход.
    // Программа должна проверить, возможно ли это сделать.
    public static void main(String[] args) {
        int rows = 8;
        int columns = 8;
        String[][] chessboard = genChessboard(rows, columns);
        nextStr(chessboard);
        Scanner scannerStartPosition = new Scanner(System.in);
        Scanner scannerNextPosition = new Scanner(System.in);
        Scanner scannerContinue = new Scanner(System.in);
        while (true) { // Безкінечний цикл для продовження виконання
            nextStr(chessboard);
            System.out.println("Введіть значення положення коня у форматі 'A-H' + '1-8' (C5, F4): ");
            String startingPosition = scannerStartPosition.nextLine();
            if (!isCellExists(chessboard, startingPosition)) {
                System.out.println("Такої клітинки на дошці не існує. Спробуйте ще раз.");
                continue;
            }
            System.out.println("Введіть значення клітинки, куди ви бажаєте походити: ");
            String theNextPosition = scannerNextPosition.nextLine();
            boolean isMoveHorse = isRightMove(startingPosition, theNextPosition);

            if (isMoveHorse) {
                System.out.println("Кінь може сюди походити.");
            } else {
                System.out.println("Кінь не може сюди походити.");
            }

            System.out.println("Бажаєте продовжити? (yes/no)");
            String continueInput = scannerContinue.nextLine().toLowerCase();

            if (!continueInput.equals("yes")) {
                break; // Вийти з циклу, якщо користувач вибрав "ні"
            }
        }
    }

    public static String[][] genChessboard(int rows, int columns) {
        String[][] chessboard = new String[rows][columns];
        char theLetterForChessBoard = 'A';
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                chessboard[i][j] = String.valueOf(theLetterForChessBoard) + (i + 1);
                theLetterForChessBoard++;
            }
            theLetterForChessBoard = 'A';
        }
        return chessboard;
    }

    public static void nextStr(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean isCellExists(String[][] board, String cell) {
        String letter = cell.substring(0, 1);
        int number = Integer.parseInt(cell.substring(1));
        int col = letter.charAt(0) - 'A';
        int row = 8 - number;
        if (col >= 0 && col < 8 && row >= 0 && row < 8) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isRightMove(String startCell, String endCell) {
        char startX = startCell.charAt(0);
        char startY = startCell.charAt(1);
        char endX = endCell.charAt(0);
        char endY = endCell.charAt(1);
        int deltaX = Math.abs(endX - startX);
        int deltaY = Math.abs(endY - startY);
        // Перевірка, чи рух конем  є можливим (L-подібний хід).
        return (deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2);
    }
}
