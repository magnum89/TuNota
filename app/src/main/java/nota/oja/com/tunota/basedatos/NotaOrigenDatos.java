package nota.oja.com.tunota.basedatos;

import java.util.ArrayList;
import java.util.List;//esta no se agrego automaticamente

/**
 * Created by usuario on 06/04/2015.
 */
public class NotaOrigenDatos {

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
        return true;//verificar que la nota se a actualizado
    }

    public boolean remover (NotaItem nota){
        return true;//verificar que la nota se a actualizado
    }

}
