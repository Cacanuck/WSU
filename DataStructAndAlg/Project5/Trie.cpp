#include "Trie.h"

using namespace std;

// Constructor
Trie::Trie() : root(new Node()), words(0), nodes(1) {
}

// Destructor
Trie::~Trie() {
    clear(root);
}

// Clears all nodes in the trie
void Trie::clear(Node *node) {

    // If theres is no node, end
    if (!node) {
        return;
    }

    // Loop through all children and delete each child node
    for (int i = 0; i < alphabetSize; i++) {
        clear(node->children[i]);
    }

    // Delete current node
    delete node;
}

// Copy Constructor
Trie::Trie(const Trie &other) : root(new Node()), words(other.words), nodes(other.nodes) {
    copy(root, other.root);
}

// Assignment operator for the trie
Trie &Trie::operator=(const Trie &other) {

    // Return if the current object is the same
    if (this == &other) {
        return *this;
    }

    // Clear nodes
    clear(root);

    // Create new root and reset words and nodes
    root = new Node();
    words = 0;
    nodes = 1;

    // Copy from the other trie
    copy(root, other.root);
    words = other.words;
    nodes = other.nodes;

    // Return copied trie
    return *this;
}

// Copies nodes from one trie into another
void Trie::copy(Node *to, const Node *from) {

    // Return if the source trie is empty
    if (!from) {
        return;
    }

    // Copy isEnd flag
    to->isEnd = from->isEnd;
    for (int i = 0; i < alphabetSize; i++) {

        // Create new nodes if a child node exists in the source trie, for each letter in alphabet
        if (from->children[i]) {
            to->children[i] = new Node();
            nodes++;

            // Copy the child node
            copy(to->children[i], from->children[i]);
        }
    }
}

// Converts character value into index value
int Trie::characterIndex(char c) const {
    return c - 'a';
}

// Inserts word into trie
bool Trie::insert(const string &word) {

    // Start node
    Node *current = root;
    bool found = false;

    // Loop through each char in the word
    for (char c: word) {
        int index = characterIndex(c);

        // If child node doesnt exist for character, create new node
        if (current->children[index] == nullptr) {
            current->children[index] = new Node();
            nodes++;

            // New node was added
            found = true;
        }

        // Go to next child node
        current = current->children[index];
    }

    // Mark current node as end of the word
    if (!current->isEnd) {
        current->isEnd = true;
        words++;
        found = true;
    }

    // Return if the word was inserted
    return found;
}

// Returns number of words in trie
int Trie::count() const {
    return words;
}

// Returns number of nodes in trie
int Trie::getSize() const {
    return nodes;
}

// Finds if word exists already in trie
bool Trie::find(const string &word) const {

    // Start node
    Node *current = root;

    // Loop through each char in the word, if child node doesnt exist, return false
    for (char c : word) {
        int index = characterIndex(c);
        if (current->children[index] == nullptr) {
            return false;
        }
        current = current->children[index];
    }

    // True if reached end of the word
    return current->isEnd;
}

// Counts words in trie that start with the prefix
int Trie::completeCount(const string &prefix) const {

    // Start node
    Node* current = root;

    // Loop through each char of prefix, if child node doesnt exist, return 0
    for (char c : prefix) {
        int index = characterIndex(c);
        if (current->children[index] == nullptr) {
            return 0;
        }
        current = current->children[index];
    }

    // Store and return words that start with prefix
    vector<string> result;
    collectComplete(current, result, prefix);
    return result.size();
}

// Collects all words starting with the prefix
void Trie::collectComplete(Node *node, vector<string>& words, string prefix) const {
    if (!node) {
        return;
    }

    // If node reaches end of word, add prefix to list of words
    if (node->isEnd) {
        words.push_back(prefix);
    }

    // Loop through child nodes, if child nodes exists, collect completions
    for (int i = 0; i < alphabetSize; i++) {
        if (node->children[i]) {
            collectComplete(node->children[i], words, prefix + static_cast<char>('a' + i));
        }
    }
}

// Return all words in trie that start with prefix
vector<string> Trie::complete(const string &prefix) const {
    vector<string> result;
    Node* current = root;

    // Loop through each char in prefix
    for (char c : prefix) {
        int index = characterIndex(c);

        // Return empty if nothing found
        if (current->children[index] == nullptr) {
            return result;
        }
        current = current->children[index];
    }

    // Collect all completions
    collectComplete(current, result, prefix);
    return result;
}