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
		return indexOfWordFirst(text,index);
	}
	/**
	 * 単語の始点を返します.
	 * @param  text  検索するテキスト
	 * @param  index 検索を開始するテキスト
	 * @return       単語の始点のindex
	 */
	public static int indexOfWordFirst(String text,int index){
		if (index<=0) {
			return 0;
		}else if(Character.isLetterOrDigit(text.charAt(index))){
			return index;
		}
		int i=index;
		while(Character.isLetterOrDigit(text.charAt(i))){
			i--;
			if (i<=0) {
				return 0;
			}
		}
		return i+1;
	}
	
	public int indexOfWordEnd(int index){
		return indexOfWordEnd(text,index);
	}
	
	public static int indexOfWordEnd(String text, int index){
		if (index<=0) {
			return 0;
		}else if (index>=text.length()) {
			return text.length();
		}else if(Character.isLetterOrDigit(text.charAt(index))){
			return index;
		}
		int i=index;
		while(Character.isLetterOrDigit(text.charAt(i))) {
			i++;
			if (i>=text.length()) {
				return text.length();
			}
		}
		return i;
	}
	
	public String getWord(int position){
		return getWord(text,position);
	}
	
	public static String getWord(String text,int index){
		if (index<0) {
			return "";
		}
		char word;
		StringBuffer br = new StringBuffer();
		while (!Character.isWhitespace(word=text.charAt(index))) {
			index--;
			br.append(word);
			if (index<0) {
				br.reverse();
				return br.toString();
			}
		}
		br.reverse();
		return br.toString();
	}
}