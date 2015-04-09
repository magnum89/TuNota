package nota.oja.com.tunota;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;

import java.util.List;

import nota.oja.com.tunota.basedatos.NotaItem;
import nota.oja.com.tunota.basedatos.NotaOrigenDatos;


public class MainActivity extends ListActivity {//lista de actividades para hacr varias notas
    //debe contener una lita de vista

    private NotaOrigenDatos origendatos;//instancia de la fuente de datos
    List<NotaItem> notasLista;//la quitamos dentro del oncreate y la agregamos aca adicionandole Lista y elimnamos el resto

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //asignaremos memoria a esa variable
        origendatos = new NotaOrigenDatos(this);//agregamos this

        //agregamos un metodo que no existe
        ActualizarPantalla();

    }

    private void ActualizarPantalla() {
        //asignamos memoria a la lista
        notasLista = origendatos.encontrartodo();
        ArrayAdapter<NotaItem> adaptador = new ArrayAdapter<NotaItem>(this, android.R.layout.simple_list_item_1,notasLista);//metodo adaptador
        setListAdapter(adaptador);//cada vez q la pantalla de actualizacion se llama, obtengo los datos
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


}
