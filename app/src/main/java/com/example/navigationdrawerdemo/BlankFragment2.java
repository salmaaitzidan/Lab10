package com.example.navigationdrawerdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * BlankFragment2 – Deuxième fragment de l'application.
 *
 * Caractéristiques :
 *  - Fond bleu indigo (#3F51B5)
 *  - Texte centré "Fragment 2" en blanc
 *  - Accessible via "Fragment 2" dans le Navigation Drawer
 */
public class BlankFragment2 extends Fragment {

    public BlankFragment2() {
        // Constructeur vide requis par Android
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank2, container, false);
    }
}
