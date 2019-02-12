package com.dkm.javacountries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;

@RestController
@RequestMapping("/age")
public class AgeController
{
    @RequestMapping("/age")
    public ArrayList<Country> overMedianAge(@RequestParam(value="age") int age)
    {
        ArrayList<Country> countriesOverMedian = new ArrayList<>();

        for (Country e : JavaCountriesApplication.countriesList.countryList)
        {
            if (e.getMedianAge() > age)
            {
                countriesOverMedian.add(e);
            }
        }

        return countriesOverMedian;
    }

    private Country YoungestAndOldest(String YO)
    {
        ArrayList<Country> sortedByAge = JavaCountriesApplication.countriesList.countryList;
        sortedByAge.sort(Comparator.comparingInt(Country::getMedianAge));

        if (YO.equalsIgnoreCase("youngest"))
        {
            return sortedByAge.get(0);
        }
        else
        {
            return sortedByAge.get(sortedByAge.size()-1);
        }
    }

    @RequestMapping("/min")
    public Country minAge()
    {
        return YoungestAndOldest("youngest");
    }

    @RequestMapping("/max")
    public  Country maxAge()
    {
        return YoungestAndOldest("oldest");
    }

}
