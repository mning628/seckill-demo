基于springboot+redis+rabbitmq+jpa实现的后台秒杀功能简易demo

秒杀流程图（网上copy）
![image text](https://github.com/mning628/my_image/blob/master/image/seckill.png)



数据库语句查看sql文件夹

项目运行步骤：
1、将application.properties中数据库，redis，rabbitmq修改为自己环境信息

2、在数据库t_seckill_product_info中任意预置一条数据

   例：INSERT INTO `second_kill`.`t_seckill_product_info` (`id`, `product_name`, `product_num`) VALUES ('1', '测试商品', '50');
   
3、手动将t_seckill_product_info记录到redis中  
   例：set 1 50
   
4、test目录下有一个main函数，可以模拟并发秒杀请求。
