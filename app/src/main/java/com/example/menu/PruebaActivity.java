package com.example.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.menu.entidades.ApiService;
import com.example.menu.entidades.CidCodigo;
import com.example.menu.entidades.PerCedula;
import com.example.menu.entidades.PmId;
import com.example.menu.entidades.Servicio;
import com.example.menu.entidades.Usuario;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class
PruebaActivity extends AppCompatActivity {
    TextView tvDate;
    ImageView ivDate;
    EditText etDate;
    DatePickerDialog.OnDateSetListener setListener;

    //======Var. de elemento spinner===========
    private Spinner spinnerprov, spinnercity;
    //=========================================

    Button btnAtras;
    Button btnPrincipal;
    ApiService apiService;
    //ApiService apiService1;
    EditText etEmail;
    EditText etPassword;

    //----------Inicializacion de views del Formulario-------------
    EditText etcedula;
    EditText etnombre;
    EditText etapellido;
    EditText etcelular;
    EditText etRUC;
    EditText etfechnac;
    Spinner spprovincia;
    Spinner spciudad;
    EditText etdireccion;
    EditText etemail;
    EditText etpassword;
    //-------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);



        //====================================Formato de Fecha=============================================
            ivDate = findViewById(R.id.ivDate);
            etDate = findViewById(R.id.etFechNac);
            Calendar calendario = Calendar.getInstance();
            final int year   = calendario.get(calendario.YEAR);
            final int month  = calendario.get(calendario.MONTH);
            final int day    = calendario.get(calendario.DAY_OF_MONTH);
            ivDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DatePickerDialog datePickerDialog = new DatePickerDialog(PruebaActivity.this
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
        //==================================================================================================


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


        //==============Botones para ir a ventana Principal=====================================
        /*btnPrincipal = findViewById(R.id.btnGuardarReg);
        //btnPrincipal.setOnClickListener(v -> callPostApiService());
         btnPrincipal.setOnClickListener(v -> {
             try {
                 callPostPersonaApiService();
             } catch (JSONException e) {
                 e.printStackTrace();
             }
         });*/
        //=====================================================================================



    }
/////////////////////////////////////////////////////////////////////////////////////////////
//------------------------METODOS O FUNCIONES DE PruebaActivity------------------------------
/////////////////////////////////////////////////////////////////////////////////////////////

    //-----oNClick------------Boton Guardar-------------------
    public void funcValidarForm(View view){
        if(validarFormulario())
        {
            Toast.makeText(this, "Ingreso datos Correctamete", Toast.LENGTH_SHORT).show();
            btnPrincipal = findViewById(R.id.btnGuardarReg);
            //btnPrincipal.setOnClickListener(v -> callPostApiService());
            btnPrincipal.setOnClickListener(v -> {
                try {
                    callPostPersonaApiService();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            });
        }
    }
    //--------------------------------------------------------

    //==============Botones para ir a ventana Principal=====================================
    /*private void callPostApiService() {
        //etEmail = (EditText) findViewById(R.id.editTextTextPersonName);
        //etPassword = (EditText)findViewById(R.id.editTextTextPassword);

        //String emaill = etEmail.getText().toString();
        //String pass = etPassword.getText().toString();

        apiService = RestEngine.getRestEngine().create(ApiService.class);
        Call<Servicio> call = apiService.setServicio(createServicio());

        //peticion ASINCRONA
        call.enqueue(new Callback<Servicio>() {
            @Override
            public void onResponse(Call<Servicio> call, Response<Servicio> response) {
                Toast.makeText(com.example.menu.PruebaActivity.this, "OK", Toast.LENGTH_SHORT).show();
                Log.d("call", "--" + call + "--");
                Log.d("response", "--" + response + "--");
                //-----------------Recycler View ---esto no es del tutorial (https://www.youtube.com/watch?v=QiYGqYVGQSk) sino de este https://www.youtube.com/watch?v=7-l5yCaF8MM&list=LL&index=25
                if(response.isSuccessful()){
                    Toast.makeText(com.example.menu.PruebaActivity.this, "OK 100%", Toast.LENGTH_SHORT).show();
                    /*ArrayList<Usuario> usuarios = response.body();
                    fnAdaptador.setDataSet(servicios);*/
                /*}
                //------------------------------------------------------------------------------------------------------
            }

            @Override
            public void onFailure(Call<Servicio> call, Throwable t) {
                Toast.makeText(com.example.menu.PruebaActivity.this,"ERROR",Toast.LENGTH_SHORT).show();
            }
        });
    }*/
    //=====================================================================================

    //==============Botones para almacenar un registro de una Persona=====================================
    private void callPostPersonaApiService() throws JSONException {

        apiService = RestEngine.getRestEngine().create(ApiService.class);
        Call<PerCedula> call = apiService.setPersona(createPersona());

        //peticion ASINCRONA
        call.enqueue(new Callback<PerCedula>() {
            @Override
            public void onResponse(Call<PerCedula> call, Response<PerCedula> response) {
                Toast.makeText(com.example.menu.PruebaActivity.this, "OK a Medias", Toast.LENGTH_SHORT).show();
                Log.d("call", "////" + call + "////");
                Log.d("response", "////" + response + "////");
                //-----------------Recycler View ---esto no es del tutorial (https://www.youtube.com/watch?v=QiYGqYVGQSk) sino de este https://www.youtube.com/watch?v=7-l5yCaF8MM&list=LL&index=25
                if(response.isSuccessful()){
                    Toast.makeText(com.example.menu.PruebaActivity.this, "OK 100%", Toast.LENGTH_SHORT).show();
                    /*ArrayList<Usuario> usuarios = response.body();
                    fnAdaptador.setDataSet(servicios);*/
                    PerCedula objPersona = new PerCedula();
                    objPersona = response.body();
                    try {
                        crearCuenta(objPersona);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                //------------------------------------------------------------------------------------------------------
            }

            @Override
            public void onFailure(Call<PerCedula> call, Throwable t) {
                Toast.makeText(com.example.menu.PruebaActivity.this,"ERROR",Toast.LENGTH_SHORT).show();
            }
        });
    }
    //=====================================================================================


    //============================Cod prueba para guardar datos serializacion===========================
    public Servicio createServicio(){
        Servicio objServicio = new Servicio();
        objServicio.setSrvEstado(true);
        objServicio.setSrvNombre("CONTROL PPRUEBA4");
        objServicio.setSrvTipo("mantenimiento");
        return objServicio;
    }

    /*public void saveServicio(Servicio servicio){
        //Call<Servicio> callServicio = RestEngine.getServicio();
    }*/
    //=====================================================================================

    //============================Cod prueba para guardar datos serializacion===========================
    public PerCedula createPersona() throws JSONException { //entidad PERSONA
      //--------------Recolectar datos el Formulario------
        etcedula =    (EditText)findViewById(R.id.etCedula);
        etnombre =    (EditText)findViewById(R.id.etNombrePer);
        etapellido =  (EditText)findViewById(R.id.etApellidoPer);
        etcelular =   (EditText)findViewById(R.id.etCelular);
        etRUC =       (EditText)findViewById(R.id.etRUC);
        etDate =      (EditText)findViewById(R.id.etFechNac);
        spprovincia = (Spinner) findViewById(R.id.sp_provincia);
        spciudad =    (Spinner) findViewById(R.id.sp_ciudad);
        etdireccion = (EditText)findViewById(R.id.etDireccion);
        //etemail =     (EditText)findViewById(R.id.etEmail);
        //etpassword =  (EditText)findViewById(R.id.etPassword);
      //--------------------------------------------------

      //----Asignar a String datos del Formulario------------
        String cedula =    etcedula.getText().toString();
        String nombre =    etnombre.getText().toString();
        String apellido =  etapellido.getText().toString();
        String celular =   etcelular.getText().toString();
        String ruc =       etRUC.getText().toString();
        String fechnac =   etDate.getText().toString();
        String provincia = spprovincia.getSelectedItem().toString();
        String ciudad =    spciudad.getSelectedItem().toString();
        String direccion = etdireccion.getText().toString();
        //String email =     etemail.getText().toString();
        //String password =  etpassword.getText().toString();
      //----------------------------------------------------

      //----------------Pasar Datos a OBJETO PERSONA-------------
        PerCedula objPersona = new PerCedula();
        objPersona.setPerCedula(cedula);
        objPersona.setPerNombre(nombre);
        objPersona.setPerApellido(apellido);
        objPersona.setPerCelular(celular);
        objPersona.setPerSexo("masculino");
        objPersona.setPerRuc(ruc);
        objPersona.setPerDireccion(direccion);
        objPersona.setPerFechanacimiento(fechnac);
        objPersona.setPerTipo("cliente");
      //---------------------------------------------------------
        /*PerCedula objPersona = new PerCedula();
        objPersona.setPerCedula("1817171717");
        objPersona.setPerNombre("Carla");
        objPersona.setPerApellido("Martinez");
        objPersona.setPerCelular("0912345895");
        objPersona.setPerSexo("masculino");
        objPersona.setPerRuc("1817171717-001");
        objPersona.setPerDireccion("av. 12 de Octubre y Guayaquil");
        objPersona.setPerFechanacimiento("1992-02-08T00:00:00-05:00");
        objPersona.setPerTipo("cliente");*/

        CidCodigo cid[] = new CidCodigo[1];

        //apiService = RestEngine.getRestEngine().create(ApiService.class);
        Call<CidCodigo> call = apiService.getCiudad("CTY01");
        call.enqueue(new Callback<CidCodigo>() {
            @Override
            public void onResponse(Call<CidCodigo> call, Response<CidCodigo> response) {
                if(response.isSuccessful()){
                    //JsonObject post = new JsonObject().get(response.body().toString()).getAsJsonObject();
                    //CidCodigo cid = new CidCodigo();
                    cid[0] = (CidCodigo)response.body();
                    String i="";
                    //fnAdaptador.setDataSet(servicios);
                }
            }
            @Override
            public void onFailure(Call<CidCodigo> call, Throwable t) {
                Toast.makeText(com.example.menu.PruebaActivity.this,"ERROR",Toast.LENGTH_SHORT).show();
            }

        });
        /*String d = cid[0] + "";
        String cdcod = cid[0].getCidCodigo();
        String cdcity = cid[0].getCidNombre();*/



        /*Ciudad*/
        CidCodigo objetoCity = new CidCodigo();
        String serCity = "{\n" +
                "    \"cidCodigo\": \"CTY02\",\n" +
                "    \"cidEstado\": true,\n" +
                "    \"cidNombre\": \"Patate\",\n" +
                "    \"prvCodigo\": {\n" +
                "        \"prvCodigo\": \"PRV01\",\n" +
                "        \"prvEstado\": true,\n" +
                "        \"prvNombre\": \"Tungurahua\"\n" +
                "    }\n" +
                "}";
        JSONObject reqCity = new JSONObject(serCity);
        objetoCity = new Gson().fromJson(reqCity.toString(), CidCodigo.class);


        //objPersona.setCidCodigo(cid[0]);
        objPersona.setCidCodigo(objetoCity);
        return objPersona;
    }

    //------Func.ingresar Cuenta y Permisos--------
    public void crearCuenta(PerCedula persona) throws JSONException {
        etemail =     (EditText)findViewById(R.id.etEmail);
        etpassword =  (EditText)findViewById(R.id.etPassword);

        String email =     etemail.getText().toString();
        String password =  etpassword.getText().toString();

        Usuario objUsuario = new Usuario();
        objUsuario.setPerCedula(persona);
        objUsuario.setUsEmail(email);
        objUsuario.setUsPassword(password);
        objUsuario.setUsEstado(true);
        objUsuario.setUsRol("cliente");
        objUsuario.setUsFechainicial("2021-02-26T00:00:00-05:00");
        objUsuario.setUsFechafinal("2021-02-26T00:00:00-05:00");

        /*Persona*/
        PmId objPermiso = new PmId();
        String serPermiso = "{\n" +
                "        \"pmCodigo\": \"ROL_CLI\",\n" +
                "        \"pmId\": 3,\n" +
                "        \"pmNombre\": \"CLIENTE\"\n" +
                "    }";
        JSONObject reqPermiso = new JSONObject(serPermiso);
        objPermiso = new Gson().fromJson(reqPermiso.toString(), PmId.class);

        objUsuario.setPmId(objPermiso);

        String i= "";

        apiService = RestEngine.getRestEngine().create(ApiService.class);
        Call<Usuario> call = apiService.setUsuario(objUsuario);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(com.example.menu.PruebaActivity.this, "usuario Ingresado", Toast.LENGTH_SHORT).show();

                    //JsonObject post = new JsonObject().get(response.body().toString()).getAsJsonObject();
                    //CidCodigo cid = new CidCodigo();
                    //cid[0] = response.body();
                    //i = response.body().getUsEmail()+"";
                    //i="dd";
                    //fnAdaptador.setDataSet(servicios);
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(com.example.menu.PruebaActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //----------------------------------------------

    /*public void saveServicio(Servicio servicio){
        //Call<Servicio> callServicio = RestEngine.getServicio();
    }*/
    //=====================================================================================


    public boolean validarFormulario() { //entidad PERSONA
        //--------------Recolectar datos el Formulario------
        etcedula =    (EditText)findViewById(R.id.etCedula);
        etnombre =    (EditText)findViewById(R.id.etNombrePer);
        etapellido =  (EditText)findViewById(R.id.etApellidoPer);
        etcelular =   (EditText)findViewById(R.id.etCelular);
        etRUC =       (EditText)findViewById(R.id.etRUC);
        etfechnac =   (EditText)findViewById(R.id.etFechNac);
        spprovincia = (Spinner) findViewById(R.id.sp_provincia);
        spciudad =    (Spinner) findViewById(R.id.sp_ciudad);
        etdireccion = (EditText)findViewById(R.id.etDireccion);
        etemail =     (EditText)findViewById(R.id.etEmail);
        etpassword =  (EditText)findViewById(R.id.etPassword);

        String cedula =    etcedula.getText().toString();
        String nombre =    etnombre.getText().toString();
        String apellido =  etapellido.getText().toString();
        String celular =   etcelular.getText().toString();
        String ruc =       etRUC.getText().toString();
        //String fechnac =   etfechnac.getText().toString();
        String provincia = spprovincia.getSelectedItem().toString();
        String ciudad =    spciudad.getSelectedItem().toString();
        String direccion = etdireccion.getText().toString();
        //String email =     etemail.getText().toString();
        //String password =  etpassword.getText().toString();
            boolean retorno = true;
            if(cedula.isEmpty()){   etcedula.setError("Ingrese su Cedula"); retorno = false;}
            if(nombre.isEmpty()){   etnombre.setError("Ingrese su Nombre"); retorno = false;}
            if(apellido.isEmpty()){ etapellido.setError("Ingrese su Apellido"); retorno = false;}
            if(celular.isEmpty()){  etcelular.setError("Ingrese su Celular"); retorno = false;}
            if(ruc.isEmpty()){      etRUC.setError("Ingrese su RUC"); retorno = false;}
            //if(fechnac.isEmpty()){  etfechnac.setError("Ingrese su Fecha de Nacimiento"); retorno = false;}
            //if(provincia.isEmpty()){spprovincia.setError("Ingrese la Ciudad"); retorno = false;}
            //if(ciudad.isEmpty()){   spciudad.setError("Ingrese la Provincia"); retorno = false;}
            if(direccion.isEmpty()){etdireccion.setError("Ingrese la Direccion"); retorno = false;}
            //if(email.isEmpty()){    etemail.setError("Ingrese el Email"); retorno = false;}
            //if(password.isEmpty()){ etpassword.setError("Ingrese la Contraseña"); retorno = false;}

        return retorno;
    }


}