+++         # Set the current cell to 3.
[           # Start a loop; run while the current cell is not 0.
  >++.      # Move to the next cell and increment its value by 2, then output it.
  <         # Move back to the starting cell.
  -         # Decrement the starting cell.
]           # End the loop.

,           # Take input and store its ASCII value in the current cell.
.           # Output the ASCII character stored in the current cell.

+++++       # Increment the value at the current cell to 5.
.           # Output the ASCII character (5 = ENQ, non-printable).

++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.
