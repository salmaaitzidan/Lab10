package com.example.navigationdrawerdemo;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

/**
 * MainActivity – Activité principale hébergeant le Navigation Drawer.
 *
 * Architecture :
 *  - Un DrawerLayout contient le contenu principal + le panneau latéral.
 *  - NavigationView gère le menu latéral (res/menu/activity_main_drawer.xml).
 *  - Un FrameLayout (R.id.contenu) sert de conteneur pour les fragments.
 *  - onNavigationItemSelected() remplace le fragment affiché au clic de menu.
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    // ─────────────────────────────────────────────────────────────────
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Toolbar personnalisée (remplace l'ActionBar par défaut)
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // 2. DrawerLayout + toggle hamburger ↔ flèche retour
        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // 3. NavigationView : écoute les clics du menu
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // 4. Afficher Fragment 1 par défaut au lancement
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.contenu, new BlankFragment())
                    .commit();
            navigationView.setCheckedItem(R.id.nav_fragment1);
        }
    }

    // ─────────────────────────────────────────────────────────────────
    /**
     * Gère les clics sur les éléments du menu latéral.
     * Chaque item remplace le fragment courant par le fragment correspondant.
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_fragment1) {
            // Fragment 1 – fond rose pastel
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.contenu, new BlankFragment())
                    .commit();

        } else if (id == R.id.nav_fragment2) {
            // Fragment 2 – fond bleu indigo
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.contenu, new BlankFragment2())
                    .commit();

        } else if (id == R.id.nav_list) {
            // Fragment List – liste de 10 éléments via ListFragment
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.contenu, new FragmentList())
                    .commit();
        }

        // Fermer le drawer après sélection
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    // ─────────────────────────────────────────────────────────────────
    /** Ferme le drawer si ouvert, sinon comportement normal retour. */
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
