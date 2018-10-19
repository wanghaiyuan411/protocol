package com.wlcxbj.http.model;

public class RespBase {
    public static final int ERRORCODE_OK = 0;
    public static final int ERRORCODE_ERROR = 1;
    public static final int ERRORCODE_PARAMS_NULL = 1000;
    public static final int ERRORCODE_PARAMS_EMPTY = 1001;
    public static final int ERRORCODE_USER_NOTEXITS = 2000;
    protected Integer errcode;
    protected String errmsg;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        switch (errcode){
            case (ERRORCODE_OK):errmsg = "OK";
            break;
            case (ERRORCODE_ERROR):errmsg = "ERROR";
            break;
            case (ERRORCODE_PARAMS_NULL):errmsg = "Parameter Is Null";
            break;
            case (ERRORCODE_PARAMS_EMPTY):errmsg = "Parameter Is Empty";
            break;
            case (ERRORCODE_USER_NOTEXITS):errmsg = "UserId Is Not Exits";
            break;
        }
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public RespBase() {
        this.errcode = ERRORCODE_OK;
        this.errmsg = "OK";
    }
    public RespBase(int errcode) {
        setErrcode(errcode);
    }


    @Override
    public String toString() {
        return "RespBase{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
