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
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.menu.entidades.ComunicaFragDetalle;
import com.example.menu.entidades.Material;
import com.example.menu.fragmentdrawer.FragCotizaciones;
import com.example.menu.fragmentdrawer.FragDrawMain;
import com.example.menu.fragmento.CableadoFragment;
import com.example.menu.fragmento.FragDetalleMaterial;
import com.example.menu.fragmento.PrimerFragment;
import com.example.menu.fragmento.SegundoFragment;
import com.example.menu.fragmento.TercerFragment;
import com.example.menu.fragmento.VideoVigilanciaFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class  PrincipalActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, ComunicaFragDetalle, View.OnClickListener {
    /*llamado al DRAWER o Menu desplegable https://www.youtube.com/watch?v=0EIU5R_zHUc&t=1208s*/
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    /*.............................................*/

    /*----Inicializando Bottom Navigation para poder mostrarlo u ocultarlo----*/
        BottomNavigationView navigation;
    /*------------------------------------*/

    /*variables para cargar el Fragment del menu Drawer -- tuto: https://www.youtube.com/watch?v=0EIU5R_zHUc&t=1208s*/
        FragmentManager fragmentManager;
        FragmentTransaction fragmentTransaction;
    /*--------------------------------------------------------------------------------------------------------------*/

    /*----------------------------------abrir fragment a partir de horiontal-menu-------------------------------------*/
       Button btn;//prueba para abrir fragment
    /*--------------------------------------------------------------------------------------------------------------*/

    /*variable del Fragment FragDetalleMaterial para acceder a ese fragment*/
        FragDetalleMaterial  fragDetalleMaterial;

    /*__variables de los Fragmentos__*/
    PrimerFragment primerFragment = new PrimerFragment();
    SegundoFragment segundoFragment = new SegundoFragment();
    TercerFragment tercerFragment = new TercerFragment();
    FragCotizaciones fragCotizaciones = new FragCotizaciones();
    /*______________________________________*/
    TextView tvDatos;

    //esto es una prueba
    HorizontalScrollView horizontalScrollView;

    //------Instancias de los fragmnts q perteneces al menu Horizontal Scroll View---------//
    //PrimerFragment primerFragment = new PrimerFragment();
        VideoVigilanciaFragment videoVigilanciaFragment = new VideoVigilanciaFragment();
        CableadoFragment cableadoFragment = new CableadoFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        /*----Codigo del Menu Desplegable DRAWER----*/
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.idDrawerLayout);
        navigationView = findViewById(R.id.nav_view);

        horizontalScrollView = findViewById(R.id.horizontalScrollView);//inicializando el menu horizontal par habilitarlo y desabilitarlo

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

        /*----Inicializar el view del layout Bottom View----*/
            //btnNavView = (BottomNavigationView)
        /*--------------------------------------------------*/

         navigation = findViewById(R.id.bottom_navigation);
         navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
            //----pasar datos Ativity a Activity con fragments-------https://es.stackoverflow.com/questions/67985/pasar-datos-desde-activity-a-fragments----
                Bundle bundle = getIntent().getExtras();
                String cedula = bundle.getString("CEDULA");
                Bundle args = new Bundle();
                args.putString("CEDULA",cedula);
                primerFragment.setArguments(args);
            //-----------------------------------------------------------------------

        loadFragment(primerFragment);
        /*_____________________________________*/

        /*------Provando el abrir fragment a partir del scroll view--------*/
        //probando el click en el horizontal
         /*btn = findViewById(R.id.button1);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame_drawer, new VideoVigilanciaFragment());
                    fragmentTransaction.commit();
                }
            });*/
        /*-----------------------------------------------------------------*/

        /*----------declarando e inicializando el click en el horizontal-----------*/
        Button btnTodos     = findViewById(R.id.btn_todos);
        Button btnCamaras   = findViewById(R.id.btn_camaras);
        Button btnCableado  = findViewById(R.id.btn_cableado);

        btnTodos.setOnClickListener(this);
        btnCamaras.setOnClickListener(this);
        btnCableado.setOnClickListener(this);
        /*-------------------------------------------------------------------------*/
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch(item.getItemId()){
                case R.id.firstFragment:
                    loadFragment(primerFragment);
                    horizontalScrollView.setVisibility(View.VISIBLE);//haciedo visible el menu inicialmente oculto
                    return true;
                case R.id.secondFragment:
                    loadFragment(segundoFragment);
                    horizontalScrollView.setVisibility(View.GONE);//ocultando menu horizontal
                    return true;
                case R.id.thirdFragment:
                    horizontalScrollView.setVisibility(View.GONE);//ocultando menu horizontal
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
            /*fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_drawer, new PrimerFragment());
            fragmentTransaction.commit();*/
          /*--------------------------------*/
            /*esto es una prueba*/
            //loadFragment(tercerFragment);
            //return true;
            /*------------------*/

            loadFragment(primerFragment);
            navigation.setVisibility(View.VISIBLE);
        }
        if(item.getItemId() == R.id.mCotizaciones){
            /*Codigo para abrir un nuevo Fragment*/
            /*fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_drawer, new FragCotizaciones());
            fragmentTransaction.commit();*/
            /*--------------------------------*/

            /*esto es una prueba*/
            //loadFragment(segundoFragment);
            //return true;
            /*------------------*/

            /*esto es otra prueba para ocltar o ver el Bottom Navigation*/
            loadFragment(fragCotizaciones);
            navigation.setVisibility(View.GONE);
            horizontalScrollView.setVisibility(View.GONE);//ocultando menu horizontal
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

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_todos:
                loadFragment(primerFragment);
                horizontalScrollView.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_camaras:
                loadFragment(videoVigilanciaFragment);
                //horizontalScrollView.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_cableado:
                loadFragment(cableadoFragment);
                //horizontalScrollView.setVisibility(View.VISIBLE);
                break;
        }
    }
}