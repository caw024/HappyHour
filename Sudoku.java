import java.io.*;
import java.util.*;
import java.util.Scanner;


public class Sudoku{
    
    private Cell[][] s;
    
    public Sudoku(String inputFile){
	s = new Cell[9][9];

	for (int r = 0; r < 9; r++){
	    for (int c = 0; c < 9; c++){
		s[r][c] = new Cell();
	    }
	}

   //transcribe maze from file into memory
    try {
	    Scanner sc = new Scanner( new File(inputFile) );
	    sc.useDelimiter(",");

	    System.out.println( "reading in file..." );

	    int row = 0;

	    while( sc.hasNext() ) {
		System.out.println(sc.next());
		
		String line = sc.nextLine();
		
		for( int i=0; i < line.length(); i++ ){
		    System.out.print("a");
		    /*
		    if (! (Integer.parseInt(sc.next()) == 0) )
			s[i][row] = new Cell(Integer.parseInt(sc.next()));
		    */
		}
		

		row++;
	    }

	    sc.close();

    }
    catch( Exception e ) {
    	System.out.println("File not found");
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
	if (s[r][c].originalSquare())
	    return false;
	while ((!checkRow(r) || !checkCol(c) || !checkSquare(r, c)) && s[r][c].getValue() < 9)
	    s[r][c].setValue(s[r][c].getValue() + 1);
	if (checkRow(r) && checkCol(c) && checkSquare(r, c))
	    return true;
	return false;
    }
    
    private boolean removeValue(int r, int c){
	if (s[r][c].getValue() == 0)
	    return false;
	s[r][c].setValue(0);
	return true;
    }

    public String toString(){
	//send ANSI code "ESC[0;0H" to place cursor in upper left
	String retStr = "[0;0H";  
	//emacs shortcut: C-q, then press ESC
	//emacs shortcut: M-x quoted-insert, then press ESC

	for (int r = 0; r < 9; r++){
	    for (int c = 0; c < 9; c++){
		retStr += Integer.toString(s[r][c].getValue());
		retStr += "   ";
	    }
	    retStr += "\n";
	}

	return retStr;
    }
}
