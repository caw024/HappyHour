public class Square{
    private Cell[][] s;
    public Square(){
	s = new Cell[3][3];
    }
    public boolean checkSquare(){
	int[] a = new int[9];
	int i = 0;
	for (int r = 0; r < 3; r++){
	    for (int c = 0; c < 3; c++){
		if (s[r][c].getValue() == 0)
		    return false;
		a[i] = s[r][c].getValue();
		i++;
	    }
	}
	for (int x = 0; x < 8; x++){
	    for (int y = x; y < a.length; y++){
		if (a[x] == a[y])
		    return false;
	    }
	}
	return true;
    }
    public int[] getRow(int r){
	int[] row = new int[3];
	for (int c = 0; c < 3; c++){
	    row[c] = s[r][c].getValue();
	}
	return row;
    }
    public int[] getCol(int c){
	int[] col = new int[3];
	for (int r = 0; r < 3; r++){
	    col[r] = s[r][c].getValue();
	}
	return col;
    }
    public void setOriginal(){
	for (Cell[] a: s){
	    for (Cell b: a){
		b.setOriginal();
	    }
	}
    }
}
