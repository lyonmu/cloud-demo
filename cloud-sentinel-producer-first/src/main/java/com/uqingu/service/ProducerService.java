package com.uqingu.service;

import cn.hutool.core.util.IdUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.uqingu.handler.CustomerBlockHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import space.muqingcloud.entities.ResponseResult;

@Service
public class ProducerService {

    @Value("${server.port}")
    private String port;

    public ResponseResult<String> getTest(Long id) {

        if (id > 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常....");
        } else if (id < 2) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录,空指针异常");
        }

        return new ResponseResult<>(200, "测试sentinel", port, "测试@SentinelResource注解，ID为：" + id);
    }

    public ResponseResult<String> getTestPersistence() {
        return new ResponseResult<>(333, "测试sentinel", port, "测试sentinel流控规则持久化注解，ID为：" + IdUtil.simpleUUID());
        /*
         * resource：资源名称；
         * limitApp：来源应用；
         * grade：阈值类型，0表示线程数, 1表示QPS；
         * count：单机阈值；
         * strategy：流控模式，0表示直接，1表示关联，2表示链路；
         * controlBehavior：流控效果，0表示快速失败，1表示Warm Up，2表示排队等待；
         * clusterMode：是否集群。
         *
         * JSON配置文件
         * [{
         *   "resource": "/rateLimit/byUrl",
         *   "IimitApp": "default",
         *   "grade": 1,
         *   "count": 1,
         *   "strategy": 0,
         *   "controlBehavior": 0,
         *   "clusterMode": false
         * }]
         *
         * */
    }
}
