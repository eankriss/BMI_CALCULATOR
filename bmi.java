
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.Scanner;

public class bmi implements ActionListener
{
    JTextField height, weight, bmi, classification;
    JButton bmiButton, resetButton;
        
    bmi()
    {
        JFrame myFrame = new JFrame("Body Mass Index Calculator");
        myFrame.setVisible(true);
        
        JLabel heightLabel = new JLabel("Height (m)");
        heightLabel.setBounds(20, 20, 80, 30);
        
        height = new JTextField();
        height.setBounds(100, 20, 200, 30);
        
        JLabel weightLabel = new JLabel("Weight (kg)");
        weightLabel.setBounds(20, 75, 80, 30);
        
        weight = new JTextField();
        weight.setBounds(100, 75, 200, 30);
        
        bmiButton = new JButton("BMI");
        bmiButton.setBounds(15, 130, 80, 30);
        
        bmi = new JTextField();
        bmi.setBounds(100, 130, 200, 30);
        bmi.setEditable(false);
        
        JLabel classificationLabel = new JLabel("Classification:");
        classificationLabel.setBounds(15, 185, 80, 30);
        
        classification = new JTextField();
        classification.setBounds(100, 185, 200, 30);
        classification.setEditable(false);
        
        resetButton = new JButton("Reset");
        resetButton.setBounds(125, 225, 80, 30);
        
        JLabel categoriesLabel = new JLabel("BMI Categories:");
        categoriesLabel.setBounds(20, 260, 150, 30);
        
        JLabel underweightLabel = new JLabel("Underweight = <18.5");
        underweightLabel.setBounds(100, 280, 150, 30);
        
        JLabel normalweightLabel = new JLabel("Normal weight = 18.5 – 24.9");
        normalweightLabel.setBounds(100, 310, 200, 30);
        
        JLabel overweightLabel = new JLabel("Overweight = 25 – 29.9");
        overweightLabel.setBounds(100, 340, 150, 30);
        
        JLabel obesityLabel = new JLabel("Obesity = >29.9");
        obesityLabel.setBounds(100, 370, 150, 30);

        bmiButton.addActionListener(this);
        resetButton.addActionListener(this);
        
        myFrame.add(heightLabel);
        myFrame.add(height);
        
        myFrame.add(weightLabel);
        myFrame.add(weight);
        
        myFrame.add(classificationLabel);
        myFrame.add(classification);
        
        myFrame.add(categoriesLabel);
        myFrame.add(underweightLabel);
        myFrame.add(normalweightLabel);
        myFrame.add(overweightLabel);
        myFrame.add(obesityLabel);
        
        myFrame.add(bmiButton);
        myFrame.add(resetButton);
        myFrame.add(bmi);
        
        Cursor bmiButtonCursor = new Cursor(Cursor.HAND_CURSOR);
        bmiButton.setCursor(bmiButtonCursor);
        
        Cursor resetButtonCursor = new Cursor(Cursor.HAND_CURSOR);
        resetButton.setCursor(resetButtonCursor);
        
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(350, 450);
        myFrame.setLayout(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String h1 = height.getText();
        String w2 = weight.getText();
        
        double a = Double.parseDouble(h1);
        double b = Double.parseDouble(w2);
        double c = 0;
        
        if (e.getSource() == bmiButton)
        {
            c = b / (a * a);
            String bmi1 = String.valueOf(c);
            //String.format("%.2f", bmi1);
            bmi.setText(bmi1 + " kg/m2");
            
            if (c >= 30)
            {
                classification.setText("Obesity");
                classification.setBounds(100, 185, 200, 30);
                classification.setEditable(false);
            }
            
            else if (c >= 25 && c <= 29.9)
            {
                classification.setText("Overweight");
                classification.setBounds(100, 185, 200, 30);
                classification.setEditable(false);
            }
            
            else if (c >= 18.5 && c <= 24.9)
            {
                classification.setText("Normal");
                classification.setBounds(100, 185, 200, 30);
                classification.setEditable(false);
            }
            
            else
            {
                classification.setText("Underweight");
                classification.setBounds(100, 185, 200, 30);
                classification.setEditable(false);
            }

        }
        
        else
        {
            height.setText("");
            weight.setText("");
            bmi.setText("");
            classification.setText("");
        }
        

    }
    
    public static void main(String[] args)
    {
        new bmi();
        //BMI Categories:
//Underweight = <18.5
//Normal weight = 18.5–24.9
//Overweight = 25–29.9
//Obesity = BMI of 30 or greater
    }
}
