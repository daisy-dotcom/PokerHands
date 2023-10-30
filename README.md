<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->

<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->

# Project Euler - Problem 54 Poker Hands
<!-- ABOUT THE PROJECT -->
## About The Project

This project provides a solution for problem 54 on projecteuler.net 
which can be found here https://projecteuler.net/problem=54.
The problem describes a poker game where 2 players are dealt 5 cards 
each and the player with the best hand according to the rules of poker
wins. 

The hand ranking sytem can be found here. https://en.wikipedia.org/wiki/List_of_poker_hands

The goal is to determine the number of times player one wins.


### Built With

* Gradle
* Java
* Docker


<!-- GETTING STARTED -->
## Getting Started

### Prerequisites

* Docker https://docs.docker.com/desktop/install/windows-install/  
or  
* Gradle https://gradle.org/install/


### Installation
#### Gradle

1. Clone the repo.
   ```sh
   git clone https://github.com/daisy-dotcom/PokerHands.git
   ```
2. Navigate to the directory with the build.gradle file.

3. Run one of these commands to run tests.
   ```sh
   gradle test
   ```
   or
   ```sh
   ./gradlew test
   ```
4. Run one of these commands to run the application and 
see the number of times player one wins.
   ```sh
   gradle run
   ```
   or
   ```sh
   ./gradlew run
   ```

#### Docker
1. Pull the image from Docker Hub
   ```sh
   docker pull daisyd0tc0m/poker-hands
   ```
2. Start a container to output player one's wins
   ```sh
   docker run --it --rm daisyd0tc0m/poker-hands
   ```
3. Pull the image for the tests from Docker Hub
   ```sh
   docker pull daisyd0tc0m/poker-hands-tests
   ```
4. Start a container to output the test results.
   ```sh
   docker run --it --rm daisyd0tc0m/poker-hands-tests
   ```

<!-- PROJECT STRUCTURE -->
## Project Overview

### How It Works

The solution works by determining the current hand of each player. This
is done by a process of elimination starting from the most specific and highest value hand (a Royal Flush) to the least specific and lowest value one (High Card). 

The first step in finding a winner is comparing the value of player 1's hand and player 2's hand. The hand of greater value wins.

When the type of hand is determined, the value of the highest value card making up the hand is also stored in case both players have the same hand in order to find a winner.

An example would be:
Player 1 : 5H 5C 6S 7S KD
Player 2 : 2C 3S 8S 8D TD

Here, player 1 has a pair of 5s and player 2 has a pair of 8s. Since 8 is greater than 5, player 2 would win.

### Object Oriented Programming Features

- Inheritance
    - The Hand class extends the Cards class since a hand is a subset of cards from a deck.
- Encapsulation
    - Use of getters and setters for private properties used to find out the poker hand for each player.
    - Prevents the addition of cards to the hand, for example, which would affect the value of assigned
    to the hand.

### Improvements

- Multithreading to improve speed.
- One Docker image for tests and the application

### New Technologies

- Gradle
    - Learned project management for Java.
- JUnit
    - First time writing automated tests in Java.

### Likes and Dislikes About the Solution
 
 - Likes
    - Makes use of inheritance between the Card class and Hand class that can allow us to add methods in the Card class to randomly generate poker hands instead of reading from a text file. Good for code reusability.

 - Dislikes
    - A lot if-else statements when determining the hand.


<!-- CONTACT -->
## Contact

Daisy Oira

Project Link: [https://github.com/daisy-dotcom/PokerHands](https://github.com/daisy-dotcom/PokerHands)





