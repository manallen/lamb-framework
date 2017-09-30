package org.lamb.lambframework.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by WangGang on 2017/7/10 0010.
 * E-mail userbean@outlook.com
 * The final interpretation of this procedure is owned by the author
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ParamVerify {

    public String value();

    public boolean required();

}
