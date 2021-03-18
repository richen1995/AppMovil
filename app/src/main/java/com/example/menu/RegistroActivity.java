package com.example.menu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.menu.entidades.ApiService;
import com.example.menu.entidades.Servicio;
import com.example.menu.entidades.Usuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroActivity extends AppCompatActivity {

    /*//TextView tvDate;
    ImageView ivDate;
    EditText etDate;
    DatePickerDialog.OnDateSetListener setListener;

    //======Var. de elemento spinner===========
    private Spinner spinnerprov, spinnercity;
    //=========================================*/

    Button btnAtras;
    Button btnPrincipal;
    ApiService apiService;
    EditText etEmail;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    /*
    //====================================Formato de Fecha=============================================
        ivDate = findViewById(R.id.iv_Date);
        etDate = findViewById(R.id.et_Date);
        Calendar calendario = Calendar.getInstance();
        final int year   = calendario.get(calendario.YEAR);
        final int month  = calendario.get(calendario.MONTH);
        final int day    = calendario.get(calendario.DAY_OF_MONTH);
        ivDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(RegistroActivity.this
                                                                            ,android.R.style.Theme_Holo_Light_Dialog_MinWidth
                                                                            ,setListener,year,month,year);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = day+"/"+month+"/"+year;
                etDate.setText(date);
            }
        };

        /*etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        RegistroActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;
                        String date = day+"/"+month+"/"+year;
                        etDate.setText(date);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });*/
    //==================================================================================================
    /*
    //============================Spinner o combobox para Ciudad y Provincia============================
        spinnerprov = (Spinner) findViewById(R.id.sp_provincia);
        spinnercity = (Spinner) findViewById(R.id.sp_ciudad);
        String [] vecspinnerprov = {"Tungurahua","Napo","Pichincha","Quito"};
        String [] vecspinnercity = {"Ambato","Baños","Pelileo","Patate"};
        ArrayAdapter<String> adapterspinnerprov = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,vecspinnerprov);
        ArrayAdapter<String> adapterspinnercity = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,vecspinnercity);
        spinnerprov.setAdapter(adapterspinnerprov);
        spinnercity.setAdapter(adapterspinnercity);
    //==================================================================================================
    */

        //============================Cod prueba para guardar datos serializacion===========================
        /*btnAtras =  findViewById(R.id.btnAtras);
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

        //=====================================================================================

        //==============Botones para ir a ventana Principal=====================================
        //btnPrincipal = findViewById(R.id.BtnActPrincipal);
        //btnPrincipal.setOnClickListener(v -> callGetApiService());
        //=====================================================================================
    }


    //==============Botones para ir a ventana Principal=====================================
    private void callGetApiService() {
        etEmail = (EditText) findViewById(R.id.editTextTextPersonName);
        etPassword = (EditText)findViewById(R.id.editTextTextPassword);

        String emaill = etEmail.getText().toString();
        String pass = etPassword.getText().toString();

        apiService = RestEngine.getRestEngine().create(ApiService.class);
        Call<Usuario> call = apiService.getUsuarioEmailPassword(etEmail.toString(), etPassword.toString());

        //peticion ASINCRONA
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Toast.makeText(com.example.menu.RegistroActivity.this, "OK", Toast.LENGTH_SHORT).show();
                Log.d("call", call + "");
                Log.d("response", response + "");
                //-----------------Recycler View ---esto no es del tutorial (https://www.youtube.com/watch?v=QiYGqYVGQSk) sino de este https://www.youtube.com/watch?v=7-l5yCaF8MM&list=LL&index=25
                /*if(response.isSuccessful()){
                    ArrayList<Usuario> usuarios = response.body();
                    fnAdaptador.setDataSet(servicios);
                }*/
                //------------------------------------------------------------------------------------------------------
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(com.example.menu.RegistroActivity.this,"ERROR",Toast.LENGTH_SHORT).show();
            }
        });
    }
    //=====================================================================================

    //============================Cod prueba para guardar datos serializacion===========================
    public Servicio createServicio(){
        Servicio objServicio = new Servicio();
        objServicio.setSrvEstado(true);
        objServicio.setSrvNombre("CONTROL PERIMETRAL" );
        objServicio.setSrvTipo("mantenimiento");
        return objServicio;
    }

    public void saveServicio(Servicio servicio){
        //Call<Servicio> callServicio = RestEngine.getServicio();
    }
    //=====================================================================================





    public void atrasRegistro(View view){
        Intent sig_registro = new Intent(this,MainActivity.class);
        startActivity(sig_registro);
    }

}