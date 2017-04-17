package com.passstorer.contraseasseguras;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by lau on 16/04/17.
 */

public class DatosUsuarioAdapter extends ArrayAdapter<DatosUsuario> {

    Activity context;
//ArrayAdapter'<WORD>' porque asi sabe que recibe en el metodo getItem(...)
//Si pusiera '...extends ArrayAdapter' habria que hacer: '... (Word) getItem(...)'

    public DatosUsuarioAdapter(Activity context, ArrayList<DatosUsuario> du) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.

        super(context, 0, du); //segundo argumento : es un id de recurso -> esta en 0, no usa ninguno
        this.context = context;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //convertView-> view existente, para reusar (a veces es null, no hay views viejas disponibles)
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.datos_vista, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        DatosUsuario currentData = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView servicio = (TextView) listItemView.findViewById(R.id.vistaDatosTxtViewPlataforma);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        servicio.setText(currentData.getNombreServicio());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView usuario = (TextView) listItemView.findViewById(R.id.vistaDatosTxtViewUsuario);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        usuario.setText(currentData.getUsuario());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        //ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        //iconView.setImageResource(currentAndroidFlavor.getImageResourceId());
        ImageButton imgBtnVerDatos = (ImageButton) listItemView.findViewById(R.id.vistaDatosImgBtn);
        imgBtnVerDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent();
                Toast.makeText(context,"Presionado: "+ position, Toast.LENGTH_SHORT).show();

            }
        });

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}