import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;


public class Sudoku{
    
    private Cell[][] s;
    
    public Sudoku(String inputFile){
	s = new Cell[9][9];


	//transcribe maze from file into memory
	try {
	    Scanner sc = new Scanner( new File(inputFile) );
	    sc.useDelimiter(",");

	    System.out.println( "reading in file..." );

	    int col = 0;
	    String sub;
	    
	    while( sc.hasNext() ) {
		sub = sc.next();
		System.out.print(sub);
		
				
	       	for( int i = 0; i < 9; i++ ){
		    s[i][col] = new Cell(Integer.parseInt(sub));	    
	       	}

		col++;
	    }

	    sc.close();

	}
	catch( Exception e ) {
	    System.out.println();
	}
 
    }
    
    public boolean checkRow(int r){
	// checks if a row is valid - no duplicates or out of range
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
	//chekcs if a column is valid
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
	//checks all 3by3 squares in a sudoku puzzle if valid
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
	// checks if the puzzle is full, no more 0s
	for (int r = 0; r < 9; r++){
	    for (int c = 0; c < 9; c++){
		if (s[r][c].getValue() == 0)
		    return false;
	    }
	}
	return true;
    }
        
    public boolean solve(){
	return solveH(0, 0);
    }

    private boolean solveH(int r, int c){
	//add the next move, if last one then true otherwise, if next can be
	//solved then true, if not solved, then false
	if (c == 0 && r == 0)
	    return false;
	if ( c == 8 && r == 8) { 
	    return true;
	}
	if (c == 8 && s[r][c].originalSquare())
	    return solveH(r+1,0);
	    
	if (s[r][c].originalSquare())
	    return solveH(r,c+1);
	
	if (addValue(r,c).size() > 1){
	    ArrayList<Integer> poss = addValue(r,c);
	    int ret = poss.remove(poss.size() - 1);
	    return testlegit(ret, poss, r, c);
	}
	else {
	    removeValue(r,c);
	    if ( c > 0 ) {
		 removeValue(r, c-1);
	    }
	    else if ( c == 0 ){
		 removeValue(r-1, 8);
	    }
	}
	return false;
	
    }

    public boolean testlegit(int max, ArrayList<Integer> poss, int r, int c){
	s[r][c].setValue(max);
	if (c == 0 && r == 0)
	    return false;
       	if ( c == 8 && r == 8) { 
	    return true;
	}
	if (poss.size() >= 1){
	    if ( c < 8 ) {
		if (solveH(r,c+1) == false){
		    max = poss.remove(poss.size() - 1);
		    return testlegit(max, poss, r, c+1);
		}
	    }
	    else if ( c == 8 ){
		if (solveH(r+1,0) == false){
		    max = poss.remove(poss.size() - 1);
		    return testlegit(max, poss, r+1, 0);
		}
	    }
	}
	return true;
	
    }

    public boolean numinRow(int num, int r){
	int[] row = new int[9];
	for (int c = 0; c < 9; c++)
	    row[c] = s[r][c].getValue();
	for (int x = 0; x < 8; x++){
	    if (row[x] == num){
		return true;
	    }
	}
	return false;
    }
    
    public boolean numinCol(int num, int c){
	int[] col = new int[9];
	for (int r = 0; r < 9; r++)
	    col[r] = s[r][c].getValue();
	for (int x = 0; x < 8; x++){
	    if (col[x] == num){
		return true;
	    }
	}
	return false;
    }
    
    public boolean numinSqr(int num, int r, int c){
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
	    if (sqr[j] == num)
		return true;	    
	}
	return false;
    }

	
    
    public boolean addValueLegal(int num, int r, int c){
	return numinRow(num, r) && numinCol(num,c) && numinSqr(num,r,c);
    }
				 
    
    public ArrayList<Integer> addValue(int r, int c){
	// adds a value not in this square, row or column
	ArrayList<Integer> poss = new ArrayList<Integer>();
	poss.add(0);
        for (int n = 1; n < 9; n++){
	    if (addValueLegal(n,r,c))
		poss.add(n);
	}
	return poss;
    }

    
    public boolean removeValue(int r, int c){
	//sets a value to zero
	if (s[r][c].getValue() == 0)
	    return false;
	if (s[r][c].originalSquare() == true)
	    return false;
	s[r][c].setValue(0);
	return true;
    }

    public String printArr(){
	//send ANSI code "ESC[0;0H" to place cursor in upper left
	System.out.print( "[0;0H") ;  
	//emacs shortcut: C-q, then press ESC
	//emacs shortcut: M-x quoted-insert, then press ESC

	for (int r = 0; r < 9; r++){
	    for (int c = 0; c < 9; c++){
		System.out.print( s[r][c] );
		System.out.print( "  " );
	    }
	    System.out.println();
	}

	return "  ";
    }
}
