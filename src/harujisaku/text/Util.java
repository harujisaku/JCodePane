package harujisaku.text;
/**
 * テキスト操作に関するクラスです。
 */
public class Util {
	private String text;
	/**
	 * デフォルトコンストラクタ.
	 * @param text 操作するテキスト
	 */
	public Util(String text){
		this.text=text;
	}
	/**
	 * 操作するテキストを設定します.
	 * @method setText
	 * @param  text   設定するテキスト
	 */
	public void setText(String text){
		this.text=text;
	}
	/**
	 * 設定しているテキストを取得します.
	 * @method getText
	 * @return 設定されているテキスト
	 */
	public String getText(){
		return text;
	}
	/**
	 * 単語の始点を返します.
	 * @param  index 検索を開始するindex
	 * @return       単語の始点のindex
	 */
	public int indexOfWordFirst(int index){
		int i=index;
		while(Character.isLetterOrDigit(text.charAt(i))){
			i--;
		}
		return i;
	}
	/**
	 * 単語の始点を返します.
	 * @param  text  検索するテキスト
	 * @param  index 検索を開始するテキスト
	 * @return       単語の始点のindex
	 */
	public static int indexOfWordFirst(String text,int index){
		int i=index;
		while(Character.isLetterOrDigit(text.charAt(i))){
			i--;
		}
		return i;
	}
}