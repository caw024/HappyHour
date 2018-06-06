public class Cell{
    private int value;
    private boolean original;
    public Cell() {
	value = 0;
	original = false;
    }
    public int getValue(){
	if (value != 0)
	    return value;
	return value;
    }
    public void setValue(int input){
	value = input;
    }
    public void setOriginal(){
	if (value != 0)
	    original = true;
	else
	    original = false;
    }
    public boolean originalSquare(){
	return original;
    }
}
