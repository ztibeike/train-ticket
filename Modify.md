# 任务

添加注册中心eureka，选择服务添加网关zuul



# 完成结果

SpringBoot版本：1.5.22.RELEASE	SpringCloud版本：Edgware.SR6

备注：

1. 未添加zuul插件

2. 所有添加的服务均写好Dockerfile，以及在根目录docker-compose.yml增加对应任务

## 添加Eureka

服务名：ts-eureka-registry

eureka版本：1.4.7.RELEASE

备注：保留了ConfController，正常运行



## 添加网关Zuul

zuul版本：2.2.5.RELEASE，与整个项目SpringCloud版本不同，但没影响

### 所选服务

![2-1-1](./image/2-1-1.png)

ts-basic-sevice

ts-train-service

ts-station-service

ts-price-service

![2-1-2](./image/2-1-2.png)



### 完成效果

![](/home/zt123/IdeaProjects/train-ticket/image/2-2.png)

### 添加过程

#### 给basic-station添加网关

1. 多实例：ts-station-service(端口12345)，ts-station2-service(端口16345)
2. 添加网关：ts-zuul-station(端口30001)
3. 路由配置：

![image-20201027194802191](./image/3.png)

4. ts-basic-service修改

   ![image-20201027194905306](./image/4.png)

   ![image-20201027194928188](./image/5.png)

![image-20201027194937534](./image/6.png)



#### 给basic-train添加网关

1. 多实例：ts-train-service(端口14567)，ts-train2-service(端口16567)

2. 添加网关：ts-zuul-train(端口30002)

3. 路由配置：

   ![image-20201027195457213](./image/7.png)

4. ts-basic-service修改

   ![image-20201027195540940](./image/8.png)

![image-20201027195559249](./image/9.png)



#### 给basic-price添加网关

1. 多实例：ts-price-service(端口16579)，ts-price2-service(端口18579)
2. 添加网关：ts-zuul-price(端口30003)
3. 路由配置：

![image-20201027195937829](./image/10.png)

4. ts-basic-service修改

   ![image-20201027200042129](./image/11.png)

   ![image-20201027200108752](./image/12.png)



### 测试

由于增加了7个服务，本地16G内存跑不起来，所以没有实际整个项目测试

采用的测试方法是模拟两个服务——调用服务和被调用服务

调用服务：ts-resttemplate![image-20201027200334406](./image/13.png)

被调用服务：ts-zuul ![image-20201027200404182](./image/14.png)

测试全部通过，能通过网关正常进行转发