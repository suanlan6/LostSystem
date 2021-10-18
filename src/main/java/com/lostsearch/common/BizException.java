package com.lostsearch.common;

import lombok.Data;

@Data
public class BizException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    protected String errorCode;
    protected String errorMsg;

    public BizException() {
        super();
    }

    public BizException(BaseErros errorInfoInterface) {
        super(errorInfoInterface.getcode());
        this.errorCode = errorInfoInterface.getcode();
        this.errorMsg = errorInfoInterface.getmsg();
    }

    public BizException(BaseErros errorInfoInterface, Throwable cause) {
        super(errorInfoInterface.getcode(), cause);
        this.errorCode = errorInfoInterface.getcode();
        this.errorMsg = errorInfoInterface.getmsg();
    }

    public BizException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public BizException(String errorCode, String errorMsg) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BizException(String errorCode, String errorMsg, Throwable cause) {
        super(errorCode, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
