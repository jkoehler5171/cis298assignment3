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

public class WineCollection {

    private static WineCollection sWineCollection;

    private List<WineItem> mWineList;

    private Context mContext;

    public static WineCollection Get(Context context)
    {
        if (sWineCollection == null);
        {
            sWineCollection = new WineCollection(context);
        }

        return sWineCollection;
    }


    private WineCollection(Context context)
    {
            mWineList= new ArrayList<>();

            mContext = context;

            LoadWineList();
    }

    public List<WineItem> getmWineList() {
        return mWineList;
    }

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
                Double price = Double.parseDouble(parts [3]);
                String availability = parts [4];

                mWineList.add(new WineItem(number, description, pack, price, availability));

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
