package com.nikki.mall.tiny.mbg;

import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.xml.ConfigurationParser;
/**
 * this class is to gen MBG code
 */
public class Generator {
    public static void main(String[] args) throws Exception{
        //MBG execute the warning info in process
        List<String> warnings = new ArrayList<String>();
        //cover the code when the generated code is duplicated\
        boolean overwrite = true;
        //read the MBG config file
        InputStream is = Generator.class.getResourceAsStream("/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        //create MBG
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,callback,warnings);
        //execute the code to gen
        myBatisGenerator.generate(null);
        //input the warning info
        for(String warning:warnings){
            System.out.println(warning);
        }
    }
}
