package uet.oop.bomberman.level;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import uet.oop.bomberman.Board;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.LayeredEntity;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.character.enemy.Balloon;
import uet.oop.bomberman.entities.character.enemy.Oneal;
import uet.oop.bomberman.entities.tile.Grass;
import uet.oop.bomberman.entities.tile.Portal;
import uet.oop.bomberman.entities.tile.Wall;
import uet.oop.bomberman.entities.tile.destroyable.Brick;
import uet.oop.bomberman.entities.tile.item.BombItem;
import uet.oop.bomberman.entities.tile.item.FlameItem;
import uet.oop.bomberman.entities.tile.item.SpeedItem;
import uet.oop.bomberman.exceptions.LoadLevelException;
import uet.oop.bomberman.graphics.Screen;
import uet.oop.bomberman.graphics.Sprite;

public class FileLevelLoader extends LevelLoader {

	/**
	 * Ma trận chứa thông tin bản đồ, mỗi phần tử lưu giá trị kí tự đ�?c được
	 * từ ma trận bản đồ trong tệp cấu hình
	 */
	private static char[][] _map;
	
	public FileLevelLoader(Board board, int level) throws LoadLevelException {
		super(board, level);
	}
	
	@Override
	public void loadLevel(int level) throws LoadLevelException {
		// TODO: đ�?c dữ liệu từ tệp cấu hình /levels/Level{level}.txt
		// TODO: cập nhật các giá trị đ�?c được vào _width, _height, _level, _map
                try {
                    InputStream ip = FileLevelLoader.class.getResourceAsStream("/levels/Level"+ level + ".txt");
                    BufferedReader br = new BufferedReader(new InputStreamReader(ip));
                    
                    String f = br.readLine();
                    _level = Integer.parseInt(f.substring(0, 1));
                    _height = Integer.parseInt(f.substring(2, 4));
                    _width = Integer.parseInt(f.substring(5));
                    _map = new char[_height][_width];
                    for (int i = 0; i < _height; i++) {
                        String s = br.readLine();
                        for (int j = 0; j < _width; j++) {
                            _map[i][j] = s.charAt(j);
                        }
                        
                    }
                }
                catch (Exception e) {
                    throw new LoadLevelException("Error loading level " + level);
                }
                
	}

	@Override
	public void createEntities() {
		// TODO: tạo các Entity của màn chơi
		// TODO: sau khi tạo xong, g�?i _board.addEntity() để thêm Entity vào game

		// TODO: phần code mẫu ở dưới để hướng dẫn cách thêm các loại Entity vào game
		// TODO: hãy xóa nó khi hoàn thành chức năng load màn chơi từ tệp cấu hình
		// thêm Wall
                int a=0;
                for(int x = 0; x < _width; x++){
                    for(int y = 0; y < _height; y++){
                        char c = _map[y][x];
			int p = x + y * _width;
			switch (c){
                            case '#':
				_board.addEntity(p, new Wall(x, y, Sprite.wall));
				break;
                            case '*':
				_board.addEntity(p, new LayeredEntity(x, y, new Grass(x, y, Sprite.grass), new Brick(x, y, Sprite.brick)));
				break;
                            case 'x':
				_board.addEntity(p, new LayeredEntity(x, y, new Grass(x ,y, Sprite.grass), new Portal(x, y, Sprite.portal, _board), new Brick(x, y, Sprite.brick)));
				break;
                            case 'p':
				int xBomber = 1, yBomber = 1;
				_board.addCharacter( new Bomber(Coordinates.tileToPixel(xBomber), Coordinates.tileToPixel(yBomber) + Game.TILES_SIZE, _board) );
				Screen.setOffset(0, 0);
				_board.addEntity(xBomber + yBomber * _width, new Grass(xBomber, yBomber, Sprite.grass));
				break;
                            case '1':
				_board.addCharacter( new Balloon(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
				_board.addEntity(p, new Grass(x, y, Sprite.grass));
				break;
                            case '2':
				_board.addCharacter( new Oneal(Coordinates.tileToPixel(x), Coordinates.tileToPixel(y) + Game.TILES_SIZE, _board));
				_board.addEntity(p, new Grass(x, y, Sprite.grass));
				break;
                            case  'b':
				_board.addEntity(p, new LayeredEntity(x, y, new Grass(x ,y, Sprite.grass), new BombItem(x, y, Sprite.powerup_bombs), new Brick(x, y, Sprite.brick)));
				break;
                            case 'f':
				_board.addEntity(p, new LayeredEntity(x, y, new Grass(x ,y, Sprite.grass), new FlameItem(x, y, Sprite.powerup_flames), new Brick(x, y, Sprite.brick)));
				break;
                            case 's':
				_board.addEntity(p, new LayeredEntity(x, y, new Grass(x ,y, Sprite.grass), new SpeedItem(x, y, Sprite.powerup_speed), new Brick(x, y, Sprite.brick)));
				break;
                        default:
				_board.addEntity(p, new Grass(x, y, Sprite.grass) );

			}
                    }
		}
	}
}
