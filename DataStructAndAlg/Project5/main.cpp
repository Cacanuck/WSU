#include "Trie.h"
#include <string>
#include <fstream>
#include <iostream>

using namespace std;

int main () {
    // Create Trie
    Trie trie;

    // Open dictionary file
    ifstream file("wordlist_mac.txt");

    // Handle file opening errors
    if(!file) {
        cerr << "Error opening file" << endl;
        return -1;
    }

    // Load the all of the words into the trie
    string word;
    while (getline(file,word)) {
        trie.insert(word);
    }
    file.close();

    // Prompt user for prefix
    string prefix;
    while (true) {
        cout << "Enter a word prefix, or press 0 to exit." << endl;
        getline(cin,prefix);

        // Command to exit is 0
        if (prefix == "0") {
            break;
        }

        // Get number value of completions
        int count  = trie.completeCount(prefix);
        cout << "There are " << count << " completions for the prefix '" << prefix << "'." << endl;

        // Prompt user to see the completed words
        string completions;
        cout << "Show completions? (Yes/No)" << endl;
        getline(cin,completions);
        if (completions == "yes" || completions == "Yes" || completions == "y" || completions == "Y") {

            // Get the completed words
            vector<string> numCompletions = trie.complete(prefix);

            // Display
            cout << "Completions" << endl;
            cout << "-------------" << endl;
            for (const string &completion : numCompletions) {
                cout << completion << endl;
            }
        }
    }
    return 0;
}