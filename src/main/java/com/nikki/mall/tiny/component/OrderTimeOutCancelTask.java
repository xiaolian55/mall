package com.nikki.mall.tiny.component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OrderTimeOutCancelTask {
    private Logger LOGGER = LoggerFactory.getLogger(OrderTimeOutCancelTask.class);

    /**
     * cron表达式：seconds minutes hours dayofmonth month dayofweek [year]
     * , 5,10  trigger per 5 mins and 10 mins
     * - 5-10  trigger once in every min from 5 mins to 10 mins
     * *       trigger every mins
     * / 5/10  trigger in 5, and trigger again per 10 mins
     * ? DayofMonth  trigger in every day
     * # 1#3 means the third week in this month (identify the week if month)
     * L in the end  if the value is 5L in DayofWeek that means will trigger in the last Thursday
     * W valid working day  if the value is 5W in DayofMonth, and 5th is weekend and it will trigger at last working day 4th
     * scan once in ten minutes, if the order hasn't been paid, then cancel this order
     */
    @Scheduled(cron = "0 0/10 * ? * ?")
    private void cancelTimeOutOrder(){
        //TODO
        LOGGER.info("cancel the order, and release the storage which locked for it according the sku id");
    }
}
