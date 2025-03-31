
package UploadImage;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class UploadImage extends JPanel {

    private button.ButtonClear button11;
    private JLabel imageLabel;
    private final int CROP_SIZE = 400;

    private String selectedFilePath;

    public UploadImage() {
        initComponents();
    }

    private void initComponents() {
        button11 = new button.ButtonClear();
        imageLabel = new JLabel();

        button11.setText("Upload photo");
        button11.setFont(new Font("Afacad", Font.BOLD, 24));
        button11.setPreferredSize(new Dimension(250, 60));

        button11.addActionListener(evt -> openFileChooser());

        setLayout(new BorderLayout());
        add(button11, BorderLayout.CENTER);
    }

    private void openFileChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a photo");

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "png", "jpeg");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            selectedFilePath = selectedFile.getAbsolutePath();

            try {
                BufferedImage originalImage = ImageIO.read(selectedFile);
                BufferedImage croppedImage = cropImage(originalImage, CROP_SIZE, CROP_SIZE);

                ImageIcon croppedIcon = new ImageIcon(croppedImage);

                imageLabel.setIcon(croppedIcon);
                imageLabel.setText("");

                imageLabel.setBorder(null);
                imageLabel.setOpaque(false);

                remove(button11);
                add(imageLabel, BorderLayout.CENTER);

                imageLabel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent evt) {
                        openFileChooser();
                    }
                });
                revalidate();
                repaint();

            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error loading image!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private BufferedImage cropImage(BufferedImage original, int width, int height) {
        int x = (original.getWidth() - width) / 2;
        int y = (original.getHeight() - height) / 2;

        int cropWidth = Math.min(width, original.getWidth());
        int cropHeight = Math.min(height, original.getHeight());

        return original.getSubimage(x, y, cropWidth, cropHeight);
    }

    public String getSelectedFilePath() {
        return selectedFilePath;
    }
}
