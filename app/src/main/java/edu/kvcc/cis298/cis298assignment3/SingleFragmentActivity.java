//Jordan Koehler
//November 14th 2016
//MW 2:30 -4:45
package edu.kvcc.cis298.cis298assignment3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Jordan on 11/11/2016.
 */


//This is an abstract class that our other activities inherit from. It handles well, activities that host a single fragment.
public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected abstract Fragment createFragment();


    //On the creation of said activities, it makes sure to instantiate a fragment manager and to create a new fragment
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine);


        FragmentManager fm = getSupportFragmentManager();


        Fragment fragment = fm.findFragmentById(R.id.fragment_container);


        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
