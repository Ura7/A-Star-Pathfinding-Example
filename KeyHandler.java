/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maze;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Acer
 */
public class KeyHandler implements KeyListener{
    Izgara1 izgara1;
    public KeyHandler(Izgara1 izgara1){
        this.izgara1 = izgara1;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_ENTER){
            izgara1.Search();
            
        }
        if(code==KeyEvent.VK_SPACE){
            izgara1.AutoSearch();
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
