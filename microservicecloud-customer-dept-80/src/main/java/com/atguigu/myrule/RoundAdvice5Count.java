package com.atguigu.myrule;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

/**
 * @ClassName:
 * @Description:自定义轮询算法，每个 服务请求五次之后，才切换到下一个服务
 * @author DuanZhaoXu
 * @data 2018年9月30日下午12:40:18
 */

public class RoundAdvice5Count extends AbstractLoadBalancerRule {

	private int totalCount;
	private int currentIndex;

	/**
	 * 自定义  轮询 策略
	 * 每个 服务 请求 五次 到达下一个 服务 如果 total Count<5 ,index 不变， 只有 totalCount 递增 如果 total
	 * Count >5了, totalCount = 0 , index+1, 如果 index > 在线的服务数量 了则重新重置为0
	 * 
	 */

	/**
	 * Randomly choose from all living servers
	 */
	public Server choose(ILoadBalancer lb, Object key) {
		if (lb == null) {
			return null;
		}
		Server server = null;

		while (server == null) {
			if (Thread.interrupted()) {
				return null;
			}
			List<Server> upList = lb.getReachableServers();
			List<Server> allList = lb.getAllServers();

			int serverCount = allList.size();
			if (serverCount == 0) {
				/*
				 * No servers. End regardless of pass, because subsequent passes only get more
				 * restrictive.
				 */
				return null;
			}

			if (totalCount < 5) {
				server = upList.get(currentIndex);
				totalCount++;
			} else {
				totalCount = 0;
				currentIndex++;
				if (currentIndex >= upList.size()) {
					currentIndex = 0;
				}
			}

//	            int index = rand.nextInt(serverCount);
//	            server = upList.get(index);

			if (server == null) {
				/*
				 * The only time this should happen is if the server list were somehow trimmed.
				 * This is a transient condition. Retry after yielding.
				 */
				Thread.yield();
				continue;
			}

			if (server.isAlive()) {
				return (server);
			}

			// Shouldn't actually happen.. but must be transient or a bug.
			server = null;
			Thread.yield();
		}

		return server;

	}

	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig clientConfig) {
		// TODO Auto-generated method stub

	}
}
