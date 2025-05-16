#include "Database.h"

Database::Database() : indexTable(), recordStore() {
}

// Insert Record in Database
bool Database::insert(const Record &newRecord, int &collisions) {
    int key = newRecord.getUID();
    int index;

    // Check if Key Already Exists
    if (indexTable.find(key, index, collisions)) return false; // Duplicate key

    // Add If Key is Unique
    recordStore.push_back(newRecord);
    int newIndex = recordStore.size() - 1;

    return indexTable.insert(key, newIndex, collisions);
}

// Remove Record from Database
bool Database::remove(int key) {
    int index, collisions;

    // If Record Not Found, Return False
    if (!indexTable.find(key, index, collisions)) return false;

    // Get Last Record from Vector and Delete
    Record lastRecord = recordStore.back();
    recordStore[index] = lastRecord;
    recordStore.pop_back();

    // IF Removed Record is Not Last Record, Insert Last Record Back In
    indexTable.remove(key);
    if (index != recordStore.size())
        indexTable.insert(lastRecord.getUID(), index, collisions);

    return true;
}

// Find Record By ID
bool Database::find(int key, Record &foundRecord, int &collisions) {
    int index;

    // If Record Not Found, Return False
    if (!indexTable.find(key, index, collisions)) return false;

    // Get Record Using Index
    foundRecord = recordStore[index];
    return true;
}

// Get Load Factor of Table
float Database::load() const {
    return indexTable.load();
}

// Overload << to Print from Database
std::ostream &operator<<(std::ostream &os, const Database &db) {
    os << "Database contents:\n";

    // Go Through Each Slot in Table
    for (int i = 0; i < db.indexTable.getMaxHash(); ++i) {
        const Slot &slot = db.indexTable.getSlot(i);

        // Check if Slot has Valid Record
        if (slot.isNormal()) {
            int recordIndex = slot.getIndex();
            const Record &record = db.recordStore[recordIndex];

            // Print Record
            os << "HashTable Slot: " << i
                    << ", recordStore slot " << recordIndex
                    << " -- " << record << "\n";
        }
    }
    return os;
}
