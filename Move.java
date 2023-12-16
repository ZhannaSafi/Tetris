import java.util.Scanner;

public class Move {
    static Scanner scanner = new Scanner(System.in);
    public static int control;

    public static void objMove() {
        for (; !Stack.gameOver; ) {
            System.out.print("press 1, 2 or 3 to move object: ");
            control = scanner.nextInt();

            if (control == 1) {
                for (int i = Figures.figuresField.length - 1; i >= 0; i--) {
                    for (int j = 0; j < Figures.figuresField[i].length; j++) {
                        if (Figures.figuresField[i][j] == Figures.object && j > 0) {
                            Figures.figuresField[i][j - 1] = Figures.object;
                            Figures.figuresField[i][j] = Figures.space;
                        }
                    }
                }
            }

            if (control == 2) {
                for (int i = Figures.figuresField.length - 1; i >= 0; i--) {
                    for (int j = Figures.figuresField.length - 1; j >= 0; j--) {
                        if (Figures.figuresField[i][j] == Figures.object) {
                            Stack.hitDownStack(i, j);
                            if (!Stack.stop) {
                                Figures.figuresField[i + 1][j] = Figures.object;
                                Figures.figuresField[i][j] = Figures.space;
                            } else {
                                Stack.moveToStack();
                                Stack.stop = false;
                            }
                        }
                    }
                }
            }

            if (control == 3) {
                for (int i = Figures.figuresField.length - 1; i >= 0; i--) {
                    for (int j = Figures.figuresField.length - 1; j >= 0; j--) {
                        if (Figures.figuresField[i][j] == Figures.object) {
                            Figures.figuresField[i][j + 1] = Figures.object;
                            Figures.figuresField[i][j] = Figures.space;
                        }
                    }
                }
            }

            // действие когда фигура дошла до низа
            for (int i = Figures.figuresField.length - 1; i >= 0; i--) {
                for (int j = Figures.figuresField.length - 1; j >= 0; j--) {
                    if (Figures.figuresField[9][j] == Figures.object) {
                        Stack.addToStack();
                        break;
                    }
                }
            }
            // когда фигура упирается в стек
            Stack.stackLineClear();
            Stack.gameOver();
            Figures.FieldAndObjectSynchronization();
            Field.fieldPrint();
        }
    }
}
