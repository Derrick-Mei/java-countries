// 2

package com.dkm.javacountries;

public class Country
{
    String name;
    double population;
    double landMass;
    int medianAge;

    public Country(String name, double population, double landMass, int medianAge)
    {
        this.name = name;
        this.population = population;
        this.landMass = landMass;
        this.medianAge = medianAge;
    }

    public Country(Country somethingToClone)
    {
        this.name = somethingToClone.getName();
        this.population = somethingToClone.getPopulation();
        this.landMass = somethingToClone.getLandMass();
        this.medianAge = somethingToClone.getMedianAge();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getPopulation()
    {
        return population;
    }

    public void setPopulation(double population)
    {
        this.population = population;
    }

    public double getLandMass()
    {
        return landMass;
    }

    public void setLandMass(double landMass)
    {
        this.landMass = landMass;
    }

    public int getMedianAge()
    {
        return medianAge;
    }

    public void setMedianAge(int medianAge)
    {
        this.medianAge = medianAge;
    }
}
