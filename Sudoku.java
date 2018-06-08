public class Sudoku{
    
    private Cell[][] s;
    
    public Sudoku(){
	s = new Cell[9][9];
	for (int a = 0; a < 18; a++){
	    s[(int)(Math.random() * 9)][(int)(Math.random() * 9)] = new Cell((int)(Math.random() * 8) + 1);
	}
    }
    
    public boolean checkRow(int r){
	int[] row = new int[9];
	for (int c = 0; c < 9; c++)
	    row[c] = s[r][c].getValue();
	for (int x = 0; x < 8; x++){
	    for (int y = x; y < row.length; y++){
		if (row[x] != 0 && row[y] != 0 && row[x] == row[y])
		    return false;
	    }
	}
	return true;
    }
    
    public boolean checkCol(int c){
	int[] col = new int[9];
	for (int r = 0; r < 9; r++)
	    col[r] = s[r][c].getValue();
	for (int x = 0; x < 8; x++){
	    for (int y = x; y < col.length; y++){
		if (col[x] != 0 && col[y] != 0 && col[x] == col[y])
		    return false;
	    }
	}
	return true;
    }
    
    public boolean checkSquare(int r, int c){
	int[] sqr = new int[9];
	if (r >= 0 && r <= 2 && c >= 0 && c <= 2){
	    int i = 0;
	    for (int x = 0; x < 3; x++){
		for (int y = 0; y < 3; y++){
		    sqr[i] = s[x][y].getValue();
		    i++;
		}
	    }
	}
	if (r >= 3 && r <= 5 && c >= 0 && c <= 2){
	    int i = 0;
	    for (int x = 3; x < 6; x++){
		for (int y = 0; y < 3; y++){
		    sqr[i] = s[x][y].getValue();
		    i++;
		}
	    }
	}
	if (r >= 6 && r <= 8 && c >= 0 && c <= 2){
	    int i = 0;
	    for (int x = 6; x < 9; x++){
		for (int y = 0; y < 3; y++){
		    sqr[i] = s[x][y].getValue();
		    i++;
		}
	    }
	}
	if (r >= 0 && r <= 2 && c >= 3 && c <= 5){
	    int i = 0;
	    for (int x = 0; x < 3; x++){
		for (int y = 3; y < 6; y++){
		    sqr[i] = s[x][y].getValue();
		    i++;
		}
	    }
	}
	if (r >= 3 && r <= 5 && c >= 3 && c <= 5){
	    int i = 0;
	    for (int x = 3; x < 6; x++){
		for (int y = 3; y < 6; y++){
		    sqr[i] = s[x][y].getValue();
		    i++;
		}
	    }
	}
	if (r >= 6 && r <= 8 && c >= 3 && c <= 5){
	    int i = 0;
	    for (int x = 6; x < 9; x++){
		for (int y = 3; y < 6; y++){
		    sqr[i] = s[x][y].getValue();
		    i++;
		}
	    }
	}
	if (r >= 0 && r <= 2 && c >= 6 && c <= 8){
	    int i = 0;
	    for (int x = 0; x < 3; x++){
		for (int y = 6; y < 9; y++){
		    sqr[i] = s[x][y].getValue();
		    i++;
		}
	    }
	}
	if (r >= 3 && r <= 5 && c >= 6 && c <= 8){
	    int i = 0;
	    for (int x = 3; x < 6; x++){
		for (int y = 6; y < 9; y++){
		    sqr[i] = s[x][y].getValue();
		    i++;
		}
	    }
	}
	if (r >= 6 && r <= 8 && c >= 6 && c <= 8){
	    int i = 0;
	    for (int x = 6; x < 9; x++){
		for (int y = 6; y < 9; y++){
		    sqr[i] = s[x][y].getValue();
		    i++;
		}
	    }
	}
	for (int j = 0; j < 8; j++){
	    for (int k = j; k < sqr.length; k++){
		if (sqr[j] != 0 && sqr[k] != 0 && sqr[j] == sqr[k])
		    return false;
	    }
	}
	return true;
    }
    
    public boolean isFilled(){
	for (int r = 0; r < 9; r++){
	    for (int c = 0; c < 9; c++){
		if (s[r][c].getValue() == 0)
		    return false;
	    }
	}
	return true;
    }
        
    public boolean solve(){
	return solveH(0);
    }

    private boolean solveH(int c){
	for (int r = 0; r < s.length; r++){
	    addValue(r,c);
	    if ( c == s.length-1 ) { 
		return true;
	    }
	    else if ( solveH(c + 1) ) {
		return true;
	    }
	    else { 
		removeValue(r,c);
	    }
	}
	return false;
    }
    
    private boolean addValue( int r, int c){
	if (s[r][c].originalValue())
	    return false;
	while ((!checkRow(r) || !checkCol(c) || !checkSquare(r, c)) && s[r][c].getValue() < 9)
	    s[r][c].setValue(s[r][c].getValue() + 1);
	if (checkRow(r) && checkCol(c) && checkSquare(r, c))
	    return true;
    }
    
    private boolean removeValue(int r, int c){
	if (s[r][c].getValue() == 0)
	    return false;
	s[r][c].setValue(0);
	return true;
    }
}