# Initial setup
 Hard
## Description
In this project, you'll write a game called Tic-Tac-Toe that you can play against your computer. The computer will have three levels of difficulty — easy, medium, and hard.

To begin with, let's write a program that knows how to work with coordinates and determine the state of the game.

The top-left cell will have the coordinates (1, 1) and the bottom-right cell will have the coordinates (3, 3), as shown in this table:
```
(1, 1) (1, 2) (1, 3)
(2, 1) (2, 2) (2, 3)
(3, 1) (3, 2) (3, 3)
```
The program should ask the user to enter the coordinates of the cell where they want to make a move.

Keep in mind that the first coordinate goes from top to bottom, and the second coordinate goes from left to right. Also, notice that coordinates start with 1 and can be 1, 2, or 3.

But what if the user attempts to enter invalid coordinates? This could happen if they try to enter letters or symbols instead of numbers, or the coordinates of an already occupied cell. Your program needs to prevent these things from happening by checking the user's input and catching possible exceptions.

## Objectives
The program should work in the following way:

1. Ask the user to provide the initial state of the 3x3 table with the first input line. This must include nine symbols that can be X, O or _ (the latter represents an empty cell).
2. Output the specified 3x3 table before the user makes a move.
3. Request that the user enters the coordinates of the move they wish to make.
4. The user then inputs two numbers representing the cell in which they wish to place their X or O. The game always starts with X, so the user's move should be made with this symbol if there are an equal number of X's and O's in the table. If the table contains an extra X, the move should be made with O.
5. Analyze the user input and show messages in the following situations:
  - This cell is occupied! Choose another one! — if the cell is not empty;
  - You should enter numbers! — if the user tries to enter letters or symbols instead of numbers;
  - Coordinates should be from 1 to 3! — if the user attempts to enter coordinates outside of the table's range.
6. Display the table again with the user's most recent move included.
7. Output the state of the game.

The possible states are:

- ```Game not finished``` — when no side has three in a row, but the table still has empty cells;
- ```Draw``` — when no side has three in a row, and the table is complete;
- ```X wins``` — when there are three X's in a row (up, down, across, or diagonally);
- ```O wins``` — when there are three O's in a row (up, down, across, or diagonally).

If the user provides invalid coordinates, the program should repeat the request until numbers that represent an empty cell on the table are supplied. You should ensure that the program only outputs the table twice — before the move and after the user makes a legal move.

## Examples
The examples below show how your program should work.
The greater-than symbol followed by a space (> ) represents the user input. Note that it's not part of the input.

### Example 1:
```
Enter the cells: > _XXOO_OX_
---------
|   X X |
| O O   |
| O X   |
---------
Enter the coordinates: > 3 1
This cell is occupied! Choose another one!
Enter the coordinates: > one
You should enter numbers!
Enter the coordinates: > one three
You should enter numbers!
Enter the coordinates: > 4 1
Coordinates should be from 1 to 3!
Enter the coordinates: > 1 1
---------
| X X X |
| O O   |
| O X   |
---------
X wins
```
### Example 2:
```
Enter the cells: > XX_XOXOO_
---------
| X X   |
| X O X |
| O O   |
---------
Enter the coordinates: > 3 3
---------
| X X   |
| X O X |
| O O O |
---------
O wins
```
### Example 3:
```
Enter the cells: > XX_XOXOO_
---------
| X X   |
| X O X |
| O O   |
---------
Enter the coordinates: > 1 3
---------
| X X O |
| X O X |
| O O   |
---------
O wins
```
### Example 4:
```
Enter the cells: > OX_XOOOXX
---------
| O X   |
| X O O |
| O X X |
---------
Enter the coordinates: > 1 3
---------
| O X X |
| X O O |
| O X X |
---------
Draw
Example 5:

Enter the cells: >  _XO_OX___
---------
|   X O |
|   O X |
|       |
---------
Enter the coordinates: > 3 1
---------
|   X O |
|   O X |
| X     |
---------
Game not finished
```
https://hyperskill.org/projects/81/stages/447/implement
