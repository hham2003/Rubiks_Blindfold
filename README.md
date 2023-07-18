# Rubik's Cube Model and Blindfolded Method Helper
During the COVID lockdown, I learned how to solve the Rubik's Cube blindfolded. Simply put, most blindfolded solving methods involve inspecting the scrambled cube and coming up with (and memorizing) a sequence of letters that 'encodes' the solution to that particular scramble in a way that is much easier to memorize. I loved to practice blindfolded solving, but it was a painstakingly long process to inspect the cube before each solve attempt, so I began to get frustrated when I found myself progressing so slowly. My goal for this project was to create a program that would generate the letter sequence for me so that I could spend more time actually practicing blindfolded solving than planning out each solution. 
### CubeModel.java
This file contains a coded model of a standard 3x3 Rubik's Cube. Each face of the cube is represented by an array of 9 integers each corresponding to one of 6 colors:<br />
0: white
1: yellow
2: green
3: red
4: orange
5: blue<br />
The cube can be scrambled by using the readScramble() method and passing in a list of singular moves (strings) in standard Rubik's Cube notation.
### BlindEdges.java and BlindCorners.java
