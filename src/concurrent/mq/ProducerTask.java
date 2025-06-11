package concurrent.mq;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProducerTask {
    private  BusinessType businessType;
    private  String content;
    private  Map<String, Object> data;
    private  String taskId;


    public ProducerTask(BusinessType businessType, String content, Map<String, Object> data) {
        this.businessType = businessType;
        this.content = content;
        this.data = data != null ? new HashMap<>(data) : new HashMap<>();
        this.taskId = UUID.randomUUID().toString().substring(0, 6);
    }

    public BusinessType getBusinessType() {
        return businessType;
    }

    public void setBusinessType(BusinessType businessType) {
        this.businessType = businessType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }


    @Override
    public String toString() {
        return String.format("Task[id=%s, type=%s, content='%s']", taskId, businessType, content);
    }
}
