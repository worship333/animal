# animal
这个项目是给流浪动物救助机构用的，他们可以把救助的小动物的信息从后台输入，然后用户就可以在前台界面看到这些动物，并决定是否要收养它。
这样就可以减轻流浪动物救助机构的压力，同时让想要收养流浪动物的爱心人士收养到他们心仪的小动物，让小动物回归家庭。

使用的技术：
Spring、SpringMVC、Mybatis、Redis、Solr、Dubbo、MySQL、Nginx

本项目是分布式项目，通过不同的包来区分不同的模块，各个模块的功能如下：
animal-parent：父项目
animal-commons：放工具类等
animal-item：动物的管理
animal-cart：是否决定收养，然后就可以联系流浪动物救助机构
animal-manage：后台
animal-passport：登录
animal-pojo：实体类
animal-portal：导航菜单，由门户调用animal-item，跨域
animal-redis：使用Redis，实现缓存
animal-search：搜索功能
animal-service：服务接口
animal-service-impl：Dubbo的provider
