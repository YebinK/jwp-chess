package wooteco.chess.domain.move;

import wooteco.chess.domain.board.Board;
import wooteco.chess.domain.position.Position;

public class KnightMoveStrategy extends MoveStrategy {
    @Override
    public boolean checkMovement(Position source, Position target, Board board) {

        int fileGap = Math.abs(source.calculateFileGap(target));
        int rankGap = Math.abs(source.calculateRankGap(target));

        return (fileGap == 2 && rankGap == 1) || (fileGap == 1 && rankGap == 2)
                && checkTarget(source, target, board);
    }
}