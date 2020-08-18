package com.cc.common.mybatisplus;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Scanner;

/**
 * @author 池臣
 * @data 2019/12/27
 * 代码生成器,使用方法,修改成员变量后,直接运行即可
 */
public class CodeGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StrUtil.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    /**
     * 数据库连接
     */
    private static String url = "jdbc:mysql://127.0.0.1:3306/cc?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    /**
     * 数据库驱动
     */
    private static String driverName = "com.mysql.jdbc.Driver";
    /**
     * 数据库连接用户名
     */
    private static String userName = "root";
    /**
     * 数据库连接密码
     */
    private static String password = "root";
    /**
     * 父包名
     */
    private static String packageParent = "com.cc";
    /**
     * 生成路径
     */
    private static String path = "C:\\vue\\my\\my-project-web\\src\\main\\java";

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //代码生成路径
        gc.setOutputDir(path);
        gc.setAuthor("");
        gc.setOpen(false);
        //实体属性 Swagger2 注解
        //gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        //dsc.setSchemaName("public");
        dsc.setDriverName(driverName);
        dsc.setUsername(userName);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(scanner("模块名"));
        pc.setParent(packageParent);
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        //生成xml
        // 如果模板引擎是 freemarker
        //String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        //List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        //focList.add(new FileOutConfig(templatePath) {
        //    @Override
        //    public String outputFile(TableInfo tableInfo) {
        //        // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
        //        return path + "\\resources\\" + pc.getModuleName()
        //                + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
        //    }
        //});
        //cfg.setFileCreate(new IFileCreate() {
        //    @Override
        //    public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
        //        // 判断自定义文件夹是否需要创建
        //        checkDir("调用默认方法创建的目录");
        //        return false;
        //    }
        //});
        //cfg.setFileOutConfigList(focList);
        //mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();
        //templateConfig.setXml(null);
        //上方如果设置为null,就是不生成
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityTableFieldAnnotationEnable(true);
        strategy.setEntityLombokModel(true);
        //strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        strategy.setRestControllerStyle(true);
        // 公共父类
        //strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        // 写于父类中的公共字段
        //strategy.setSuperEntityColumns("id");
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
