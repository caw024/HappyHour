# HappyHour
## Calvin Aw, Kendrick Liang and Zane Wang
## APCS1 pd02

### SUDOKU SOLVER

Plan:
We intend to use a sudoku puzzle from online, and make an algorithm to
solve the sudoku puzzle. Because sudoku is a recursive puzzle, the algorithm 
will be relatively straightforward. We will have to account for all the rows,
columns, and 3 by 3 sections of the puzzle.

Project:
Our final project will present to a user a completed sudoku puzzle and 
information on how quickly the puzzle was solved by the computer. The computer
will print out the completed sudoku puzzle and the time taken to complete it.

Algorithm: 
The algorithm for solving the sudoku puzzle we will implement is similar to 
the queen rows algorithm because each row can only have one of each letter,
just like each row on a chess board can only have one queen if you were to try
to place n number of queens on a nxn board. We will be using recursive backtracking
to solve this puzzle.

How to Launch:
- First, either clone or download the root folder. Do this by navigating to the 
repository, then click the clone or download option. Clone by copying the ssh 
link, then opening a terminal session and typing in 
`$ git clone linktorepo@username`.
- Next, in the terminal, you can navigate to the new repository by typing in 
`$ cd pathtorepo`.
- Finally, you type in `$ javac SudokuSolve.java` to compile all the files, before
typing `$ java SudokuSolve`.
