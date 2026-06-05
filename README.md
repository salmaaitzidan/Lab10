# NavigationDrawerDemo 🗂️

[![Android](https://img.shields.io/badge/Platform-Android-green.svg)](https://android.com)
[![API](https://img.shields.io/badge/Min%20SDK-24%20(Android%207.0)-blue.svg)](https://developer.android.com/about/versions/nougat)
[![Java](https://img.shields.io/badge/Language-Java-orange.svg)](https://www.java.com)
[![Material Design](https://img.shields.io/badge/UI-Material%20Design%203-purple.svg)](https://m3.material.io)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

> Application Android de démonstration illustrant la navigation modulaire via un **Navigation Drawer** et la gestion dynamique de **Fragments** dans une seule activité.

---

## 📱 Aperçu

| Navigation Drawer | Fragment 1 (Rose) | Fragment 2 (Bleu) | Fragment List |
|:-----------------:|:-----------------:|:-----------------:|:-------------:|
| Menu latéral avec 3 items | Fond rose `#F8BBD0` | Fond bleu `#3F51B5` | Liste 10 éléments |

---

## 🎯 Objectifs pédagogiques

Ce projet t'apprend à :

- ✅ Utiliser le modèle **Navigation Drawer Activity** d'Android Studio
- ✅ Créer et gérer plusieurs **Fragments** dans une seule `Activity`
- ✅ Manipuler le **FragmentManager** et les transactions de fragments
- ✅ Personnaliser le **menu de navigation** avec des icônes vectorielles
- ✅ Utiliser **ListFragment** pour afficher une liste simple
- ✅ Implémenter `onBackPressed()` pour fermer le drawer au retour

---

## 🏗️ Architecture du projet

```
NavigationDrawerDemo/
├── app/src/main/
│   ├── java/com/example/navigationdrawerdemo/
│   │   ├── MainActivity.java          ← Activité principale + gestion du Drawer
│   │   ├── BlankFragment.java         ← Fragment 1 (fond rose)
│   │   ├── BlankFragment2.java        ← Fragment 2 (fond bleu)
│   │   └── FragmentList.java          ← ListFragment avec 10 éléments
│   │
│   └── res/
│       ├── layout/
│       │   ├── activity_main.xml      ← DrawerLayout + NavigationView
│       │   ├── content_main.xml       ← FrameLayout conteneur des fragments
│       │   ├── nav_header_main.xml    ← En-tête du panneau latéral
│       │   ├── fragment_blank.xml     ← Layout Fragment 1
│       │   └── fragment_blank2.xml   ← Layout Fragment 2
│       ├── menu/
│       │   └── activity_main_drawer.xml ← Items du menu de navigation
│       ├── drawable/
│       │   ├── ic_home.xml            ← Icône vectorielle maison
│       │   ├── ic_dashboard.xml       ← Icône vectorielle tableau de bord
│       │   ├── ic_list.xml            ← Icône vectorielle liste
│       │   └── ic_nav_logo.xml        ← Logo dans l'en-tête du Drawer
│       └── values/
│           ├── strings.xml
│           ├── colors.xml
│           ├── themes.xml
│           └── dimens.xml
```

---

## 🧩 Composants clés expliqués

### 1. `DrawerLayout`
Conteneur racine qui gère l'affichage du panneau latéral. Il contient deux enfants directs : le contenu principal et le `NavigationView`.

```xml
<androidx.drawerlayout.widget.DrawerLayout
    android:id="@+id/drawer_layout"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <!-- Contenu principal -->
    <!-- NavigationView (panneau latéral) -->
</androidx.drawerlayout.widget.DrawerLayout>
```

### 2. `NavigationView`
Composant Material Design qui affiche l'en-tête et le menu de navigation.

```xml
<com.google.android.material.navigation.NavigationView
    android:id="@+id/nav_view"
    app:headerLayout="@layout/nav_header_main"
    app:menu="@menu/activity_main_drawer" />
```

### 3. Transactions de fragments
Le cœur de la navigation modulaire. `replace()` échange le fragment affiché :

```java
getSupportFragmentManager()
    .beginTransaction()
    .replace(R.id.contenu, new BlankFragment())  // Remplace le fragment dans FrameLayout
    .commit();                                    // Valide la transaction
```

### 4. `ListFragment`
Fragment spécialisé qui intègre nativement un `ListView` :

```java
public class FragmentList extends ListFragment {
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
            getActivity(),
            android.R.layout.simple_list_item_1,
            items
        );
        setListAdapter(adapter);  // Lie l'adaptateur au ListView intégré
    }
}
```

---

## 🚀 Installation et exécution

### Prérequis
- **Android Studio** Hedgehog (2023.1) ou version ultérieure
- **JDK 17** ou supérieur
- **Android SDK** API 24+ installé
- **Émulateur** ou appareil physique Android 7.0+

### Étapes

```bash
# 1. Cloner le dépôt
git clone https://github.com/VOTRE_USERNAME/NavigationDrawerDemo.git

# 2. Ouvrir dans Android Studio
# File > Open > sélectionner le dossier NavigationDrawerDemo

# 3. Synchroniser Gradle
# Android Studio le fera automatiquement, ou : Build > Sync Project with Gradle Files

# 4. Exécuter
# Run > Run 'app'  (Shift+F10)
```

---

## 📖 Guide de navigation dans l'app

| Action | Résultat |
|--------|----------|
| Appuyer sur l'icône ☰ (hamburger) | Ouvre le panneau Navigation Drawer |
| Sélectionner **Fragment 1** | Affiche le fond rose pastel |
| Sélectionner **Fragment 2** | Affiche le fond bleu indigo |
| Sélectionner **Fragment List** | Affiche une liste de 10 éléments thématiques |
| Appuyer sur **Retour** quand le drawer est ouvert | Ferme le drawer |
| Appuyer sur **Retour** quand le drawer est fermé | Quitte l'application |

---

## 🔧 Personnalisation

### Ajouter un nouveau fragment

1. **Créer le fragment** : `File > New > Fragment > Fragment (Blank)`

2. **Ajouter au menu** (`res/menu/activity_main_drawer.xml`) :
```xml
<item
    android:id="@+id/nav_nouveau"
    android:icon="@drawable/ic_nouvelle_icone"
    android:title="Nouveau Fragment" />
```

3. **Gérer dans `MainActivity.java`** :
```java
} else if (id == R.id.nav_nouveau) {
    getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.contenu, new NouveauFragment())
        .commit();
}
```

### Modifier les couleurs
Les couleurs principales sont dans `res/values/colors.xml` :
```xml
<color name="colorPrimary">#3F51B5</color>    <!-- Bleu indigo -->
<color name="colorAccent">#FF4081</color>      <!-- Rose accent -->
```

---

## 📦 Dépendances

```gradle
implementation 'androidx.appcompat:appcompat:1.6.1'
implementation 'com.google.android.material:material:1.11.0'
implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
implementation 'androidx.drawerlayout:drawerlayout:1.2.0'
```

---

## 📚 Concepts Android abordés

| Concept | Fichier(s) concerné(s) |
|---------|------------------------|
| Navigation Drawer | `MainActivity.java`, `activity_main.xml` |
| Fragment Manager | `MainActivity.java` → `onNavigationItemSelected()` |
| Fragment Lifecycle | `BlankFragment.java`, `BlankFragment2.java` |
| ListFragment | `FragmentList.java` |
| Vector Drawables | `res/drawable/ic_*.xml` |
| Material Themes | `res/values/themes.xml` |
| ViewBinding | `app/build.gradle` |

---

## 🔮 Extensions possibles

- [ ] Ajouter une **pile de retour** (`addToBackStack()`) pour naviguer entre les fragments
- [ ] Remplacer `ListFragment` par `RecyclerView` pour plus de flexibilité
- [ ] Intégrer **Room Database** pour des données persistantes
- [ ] Ajouter des **animations** de transition entre fragments
- [ ] Implémenter **ViewModel + LiveData** (architecture MVVM)
- [ ] Migrer vers **Navigation Component** (Jetpack)

---

## 📄 Licence

```
MIT License – libre d'utilisation, modification et distribution.
```

---

## 👨‍💻 Auteur

Projet réalisé dans le cadre d'une **formation Android – Niveau intermédiaire**.

> 💡 *Ce projet est conçu comme support pédagogique pour apprendre la navigation modulaire Android.*
