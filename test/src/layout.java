import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class layout implements ActionListener{
JFrame frame = new JFrame();
JTextField field;
JPanel panel;
JButton numbersButton []= new JButton[10];
JButton functiButton[]= new JButton[9];
JButton addButton,subButton,multButton,divButton;
JButton delButton,clrButton,negButton,decButton,eqlButton;
double num1=0,num2=0, result;
char operator;
Font myfont= new Font("Arial", Font.BOLD,30);
layout(){
frame= new JFrame("CALCULATOR");
frame.setVisible(true);
frame.setSize(420,550);
frame.setResizable(false);
frame.setLayout(null);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setBackground(Color.BLACK);

field=new JTextField();
field.setBounds(50,25,300,50);
field.setVisible(true);
field.setFont(myfont);
field.setForeground(Color.MAGENTA);



addButton=new JButton("+");
subButton=new JButton("-");
multButton=new JButton("*");
divButton=new JButton("/");
decButton=new JButton(".");
delButton=new JButton("DEL");
clrButton=new JButton("clr");
negButton=new JButton("(-)");
eqlButton=new JButton("=");

functiButton[0]=addButton;
functiButton[1]=subButton;
functiButton[2]=multButton;
functiButton[3]=divButton;
functiButton[4]=decButton;
functiButton[5]=delButton;
functiButton[6]=clrButton;
functiButton[7]=negButton;
functiButton[8]=eqlButton;

for(int i=0;i<10;i++){
    numbersButton[i] = new JButton(String.valueOf(i));
    numbersButton[i].addActionListener(this);
    numbersButton[i].setFont(myfont);
    numbersButton[i].setFocusable(false);
    numbersButton[i].setBackground(Color.GRAY);
    numbersButton[i].setForeground(Color.GREEN);
}
for(int i=0;i<9;i++){
    functiButton[i].setFocusable(false);
    functiButton[i].addActionListener(this);
    functiButton[i].setFont(myfont);
    functiButton[i].setForeground(Color.RED);
}

delButton.setBounds(50,430,100,50);
clrButton.setBounds(150,430,100,50);
negButton.setBounds(250,430,100,50);





 panel=new JPanel();
panel.setBounds(50,100,300,300);
panel.setLayout(new GridLayout(4,4,10,10));
panel.setVisible(true);
panel.setBackground(Color.BLUE);


panel.add(numbersButton[1]);
panel.add(numbersButton[2]);
panel.add(numbersButton[3]);
panel.add(addButton);
panel.add(numbersButton[4]);
panel.add(numbersButton[5]);
panel.add(numbersButton[6]);
panel.add(subButton);
panel.add(numbersButton[7]);
panel.add(numbersButton[8]);
panel.add(numbersButton[9]);
panel.add(multButton);
panel.add(decButton);
panel.add(numbersButton[0]);
panel.add(eqlButton);
panel.add(divButton);


frame.getContentPane().setBackground(Color.cyan);
frame.setBackground(Color.GREEN);
frame.add(panel);
frame.add(negButton);
frame.add(delButton);
frame.add(clrButton);
frame.add(field);
frame.setVisible(true);


}
@Override
public void actionPerformed(ActionEvent e) {
   for(int i=0;i<10;i++){
    if(e.getSource()==numbersButton[i]){
        field.setText(field.getText().concat(String.valueOf(i)));

    }
   }
  if(e.getSource()==decButton){
    field.setText(field.getText().concat("."));
   }
   if(e.getSource()==addButton){
    num1=Double.parseDouble(field.getText());
    operator='+';
    field.setText("");

   }
   if(e.getSource()==subButton){
    num1=Double.parseDouble(field.getText());
    operator='-';
    field.setText("");

   }
   if(e.getSource()==multButton){
    num1=Double.parseDouble(field.getText());
    operator='*';
    field.setText("");

   }
   if(e.getSource()==divButton){
    num1=Double.parseDouble(field.getText());
    operator='/';
    field.setText("");

   }
   if (e.getSource() == negButton) {
    if (field.getText().isEmpty()){
        field.setText("-");
    }
}
    
   if(e.getSource()==eqlButton){
   num2=Double.parseDouble(field.getText());
   switch (operator) {
    case '+':
    result=num1+num2;
        
        break;
    case '-':
        result=num1-num2;
            
        break;
    case '*':
        result=num1*num2;
                
         break;
    case '/':
        result=num1/num2;
                    
        break;

   
    default:
        break;
   }
   field.setText(String.valueOf(result));
   num1=result;
}
if(e.getSource()==clrButton){
    field.setText("");

}
if(e.getSource()==delButton){
    String string=field.getText();
    field.setText("");
    for(int i=0;i<string.length()-1;i++){
        field.setText(field.getText()+string.charAt(i));

    }


}

}

}