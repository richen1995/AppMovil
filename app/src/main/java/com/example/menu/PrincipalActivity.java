package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.menu.entidades.ComunicaFragDetalle;
import com.example.menu.entidades.Material;
import com.example.menu.fragmentdrawer.FragCotizaciones;
import com.example.menu.fragmentdrawer.FragDrawMain;
import com.example.menu.fragmento.FragDetalleMaterial;
import com.example.menu.fragmento.PrimerFragment;
import com.example.menu.fragmento.SegundoFragment;
import com.example.menu.fragmento.TercerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class    PrincipalActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, ComunicaFragDetalle {
    /*llamado al DRAWER o Menu desplegable https://www.youtube.com/watch?v=0EIU5R_zHUc&t=1208s*/
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    /*.............................................*/

    /*///////Esto es un Prueba//////////*/
        //private NavController navController;
    /*//////////////////////////////////*/

    /*variables para cargar el Fragment del menu Drawer -- tuto: https://www.youtube.com/watch?v=0EIU5R_zHUc&t=1208s*/
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
    /*--------------------------------------------------------------------------------------------------------------*/

    /*variable del Fragment FragDetalleMaterial para acceder a ese fragment*/
        FragDetalleMaterial  fragDetalleMaterial;

    /*__variables de los Fragmentos__*/
    PrimerFragment primerFragment = new PrimerFragment();
    SegundoFragment segundoFragment = new SegundoFragment();
    TercerFragment tercerFragment = new TercerFragment();
    /*______________________________________*/
    TextView tvDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        /*----Codigo del Menu Desplegable DRAWER----*/
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.idDrawerLayout);
        navigationView = findViewById(R.id.nav_view);

        //-----establecer evento onclik al NavigationView -- tuto: https://www.youtube.com/watch?v=0EIU5R_zHUc&t=1208s
        navigationView.setNavigationItemSelectedListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string. open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        /*--------------------------------------*/

        /*variables para cargar el Fragment del menu Drawer -- tuto: https://www.youtube.com/watch?v=0EIU5R_zHUc&t=1208s*/
            /*fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.frame_drawer, new FragDrawMain());
            fragmentTransaction.commit();*/
        /*--------------------------------------------------------------------------------------------------------------*/

        /*///////Esto es un Prueba//////////*/
        //navController = Navigation.findNavController(this, R.id.frame_container);
        /*//////////////////////////////////*/

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
         navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
            //----pasar datos Ativity a Activity con fragments-------https://es.stackoverflow.com/questions/67985/pasar-datos-desde-activity-a-fragments----
                Bundle bundle = getIntent().getExtras();
                String cedula = bundle.getString("CEDULA");
                Bundle args = new Bundle();
                args.putString("CEDULA",cedula);
                primerFragment.setArguments(args);
            //-----------------------------------------------------------------------

        loadFragment(primerFragment);
        /*______________________________________*/

    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch(item.getItemId()){
                case R.id.firstFragment:
                    loadFragment(primerFragment);
                    return true;
                case R.id.secondFragment:
                    loadFragment(segundoFragment);
                    return true;
                case R.id.thirdFragment:
                    loadFragment(tercerFragment);
                    return true;
            }
            return false;
        }
    };

    public void loadFragment(Fragment fragment){
        /*FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container,fragment);
        transaction.commit();*/

        /*esto es una prueba*/
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_drawer,fragment);
        fragmentTransaction.commit();

    }

    @Override //Tutorial Navigacion Drawer
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if(item.getItemId() == R.id.mHome){
          /*Codigo para abrir un nuevo Fragment*/
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_drawer, new FragDrawMain());
            fragmentTransaction.commit();
          /*--------------------------------*/
            /*esto es una prueba*/
            //loadFragment(tercerFragment);
            //return true;
            /*------------------*/

            /*--------------------------------*/
            /*esto es otra prueba*/
            //loadFragment(tercerFragment);
            //return true;
            /*------------------*/

        }
        if(item.getItemId() == R.id.mCotizaciones){
            /*Codigo para abrir un nuevo Fragment*/
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_drawer, new FragCotizaciones());
            fragmentTransaction.commit();
            /*--------------------------------*/

            /*esto es una prueba*/
            //loadFragment(segundoFragment);
            //return true;
            /*------------------*/
        }
        return false;

        /*-----Este odigo es de otro tutorial---https://www.youtube.com/watch?v=W-Os-qa_t_8&t=1291s --para tratar de solucionar el problema del drawer-*/
        //selectItemNav(item);
        //return true;
    }

    /*-----Este odigo es de otro tutorial---https://www.youtube.com/watch?v=W-Os-qa_t_8&t=1291s ---para tratar de solucionar el problema del drawer-*/
    //private void selectItemNav(MenuItem item) {
    //    fragmentManager = getSupportFragmentManager();
    //    fragmentTransaction = fragmentManager.beginTransaction();

    //    switch(item.getItemId()){
    //        case R.id.mCotizaciones:
    //            fragmentTransaction.replace(R.id.frame_container, new FragCotizaciones()).commit();
    //            break;
    //    }
    //    drawerLayout.closeDrawers();
    //}

    @Override
    public void enviarOBJMaterial(Material material) {//tuto:  https://www.youtube.com/watch?v=vC8C89MsqlI 12:59
         //Progaramacion clave para dar paso al envio del objeto
        fragDetalleMaterial = new FragDetalleMaterial();
        Bundle bundleEnvio = new Bundle();//Bundle se usa para pasar datos entre actividades | instanciar objeto Bundle para transportar la informacio
        bundleEnvio.putSerializable("objetoMaterial", material);//enviar el objeto con SERIALIZBLE
        fragDetalleMaterial.setArguments(bundleEnvio);

        /*Codigo para abrir un nuevo Fragment*/
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_drawer, fragDetalleMaterial);
        fragmentTransaction.addToBackStack(null);//permit recupear el fragmento anterior en este caso es el fragment PrimerFragment
        fragmentTransaction.commit();
    }
}