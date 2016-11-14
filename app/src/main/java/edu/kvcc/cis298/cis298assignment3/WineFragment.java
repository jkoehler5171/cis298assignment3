package edu.kvcc.cis298.cis298assignment3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Created by Tomato on 11/13/2016.
 */

public class WineFragment extends Fragment {

    private static final String ARG_WINE_ID = "wine_number";


    private WineItem mWine;

    private EditText mWineDescription;
    private EditText mWineNumber;
    private EditText mWinePack;
    private CheckBox mWineAvailability;

    public static WineFragment CreateNewFragment(String wineNumber) {

        Bundle args = new Bundle();
        args.putSerializable(ARG_WINE_ID, wineNumber);

        WineFragment fragment = new WineFragment();
        fragment.setArguments(args);
        return fragment;

    }

@Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    String wineNumber = (String) getArguments().getSerializable(ARG_WINE_ID);

    mWine = WineCollection.Get(getActivity()).getWineItem(wineNumber);
}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_wine,container, false);

        mWineDescription = (EditText) v.findViewById(R.id.Wine_Name);
        mWineNumber = (EditText) v.findViewById(R.id.ID_Edit_Text);
        mWinePack = (EditText) v.findViewById(R.id.Pack_Edit_Text);



        return v;
    }





}
