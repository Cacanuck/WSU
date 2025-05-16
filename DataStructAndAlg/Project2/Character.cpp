#include "Character.h"
#include <cstdlib>

// Character constructor
Character::Character(string name, string role, int hp, int atkBonus, int dmgBonus, int armorClass)
    : name(name), role(role), hp(hp), atkBonus(atkBonus), dmgBonus(dmgBonus), armorClass(armorClass){}

// Function getName returns name
string Character::getName() const {
    return name;
}

// Function getRole returns role
string Character::getRole() const {
    return role;
}

// Function getHealth returns health
int Character::getHealth() const {
    return hp;
}

// Function getArmorClass returns armor class
int Character::getArmorClass() const {
    return armorClass;
}

// Function print displays character's stats in a sheet style
void Character::print(ostream& os) const {
    os << "Character Summary\n"
    << "------------------\n"
    << name << " the " << role << "\n"
    << "HP: " << hp << "\n"
    << "Attack Bonus: " << atkBonus << "\n"
    << "Damage Bonus: " << dmgBonus << "\n"
    << "Armor Class: " << armorClass << endl;
}

// Function damage subtracts the damage a character takes from its health, and makes sure the lowest value is 0
void Character::damage(int amount) {
    hp = hp - amount;
    if (hp < 0) {
        hp = 0;
    }
}

// Function attack determines if a character can attack another character, and displays the status of the attacked character
// The function simulated a d20 dice roll, and adds that roll to the character's attack bonus
// If the total attack is higher than the defending character's armorClass stat, the attack hits
// Then a d10 dice roll is simulated and added to the attacking character's damageBonus stat
// The damage function is called to apply the rolled damage amount to the defending character's health
// If the total attack is lower than the defending character's aarmorClass stat, the turn is skipped
void Character::attack(Character &otherCharacter) {
    int roll = rand() % 20 + 1;
    int total = roll + atkBonus;
    cout << name << " attacks!" << endl;
    cout << "Attack Roll: " << roll << " + " << atkBonus << " = " << total;
    if (total >= otherCharacter.getArmorClass()) {
        cout << " ---> HIT" << endl;
        int rolledDamage = rand() % 10 + 1;
        int totalDamage = rolledDamage + atkBonus;
        cout << "Damage: " << rolledDamage << " + " << atkBonus << " = " << totalDamage << endl;
        otherCharacter.damage(totalDamage);
        cout << otherCharacter.getName() << " the " << otherCharacter.getRole() << " has " << otherCharacter.getHealth() << " hit points remaining." << endl;
    } else {
        cout << "---> MISS!" << endl;
    }
}