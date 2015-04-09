package nota.oja.com.tunota.basedatos;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by usuario on 06/04/2015.
 */
@SuppressLint("SimpleDateFormat")
public class NotaItem {

    //declaramos las variables clave y valor
    private String clave;//los metemos en un geter y setter
    private String texto;//damos click generar

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }



    //creamos un constructor que almacenara ls datos del dispositivo
    public static NotaItem obtenerNuevo()
    {
        //variable de tipo local Locale
        Locale local = new Locale("en_US");//se escoje q devuelva un parametro "en_US"
        Locale.setDefault(local);
        //porque tiene caracteristicas que otros idiomas no posee
        String patron = "yyyy-MM-dd HH:mm:ss Z"; //la z es que se va a agregar una nueva anotacion que muestra el horario
        //en funcion de meridiano de grenguich
        SimpleDateFormat formato = new SimpleDateFormat(patron);//enviamos por parametro el patron

        String clave = formato.format(new Date());//enviamos la fecha actual del dispositivo

        NotaItem nota = new NotaItem();//asignamos memoria
        //enviamos la clave
        nota.setClave(clave);
        //y enviamos el texto
        nota.setTexto("");//el texto al ser un string podemos enviar una cadena vacia

        //retornamos la variable
        return nota;


    }


    @Override
    public String toString() {

        return this.getTexto();
    }
}
