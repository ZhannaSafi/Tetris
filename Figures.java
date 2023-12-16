public class Figures extends Field {
    public static char object = '#';

    public static char[][] figuresField = new char[size][size];

    public static void figureFieldInitialization() {
        for (int i = 0; i < Figures.figuresField.length; i++) {
            for (int j = 0; j < Figures.figuresField.length; j++) {
                figuresField[i][j] = space;
            }
        }
    }

    public static void objectA() {

        figuresField[0][0] = object;
        figuresField[0][1] = object;
        figuresField[1][0] = object;
        figuresField[1][1] = object;

        FieldAndObjectSynchronization();
    }

    public static void objectB() {

        figuresField[0][3] = object;
        figuresField[1][3] = object;
        figuresField[2][3] = object;
        figuresField[3][3] = object;

        FieldAndObjectSynchronization();
    }

    public static void objectC() {

        figuresField[0][4] = object;
        figuresField[1][4] = object;
        figuresField[2][4] = object;
        figuresField[2][5] = object;

        FieldAndObjectSynchronization();
    }

    public static void FieldAndObjectSynchronization() {
        fieldInitialization();
        for (int i = 0; i < figuresField.length; i++) {
            for (int j = 0; j < figuresField.length; j++) {
                if (figuresField[i][j] == object) {
                    field[i][j] = object;
                }
            }
        }
    }
}
