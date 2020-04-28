package wooteco.chess.domain.move.direction;

import wooteco.chess.domain.position.Position;
import wooteco.chess.domain.position.Positions;

import java.util.ArrayList;
import java.util.List;

public class UpStrategy implements DirectionStrategy {
    @Override
    public List<Position> findPath(Position source, Position target) {
        List<Position> path = new ArrayList<>();

        for (int i = target.getRank() - 1; i > source.getRank(); i--) {
            path.add(Positions.of(source.getFile(), i));
        }
        return path;
    }
}