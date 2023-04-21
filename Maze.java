 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package maze;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import static java.awt.SystemColor.window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author Acer
 */
public class Maze {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        JFrame window = new JFrame();
        JFrame window1 = new JFrame();
        JFrame window2 = new JFrame();
        JPanel panel1 = new JPanel();
        JButton button = new JButton("Robo1");
        JButton button1 = new JButton("Robo2");
        window1.setSize(400, 400);
        window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window1.setLocationRelativeTo(null);
        panel1.setPreferredSize(new Dimension (400,400));
        panel1.setBackground(Color.gray);
        button.setBounds(300 , 150, 200, 100);
        button1.setBounds(300, 200, 200, 100);
        window1.add(panel1);
        panel1.add(button);
        panel1.add(button1);
        window1.pack();
        window1.setVisible(true);
        
        
        
        
        
        window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window2.setResizable(false);
        window2.add(new Izgara1());
        window2.pack();
        window2.setLocationRelativeTo(null);
        window2.setVisible(false);
        
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        
        
        window.add(new Izgara());
        window.pack();
        window1.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(false);
        
        
      button.addActionListener(new ActionListener(){
     @Override
     public void actionPerformed(ActionEvent e){
        window1.setVisible(true);
         window.setVisible(true);
          
     }    
         

     });
      
       button1.addActionListener(new ActionListener(){
     @Override
     public void actionPerformed(ActionEvent e){
        window1.setVisible(true);
         window2.setVisible(true);
          
     }    
         

     });


               
        
        
        
    }
        
       
}
