//Jordan Koehler
//November 14th 2016
//MW 2:30 -4:45
package edu.kvcc.cis298.cis298assignment3;

/**
 * Created by Jordan on 11/11/2016.
 */

//This is a POJO representing a single Wine Item. Not alot going on here. Pass in info to the constructors, auto generated
    //some getters and setters and that's about it.
public class WineItem {

    private String mWineNumber;
    private String mWineDescription;
    private String mWinePack;
    private String mWinePrice;
    private boolean mWineAvailability;

    public WineItem(String number, String description, String pack, String price, boolean availability)
    {
        mWineNumber = number;
        mWineDescription= description;
        mWinePack = pack;
        mWinePrice = price;
        mWineAvailability = availability;
    }

    public String getmWineNumber() {
        return mWineNumber;
    }

    public void setmWineNumber(String mWineNumber) {
        this.mWineNumber = mWineNumber;
    }

    public String getmWineDescription() {
        return mWineDescription;
    }

    public void setmWineDescription(String mWineDescription) {
        this.mWineDescription = mWineDescription;
    }

    public String getmWinePack() {
        return mWinePack;
    }

    public void setmWinePack(String mWinePack) {
        this.mWinePack = mWinePack;
    }

    public String getmWinePrice() {
        return mWinePrice;
    }

    public void setmWinePrice(String mWinePrice) {
        this.mWinePrice = mWinePrice;
    }

    public boolean getmWineAvailability() {
        return mWineAvailability;
    }

    public void setmWineAvailability(boolean mWineAvailability) {
        this.mWineAvailability = mWineAvailability;
    }
}
