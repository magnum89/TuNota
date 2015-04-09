package nota.oja.com.tunota.basedatos;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;//esta no se agrego automaticamente
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by usuario on 06/04/2015.
 */
public class NotaOrigenDatos {

    private static final String PRECLAVE = "notas";

    //instancia de clase
    private SharedPreferences notaPerf;

    //creamos un constructor
    public NotaOrigenDatos (Context context){
        notaPerf =context.getSharedPreferences(PRECLAVE, Context.MODE_PRIVATE);
    }

    public List<NotaItem> encontrartodo(){

        //creamos un mapa que contiene un elemento clave y un valor
        //recibe dos argumentos un string el segundo ? no sabemos el tipo de dato que retornara
        Map<String, ?> notamapa = notaPerf.getAll();//
        //pero desordenado asi que necestamos ordenar las claves
        SortedSet<String> claves = new TreeSet<String>(notamapa.keySet());//creamos un objeto con tree set que puede ordenar los daos
        //recorrer las claves para obtener el elemento de la lista
        List<NotaItem> notalista = new ArrayList<NotaItem>();//asignamos memoria
        for (String clave : claves)//enviamos una cadena y recorrera el arbol de claves
        {
            NotaItem nota = new NotaItem();
            nota.setClave(clave);
            nota.setTexto((String)notamapa.get(clave));
            //añadimos a la lista de nota
            notalista.add(nota);
        }


        return notalista;
    }

    //crear dos metodos el de actualizar y el de eliminar la nota
    public boolean actualizar (NotaItem nota){
        //un campo de la clase de preferencias compartidas
        SharedPreferences.Editor editor= notaPerf.edit();
        //poner en el valor de campo compartido
        editor.putString(nota.getClave(), nota.getTexto());
        editor.commit();

        return true;//verificar que la nota se a actualizado
    }

    public boolean remover (NotaItem nota){
        //para que elimine el texto que exista:
        if(notaPerf.contains(nota.getClave()))
        {
            SharedPreferences.Editor editor = notaPerf.edit();
            editor.remove(nota.getClave());
            editor.commit();
        }

        return true;//verificar que la nota se a actualizado
    }

}
