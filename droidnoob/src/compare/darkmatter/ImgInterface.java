package compare.darkmatter;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.SwingConstants;

import java.awt.Font;


public class ImgInterface extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private static JTextField textField1;
	private static JTextField textField2;
	static String url1= "";
	static String url2= "";
	static JButton btnCheckSimilarity= new JButton("Check Similarity");
	private JLabel lblEnterImage = new JLabel("Enter Image 1 URL :");
	private JLabel lblEnterImage_1 = new JLabel("Enter Image 2 URL :");
	static JLabel label = new JLabel("      ");
	private final JLabel lblEnterImagesOf = new JLabel("Enter images of same resolution");
	private final static JButton btnShowImages = new JButton("Show Images");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			
		  btnCheckSimilarity.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					 url1= textField1.getText();
					  url2= textField2.getText();
					  
					  ImgDiffPercent img= new ImgDiffPercent( url1, url2);
					  double a = img.DifPerc();
					  String str = new Double(a).toString();
					  label.setText(str);
					  System.out.println("Similarity Percentage : " + str);
				}
			});
		  
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImgInterface frame = new ImgInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ImgInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBorder(BorderFactory.createTitledBorder("Image Comparison Tool"));
		
		
		lblEnterImage.setBounds(37, 55, 132, 14);
		contentPane.add(lblEnterImage);
		
		textField1 = new JTextField();
		textField1.setBounds(179, 52, 228, 20);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		
		
		lblEnterImage_1.setBounds(37, 118, 132, 14);
		contentPane.add(lblEnterImage_1);
		
		textField2 = new JTextField();
		textField2.setBounds(179, 115, 228, 20);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		
		btnCheckSimilarity.setBounds(257, 178, 150, 23);
		contentPane.add(btnCheckSimilarity);
		
		JLabel lblSimilarityPercentage = new JLabel("Similarity Percentage :");
		lblSimilarityPercentage.setBounds(37, 236, 132, 14);
		contentPane.add(lblSimilarityPercentage);
		
		label.setBounds(184, 236, 97, 14);
		contentPane.add(label);
		lblEnterImagesOf.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEnterImagesOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterImagesOf.setBounds(25, 11, 382, 30);
		contentPane.add(lblEnterImagesOf);
		btnShowImages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				url1= textField1.getText();
				  url2= textField2.getText();
				 new ImgShow( url1,url2);
			}
		});
		btnShowImages.setBounds(92, 178, 150, 23);
		
		contentPane.add(btnShowImages);
	}
}
