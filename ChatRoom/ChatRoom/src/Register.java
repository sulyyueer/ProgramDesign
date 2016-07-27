import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

/**
 * Title:QICQ
 * 聊天系统用户注册程序 
 * Description:新用户通过输入相关信息注册成系统用户
 *
 * Copyright:Copyright(C)2015
 *
 * @author 吴浩男
 * @version 1.0
 */

public class Register extends JFrame implements ActionListener {
	private JComboBox comboBox;

	private static final long serialVersionUID = 9019746127517522180L;

	private JPanel pnlRegister;

	private JLabel lblNickName, lblUserName, lblGender, lblAge;

	private JLabel lblPassword, lblConfirmPass, lblEmail, logoPosition;

	private JTextField txtNickName, txtUserName, txtAge, txtEmail;

	private JPasswordField pwdUserPassword, pwdConfirmPass;

	private JRadioButton rbtnMale, rbtnFemale;

	private ButtonGroup btngGender;

	private JButton btnOk, btnCancel, btnClear;

	private String strServerIp;

	final JLabel headLabel = new JLabel();
	// 用于将窗口用于定位
	private Dimension scrnsize;
	private Toolkit toolkit = Toolkit.getDefaultToolkit();

	// 构造方法
	@SuppressWarnings(value={"unchecked", "rawtypes"})
	public Register(String ip) {
		super("[QICQ]聊天室注册窗口");
		strServerIp = ip;
		pnlRegister = new JPanel();
		this.getContentPane().add(pnlRegister);

		lblNickName = new JLabel("昵 称:");
		lblUserName = new JLabel("用 户 名:");
		lblGender = new JLabel("性    别:");
		lblAge = new JLabel("年    龄:");
		lblPassword = new JLabel("密    码:");
		lblConfirmPass = new JLabel("确认密码:");
		lblEmail = new JLabel("电子邮件:");
		txtNickName = new JTextField(30);
		txtUserName = new JTextField(30);
		txtEmail = new JTextField(30);
		txtAge = new JTextField(10);
		pwdUserPassword = new JPasswordField(30);
		pwdConfirmPass = new JPasswordField(30);
		rbtnMale = new JRadioButton("男", true);
		rbtnFemale = new JRadioButton("女");
		btngGender = new ButtonGroup();
		btnOk = new JButton("确定(O)");
		btnOk.setMnemonic('O');
		btnOk.setToolTipText("保存注册信息");
		btnCancel = new JButton("返回(B)");
		btnCancel.setMnemonic('B');
		btnCancel.setToolTipText("返回登录窗口");
		btnClear = new JButton("清空(L)");
		btnClear.setMnemonic('L');
		btnClear.setToolTipText("清空注册信息");

		/**
		 * 该布局采用手动布局 
		 * setBounds设置组件位置 
		 * setFont设置字体、字型、字号 　
		 * setForeground设置文字的颜色
		 * setBackground设置背景色 setOpaque将背景设置为透明
		 */
		pnlRegister.setLayout(null); // 组件用手动布局
		pnlRegister.setBackground(new Color(52, 130, 203));

		lblUserName.setBounds(210, 30, 100, 30);
		txtUserName.setBounds(290, 35, 120, 20);
		lblNickName.setBounds(210, 60, 100, 30);
		txtNickName.setBounds(210, 65, 100, 30);
		lblPassword.setBounds(210, 120, 100, 30);
		pwdUserPassword.setBounds(290, 106, 120, 20);
		lblConfirmPass.setBounds(210, 150, 100, 30);
		pwdConfirmPass.setBounds(290, 141, 120, 20);
		lblGender.setBounds(210, 171, 100, 30);
		rbtnMale.setBounds(290, 176, 60, 20);
		rbtnFemale.setBounds(370, 176, 60, 20);
		lblAge.setBounds(210, 206, 100, 30);
		txtAge.setBounds(290, 211, 120, 20);
		lblEmail.setBounds(210, 241, 100, 30);
		txtEmail.setBounds(290, 246, 120, 20);

		btnOk.setBounds(426, 116, 80, 25);
		btnCancel.setBounds(426, 161, 80, 25);
		btnClear.setBounds(426, 206, 80, 25);

		Font fontstr = new Font("宋体", Font.PLAIN, 12);
		lblUserName.setFont(fontstr);
		lblGender.setFont(fontstr);
		lblPassword.setFont(fontstr);
		lblConfirmPass.setFont(fontstr);
		lblAge.setFont(fontstr);
		lblEmail.setFont(fontstr);
		rbtnMale.setFont(fontstr);
		rbtnFemale.setFont(fontstr);
		txtUserName.setFont(fontstr);
		txtEmail.setFont(fontstr);
		btnOk.setFont(fontstr);
		btnCancel.setFont(fontstr);
		btnClear.setFont(fontstr);

		lblUserName.setForeground(Color.BLACK);
		lblGender.setForeground(Color.BLACK);
		lblPassword.setForeground(Color.BLACK);
		lblAge.setForeground(Color.BLACK);
		lblConfirmPass.setForeground(Color.BLACK);
		lblEmail.setForeground(Color.BLACK);
		rbtnMale.setForeground(Color.BLACK);
		rbtnFemale.setForeground(Color.BLACK);
		rbtnMale.setBackground(Color.white);
		rbtnFemale.setBackground(Color.white);
		btnOk.setBackground(Color.ORANGE);
		btnCancel.setBackground(Color.ORANGE);
		btnClear.setBackground(Color.ORANGE);
		rbtnMale.setOpaque(false);
		rbtnFemale.setOpaque(false);

		pnlRegister.add(lblUserName);
		pnlRegister.add(lblGender);
		pnlRegister.add(lblPassword);
		pnlRegister.add(lblConfirmPass);
		pnlRegister.add(lblEmail);
		pnlRegister.add(lblAge);
		pnlRegister.add(txtAge);
		pnlRegister.add(txtUserName);
		pnlRegister.add(txtEmail);
		pnlRegister.add(pwdUserPassword);
		pnlRegister.add(pwdConfirmPass);
		pnlRegister.add(btnOk);
		pnlRegister.add(btnCancel);
		pnlRegister.add(btnClear);
		pnlRegister.add(rbtnMale);
		pnlRegister.add(rbtnFemale);
		btngGender.add(rbtnMale);
		btngGender.add(rbtnFemale);

		// 设置背景图片
		Icon logo = new ImageIcon("resource/images/register_background.jpg");
		logoPosition = new JLabel(logo);
		logoPosition.setBounds(0, 0, 180, 314);
		pnlRegister.add(logoPosition);

		this.setSize(550, 350);
		this.setVisible(true);
		this.setResizable(false);
		// 将窗口定位在屏幕中央
		scrnsize = toolkit.getScreenSize();
		this.setLocation(scrnsize.width / 2 - this.getWidth() / 2,
				scrnsize.height / 2 - this.getHeight() / 2);
		Image img = toolkit.getImage("resource/images/appico.jpg");
		this.setIconImage(img);
		// 三个按钮注册监听
		btnOk.addActionListener(this);
		btnCancel.addActionListener(this);
		btnClear.addActionListener(this);

		final JLabel label = new JLabel();
		label.setText("头    像:");
		label.setBounds(210, 90, 60, 15);
		pnlRegister.add(label);

		comboBox = new JComboBox();
		comboBox.setAutoscrolls(true);
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3" }));
		comboBox.setBounds(290, 71, 47, 23);
		comboBox.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent arg0) {
				Icon logo = new ImageIcon("resource/face/"
						+ comboBox.getSelectedItem().toString() + ".jpg");
				// TODO 自动生成方法存根
				headLabel.setIcon(logo);
			}
		});
		pnlRegister.add(comboBox);

		headLabel.setHorizontalAlignment(SwingConstants.CENTER);
		// .setIcon(SwingResourceManager.getIcon(Register.class, "face/1.jpg"));
		headLabel.setIcon(new ImageIcon("resource/face/1.JPG"));
		headLabel.setBounds(427, 43, 74, 72);
		pnlRegister.add(headLabel);
	} // 构造方法结束

	// 按钮监听响应
	public void actionPerformed(ActionEvent ae) {
		Object source = new Object();
		source = ae.getSource();
		if (source.equals(btnOk)) { // "确定"按钮
			register();
		}
		if (source.equals(btnCancel)) { // "返回"按钮
			new Login();
			this.dispose();
		}
		if (source.equals(btnClear)) { // "清空"按钮
			txtUserName.setText("");
			pwdUserPassword.setText("");
			pwdConfirmPass.setText("");
			txtAge.setText("");
			txtEmail.setText("");
		}
	} // actionPerformed()结束

	// "确定"按钮事件响应
	@SuppressWarnings({ "deprecation", "static-access", "resource" })
	public void register() {
		// 接受客户的详细资料
		Register_Customer data = new Register_Customer();
		data.custName = txtUserName.getText();
		data.custPassword = pwdUserPassword.getText();
		data.age = txtAge.getText();
		data.sex = rbtnMale.isSelected() ? "男" : "女";
		data.email = txtEmail.getText();
		data.head = comboBox.getSelectedItem().toString();
		// 验证用户名是否为空
		if (data.custName.length() == 0) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		// 验证密码是否为空
		if (data.custPassword.length() == 0) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}

		// 验证密码的一致性
		if (!data.custPassword.equals(pwdConfirmPass.getText())) {
			JOptionPane.showMessageDialog(null, "密码两次输入不一致，请重新输入");
			return;
		}

		// 验证年龄是否为空
		if (data.age.length() == 0) {
			JOptionPane.showMessageDialog(null, "年龄不能为空");
			return;
		}
		// 验证年龄的合法性
		int age = Integer.parseInt(txtAge.getText());
		if (age <= 0 || age > 100) {
			JOptionPane.showMessageDialog(null, "年龄输入不合法");
			return;
		}
		// 验证Email的正确性
		int Found_flag = 0; // 判断标志
		for (int i = 0; i < data.email.length(); i++) {
			if (data.email.charAt(i) == '@') {
				Found_flag++;
			}
		}
		if (Found_flag != 1) {
			JOptionPane.showMessageDialog(null, "电子邮箱格式不正确，请重新输入");
			return;
		}

		try {
			// 连接到服务器
			Socket toServer;
			toServer = new Socket(strServerIp, 1080);
			ObjectOutputStream streamToServer = new ObjectOutputStream(
					toServer.getOutputStream());
			// 写客户详细资料到服务器socket
			streamToServer.writeObject((Register_Customer) data);
			// 读来自服务器socket的登陆状态
			BufferedReader fromServer = new BufferedReader(
					new InputStreamReader(toServer.getInputStream()));
			String status = fromServer.readLine();
			// 显示成功消息
			JOptionPane op = new JOptionPane();
			op.showMessageDialog(null, status);
			if (status.equals(data.custName + "注册成功")) {
				txtUserName.setText("");
				pwdUserPassword.setText("");
				pwdConfirmPass.setText("");
				txtAge.setText("");
				txtEmail.setText("");
			}

			// 关闭流对象
			streamToServer.close();
			fromServer.close();
		} catch (InvalidClassException e1) {
			JOptionPane.showMessageDialog(null, "类错误!");
		} catch (NotSerializableException e2) {
			JOptionPane.showMessageDialog(null, "对象未序列化!");
		} catch (IOException e3) {
			JOptionPane.showMessageDialog(null, "不能写入到指定服务器!");
		}

	} // 方法register()结束

	public static void main(String args[]) {
		new Register("127.0.0.1");
	}

} // class Register 结束
