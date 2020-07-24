# simple lists


For this kata we’re going to code up three implementations of a list that has the following basic interface:

- The list consists of nodes. Each node has a string value, along with whatever housekeeping the list itself needs.
- New nodes are added to the end of the list.
- You can ask the list if it contains a given string. If it does, it returns the node containing that string.
- You can delete a node from the list.
- You can ask the list to return an array of all its values.

1. A singly linked list (each node has a reference to the next node).
2. A doubly linked list (each node has a reference to both the next and previous nodes).
3. Some other implementation of your choosing, except that it should use no references (pointers) to collect nodes together in the list.

Obviously, we won’t be using predefined library classes as our list implementations…

See http://codekata.com/kata/kata21-simple-lists/ for more details about this kata.

And https://en.wikipedia.org/wiki/Linked_list for more about Linked Lists.
