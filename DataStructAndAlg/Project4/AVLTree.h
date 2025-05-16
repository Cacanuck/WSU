#include <iostream>
#include <vector>
#include <string>

#ifndef AVLTREE_H
#define AVLTREE_H

using namespace std;

class AVLTree {
private:
    // Structure for Nodes in the AVL Tree
    struct Node {
        int key; // Node key
        string val; // Value tied to the key
        Node *left; // Pointer for node's left child
        Node *right; // Pointer for node's right child
        Node *parent; //Pointer for parent node
        int height; // Height of the node

        // Constructor for Nodes
        Node(int k, const string &v)
            : key(k), val(v), left(nullptr), right(nullptr), height(0) {
        }
    };

    // Pointer to root Node
    Node *root;

    // Size of AVL Tree
    int size;

    // Inserts a key-value pair into the tree
    Node *insert(Node *node, int key, const string &value, bool &inserted);

    // Gets height of the node
    int getHeight(Node *node) const;

    // Finds balance factor of the node
    int getBalance(Node *node) const;

    // Do a left rotation on the node
    Node *rotateLeft(Node *problem);

    // Do a right rotation on the node
    Node *rotateRight(Node *problem);

    // Find node with the minimum key
    Node *findMin(Node *node) const;

    // Remove the node with the minimum key from the tree
    Node *removeMin(Node *node);

    // Searches for a node using the key
    Node *find(Node *node, int key, string &value) const;

    // Find values in the tree within the key range
    void findRange(Node *node, int lowkey, int highkey, vector<string> &result) const;

    // Print the AVL Tree
    void printTree(ostream &os, Node *node, int depth) const;

public:
    // Default Constructor
    AVLTree();

    // Inserts a key-value pair into the tree
    bool insert(int key, const string &value);

    // Gets the height of the tree
    int getHeight() const;

    // Gets the number of nodes in the tree
    int getSize() const;

    // Finds the value when given a key
    bool find(int key, string &value) const;

    // Finds all the values in a key range
    vector<string> findRange(int lowkey, int highkey) const;

    // Overloaded operator<< to print the tree
    friend ostream &operator<<(ostream &os, const AVLTree &tree);

    // Destructor
    ~AVLTree();

    // Clear memory
    void clear(Node *node);
};

#endif //AVLTREE_H
