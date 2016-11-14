//Jordan Koehler
//November 14th 2016
//MW 2:30 -4:45
package edu.kvcc.cis298.cis298assignment3;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static android.R.id.list;

/**
 * Created by Jordan on 11/11/2016.
 */

//This is a POJO built to store a collection of individual wine items.
public class WineCollection {

    private static WineCollection sWineCollection;

    private List<WineItem> mWineList;

    private Context mContext;

    //This singleton ensures that there is only ever one winecollection in the program. Don't need to make more than one
    //gigantic list of wines after all, one should certainly suffice.
    public static WineCollection Get(Context context)
    {
        if (sWineCollection == null);
        {
            sWineCollection = new WineCollection(context);
        }

        return sWineCollection;
    }

    //Constructor for the WineCollection. It can only be called from inside the winecollection.
    private WineCollection(Context context)
    {
            mWineList= new ArrayList<>();

            mContext = context;

            LoadWineList();
    }

    //Spits the wine list back out to whatever requests it.
    public List<WineItem> getmWineList() {
        return mWineList;
    }

    //Returns a specific wine item in the list that matches the passed in wine number.
    public WineItem getWineItem(String wineNumber){
        for (WineItem wineItem : mWineList) {

            if(wineItem.getmWineNumber().equals(wineNumber)) {
                return wineItem;
            }

        }
        return null;
    }

    //This is a scanner setup that loads the array with with wine items from our provided CSV.
    private void LoadWineList()
    {
        Scanner scanner = null;

        try{
            scanner = new Scanner(mContext.getResources().openRawResource(R.raw.beveragelist));

            while(scanner.hasNextLine()){

                String line = scanner.nextLine();

                String parts[] = line.split(",");

                String number = parts[0];
                String description = parts [1];
                String pack = parts [2];
                String price = parts [3];
                String availability = parts [4];

                boolean solved = (availability.equals("True")) ? true : false;

                mWineList.add(new WineItem(number, description, pack, price, solved));

            }


        }
        catch (Exception e)
        {
            Log.e("Read CSV", e.toString());
        }
        finally
        {
            if(scanner != null)
            {
            scanner.close();
            }
        }

    }

}
