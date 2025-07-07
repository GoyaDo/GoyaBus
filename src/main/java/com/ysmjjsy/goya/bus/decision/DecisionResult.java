package com.ysmjjsy.goya.bus.decision;

import com.ysmjjsy.goya.bus.enums.EventModel;
import com.ysmjjsy.goya.bus.enums.EventType;
import com.ysmjjsy.goya.bus.enums.ReliabilityLevel;
import com.ysmjjsy.goya.bus.enums.TransportType;
import com.ysmjjsy.goya.bus.route.RoutingContext;
import lombok.Builder;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * <p>决策结果</p>
 *
 * @author goya
 * @since 2025/6/26 22:08
 */
@Data
@Builder
public class DecisionResult {

    /**
     * 消息模型
     */
    private EventModel eventModel;

    /**
     * 消息类型
     */
    private EventType eventType;

    /**
     * 可靠性级别
     */
    private ReliabilityLevel reliabilityLevel;

    /**
     * 传输方式
     */
    private TransportType transportType;

    /**
     * 路由上下文（包含详细的路由信息）
     */
    private RoutingContext routingContext;

    /**
     * 延迟时间
     */
    private Duration delayTime;

    /**
     * 发送时间
     */
    private LocalDateTime deliverTime;

    /**
     * 消息序列键
     */
    private String sequenceKey;

    /**
     * 消息生存时间
     */
    private Duration ttl;

    /**
     * 是否本地记录
     */
    private boolean localRecord;

    /**
     * 是否持久化
     */
    private boolean persistent;

    /**
     * 重试次数
     */
    private Integer retryTimes;

    /**
     * 是否启用压缩
     */
    private Boolean enableCompression;

    /**
     * 是否启用加密
     */
    private Boolean enableEncryption;

    /**
     * 是否启用幂等
     */
    private Boolean idempotence;

    /**
     * 事务ID
     */
    private String transactionalId;

    /**
     * 自定义属性
     * 用于传递额外信息
     */
    private Map<String, Object> properties;
}
