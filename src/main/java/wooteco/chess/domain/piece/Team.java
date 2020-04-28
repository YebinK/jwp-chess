package wooteco.chess.domain.piece;

import java.util.function.Function;

public enum Team {
    BLACK(String::toUpperCase),
    WHITE(String::toLowerCase),
    NONE(String::toString);

    private final Function<String, String> expression;

    Team(Function<String, String> expression) {
        this.expression = expression;
    }

    public Team changeTeam() {
        if (this == BLACK) {
            return WHITE;
        }
        return BLACK;
    }

    public String symbolize(final String name) {
        return this.expression.apply(name);
    }

    public boolean isSameTeamWith(Team team) {
        return this == team;
    }

    public boolean isWhite() {
        return this == WHITE;
    }
}
