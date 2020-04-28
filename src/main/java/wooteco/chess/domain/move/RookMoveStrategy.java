package wooteco.chess.domain.move;

import wooteco.chess.domain.board.Board;
import wooteco.chess.domain.position.Position;

public class RookMoveStrategy extends MoveStrategy {
    @Override
    public boolean checkMovement(Position source, Position target, Board board) {

        int fileGap = Math.abs(source.calculateFileGap(target));
        int rankGap = Math.abs(source.calculateRankGap(target));

        return ((fileGap > 0 && rankGap == 0) || (fileGap == 0 && rankGap > 0))
                && checkObstacle(source, target, board)
                && checkTarget(source, target, board);
    }
}
