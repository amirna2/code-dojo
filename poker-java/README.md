# Poker Hand Evaluator
Evaluate a 5 cards poker hand using TDD approach.

Cards are ranked `A`ce, `K`ing, `Q`ueen, `J`ack, 10...2
Suits are `CLUB`, `SPADE`, `DIAMOND` and `HEART`

1. **Royal flush**
```A, K, Q, J, 10``` Highest cards in sequence, all the same suit.

2. **Straight flush**
```10,9,8,7,6``` Five cards in a sequence, all in the same suit.

3. **Four of a kind**
`K, K, K, K, 8` All four cards of the same rank.

4. ***Full house***
`K, K, K, 2, 2` Three of a kind with a pair.

5. ***Flush***
Any five cards of the same suit, but not in a sequence.

6. ***Straight***
Five cards in a sequence, but not of the same suit.

7. ***Three of a kind***
Three cards of the same rank.

8. ***Two pairs***
Two different pairs.

9. ***One pair***
Two cards of the same rank.

10. ***High Card***
When you haven't made any of the hands above, the highest card plays.
