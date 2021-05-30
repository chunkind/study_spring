package kosta.model.impl;

import kosta.model.Member;

public class MemberImpl implements Member{

	@Override
	public void deleteMember(String id, String name) {
		System.out.println("deleteMember()...1)id : " +id + " , 2)name : " + name);
	}
}
