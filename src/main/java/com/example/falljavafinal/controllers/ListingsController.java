package com.example.falljavafinal.controllers;

import com.example.falljavafinal.models.Listing;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/listings")
public class ListingsController {

    //  this is the List of Listings
    //      add real estate properties are saved in this List
    private List<Listing> listings;

    //  this is our Controller constructor.
    //      here we will load the Listings.csv file
    //      which will be our database listing of homes in Dallas
    public ListingsController() {
        listings = Listing.loadRecords("src/Listings.csv");
    }

    //  This entry point will list all properties
    //
    //      If you want to see all the attributes of our Listing object they are listed below
    //          propertyType,address,city,zip,price,beds,baths,location,sqFt,lotSize,
    //          yearBuilt,daysOnMarket,pricePerSqFt,hoa,link,latitude,longitude
    @RequestMapping("/")
    public String list(Model model) {
        model.addAttribute("title", "Dallas Property Listings");
        model.addAttribute("criteria", "All Properties");
        model.addAttribute("listings", listings);
        return "listings";
    }

    //  entry point provided for you for the search request in the listing page
    //      initially in only receives the city name. You will add more to it in this exam
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam String city, @RequestParam Integer price,
                         @RequestParam Integer sqFt, @RequestParam Integer beds, Model model) {
        List<Listing> matchedHomes = listings;

        String criteria = "Found Matching Listings:";

        if (city != null && city.length() > 0) {
            matchedHomes = matchedHomes.stream().filter(l -> l.getCity().indexOf(city) >= 0).collect(Collectors.toList());
            criteria += " for City: " + city;
        }

        //  TODO you need to add the code here to search by Sq Ft

        if (price != null && price > 0) {
            matchedHomes = matchedHomes.stream().filter(l -> l.getPrice() <= price).collect(Collectors.toList());
            criteria += ", for less than $" + price;
        }

        if (beds != null && beds > 0) {
            matchedHomes = findByBeds(matchedHomes, beds);
            criteria += ", " + beds + "+ beds";
        }

        model.addAttribute("title", "Home Listings");
        model.addAttribute("criteria", criteria);
        model.addAttribute("listings", matchedHomes);

        model.addAttribute("city", city);
        model.addAttribute("beds", beds);

        return "listings";
    }

    /**
     *
     * @param list      a list of homes
     * @param beds      minimum number of beds
     * @return          a list of homes with at least the number of beds desired
     *
     *      This is a method to loop through all the homes in the provided list
     *      If the home has at least the number of beds requested
     *      save that home to the list of suggested homes for the home buyer
     */
    public List<Listing> findByBeds(List<Listing> list, int beds) {
        //  shortList will contain the listings with at least the number of bed rooms searched for
        List<Listing> shortList = new ArrayList<>();

        //  look at all listings. One at a time
        for (Listing Listing : list) {
            //  check to see if the first or last name contains the name given
            //  we will convert the first and last names to lowercase since contains does a case sensitive compare
            if (Listing.getBeds() >= beds) {
                shortList.add(Listing);
            }
        }
        //  return the list of Listings we found matching the name provided
        return shortList;
    }
}
