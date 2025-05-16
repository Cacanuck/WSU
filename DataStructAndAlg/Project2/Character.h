#ifndef CHARACTER_H
#define CHARACTER_H

#include <string>
#include <iostream>

using namespace std;

class Character
{

// Private variables for the Character class
private:
    string name;
    string role;
    int hp;
    int atkBonus;
    int dmgBonus;
    int armorClass;

// Constructor for the Character class
public:
    Character(string name, string role, int hp, int atkBonus, int dmgBonus, int armorClass);

    // Getter functions for the Character class
    string getName() const;
    string getRole() const;
    int getHealth() const;
    int getArmorClass() const;

    // Other functions for the Character class
    void print(ostream &os) const;
    void damage(int amount);
    void attack(Character &otherCharacter);
};

#endif