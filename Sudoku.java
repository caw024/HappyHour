import java.util.ArrayList;

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

    public ArrayList<Integer> ridShare(int[] keep, ArrayList<integer> edit){
	for (int i = 0; i < keep.length; i++){
	    for (int k = 0; k < edit.size(); k++){
		if (keep[i] == edit.get(k))
			edit.set(k, 0);
	    }
	}
	    	
	for (int i = edit.size() - 1; i >= 0; i--){
	    if (edit.get(i) == 0)
		edit.remove(i);
	}
	return edit;
    }

    public ArrayList<Integer> legalMove(int r, int c){
	ArrayList<Integer> poss = new ArrayList<Integer>();
	poss.add(1);
	poss.add(2);
	poss.add(3);
	poss.add(4);
	poss.add(5);
	poss.add(6);
	poss.add(7);
	poss.add(8);
	poss.add(9);

	poss = ridShare(s.getRow(r), poss);
	poss = ridShare(s.getColumn(c), poss);
	poss = ridShare(s[r][c].getSquare(), poss);

        return poss;
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
	    for (Square b: a){
		b.setOriginal();
	    }
	}
    }
    
    public boolean solve(){
	ArrayList<Integer> poss = new ArrayList<Integer>();
	for (int r = 0; r < 3; r++){
	    for (int c = 0; c < 3; c++){
		poss = legalMove(r,c);
		if (poss.size() == 0){
		    //remove last piece
		}
		else{
		    
		}
		else{
		    
		}
       
	    }
	}
	
    }
}
