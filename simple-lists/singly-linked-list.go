package main

import "fmt"

type Node struct {
	name string
	next *Node
}

type List struct {
    name string
	size int
	head *Node
}

// creates an empty list
func newList(name string) *List {
    return &List{
	            name: name,
				size: 0,
				head: nil,
				}
}

func (list *List) getName() string {
	return list.name
}

// add() will append a new element to the list
func (list *List) add(name string) {
	node := &Node{name, nil}

	if list.head == nil {
		list.head = node
	} else {
		currentNode := list.head
		for currentNode.next != nil {
			currentNode = currentNode.next
		}
		currentNode.next = node
	}
	list.size++
}

func (list *List) remove(node *Node) error {
	
	if (node == nil) {
		return fmt.Errorf("[remove] node is nil")
	}
	
	if list.head == nil {
		return fmt.Errorf("[remove] List is empty")
	}
	
	// node to remove is the first one
	if node.name == list.head.name {
		list.head = list.head.next	
		list.size--
		return nil
	}
	// node to remove is the last one
	if node.next == nil {
		// remove the last element
		nodeBeforeLast := list.head;
		for nodeBeforeLast.next != nil {
			if nodeBeforeLast.next.name == node.name {
				nodeBeforeLast.next = nil
				fmt.Printf("[remove] before last is %v\n", nodeBeforeLast.name)
				list.size--
				return nil
			}
			nodeBeforeLast = nodeBeforeLast.next
		}
	} else {
		node.next.name = node.name
		node = node.next	
	}
	
	return nil
}

func (list *List) show() error {
	if list.head == nil {
		fmt.Printf("[show] %v is empty\n", list.name)
		return fmt.Errorf("show: is empty")
	}
	currentNode := list.head
	fmt.Printf("[show] %v elements:\n", list.name)

	for currentNode != nil {
		fmt.Println(currentNode.name)
		currentNode = currentNode.next
	}
	return nil
}

func (list *List) find(name string) (*Node, error) {
	if list.head == nil {
		return nil, fmt.Errorf("[find] list is empty") 
	}
	currentNode := list.head
	for currentNode != nil {
		if currentNode.name == name {
			return currentNode, nil
		}
		currentNode = currentNode.next
	}
	return nil, fmt.Errorf("[find]: %v not found\n",name)
}

func main() {
	fmt.Println("Creating a List")
	list := newList("My Names List")
	list.show()
	fmt.Println("Adding names")
	list.add("fred")
	list.add("wilma")
	list.add("betty")
	list.add("barney")
	list.show()
	fmt.Println("Searching for betty")
	if found, err := list.find("betty"); err != nil {
        	fmt.Printf("%v",err)
    } else {
		fmt.Printf("Found %v\n",found.name)
		fmt.Printf("Removing %v\n",found.name)
		if err := list.remove(found); err != nil {
			fmt.Printf("%v\n",err)
		} else {
			fmt.Printf("Removed %v\n",found.name)
			list.show()
		}
		
	}
	
	fmt.Println("Searching for john")
	
	if found, err := list.find("john"); err != nil {
        	fmt.Printf("%v",err)
    } else {
		fmt.Printf("Found %v",found.name)
	}
	
}
