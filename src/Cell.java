public class Cell {
	private TileType type;
	private int x;
	private int y;
	
	public Cell(int x, int y) {
	    this.x = x;
	    this.y = y;
		this.type = TileType.EMPTY;
	}
	
	public Cell(int x, int y, TileType type) {
	    this.x = x;
	    this.y = y;
		this.type = type;
	}
	
	public TileType getType() {
	    return this.type;
	}
	
	public int getX() {
	    return this.x;
	}
	
	public int getY() {
	    return this.y;
	}
}
