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
	JMenuBar menubar;               //菜单条
	JMenu    menu1,menu2,menu3,subMenu;          //菜单
	JMenuItem item1,item2,item3;         // 菜单项
	//JTextField text;
	JTextArea text;
	
	JPanel   panel;
	private final String[] KEYS = { "7", "8", "9", "/", "sqrt", "4", "5", "6",
			"*", "%", "1", "2", "3", "-", "1/x", "0", "+/-", ".", "+", "=" };
	/** 计算器上的功能键的显示名字 */
	private JButton keys[] = new JButton[KEYS.length];
	/** 计算器上的功能键的按钮 */
	public WindowsMenu(String s,int x,int y,int w,int h){
		init(s);//初始化方法
		setLocation(x,y);
		setSize(w,h);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	void init(String s){
		setTitle(s);
		//setLayout(new FlowLayout()); //居中布局
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,5,3,3));  //设置功能键
		for (int i = 0; i < KEYS.length; i++) {
			keys[i] = new JButton(KEYS[i]);
			panel.add(keys[i]);
			keys[i].setForeground(Color.blue);
		}
		text = new JTextArea(6,12);  //输入文本框
		add(text,BorderLayout.NORTH);
		add(panel,BorderLayout.CENTER);//布局设置
		menubar = new JMenuBar();
		menu1 = new JMenu("查看（V）");
		menu2 = new JMenu("编辑（E）");
		menu3 = new JMenu("帮助（H）");
		item1 = new JMenuItem("科学型");
		item2 = new JMenuItem("查看帮助");
		item3 = new JMenuItem("标准型");
		item1.setAccelerator(KeyStroke.getKeyStroke('a'));
		//item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,InputEvent.CTRL_MASK));//ctrl+1快捷键
		item2.setAccelerator(KeyStroke.getKeyStroke("F1"));
		item3.setAccelerator(KeyStroke.getKeyStroke('q'));
		menu1.setMnemonic('V');//设置快捷键alt+V
		menu2.setMnemonic('E');
		menu3.setMnemonic('H');
		menu1.add(item1);
		menu1.addSeparator();//分隔符行
		menu1.add(item3);
		menu3.add(item2);
		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
		setJMenuBar(menubar);
	}

}
