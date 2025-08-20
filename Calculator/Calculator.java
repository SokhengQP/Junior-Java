import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

// Custom button class for rounded corners
class RoundedButton extends JButton {
    private static final int ARC_SIZE = 25; // Adjust this value for more or less rounded corners

    public RoundedButton(String text) {
        super(text);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusable(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fill the rounded rectangle with the button's background color
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), ARC_SIZE, ARC_SIZE));

        // Paint the text
        super.paintComponent(g);

        g2.dispose();
    }
}

// The main Calculator class, extending JFrame to create a window
public class Calculator extends JFrame implements ActionListener {

    // Components for the calculator UI
    JTextField display;
    RoundedButton[] numberButtons = new RoundedButton[10];
    RoundedButton[] functionButtons = new RoundedButton[9];
    RoundedButton addButton, subButton, mulButton, divButton;
    RoundedButton decButton, equButton, delButton, clrButton, negButton;
    JPanel mainPanel, controlPanel;

    // Variables for calculation logic
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    // Constructor to set up the GUI
    Calculator() {
        // Set up the main window (JFrame)
        this.setTitle("Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420, 550);
        this.setLayout(null);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(30, 30, 30)); // Soft dark gray background

        // Text field for the display
        display = new JTextField();
        display.setBounds(50, 25, 300, 50);
        display.setFont(new Font("Arial", Font.BOLD, 30));
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // No border on display
        display.setBackground(new Color(50, 50, 50)); // Darker gray for display
        display.setForeground(Color.WHITE);

        // Initialize function buttons
        addButton = new RoundedButton("+");
        subButton = new RoundedButton("-");
        mulButton = new RoundedButton("×");
        divButton = new RoundedButton("÷");
        decButton = new RoundedButton(".");
        equButton = new RoundedButton("=");
        delButton = new RoundedButton("D");
        clrButton = new RoundedButton("C");
        negButton = new RoundedButton("-");

        // Add function buttons to an array for easy management
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        // Set properties for function buttons
        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(new Font("Arial", Font.BOLD, 25));
            functionButtons[i].setForeground(Color.WHITE);
            // Softer orange for operators and other special buttons
            if (i < 4) {
                functionButtons[i].setBackground(new Color(255, 150, 0));
            } else if (i == 5) {
                functionButtons[i].setBackground(new Color(0, 150, 255));
            } else {
                functionButtons[i].setBackground(new Color(90, 90, 90));
            }
        }

        // Initialize number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new RoundedButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 25));
            numberButtons[i].setForeground(Color.WHITE);
            numberButtons[i].setBackground(new Color(60, 60, 60)); // Soft dark gray for numbers
        }

        // Panel for the number and operator buttons
        mainPanel = new JPanel();
        mainPanel.setBounds(50, 100, 300, 300);
        mainPanel.setLayout(new GridLayout(4, 4, 10, 10));
        mainPanel.setBackground(new Color(30, 30, 30));

        // Add buttons to the main panel
        mainPanel.add(numberButtons[1]);
        mainPanel.add(numberButtons[2]);
        mainPanel.add(numberButtons[3]);
        mainPanel.add(addButton);
        mainPanel.add(numberButtons[4]);
        mainPanel.add(numberButtons[5]);
        mainPanel.add(numberButtons[6]);
        mainPanel.add(subButton);
        mainPanel.add(numberButtons[7]);
        mainPanel.add(numberButtons[8]);
        mainPanel.add(numberButtons[9]);
        mainPanel.add(mulButton);
        mainPanel.add(decButton);
        mainPanel.add(numberButtons[0]);
        mainPanel.add(equButton);
        mainPanel.add(divButton);

        // Panel for the control buttons with gaps
        controlPanel = new JPanel();
        controlPanel.setBounds(50, 430, 300, 50);
        controlPanel.setLayout(new GridLayout(1, 3, 10, 0)); // 1 row, 3 columns, with 10px horizontal gap
        controlPanel.setBackground(new Color(30, 30, 30));

        // Add control buttons to the new panel
        controlPanel.add(negButton);
        controlPanel.add(delButton);
        controlPanel.add(clrButton);

        // Add components to the frame
        this.add(mainPanel);
        this.add(controlPanel);
        this.add(display);
        this.setVisible(true);
    }

    // Main method to create and run the calculator
    public static void main(String[] args) {
        new Calculator();
    }

    // Action listener for button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle number button clicks
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                String currentText = display.getText();
                if (currentText.equals("0") && i == 0) {
                    // Do nothing if trying to add '0' to an already '0' display
                    return;
                } else if (currentText.equals("0")) {
                    // Replace '0' with the new number
                    display.setText(String.valueOf(i));
                } else {
                    // Append the new number
                    display.setText(currentText.concat(String.valueOf(i)));
                }
            }
        }

        // Handle decimal point click
        if (e.getSource() == decButton) {
            if (!display.getText().contains(".")) {
                display.setText(display.getText().concat("."));
            }
        }

        // Handle operator clicks
        if (e.getSource() == addButton) {
            if (!display.getText().isEmpty()) {
                num1 = Double.parseDouble(display.getText());
                operator = '+';
                display.setText("");
            }
        }
        if (e.getSource() == subButton) {
            if (!display.getText().isEmpty()) {
                num1 = Double.parseDouble(display.getText());
                operator = '-';
                display.setText("");
            }
        }
        if (e.getSource() == mulButton) {
            if (!display.getText().isEmpty()) {
                num1 = Double.parseDouble(display.getText());
                operator = '*';
                display.setText("");
            }
        }
        if (e.getSource() == divButton) {
            if (!display.getText().isEmpty()) {
                num1 = Double.parseDouble(display.getText());
                operator = '/';
                display.setText("");
            }
        }

        // Handle equals button click
        if (e.getSource() == equButton) {
            if (!display.getText().isEmpty()) {
                num2 = Double.parseDouble(display.getText());

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            display.setText("Error");
                            return;
                        }
                        break;
                }
                display.setText(String.valueOf(result));
                num1 = result;
            }
        }

        // Handle clear button click
        if (e.getSource() == clrButton) {
            display.setText("");
        }

        // Handle delete button click
        if (e.getSource() == delButton) {
            String string = display.getText();
            if (!string.isEmpty()) {
                display.setText(string.substring(0, string.length() - 1));
            }
        }

        // Handle negative/positive button click
        if (e.getSource() == negButton) {
            String string = display.getText();
            if (!string.isEmpty()) {
                double temp = Double.parseDouble(string);
                temp *= -1;
                display.setText(String.valueOf(temp));
            }
        }
    }
}
