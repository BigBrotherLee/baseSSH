
# 这是SSH(struts2,spring,hibernate)的整合环境

------------------------------------------------------------

## 一、说明

这个环境拿到就能用，框架版本分别是spring-framework-5.0.2.RELEASE、struts-2.5.14.1、hibernate-release-5.2.11.Final
基本上配置文件就是这些，日志的没有输出到文件中，需要的自己修改
log4j有俩个配置文件，它们的作用是不一样的，struts用的是2的版本，用xml文件配置

## 二、配置

请将你要写的类放到相应的包里面。

### 1.所有的配置文件在名为config的source folder下面，本质上部署后是在classes文件夹下。

### 2.config下的spring包放的是bean配置，其中beans.xml是其他模块bean的综合，我在applicationContext.xml
### 中import的只有一个beans.xml。而在beans中我import了其他模块的bean配置。我们希望每一个模块有一个bean.xml
### 然后你可以自行将这个bean.xml文件import到beans.xml中。我们这样做因为spring的import不支持通配符

### 3.config下的struts包放的是action配置。你只需要在里面写action的xml配置就ok了，struts的include是支持通配符的
### 也就是说你只需要将配置文件放到该文件夹下就可以了，不用自己配置

### 4.applicationContext.xml和struts.xml分别是Spring和Struts2的核心配置文件。当你更改了包名，记得更
### 改applicationContext.xml里的**事务配置** 

### 5.db.properties和hibernate.properties分别是c3p0数据源和hibernate的属性设置，你可以在db.properties中配置连接池
### 超时时长、最大连接数,驱动等设置，当然你所设置的记得**要在applicationContext.xml的dataSource里进行应用** 。
### hibernate.properties可以设置方言等等,你更改之后可以不用应用就会自动应用过去

### 6.log4j是没有配置输出到硬盘的，如果你不添加的话会给后期维护带来不便

## 三、使用注意

相信使用框架的你对分层没有什么疑问
	
### 1、由于我的实体类使用的是注解这也就使得我没有hibernate.cfg.xml配置文件，所以你如果要用xml配置的话需要将
### `<property name="packagesToScan" value="com.example.pojo.entity"></property>` 注释掉，同时将你的hibernate.cfg.xml
### 路径添加至`<property name="configLocations" value=""></property>`之中

### 2.当你对项目中的包、结构进行更改后记得更改相应的配置

### 3.hibernate使用的是spring提供的模板，bean的id为：hTamplate；他可以替代HibernateSession

### 4.我的测试数据库是mysql，数据库是test，测试表为TestUser，你可以自己测试这个环境是否可用（访问：http://localhost:8080/baseSSH/testUserAction）

### 5.你自己的action继承要default，可以省去一些配置

### 6.不要带多余的环境如.classpath、.project等


------------------------------------------------------------

&copy; 李大哥 一个环境，以后如果不用maven就可以方便搭建

------------------------------------------------------------


## **更新** ：将spring的bean用通配符配置了（web.xml里），文件规范：以Bean.xml结尾且放到spring目录下

















