package wooteco.chess.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import wooteco.chess.domain.piece.Piece;
import wooteco.chess.domain.piece.PieceType;
import wooteco.chess.domain.piece.Team;
import wooteco.chess.domain.position.Positions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ChessRunnerTest {
    ChessRunner chessRunner;

    @BeforeEach
    void setUp() {
        chessRunner = new ChessRunner();
    }

    @DisplayName("현재 순서가 아닐 때 에러 메시지 출력")
    @Test
    void validateCurrentTeam() {
        assertThatThrownBy(() -> chessRunner.updateBoard("a7", "a5")) //블랙 팀 폰 이동
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("현재 차례가 아닙니다.");
    }

    @DisplayName("이동할 수 없는 곳일 때 에러 메시지 출력")
    @Test
    void validateMovable() {
        assertThatThrownBy(() -> chessRunner.updateBoard("a1", "a2")) //화이트 팀 룩 이동
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이동할 수 없는 곳입니다.");
    }

    @DisplayName("말 이동")
    @Test
    void updateBoard() {
        Piece whitePawn = new Piece(PieceType.PAWN, Team.WHITE);
        chessRunner.updateBoard("a2", "a4");

        assertThat(chessRunner.getBoard().getPiece(Positions.of("a4"))).isEqualTo(whitePawn);
    }

    @DisplayName("우승자가 없을 때")
    @Test
    void findWinner() {
        assertThat(chessRunner.findWinner()).isEqualTo(Team.NONE);
    }

    @DisplayName("점수 계산")
    @Test
    void calculateScore() {
        assertThat(chessRunner.calculateScore()).isEqualTo(38.0);
    }
}