public class Cell{
    private int value;
    private boolean original;
    
    public Cell(int newVal){
	value = newVal;
	if (value != 0) {
	    original = true;
	}
	else {
	    original = false;
	}
    }
    public int getValue(){
	// returns value of the cell
	return value;
    }
    public void setValue(int input){
	// changes value of the cell
	if (!originalSquare())
	    value = input;
    }
    public boolean originalSquare(){
	// checks if cell was a given value
	return original;
    }
}
