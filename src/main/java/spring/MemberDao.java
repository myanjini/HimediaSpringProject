package spring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

// 설정 클래스에서 public MemberDao memberDao() { return new MemberDao(); } 한 것과 동일
//                        ~~~~~~~~~ ~~~~~~~~~
//                        빈 타입   빈 이름
@Component
public class MemberDao {				
	private static long nextId = 0;
	
	private Map<String, Member> map = new HashMap<>();
	
	public Member selectByEmail(String email) {
		return map.get(email);
	}
	
	public void insert(Member member) {
		nextId ++;
		member.setId(nextId);
		map.put(member.getEmail(), member);
	}
	
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
	
	public Collection<Member> selectAll() {
		return map.values();
	}
}
