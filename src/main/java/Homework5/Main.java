package Homework5;

public class Main {
    public static void main(String[] args) {
        System.out.println(powRecursive(5, 4));

    }

    public static int powRecursive(int value, int power) {
        if (power > 1) {
            return value * powRecursive(value, power - 1);
        }
        return value;
    }

    public static void chessHorseRecursive(int[][] board, int x, int y, int counter) {
        int [] xi = new int[]{1, 1, 2, 2, -1, -1, -2, -2};
        int [] yi = new int[]{2, -2, 1, -1, 2, -2, 1, -1};
        while (hasNulls(board)) {
            //Есть ли ходы в пределах доски на незанятые клетки
            for (int i = 0; i < xi.length; i++) {
                if (x + xi[i] < 8 && y + yi[i] < 8 && x + xi[i] >= 0 && y + yi[i] >= 0){
                    if (board[x + xi[i]][y + yi[i]] == 0) {
                        board[x][y] = counter;
                        chessHorseRecursive(board, x + xi[i], y + yi[i], counter++);
                    }
                }
            }
            //Если нет, то возвращаемся назад и ищем снова не используя эту клетку
            board[x][y] = -1;
            counter--;
            int xBefore = xyBefore(counter, board)[0];
            int yBefore = xyBefore(counter, board)[1];
            for (int i = 0; i < xi.length; i++) {
                if (xBefore + xi[i] < 8 && yBefore + yi[i] < 8 && xBefore + xi[i] >= 0 && yBefore + yi[i] >= 0){
                    if (xBefore + xi[i] != x && yBefore + yi[i] != y) {
                        //Если находим, то переходим на нее
                        board[x][y] = 0;
                        chessHorseRecursive(board, xBefore + xi[i], yBefore + yi[i], counter++);
                    }
                }
            }
            //Если не находим, я не придумал :_)

        }
    }

    public static boolean hasNulls(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int[] xyBefore(int stepBefore, int[][] array) {
        int[] xy = new int[2];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == stepBefore) {
                    xy[0] = j;
                    xy[1] = i;
                    return xy;
                }
            }
        }
        return xy;
    }
}
