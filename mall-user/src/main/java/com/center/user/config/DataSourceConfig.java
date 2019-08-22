package com.center.user.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.MybatisConfiguration;
import com.baomidou.mybatisplus.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.enums.DBType;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import com.baomidou.mybatisplus.spring.boot.starter.SpringBootVFS;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
// 扫描 Mapper 接口并容器管理
@EnableConfigurationProperties(MybatisProperties.class)
@MapperScan(basePackages = {DataSourceConfig.PACKAGE_FIRST},
sqlSessionFactoryRef = DataSourceConfig.SESSION_FACTORY)
public class DataSourceConfig {

// 精确到 cluster 目录，以便跟其他数据源隔离
static final String PACKAGE_FIRST = "com.center.user.dao";
static final String MAPPER_LOCATION = "classpath:com/center/user/dao/mapper/*.xml";
static final String SESSION_FACTORY = "firstSqlSessionFactory";



@ConfigurationProperties(prefix = "spring.datasource")
@Bean(name = "firstDataSource")
public DataSource druid() {
return new DruidDataSource();
}

@Bean
public DataSourceTransactionManager firstTransactionManager(@Qualifier("firstDataSource") DataSource dataSource) {
return new DataSourceTransactionManager(dataSource);
}

/**
* mybatis-plus分页插件
*/
@Bean
public PaginationInterceptor paginationInterceptor() {
PaginationInterceptor page = new PaginationInterceptor();
page.setDialectType(DBType.MYSQL.name());
// 开启 PageHelper 的支持
page.setLocalPage(true);
return page;
}


//    //配置Druid的监控
//    //1、配置一个管理后台的Servlet
//    @Bean
//    public ServletRegistrationBean statViewServlet() {
//        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
//        Map<String, String> initParams = new HashMap<>();
//        initParams.put("loginUsername", "admin");
//        initParams.put("loginPassword", "123456");
//        initParams.put("allow", "");//默认就是允许所有访问
//        initParams.put("deny", "192.168.15.21");
//        bean.setInitParameters(initParams);
//        return bean;
//    }


@Autowired
private MybatisProperties properties;

@Autowired
private ResourceLoader resourceLoader = new DefaultResourceLoader();

@Autowired(required = false)
private Interceptor[] interceptors;

@Autowired(required = false)
private DatabaseIdProvider databaseIdProvider;

/**
* 这里全部使用mybatis-autoconfigure 已经自动加载的资源。不手动指定
* 配置文件和mybatis-boot的配置文件同步
* @return
*/
@Bean(name = SESSION_FACTORY)
public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean(@Qualifier("firstDataSource") DataSource dataSource) throws IOException {
MybatisSqlSessionFactoryBean mybatisPlus = new MybatisSqlSessionFactoryBean();
mybatisPlus.setDataSource(dataSource);

Resource[] resources1=new PathMatchingResourcePatternResolver().getResources(DataSourceConfig.MAPPER_LOCATION);
//Resource[] resources2=new PathMatchingResourcePatternResolver().getResources(DataSourceConfig.MAPPER_LOCATION2);
Resource[] resources= ArrayUtils.addAll(resources1);
mybatisPlus.setMapperLocations(resources);

mybatisPlus.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DataSourceConfig.MAPPER_LOCATION));
mybatisPlus.setVfs(SpringBootVFS.class);
if (StringUtils.hasText(this.properties.getConfigLocation())) {
mybatisPlus.setConfigLocation(this.resourceLoader.getResource(this.properties.getConfigLocation()));
}
mybatisPlus.setConfiguration(properties.getConfiguration());
if (!ObjectUtils.isEmpty(this.interceptors)) {
mybatisPlus.setPlugins(this.interceptors);
}
// MP 全局配置，更多内容进入类看注释
GlobalConfiguration globalConfig = new GlobalConfiguration();
globalConfig.setDbType(DBType.MYSQL.name());//数据库类型
// ID 策略 AUTO->`0`("数据库ID自增") INPUT->`1`(用户输入ID") ID_WORKER->`2`("全局唯一ID") UUID->`3`("全局唯一ID")
globalConfig.setIdType(IdType.AUTO.getKey());
//MP 属性下划线 转 驼峰 , 如果原生配置 mc.setMapUnderscoreToCamelCase(true) 开启，该配置可以无。
//globalConfig.setDbColumnUnderline(true);
mybatisPlus.setGlobalConfig(globalConfig);
MybatisConfiguration mc = new MybatisConfiguration();
// 对于完全自定义的mapper需要加此项配置，才能实现下划线转驼峰
mc.setMapUnderscoreToCamelCase(true);
mc.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
mybatisPlus.setConfiguration(mc);
if (this.databaseIdProvider != null) {
mybatisPlus.setDatabaseIdProvider(this.databaseIdProvider);
}
if (StringUtils.hasLength(this.properties.getTypeAliasesPackage())) {
mybatisPlus.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
}
if (StringUtils.hasLength(this.properties.getTypeHandlersPackage())) {
mybatisPlus.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
}
if (!ObjectUtils.isEmpty(this.properties.resolveMapperLocations())) {
mybatisPlus.setMapperLocations(this.properties.resolveMapperLocations());
}
return mybatisPlus;
}
}