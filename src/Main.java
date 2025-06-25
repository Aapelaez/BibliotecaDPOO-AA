import GIU.MainScreen;
import Logica.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = Biblioteca.getInstance();
        Util.Inicializar.inicializar();
        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);
    }
}
