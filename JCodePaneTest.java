import harujisaku.gui.JCodePane;
import harujisaku.gui.highlight.*;
import harujisaku.gui.autocomplete.*;

import javax.swing.JFrame;

public class JCodePaneTest extends JFrame {
	JCodePane jcodePane = new JCodePane();
	AutoComplete autoComplete;
	List<String> list = new List<String>();
	// static HighlightStyle h = new HighlightStyle();
	public JCodePaneTest(){
		
	}
	
	public static void main(String[] args) {
		new JCodePaneTest().myMain();
	}
	
	public void myMain(){
		JFrame frame = new JFrame("test");
		list.add("public");
		DefaultAutoComplete defaultAutoComplete = new DefaultAutoComplete(new SuggestString(list));
		DefaultAutoCompletePanel autoCompletePane = new DefaultAutoCompletePanel(jcodePane);
		autoComplete = new AutoComplete(defaultAutoComplete,autoCompletePane);
		frame.setBounds(100, 100, 200, 160);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// jcodePane.setHighlight(h);
		jcodePane.setAutoComplete(autoComplete);
		frame.add(jcodePane);
		frame.setVisible(true);
		jcodePane.highlight();
	}
}