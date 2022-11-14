package tennis.kata;

public class TennisGame1 implements TennisGame {

    private int pointsPlayer1 = 0;
    private int pointsPlayer2 = 0;
    private String player1Name;
    private String player2Name;

    private String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};
    private String[] tieScores = {"Love-All", "Fifteen-All", "Thirty-All"};

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name) {
            pointsPlayer1 += 1;
            return;
        }

        if (playerName == player2Name) {
            pointsPlayer2 += 1;
        }
    }

    public String getScore() {
        if (isTie()) {
            if (pointsPlayer1 > 2) return "Deuce";

            return tieScores[pointsPlayer1];
        }

        if (onePlayerHasAdvantage()) {
            if (pointsPlayer1AreGreaterThanPointsPlayer2()) return "Advantage player1";

            return "Advantage player2";
        }

        if (onePlayerWins()) {
            if (pointsPlayer1AreGreaterThanPointsPlayer2()) return "Win for player1";

            return "Win for player2";
        }

        return scores[pointsPlayer1]+"-"+scores[pointsPlayer2];
    }

    private boolean pointsPlayer1AreGreaterThanPointsPlayer2() {
        return pointsPlayer1 > pointsPlayer2;
    }

    private boolean isTie() {
        return pointsPlayer1 == pointsPlayer2;
    }

    private boolean onePlayerHasAdvantage() {
        return (onePlayerHasAtLeastFourPoints() && Math.abs(pointsPlayer1 - pointsPlayer2) == 1);
    }

    private boolean onePlayerHasAtLeastFourPoints() {
        return pointsPlayer1 >= 4 || pointsPlayer2 >= 4;
    }

    private boolean onePlayerWins() {
        return (onePlayerHasAtLeastFourPoints() && Math.abs(pointsPlayer1 - pointsPlayer2) > 1);
    }
}
