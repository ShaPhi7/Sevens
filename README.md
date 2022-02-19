# Sevens
Play a game of sevens - the [card game](https://en.wikipedia.org/wiki/Domino_(card_game)) that is, not the [Rugby game](https://en.wikipedia.org/wiki/Rugby_sevens).

This was a small implementation that I wrote a while ago. I dusted it off to discover that the code seems fairly readable, although there are a few things I'd do differently. I may yet update it!

Edit: It didn't feel worth pulling this apart so I'll just summarise the main issues:
- The Player object is doing a lot, with not much structure. We could have a Player interface to establish exactly what it needs to do. It could even be worth implementing the interface with an abstract method, which is extended by PlayerComputerEasy, PlayerComputerHard and PlayerHuman (which is currently just Player).
- A lot of the Player methods are really just helpers that deal with the cards a player has in their hand. Tidying these into a proper class would make Player feel more manageable.
- Vector is used throughout, a List would be more appropriate in most places. Some places will want to use a Set.
- There's a lot of procedural logic, if-else's that feel more like sticky plaster fixes than well thought out code.
- (+ve) Where there is logic, it's generally commented and explained well if it isn't obvious what's happening.

Note: CLI only (no GUI).

## Building the project

Simply built using `mvn clean install`, obviously having Apache Maven installed is a prerequisite.

## Running the project 

Simply run using `java -jar <name of jar>`. Java 8+ recommended.
