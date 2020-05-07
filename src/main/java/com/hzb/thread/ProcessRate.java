package com.hzb.thread;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 2020/04/01 已对应为最新版本
 */
public class ProcessRate {

    // 任务ID
    @JSONField(name = "task_id")
    private Long taskId;

    // 应答码
    @JSONField(name = "rsp_code")
    private Integer rspCode;

    // 处理状态(0：未开始 1：处理中 2：处理完成 3：处理终止 4：处理失败)
    @JSONField(name = "task_status")
    private Integer taskStatus;

    // 已处理文件数
    @JSONField(name = "finish_num")
    private Integer finishNum;

    // 总文件数
    @JSONField(name = "total_num")
    private Integer totalNum;

    // 已处理包数，仅payload扫描任务支持
    @JSONField(name = "finish_pkts")
    private Integer finishPkts;

    // 总包数，仅payload扫描任务支持
    @JSONField(name = "total_pkts")
    private Integer totalPkts;

    // 进度百分数分子
    private int rate;

    // 进度请求的时间
    private Long requestTime;

    public ProcessRate() {
    }

    public ProcessRate(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public ProcessRate(int taskStatus, int rate) {
        this.taskStatus = taskStatus;
        this.rate = rate;
    }

    @JSONField(name = "task_id")
    public Long getTaskId() {
        return taskId;
    }

    @JSONField(name = "task_id")
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Integer getRspCode() {
        return rspCode;
    }

    public void setRspCode(Integer rspCode) {
        this.rspCode = rspCode;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Integer getFinishNum() {
        return finishNum;
    }

    public void setFinishNum(Integer finishNum) {
        this.finishNum = finishNum;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getFinishPkts() {
        return finishPkts;
    }

    public void setFinishPkts(Integer finishPkts) {
        this.finishPkts = finishPkts;
    }

    public Integer getTotalPkts() {
        return totalPkts;
    }

    public void setTotalPkts(Integer totalPkts) {
        this.totalPkts = totalPkts;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }

    public Long getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Long requestTime) {
        this.requestTime = requestTime;
    }

}
