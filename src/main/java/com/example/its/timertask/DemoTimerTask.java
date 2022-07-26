package com.example.its.timertask;

import com.example.its.util.SpringContextUtils;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

// 参考：
// 每隔5秒执行一次：*/5 * * * * ?
// 每隔1分钟执行一次：0 */1 * * * ?
// 每天23点执行一次：0 0 23 * * ?
// 每天凌晨1点执行一次：0 0 1 * * ?
// 每月1号凌晨1点执行一次：0 0 1 1 * ?
// 每月最后一天23点执行一次：0 0 23 L * ?
// 每周星期天凌晨1点实行一次：0 0 1 ? * L
// 在26分、29分、33分执行一次：0 26,29,33 * * * ?
// 每天的0点、13点、18点、21点都执行一次：0 0 0,13,18,21 * * ?

/**
 * @ClassName: DemoTimerTask
 * @Author: lixin
 * @Description: 定时调度任务
 * @Date Created in 2020/12/24 14:36
 * @Modified By:
 */
@Slf4j
@Component
public class DemoTimerTask {

	@Scheduled(cron="*/5 * * * * ?")
	public void demoExec() throws Exception{
		log.info(new Date().toString());
		ThreadPoolTaskExecutor taskExecutor = SpringContextUtils.getBean(ThreadPoolTaskExecutor.class);
		System.out.println(taskExecutor.getThreadNamePrefix());
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				//do sth
				DemoTimerTask tasks = SpringContextUtils.getBean(DemoTimerTask.class);
				tasks.run1();
			}
		};
		//异步调用无返回值方法
		taskExecutor.execute(runnable);
		//异步调用有返回值方法
		Future future = taskExecutor.submit(run3());
		//阻塞方式取返回值
		log.info("future:"+future.get());
		log.info("完了");
	}

	public void run1(){
		int len = 30;
		for(int i = 0; i < len ;i++){
			try{
				Thread.sleep(1000);
				log.info("one - " + i);
			}catch ( Exception e){
				e.printStackTrace();
			}
		}
	}

	public Callable<String> run3(){
		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				int len = 30;
				for(int i = 0; i < len ;i++){
					Thread.sleep(1000);
					log.info("tree - " + i);
				}
				return "run3 is ok";
			}
		};
		return callable;
	}

}
