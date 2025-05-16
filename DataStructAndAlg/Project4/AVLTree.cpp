#include "AVLTree.h"

using namespace std;

// Constructor for the AVL Tree
AVLTree::AVLTree() : root(NULL), size(0) {
}

// Gets height of a node
int AVLTree::getHeight(Node *node) const {
    // Check if tree is empty
    if (node == nullptr) {
        return -1;
    }
    return node->height;
}

// Get height of the tree
int AVLTree::getHeight() const {
    return getHeight(root);
}

// Get size of the tree
int AVLTree::getSize() const {
    return size;
}

// Find balance factor fo a node
int AVLTree::getBalance(Node *node) const {
    if (!node) return 0;
    return getHeight(node->left) - getHeight(node->right);
}

// Do right rotation on problem node
AVLTree::Node *AVLTree::rotateRight(Node *problem) {
    Node *leftChild = problem->left;
    Node *leftRightChild = leftChild->right;

    // Check if problem node has a parent node
    if (problem->parent != nullptr) {
        if (problem->parent->left == problem) {
            problem->parent->left = leftChild;
        } else {
            problem->parent->right = leftChild;
        }
        leftChild->parent = problem->parent;
    } else {
        root = leftChild;
        leftChild->parent = nullptr;
    }

    // Rotation
    leftChild->right = problem;
    problem->parent = leftChild;
    problem->left = leftRightChild;

    if (leftRightChild != nullptr) {
        leftRightChild->parent = problem;
    }

    // Update heights
    problem->height = max(getHeight(problem->left), getHeight(problem->right)) + 1;
    leftChild->height = max(getHeight(leftChild->left), getHeight(leftChild->right)) + 1;

    return leftChild;
}

// Do left rotation on problem node
AVLTree::Node *AVLTree::rotateLeft(Node *problem) {
    Node *rightChild = problem->right;
    Node *rightLeftChild = rightChild->left;

    // Check if problem node has a parent node
    if (problem->parent != nullptr) {
        if (problem->parent->left == problem) {
            problem->parent->left = rightChild;
        } else {
            problem->parent->right = rightChild;
        }
        rightChild->parent = problem->parent;
    } else { // problem node is the root
        root = rightChild;
        rightChild->parent = nullptr;
    }

    // Rotate
    rightChild->left = problem;
    problem->parent = rightChild;
    problem->right = rightLeftChild;

    if (rightLeftChild != nullptr) {
        rightLeftChild->parent = problem;
    }

    // Update heights
    problem->height = max(getHeight(problem->left), getHeight(problem->right)) + 1;
    rightChild->height = max(getHeight(rightChild->left), getHeight(rightChild->right)) + 1;

    return rightChild;
}

// Insert key-value pair and balance tree
AVLTree::Node *AVLTree::insert(Node *node, int key, const string &value, bool &inserted) { // TODO height is correct but 35 is root
    // Create new node if the node is null
    if (!node) {
        inserted = true;
        size++;
        return new Node(key, value);
    }

    // Insert into left or right subtree
    if (key < node->key) {
        node->left = insert(node->left, key, value, inserted);
    } else if (key > node->key) {
        node->right = insert(node->right, key, value, inserted);
    } else {
        inserted = false;
        return node;
    }

    // Update height of the current node after insertion
    node->height = 1 + max(getHeight(node->left), getHeight(node->right));

    // Get balance factor of the node
    int balance = getBalance(node);

    // Balancing
    // Right
    if (balance > 1 && key < node->left->key) {
        return rotateRight(node);
    }

    // Left
    if (balance < -1 && key > node->right->key) {
        return rotateLeft(node);
    }

    // Left Right
    if (balance > 1 && key > node->left->key) {
        node->left = rotateLeft(node->left);
        return rotateRight(node);
    }

    // Right Left
    if (balance < -1 && key < node->right->key) {
        node->right = rotateRight(node->right);
        return rotateLeft(node);
    }

    return node;
}



// Insert key-value pair into tree and return if successful
bool AVLTree::insert(int key, const string &value) {
    bool inserted = false;
    root = insert(root, key, value, inserted);
    return inserted;
}

// Public find Function
bool AVLTree::find(int key, string &value) const {
    Node *result = find(root, key, value);
    return result != nullptr;
}

// Private find Function
AVLTree::Node *AVLTree::find(Node *node, int key, string &value) const {
    if (!node) return nullptr;

    // Look in left subtree
    if (key < node->key) {
        return find(node->left, key, value);
        // Look in right subtree
    } else if (key > node->key) {
        return find(node->right, key, value);
        // Set value when key is found
    } else {
        value = node->val;
        return node;
    }
}

// Public findRange Function
vector<string> AVLTree::findRange(int lowkey, int highkey) const {
    vector<string> result;
    findRange(root, lowkey, highkey, result);
    return result;
}

// Private findRange Function
void AVLTree::findRange(Node *node, int lowkey, int highkey, vector<string> &result) const {
    if (!node) return;

    if (node->key >= lowkey && node->key <= highkey) {
        // Check left subtree
        findRange(node->left, lowkey, highkey, result);
        // Add val to result
        result.push_back(node->val);
        // Check right subtree
        findRange(node->right, lowkey, highkey, result);
    } else if (node->key < lowkey) {
        // Only check right subtree
        findRange(node->right, lowkey, highkey, result);
    } else {
        // Only check left subtree
        findRange(node->left, lowkey, highkey, result);
    }
}

//  Public Print Function
ostream &operator<<(ostream &os, const AVLTree &tree) {
    tree.printTree(os, tree.root, 0);
    return os;
}

// Private Print Function
void AVLTree::printTree(ostream &os, Node *node, int depth) const {
    if (node != nullptr) {
        // Print right subtree
        printTree(os, node->right, depth + 1);
        // Indent for "height"
        for (int i = 0; i < depth; i++) {
            os << "    ";
        }
        // Print node
        os << node->key << ", " << node->val << endl;
        // Print left subtree
        printTree(os, node->left, depth + 1);
    }
}

// Destructor
AVLTree::~AVLTree() {
    clear(root);
}
// Clear nodes from memory
void AVLTree::clear(Node *node) {
    if (node) {
        clear(node->left);
        clear(node->right);
        delete node;
    }
}
