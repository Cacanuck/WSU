/*
Trevor Hollack
Project 2
This project gets input from the user for 2 different tabletop RPG character data sheets, and then simulates a battle between them*/

#include <iostream>
#include "Character.h"
#include <cstdlib>
#include <ctime>

using namespace std;

int main()
{
    // Initialize variables for the first character
    string name1;
    string role1;
    int hp1;
    int atkBonus1;
    int dmgBonus1;
    int armorClass1;

    // Initialize variables for the second character
    string name2;
    string role2;
    int hp2;
    int atkBonus2;
    int dmgBonus2;
    int armorClass2;

    // Prompt user for data about the first character, and store that input into the variables
    cout << "First Character Name?" << endl;
    cin >> name1;
    cout << name1 << "'s role?" << endl;
    cin >> role1;
    cout << name1 << " the " << role1 << " 's hit points?" << endl;
    cin >> hp1;
    cout << name1 << " the " << role1 << " 's attack bonus?" << endl;
    cin >> atkBonus1;
    cout << name1 << " the " << role1 << " 's damage bonus?" << endl;
    cin >> dmgBonus1;
    cout << name1 << " the " << role1 << " 's armor class?" << endl;
    cin >> armorClass1;

    // Construct the first character object and display  its stats
    Character character1(name1, role1, hp1, atkBonus1, dmgBonus1, armorClass1);
    character1.print(cout);
    cout << endl;

    //  Clear the input stream
    cin.ignore();

    // Prompt user for data about the second character, and store that input into the variables
    cout << "Second Character Name?" << endl;
    cin >> name2;
    cout << name2 << "'s role?" << endl;
    cin >> role2;
    cout << name2 << " the " << role2 << " 's hit points?" << endl;
    cin >> hp2;
    cout << name2 << " the " << role2 << " 's attack bonus?" << endl;
    cin >> atkBonus2;
    cout << name2 << " the " << role2 << " 's damage bonus?" << endl;
    cin >> dmgBonus2;
    cout << name2 << " the " << role2 << " 's armor class?" << endl;
    cin >> armorClass2;

    // Construct the second character object and display its stats
    Character character2(name2, role2, hp2, atkBonus2, dmgBonus2, armorClass2);
    character2.print(cout);
    cout << endl;

    // Seed the random number generator using the clock
    srand(time(0));

    cout << "Simulated Combat:" << endl;

    // Loop runs until the health of one of the characters reaches 0
    // Character1 calls the attack function on character2
    // If character2's hp hits 0, display that character1 wins
    // If character2's hp is not 0, then character2 calls the attack function on character1
    // If character1's hp is 0, display that character2  wins
    // if character1's hp is not 0, the loop continues
    while (character1.getHealth() > 0 && character2.getHealth() > 0) {
        character1.attack(character2);
        if (character2.getHealth() == 0) {
            cout << character1.getName() << " WINS!" << endl;
            break;
        }
        character2.attack(character1);
        if (character1.getHealth() == 0) {
            cout << character2.getName() << " WINS!" << endl;
            break;
        }
    }
}