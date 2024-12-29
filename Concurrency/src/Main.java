import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Concurrency in Swing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);
            frame.setLayout(new BorderLayout());

            JLabel statusLabel = new JLabel("Press button for start heavy operation", JLabel.CENTER);
            JButton startButton = new JButton("Start");

            JProgressBar progressBar = new JProgressBar(0, 60);
            progressBar.setValue(0);
            progressBar.setStringPainted(true);

            frame.add(statusLabel, BorderLayout.NORTH);
            frame.add(progressBar, BorderLayout.CENTER);
            frame.add(startButton, BorderLayout.SOUTH);

            startButton.addActionListener(e -> {
                startButton.setEnabled(false);
                statusLabel.setText("Heavy operation in progress...");

                SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        for (int i = 0; i <= 100; i++) {
                            Thread.sleep(50);
                            publish(i);
                        }
                        return null;
                    }

                    @Override
                    protected void process(List<Integer> chunks) {
                        progressBar.setValue(chunks.get(chunks.size() - 1));
                    }

                    @Override
                    protected void done() {
                        startButton.setEnabled(true);
                        statusLabel.setText("Heavy operation completed");
                    }
                };
                worker.execute();
            });

            frame.setVisible(true);
            frame.setVisible(true);
        });
    }
}
