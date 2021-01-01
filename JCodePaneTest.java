import harujisaku.gui.JCodePane;
import harujisaku.gui.highlight.*;
import harujisaku.gui.autocomplete.*;

import javax.swing.JFrame;

public class JCodePaneTest extends JFrame {
	static JCodePane jcodePane = new JCodePane();
	static AutoComplete autoComplete;
	// static HighlightStyle h = new HighlightStyle();
	public JCodePaneTest(){
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("test");
		DefaultAutoComplete defaultAutoComplete = new DefaultAutoComplete();
		DefaultAutoCompletePanel autoCompletePane = new DefaultAutoCompletePanel();
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