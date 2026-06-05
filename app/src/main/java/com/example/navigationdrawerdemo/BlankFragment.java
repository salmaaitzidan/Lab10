package com.example.navigationdrawerdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * BlankFragment – Premier fragment de l'application.
 *
 * Caractéristiques :
 *  - Fond rose pastel (#F8BBD0)
 *  - Texte centré "Fragment 1"
 *  - Affiché par défaut au lancement de l'app
 *  - Accessible via "Fragment 1" dans le Navigation Drawer
 */
public class BlankFragment extends Fragment {

    public BlankFragment() {
        // Constructeur vide requis par Android
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate du layout fragment_blank.xml
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }
}
