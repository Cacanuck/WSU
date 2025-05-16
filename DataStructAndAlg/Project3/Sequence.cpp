#include "Sequence.h"
#include <iostream>
#include <exception>

using namespace std;

//Constructor that creates a Sequence object of size sz
//Sets the values of head, tail, and numElts
Sequence::Sequence(size_type sz) : head(nullptr), tail(nullptr), numElts(0) {
    //Adds sz elements to the sequence
    for (size_type i = 0; i < sz; i++) {
        push_back(value_type());
    }
}

//Copies another Sequence object and creates a new one
Sequence::Sequence(const Sequence &s) : head(nullptr), tail(nullptr), numElts(0) {
    SequenceNode *current = s.head;
    //Iterates through s's nodes and adds each one to the new sequence
    while (current) {
        push_back(current->elt);
        current = current->next;
    }
}

//Destructor to delete the sequence
//Prevents memory leaks
Sequence::~Sequence() {
    clear();
}

//Assigns 2 sequence objects to each other
Sequence &Sequence::operator=(const Sequence &s) {
    //Clears the sequence if there are 2 objects
    //Copies elements from s to the current sequence
    if (this != &s) {
        clear();
        SequenceNode *current = s.head;
        while (current) {
            push_back(current->elt);
            current = current->next;
        }
    }
    return *this;
}

//Accesses elements at the indicated index
Sequence::value_type &Sequence::operator[](size_type position) {
    //Throw exception if position is invalid
    if (position >= numElts) {
        throw exception();
    }
    //Find the node nd return a reference to the element
    SequenceNode *current = head;
    for (size_type i = 0; i < position; i++) {
        current = current->next;
    }
    return current->elt;
}

//Adds new element at the back of the sequence
void Sequence::push_back(const value_type &value) {
    //Create a new node
    SequenceNode *new_node = new SequenceNode(value);
    //If empty sequence, sets this new node as the head and tail
    if (!head) {
        head = tail = new_node;
    }
    //Set the new node as the tail and increment numElts
    else {
        tail->next = new_node;
        new_node->prev = tail;
        tail = new_node;
    }
    numElts++;
}

//Remove element from back of the sequence
void Sequence::pop_back() {
    //Throw exception if sequence is empty
    if (empty()) {
        throw exception();
    }
    //Set tail to the previous node
    //Then delete the node, and decrement numElts
    SequenceNode *temp = tail;
    if (tail->prev) {
        tail = tail->prev;
        tail->next = nullptr;
    } else {
        head = tail = nullptr;
    }
    delete temp;
    numElts--;
}

//Place an element at the indicated location
void Sequence::insert(size_type position, value_type value) {
    //If position is not valid, throw exception
    if (position > numElts) {
        throw exception();
    }
    //Create new node to be inserted
    SequenceNode *new_node = new SequenceNode(value);
    //Set the new node as the head and tail if it is the first node in a sequence
    if (position == 0) {
        new_node->next = head;
        if (head) head->prev = new_node;
        head = new_node;
        if (!tail) tail = new_node;
    } else {
        SequenceNode *current = head;
        //Iterate to the head location of the desired position
        for (size_type i = 0; i < position - 1; i++) {
            current = current->next;
        }
        //Place the new node in the sequence, and update the next and prev pointers
        new_node->next = current->next;
        new_node->prev = current;
        if (current->next) current->next->prev = new_node;
        current->next = new_node;
        if (new_node->next == nullptr) tail = new_node;
    }
    numElts++;
}

//Returns first element in the sequence
const Sequence::value_type &Sequence::front() const {
    //Throw exception if the sequence is empty
    if (empty()) {
        throw exception();
    }
    return head->elt;
}

//Returns last element in the sequence
const Sequence::value_type &Sequence::back() const {
    //Throw exception if the sequence is empty
    if (empty()) {
        throw exception();
    }
    return tail->elt;
}

//Check is the sequence is empty
bool Sequence::empty() const {
    //True is numElts == 0
    return numElts == 0;
}

//Return the number of elements in the sequence
Sequence::size_type Sequence::size() const {
    return numElts;
}

//Deletes all elements from the sequence
void Sequence::clear() {
    while (!empty()) {
        pop_back();
    }
}

//Remove count number of elements starting at position in the sequence
void Sequence::erase(size_type position, size_type count) {
    //Throw exception if position or the amount to be removed are larger than the sequence
    if (position >= numElts || position + count > numElts) {
        throw exception();
    }
    SequenceNode *current = head;
    //Iterate to the position
    for (size_type i = 0; i < position; i++) {
        current = current->next;
    }
    //Update pointer values and delete the node, and then decrement numElts
    for (size_type i = 0; i < count; i++) {
        SequenceNode *temp = current;
        current = current->next;
        if (temp->prev) temp->prev->next = temp->next;
        if (temp->next) temp->next->prev = temp->prev;
        if (temp == head) head = temp->next;
        if (temp == tail) tail = temp->prev;
        delete temp;
        numElts--;
    }
}

// Place code for printing sequence here (well not here, inside the method)
//Prints the sequence
void Sequence::print(ostream &os) const {
    SequenceNode *current = head;
    //Prints the node, then iterates to the next one
    while (current) {
        os << current->elt << " ";
        current = current->next;
    }
    os << endl;
}

// Don't modify, do the output in the print() method
ostream &operator<<(ostream &os, const Sequence &s) {
    s.print(os);
    return os;
}
