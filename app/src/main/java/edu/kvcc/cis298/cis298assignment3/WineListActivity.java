package edu.kvcc.cis298.cis298assignment3;

import android.support.v4.app.Fragment;

/**
 * Created by Tomato on 11/13/2016.
 */

public class WineListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {return new WineListFragment();}
}
