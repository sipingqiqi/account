package RestResponse;

public class RESTResponse<T> {
    private int errCode;
    private String errorMessage;
    private T data;


    public int getErrCode(){
        return errCode;
    }
    public void setErrCode(int errCode){
        this.errCode = errCode;
    }
    public String getErrorMessage(){
        return errorMessage;
    }
    public void  setErrorMessage(String errorMessage){
        this.errorMessage =errorMessage;
    }
    public T getData(){
        return data;
    }
    public void setData(T data){
        this.data = data;
    }


}
