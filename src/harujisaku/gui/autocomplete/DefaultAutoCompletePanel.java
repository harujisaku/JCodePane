package harujisaku.gui.autocomplete;

import javax.swing.text.JTextComponent;

/**
 * デフォルトの自動補完文字列を表示するパネル
 */

public class DefaultAutoCompletePanel extends AutoCompletePanel {
	/**
	 * デフォルトコンストラクタ
	 * @param textCom 自動補完文字列を表示するJTextComponent
	 */
	public DefaultAutoCompletePanel(JTextComponent textCom){
		super(textCom);
	}
}