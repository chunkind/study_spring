package step15.model.impl;

import step15.model.Member;

public class MemberImpl implements Member{

	@Override
	public void deleteMember(String id, String name) {
		System.out.println("deleteMember()...1)id : " +id + " , 2)name : " + name);
	}
}
