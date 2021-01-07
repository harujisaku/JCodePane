package harujisaku.gui;

import javax.swing.text.StyledDocument;
import javax.swing.text.DefaultEditorKit;
import javax.swing.JTextPane;

import harujisaku.gui.highlight.*;
import harujisaku.gui.autocomplete.*;

public class JCodePane extends JTextPane{
	
	HighlightStyle style;
	AutoComplete autoComplete;
	/**
	 * デフォルトコンストラクタ
	 */
	public JCodePane(){
		super();
		init();
	}
	/**
	 * StyledDocumentを指定したJCodePaneを作ります。
	 * @param doc 設定するStyledDocument
	 */
	public JCodePane(StyledDocument doc){
		super(doc);
		init();
	}
	/**
	 * シンタックスハイライトを設定します。
	 * @param style 設定するHighlightStyle
	 */
	public void setHighlight(HighlightStyle style){
		this.style=style;
	}
	/**
	 * 自動補完を設定します。
	 * @param autoComplete 設定する自動補完
	 */
	public void setAutoComplete(AutoComplete autoComplete){
		this.autoComplete=autoComplete;
		addKeyListener(autoComplete);
	}
	/**
	 * 設定されたシンタックスハイライトを反映します。
	 */
	public void highlight(){
		HighlightSet[] highlightSets = style.getHighLightSet();
		for (HighlightSet highlightSet :highlightSets ) {
			getStyledDocument().setCharacterAttributes(highlightSet.start,highlightSet.end-highlightSet.start,highlightSet.aset,true);
		}
	}
	
 	private void init(){
		getDocument().putProperty(DefaultEditorKit.EndOfLineStringProperty,"\n");
	}
}