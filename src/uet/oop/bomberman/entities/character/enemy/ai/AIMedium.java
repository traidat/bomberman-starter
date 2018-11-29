package uet.oop.bomberman.entities.character.enemy.ai;

import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.character.enemy.Enemy;
import uet.oop.bomberman.graphics.Sprite;
import static uet.oop.bomberman.graphics.Sprite.player_up;

public class AIMedium extends AI {
	Bomber _bomber;
	Enemy _e;
	
	public AIMedium(Bomber bomber, Enemy e) {
		_bomber = bomber;
		_e = e;
	}

	@Override
	public int calculateDirection() {
		// TODO: cài đặt thuật toán tìm đư�?ng đi
                int r = random.nextInt(2);
                if (r == 0) {
                    
                    if (_bomber.getY() > _e.getY()) {
                        return 2;
                    }
                    else if (_bomber.getY() < _e.getY()) {
                        return 0;
                    }
                }
                else {
                    if (_bomber.getX() > _e.getX()) {
                        return 3;
                    }
                    else if (_bomber.getX() > _e.getX()) {
                        return 1;
                    }
                }
		return random.nextInt(4);
	}
}
