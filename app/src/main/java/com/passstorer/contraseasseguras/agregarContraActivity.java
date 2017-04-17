package com.passstorer.contraseasseguras;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class agregarContraActivity extends AppCompatActivity {

    private Button btnGuardar;
    private EditText contra1;
    private EditText contra2;
    private ImageButton btnVer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contra);

        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chequearContrasenas()){
                    findViewById(R.id.txtErrorContrasenas).setVisibility(View.INVISIBLE);
                    //guardar en db
                    //...
                    //volver a pantalla anterior

                    //Test - prueba con passw y datos truchos
                    String servicio = ((EditText) agregarContraActivity.this.findViewById(R.id.editTxtPagWeb)).getText().toString();
                    String usuario = ((EditText) agregarContraActivity.this.findViewById(R.id.editTxtUsuario)).getText().toString();
                    String email = ((EditText) agregarContraActivity.this.findViewById(R.id.editTxtEmail)).getText().toString();
                    String contra = ((EditText) agregarContraActivity.this.findViewById(R.id.editTxtContrasena)).getText().toString();
                    String extradata= ((EditText) agregarContraActivity.this.findViewById(R.id.editTxtDatosExtra)).getText().toString();

                    FixtureDummyPassw.listaDummyPassw.add(new DatosUsuario(servicio,usuario,contra,email,extradata));
                    contrasenasActivity.itemsAdapter.notifyDataSetChanged();//encontrar forma mas correcta que usar un atributo static
                    //TODO: cuando esta activity termina tiene que devolver un valor a la act anterior (contrasenasActivity) y segun ese valor refrescar la listview (cómo hacerlo en linea anterior)
                    //

                    finish();
                    return;
                }
                else {
                    findViewById(R.id.txtErrorContrasenas).setVisibility(View.VISIBLE);
                    Toast.makeText(agregarContraActivity.this,"Contraseñas no coinciden",Toast.LENGTH_LONG).show();
                }
            }

            private boolean chequearContrasenas(){
                String contr1 = ((EditText) findViewById(R.id.editTxtContrasena)).getText().toString();
                String contr2 = ((EditText) findViewById(R.id.editTxtContrasenaRepetida)).getText().toString();

                return (!contr1.isEmpty()&& !contr2.isEmpty() && contr1.equals(contr2));
            }
        });

        contra1 = (EditText) findViewById(R.id.editTxtContrasena);
        contra1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                String contr1 = ((EditText) findViewById(R.id.editTxtContrasena)).getText().toString();
                String contr2 = ((EditText) findViewById(R.id.editTxtContrasenaRepetida)).getText().toString();
                TextView error = (TextView) findViewById(R.id.txtErrorContrasenas);

                if (!contr1.equals(contr2)){
                    error.setVisibility(View.VISIBLE);
                }
                else {
                    error.setVisibility(View.INVISIBLE);}


            }
        });


        contra2 = (EditText) findViewById(R.id.editTxtContrasenaRepetida);
        contra2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {


                String contr1 = ((EditText) findViewById(R.id.editTxtContrasena)).getText().toString();
                String contr2 = ((EditText) findViewById(R.id.editTxtContrasenaRepetida)).getText().toString();

                TextView error = (TextView) findViewById(R.id.txtErrorContrasenas);

                if (!contr2.equals(contr1)){
                    error.setVisibility(View.VISIBLE);
                }
                else {
                    error.setVisibility(View.INVISIBLE);
                    }


            }
        });

        btnVer = (ImageButton) findViewById(R.id.btnVer);
        btnVer.setOnTouchListener(new View.OnTouchListener() {

            private EditText contra1 = (EditText) findViewById(R.id.editTxtContrasena);
            private EditText contra2 = (EditText) findViewById(R.id.editTxtContrasenaRepetida);

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN){
                    contra1.setInputType(InputType.TYPE_CLASS_TEXT);
                    contra2.setInputType(InputType.TYPE_CLASS_TEXT);

                }else if(event.getAction() == MotionEvent.ACTION_UP){

                    contra1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    contra2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
                return true;
            }
        });


    }
}
