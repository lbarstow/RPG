/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw5;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author baylor
 */
public class CharacterDesignerForm extends JFrame
{
	//<editor-fold defaultstate="collapsed" desc="graphics variables">
	Map<String,Image> images = new HashMap<String,Image>();
	BufferedImage backBufferContainer;
	Graphics backBuffer, frontBuffer;
	//</editor-fold>

	//<editor-fold defaultstate="collapsed" desc="models for list controls">
	ComboBoxModel<EquipableItem> backgroundsModel;
	ComboBoxModel<EquipableItem> headModel;
	ComboBoxModel<EquipableItem> handsModel;
	ComboBoxModel<EquipableItem> feetModel;
	//</editor-fold>

	private EquipableItem itemOnHead, itemOnHands, itemOnFeet;
	private String backgroundImageName = "";

	/**
	 * Constructor
	 */
	public CharacterDesignerForm()
	{
		initComponents();
		setLocationRelativeTo(null);

		initializeGraphics();
		loadComboBoxes();
		loadImages();
		repaint();
	}

	private void initializeGraphics()
	{
		backBufferContainer = new BufferedImage(drawingPanel.getWidth(),
			drawingPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
		backBuffer  = backBufferContainer.getGraphics();
		frontBuffer = drawingPanel.getGraphics();
	}

	private void drawCharacter()
	{
		//--- Erase what ever used to be drawn there
		backBuffer.clearRect(0, 0, backBufferContainer.getWidth(),
				backBufferContainer.getHeight());
		backBuffer.drawImage(images.get(backgroundImageName), 0, 0, null);

		//--- Draw the background / body
		backBuffer.drawImage(images.get("body"), 0, 0, null);

		//--- Items
		if (null != itemOnHead)
		{
			backBuffer.drawImage(images.get(itemOnHead.id), 0, 0, null);
		}
		if (null != itemOnHands)
		{
			backBuffer.drawImage(images.get(itemOnHands.id), 0, 0, null);
		}
		if (null != itemOnFeet)
		{
			backBuffer.drawImage(images.get(itemOnFeet.id), 0, 0, null);
		}


		//--- Show the finished product
		frontBuffer.drawImage(backBufferContainer, 0, 0, null);
	}

	private void loadComboBoxes()
	{
		//--- Backgrounds
		EquipableItem[] items = new EquipableItem[3];
		items[0] = new EquipableItem("background white", "");
		items[1] = new EquipableItem("background forest", "Forest");
		items[2] = new EquipableItem("background scary forest", "Scary Forest");
		backgroundsModel = new DefaultComboBoxModel<EquipableItem>(items);
		backgroundsComboBox.setModel(backgroundsModel);
		backgroundsComboBox.setSelectedIndex(0);

		//--- Hats
		items = new EquipableItem[3];
		items[0] = null;
		items[1] = new EquipableItem("beanie", "Beanie of Strength");
		items[2] = new EquipableItem("helm", "Helm of Fortitude");
		headModel = new DefaultComboBoxModel<EquipableItem>(items);
		headComboBox.setModel(headModel);

		//--- Hands
		items = new EquipableItem[6];
		items[0] = null;
		items[1] = new EquipableItem("knife", "Knife");
		items[2] = new EquipableItem("sword", "Sword");
		items[3] = new EquipableItem("sword blue", "Ice Blade");
		items[4] = new EquipableItem("sword curvy", "Ebony Scimitar");
		items[5] = new EquipableItem("sword red", "Flame Blade");
		handsModel = new DefaultComboBoxModel<EquipableItem>(items);
		handsComboBox.setModel(handsModel);

		//--- Feet
		items = new EquipableItem[3];
		items[0] = null;
		items[1] = new EquipableItem("boots", "Boots");
		items[2] = new EquipableItem("crocs", "Gator Boots");
		feetModel = new DefaultComboBoxModel<EquipableItem>(items);
		feetComboBox.setModel(feetModel);
	}

	private Image loadImage(String fullyQualifiedName)
	{
		BufferedImage image;
		Image scaled = null;
		try
		{
			image = ImageIO.read(new File(fullyQualifiedName));
			scaled = image.getScaledInstance(
						drawingPanel.getWidth(), drawingPanel.getHeight(),
						Image.SCALE_SMOOTH);
		}
		catch (IOException ex)
		{
			System.out.println("Problem loading file " + fullyQualifiedName);
		}
		return scaled;
	}

	private void loadImages()
	{
		Image image;
		String directoryName, fileName;

		directoryName = "hw5RPG/images";
		fileName = "body masked";
		image = loadImage(directoryName + "/" + fileName + ".png");
		images.put("body", image);

		//--- Hats
		directoryName = "hw5RPG/images/head";
		for (int i = 0; i < headModel.getSize(); i++)
		{
			EquipableItem item = headModel.getElementAt(i);
			if (null == item)
			{
				continue;
			}
			fileName = item.id;
			image = loadImage(directoryName + "/" + fileName + ".png");
			images.put(fileName, image);
		}

		//--- Hands
		directoryName = "hw5RPG/images/hands";
		for (int i = 0; i < handsModel.getSize(); i++)
		{
			EquipableItem item = handsModel.getElementAt(i);
			if (null == item)
			{
				continue;
			}
			fileName = item.id;
			image = loadImage(directoryName + "/" + fileName + ".png");
			images.put(fileName, image);
		}

		//--- Feet
		directoryName = "hw5RPG/images/feet";
		for (int i = 0; i < feetModel.getSize(); i++)
		{
			EquipableItem item = feetModel.getElementAt(i);
			if (null == item)
			{
				continue;
			}
			fileName = item.id;
			image = loadImage(directoryName + "/" + fileName + ".png");
			images.put(fileName, image);
		}

		//--- Backgrounds
		directoryName = "hw5RPG/images/backgrounds";
		for (int i = 0; i < backgroundsModel.getSize(); i++)
		{
			EquipableItem item = backgroundsModel.getElementAt(i);
			if (null == item)
			{
				continue;
			}
			fileName = item.id;
			image = loadImage(directoryName + "/" + fileName + ".png");
			images.put(fileName, image);
		}
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		drawCharacter();
	}


	//<editor-fold defaultstate="collapsed" desc="NetBeans generated stuff - don't touch">
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel1 = new JLabel();
        jTextField1 = new JTextField();
        headComboBox = new JComboBox();
        jLabel2 = new JLabel();
        jScrollPane1 = new JScrollPane();
        outputTextArea = new JTextArea();
        jPanel1 = new JPanel();
        drawingPanel = new JPanel();
        jLabel3 = new JLabel();
        handsComboBox = new JComboBox();
        jLabel4 = new JLabel();
        feetComboBox = new JComboBox();
        jLabel5 = new JLabel();
        backgroundsComboBox = new JComboBox();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Character Designer");

        jLabel1.setText("Strength");

        jTextField1.setHorizontalAlignment(JTextField.TRAILING);
        jTextField1.setText("9");

        headComboBox.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                headComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Head");

        outputTextArea.setColumns(20);
        outputTextArea.setRows(5);
        jScrollPane1.setViewportView(outputTextArea);

        jPanel1.setBackground(new Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new Color(0, 0, 0), 2, true));

