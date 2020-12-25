import harujisaku.gui.JCodePane;
import harujisaku.gui.highlight.*;

import javax.swing.JFrame;

public class JCodePaneTest extends JFrame {
	static JCodePane jcodePane = new JCodePane();
	static HighlightStyle h = new HighlightStyle();
	public JCodePaneTest(){
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("test");
		frame.setBounds(100, 100, 200, 160);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jcodePane.setHighlight(h);
		frame.add(jcodePane);
		frame.setVisible(true);
		jcodePane.highlight();
	}
}