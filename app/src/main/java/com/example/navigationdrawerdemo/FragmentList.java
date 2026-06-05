package com.example.navigationdrawerdemo;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

/**
 * FragmentList – Fragment affichant une liste de 10 éléments.
 *
 * Hérite de ListFragment qui fournit un ListView intégré.
 * Les données sont injectées via un ArrayAdapter simple.
 *
 * Points clés :
 *  - Utilisation de android.R.layout.simple_list_item_1 (layout natif Android)
 *  - Données statiques (tableau de String) – extensible vers une source dynamique
 *  - Accessible via "Fragment List" dans le Navigation Drawer
 */
public class FragmentList extends ListFragment {

    /** Données de la liste – peut être remplacé par une source dynamique (BDD, API). */
    private static final String[] ITEMS = {
            "📱  Item 1 – Introduction Android",
            "🧩  Item 2 – Activités et Fragments",
            "🗂️  Item 3 – Navigation Drawer",
            "🎨  Item 4 – Material Design",
            "💾  Item 5 – SharedPreferences",
            "🌐  Item 6 – Requêtes réseau (Retrofit)",
            "🗄️  Item 7 – Base de données Room",
            "🔔  Item 8 – Notifications",
            "📷  Item 9 – Caméra & Médias",
            "☁️  Item 10 – Firebase & Cloud"
    };

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Création de l'adaptateur avec le layout natif simple_list_item_1
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireActivity(),
                android.R.layout.simple_list_item_1,
                ITEMS
        );

        // Association de l'adaptateur au ListFragment
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull android.view.View v,
                                int position, long id) {
        super.onListItemClick(l, v, position, id);
        // Optionnel : réaction au clic sur un élément
        // Ex : Toast.makeText(getActivity(), ITEMS[position], Toast.LENGTH_SHORT).show();
    }
}
