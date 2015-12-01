package cfr334div2;

public class LiegesOfLegendre {

}
/**
E. Lieges of Legendre
time limit per test2 seconds
memory limit per test256 megabytes
inputstandard input
outputstandard output
Kevin and Nicky Sun have invented a new game called Lieges of Legendre. In this game, two players take turns modifying the game state with Kevin moving first. Initially, the game is set up so that there are n piles of cows, with the i-th pile containing ai cows. During each player's turn, that player calls upon the power of Sunlight, and uses it to either:

Remove a single cow from a chosen non-empty pile.
Choose a pile of cows with even size 2·x (x > 0), and replace it with k piles of x cows each.
The player who removes the last cow wins. Given n, k, and a sequence a1, a2, ..., an, help Kevin and Nicky find the winner, given that both sides play in optimal way.

Input
The first line of the input contains two space-separated integers n and k (1 ≤ n ≤ 100 000, 1 ≤ k ≤ 109).

The second line contains n integers, a1, a2, ... an (1 ≤ ai ≤ 109) describing the initial state of the game.

Output
Output the name of the winning player, either "Kevin" or "Nicky" (without quotes).

Sample test(s)
input
2 1
3 4
output
Kevin
input
1 2
3
output
Nicky
Note
In the second sample, Nicky can win in the following way: Kevin moves first and is forced to remove a cow, so the pile contains two cows after his move. Next, Nicky replaces this pile of size 2 with two piles of size 1. So the game state is now two piles of size 1. Kevin then removes one of the remaining cows and Nicky wins by removing the other.
*/