// 5

package com.dkm.javacountries;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class NamesController
{
    @RequestMapping("/all")
    public ArrayList<Country> sortAllCountriesAlphabetically()
    {
        JavaCountriesApplication.countriesList.countryList.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        return JavaCountriesApplication.countriesList.countryList;
    }

    @RequestMapping("/begin")
    public ArrayList<Country> filterCountryByLetter(@RequestParam(value="letter") char letter)
    {
        ArrayList<Country> givenLetter = new ArrayList<>();

        for (Country e : JavaCountriesApplication.countriesList.countryList)
        {
            if (Character.toLowerCase(e.getName().charAt(0)) == Character.toLowerCase(letter))
            {
                givenLetter.add(e);
            }
        }
        return givenLetter;
    }

    @RequestMapping("/size")
    public ArrayList<Country> filterCoutryByLength(@RequestParam(value="letters") int length)
    {
        ArrayList<Country> givenLength = new ArrayList<>();

        for (Country e : JavaCountriesApplication.countriesList.countryList)
        {
            if (e.getName().length() >= length)
            {
                givenLength.add(e);
            }
        }
        return givenLength;
    }

}
//
//  /names/all
//       return the names of all the countries alphabetically

//  /names/begin?letter=
//       return the countries alphabetically that begin with the given letter

//  /names/size?letters=
//       return the countries alphabetically that have a name equal to or longer than the given length
