package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.menu.entidades.ApiService;
import com.example.menu.entidades.Usuario;
import com.example.menu.fragmento.PrimerFragment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //==========GET==========================
    TextView tvPrueba;
    EditText etEmail, etPassword;
    Button btnSession;
    ApiService apiService;
    //========================================

    //.........boton para abrir RegistroActvity..........
    Button btnRegistro;
    //......................................

    PrimerFragment primerFragment = new PrimerFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //==========GET para email y password=======================
        btnSession = findViewById(R.id.BtnActPrincipal);
        btnSession.setOnClickListener(v -> callGetApiService());
        //=========================================================

        //................boton para abrir RegistroActvity..........
        /*btnRegistro = (Button) findViewById(R.id.BtnActRegistro);
        btnRegistro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(i);
            }
        });*/
        //.........................................................
    }

    //................boton para abrir RegistroActvity..........
    /*private void abrirActivityRegistro() {
        btnRegistro = (Button)findViewById(R.id.BtnActRegistro);
        Intent BtnSigiente = new Intent(MainActivity.this, RegistroActivity.class);
        startActivity(BtnSigiente);
    }*/
    //.........................................................

    public void SigRegistro(View view){
        Intent BtnSigiente = new Intent(MainActivity.this, PruebaActivity.class);
        startActivity(BtnSigiente);
    }
    public void SigActPrincipal(View view){
        Intent BtnSigPrincipal = new Intent(this, PrincipalActivity.class);
        startActivity(BtnSigPrincipal);
    }

    /*==========Tuto Web GET (email, password) https://www.develou.com/login-android-retrofit/ ============*/
    private void callGetApiService() {
        etEmail =    (EditText)findViewById(R.id.editTextTextPersonName);
        etPassword = (EditText)findViewById(R.id.editTextTextPassword);

        String eemail = etEmail.getText().toString();
        String epassword = etPassword.getText().toString();

        tvPrueba = (TextView) findViewById(R.id.tvPrueba);

        apiService = RestEngine.getRestEngine().create(ApiService.class);
        Call<Usuario> call = apiService.getUsuarioEmailPassword(eemail,epassword);

        //peticion ASINCRONA
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                tvPrueba.setText(response + "Lorem ipsum");
                Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
                //-----------------Recycler View ---esto no es del tutorial (https://www.youtube.com/watch?v=QiYGqYVGQSk) sino de este https://www.youtube.com/watch?v=7-l5yCaF8MM&list=LL&index=25
                if(response.isSuccessful()){
                    Usuario user = response.body();
                    String datUser = "" +
                            user.getPerCedula().getPerCedula()  + "\n" +
                            user.getPerCedula().getPerNombre()  + "\n" +
                            user.getUsEmail()                   + "\n" +
                            user.getUsPassword()                + "\n" ;

                    //tvPrueba.setText(datUser);
                    //*************pasar datos a otro activity***********************https://www.youtube.com/watch?v=lAnpyZmrwX8

                        /*Intent intent = new Intent(MainActivity.this , PrimerFragment.class);
                        intent.putExtra("CEDULA",user.getPerCedula().getPerCedula());
                        intent.putExtra("EMAIL",user.getUsEmail());
                        intent.putExtra("PASSWORD",user.getUsPassword());
                        startActivity(intent);*/
                    //***************************************************************

                    //----pasar datos Ativity a Activity con fragments-------https://es.stackoverflow.com/questions/67985/pasar-datos-desde-activity-a-fragments----
                    Bundle bundle = new Bundle();
                    Intent intent = new Intent(MainActivity.this , PrincipalActivity.class);
                    bundle.putString("CEDULA",user.getPerCedula().getPerCedula());
                    intent.putExtras(bundle);
                    startActivity(intent);
                    //----------------------------------------------------------------

                    //____________pasar datos a un Fragment_______https://www.youtube.com/watch?v=1OP1jLxgsrA_________
                    /*Bundle bundle = new Bundle();
                    bundle.putString("CEDULA",user.getPerCedula().getPerCedula());
                    primerFragment.setArguments(bundle);*/
                    //___________________________________________


                    //****pasar datos a otro activity*****https://es.stackoverflow.com/questions/36902/como-enviar-datos-entre-activities**respuesta de = Jorgesys

                    /*Bundle parametros = new Bundle();
                    parametros.putString("CEDULA",user.getPerCedula().getPerCedula());
                    parametros.putString("EMAIL",user.getUsEmail());
                    parametros.putString("PASSWORD",user.getUsPassword());

                    Intent intent = new Intent(MainActivity.this, PrincipalActivity.class);//pasar de una vista a otra
                    intent.putExtras(parametros);
                    startActivity(intent);
                    finish();*/

                    //***************************************************************


                }
                //------------------------------------------------------------------------------------------------------
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(MainActivity.this,"ERROR",Toast.LENGTH_SHORT).show();
            }
        });
    }
    /*======================================================================================================*/
}