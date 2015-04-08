package nota.oja.com.tunota;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import nota.oja.com.tunota.basedatos.NotaItem;
import nota.oja.com.tunota.basedatos.NotaOrigenDatos;


public class MainActivity extends ActionBarActivity {

    private NotaOrigenDatos datosorigen;//instancia de la fuente de datos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //asignaremos memoria a esa variable
        datosorigen = new NotaOrigenDatos(this);//agregamos this
        //creamos la lista de tipo nota item
        List<NotaItem> notas = datosorigen.encontrarTodo();
        NotaItem nota = notas.get(0);//posicion 0
        //guardar la fecha y la hora usando log clase de registro q se utiliza para depurar ejecuciones android

        //agregamos el actualizar
        datosorigen.actualizar(nota);

        Log.i("Nota", nota.getClave());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
