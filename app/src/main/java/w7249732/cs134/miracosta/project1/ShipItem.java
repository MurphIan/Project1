package w7249732.cs134.miracosta.project1;

import android.text.Editable;
/*
This class defines how much it costs to ship an item.
 */
public class ShipItem
{
    //Instance variables
    private Integer ounces = 0;
    double totalAddedCost = 0.0;
    private double BASE_COST = 3.00;
    private double ADDED_COST = 0.5;
    private double totalCost = 0.0;

    //Setters and Getters for all variables.
    public Integer getOunces() {
        return ounces;
    }

    /*
    This sets the ounces variable

    @param ounces the amount of ounces the package
     */
    public void setOunces(Integer ounces) {
        this.ounces = ounces;
    }

    public double getTotalAddedCost() {
        return totalAddedCost;
    }

    /*
    This holds the total amount that is added on the total cost.

    @param totalAddedCost tracks how much cost was added on the total.
     */
    public void setTotalAddedCost(double totalAddedCost) {
        this.totalAddedCost = totalAddedCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    /*
    This holds the total amount of money that will be spent on shipping

    @param totalCost this holds the total amount of money to be spent.
     */
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    /*
    This will calculate the total amount of money that is added on due to weight restrictions

    @param weight This is the number that is inputted from the user.

    @returns the total added cost
     */
    public double calculateAddedCost(double weight)
    {
        Integer howMuchOver = ounces / 4;

        totalAddedCost = howMuchOver*ADDED_COST;

        return totalAddedCost;
    }

    /*
    This calculates the entire cost of shipping for the package.

    @param weight This is the number that is inputted from the user.

    @returns the total cost.
     */
    public double calculateShippingCost(double weight)
    {
        Integer howMuchOver = 0;

        if(ounces <= 16)
        {
            totalCost = totalCost + BASE_COST;
            return totalCost;
        }
        else if(ounces % 4 == 0)
        {
            totalCost = totalCost + BASE_COST + calculateAddedCost(weight);

            return totalCost;
        }

        return totalCost;
    }
}
