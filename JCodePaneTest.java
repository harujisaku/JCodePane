import harujisaku.gui.JCodePane;
import harujisaku.gui.highlight.*;
import harujisaku.gui.autocomplete.*;
import harujisaku.text.*;

import java.util.*;

import javax.swing.JFrame;

public class JCodePaneTest extends JFrame {
	JCodePane jcodePane = new JCodePane();
	AutoComplete autoComplete;
	List<String> list = new ArrayList<String>();
	// static HighlightStyle h = new HighlightStyle();
	public JCodePaneTest(){
		
	}
	
	public static void main(String[] args) {
		new JCodePaneTest().myMain();
	}
	
	public void myMain(){
		JFrame frame = new JFrame("test");
		list.add("public");
		list.add("private");
		list.add("print");
		list.add("println");
		list.add("index");
		DefaultAutoComplete defaultAutoComplete = new DefaultAutoComplete(new SuggestString(list),jcodePane);
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