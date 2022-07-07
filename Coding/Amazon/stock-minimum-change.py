'''
Given the stock prices of n months, the net price change for the i-th month is defined as the absolute difference between 
the average of stock prices for the first i months and for the remaining(n-i) months where 1 <= i < n. 
These averages are rounded down to an integer.

Given an array of stock prices, find the month at which the net price change is minimum. If there are several such months, 
return the earliest month.


Note: The average of a set of integers here is defined as the sum of integers divided by the number of integers, rounded down to the nearest integer.
For example, the average of[1, 2, 3, 4] is the floor of(1 + 2 + 3 + 4) / 4 = 2.5 and the floor of 2.5 is 2.

Example:

stockPrice = [1, 3, 2, 3]
The minimum net price change is 0, and it occurs in the 2nd month. Return 2.
'''


def findEarliestMonth(stockPrice):
    month = 0
    change = max(stockPrice)
    l = []
    total_sum = sum(stockPrice)
    left = 0
    left_sum = 0
    while (len(stockPrice) > 1):
        left = stockPrice.pop(0)
        l.append(left)
        left_sum += left
        avg1 = left_sum // len(l)
        avg2 = (total_sum - left_sum) // len(stockPrice)
        print(avg1, avg2)
        if (abs(avg1 - avg2) < change):
            change = abs(avg1 - avg2)
            month = len(l)
    return month
