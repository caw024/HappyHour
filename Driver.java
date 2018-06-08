import cs1.Keyboard;

public class Driver{
    public static void main(String[] args){

	int hi = 0;
	while (true){
	    while (true){
		System.out.println("\nDo you want to play\n\n1: Easy\n2: Hard");
	    
		try{
		    hi = Keyboard.readInt();
		
		    if (hi < 3){
			break;
		    }
		
		    else if (hi > 2){
			throw new IllegalArgumentException("Integer not within range, try again!");
		    }
		}
	
		catch ( Exception e ){}
	    }

	
	    if (hi == 1){
		Sudoku yay = new Sudoku();
		//clear screen using ANSI control code
		System.out.println( "[2J" ); 

		//display board 
		System.out.println( yay );
		int k;
		while (true){
		    yay.solve();
		    System.out.println("What do you want to do next?\n1. Play again\n2. I'm done");
		    try{
			k = Keyboard.readInt();
			if (k == 1){
			    System.out.println( "\nCool!\n" );
			    break;
			}

			if (k == 2){
			    System.out.println( "\nAlright!\n" );
			    return;
			}
			
			else if (k > 3 || k  < 0){
			    throw new IllegalArgumentException("Integer not within range, try again!");
			}
		    }
		    catch ( Exception e ){}
		}
	    }
	    
	    else if (hi == 2){
		Sudoku yay = new Sudoku();
		int m;
		//clear screen using ANSI control code
		System.out.println( "[2J" ); 

		//display board 
		System.out.println( yay );
		while (true){
		    yay.solve();
		    System.out.println("What do you want to do next?\n1. Play again\n2. I'm done");
		    try{
			m = Keyboard.readInt();
			if (m == 1){
			    System.out.println( "\nCool!\n" );
			    break;
			}

			if (m == 2){
			    System.out.println( "\nAlright!\n" );
			    return;

			}
			
			else if (hi > 3 || hi < 0){
			    throw new IllegalArgumentException("Integer not within range, try again!");
			}
		    }
		    catch ( Exception e ){}
		}
	    }
	    
	    else{
		System.out.println("Requires an integer input");
	    }
	}

    }
}
