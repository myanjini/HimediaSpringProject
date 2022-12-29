package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// 설정 클래스에서 public MemberInfoPrinter infoPrinter() { return new MemberInfoPrinter(); } 와 동일
//                        ~~~~~~~~~~~~~~~~~ ~~~~~~~~~~~
//                        빈 타입           빈 이름
@Component("infoPrinter")
public class MemberInfoPrinter {

	private MemberDao memberDao;
	private MemberPrinter printer;
	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@Autowired
	@Qualifier("printer")
	public void setMemberPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	public void printMemberInfo(String email) {
		Member member = memberDao.selectByEmail(email);
		if (member == null) {
			System.out.println("일치하는 회원 정보가 없습니다.");
			return;
		}
		printer.print(member);		
	}	
}
