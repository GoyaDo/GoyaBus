package com.ysmjjsy.goya.bus.route;

import com.ysmjjsy.goya.bus.api.IEvent;
import com.ysmjjsy.goya.bus.enums.EventModel;
import com.ysmjjsy.goya.bus.enums.TransportType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * 路由策略管理器
 * <p>
 * 负责管理和选择合适的路由策略
 *
 * @author goya
 * @since 2025/6/26
 */
@Slf4j
@RequiredArgsConstructor
public class RoutingStrategyManager {

    /**
     * 策略缓存
     */
    private final Map<String, RoutingStrategy> strategyCache;

    /**
     * 构建发送消息的路由上下文
     */
    public RoutingContext buildSendingContext(IEvent event, EventModel eventModel, TransportType transportType) {

        RoutingStrategy strategy = selectStrategy(transportType);

        RoutingContext context = strategy.buildSendingContext(event, eventModel);

        log.debug("Built sending context {}", context);

        return context;
    }

    /**
     * 选择发送策略
     */
    public RoutingStrategy selectStrategy(TransportType transportType) {

        if (transportType == null) {
            return strategyCache.get("defaultRoutingStrategy");
        }

        for (Map.Entry<String, RoutingStrategy> entry : strategyCache.entrySet()) {
            String strategyName = entry.getKey();
            RoutingStrategy strategy = entry.getValue();

            if (StringUtils.contains(strategyName, transportType.name())) {
                return strategy;
            }
        }
        return strategyCache.get("defaultRoutingStrategy");
    }
} 
 