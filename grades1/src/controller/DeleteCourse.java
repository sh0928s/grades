package controller;

import java.awt.AWTEvent;
import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class DeleteCourse extends JFrame implements ActionListener{
	/*管理员删除课程*/
	JPanel contain;
	JLabel id;
	JTextField idt;
	JButton submit;
	
	String file = new File(System.getProperty("user.dir")).getParent()+"/data/";
	
	public DeleteCourse() {
		super("删除课程");
		setSize(300,400);
		setLocation(600,400);
		contain=new JPanel();
		contain.setLayout(null);
		id=new JLabel("课程号");
		submit=new JButton("提交");
		idt=new JTextField();
		id.setBounds(42, 45, 75, 35);
		idt.setBounds(80, 45, 150, 35);
		submit.setBounds(102, 100, 70, 30);
		contain.add(id);
		contain.add(idt);
		contain.add(submit);
		submit.addActionListener(this);
		add(contain);
		setVisible(true);
		enableEvents(AWTEvent.WINDOW_EVENT_MASK);
	}

	public int isCourse(String table,String id) {
		 File file =new File( System.getProperty("user.dir"));
		   String file1=file.getParent()+ "/data".concat("/").concat(table).concat(".txt");
		   try {
			      BufferedReader br = new BufferedReader(new FileReader(file1));// 构造一个BufferedReader类来读取文件
			      String s = null;
			      while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
			        String[] result = s.split(" ");
			        if (result[0].equals(id)) {
			          br.close();
			          return 1;// 判断登录信息是否正确
			        }
			      }
			      br.close();
			    }
			    catch (Exception e) {
			      e.printStackTrace();
			    }

			    return 0;
			  }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(isCourse("course",idt.getText())==1) {
		if(e.getSource()==submit) {
			file=file+"course.txt";
			ArrayList<String> modifiedContent = new ArrayList<String>();
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String s=null;
				while((s=br.readLine())!=null) {
					String[] result=s.split(" ");
					if(result[0].equals(idt.getText())) {
						continue;
					}
					String s1 = "";
					for (int i = 0; i < result.length - 1; i++) {
						s1 = s1 + result[i];
						s1 = s1 + " ";
					}
					s1 = s1 + result[result.length - 1];
					// System.out.println(s1);
					modifiedContent.add(s1);
				
 				}
				br.close();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			

			try {
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);

				for (int i = 0; i < modifiedContent.size(); i++) {
					bw.write(modifiedContent.get(i));
					bw.newLine();
				}

				bw.close();
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(null, "删除课程成功", "提示", JOptionPane.INFORMATION_MESSAGE);
		} }
		else {
			JOptionPane.showMessageDialog(null, "此课程不存在！", "提示", JOptionPane.INFORMATION_MESSAGE);
		}
		
		}
	
}


