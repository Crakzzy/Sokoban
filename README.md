# Sokoban

Sokoban is a classic puzzle game where the player, represented as a warehouse worker, must push boxes to designated target locations in a maze. The challenge lies in maneuvering the boxes strategically to solve increasingly complex puzzles. The worker can only push, not pull, and planning ahead is crucial to avoid getting boxes stuck.

## Why this project?

This project was assigned as bonus task for OOP class. This is my first bigger project using OOP and I know the classes are probably not optimal.

## How to install

1. Download the Sobokan.zip
2. Unzip the folder

## How to start

**Make sure you have java installed!**

### On Windows

1. Simply run Start.cmd

### Other systems

1. Open terminal
2. Get into the folder
3. Run *java -jar ".\Sokoban.jar"*

(Optional)
1. Do everything above, but save the command in seperate executable file
2. Add to the end of file "pause" command depending on your system to stop auto closing of console at the end of game

## Adding custom levels

Simply open level.txt and insert your level istead of the default one

## Testing
I've run basic tests for Box and Player classes. Assuming that the board is always bordered with walls, so the player and box will never move out.
<br>
Box class:
<br>
![image_2023-11-13_105754687](https://github.com/Crakzzy/Sokoban/assets/82884609/a6e2fa9b-0892-4390-a63d-7431c3135c39)
<br>
Player class:
<br>
![image](https://github.com/Crakzzy/Sokoban/assets/82884609/25f8911c-8637-4fa0-a0dd-9cd1f18f17c7)

Tests can be found in *src/test/kotlin*

## What I've learned?
 - Basics of OOP 
 - During develompent of this project I discovered that String is not an array of chars, like in C++. So I can't directly change chars at each index
 - Enum classes
 - File input
 - Searching in lists by iterator
 - Basic testing

Big thanks to https://github.com/FilipGregus for helping
