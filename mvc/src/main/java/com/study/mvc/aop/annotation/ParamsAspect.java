package com.study.mvc.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD}) // type - 클래스 위에, method - method 위에, field - 변수 위에 달 수 있다. 어노테이션을
public @interface ParamsAspect {

}
