/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maze;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import static java.awt.SystemColor.window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.constant.ConstantDescs.NULL;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 *
 * @author Acer
 */
public class Izgara extends JPanel{
    
    
  JToggleButton b;
  JFrame window;
  JFrame window2;
  int maxSutun = 0; 
  int maxSatir = 0;
  int sec = 0;
  boolean bo = true;
 ArrayList<Node> openList = new ArrayList<Node>();
 ArrayList<Node> checkedList = new ArrayList<Node>();
 int [][] engeltut; 
 boolean goalReached = false;
  Node[][] node ; 
  Node baslaNode,bitisNode,currentNode,tempNode; 
  int dur = 0;
        
 public Izgara() throws FileNotFoundException, IOException
 {
     
     
    File file = new File("C:/Users/Acer/Desktop/izgara1.txt");
    File file1 = new File("C:/Users/Acer/Desktop/izgara2.txt");
    
    FileReader fReader;
    int line;
    BufferedReader bReader = null;
    
   
     System.out.println("Gir");
    Scanner a = new Scanner(System.in);
    
    sec = a.nextInt();
    
     
     
   if(sec==0)
   {
    maxSutun = 20;
   maxSatir =20;
    fReader = new FileReader(file);    
    bReader = new BufferedReader(fReader);
   }
   else if(sec==1)
   {
    maxSutun = 10;
    maxSatir =10;
   fReader = new FileReader(file1);    
   bReader = new BufferedReader(fReader);
   
   }
   
   int nodeSize =50;
  
   int windowWidth = nodeSize * maxSutun;
   int windowHeight = nodeSize * maxSatir;
   
    node = new Node[maxSutun][maxSatir];
   
   
   this.setPreferredSize(new Dimension (windowWidth,windowHeight));
  this.setBackground(Color.gray);
  this.setLayout((new GridLayout(maxSutun,maxSatir+5)));
  this.addKeyListener(new KeyHandler1(this));
   this.setFocusable(true);
    int sutun = 0;
   int satir=0;
   
    please:
   while((line = bReader.read())!=-1 && (sutun<maxSutun) && (satir<maxSatir)) {
    
           if(line == 13 || line ==10 )
       {
       continue please;
       }
       
     
        node[sutun][satir] = new Node(sutun,satir);
        
        this.add(node[sutun][satir]);
       
        
       
        System.out.println(sutun+satir+"");
        
         if(line == 49 || line == 50 || line == 51){
          
         setEngelNode(sutun,satir);
    
          }   
          sutun++;
        
        if(sutun==maxSutun){
            sutun=0;
            satir++;
        }
         
    
       
   }
 
  currentNode = node[0][0];
  currentNode.setChecked();
   setbaslaNode(0,0);
   setbitisNode(maxSutun-5,maxSatir-4);
   
       System.out.println("a");
      Searching();

    
        
 }
 private void setbaslaNode(int sutun, int satir)
 {
 node[sutun][satir].setBasla();
 baslaNode = node[sutun][satir];
 currentNode = baslaNode;
 
 }
 private void setbitisNode(int sutun, int satir)
 {
 node[sutun][satir].setBitis();
 bitisNode = node[sutun][satir];
 
 
 }
 private void setEngelNode(int sutun, int satir){
   node[sutun][satir].setEngel();
 }
  
  public void Searching(){
     if(goalReached == false && dur <500)
     {
         System.out.println("ab");
         dur++;
     int col = currentNode.sutun;
     int row = currentNode.satir;
     int a=0;
     currentNode.setChecked();
     checkedList.add(currentNode);
     openList.remove(currentNode);
     System.out.println(dur+"");
     
     if(row-1>=0){
     openNode(node[col][row-1]);
     a++;
     }
     if(col-1>=0){
     openNode(node[col-1][row]);
     a++;
     }
     if(row+1<maxSutun){
     openNode(node[col][row+1]);
     a++;
     }
     if(col+1<maxSatir){
     openNode(node[col+1][row]);
     a++;
     }
     int bestNode = 0;
     int bestNodeCost = 1000;
     
    
     for(int i=0; i<openList.size();i++){
         if(openList.get(i).Fdeger<bestNodeCost){
             bestNode = i;
             bestNodeCost = openList.get(i).Fdeger;
             
         }
         
         else if(openList.get(i).Fdeger == bestNodeCost){
             if(openList.get(i).Gdeger<openList.get(bestNode).Gdeger){
                 bestNode=i;
             }

         
         
             
           
         
         
         
     
     
     
     
     }
     
     
     
  
     }
         
    currentNode = openList.get(bestNode);
     if(currentNode == bitisNode){
         goalReached =true;
         yolCiz();
     }
     }
 }

 private void getCost(Node node){
    int x = Math.abs(node.sutun - baslaNode.sutun);
    int y = Math.abs(node.satir - baslaNode.satir);
    node.Gdeger = x + y;
    
     x = Math.abs(node.sutun - bitisNode.sutun);
     y = Math.abs(node.satir - bitisNode.satir);
    node.Hdeger = x + y;
     
    node.Fdeger = node.Gdeger + node.Hdeger;
    
     
     
 }

 private void yolCiz(){
     Node current = bitisNode;
     while(current!=baslaNode){
         current = current.parent;
         
         if(current!=baslaNode){
             current.setYol();
             
         }
         
     }
     
     
     
 }

 
 
 
 
 
 
 
 private void openNode(Node node){
     if(node.open==false && node.checked==false && node.engel1==false){
         node.setOpen();
         node.parent = currentNode;
         openList.add(node);
         
         
     }
     

}
}
