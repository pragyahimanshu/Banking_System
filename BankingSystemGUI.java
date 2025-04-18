// English GUI version of Banking System App with tabbed layout and branding
// English GUI version of Banking System App with tabbed layout and branding
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BankingSystemGUI {
    ArrayList<String> accounts = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BankingSystemGUI().createAndShowGUI());
    }

    void createAndShowGUI() {
        JFrame frame = new JFrame("  Banking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JTabbedPane tabs = new JTabbedPane();

        tabs.addTab("Home", createHomePanel());
        tabs.addTab("Transactions", createTransactionsPanel());
        tabs.addTab("Admin", createAdminPanel());
        tabs.addTab("Contact Us", createContactPanel());

        JLabel footer = new JLabel("Developed by Pragya Himanshu, B.Tech CSE", JLabel.CENTER);
        footer.setFont(new Font("Arial", Font.PLAIN, 14));
        footer.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        frame.add(tabs, BorderLayout.CENTER);
        frame.add(footer, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    JPanel createHomePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel title = new JLabel("Welcome to Online Banking System", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));

        ImageIcon logo = new ImageIcon("banking-system-icon-financial-institutions-vector.jpg");
        JLabel logoLabel = new JLabel(logo, JLabel.CENTER);

        panel.add(title, BorderLayout.NORTH);
        panel.add(logoLabel, BorderLayout.CENTER);

        return panel;
    }

    JPanel createTransactionsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 1, 10, 10));

        JButton checkBalanceBtn = new JButton("Check Balance");
        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");
        JButton transferBtn = new JButton("Transfer Funds");
        JButton statementBtn = new JButton("Mini Statement");
        JButton changePinBtn = new JButton("Change PIN");
        JButton addAccountBtn = new JButton("Add New Account");
        JButton calculateInterestBtn = new JButton("Calculate Interest");

        checkBalanceBtn.addActionListener(e -> JOptionPane.showMessageDialog(panel, "Your balance is ₹10,000"));
        depositBtn.addActionListener(e -> JOptionPane.showInputDialog(panel, "Enter amount to deposit:"));
        withdrawBtn.addActionListener(e -> JOptionPane.showInputDialog(panel, "Enter amount to withdraw:"));
        transferBtn.addActionListener(e -> JOptionPane.showInputDialog(panel, "Enter recipient and amount to transfer:"));
        statementBtn.addActionListener(e -> JOptionPane.showMessageDialog(panel, "Mini Statement:\n- ₹500 withdrawn\n- ₹1000 deposited"));
        changePinBtn.addActionListener(e -> JOptionPane.showInputDialog(panel, "Enter new 4-digit PIN:"));

        addAccountBtn.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(panel, "Enter details to add new account (Name, Age, Initial Deposit):");
            if (input != null && !input.trim().isEmpty()) {
                accounts.add(input);
                JOptionPane.showMessageDialog(panel, "Account added successfully!");
            }
        });

        calculateInterestBtn.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(panel, "Enter principal, rate and time (comma separated):");
            if (input != null && !input.trim().isEmpty()) {
                try {
                    String[] parts = input.split(",");
                    double principal = Double.parseDouble(parts[0].trim());
                    double rate = Double.parseDouble(parts[1].trim());
                    double time = Double.parseDouble(parts[2].trim());
                    double interest = (principal * rate * time) / 100;
                    JOptionPane.showMessageDialog(panel, "Simple Interest: ₹" + interest);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, "Invalid input. Please enter valid numbers.");
                }
            }
        });

        panel.add(checkBalanceBtn);
        panel.add(depositBtn);
        panel.add(withdrawBtn);
        panel.add(transferBtn);
        panel.add(statementBtn);
        panel.add(changePinBtn);
        panel.add(addAccountBtn);
        panel.add(calculateInterestBtn);

        return panel;
    }

    JPanel createAdminPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        JButton viewAccountsBtn = new JButton("View All Accounts");
        JButton unlockBtn = new JButton("Unlock Account");
        JButton resetPinBtn = new JButton("Reset PIN");
        JButton logoutBtn = new JButton("Logout");

        viewAccountsBtn.addActionListener(e -> {
            if (accounts.isEmpty()) {
                JOptionPane.showMessageDialog(panel, "No accounts found.");
            } else {
                StringBuilder sb = new StringBuilder("Account List:\n");
                for (int i = 0; i < accounts.size(); i++) {
                    sb.append((i + 1)).append(": ").append(accounts.get(i)).append("\n");
                }
                JOptionPane.showMessageDialog(panel, sb.toString());
            }
        });

        unlockBtn.addActionListener(e -> JOptionPane.showInputDialog(panel, "Enter account number to unlock:"));
        resetPinBtn.addActionListener(e -> JOptionPane.showInputDialog(panel, "Enter new PIN:"));
        logoutBtn.addActionListener(e -> JOptionPane.showMessageDialog(panel, "Logged out successfully."));

        panel.add(viewAccountsBtn);
        panel.add(unlockBtn);
        panel.add(resetPinBtn);
        panel.add(logoutBtn);

        return panel;
    }

    JPanel createContactPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel("For support, contact: pragyahimanshu@gmail.com", JLabel.CENTER), BorderLayout.CENTER);
        return panel;
    }
}
