package com.ykh.dao.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD})
public @interface DaoHelper {
	String value() default "";
	IgnoreValue ignore() default IgnoreValue.DEFAULT;
	SearchMethod searchMethod() default SearchMethod.equal;
	public enum IgnoreValue {
		 DEFAULT,ZERO,NULLCOLLECTION,NONE;
	}
	public enum SearchMethod{
		like,equal,gt,ge,lt,le
	}
}
