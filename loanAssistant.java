package loan_Assistant;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoanAssistant extends JFrame
{
	public static void main(String args[])
	{
		new LoanAssistant().setVisible(true);
	}
	
	Color lightYellow = new Color(255, 255, 128);
	boolean c_payment;
	GridBagConstraints gbc = new GridBagConstraints();
	JLabel b_Label = new JLabel("Loan Balance");
	JTextField btf = new JTextField();
	JLabel i_Label = new JLabel("Rate of Interest");
	JTextField itf = new JTextField();
	JLabel m_Label = new JLabel("Number of Months");
	JTextField mtf = new JTextField();
	JLabel p_Label = new JLabel("Monthly Payments");
	JTextField ptf = new JTextField();
	JButton c_button = new JButton("Compute Monthly Payment");
	JButton n_button = new JButton("New Loan Analyis");
	JButton m1_button = new JButton("X");
	JButton n1_button = new JButton("X");
	JLabel l_label = new JLabel("Loan Analysis :");
	JTextArea ta = new JTextArea();
	JButton e_button = new JButton("Exit");
	Font mfont = new Font("Arial",Font.PLAIN,16);
	double interest,balance,payment,m_interest,multiplier,l_bal,f_payment;
	int months;

	public boolean validateDecimalNumber(JTextField tf)
	{
		int i ;
		String s = tf.getText().trim();
		boolean decimal = false;
		boolean check = true;
		
		if(s.length()==0)
		{
			check = false;
		}
		else
		{
			for( i = 0; i<s.length();i++)
			{
				char c = s.charAt(i);
				if(c>='0' && c<='9')
				{
					continue;
				}	
				else if(c == '.' && !decimal)
				{
					
				}
				else
				{
					check = false;
				}
			}
		}
		
		tf.setText(s);
		if(!check)
		{
			tf.requestFocus();
		}
		
		return check;
	}
	LoanAssistant()
	{
		
		setTitle("LOAN ASSISTANT");
		//setResizable(false);
		setSize(1000,600);
		getContentPane().setLayout(new GridBagLayout());
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent evt)
			{
				exitForm(evt);
			}

			private void exitForm(WindowEvent evt) 
			{
				// TODO Auto-generated method stub
				System.exit(0);
			}
		}
		);
		
		//1st label
		b_Label.setFont(mfont);
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.anchor= gbc.WEST;
		gbc.insets = new Insets(10,10,0,0);
		getContentPane().add(b_Label,gbc);
		
		btf.setPreferredSize(new Dimension(100,25));
		btf.setHorizontalAlignment(SwingConstants.CENTER);
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.insets = new Insets(10,10,0,10);
		getContentPane().add(btf,gbc);
		btf.addActionListener(new ActionListener()
		{		
			public void ActionPerformed(ActionEvent e)
			{
				ActionPerformed(e);
			}

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				btf.transferFocus();	
			}
		});
		
		//2nd label
		i_Label.setFont(mfont);
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.anchor= gbc.WEST;
		gbc.insets = new Insets(10,10,0,0);
		getContentPane().add(i_Label,gbc);
		
		itf.setPreferredSize(new Dimension(100,25));
		itf.setHorizontalAlignment(SwingConstants.CENTER);
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.insets = new Insets(10,10,0,10);
		getContentPane().add(itf,gbc);
		itf.addActionListener(new ActionListener()
		{		
			public void ActionPerformed(ActionEvent e)
			{
				ActionPerformed(e);
			}

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				itf.transferFocus();	
			}
		});
		
		
		//3rd label
		m_Label.setFont(mfont);
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.anchor= gbc.WEST;
		gbc.insets = new Insets(10,10,0,0);
		getContentPane().add(m_Label,gbc);
		
		mtf.setPreferredSize(new Dimension(100,25));
		mtf.setHorizontalAlignment(SwingConstants.CENTER);
		gbc.gridx=1;
		gbc.gridy=2;
		gbc.insets = new Insets(10,10,0,10);
		getContentPane().add(mtf,gbc);
		mtf.addActionListener(new ActionListener()
		{		
			public void ActionPerformed(ActionEvent e)
			{
				ActionPerformed(e);
			}

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				mtf.transferFocus();	
			}
		});
		
		
		//4th label
		p_Label.setFont(mfont);
		gbc.gridx=0;
		gbc.gridy=3;
		gbc.anchor= gbc.WEST;
		gbc.insets = new Insets(10,10,0,0);
		getContentPane().add(p_Label,gbc);
		
		ptf.setPreferredSize(new Dimension(100,25));
		ptf.setHorizontalAlignment(SwingConstants.CENTER);
		gbc.gridx=1;
		gbc.gridy=3;
		gbc.insets = new Insets(10,10,0,10);
		getContentPane().add(ptf,gbc);		
		ptf.addActionListener(new ActionListener()
		{		
			public void ActionPerformed(ActionEvent e)
			{
				ActionPerformed(e);
			}

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				ptf.transferFocus();	
			}
		});
		
		//x , compute,new buttons
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(10,0,0,0);
		getContentPane().add(c_button, gbc);
		c_button.addActionListener(new ActionListener()
		{
				public void ActionPerformed(ActionEvent e)
				{
					ActionPerformed(e);
				}

				@Override
				public void actionPerformed(ActionEvent e) 
				{
					if(validateDecimalNumber(btf))
					{
						balance = Double.valueOf(btf.getText()).doubleValue();
					}
					else
					{
						JOptionPane.showConfirmDialog(null, "Invalid or Empty Loan Balance Entry.\n Please correct ","Balance Input Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					if(validateDecimalNumber(itf))
					{	
						interest = Double.valueOf(itf.getText()).doubleValue();
					}
					else
					{
						JOptionPane.showConfirmDialog(null, "Invalid or Empty Interest Rate Entry.\n Please correct ","Interest Input Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
						return;
					}
					m_interest = interest/1200;
				//Compute loan Payment
					if(c_payment)
					{	
						if(validateDecimalNumber(mtf))
						{
							months = Integer.valueOf(mtf.getText()).intValue();
						}
						else
						{
							JOptionPane.showConfirmDialog(null, "Invalid or Empty Number of Payments Entry.\n Please correct ","Number of Payments Input Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						
						if(interest==0)
						{
							payment = balance/months;
						}
						else
						{	
							multiplier = Math.pow(1+m_interest, months);
							payment = (balance*m_interest*multiplier)/(multiplier-1);
						}
						ptf.setText(new DecimalFormat("0.00").format(payment));
					}
					else
					{
						if(validateDecimalNumber(ptf))
						{	
							payment = Double.valueOf(ptf.getText()).doubleValue();
						
							if(payment <= (balance*m_interest+1.0))
							{
								if(JOptionPane.showConfirmDialog(null, "Minimum payment of $"+new DecimalFormat("0.00").format((int)(balance*m_interest+1.0))+
										"\n"+"Do you want to use the minimum payment?",
										"Input Error",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION)
								{
									ptf.setText(new DecimalFormat("0.00").format((int)(balance*m_interest+1.0)));
									payment = Double.valueOf(ptf.getText()).doubleValue();
									
								}
								
							}
							else
							{
								ptf.requestFocus();
								return ;
							}
						}
						else
						{
							JOptionPane.showConfirmDialog(null, "Invalid or Empty Monthly Payment Entry.\n Please correct ","Payment Input Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
							return;
						}
						if(interest==0)
						{
							months = (int)(balance/payment);
						}
						else
						{	
							months = (int) ((Math.log(payment)-Math.log(payment-balance*m_interest))/Math.log(1+m_interest));
						}
						mtf.setText(String.valueOf(months));
					}
					payment = Double.valueOf(ptf.getText()).doubleValue();
					ta.setText("LOAN BALANCE : $"+new DecimalFormat("0.00").format(balance));
					ta.append("\nINTEREST RATE : "+new DecimalFormat("0.00").format(interest)+"%");
					
					l_bal = balance;
					for(int i=1;i<=months-1;i++)
					{
						l_bal += (l_bal*m_interest)-payment;
					}
					
					f_payment = l_bal;
					if(f_payment > payment)
					{
						l_bal += l_bal*m_interest - payment;
						f_payment = l_bal;
						months++;
						mtf.setText(String.valueOf(months));
					}
					ta.append("\n\n"+String.valueOf(months-1)+" PAYMENTS OF $" +new DecimalFormat("0.00").format(payment));
					ta.append("\n"+"FINAL PAYMENT : $"+new DecimalFormat("0.00").format(f_payment));
					ta.append("\n"+"TOTAL PAYMENTS :$"+new DecimalFormat("0.00").format((months-1)*payment+f_payment));
					ta.append("\n"+"INTEREST PAID :$"+new DecimalFormat("0.00").format((months-1)*payment+f_payment-balance));
					c_button.setEnabled(false);
					n_button.setEnabled(true);
					n_button.requestFocus();
				}	
				
				private void e_buttonActionPerformed(ActionEvent e)
				{
					System.exit(0);
				}
		});
		
		m1_button.setFocusable(false);		
		gbc.gridx=2;
		gbc.gridy=2;
		gbc.insets = new Insets(10,0,0,0);
		getContentPane().add(m1_button,gbc);
		m1_button.addActionListener(new ActionListener()		
		{
			public void ActionPerformed(ActionEvent e)
			{
				ActionPerformed(e);
			}

			@Override
			public void actionPerformed(ActionEvent e)
			{
				c_payment = true;
				n1_button.setVisible(false);
				m1_button.setVisible(true);
				mtf.setEditable(true);
				mtf.setBackground(Color.WHITE);
				mtf.setFocusable(true);
				ptf.setText("");
				ptf.setEditable(false);
				ptf.setBackground(lightYellow);
				ptf.setFocusable(false);
				btf.requestFocus();
				c_button.setText("COMPUTE MONTHLY PAYMENTS");
			}	
		});
		
		//n1_button.setFont(mfont);
		n1_button.setFocusable(false);
		gbc.gridx=2;
		gbc.gridy=3;
		gbc.insets = new Insets(10,0,0,0);
		getContentPane().add(n1_button,gbc);
		n1_button.addActionListener(new ActionListener()
		{
			public void ActionPerformed(ActionEvent e)
			{
				ActionPerformed(e);
			}

			@Override
			public void actionPerformed(ActionEvent e)
			{
				c_payment = false;
				n1_button.setVisible(true);
				m1_button.setVisible(false);
				mtf.setEditable(false);
				mtf.setBackground(lightYellow);
				mtf.setText("");
				mtf.setFocusable(false);
				ptf.setEditable(true);
				ptf.setBackground(Color.WHITE);
				ptf.setFocusable(true);
				btf.requestFocus();
				c_button.setText("COMPUTE NUMBER OF PAYMENTS");
			}
			
		});
		
		n_button.setEnabled(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(10, 0, 10, 0);
		getContentPane().add(n_button, gbc);
		n_button.addActionListener(new ActionListener()
		{
			 public void ActionPerformed(ActionEvent e) 
			 {
				 ActionPerformed(e);
			 }
		
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(c_payment)
				{
					ptf.setText(" ");
				}
				else
				{
					mtf.setText(" ");
				}	
				ta.setText(" ");
				c_button.setEnabled(true);
				n_button.setEnabled(false);
				btf.requestFocus();
			}
		});
		
		//Right Hand Side 
		l_label.setFont(mfont);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 4;
		gbc.gridy = 0;
		gbc.insets = new Insets(10,10,0,0);
		getContentPane().add(l_label,gbc);
		
		ta.setPreferredSize(new Dimension(250,150));
		ta.setBorder(BorderFactory.createLineBorder(Color.black));
		ta.setFont(new Font("Arial",Font.PLAIN,14));
		ta.setBackground(Color.WHITE);
		ta.setEditable(false);
		ta.setFocusable(false);
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 1;
		gbc.gridheight = 4;
		gbc.insets = new Insets(0,10,0,10);
		getContentPane().add(ta,gbc);
		
		gbc = new GridBagConstraints();
		gbc.gridx = 4;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.CENTER;
		e_button.setFocusable(false);
		getContentPane().add(e_button,gbc);
		
		e_button.addActionListener(new ActionListener() 
		{
			void actionPerformed()
			{
				System.exit(0);
			}

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				System.exit(0);
			}
		});	
		pack();
	}
}

