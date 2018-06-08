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
	return value;
    }
    public void setValue(int input){
	if (!originalSquare())
	    value = input;
    }
    public boolean originalSquare(){
	return original;
    }
}
