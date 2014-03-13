package convertRomeArabNum;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ConvertTest {
	Convert trconvertNumform;
	@Before
	public void before(){
		trconvertNumform = new Convert();
	}
	@Test //ローマ数字単体を数字に変換する処理のテスト
	public void testＭを入力して１０００が返ってくる() {		
		int num = trconvertNumform.convertRomeToArab("M");
		assertEquals(1000, num);
	}
	@Test //ローマ数列をリストへ個別に格納するテスト
	public void testローマ数列を入力すると個別に格納されたリストが返ってくる() {
		ArrayList<String> splitString = trconvertNumform.makeRomeList("VI");
		assertEquals("V", splitString.get(0));
		assertEquals("I", splitString.get(1));
	}
	@Test //ローマ数列リストをアラビア数列リストへ変更するテスト
	public void testローマ数列リストを入力するとアラビア数列リストが返ってくる() {
		ArrayList<String> testRome = new ArrayList<String>();
		testRome.add("V");
		testRome.add("I");
		ArrayList<Integer> splitString = trconvertNumform.makeArabList(testRome);
		assertEquals("5", String.valueOf(splitString.get(0)));
		assertEquals("1", String.valueOf(splitString.get(1)));
	}
	@Test //ローマ数列をアラビア数列へ変換する
	public void testローマ数列を入力するとアラビア数列が返ってくる() {
		Convert trconvertNumform = new Convert();
		String convertNum = trconvertNumform.convertNum("IV");
		assertEquals("4", convertNum);
	}
	@Test //ローマ数列をアラビア数列へ変換する
	public void testローマ数列ＣＣＣＬＸＩＸを入力するとアラビア数列３６９が返ってくる() {
		String convertNum = trconvertNumform.convertNum("CCCLXIX");
		assertEquals("369", convertNum);
	}
	@Test //アラビア数列をローマ数列へ変換する
	public void testアラビア数列４を入力するとアラビア数列ＩＶが返ってくる() {
		String convertNum = trconvertNumform.convertNum("4");
		assertEquals("IV", convertNum);
	}
	@Test //アラビア数列をローマ数列へ変換する
	public void testアラビア数列７８４を入力するとアラビア数列ＤＣＣＬＸＸＸＩＶが返ってくる() {
		String convertNum = trconvertNumform.convertNum("784");
		assertEquals("DCCLXXXIV", convertNum);
	}
	@Test //アラビア数列をローマ数列へ変換する
	public void testアラビア数列を入力するとアラビア数列ＤＣＣＬＸＸＸＩＶが返ってくる() {
		String convertNum = trconvertNumform.convertNum("XIX");
		assertEquals("19", convertNum);
	}
	@Test(expected = RuntimeException.class) //ローマ字の書式で同一種が４回以上連続で入力されているとエラーを返す
	public void testローマ数列ＩＩＩＩを入力するとエラーが返ってくる() {
		trconvertNumform.convertNum("IIIII");
	}
	@Test(expected = RuntimeException.class) //1と10の倍数を表す文字が２つ以上続いた後にその文字より大きい値を入力するで入力されているとエラーを返す
	public void testローマ数列ＩＩＶを入力するとエラーが返ってくる() {
		trconvertNumform.convertNum("IIV");
	}
	@Test(expected = RuntimeException.class) //ローマ数列に変換可能なアラビア数字は１〜３９９９までとなっているかの確認テスト
	public void testアラビア数列のが０を入力したときエラーが返ってくる() {
		trconvertNumform.convertNum("0");
	}
	@Test(expected = RuntimeException.class) //ローマ数列に変換可能なアラビア数字は１〜３９９９までとなっているかの確認テスト
	public void testアラビア数列の値が４０００を入力したときエラーが返ってくる() {
		trconvertNumform.convertNum("4000");
	}
	@Test(expected = RuntimeException.class) //ローマ数列の書式で同一種が４回以上連続で入力されているとエラーを返す
	public void testローマ数列ＩＭを入力するとエラーが返ってくる() {
		trconvertNumform.convertNum("IM");
	}
	@Test(expected = RuntimeException.class) //ローマ字の書式で同一種が４回以上連続で入力されているとエラーを返す
	public void testローマ数列とアラビア数列の混合した文字列入力するとエラーが返ってくる() {
		trconvertNumform.convertNum("IV2");
	}
	@Test(expected = RuntimeException.class) //ローマ数列の書式で同一種が４回以上連続で入力されているとエラーを返す
	public void testローマ数列とアラビ数列の混合した文字列入力するとエラーが返ってくる() {
		trconvertNumform.convertNum("MCMD");
	}
	@Test(expected = RuntimeException.class) //ローマ数列の書式で同一種が４回以上連続で入力されているとエラーを返す
	public void testローマ列とアラビ数列の混合した文字列入力するとエラーが返ってくる() {
		trconvertNumform.convertNum("IXX");
	}

}
