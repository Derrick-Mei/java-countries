// 6

package com.dkm.javacountries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class PopulationController
{
    @RequestMapping("/size")
    public ArrayList<Country> filterByPopulationSize(@RequestParam(value="people") double people)
    {
        ArrayList<Country> populationList = new ArrayList<>();

        for (Country e : JavaCountriesApplication.countriesList.countryList)
        {
            if (e.getPopulation() >= people)
            {
                populationList.add(e);
            }
        }
        return populationList;
    }

//    public AtomicReference<Country> MaxOrMin(String string)
//    {
//        AtomicReference<Country> answer = new AtomicReference<>(JavaCountriesApplication.countriesList.countryList.get(0));
//        if (string.equalsIgnoreCase("max"))
//        {
//            JavaCountriesApplication.countriesList.countryList.forEach(o -> {
//                if (o.getPopulation() > answer.get().getPopulation())
//                {
//                    answer.set(o);
//                }
//            });
//        }
//        else
//        {
//            JavaCountriesApplication.countriesList.countryList.forEach(o -> {
//                if (o.getPopulation() < answer.get().getPopulation())
//                {
//                    answer.set(o);
//                }
//            });
//        }
//        return answer;
//    }

    public Country sortAndReturnByIndex(String maxmin)
    {
        ArrayList<Country> sortedByPopulation = JavaCountriesApplication.countriesList.countryList;
        sortedByPopulation.sort((a,b) -> (int) (b.getPopulation() - a.getPopulation()));
        if (maxmin.equalsIgnoreCase("max"))
        {
            return sortedByPopulation.get(0);
        }
        else
        {
            return sortedByPopulation.get(sortedByPopulation.size()-1);
        }
    }


    @RequestMapping("/max")
    public Country maxPopulation()
    {
        // Try 1
//        Country max2 = JavaCountriesApplication.countriesList.countryList.get(0);
//
//        for (Country e : JavaCountriesApplication.countriesList.countryList)
//        {
//            if (e.getPopulation() > max2.getPopulation())
//            {
//                max2 = e;
//            }
//        }
//
//        return max2;

        // Try 2
//        return MaxOrMin("max");

        // Try 3
        return sortAndReturnByIndex("max");
    }

    @RequestMapping("/min")
    public Country minPopulation()
    {
        // Try 1
//        Country min2 = JavaCountriesApplication.countriesList.countryList.get(0);
//
//        for (Country e : JavaCountriesApplication.countriesList.countryList)
//        {
//            if (e.getPopulation() < min2.getPopulation())
//            {
//                min2 = e;
//            }
//        }
//
//        return min2;

        // Try 2
//        return MaxOrMin("min");

        // Try 3
        return sortAndReturnByIndex("min");
    }





}

/*
/population/size?people=
    return the countries that have a population equal to or greater than the given population

/population/min
    return the country with the smallest population

/population/max
    return the country with the largest population

*/