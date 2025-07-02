package GIU;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class TextFieldID extends javax.swing.JTextField {
        public TextFieldID() {
            addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char c=e.getKeyChar();
                    JTextField text =(JTextField)e.getSource();
                    if(text.getText().length()==limite){
                        e.consume();
                    }
                    if(c<'0' || c>'9'){
                        e.consume();
                    }
                }
            });
        }
        private int limite=11;
        public int getLimite() {
            return limite;
        }

        public void setLimite(int limite) {
            if(limite>=1){
                this.limite = limite;
            }
        }
    }

