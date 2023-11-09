import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
   
    static JFrame frame;

    
    static JTextField textField;

    
    String operator;
    double num1, num2, result;

    
    public Calculator() {
    }

   
    public static void main(String[] args) {
       
        frame = new JFrame("Calculator");

        try {
            
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        
        Calculator c = new Calculator();

       
        textField = new JTextField(16);

        
        textField.setEditable(false);

        
        JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonAdd, buttonSub, buttonMul, buttonDiv, buttonEqual, buttonClear, buttonDot;

        
        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");

        
        buttonEqual = new JButton("=");
      
        buttonAdd = new JButton("+");
        buttonSub = new JButton("-");
        buttonMul = new JButton("*");
        buttonDiv = new JButton("/");
        buttonClear = new JButton("C");
        buttonDot = new JButton(".");

        
        JPanel p = new JPanel();

       
        button0.addActionListener(c);
        button1.addActionListener(c);
        button2.addActionListener(c);
        button3.addActionListener(c);
        button4.addActionListener(c);
        button5.addActionListener(c);
        button6.addActionListener(c);
        button7.addActionListener(c);
        button8.addActionListener(c);
        button9.addActionListener(c);
        buttonAdd.addActionListener(c);
        buttonSub.addActionListener(c);
        buttonMul.addActionListener(c);
        buttonDiv.addActionListener(c);
        buttonDot.addActionListener(c);
        buttonEqual.addActionListener(c);
        buttonClear.addActionListener(c);

      
        p.add(textField);
        p.add(button1);
        p.add(button2);
        p.add(button3);
        p.add(buttonAdd);
        p.add(button4);
        p.add(button5);
        p.add(button6);
        p.add(buttonSub);
        p.add(button7);
        p.add(button8);
        p.add(button9);
        p.add(buttonMul);
        p.add(buttonDot);
        p.add(button0);
        p.add(buttonEqual);
        p.add(buttonDiv);
        p.add(buttonClear);

       
        p.setBackground(Color.BLACK);

        
        frame.add(p);

        frame.setSize(200, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9')) {
            textField.setText(textField.getText() + s);
        } else if (s.charAt(0) == 'C') {
            textField.setText("");
            num1 = num2 = result = 0;
            operator = "";
        } else if (s.charAt(0) == '=') {
            if (operator != null) {
                num2 = Double.parseDouble(textField.getText());

                switch (operator) {
                    case "+" -> result = num1 + num2;
                    case "-" -> result = num1 - num2;
                    case "/" -> result = num1 / num2;
                    case "*" -> result = num1 * num2;
                }

                JOptionPane.showMessageDialog(frame, "Result: " + result, "Calculation Result", JOptionPane.INFORMATION_MESSAGE);
                textField.setText(String.valueOf(result));
                num1 = result;
                operator = "";
            }
        } else {
            if (operator == null || operator.isEmpty()) {
                operator = s;
                num1 = Double.parseDouble(textField.getText());
                textField.setText("");
            }
        }
    }
}

