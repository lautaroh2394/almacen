package com.passstorer.contraseasseguras;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class contrasenasActivity extends AppCompatActivity {

    private Button btnAgregar;
    public static DatosUsuarioAdapter itemsAdapter;//esto para probar si actualiza el listview - encontrar forma mas "correcta"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrasenas);

        btnAgregar = (Button) findViewById(R.id.buttonAgregarContrasena);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent agregarContraActivity = new Intent(contrasenasActivity.this, agregarContraActivity.class);
                startActivity(agregarContraActivity);
            }
        });

        //Llenar el scroll view con vistas "datos_vista" con datos desde la db
        //por ahora llenamos con datos dummy de FixtureDummyPassw

        //...


        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
       itemsAdapter =
                new DatosUsuarioAdapter(this, (new FixtureDummyPassw(500)).getListaDummyPassw());

        // Find the {@link ListView} o  bject in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // list.xml.
        ListView listView = (ListView) findViewById(R.id.listViewContrasenas);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(itemsAdapter);

        //holder pattern: basicamente guarda la view para que el adapter no la busque con el findVIewById (metodo muy costoso) cuando la vuelva a necesitar, ahorrando recursos
    }
}
