package sc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;



public class WindowsMenu extends JFrame implements ActionListener{
	JMenuBar menubar;               //�˵���
	JMenu    menu1,menu2,menu3,subMenu;          //�˵�
	JMenuItem item1,item2,item3;         // �˵���
	//JTextField text;
	JTextField text;
	
	JPanel   panel,commandspanel;
	private final String[] KEYS = { "7", "8", "9", "/", "sqrt", "4", "5", "6",
			"*", "%", "1", "2", "3", "-", "1/x", "0", "+/-", ".", "+", "=" };
	/** �������ϵĹ��ܼ�����ʾ���� */
	private JButton keys[] = new JButton[KEYS.length];
	/** �������ϵĹ��ܼ��İ�ť */
	private final String[] COMMAND = { "Backspace", "CE", "C" };
	/** �������ϼ��İ�ť */
	private JButton commands[] = new JButton[COMMAND.length];
	/** ��������ߵ�M�İ�ť */
	
	private boolean firstDigit = true;
	// ��־�û������Ƿ����������ʽ�ĵ�һ������,�������������ĵ�һ������

	private double resultNum = 0.0;
	// ������м�����
	
	private String operator = "=";
	// ��ǰ����������
	
	private boolean operateValidFlag = true;
	// �����Ƿ�Ϸ�
	public WindowsMenu(String s,int x,int y,int w,int h){
		init(s);//��ʼ������
		setLocation(x,y);
		setSize(w,h);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	void init(String s){
		setTitle(s);
		//setLayout(new FlowLayout()); //���в���
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,5,3,3));  //���ù��ܼ�
		for (int i = 0; i < KEYS.length; i++) {
			keys[i] = new JButton(KEYS[i]);
			panel.add(keys[i]);
			keys[i].setForeground(Color.blue);
		}
		commandspanel = new JPanel();
		commandspanel.setLayout(new GridLayout(1,3,3,3));
		
		for(int i=0;i<COMMAND.length;i++){         //����command����
			commands[i] = new JButton(COMMAND[i]);
			commandspanel.add(commands[i]);
			commands[i].setForeground(Color.red);
			
		}
		 text = new JTextField();   //�����ı���
		/**
		 *  JScrollPane scl =new JScrollPane(text);
		 *   this.add(scl);
		 */
	       
		 text.setHorizontalAlignment(JTextField.RIGHT); //�Ҷ���
		 
		 text.setEditable(false); //��ֹ�޸�
	    
	
		// ������������һ���������ı���һ����commands�Ͱ�ť��һ�����廭����ǰ����������
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		panel1.add(text,BorderLayout.CENTER);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout(3,3));
		panel2.add(commandspanel,BorderLayout.NORTH);
		panel2.add(panel, BorderLayout.CENTER);
		
		//���岼��
		
		getContentPane().setLayout(new BorderLayout(3,5));
		getContentPane().add("North",panel1);
		getContentPane().add("Center",panel2);
		
		//�˵�����
		menubar = new JMenuBar();
		menu1 = new JMenu("�鿴��V��");
		menu2 = new JMenu("�༭��E��");
		menu3 = new JMenu("������H��");
		item1 = new JMenuItem("��ѧ��");
		item2 = new JMenuItem("�鿴����");
		item3 = new JMenuItem("��׼��");
		item1.setAccelerator(KeyStroke.getKeyStroke('a'));
		//item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,InputEvent.CTRL_MASK));//ctrl+1��ݼ�
		item2.setAccelerator(KeyStroke.getKeyStroke("F1"));
		item3.setAccelerator(KeyStroke.getKeyStroke('q'));
		menu1.setMnemonic('V');//���ÿ�ݼ�alt+V
		menu2.setMnemonic('E');
		menu3.setMnemonic('H');
		menu1.add(item1);
		menu1.addSeparator();//�ָ�����
		menu1.add(item3);
		menu3.add(item2);
		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
		setJMenuBar(menubar);
		// ���ü���
		
		for (int i = 0; i < KEYS.length; i++) {
			keys[i].addActionListener(this);
		}
		for(int i=0;i<COMMAND.length;i++){
			commands[i].addActionListener(this);
		}
	}

	//�����˸񰴼�
	private void handleBackspace(){
		
		String t = text.getText();
		int i=t.length();
		if(i>0){
			
         t = t.substring(0, i - 1);
     	     // �˸񣬽��ı����һ���ַ�ȥ��
		}
		else if(i==0){
			text.setText("0"); // û�����ݣ���ʼ��
			firstDigit = true;
			operator = "=";
			
		}
		else{
			text.setText(t);
		}
		
	}
	@Override
	/**
	 * �¼�������
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		String u = e.getActionCommand();
		if(u.equals(COMMAND[0])){
			 handleBackspace(); // �û�����"Backspace"��
		}
	}
	private double getNumberFromText() {
		double result = 0;
		try {
			result = Double.valueOf(text.getText()).doubleValue();
		} catch (NumberFormatException e) {
		}
		return result;
	}
}
