package com.jerome.event;

import org.springframework.context.ApplicationListener;

/**
 * @author suzhida@soundbus.cn
 * @since 2017/7/19 09:58
 */
public class DemoListener implements ApplicationListener<DemoEvent> {

    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        String msg = demoEvent.getMsg();
        System.out.println("我：DemoListener接收到了：" + msg);
    }
}