        drawingPanel.setBorder(BorderFactory.createEtchedBorder());
        drawingPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        drawingPanel.setFocusable(false);
        drawingPanel.setMinimumSize(new Dimension(270, 460));
        drawingPanel.setPreferredSize(new Dimension(270, 460));
        drawingPanel.setRequestFocusEnabled(false);
        drawingPanel.setVerifyInputWhenFocusTarget(false);

        GroupLayout drawingPanelLayout = new GroupLayout(drawingPanel);
        drawingPanel.setLayout(drawingPanelLayout);
        drawingPanelLayout.setHorizontalGroup(
            drawingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 266, Short.MAX_VALUE)
        );
        drawingPanelLayout.setVerticalGroup(
            drawingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
        );

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(drawingPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(drawingPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("Hands");

        handsComboBox.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                handsComboBoxActionPerformed(evt);
            }
        });

        jLabel4.setText("Feet");

        feetComboBox.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                feetComboBoxActionPerformed(evt);
            }
        });

        jLabel5.setText("Background");

        backgroundsComboBox.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                backgroundsComboBoxActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(handsComboBox, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(feetComboBox, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(headComboBox, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(backgroundsComboBox, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 455, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backgroundsComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(headComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(handsComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(feetComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void headComboBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_headComboBoxActionPerformed
    {//GEN-HEADEREND:event_headComboBoxActionPerformed
        itemOnHead = (EquipableItem) headComboBox.getSelectedItem();
		if (null == itemOnHead)
		{
			outputTextArea.append("Removed hat");
		}
		else
		{
			outputTextArea.append("Put on " + itemOnHead.description);
		}
		outputTextArea.append(System.lineSeparator());
		repaint();
    }//GEN-LAST:event_headComboBoxActionPerformed

    private void handsComboBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_handsComboBoxActionPerformed
    {//GEN-HEADEREND:event_handsComboBoxActionPerformed
        itemOnHands = (EquipableItem) handsComboBox.getSelectedItem();
		if (null == itemOnHands)
		{
			outputTextArea.append("Freed up hands");
		}
		else
		{
			outputTextArea.append("Equipped " + itemOnHands.description);
		}
		outputTextArea.append(System.lineSeparator());
		repaint();
    }//GEN-LAST:event_handsComboBoxActionPerformed

    private void feetComboBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_feetComboBoxActionPerformed
    {//GEN-HEADEREND:event_feetComboBoxActionPerformed
        itemOnFeet = (EquipableItem) feetComboBox.getSelectedItem();
		if (null == itemOnFeet)
		{
			outputTextArea.append("Removed footwear");
		}
		else
		{
			outputTextArea.append("Put on " + itemOnFeet.description);
		}
		outputTextArea.append(System.lineSeparator());
		repaint();
    }//GEN-LAST:event_feetComboBoxActionPerformed

    private void backgroundsComboBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_backgroundsComboBoxActionPerformed
    {//GEN-HEADEREND:event_backgroundsComboBoxActionPerformed
        EquipableItem item = (EquipableItem)backgroundsComboBox.getSelectedItem();
		backgroundImageName = item.id;
		repaint();
    }//GEN-LAST:event_backgroundsComboBoxActionPerformed
	//</editor-fold>

	//<editor-fold defaultstate="collapsed" desc="NetBeans generated stuff - don't touch">
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[])
	{
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try
		{
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
			{
				if ("Nimbus".equals(info.getName()))
				{
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		}
		catch (ClassNotFoundException ex)
		{
			java.util.logging.Logger.getLogger(CharacterDesignerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch (InstantiationException ex)
		{
			java.util.logging.Logger.getLogger(CharacterDesignerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch (IllegalAccessException ex)
		{
			java.util.logging.Logger.getLogger(CharacterDesignerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		catch (UnsupportedLookAndFeelException ex)
		{
			java.util.logging.Logger.getLogger(CharacterDesignerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				new CharacterDesignerForm().setVisible(true);
			}
		});
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JComboBox backgroundsComboBox;
    private JPanel drawingPanel;
    private JComboBox feetComboBox;
    private JComboBox handsComboBox;
    private JComboBox headComboBox;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTextField jTextField1;
    private JTextArea outputTextArea;
    // End of variables declaration//GEN-END:variables

	//</editor-fold>
}

