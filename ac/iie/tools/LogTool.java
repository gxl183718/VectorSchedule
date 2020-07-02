package cn.ac.iie.tools;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;


/**
 * @author zhangzhanqi
 * @version 1.0
 * @date 2019-8-26 17:40
 */

public class LogTool {

    public static String packageName = "mmdd.server";

    public static String name = "WB";

    public static String subName = "WB-DATA-ACCESS";

    public void error(String code, Throwable e) {
        logger(null, code, e, e.getMessage(), null,
                null, null, null, null, null,
                null, null, null, null,
                null, "ERROR");
    }

    public void error(String code, String message) {
        logger(null, code, null, message, null,
                null, null, null, null, null,
                null, null, null, null,
                null, "ERROR");
    }


    public void error(String message) {
        logger(null, "-1", null, message, null,
                null, null, null, null, null,
                null, null, null, null,
                null, "ERROR");
    }

    public void error(Throwable e) {
        logger(null, "-1", e, e.getMessage(), null,
                null, null, null, null, null,
                null, null, null, null,
                null, "ERROR");
    }
    public void warn(Throwable e) {
        logger(null, "-1", e, e.getMessage(), null,
                null, null, null, null, null,
                null, null, null, null,
                null, "INFO");
    }
    public void warn(String e) {
        logger(null, "-1", null, e, null,
                null, null, null, null, null,
                null, null, null, null,
                null, "INFO");
    }

    public void info(String message) {
        logger(null, "1", null, message, null,
                null, null, null, null, null,
                null, null, null, null,
                null, "INFO");
    }



    public void info(Long readNumber, Long writeNumber, String numLast7Days) {
        logger(null, "1", null, "", "OK",
                null, null, null, null, null,
                null, null, readNumber, writeNumber, numLast7Days, "INFO");
    }


    private void logger(String requestId, String code, Throwable e, String message, String heartbeat,
                        Date startTime, Date endTime, Integer requestNumber, Integer returnNumber, Integer dataNumber,
                        Integer errorNumber, Integer targetNumber, Long readNumber, Long writeNumber, String numLast7Days,
                        String level) {
        String element = null;
        StackTraceElement[] stackTrace;
        if (e == null) {
            stackTrace = Thread.currentThread().getStackTrace();
        } else {
            stackTrace = e.getStackTrace();
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            String fileName = stackTraceElement.getFileName();
            if (className.startsWith(packageName) && fileName != null && !fileName.startsWith("LogManager")) {
                element = stackTraceElement.toString();
                break;
            }
        }
        if (element == null) {
            element = stackTrace[stackTrace.length -1].toString();
        }
        LogMessage logMessage = new LogMessage(requestId, code, element, message, heartbeat,
                startTime, endTime, requestNumber, returnNumber, dataNumber,
                errorNumber, targetNumber, readNumber, writeNumber, numLast7Days, level);
        //log.info(logMessage.toJson());
        System.out.println(logMessage.toJson());
    }

    public class LogMessage {

        public LogMessage(String taskId, String code, String function, String msg, String heartbeat,
                          Date startTime, Date endTime, Integer requestNumber, Integer returnNumber,
                          Integer dataNumber, Integer errorNumber, Integer targetNumber, Long readNumber,
                          Long writeNumber, String numLast7Days, String level) {
            this.taskId = taskId;
            this.code = code;
            this.function = function;
            this.msg = msg;
            this.heartbeat = heartbeat;
            this.startTime = startTime;
            this.endTime = endTime;
            this.requestNumber = requestNumber;
            this.returnNumber = returnNumber;
            this.dataNumber = dataNumber;
            this.errorNumber = errorNumber;
            this.targetNumber = targetNumber;
            this.readNumber = readNumber;
            this.writeNumber = writeNumber;
            this.numLast7Days = numLast7Days;
            this.level = level;
        }

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getFunction() {
            return function;
        }

