package wooteco.chess.domain.move;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wooteco.chess.domain.board.Board;
import wooteco.chess.domain.piece.Piece;
import wooteco.chess.domain.piece.PieceType;
import wooteco.chess.domain.piece.Team;
import wooteco.chess.domain.position.Position;
import wooteco.chess.domain.position.Positions;

import java.util.HashMap;
import java.util.Map;

public class BishopMoveStrategyTest {
    private MoveStrategy bishopStrategy;
    private Board board;

    @BeforeEach
    private void setUp() {
        bishopStrategy = new BishopMoveStrategy();
        Map<Position, Piece> emptyBoard = new HashMap<>();
        board = new Board(emptyBoard);
    }

    @DisplayName("비숍의 우 상단 대각 이동")
    @Test
    void rightUpTest() {
        Position source = Positions.of("a1");
        Position target = Positions.of("e5");

        Assertions.assertThat(bishopStrategy.movable(source, target, board)).isTrue();
    }

    @DisplayName("비숍의 우 하단 대각 이동")
    @Test
    void rightDownTest() {
        Position source = Positions.of("a7");
        Position target = Positions.of("e3");

        Assertions.assertThat(bishopStrategy.movable(source, target, board)).isTrue();
    }

    @DisplayName("비숍의 좌 상단 대각 이동")
    @Test
    void leftUpTest() {
        Position source = Positions.of("g1");
        Position target = Positions.of("c5");

        Assertions.assertThat(bishopStrategy.movable(source, target, board)).isTrue();
    }

    @DisplayName("비숍의 좌 하단 대각 이동")
    @Test
    void leftDownTest() {
        Position source = Positions.of("g7");
        Position target = Positions.of("c3");

        Assertions.assertThat(bishopStrategy.movable(source, target, board)).isTrue();
    }

    @DisplayName("타겟 위치에 적이 있을 때 이동")
    @Test
    void moveWhenEnemyTest() {
        Piece bishop = new Piece(PieceType.BISHOP, Team.BLACK);
        Piece enemy = new Piece(PieceType.PAWN, Team.WHITE);
        Position source = Positions.of("a1");
        Position target = Positions.of("e5");
        Map<Position, Piece> enemyEntry = new HashMap<>();
        enemyEntry.put(source, bishop);
        enemyEntry.put(target, enemy);
        Board enemyBoard = new Board(enemyEntry);

        Assertions.assertThat(bishopStrategy.movable(source, target, enemyBoard)).isTrue();
    }
}
