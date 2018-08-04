package problems

fun maximumToys(prices: Array<Int>, budget: Int): Int {
    prices.sort()

    var budgetAccrued = 0
    var numOfItems = 0
    prices.forEach { priceOfToy ->
        budgetAccrued += priceOfToy
        if(budgetAccrued <= budget) {
            numOfItems++
        } else {
            return numOfItems
        }
    }

    return numOfItems
}