package com.example.falljavafinal.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Listing {
    private String  propertyType;
    private String  address;
    private String  city;
    private String  zip;
    private String  location;
    private String  link;
    private int  price;
    private int  beds;
    private int  sqFt;
    private int  lotSize;
    private int  yearBuilt;
    private int  daysOnMarket;
    private int  pricePerSqFt;
    private int  hoa;
    private float  baths;
    private float  latitude;
    private float  longitude;

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getBaths() {
        return baths;
    }

    public void setBaths(float baths) {
        this.baths = baths;
    }

    public int getSqFt() {
        return sqFt;
    }

    public void setSqFt(int sqFt) {
        this.sqFt = sqFt;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public int getDaysOnMarket() {
        return daysOnMarket;
    }

    public void setDaysOnMarket(int daysOnMarket) {
        this.daysOnMarket = daysOnMarket;
    }

    public int getPricePerSqFt() {
        return pricePerSqFt;
    }

    public void setPricePerSqFt(int pricePerSqFt) {
        this.pricePerSqFt = pricePerSqFt;
    }

    public int getHoa() {
        return hoa;
    }

    public void setHoa(int hoa) {
        this.hoa = hoa;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public Listing(String propertyType, String address, String city, String zip, String location, String link, int price, int beds, int sqFt, int lotSize, int yearBuilt, int daysOnMarket, int pricePerSqFt, int hoa, float baths, float latitude, float longitude) {
        this.propertyType = propertyType;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.location = location;
        this.link = link;
        this.price = price;
        this.baths = baths;
        this.sqFt = sqFt;
        this.lotSize = lotSize;
        this.yearBuilt = yearBuilt;
        this.daysOnMarket = daysOnMarket;
        this.pricePerSqFt = pricePerSqFt;
        this.hoa = hoa;
        this.beds = beds;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Listing{" +
                "propertyType='" + propertyType + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", location='" + location + '\'' +
                ", link='" + link + '\'' +
                ", price=" + price +
                ", beds=" + beds +
                ", sqFt=" + sqFt +
                ", lotSize=" + lotSize +
                ", yearBuilt=" + yearBuilt +
                ", daysOnMarket=" + daysOnMarket +
                ", pricePerSqFt=" + pricePerSqFt +
                ", hoa=" + hoa +
                ", baths=" + baths +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    /**
     * loadRecords
     *
     * @param fileName use this file to read in the students to be added to our students list
     */
    public static List<Listing> loadRecords(String fileName) {

        List<Listing> listings = new ArrayList<>();

        // Read in the students.csv file
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            // consume the header line
            br.readLine();
            // Read each line of the file and create a Student object for that line
            while ((line = br.readLine()) != null) {
                String[] aLine = line.split(",");
                //  String propertyType, String address, String city, String zip, String location, String link,
                //  int price, int baths, int sqFt, int lotsize, int yearBuilt, int daysOnMarket, int pricePerSqFt, int hoa,
                //  float beds, float latitude, float longitude) {

//  0               1       2       3   4       5       6       7           8       9       10          11              12              13  14      15          16
//  propertyType	address	city	zip	price	beds	baths	location	sqFt	lotSize	yearBuilt	daysOnMarket	pricePerSqFt	hoa	link	latitude	longitude
                if ( aLine[4 ].length() == 0)   aLine[4 ] = "0";
                if ( aLine[5 ].length() == 0)   aLine[5 ] = "0";
                if ( aLine[6 ].length() == 0)   aLine[6 ] = "0";
                if ( aLine[8 ].length() == 0)   aLine[8 ] = "0";
                if ( aLine[9 ].length() == 0)   aLine[9 ] = "0";
                if ( aLine[10].length() == 0)   aLine[10] = "0";
                if ( aLine[11].length() == 0)   aLine[11] = "0";
                if ( aLine[12].length() == 0)   aLine[12] = "0";
                if ( aLine[13].length() == 0)   aLine[13] = "0";
                if ( aLine[15].length() == 0)   aLine[15] = "0";
                if ( aLine[16].length() == 0)   aLine[16] = "0";

                Listing listing = new Listing(aLine[0], aLine[1], aLine[2], aLine[3], aLine[7], aLine[14],
                        Integer.parseInt(aLine[4]),  Integer.parseInt(aLine[5]),  Integer.parseInt(aLine[8]),
                        Integer.parseInt(aLine[9]),  Integer.parseInt(aLine[10]), Integer.parseInt(aLine[11]),
                        Integer.parseInt(aLine[12]), Integer.parseInt(aLine[13]),
                        Float.parseFloat(aLine[6]),  Float.parseFloat(aLine[15]), Float.parseFloat(aLine[16]));
                listings.add(listing);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // handle exception
        }
        return listings;
    }
}
