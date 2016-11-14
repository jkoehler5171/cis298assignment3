package edu.kvcc.cis298.cis298assignment3;

/**
 * Created by Jordan on 11/11/2016.
 */

public class WineItem {

    private String mWineNumber;
    private String mWineDescription;
    private String mWinePack;
    private Double mWinePrice;
    private String mWineAvailability;

    public WineItem(String number, String description, String pack, Double price, String availability)
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

    public Double getmWinePrice() {
        return mWinePrice;
    }

    public void setmWinePrice(Double mWinePrice) {
        this.mWinePrice = mWinePrice;
    }

    public String getmWineAvailability() {
        return mWineAvailability;
    }

    public void setmWineAvailability(String mWineAvailability) {
        this.mWineAvailability = mWineAvailability;
    }
}
