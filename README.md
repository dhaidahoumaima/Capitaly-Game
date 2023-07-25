# Capitaly Game
Capitaly is a simulated board game where players showcase their strategic prowess in a quest for dominance. The game involves multiple
players with diverse strategies, all navigating a cyclical board with an array of intriguing fields.
# Gameplay Overview
Players roll a dice to move forward on the board, employing various strategies to gain an advantage.
The board comprises three types of fields: Property, Service, and Lucky fields.
Players can purchase properties for 1000 currency units and construct houses on them for 4000 currency units in subsequent rounds.
Stepping on a property owned by another player incurs a payment of 500 currency units if no house is present, or 2000 currency units if a house is built.
Service fields demand payments to the bank, with the amount being a parameter specific to the field.
Lucky fields bring fortune to the player, granting them a monetary reward defined by the field's parameter.
Each player begins the game with 10000 currency units.
# Player Strategies
Greedy Player: This player jumps at the chance to acquire unowned properties or upgrade their own properties without a house, provided they have sufficient funds.
Careful Player: Cautious and calculated, this player limits their purchases in each round to half of their total funds.
Tactical Player: The master tactician, this player strategically skips every other opportunity to buy, allowing for more calculated moves.
