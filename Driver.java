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
		TicTacToe yay = new TicTacToe();
		while (true){
		    yay.setup3();
		    yay.rules3();
		    System.out.print(yay);
		    yay.play3();
		    System.out.println("What do you want to do next?\n1. Play again\n2. I'm done");
		    try{
			hi = Keyboard.readInt();
			if (hi == 1){
			    System.out.println( "\nCool!\n" );
			}

			if (hi == 2){
			    System.out.println( "\nAlright!\n" );
			    String[] c = new String[1];
			    MiniDesktop.main(c);

			}
			
			else if (hi > 3 || hi < 0){
			    throw new IllegalArgumentException("Integer not within range, try again!");
			}
		    }
		    catch ( Exception e ){}
		}
	    }
	    
	    else if (hi == 2){
		TicTacToe yay = new TicTacToe(9);
		while (true){
		    yay.setup9();
		    yay.rules9();
		    System.out.print(yay);
		    yay.play9();
		    System.out.println("What do you want to do next?\n1. Play again\n2. I'm done");
		    try{
			hi = Keyboard.readInt();
			if (hi == 1){
			    System.out.println( "\nCool!\n" );
			}

			if (hi == 2){
			    System.out.println( "\nAlright!\n" );
			    String[] c = new String[1];
			    MiniDesktop.main(c);

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
	Sudoku s = new Sudoku();
	s.solve();
    }
}
