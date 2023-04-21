/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maze;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JPanel;

/**
 *
 * @author Acer
 */
public class Izgara1 extends JPanel{
    
    
    
    
    
 int maxSutun = 0;
 int maxSatir =0;
 Node[][] node; 
 Node baslaNode,bitisNode,currentNode,tempNode; 
 boolean mazeFinish = false;
 ArrayList<Node> openList = new ArrayList<Node>();
 ArrayList<Node> checkedList = new ArrayList<Node>();
 int [][] engeltut; 
 boolean goalReached = false;
 
 public Izgara1(){


Scanner izgara = new Scanner(System.in);
     System.out.println("Sütün sayisini giriniz");
     maxSutun = izgara.nextInt();
     System.out.println("Satir sayisini giriniz");
     maxSatir = izgara.nextInt();
     
     int nodeSize = 50;
     
     
     int windowWidth = nodeSize * maxSutun;
   int windowHeight = nodeSize * maxSatir;
     node = new Node[maxSutun][maxSatir];
     this.setPreferredSize(new Dimension (windowWidth,windowHeight));
  this.setBackground(Color.gray);
  this.setLayout((new GridLayout(maxSutun,maxSatir)));
   this.addKeyListener(new KeyHandler(this));
   this.setFocusable(true);
   int sutun = 0;
   int satir=0;

    while ((sutun<maxSutun) && (satir<maxSatir)) {
   
        node[sutun][satir] = new Node(sutun,satir);
        
        this.add(node[sutun][satir]);
       
        
       
        System.out.println(sutun+satir+"");
    
          sutun++;
        
        if(sutun==maxSutun){
            sutun=0;
            satir++;
        }
         
    
       
       
       
   }
    engeltut = new int[maxSutun][maxSatir];
   int myrand1;
   int myrand2;
  
   
   for(int b = 1; b<=maxSutun;b++)
   {
       setEngelNode(b-1,0);
       setEngelNode(b-1,maxSatir-1);
      for(int j = 1; j<maxSatir; j++)
      {
      setEngelNode(0,j-1);
      setEngelNode(maxSutun-1,j-1);
      
      }
   
   
   }
    boo:
   for(int a = 0; a <(maxSutun*maxSatir)/2; a++)
   {
       
   Random rand1 = new Random();
   Random rand2 = new Random();
   
   myrand1 = rand1.nextInt(maxSutun);
   myrand2 = rand2.nextInt(maxSatir);
   
   
   if(myrand1==1 && myrand2 == 1 || myrand1==1 && myrand2 == 2 || myrand1==2 && myrand2 == 2 || myrand1==maxSutun-2 && myrand2 ==maxSatir-2 || myrand1==maxSutun-2 && myrand2 ==maxSatir-3 || myrand1==maxSutun-3 && myrand2 ==maxSatir-3)
   {
       continue boo;
       
       
   }
   setEngelNode(myrand1,myrand2);
   }
   
    
   currentNode = node[0][0];
   currentNode.setChecked();
   setbaslaNode(1,1);
   setbitisNode(maxSutun-2,maxSatir-2);
  
   
 
   
   
   Search();
   
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
 
 
 
 public void Search(){
     if(goalReached == false)
     {
     int col = currentNode.sutun;
     int row = currentNode.satir;
     int a=0;
     currentNode.setChecked();
     checkedList.add(currentNode);
     openList.remove(currentNode);
     
     
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
     
     
     Random rand3 = new Random();
     int tut=0;
     boooo:
     for(int i=0; i<openList.size();i+=a){
         
          if(i==0){
              bestNode =0;
          }
          else
          bestNode = i+tut;

          System.out.println(bestNode+"best");  
          tempNode = currentNode;
          currentNode = openList.get(bestNode);
         if(currentNode==tempNode){
         continue boooo;
     }   
         }
         
         
             
       a=0;      
         
         
         
     
     
     
     if(currentNode == bitisNode){
         goalReached =true;
         yolCiz();
     }
     }
     
     
     
 }
 public void AutoSearch(){
     int dur = 0;
     while(goalReached == false && dur<500)
     {
         dur++;
     int col = currentNode.sutun;
     int row = currentNode.satir;
     int a=0;
     currentNode.setChecked();
     checkedList.add(currentNode);
     openList.remove(currentNode);
     
     
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
     
     
     Random rand3 = new Random();
     int tut=0;
     boooo:
     for(int i=0; i<openList.size();i+=a){
         
         tut = rand3.nextInt(3);
          if(i==0){
              bestNode =0;
          }
          else
          bestNode = i+tut;
            
          tempNode = currentNode;
          currentNode = openList.get(bestNode);
         if(currentNode==tempNode || currentNode==null){
         continue boooo;
     }   
         }
         
         
             
       a=0;      
         
         
         
     
     
     
     if(currentNode == bitisNode){
         goalReached =true;
         yolCiz();
     }
     }
     
     
     
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

