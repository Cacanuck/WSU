/*
Trevor Hollack
Project 1
This project prompts the user for how many times they would like to roll 2 6-sided dice, and then displays how many times each pssible value is rolled.
*/

#include <iostream>
#include <cstdlib>
using namespace std;

int main()
{
    // Prompt user for number of rolls
    cout << "How many rolls?" << endl;

    // Store user input into numRolls
    int numRolls;
    cin >> numRolls;

    // Tell user that their number of rolls are simulating
    cout << "Simulating " << numRolls << " rolls." << endl;

    // Seed the random number generator using the clock
    srand(time(nullptr));

    // Initialize an array of size 11 with value of 0 in every index
    int arr[11] = {0};

    // Loop runs for the amount of times specified in numRolls
    // roll1 and roll2 simulate 6 sided dice rolls
    // Add the rolls together and store that number in result
    // Subtract 2 from the result value to access the index of the array, and increment the value stored there by 1
    // Index 0 tracks results of 2, Index 1 tracks results of 3, etc...
    for (int times = 0; times < numRolls; times++)
    {
        int roll1 = rand() % 6 + 1;
        int roll2 = rand() % 6 + 1;
        int result = roll1 + roll2;
        arr[result - 2]++;
    }

    // Display the results of the rolls to the user
    cout << "Results: " << endl;

    // Loop runs 11 times, once per index of the array
    // Displays to the user how many times each number was rolled
    for (int i = 2; i <= 12; i++)
    {
        cout << i << " was rolled " << arr[i - 2] << " times." << endl;
    }

    return 0;
}