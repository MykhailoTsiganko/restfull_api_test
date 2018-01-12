package com.utills;

import org.apache.log4j.FileAppender;
import org.apache.log4j.spi.LoggingEvent;

public class FileThreadAppender extends FileAppender {
    private long threadId;

    public FileThreadAppender(){
        this.threadId = Thread.currentThread().getId();
    }

    @Override
    public void append(LoggingEvent event){
        if (this.checkEntryConditions()&& Thread.currentThread().getId() == threadId) {
            this.subAppend(event);
        }
    }
}
