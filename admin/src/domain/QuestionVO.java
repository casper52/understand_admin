package domain;

import java.util.Date;

import lombok.Data;

@Data
public class QuestionVO {
   private Integer qno, mno, reply, limittime;
   private String question, cmt, name, id;
   private Date regdate, replydate;
   private Double time;
}