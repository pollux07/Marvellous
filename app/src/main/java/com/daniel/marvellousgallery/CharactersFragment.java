package com.daniel.marvellousgallery;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Fragment that contain the information of the characters.
 */

public class CharactersFragment extends Fragment{
    public CharactersFragment() {}

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_characters,
                                            container,
                                            false);
        getCharacterList();
        return view;
    }

    private void getCharacterList() {
    }
}
