package com.hzb.pattern.template;

/**
 * @author haozhenbo
 * @version 1.0.0
 * @ClassName MySQLClearingTask.java
 * @Description TODO
 * @createTime 2022年05月15日 15:59:00
 */
public class MySQLClearingTask extends AbstractClearingTask {
    @Override
    protected boolean needUpdateTask() {
        return true;
    }
}
