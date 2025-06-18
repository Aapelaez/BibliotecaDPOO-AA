import Logica.Articulo;
import Logica.Biblioteca;
import Logica.TorpedoUsuario;
import Logica.Usuario;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Biblioteca.getInstance().registrarUsuario("04121668369","John", "Doe", 30, 'M', "U001");
        Biblioteca.getInstance().registrarUsuario("04032468565","Eduardo", "Paz", 19, 'M', "U008");
        Biblioteca.getInstance().contratarTrabajador("04082468369", "Jane", "Doe", "Bibliotecario", 33, 'F',"52222222", "jane@mailbroke.com","Universitario");
        Biblioteca.getInstance().agregrarArticulo("art-001","La vida y la ciencia de la computación", "Ciencias",9, 12);
        Biblioteca.getInstance().agregrarArticulo("art-002","La influencia de la droga en la tercera edad", "Ciencias Sociales",9, 2);
        Biblioteca.getInstance().agregrarArticulo("art-002","La influencia de la droga en la tercera edad", "Ciencias Sociales",9, 2);
        Biblioteca.getInstance().agregrarArticulo("art-003","Efectos del chocolate en las edades tempranas", "Pediatria",9, 1);
        Articulo a= (Articulo) Biblioteca.getInstance().buscarPublicacion("art-002");
        System.out.println(a.getTitulo());
        Usuario u= Biblioteca.getInstance().buscarUsuario("U001");
        System.out.println(u.getNombre());
        boolean b=Biblioteca.getInstance().puedePrestarCant("art-001",u);
        System.out.println(b);
        Biblioteca.getInstance().atenderPrestamo("art-001",u,"04082468369");
        TorpedoUsuario t=Biblioteca.getInstance().buscarTorpedo(u.getNumUsuario());
        System.out.println(t.getPrestamos().get(0).getEstado());
        ArrayList<Usuario> arr=Biblioteca.getInstance().usuariosAcreditadosMes(5,2025);
        System.out.println("cant acredit: " + arr.size() + " " + arr.get(0).getNombre() + " y "+ arr.get(1).getNombre());

    }
}