        public void setFunction(String function) {
            this.function = function;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getName() {
            return name;
        }

        public String getSubName() {
            return subName;
        }

        public String getHeartbeat() {
            return heartbeat;
        }

        public void setHeartbeat(String heartbeat) {
            this.heartbeat = heartbeat;
        }

        public Date getTime() {
            return time;
        }

        public Date getStartTime() {
            return startTime;
        }

        public void setStartTime(Date startTime) {
            this.startTime = startTime;
        }

        public Date getEndTime() {
            return endTime;
        }

        public void setEndTime(Date endTime) {
            this.endTime = endTime;
        }

        public Integer getRequestNumber() {
            return requestNumber;
        }

        public void setRequestNumber(Integer requestNumber) {
            this.requestNumber = requestNumber;
        }

        public Integer getReturnNumber() {
            return returnNumber;
        }

        public void setReturnNumber(Integer returnNumber) {
            this.returnNumber = returnNumber;
        }

        public Integer getDataNumber() {
            return dataNumber;
        }

        public void setDataNumber(Integer dataNumber) {
            this.dataNumber = dataNumber;
        }

        public Integer getErrorNumber() {
            return errorNumber;
        }

        public void setErrorNumber(Integer errorNumber) {
            this.errorNumber = errorNumber;
        }

        public Integer getTargetNumber() {
            return targetNumber;
        }

        public void setTargetNumber(Integer targetNumber) {
            this.targetNumber = targetNumber;
        }

        public Long getReadNumber() {
            return readNumber;
        }

        public void setReadNumber(Long readNumber) {
            this.readNumber = readNumber;
        }

        public Long getWriteNumber() {
            return writeNumber;
        }

        public void setWriteNumber(Long writeNumber) {
            this.writeNumber = writeNumber;
        }




        // ID
        @JSONField(name = "request_id")
        private String taskId;

        // 消息状态码
        @JSONField(name = "status")
        private String code;

        // 函数名
        @JSONField(name = "function")
        private String function;

        // 消息内容
        @JSONField(name = "content")
        private String msg;

        // 消息常量
        // 服务名
        @JSONField(name = "fw_type")
        private final String name = LogTool.name;

        // 消息常量
        // 模块名
        @JSONField(name = "fw_subtype")
        private final String subName = LogTool.subName;

        // 消息常量
        // 服务名
        @JSONField(name = "heart_beat")
        private String heartbeat;

        // 消息时间
        @JSONField(name = "print_time", format="yyyy-MM-dd HH:mm:ss.000")
        private final Date time = sipDate();
        // 请求开始时间
        @JSONField(name = "start_time", format="yyyy-MM-dd HH:mm:ss.SSS")
        private Date startTime;
        // 请求结束时间
        @JSONField(name = "end_time", format="yyyy-MM-dd HH:mm:ss.SSS")
        private Date endTime;

        // 请求数
        @JSONField(name = "request_num")
        private Integer requestNumber;
        // 返回数
        @JSONField(name = "return_num")
        private Integer returnNumber;
        // 数据量
        @JSONField(name = "data_num")
        private Integer dataNumber;
        // 异常量
        @JSONField(name = "abnormal_num")
        private Integer errorNumber;
        // 中标量
        @JSONField(name = "bid_num")
        private Integer targetNumber;

        // 读取数据量
        @JSONField(name = "read_data_num")
        private Long readNumber;
        // 写入数据量
        @JSONField(name = "write_data_num")
        private Long writeNumber;

        public String getNumLast7Days() {
            return numLast7Days;
        }

        public void setNumLast7Days(String numLast7Days) {
            this.numLast7Days = numLast7Days;
        }

        // 近7天数据量
        @JSONField(name = "num_last7_days")
        private String numLast7Days;

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        @JSONField(name = "level")
        private String level;

	private Date sipDate(){
	    long timeSecond = System.currentTimeMillis();
	    long time = timeSecond - timeSecond%10000;
	    return new Date(time);
	}	

        public String toJson() {
            return JSON.toJSONString(this);
        }
    }


}
