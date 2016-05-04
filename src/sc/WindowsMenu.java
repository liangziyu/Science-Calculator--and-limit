package sc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;



public class WindowsMenu extends JFrame{
	JMenuBar menubar;               //�˵���
	JMenu    menu1,menu2,menu3,subMenu;          //�˵�
	JMenuItem item1,item2,item3;         // �˵���
	//JTextField text;
	JTextArea text;
	
	JPanel   panel;
	private final String[] KEYS = { "7", "8", "9", "/", "sqrt", "4", "5", "6",
			"*", "%", "1", "2", "3", "-", "1/x", "0", "+/-", ".", "+", "=" };
	/** �������ϵĹ��ܼ�����ʾ���� */
	private JButton keys[] = new JButton[KEYS.length];
	/** �������ϵĹ��ܼ��İ�ť */
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
		text = new JTextArea(6,12);  //�����ı���
		add(text,BorderLayout.NORTH);
		add(panel,BorderLayout.CENTER);//��������
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
	}

}
