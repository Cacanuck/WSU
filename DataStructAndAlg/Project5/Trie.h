#ifndef TRIE_H
#define TRIE_H

#include <string>
#include <vector>

using namespace std;

class Trie {
private:
    static const int alphabetSize = 26;

    // Node Structure
    struct Node {

        // Pointer array for each letter in alphabet
        Node *children[alphabetSize];

        // Marks end of a word
        bool isEnd;

        // Constructor, sets isEnd to false and sets child nodes to null
        Node() : isEnd(false) {
            for (int i = 0; i < alphabetSize; i++) {
                children[i] = nullptr;
            }
        }
    };

    // Pointer to root node
    Node *root;

    // Number of words in trie
    int words;

    // Number of nodes in trie
    int nodes;

    // Clears trie at root node
    void clear(Node *node);

    // Copy nodes from trie to another
    void copy(Node *to, const Node *from);

    // Collects words that complete prefix
    void collectComplete(Node *node, vector<string> &words, string prefix) const;

    // Converts character value into int value
    int characterIndex(char c) const;

public:

    // Constructor
    Trie();

    // Destructor
    ~Trie();

    // Copy Constructor
    Trie(const Trie &other);

    // Assignment operator
    Trie& operator=(const Trie &other);

    // Insert word into trie
    bool insert(const string &word);

    // Number of words in trie
    int count() const;

    // Number of nodes in trie
    int getSize() const;

    // Finds if a word exists in trie
    bool find(const string &word) const;

    // Number of words that start with prefix
    int completeCount(const string &prefix) const;

    // Vector of words that start with prefix
    vector<string> complete(const string &prefix) const;
};


#endif //TRIE_H
