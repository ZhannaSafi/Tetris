public class Field {
    public static int size = 10;
    public static int row;
    public static int col;
    public static char space = '_';
    public static char stack = '*';

    public static char[][] field = new char[size][size];

    public static void fieldInitialization() {
        System.out.println();
        System.out.println("STEP-TETRIS");
        System.out.println();
        for (row = 0; row < size; row++) {
            for (col = 0; col < size; col++) {
                field[row][col] = space;
            }
        }
        for (int i = 0; i < Stack.stackField.length; i++) {
            for (int j = 0; j < Stack.stackField.length; j++) {
                if (Stack.stackField[i][j] == stack) {
                    field[i][j] = Stack.stackField[i][j];
                }
            }
        }
    }

    public static void fieldPrint() {
        for (row = 0; row < size; row++) {
            for (col = 0; col < size; col++) {
                System.out.print(" " + field[row][col] + " ");
            }
            System.out.println();
        }
    }
}
