import GIU.LoginFrame;
import GIU.MainScreen;
import Logica.*;

import java.awt.EventQueue;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

            EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

    }
}
