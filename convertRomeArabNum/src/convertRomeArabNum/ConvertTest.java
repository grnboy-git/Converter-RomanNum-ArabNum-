package convertRomeArabNum;

import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Test;

public class ConvertTest {

	@Test //ローマ数字単体を数字に変換する処理のテスト
	public void testＭを入力して１０００が返ってくる() {
		Convert trconvertNumform = new Convert();
		int num = trconvertNumform.convertRomeToArab("M");
		assertEquals(1000, num);
	}
	@Test //ローマ数列をリストへ個別に格納するテスト
	public void testローマ数列を入力すると個別に格納されたリストが返ってくる() {
		Convert trconvertNumform = new Convert();
		ArrayList<String> splitString = trconvertNumform.makeRomeList("VI");
		assertEquals("V", splitString.get(0));
		assertEquals("I", splitString.get(1));
	}
	@Test //ローマ数列リストをアラビア数列リストへ変更するテスト
	public void testローマ数列リストを入力するとアラビア数列リストが返ってくる() {
		Convert trconvertNumform = new Convert();
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
//		System.out.println(convertNum);
		assertEquals("4", convertNum);
	}
	@Test //ローマ数列をアラビア数列へ変換する
	public void testローマ数列ＣＣＣＬＸＩＸを入力するとアラビア数列３６９が返ってくる() {
		Convert trconvertNumform = new Convert();
		String convertNum = trconvertNumform.convertNum("CCCLXIX");
		System.out.println(convertNum);
		assertEquals("369", convertNum);
	}
	@Test //アラビア数列をローマ数列へ変換する
	public void testアラビア数列４を入力するとアラビア数列ＩＶが返ってくる() {
		Convert trconvertNumform = new Convert();
		String convertNum = trconvertNumform.convertNum("4");
		System.out.println(convertNum);
		assertEquals("IV", convertNum);
	}
	@Test //アラビア数列をローマ数列へ変換する
	public void testアラビア数列７８４を入力するとアラビア数列ＤＣＣＬＸＸＸＩＶが返ってくる() {
		Convert trconvertNumform = new Convert();
		String convertNum = trconvertNumform.convertNum("784");
		System.out.println(convertNum);
		assertEquals("DCCLXXXIV", convertNum);
	}
	@Test //ローマ字の書式で同一種が４回以上連続で入力されているとエラーを返す
	public void testローマ数列ＩＩＩＩを入力するとエラーが返ってくる() {
		Convert trconvertNumform = new Convert();
		String e = trconvertNumform.convertNum("IIIII");
		System.out.println(e);
		assertEquals("ローマ数列の書式が不正です。単一の文字は3文字以内で構成しましょう。5の倍数を表す文字は2文字以上続けて表現できません。", e);
	}
	@Test //1と10の倍数を表す文字が２つ以上続いた後にその文字より大きい値を入力するで入力されているとエラーを返す
	public void testローマ数列ＩＩＶを入力するとエラーが返ってくる() {
		Convert trconvertNumform = new Convert();
		String e = trconvertNumform.convertNum("IIV");
		System.out.println(e);
		assertEquals("ローマ数列の書式が不正です。Error001", e);
	}
	@Test //ローマ数儀に変換可能なアラビア数字は１〜３９９９までとなっているかの確認テスト
	public void testアラビア数列のが０を入力したときエラーが返ってくる() {
		Convert trconvertNumform = new Convert();
		String e = trconvertNumform.convertNum("0");
		System.out.println(e);
		assertEquals("ローマ数字はアラビア数字の1〜3999までの範囲のみ処理可能です。", e);
	}
	@Test //ローマ数儀に変換可能なアラビア数字は１〜３９９９までとなっているかの確認テスト
	public void testアラビア数列の値が４０００を入力したときエラーが返ってくる() {
		Convert trconvertNumform = new Convert();
		String e = trconvertNumform.convertNum("4000");
		System.out.println(e);
		assertEquals("ローマ数字はアラビア数字の1〜3999までの範囲のみ処理可能です。", e);
	}
	@Test //ローマ字の書式で同一種が４回以上連続で入力されているとエラーを返す
	public void testローマ数列ＩＭを入力するとエラーが返ってくる() {
		Convert trconvertNumform = new Convert();
		String e = trconvertNumform.convertNum("IM");
		System.out.println(e);
		assertEquals("ローマ数列の書式が不正です。Error002", e);
	}
	@Test //ローマ字の書式で同一種が４回以上連続で入力されているとエラーを返す
	public void testローマ数列とアラビア数列の混合した文字列入力するとエラーが返ってくる() {
		Convert trconvertNumform = new Convert();
		String e = trconvertNumform.convertNum("IV2");
		System.out.println(e);
		assertEquals("入力した数列の書式が不正です。(HINT:ローマ数列は<IVXLCDM>で表現します)", e);
	}
	@Test //ローマ字の書式で同一種が４回以上連続で入力されているとエラーを返す
	public void testローマ数列とアラビ数列の混合した文字列入力するとエラーが返ってくる() {
		Convert trconvertNumform = new Convert();
		String e = trconvertNumform.convertNum("IV2");
		System.out.println(e);
		assertEquals("入力した数列の書式が不正です。(HINT:ローマ数列は<IVXLCDM>で表現します)", e);
	}

}
