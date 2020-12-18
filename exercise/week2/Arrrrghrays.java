public class Piece{
	/* two int type array to store longitudes and latitudes individually */
	int longitude;
	int latitude;
	
	/** Create the class with x for longitudes and  y for latidues. */
	public Piece(int x ,int y){
		longitude = x;
		latitude = y;
	}

	/** Map is a square with N*N, hence the N = sqrt(array.legnth) */
	public Piece[ ][ ]   groupByLat ( Piece[ ]   p ){
		int width = (int) Math.sqrt(p.length);
		Piece[ ][ ] lastGroup = new Piece[width][width];
		for(int i = 0; i < width; i++){
			for(int j = 0; j < width; j++){
				if(lastGroup[j][] == ){
					;
					break;
				} 
			}
		} 
	}
}