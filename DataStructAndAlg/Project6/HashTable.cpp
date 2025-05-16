#include "HashTable.h"
#include <iostream>
#include <thread>
#include "hashfunction.h"

HashTable::HashTable() : filledSlots(0) {
}

// Probe Function
int HashTable::probe(int key, int &collisions) const {
    // Calculate hash Value
    unsigned int hash = jsHash(key) % MAXHASH;
    int i = 0;
    collisions = 0;

    // Quadratic Probing
    while (i < MAXHASH) {
        int slot = (hash + i * i) % MAXHASH;
        if (table[slot].isEmpty() || table[slot].getKey() == key)
            return slot;
        i++;
        collisions++;
    }

    // If Table Full
    return -1;
}

// Insert Key and Index into Table
bool HashTable::insert(int key, int index, int &collisions) {
    // Check if Key ALready Exists
    if (find(key, index, collisions)) return false;

    // Check if Table Full
    int slot = probe(key, collisions);
    if (slot == -1) return false;

    // Insert Key into Slot
    table[slot].load(key, index);
    filledSlots++;
    return true;
}

// Remove Key from Table
bool HashTable::remove(int key) {
    int index, collisions;

    // Check if key Exists
    if (!find(key, index, collisions)) return false;

    // Probe to Find Slot
    int slot = probe(key, collisions);

    // Clear Key from Slot
    table[slot].kill();
    filledSlots--;
    return true;
}

// Find Key in Table
bool HashTable::find(int key, int &index, int &collisions) const {
    // Find if Key Exists
    int slot = probe(key, collisions);
    if (slot == -1 || !table[slot].isNormal() || table[slot].getKey() != key)
        return false;

    // Get Key Index
    index = table[slot].getIndex();
    return true;
}

// Load Function of Table
float HashTable::load() const {
    return static_cast<float>(filledSlots) / MAXHASH;
}

// Overload << to Print from Database
std::ostream &operator<<(std::ostream &os, const HashTable &ht) {
    // Go Through Each Slot in Table
    for (int i = 0; i < HashTable::MAXHASH; ++i) {
        // Check if Slot has Valid Record
        if (ht.table[i].isNormal()) {
            // Print Record
            os << "HashTable Slot " << i << ": Key = " << ht.table[i].getKey()
                    << ", Index = " << ht.table[i].getIndex() << "\n";
        }
    }
    return os;
}

// Get Slot at Index
const Slot &HashTable::getSlot(int index) const {
    // Check if Index is Valid
    if (index >= 0 && index < MAXHASH) {
        return table[index];
    }

    // Index is Not Valid
    throw std::out_of_range("Index out of range.");
}
