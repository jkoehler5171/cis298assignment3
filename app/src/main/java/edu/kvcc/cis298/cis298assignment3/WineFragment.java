//Jordan Koehler
//November 14th 2016
//MW 2:30 -4:45
package edu.kvcc.cis298.cis298assignment3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

/**
 * Created by Tomato on 11/13/2016.
 */


//This fragment displays the detail information of any given wine item.
public class WineFragment extends Fragment {

    private static final String ARG_WINE_ID = "wine_number";


    private WineItem mWine;

    private EditText mWineDescription;
    private EditText mWineNumber;
    private EditText mWinePack;
    private EditText mWinePrice;
    private CheckBox mWineAvailability;

    //Method to create a new winefragment that can be called by other parts of the program.
    public static WineFragment CreateNewFragment(String wineNumber) {

        Bundle args = new Bundle();
        args.putSerializable(ARG_WINE_ID, wineNumber);

        WineFragment fragment = new WineFragment();
        fragment.setArguments(args);
        return fragment;

    }

    //On create it pulls the string storing the wine number out of the arguments, and finds the matching
    //wine item with a matching number from the list.
@Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    String wineNumber = (String) getArguments().getSerializable(ARG_WINE_ID);

    mWine = WineCollection.Get(getActivity()).getWineItem(wineNumber);
}
    //Inflates the view, and assigns information from the wine item to the widgets in the application. Should save changed
    //info back to the arraylist, but for some reason I can't get it to work.
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_wine,container, false);

        mWineDescription = (EditText) v.findViewById(R.id.Wine_Name);
        mWineDescription.setText(mWine.getmWineDescription());
        mWineDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mWine.setmWineDescription(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mWineNumber = (EditText) v.findViewById(R.id.ID_Edit_Text);
        mWineNumber.setText(mWine.getmWineNumber());
        mWineNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mWine.setmWineNumber(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mWinePack = (EditText) v.findViewById(R.id.Pack_Edit_Text);
        mWinePack.setText(mWine.getmWinePack());
        mWinePack.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mWine.setmWinePack(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mWinePrice = (EditText) v.findViewById(R.id.Price_Edit_Text);
        mWinePrice.setText(mWine.getmWinePrice());
        mWinePrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mWine.setmWinePrice(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mWineAvailability= (CheckBox)  v.findViewById(R.id.Active_Check_Box);
        mWineAvailability.setChecked(mWine.getmWineAvailability());
        mWineAvailability.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                mWine.setmWineAvailability(isChecked);
            }
        });



        return v;
    }





}
