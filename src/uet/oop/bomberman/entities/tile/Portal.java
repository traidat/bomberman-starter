package uet.oop.bomberman.entities.tile;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.sound.Sound;

public class Portal extends Tile {
    Board _board;

	public Portal(int x, int y, Sprite sprite) {
		super(x, y, sprite);
	}
        public Portal (int x, int y, Sprite sprite, Board board) {
            super(x, y, sprite);
            this._board = board;
        }
	
	@Override
	public boolean collide(Entity e) {
		// TODO: xử lý khi Bomber đi vào
                if (e instanceof Bomber == true && _board.detectNoEnemies() == true) {
                    Sound music = new Sound();
                    music.portal().start();
                    if (Game.getBombRadius() != 1) {
                        Game.addBombRadius(-1);
                    }
                    if (Game.getBombRate() != 1) {
                        Game.addBombRate(-1);
                    }
                    if (Game.getBomberSpeed() != 1.0) {
                        Game.addBomberSpeed(-1.0);
                    }
                    _board.nextLevel();
                    
                }
		return false;
	}

}
