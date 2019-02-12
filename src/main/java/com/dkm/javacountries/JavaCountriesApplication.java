// 1

package com.dkm.javacountries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaCountriesApplication
{
    static CountryListCreator countriesList;

    public static void main(String[] args)
    {
        countriesList = new CountryListCreator();
        SpringApplication.run(JavaCountriesApplication.class, args);
    }
}

