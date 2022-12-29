package spring;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

public class MemberPrinter {
	
	private DateTimeFormatter dateTimeFormatter;
	
	public MemberPrinter() {
		this.dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
	}
	
	@Autowired
	public void setDateTimeFormatter(@Nullable DateTimeFormatter dateTimeFormatter) {
		System.out.println("setDateTimeFormatter is called");
		this.dateTimeFormatter = dateTimeFormatter;
	}
	
	public void print(Member member) {
		if (dateTimeFormatter == null) {
			System.out.printf("회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n", 
					member.getId(), member.getEmail(), member.getName(), 
					member.getRegisterDateTime());	
		} else {
			System.out.printf("회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%s\n", 
					member.getId(), member.getEmail(), member.getName(), 
					dateTimeFormatter.format(member.getRegisterDateTime()));
		}		
	}
}
