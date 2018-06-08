public class Cell{
    private int value;
    private boolean original;
    public Cell() {
	value = 0;
	original = false;
    }
    public Cell(int newVal){
	value = newVal;
	original = true;
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
