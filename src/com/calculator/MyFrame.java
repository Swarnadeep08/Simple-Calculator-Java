package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener
{
    private JTextField textField;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] funcButtons = new JButton[10];
    private JButton addButton, subButton, mulButton, divButton, decButton, equalButton, delButton, clrButton, modButton, sqrtButton;

    Font font = new Font("Monospaced", Font.BOLD, 30);

    double num1, num2, result=0;
    char operator;

    MyFrame()
    {
        super.setTitle("Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);
        this.setResizable(false);
        this.setLocation(300, 200);
        this.setLayout(null);

        textField = new JTextField();
        textField.setBounds(0,0, 390, 100);
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setBackground(Color.MAGENTA);
        textField.setOpaque(true);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        textField.setForeground(Color.white);
        textField.setFont(new Font("Monospaced", Font.BOLD, 40));
        textField.setEditable(false);
        this.add(textField);

        addButton = new JButton("+");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        subButton = new JButton("-");
        decButton = new JButton(".");
        clrButton = new JButton("CLR");
        delButton = new JButton("DEL");
        modButton = new JButton("MOD");
        equalButton = new JButton("=");
        sqrtButton = new JButton(("SQRT"));

        funcButtons[0] = addButton;
        funcButtons[1] = subButton;
        funcButtons[2] = mulButton;
        funcButtons[3] = divButton;
        funcButtons[4] = decButton;
        funcButtons[5] = delButton;
        funcButtons[6] = clrButton;
        funcButtons[7] = equalButton;
        funcButtons[8] = modButton;
        funcButtons[9] = sqrtButton;

        for(int i=0; i<10; i++){
            funcButtons[i].setFont(font);
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFocusable(false);
        }

        for(int i=0; i<10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
            numberButtons[i].setFocusable(false);
        }

        // Row 1
        numberButtons[9].setBounds(0,100, 78,95);
        numberButtons[8].setBounds(78,100, 78,95);
        numberButtons[7].setBounds(156,100, 78,95);
        numberButtons[6].setBounds(234,100, 78,95);
        clrButton.setBounds(312,100,78,95);
        clrButton.setBorder(BorderFactory.createRaisedBevelBorder());
        this.add(clrButton);

        // Row 2
        numberButtons[5].setBounds(0,195, 78,95);
        numberButtons[4].setBounds(78,195, 78,95);
        numberButtons[3].setBounds(156,195, 78,95);
        numberButtons[2].setBounds(234,195, 78,95);
        modButton.setBounds(312,195,78,95);
        modButton.setBorder(BorderFactory.createRaisedBevelBorder());
        this.add(modButton);

        // Row 3
        delButton.setBounds(0,290,78,95);
        delButton.setBorder(BorderFactory.createRaisedBevelBorder());
        this.add(delButton);
        decButton.setBounds(78,290,78,95);
        decButton.setBorder(BorderFactory.createRaisedBevelBorder());
        this.add(decButton);
        numberButtons[0].setBounds(156,290, 78,95);
        numberButtons[1].setBounds(234,290, 78,95);
        addButton.setBounds(312,290,78,95);
        addButton.setBorder(BorderFactory.createRaisedBevelBorder());
        this.add(addButton);

        // Row 4
        sqrtButton.setBounds(0,385,78,95);
        sqrtButton.setBorder(BorderFactory.createRaisedBevelBorder());
        this.add(sqrtButton);
        divButton.setBounds(78,385,78,95);
        divButton.setBorder(BorderFactory.createRaisedBevelBorder());
        this.add(divButton);
        mulButton.setBounds(156,385,78,95);
        mulButton.setBorder(BorderFactory.createRaisedBevelBorder());
        this.add(mulButton);
        subButton.setBounds(234,385,78,95);
        subButton.setBorder(BorderFactory.createRaisedBevelBorder());
        this.add(subButton);
        equalButton.setBounds(312,385,78,95);
        equalButton.setBorder(BorderFactory.createRaisedBevelBorder());
        this.add(equalButton);

        for(int i=0; i<10; i++){
            numberButtons[i].setBorder(BorderFactory.createRaisedBevelBorder());
            this.add(numberButtons[i]);
        }

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<10; i++){
            if(e.getSource()==numberButtons[i]){
                 textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource()==decButton){
            textField.setText(textField.getText().concat("."));
        }

        if(e.getSource()==addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("+ ");
        }

        if(e.getSource()==subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("- ");
        }

        if(e.getSource()==mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("* ");
        }

        if(e.getSource()==divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("/ ");
        }

        if(e.getSource()==modButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '%';
            textField.setText("% ");
        }

        if(e.getSource()==sqrtButton){
            num1 = Double.parseDouble(textField.getText());
            result = Math.sqrt(num1);
            num1 = result;
            textField.setText(String.format("%.3f", result));
        }

        if(e.getSource()==equalButton){
            num2 = Double.parseDouble(textField.getText().substring(2));

            switch(operator)
            {
                case '+':
                    result = num1+num2;
                    textField.setText(String.format("%.3f", result));
                    num1 = result;
                    break;
                case '-':
                    result = num1-num2;
                    textField.setText(String.format("%.3f", result));
                    num1 = result;
                    break;
                case '*':
                    result = num1*num2;
                    textField.setText(String.format("%.3f", result));
                    num1 = result;
                    break;
                case '/':
                    if(num2!=0){
                        result = num1/num2;
                        textField.setText(String.format("%.3f", result));
                        num1 = result;
                    }
                    else{
                        textField.setText("Division Error");
                    }
                    break;
                case '%':
                    result = num1%num2;
                    textField.setText(String.format("%.3f", result));
                    num1 = result;
                    break;
            }
        }

        if(e.getSource()==clrButton){
            textField.setText("");
        }

        if(e.getSource()==delButton){
            String string = textField.getText();
            textField.setText("");
            for(int i=0; i<string.length()-1; i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
    }
}
