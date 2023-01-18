package hello.core.member.entity;

import lombok.Data;

@Data
public class Member {

    private Long id;
    private String name;
    private Grade grade;

    //생성자
    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

}
