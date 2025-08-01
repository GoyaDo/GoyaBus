package com.ysmjjsy.goya.bus.spi;

import com.ysmjjsy.goya.bus.api.IEvent;
import com.ysmjjsy.goya.bus.enums.EventModel;
import com.ysmjjsy.goya.bus.enums.TransportType;
import com.ysmjjsy.goya.bus.route.RoutingContext;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Map;

/**
 * 订阅配置
 *
 * @author goya
 * @since 2025/6/24
 */
@Data
@SuperBuilder
public class SubscriptionConfig {

    /**
     * 消息模型
     */
    private EventModel eventModel;

    /**
     * 监听的事件类型列表
     * 当使用方法级监听器时，用于指定监听的事件类型
     * 对于类级监听器，框架会自动从泛型参数推断
     */
    private String eventKey;

    /**
     * 传输层类型枚举
     */
    private TransportType transportType;

    /**
     * 事件类
     */
    private String eventClassSimpleName;

    /**
     * 事件类
     */
    private Class<? extends IEvent> eventClass;

    /**
     * 是否启用
     */
    @Builder.Default
    private Boolean enabled = true;

    /**
     * 路由上下文
     */
    private RoutingContext routingContext;

    /**
     * 属性
     */
    private Map<String,Object> properties;
}