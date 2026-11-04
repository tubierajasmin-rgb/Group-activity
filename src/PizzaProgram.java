import javax.swing.JOptionPane;

public class PizzaProgram {
    public static void main(String[] args) {
        while (true) {
            try {
                String[] toppingsOptions = {"Pepperoni", "Ham and Cheese", "Hawaiian"};
                String selectedTopping = "";
                double toppingPrice = 0;

                while (true) {
                    selectedTopping = (String) JOptionPane.showInputDialog(
                        null, 
                        "Choose Toppings", 
                        "Pizza Program", 
                        JOptionPane.QUESTION_MESSAGE, 
                        null, 
                        toppingsOptions, 
                        null
                    );

                    if (selectedTopping == null) {
                        int cancelChoice = JOptionPane.showConfirmDialog(
                            null, 
                            "Want to CANCEL the order?", 
                            "Confirm Question", 
                            JOptionPane.YES_NO_OPTION
                        );
                        if (cancelChoice == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Thank you!");
                            System.exit(0);
                        } else {
                            continue;
                        }
                    }

                    if (selectedTopping.equals("Pepperoni")) {
                        toppingPrice = 100;
                        JOptionPane.showMessageDialog(null, "You chose Pepperoni\nwhich cost additional 100php!");
                    } else if (selectedTopping.equals("Ham and Cheese")) {
                        toppingPrice = 150;
                        JOptionPane.showMessageDialog(null, "You chose Ham and Cheese\nwhich cost additional 150php!");
                    } else if (selectedTopping.equals("Hawaiian")) {
                        toppingPrice = 200;
                        JOptionPane.showMessageDialog(null, "You chose Hawaiian\nwhich cost additional 200php!");
                    }

                    int confirmTopping = JOptionPane.showConfirmDialog(
                        null, 
                        "Are you sure?\nYou want " + selectedTopping + "?", 
                        "Confirm Question", 
                        JOptionPane.YES_NO_OPTION
                    );

                    if (confirmTopping == JOptionPane.YES_OPTION) {
                        break;
                    }
                }

                double diameterCm = 0;
                while (true) {
                    String diameterStr = JOptionPane.showInputDialog(null, "Enter Diameter in inches", "Input", JOptionPane.QUESTION_MESSAGE);
                    if (diameterStr == null) {
                        int cancelChoice = JOptionPane.showConfirmDialog(null, "Want to CANCEL the order?", "Confirm Question", JOptionPane.YES_NO_OPTION);
                        if (cancelChoice == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Thank you!");
                            System.exit(0);
                        } else {
                            continue;
                        }
                    }
                    double diameterInches = Double.parseDouble(diameterStr);
                    diameterCm = diameterInches * 2.54;
                    break;
                }

                int quantity = 0;
                while (true) {
                    String qtyStr = JOptionPane.showInputDialog(null, "Enter How Many?", "Input", JOptionPane.QUESTION_MESSAGE);
                    if (qtyStr == null) {
                        int cancelChoice = JOptionPane.showConfirmDialog(null, "Want to CANCEL the order?", "Confirm Question", JOptionPane.YES_NO_OPTION);
                        if (cancelChoice == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Thank you!");
                            System.exit(0);
                        } else {
                            continue;
                        }
                    }
                    quantity = Integer.parseInt(qtyStr);
                    break;
                }

                String[] discountOptions = {"N/A", "Senior-PWD", "VIP"};
                int discountChoice = JOptionPane.showOptionDialog(
                    null, 
                    "Choose Discount:", 
                    "Pizza Program", 
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    discountOptions, 
                    discountOptions[0]
                );

                double discountRate = 0;
                if (discountChoice == 1 || discountChoice == 2) {
                    while (true) {
                        String cardType = (discountChoice == 1) ? "Senior/PWD ID Number:" : "VIP Card Number:";
                        String cardNum = JOptionPane.showInputDialog(null, "Enter " + cardType, "Input", JOptionPane.QUESTION_MESSAGE);
                        if (cardNum == null) {
                            int cancelChoice = JOptionPane.showConfirmDialog(null, "Want to CANCEL the order?", "Confirm Question", JOptionPane.YES_NO_OPTION);
                            if (cancelChoice == JOptionPane.YES_OPTION) {
                                JOptionPane.showMessageDialog(null, "Thank you!");
                                System.exit(0);
                            } else {
                                continue;
                            }
                        }
                        break;
                    }
                    if (discountChoice == 1) {
                        discountRate = 0.20;
                    } else if (discountChoice == 2) {
                        discountRate = 0.12;
                    }
                }

                double basePricePerPizza = (diameterCm * 5.0) + toppingPrice;
                double subtotal = basePricePerPizza * quantity;
                double totalDiscount = subtotal * discountRate;
                double totalPrice = subtotal - totalDiscount;

                int roundedCm = (int) Math.round(diameterCm);
                JOptionPane.showMessageDialog(null, "You ordered for " + selectedTopping + " Pizza\nwith the size of " + roundedCm + " centimeter\nfor the total price of PHP" + String.format("%.2f", totalPrice));

                double payment = 0;
                while (true) {
                    String paymentStr = JOptionPane.showInputDialog(null, "Enter Amount:", "Input", JOptionPane.QUESTION_MESSAGE);
                    if (paymentStr == null) {
                        int cancelChoice = JOptionPane.showConfirmDialog(null, "Want to CANCEL the order?", "Confirm Question", JOptionPane.YES_NO_OPTION);
                        if (cancelChoice == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Thank you!");
                            System.exit(0);
                        } else {
                            continue;
                        }
                    }
                    payment = Double.parseDouble(paymentStr);
                    if (payment > totalPrice) {
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Insufficient Amount");
                    }
                }

                double change = payment - totalPrice;
                JOptionPane.showMessageDialog(null, "Your CHANGE is Php" + String.format("%.0f", change));
                JOptionPane.showMessageDialog(null, "Thank you!");
                break;

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid input encountered. Restarting order.");
            }
        }
    }
}