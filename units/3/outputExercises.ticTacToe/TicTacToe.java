import java.util.InputMismatchException;
import java.util.Scanner;

class TicTacToe {
    private static int WIDTH = 3;
    private static int HEIGHT = 3;
    private static int MIDDLE_X = WIDTH / 2 + 1;
    private static int MIDDLE_Y = WIDTH / 2 + 1;

    private static Integer[] keyIndexMap = { 7, 8, 9, 4, 5, 6, 1, 2, 3 };

    private static Scanner scanner = new Scanner(System.in);

    private CellState[] cells;
    private boolean gameOver = false;
    private boolean wasXTurn = false;

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.start();
    }

    public void start() {
        print();

        while (!gameOver) {
            nextTurn();
            print();
        }
    }

    private void nextTurn() {
        CellState newState = CellState.empty;

        if (wasXTurn) {
            newState = CellState.o;
            wasXTurn = false;
        } else {
            newState = CellState.x;
            wasXTurn = true;
        }

        while (true) {
            // (getInt1To9() - 1) -> for accessing 0-indexed array,
            int keyIndex = getInt1To9(charFromState(newState) + " > ") - 1;

            // the output is -1-ed again to serve as the index for the cells array
            int index = keyIndexMap[keyIndex] - 1;

            if (cells[index] == CellState.empty) {
                cells[index] = newState;
                break;
            } else {
                System.out.println("Invalid! Already occupied!");
            }
        }

        checkWon();
    }

    public void checkWon() {
        for (int x = 0; x < WIDTH; x++) {
            checkDoneInColumn(x);
        }

        for (int y = 0; y < HEIGHT; y++) {
            checkDoneInRow(y);
        }

        checkDoneDiagonal();
        checkBoardFull();
    }

    private void checkDoneInColumn(int x) {
        CellState first = cells[x];

        if (first == CellState.empty) {
            return;
        }

        for (int y = 1; y < HEIGHT; y++) {
            if (cells[y * WIDTH + x] != first) {
                return;
            }
        }

        gameOver = true;
    }

    private void checkDoneInRow(int y) {
        CellState first = cells[y * WIDTH];
        if (first == CellState.empty) {
            return;
        }

        for (int x = 1; x < WIDTH; x++) {
            if (cells[y * WIDTH + x] != first) {
                return;
            }
        }

        gameOver = true;
    }

    private void checkDoneDiagonal() {
        CellState middle = cells[MIDDLE_Y * WIDTH + MIDDLE_X];
        if (middle == CellState.empty) {
            return;
        }
        checkDiagonal1();
        checkDiagonal2();

    }

    private void checkDiagonal1() {
        CellState middle = cells[MIDDLE_Y * WIDTH + MIDDLE_X];

        for (int i = 0; i < WIDTH; i++) {
            if (cells[i * WIDTH + (WIDTH - i - 1)] != middle) {
                return;
            }
        }

        gameOver = true;
    }

    private void checkDiagonal2() {
        CellState middle = cells[MIDDLE_Y * WIDTH + MIDDLE_X];

        for (int i = 0; i < WIDTH; i++) {
            if (cells[i * WIDTH + i] != middle) {
                return;
            }
        }

        gameOver = true;
    }

    private void checkBoardFull() {
        for (int i = 0; i < WIDTH * HEIGHT; i++) {
            if (cells[i] == CellState.empty) {
                return;
            }
        }

        gameOver = true;
    }

    private void print() {
        String row =
            "       |       |       \n" +
            "   %s   |   %s   |   %s   \n" +
            "       |       |       \n";

        String rowSeparator = "------------------------\n"; // one extra -, to match the specs, which are, slightly off

        System.out.printf("\n\n" + row + rowSeparator + row + rowSeparator + row,

                charFromState(cells[0]), charFromState(cells[1]), charFromState(cells[2]), charFromState(cells[3]),
                charFromState(cells[4]), charFromState(cells[5]), charFromState(cells[6]), charFromState(cells[7]),
                charFromState(cells[8]));
    }

    private int getInt1To9() {
        return getInt1To9("> ");
    }

    private int getInt1To9(String prefix) {
        while (true) {
            System.out.print(prefix);

            try {
                int val = scanner.nextInt();
                if (val >= 1 && val <= 9) {
                    return val;
                } else {
                    System.out.println("Invalid! Must be between 1 and 9");
                }
            } catch (InputMismatchException err) {
                System.out.println("Invalid!");
                scanner.nextLine(); // flush
            }
        }
    }

    private TicTacToe() {
        cells = new CellState[HEIGHT * WIDTH];

        for (int i = 0; i < WIDTH * HEIGHT; i++) {
            cells[i] = CellState.empty;
        }
    }

    private char charFromState(CellState state) {
        switch (state) {
            case empty:
                return ' ';
            case x:
                return 'X';
            case o:
                return 'O';
        }

        return '?';
    }
}

enum CellState {
    empty, x, o
};
