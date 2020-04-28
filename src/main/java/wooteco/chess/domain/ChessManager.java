package wooteco.chess.domain;

import wooteco.chess.domain.board.Board;
import wooteco.chess.domain.piece.Team;

public class ChessManager {
    private ChessRunner chessRunner;
    private boolean playing;

    public void start() {
        this.chessRunner = new ChessRunner();
        playing = true;
    }

    public void end() {
        playing = false;
    }

    public void move(String source, String target) {
        chessRunner.updateBoard(source, target);
        playing = hasWinner();
    }

    public void clearBoard() {
        chessRunner.clearBoard();
    }

    public boolean isPlaying() {
        return playing;
    }

    public double calculateScore() {
        return chessRunner.calculateScore();
    }

    public boolean hasWinner() {
        return getWinner() != Team.NONE;
    }

    public Board getBoard() {
        return chessRunner.getBoard();
    }

    public Team getCurrentTeam() {
        return chessRunner.getCurrentTeam();
    }

    public Team getWinner() {
        return chessRunner.findWinner();
    }
}
