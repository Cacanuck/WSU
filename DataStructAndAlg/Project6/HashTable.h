#ifndef HASHTABLE_H
#define HASHTABLE_H

#include "Slot.h"
#include <vector>

class HashTable {
private:
    static const int MAXHASH = 20;
    Slot table[MAXHASH];
    int filledSlots;

    // Probe Function
    int probe(int key, int &collisions) const;

public:
    HashTable();

    // Insert Key and Index into Table
    bool insert(int key, int index, int &collisions);

    // Remove Key from Table
    bool remove(int key);

    // Find Key in Table
    bool find(int key, int &index, int &collisions) const;

    // Finds Load Factor of Table
    float load() const;

    // Overload << to Print from Database
    friend std::ostream &operator<<(std::ostream &os, const HashTable &ht);

    // Get Slot Object by Index
    const Slot &getSlot(int index) const;

    // Get MAX HASH Value
    int getMaxHash() const { return MAXHASH; }
};

#endif // HASHTABLE_H
