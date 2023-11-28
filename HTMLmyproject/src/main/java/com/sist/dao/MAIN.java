package com.sist.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MAIN {
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		ProductDAO dao =new ProductDAO();
		List<ProductVO> list=new ArrayList();
		System.out.print("검색어 입력:");
		String str = scan.next();
	list=dao.searchProduct(str);
		for (ProductVO productVO : list) {
			System.out.println("상품이름:"+productVO.getProduct_name());
			System.out.println("상품순위:"+productVO.getProduct_rank());
		}
}
}