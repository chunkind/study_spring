package jdbc;

import java.util.List;

/*
 * 추상화된 비지니스 로직만 담는다..
 */
public interface MemberDao {
	void register(MemberVO vo);
	List<MemberVO> getList();
	MemberVO getSearch(String id);
}
