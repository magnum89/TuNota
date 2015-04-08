package nota.oja.com.tunota.basedatos;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;//esta no se agrego automaticamente

/**
 * Created by usuario on 06/04/2015.
 */
public class NotaOrigenDatos {

    private static final String PRECLAVE = "notas";

    //instancia de clase
    private SharedPreferences NotaPerf;

    //creamos un constructor
    public NotaOrigenDatos (Context context){
        NotaPerf=context.getSharedPreferences(PRECLAVE, Context.MODE_PRIVATE);
    }

    public List<NotaItem> encontrarTodo (){
        List<NotaItem> listaNota = new ArrayList<NotaItem>();//asignamos memoria
        //crear un objeto de la clase notaitem
        NotaItem nota = NotaItem.obtenerNuevo();
        //añadimos a la lista
        listaNota.add(nota);
        //retornamos la lista
        return listaNota;
    }

    //crear dos metodos el de actualizar y el de eliminar la nota
    public boolean actualizar (NotaItem nota){
        //un campo de la clase de preferencias compartidas
        SharedPreferences.Editor editor= NotaPerf.edit();
        //poner en el valor de campo compartido
        editor.putString(nota.getClave(), nota.getTexto());
        editor.commit();

        return true;//verificar que la nota se a actualizado
    }

    public boolean remover (NotaItem nota){
        //para que elimine el texto que exista:
        if(NotaPerf.contains(nota.getClave()))
        {
            SharedPreferences.Editor editor = NotaPerf.edit();
            editor.remove(nota.getClave());
            editor.commit();
        }

        return true;//verificar que la nota se a actualizado
    }

}
