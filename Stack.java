public class Stack {
    // счетчик количства баллов
    public static int bonuses = 0;

    // указатель на столкновение фигуры со стеком (выше ряда 9)
    public static boolean stop = false;

    // При заполнении стека гейм овер
    public static boolean gameOver = false;

    // массив элементов стека
    public static char[][] stackField = new char[Field.size][Field.size];


    // фигура доходит до "низа"
    public static void addToStack() {
        for (int i = 0; i < Figures.figuresField.length; i++) {
            for (int j = 0; j < Figures.figuresField.length; j++) {
                if (Figures.figuresField[9][j] == Figures.object) {
                    for (int x = 0; x < Figures.figuresField.length; x++) {
                        for (int y = 0; y < Figures.figuresField.length; y++) {
                            if (Figures.figuresField[i][j] == Figures.object) {
                                stackField[i][j] = Field.stack;
                            }
                        }
                    }
                }
            }
        }

        // удаление предыдущей фигуры
        Figures.figureFieldInitialization();

        // Вывод следующей фигуры при помощи ротации
        figuresRandom();
    }

    public static void figuresRandom() {
        int numberOfObject = (int) (Math.random() * 3 + 1);
        if (numberOfObject == 1) Figures.objectA();
        if (numberOfObject == 2) Figures.objectB();
        if (numberOfObject == 3) Figures.objectC();
    }

    public static void stackLineClear() {
        // удаление заполненной линии в стеке
        for (int i = stackField.length - 1; i >= 0; i--) {
            if (stackField[i][0] == Field.stack && stackField[i][1] == Field.stack &&
                    stackField[i][2] == Field.stack && stackField[i][3] == Field.stack &&
                    stackField[i][4] == Field.stack && stackField[i][5] == Field.stack &&
                    stackField[i][6] == Field.stack && stackField[i][7] == Field.stack &&
                    stackField[i][8] == Field.stack && stackField[i][9] == Field.stack) {

                stackField[i][0] = Field.space;
                stackField[i][1] = Field.space;
                stackField[i][2] = Field.space;
                stackField[i][3] = Field.space;
                stackField[i][4] = Field.space;
                stackField[i][5] = Field.space;
                stackField[i][6] = Field.space;
                stackField[i][7] = Field.space;
                stackField[i][8] = Field.space;
                stackField[i][9] = Field.space;

                for (int x = 0; x <= i; x++) {
                    for (int y = 0; y < stackField.length; y++) {
                        if (stackField[x][y] == Figures.object) {
                            stackField[x][y] = stackField[x - 1][y];
                        }
                    }
                }

                bonuses++;
                System.out.println("You have " + bonuses + " bonuses!");

            }
        }
    }

    public static void hitDownStack(int row, int col) {
        // тут код который отслеживает столкновение фигур со стеком и превращает их в часть стека
        int nextRow = row + 1;

        if (stackField[nextRow][col] == Field.stack) {
            stop = true;
            System.out.println("BOOM!");
        }
    } // hitDowStak(int row, int col)

    // добавление к стеку фигур стокнувшихся с фигурами ранее уже добавленными в стек
    public static void moveToStack() {
        for (int i = 0; i < Figures.figuresField.length; i++) {
            for (int j = 0; j < Figures.figuresField.length; j++) {
                if (Figures.figuresField[i][j] == Figures.object) {
                    Stack.stackField[i][j] = Field.stack;
                }
            }
        }

        // удаление предыдущей фигуры
        Figures.figureFieldInitialization();

        // Вывод следующей фигуры при помощи ротации
        figuresRandom();


    }

    public static void gameOver() {

        boolean allMatch = false;
        for (int col = 0; col < Stack.stackField[0].length; col++) {  // перебираем по колонкам
            boolean columnMatch = true;
            for (int row = 0; row < Stack.stackField.length; row++) {  // перебираем по строкам
                if (Stack.stackField[row][col] != Field.stack) {
                    columnMatch = false;
                    break;
                }
            }
            if (columnMatch) {
                allMatch = true;
                System.out.println("GAME OVER! STACK FULL.");
            }
        }
        if (allMatch) {
            gameOver = true;
        }
    }
}
