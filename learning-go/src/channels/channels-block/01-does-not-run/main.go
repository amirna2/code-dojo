package main

import "fmt"

// This code will not work, because channels are blocking
func main() {
	c := make(chan int)
    c <- 42
    // This will never execute because we are block after sending
    // 42 into the channel
	fmt.Println(<-c)
}
