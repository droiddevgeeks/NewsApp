package news.agoda.com.sample.base;

public class BaseViewState<T> {
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Throwable getError() {
        return error;
    }

    public void setError(Throwable error) {
        this.error = error;
    }

    public int getCurrentState() {
        return currentState;
    }

    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }

    protected T data;
    protected Throwable error;
    protected int currentState;

    public enum State{
        LOADING(0), SUCCESS(1),FAILED(-1);
        public int value;
        State(int val) {
            value = val;
        }
    }
}
