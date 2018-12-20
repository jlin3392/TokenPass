public class TokenPass {

    int playerCount;
    int currentPlayer;
    int nextPlayer;
    int numToDistribute;

    int[] board = new int[playerCount];

    public TokenPass(int playerCount) {
        this.playerCount = playerCount;
        board = new int[playerCount];
        for (int i = 0; i < playerCount; i++) {
            board[i] = 1 + (int) (Math.random() * 10);
        }
        currentPlayer = (int)(playerCount * Math.random());
    }

    public void distributeCurrentPlayerTokens() {
        nextPlayer = currentPlayer;
        numToDistribute = board[currentPlayer];
        board[currentPlayer] = 0;

        while (numToDistribute > 0) {
            nextPlayer = (nextPlayer + 1) % board.length;
            board[nextPlayer]++;
            numToDistribute--;
        }
    }

    public int nextPlayer() {
        if (currentPlayer > playerCount) {
            currentPlayer = 1;
        }

        return currentPlayer;
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.println("Player " + (i+1) + ": " + board[i]);
        }
    }

    public int gameOver() {
        for (int i = 0; i < board.length; i++) {
            if (board[i] == 0) {
                return currentPlayer;
            }
        }

        return 0;
    }

}
