class TicTacToe {
    private static int WIDTH = 3;
    private static int HEIGHT = 3;

    private CellState[][] cells;

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();

        ticTacToe.print();
    }

    public void print() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                System.out.print(charFromState(cells[y][x]));
            }

            System.out.print("\n");
        }
    }

    private TicTacToe() {
        cells = new CellState[HEIGHT][];

        for (int i = 0; i < HEIGHT; i++) {
            cells[i] = new CellState[WIDTH];

            for (int j = 0; j < WIDTH; j++) {
                cells[i][j] = CellState.empty;
            }
        }
    }

    private char charFromState(CellState state) {
        switch (state) {
            case empty:
                return ' ';
            case x:
                return 'x';
            case o:
                return 'o';
        }

//         return '-';
    }
}

enum CellState {
    empty, x, o
};
