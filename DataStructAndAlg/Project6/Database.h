#ifndef DATABASE_H
#define DATABASE_H

#include "HashTable.h"
#include "Record.h"
#include <vector>

class Database {
private:
    HashTable indexTable;
    std::vector<Record> recordStore;

public:
    Database();

    // Insert Record to Database
    bool insert(const Record &newRecord, int &collisions);

    // Remove Record from Database
    bool remove(int key);

    // Find Record in Database by ID
    bool find(int uid, Record &foundRecord, int &collisions);

    // Calculate Load Factor of Hash Table
    float load() const;

    // Overload << to Print from Database
    friend std::ostream &operator<<(std::ostream &os, const Database &db);
};

#endif // DATABASE_H
