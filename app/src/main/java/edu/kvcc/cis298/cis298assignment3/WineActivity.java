package edu.kvcc.cis298.cis298assignment3;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class WineActivity extends SingleFragmentActivity {

    private static final String EXTRA_WINE_NO =
            "edu.kvcc.cis298.cis298assignment3.wine_number_extra";

    public static Intent CreateNewIntent(Context packageContext, String wineNumber) {
        Intent intent = new Intent(packageContext, WineActivity.class);
        intent.putExtra(EXTRA_WINE_NO, wineNumber);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        String wineNumber = (String) getIntent().getSerializableExtra(EXTRA_WINE_NO);
        return WineFragment.CreateNewFragment(wineNumber);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
