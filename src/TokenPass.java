public class TokenPass {

    int[] board;
    int playerCount;
    int currentPlayer;

    public TokenPass(int playerCount) {
        this.playerCount = playerCount;
        board = new int[playerCount];
        for (int i = 0; i < playerCount; i++) {
            board[i] = 1 + (int) (Math.random() * 10);
        }
        currentPlayer = (int)(playerCount * Math.random());
    }

    public void distributeCurrentPlayerTokens() {
        int nextPlayer = currentPlayer;
        int numToDistribute = board[currentPlayer];
        board[currentPlayer] = 0;

        while (numToDistribute > 0) {
            nextPlayer = (nextPlayer + 1) % board.length;
            board[nextPlayer]++;
            numToDistribute--;
        }
    }

    public void nextPlayer() {
        currentPlayer++;
        currentPlayer = currentPlayer % playerCount;
    }

    public void printBoard() {

        System.out.println("------------------------");

        for (int i = 0; i < playerCount; i++) {
            System.out.println("Player " + (i) + ": " + board[i] + " tokens.");
        }
    }

    public int gameOver() {

        int n = -1;

        for (int i = 0; i < board.length; i++) {
            if (board[i] == 0) {
                n = i;
            }
        }

        return n;
    }

}
