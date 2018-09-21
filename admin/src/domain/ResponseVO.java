package domain;

import java.util.Date;

import lombok.Data;

@Data
public class ResponseVO {

	private Integer qno, mno, reply, seatnum;
	private String cmt, name, question;
	private Date replydate;
	private double ratio;
	
}
