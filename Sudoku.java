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
		if (i == 0)
		    return false;
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
		if (i == 0)
		    return false;
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
	return s[r][c].checkSquare();
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
	
	//prints the current sudoku puzzle
    public String toString() 
    {
	String foo = "\nTic Tac Toe Board:\n    ";
	for (int i = 0; i < size(); i++){
	    foo += i + 1  + " ";
	    if ((i + 1) % 3 == 0)
		foo += "  ";
	}
	
	foo += "\n";
	
	for( int i = 0; i < size(); i++ ) {
	    foo += i+1  + " | ";
	
	    for( int j=0; j < size(); j++ ) {
		foo += _matrix[i][j]; //get(i+1,j+1)
		if ((j+1) % 3 == 0){
		    foo += " |";
		}
		foo += " ";
	    }
	    foo += "\n";
	    if ((i + 1) % 3 == 0)
		foo += "\n";
	}

	if (_final.length == 3){
	    foo += "\nFinal matrix\n";
	    for( int i = 0; i < 3; i++ ) {
		foo += " | ";
	
		for( int j=0; j < 3; j++ ) {
		    foo += _final[i][j] + " "; //get(i+1,j+1)
		}

		foo += "|\n";

	    }
	}

	
	return foo;
    }

    public Square[][] solve(){
	while (!isFilled()){
	    
	}
    }
}
