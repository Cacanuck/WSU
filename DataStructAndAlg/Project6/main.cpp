#include "Database.h"
#include <iostream>

using namespace std;

int main() {
    Database db;
    char action;
    bool running = true;

    // Loop to Access Database
    while (running) {
        // Prompt User
        std::cout << "Would you like to (I)nsert, (D)elete, (S)earch, (P)rint, or (Q)uit?\n";
        std::cin >> action;

        // Switch Depending on WHat Char is Entered
        switch (toupper(action)) {
            // Insertion
            case 'I': {
                std::string first, last, year;
                int uid, collisions;
                std::cout << "Last name: ";
                std::cin >> last;
                std::cout << "First name: ";
                std::cin >> first;
                std::cout << "UID: ";
                std::cin >> uid;
                std::cout << "Year: ";
                std::cin >> year;

                Record record(first, last, uid, year);

                // Insertion Works
                if (db.insert(record, collisions)) {
                    std::cout << "Record inserted (" << collisions << " collisions during insert).\n";

                    // Insertion Fails
                } else {
                    std::cout << "Record not inserted.\n";
                }
                break;
            }

            // Delete
            case 'D': {
                int uid;
                std::cout << "Enter UID to delete: ";
                std::cin >> uid;

                // Delete Works
                if (db.remove(uid)) {
                    std::cout << "Record deleted.\n";

                    // Delete Fails
                } else {
                    std::cout << "Record not found.\n";
                }
                break;
            }

            // Search
            case 'S': {
                int uid, collisions;
                Record foundRecord;
                std::cout << "Enter UID to search: ";
                std::cin >> uid;

                // Probe Works
                if (db.find(uid, foundRecord, collisions)) {
                    std::cout << "Record found (" << collisions << " collisions during search):\n";
                    std::cout << foundRecord << "\n";

                    // Probe Fails
                } else {
                    std::cout << "Record not found.\n";
                }
                break;
            }

            // Print
            case 'P':
                std::cout << db << "\n";
                break;

            // Quit
            case 'Q':
                running = false;
                break;

            // Not I, D, S, P, Q
            default:
                std::cout << "Invalid action.\n";
        }
    }

    return 0;
}
