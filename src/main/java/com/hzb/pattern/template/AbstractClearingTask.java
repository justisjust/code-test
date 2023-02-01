package com.hzb.pattern.template;

/**
 * @author haozhenbo
 * @version 1.0.0
 * @ClassName AbstractClearing.java
 * @Description TODO
 * @createTime 2022年05月15日 15:51:00
 */
public abstract class AbstractClearingTask {

    public void handleClearingTask() {
        validParam();
        createReceipt();
        saveReceipt();
        if(needUpdateTask()) {
            updateTask();
        }
    }

    protected void validParam() {
        System.out.println("1-   validParam");
    }

    protected void createReceipt(){
        System.out.println("2-    createReceipt");
    }

    protected void saveReceipt() {
        System.out.println("3-   saveReceipt");
    }

    /**
     * 钩子方法
     * @return
     */
    protected boolean needUpdateTask() {
        return false;
    }

    protected void updateTask(){
        System.out.println("4-   updateTask");
    }

}
