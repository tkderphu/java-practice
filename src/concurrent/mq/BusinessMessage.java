package concurrent.mq;

import java.util.HashMap;
import java.util.Map;


public class BusinessMessage {
    private String content;
    private BusinessType type;
    private Map<String, Object> data;

    public BusinessMessage(String content, BusinessType type, Map<String, Object> data) {
        this.content = content;
        this.type = type;
        this.data = data == null ? new HashMap<>() : new HashMap<>(data);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BusinessType getType() {
        return type;
    }

    public void setType(BusinessType type) {
        this.type = type;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BusinessMessage{" +
                "content='" + content + '\'' +
                ", type=" + type +
                ", data=" + data +
                '}';
    }
}
