'''
Amazon Prime Games is designing a game. The player needs to pass n rounds sequentially in this game. Rules of play are as 
follows:

    - The player loses power[i] health to complete round i.
    - The player's health must be greater than 0 at all times.
    - The player can choose to use armor in any one round. The armor will prevent damage of min(armor, power[i]).
 

Determine the minimum starting health for a player to win the game.

Example:
power = [1, 2, 6, 7]
armor = 5
Give the player 12 units of health at the beginning of the game. One of the optimal strategies is to use the armor in the 
third round and only lose 1 unit instead of 6. The health of the player after each round is:
Round, health
12
12-power[0] =12-1=11
11 - power[1] = 11-2=9
9-power[2]+armor=9-6+5=8
8-power[3] =8-7=1
'''


def findMinHealth(power, armor):
    n = len(power)
    ans = 0
    arm = True
    maxPower = 0
    for i in range(n):
        if power[i] > armor and arm == True:
            ans += power[i] - armor
            arm = False
        else:
            ans += power[i]
        maxPower = max(maxPower, power[i])
    if arm == True:
        ans -= maxPower
        arm = False
    return ans + 1
