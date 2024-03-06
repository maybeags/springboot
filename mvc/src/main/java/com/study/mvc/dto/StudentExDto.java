package com.study.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
// @Component는 안된다, 왜냐하면, 무조건 하나가 스캔돼서 ioc에 올라가기 때문에. 얘는 매번 카피하면서 정보를 담는 객체다.
public class StudentExDto {
    private String name;
}
