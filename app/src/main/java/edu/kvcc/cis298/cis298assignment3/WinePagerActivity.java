//Jordan Koehler
//November 14th 2016
//MW 2:30 -4:45
package edu.kvcc.cis298.cis298assignment3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.nio.BufferUnderflowException;
import java.util.List;

/**
 * Created by Jordan on 11/13/2016.
 */


//This Activity is creates a view pager for the detail view of each wine item.
public class WinePagerActivity extends AppCompatActivity {

    private  static final String EXTRA_WINE_NO = "edu.kvcc.cis298.cis298assignment3.wine_number";

    //Creates an intent so that other parts of the program may start this activity.
    public static Intent CreateNewIntent(Context packageContext, String wineNumber){
        Intent intent = new Intent(packageContext, WinePagerActivity.class);
        intent.putExtra(EXTRA_WINE_NO, wineNumber);
        return intent;
    }

    private ViewPager mViewPager;

    private List<WineItem> mWines;


    //On Create it pulls the information stored in the intent back out, sets up a view pager so we can flip freely through
    //list entries, pulls a wine list into the activity, and creates a new fragment.
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_pager);

        String wineNumber = (String) getIntent().getSerializableExtra(EXTRA_WINE_NO);

        mViewPager = (ViewPager) findViewById(R.id.Activity_Wine_Pager);

        mWines = WineCollection.Get(this).getmWineList();

        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {

                WineItem wine = mWines.get(position);

                return WineFragment.CreateNewFragment(wine.getmWineNumber());
            }

            @Override
            public int getCount() {
                return mWines.size();
            }
        });


        //Checks to see if it can find the current item in the wine list.
        for(int i = 0; i < mWines.size(); i++){
            if(mWines.get(i).getmWineNumber().equals(wineNumber)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }

    }
}
