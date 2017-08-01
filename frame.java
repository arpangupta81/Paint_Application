package PAINT1;

import java.awt.EventQueue;

public class frame extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JCheckBox checkc;
	public static Color co;
	private JPanel contentPane;
	private JPanel panel;
	JLabel lblNewLabel;
	JLabel lblNewLabel_1;
	Graphics g;
	JTextArea ta;
	/**
	 * Launch the application.
	 */
	public void savefile()
	{
		JFileChooser chooseDirec = new JFileChooser();
        chooseDirec.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooseDirec.showSaveDialog(this);
        File file = chooseDirec.getSelectedFile();
        file = new File(file+".png");
         
        BufferedImage image=new BufferedImage(
               panel.getWidth(), panel.getHeight(),
               BufferedImage.TYPE_INT_RGB);
        Graphics2D g2=(Graphics2D)image.getGraphics();
        panel.paint(g2);
    try
    {
        ImageIO.write(image, "png", file);
    }
    catch (Exception e)
         
    {
    }
	    }
	public void displayContent(String fpath){  
		try{  
		BufferedReader br=new BufferedReader(new FileReader(fpath));  
		String s1="",s2="";  
		              
		while((s1=br.readLine())!=null){  
		s2+=s1+"\n";  
		}  
		ta.setText(s2);  
		br.close();  
		}
		catch (Exception e) {
			e.printStackTrace();  }  
		}
	public void paintComponent(Graphics g)
	{
	
	// TODO Auto-generated method stub
		super.paintComponents(g);	
	}
	public static void main(String[] args)
	{
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame frame = new frame();
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
	public frame() 
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);	
		JMenu mnFile = new JMenu("FILE");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("NEW");
		mntmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnFile.add(mntmNew);
		
		JMenuItem mntmOpen = new JMenuItem("OPEN");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
			JFileChooser fc=new JFileChooser();
			int i=fc.showOpenDialog(contentPane);  
	          
			if(i==JFileChooser.APPROVE_OPTION){  
			File f=fc.getSelectedFile();  
			String filepath=f.getPath();  
			  System.out.println("Hello"+filepath);            
			displayContent(filepath);  

			}
			}	
		});
		  
		
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSaveAs = new JMenuItem("SAVE AS");
		mnFile.add(mntmSaveAs);
		
		JMenuItem mntmSave = new JMenuItem("SAVE");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
			savefile();
			}
		});
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnFile.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("EXIT");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			System.exit(0);
			}
		});
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mnFile.add(mntmExit);
		
		JMenu mnEdit = new JMenu("EDIT");
		menuBar.add(mnEdit);
		
		JMenuItem mntmUndo = new JMenuItem("UNDO");
		mntmUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		mnEdit.add(mntmUndo);
		
		JMenuItem mntmRedo = new JMenuItem("REDO");
		mntmRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_MASK));
		mnEdit.add(mntmRedo);
		
		 final JMenu mnDraw = new JMenu("DRAW");
		 mnDraw.setSelectedIcon(new ImageIcon("G:\\Arpan\\Java\\NIELET\\pencil_medium.jpg.png"));
		menuBar.add(mnDraw);
		
		JMenuItem mntmPencil = new JMenuItem("PENCIL");
		mntmPencil.setSelectedIcon(new ImageIcon("G:\\Arpan\\Java\\NIELET\\pencil_medium.jpg.png"));
		mntmPencil.setIcon(new ImageIcon("G:\\Arpan\\Java\\NIELET\\pencil_medium.jpg.png"));
		mntmPencil.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntmPencil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				panel.removeAll();
				panel.add(new pencil());
				System.out.println("pencil");
			}
		});
		mnDraw.add(mntmPencil);
		
		JMenuItem mntmLine = new JMenuItem("LINE");
		mntmLine.setIcon(new ImageIcon("G:\\Arpan\\Java\\NIELET\\layer_shape_line.png"));
		mntmLine.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntmLine.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				panel.removeAll();
		panel.add(new line());
		System.out.println("line");
			}
		});
		mnDraw.add(mntmLine);	
		
		JMenuItem mntmRectangle = new JMenuItem("RECTANGLE");
		mntmRectangle.setIcon(new ImageIcon("G:\\Arpan\\Java\\NIELET\\rectangle.png"));
		mntmRectangle.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntmRectangle.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				panel.removeAll();
			panel.add(new rect());
			System.out.println("rect");
			}
		});
		mnDraw.add(mntmRectangle);
		
		JMenuItem mntmCircle = new JMenuItem("CIRCLE");
		mntmCircle.setIcon(new ImageIcon("G:\\Arpan\\Java\\NIELET\\mini_circle.png"));
		mntmCircle.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntmCircle.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				panel.removeAll();
			panel.add(new circ());
			}
		});
		mnDraw.add(mntmCircle);
		
		JMenuItem mntmText = new JMenuItem("TEXT");
		mntmText.setIcon(new ImageIcon("G:\\Arpan\\Java\\NIELET\\Actions.draw.text.jpg.png"));
		mntmText.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnDraw.add(mntmText);
		
		JMenu mnColor = new JMenu("COLORS");
		menuBar.add(mnColor);
		
		JMenuItem mntmWhite = new JMenuItem("WHITE");
		mntmWhite.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mnColor.add(mntmWhite);
		
		JMenuItem mntmBlack = new JMenuItem("BLACK");
		mntmBlack.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntmBlack.setForeground(Color.WHITE);
		mntmBlack.setBackground(Color.BLACK);
		mnColor.add(mntmBlack);
		
		JMenuItem mntmRed = new JMenuItem("RED");
		mntmRed.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntmRed.setForeground(Color.WHITE);
		mntmRed.setBackground(Color.RED);
		mnColor.add(mntmRed);
		
		JMenuItem mntmBlue = new JMenuItem("BLUE");
		mntmBlue.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntmBlue.setBackground(Color.BLUE);
		mnColor.add(mntmBlue);
		
		JMenuItem mntmCyan = new JMenuItem("CYAN");
		mntmCyan.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntmCyan.setBackground(Color.CYAN);
		mnColor.add(mntmCyan);
		
		ta=new JTextArea(800,800);  
		ta.setBounds(100,100,700,700); 
		
		JMenuItem mntmYellow = new JMenuItem("YELLOW");
		mntmYellow.setFont(new Font("Segoe UI", Font.BOLD, 15));
		mntmYellow.setBackground(Color.YELLOW);
		mnColor.add(mntmYellow);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBounds(100, 0, 100, 100);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setFocusable(true);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setSize(10, 827);
		separator.setLocation(137, 0);
		separator.setFocusable(true);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(Color.BLACK);
		separator.setForeground(Color.BLACK);
		contentPane.add(separator);
		
		JToggleButton tglbtnBlue = new JToggleButton("BLACK");
		tglbtnBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				co=Color.BLACK;
				}
		});
		tglbtnBlue.setForeground(Color.WHITE);
		tglbtnBlue.setFont(new Font("Tahoma", Font.BOLD, 13));
		tglbtnBlue.setBackground(Color.BLACK);
		tglbtnBlue.setBounds(0, 299, 137, 25);
		contentPane.add(tglbtnBlue);
		
		final JToggleButton tglbtnNewToggleButton = new JToggleButton("PENCIL");
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				tglbtnNewToggleButton.setSelected(true);
				panel.removeAll();
				panel.add(new pencil());
				tglbtnNewToggleButton.setSelected(false);
			}
		});
		tglbtnNewToggleButton.setIcon(new ImageIcon("G:\\Arpan\\Java\\NIELET\\pencil_medium.jpg.png"));
		tglbtnNewToggleButton.setBounds(0, 65, 137, 40);
		contentPane.add(tglbtnNewToggleButton);
		
		final JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("RECTANGLE");
		tglbtnNewToggleButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				tglbtnNewToggleButton_1.setSelected(true);
				panel.removeAll();
				panel.add(new rect());
				tglbtnNewToggleButton_1.setSelected(false);
			}
		});
		tglbtnNewToggleButton_1.setIcon(new ImageIcon("G:\\Arpan\\Java\\NIELET\\rectangle.png"));
		tglbtnNewToggleButton_1.setBounds(0, 141, 137, 40);
		contentPane.add(tglbtnNewToggleButton_1);
		
		final JToggleButton tglbtnNewToggleButton_2 = new JToggleButton("CIRCLE");
		tglbtnNewToggleButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				tglbtnNewToggleButton_2.setSelected(true);
				panel.removeAll();
				panel.add(new circ());
				tglbtnNewToggleButton_2.setSelected(false);
			}
		});
		tglbtnNewToggleButton_2.setIcon(new ImageIcon("G:\\Arpan\\Java\\NIELET\\mini_circle.png"));
		tglbtnNewToggleButton_2.setBounds(0, 178, 137, 40);
		contentPane.add(tglbtnNewToggleButton_2);
		
		JLabel lblShapes = new JLabel("SHAPES");
		lblShapes.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblShapes.setBounds(26, 36, 99, 16);
		contentPane.add(lblShapes);
		
		
		panel = new JPanel();
		panel.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent arg0) 
			{
				panel.removeAll();
				panel.add(new pencil());
				
			}
			public void mouseMoved(MouseEvent e) 
			{
				panel.removeAll();
				panel.add(new pencil());
			}
		});
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) 
			{
				String a=Integer.toString(e.getX());
				String b=", "+Integer.toString(e.getY());
				lblNewLabel.setText(a);
				lblNewLabel_1.setText(b);
			
			}
			@Override
			public void mouseDragged(MouseEvent e) 
			{
				mouseMoved(e);
			}
		});
		
		panel.setBackground(Color.WHITE);
		
		panel.setBounds(146, 0, 570, 455);
		panel.setFocusable(true);
		contentPane.add(panel);
		
		final JToggleButton tglbtnLine = new JToggleButton("LINE");
		tglbtnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				tglbtnLine.setSelected(true);
				panel.removeAll();
				panel.add(new line());
				tglbtnLine.setSelected(false);
			}
		});
		tglbtnLine.setIcon(new ImageIcon("G:\\Arpan\\Java\\NIELET\\layer_shape_line.png"));
		tglbtnLine.setBounds(0, 103, 137, 40);
		contentPane.add(tglbtnLine);
		
		JLabel lblColors = new JLabel("COLORS");
		lblColors.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblColors.setBounds(26, 246, 99, 16);
		contentPane.add(lblColors);
		
		JToggleButton tglbtnWhite = new JToggleButton("WHITE");
		tglbtnWhite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			co=Color.WHITE;
			}
		});
		tglbtnWhite.setForeground(Color.BLACK);
		tglbtnWhite.setFont(new Font("Tahoma", Font.BOLD, 13));
		tglbtnWhite.setBackground(Color.WHITE);
		tglbtnWhite.setBounds(0, 274, 137, 25);
		contentPane.add(tglbtnWhite);
		
		JToggleButton tglbtnRed = new JToggleButton("RED");
		tglbtnRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				co=Color.RED;
         	}
		});
		tglbtnRed.setForeground(Color.WHITE);
		tglbtnRed.setFont(new Font("Tahoma", Font.BOLD, 13));
		tglbtnRed.setBackground(Color.RED);
		tglbtnRed.setBounds(0, 323, 137, 25);
		contentPane.add(tglbtnRed);
		
		JToggleButton toggleButton_2 = new JToggleButton("BLUE");
		toggleButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				co=Color.BLUE;
			}
		});
		toggleButton_2.setForeground(Color.WHITE);
		toggleButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		toggleButton_2.setBackground(Color.BLUE);
		toggleButton_2.setBounds(0, 347, 137, 25);
		contentPane.add(toggleButton_2);
		
		JToggleButton tglbtnCyan = new JToggleButton("CYAN");
		tglbtnCyan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				co=Color.CYAN;
			}
		});
		tglbtnCyan.setForeground(Color.BLACK);
		tglbtnCyan.setFont(new Font("Tahoma", Font.BOLD, 13));
		tglbtnCyan.setBackground(Color.CYAN);
		tglbtnCyan.setBounds(0, 371, 137, 25);
		contentPane.add(tglbtnCyan);
		
		JToggleButton tglbtnYellow = new JToggleButton("YELLOW");
		tglbtnYellow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				co=Color.YELLOW;
			}
		});
		tglbtnYellow.setForeground(Color.BLACK);
		tglbtnYellow.setFont(new Font("Tahoma", Font.BOLD, 13));
		tglbtnYellow.setBackground(Color.YELLOW);
		tglbtnYellow.setBounds(0, 395, 137, 25);
		contentPane.add(tglbtnYellow);
		
		JLabel lblCurrentlyMouseAt = new JLabel("Currently Mouse at :");
		lblCurrentlyMouseAt.setBounds(681, 598, 130, 16);
		contentPane.add(lblCurrentlyMouseAt);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setBounds(805, 598, 27, 16);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBounds(832, 598, 27, 16);
		contentPane.add(lblNewLabel_1);
		
		final JToggleButton tglbtnClearScreen = new JToggleButton("CLEAR SCREEN");
		tglbtnClearScreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				tglbtnClearScreen.setSelected(true);
				panel.removeAll();
				panel.add(new clear());
				tglbtnClearScreen.setSelected(false);
			}
		});
		tglbtnClearScreen.setBounds(0, 511, 137, 25);
		contentPane.add(tglbtnClearScreen);
		
		final JToggleButton tglbtnEraser = new JToggleButton("ERASER");
		tglbtnEraser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				tglbtnEraser.setSelected(true);
				panel.removeAll();
				panel.add(new erase());
				tglbtnEraser.setSelected(false);
			}
		});
		tglbtnEraser.setBounds(0, 473, 137, 25);
		contentPane.add(tglbtnEraser);
		
		checkc = new JCheckBox("FILL COLOR");
		checkc.setBounds(12, 429, 113, 25);
		contentPane.add(checkc);
	}
}
