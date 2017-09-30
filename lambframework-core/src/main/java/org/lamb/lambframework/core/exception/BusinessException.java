package org.lamb.lambframework.core.exception;

import org.lamb.lambframework.core.exception.basic.GlobalBasicException;
import org.lamb.lambframework.core.enumeration.ExceptionEnum;

/**
 * Created by WangGang on 2017/6/22 0022.
 * E-mail userbean@outlook.com
 * The final interpretation of this procedure is owned by the author
 */
public class BusinessException extends GlobalBasicException {

    public BusinessException(ExceptionEnum error) {
        super(error);
    }

    public BusinessException(String code,String message) {
        super(code,message);
    }

}
