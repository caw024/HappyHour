public class Sudoku{
    
    private Square[][] s;
    
    public Sudoku(){
	s = new Square[3][3];
    }
    
    public boolean checkRow(int r){
	int[] row = new int[9];
	int[] row2 = new int[3];
	int a = 0;
	for (int c = 0; c < 3; c++){
	    row2 = s[r][c].getRow(r);
	    for (int i: row2){
		row[a] = i;
		a++;
	    }
	}
	for (int x = 0; x < 8; x++){
	    for (int y = x; y < row.length; y++){
		if (row[x] == row[y])
		    return false;
	    }
	}
	return true;
    }
    
    public boolean checkCol(int c){
	int[] col = new int[9];
	int[] col2 = new int[3];
	int a = 0;
	for (int r = 0; r < 3; r++){
	    col2 = s[r][c].getCol(c);
	    for (int i: col2){
		col[a] = i;
		a++;
	    }
	}
	for (int x = 0; x < 8; x++){
	    for (int y = x; y < col.length; y++){
		if (col[x] == col[y])
		    return false;
	    }
	}
	return true;
    }
    
    public boolean checkSquare(int r, int c){
	return s[r][c].isValid();
    }
    
    public boolean isFilled(){
	for (int r = 0; r < 3; r++){
	    for (int c = 0; c < 3; c++){
		if(checkCol(c) == false)
		    return false;
		if (checkSquare(r, c) == false)
		    return false;
	    }
	    if (checkRow(r) == false)
		return false;
	}
	return true;
    }
    
    public void setOriginal(){
	for (Square[] a: s){
	    for (Square b: Square[] a){
		b.setOriginal();
	    }
	}
    }
    
}
