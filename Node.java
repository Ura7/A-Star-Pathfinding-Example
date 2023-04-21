/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maze;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Acer
 */
public class Node extends JButton {

    Node parent;
    int sutun;
    int satir;
    int Gdeger;
    int Hdeger;
    int Fdeger;
    boolean engel1;
    boolean basla;
    boolean bitis;
    boolean open;
    boolean checked;
    boolean top;
    boolean right;
    boolean left;
    boolean bottom;
    int i =0;
    public Node(int sutun, int satir){
        this.sutun =sutun;
        this.satir=satir;
        setBackground(Color.white);
        
    }
    public void setBasla(){
        setBackground(Color.green);
        setForeground(Color.white);
        setText("Basla");
        basla=true;
    }
    public void setBitis(){
        setBackground(Color.red);
        setForeground(Color.white);
        setText("Bitis");
        bitis=true;
    }
    public void setEngel(){
        setBackground(Color.black);
        engel1 = true;
        
    }
    public void setOpen(){
    open =true;
    
    }
    public void setChecked(){
        if(i==0&& basla==false && bitis == false){
            setBackground(Color.orange);
        }
        else if(i==1&& basla==false && bitis == false){
            setBackground(Color.blue);
        }
        checked=true;
        i++;
    }
    public void setYol(){
        setBackground(Color.green);
    }

    
    
    
    

    

   
}
