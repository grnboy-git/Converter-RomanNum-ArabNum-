package convertRomeArabNum;

import java.util.ArrayList;

public class Convert {
	String errorMessage = "";
//	ローマ数列をアラビア数列に変換するメインメソッド
	public String convertNum(String romeNum){
//		入力された数列の判別チェック
		boolean result = checkStr(romeNum);
		String ans = "";
		if (result && errorMessage.equals("")){ //ローマ数列→アラビア数列
//			ローマ数列の整合性チェック
			if (!checkRome(romeNum)){
				System.out.println(errorMessage);
				return errorMessage;
			}
//			ローマ数列をリストに格納
			ArrayList<String> strList = makeRomeList(romeNum);
//			ローマ数列リストをアラビア数列リストへ変換
			ArrayList<Integer> numList = makeArabList(strList);
//			アラビア数列を処理して解を出力する
			ans = String.valueOf(sumTotal(numList));
			return ans;
		}else if(!result && errorMessage.equals("")){ //アラビア数列→ローマ数列
//			アラビア数列の整合性チェック
			int num = Integer.parseInt(romeNum);
			checkArab(num);
			if (!checkArab(num)){
				return errorMessage;
			}
//			アラビア数列をリストに格納
			ArrayList<Integer> numList = makeArabList(num);
//			アラビア数列リストをローマ数列リストへ変換
			ArrayList<String> romeList = makeRomeList(numList);
//			ローマ数列を処理して解を出力する
			ans = String.valueOf(ConnectRomeNumList(romeList));
			return ans;
		}else{
			return errorMessage = "入力した数列の書式が不正です。(HINT:ローマ数列は<IVXLCDM>で表現します)";
		}
	}

///////////////////////////////////////////////////////////////////
//ローマ数字からアラビア数字への変換処理
///////////////////////////////////////////////////////////////////

//	ローマ数列を一文字ごとに分離
	public ArrayList<String> makeRomeList(String romeNum){
		ArrayList<String> strList = new ArrayList<String>();
		for (int i = 0; i <= romeNum.length() - 1; i++){
			strList.add(String.valueOf(romeNum.charAt(i)));
		}
		return strList;
	}
	
//	ローマ数列リストをアラビア数列リストへ変換
	public ArrayList<Integer> makeArabList(ArrayList<String> strList){
		ArrayList<Integer> numList = new ArrayList<Integer>();
		for (int i = 0; i <= strList.size()-1; i++){
			int s = convertRomeToArab(strList.get(i));
			numList.add(s);
		}
		return numList;
	}

	
//	文字を数字に変換	
	public int convertRomeToArab(String romeNum){
		int num = 0; //ローマ数字を数字に当てはめる時の格納先
		switch(romeNum){
	        case "I": return num = 1;
	        case "V": return num = 5;
	        case "X": return num = 10;
	        case "L": return num = 50;
	        case "C": return num = 100;
	        case "D": return num = 500;
	        case "M": return num = 1000;
	        default:
	            System.out.println("そのローマ数字処理できない！");
		}
		return num;
	}

	
//	変換された個別の数値を足す（または引く）処理
	public int sumTotal(ArrayList<Integer> numList){
		int totalNum = 0;
		totalNum = numList.get(0);
		
		for (int i=1; i <= numList.size()-1; i++){
			if (numList.get(i) < numList.get(i-1)){ //前の数より小さかったら足す
				totalNum = totalNum + numList.get(i);
			}else if (numList.get(i).equals(numList.get(i-1))){ //前の数と同じときは足す
				totalNum = totalNum + numList.get(i);
			}else if (numList.get(i) > numList.get(i-1)){ //前の数より大きかったら引く
				totalNum = totalNum + numList.get(i) - numList.get(i-1) * 2;
			}
		}
		return totalNum;
	}
	
///////////////////////////////////////////////////////////////////
// アラビア数字からローマ数字への変換処理
///////////////////////////////////////////////////////////////////

//	アラビア数列を桁ごとにリストへ入れる処理
	public ArrayList<Integer> makeArabList(int arabNum){
		ArrayList<Integer> numList = new ArrayList<Integer>();
		String strNum = String.valueOf(arabNum);
		for (int i = 0; i <= strNum.length() - 1; i++){
			numList.add(Integer.parseInt("" + strNum.charAt(i)));
		}
		return numList;
	}
	
//	桁数ごとに処理を切り替えるて数値へ変換した値をリストで返す処理
	public ArrayList<String> makeRomeList(ArrayList<Integer> numList){
//		何桁か調べる
		int digits = numList.size();
		ArrayList<String> romeList = new ArrayList<String>();
		for (int i=0; i <= numList.size()-1; i++){
			romeList.add(convertArabToRome(numList.get(i), digits-i));
		}
		return romeList;
	}
	
//	アラビア→ローマ変換
	public String convertArabToRome(int arabNum, int digits){
		String romeNum = "";
		String[][] digitsMatrix = {
				{"I","X","C","M"},
				{"II","XX","CC","MM"},
				{"III","XXX","CCC","MMM"},
				{"IV","XL","CD"},
				{"V","L","D"},
				{"VI","LX","DC"},
				{"VII","LXX","DCC"},
				{"VIII","LXXX","DCCC"},
				{"IX","XC","CM"}
				};
		for (int j=1; j<=9; j++){
			if (arabNum == j){romeNum = digitsMatrix[j-1][digits-1];}
		}
		return romeNum;
	}
	
//	リストを一つの文字列にまとめる処理
	public String ConnectRomeNumList(ArrayList<String> romeNum){
		String ans = "";
		for (int i=0; i <= romeNum.size()-1; i++){
			ans = ans + romeNum.get(i);
		}
		return ans;
	}
	
///////////////////////////////////////////////////////////////////
// 入力された文字列の書式チェック
///////////////////////////////////////////////////////////////////
	
	
	
//	入力された数列がローマかアラビアか判定する（trueがローマ、falseがアラビア)
	public boolean checkStr(String romeNum){
		boolean checkStr = false;
		boolean checkNum = false;
		checkStr = romeNum.matches("^[IVXLCDM]+$");
		checkNum = romeNum.matches("^[0-9]+$");
		if (checkStr && !checkNum){
			System.out.println("この数列はローマ数列です。");
			checkStr = true;
		}else if(checkNum && !checkStr){
			System.out.println("この数列はアラビア数列です。");
		}else{
			System.out.println("処理が続行できません。");
			errorMessage = "この数列はアラビア数列、ローマ数列の判別ができません。もう一度入力した内容を見直しましょう。";
		}
		return checkStr;
	}
//	ローマ数列書式チェック
	public boolean checkRome(String romeNum){
		boolean result = true;
		if (romeNum.matches("[I]{4,}$|[V]{2,}$|[X]{4,}$|[L]{2,}$|[C]{4,}$|[D]{2,}$|[M]{4,}$")){
			errorMessage = "ローマ数列の書式が不正です。単一の文字は3文字以内で構成しましょう。5の倍数を表す文字は2文字以上続けて表現できません。";
			System.out.println(errorMessage);
			return result = false;
		}else if (romeNum.matches("I{2,}[VXLCDM]$|X{2,}[LCDM]$|C{2,}[DM]$")){
			errorMessage = "ローマ数列の書式が不正です。Error001";
			return result = false;
		}else if (romeNum.matches("I[LCDM]|V[LCDM]|X[DM]|L[DM]|DM")){
			errorMessage = "ローマ数列の書式が不正です。Error002";
			return result = false;
		}
		return result;
	}
//　アラビア数列書式チェック;
	public boolean checkArab(int arabNum){
		boolean result = true;
		if (arabNum < 1 || 3999 < arabNum){
			errorMessage = "ローマ数字はアラビア数字の1〜3999までの範囲のみ処理可能です。";
			return result = false;
		}
		return result;
	}
}
