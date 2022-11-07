package API;


import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaskingPatternLayout extends PatternLayout {


   /* private  static  final Logger logger = LoggerFactory.getLogger(MaskingPatternLayout.class);
    public static void main(String[] args) {
        logger.info("I am logger info");
        logger.debug("I am logger debug");
        logger.trace("I am logger trace");
        logger.warn("I am logger warn");
        logger.error("I am logger error");



    }*/


    private Pattern appliedPattern;
    List<String> maskPatterns = new ArrayList<>();

    public  void addMaskPattern(String maskPattern){

            maskPatterns.add(maskPattern);
            appliedPattern =  Pattern.compile(maskPatterns.stream()
            .collect(Collectors.joining("|")),Pattern.MULTILINE);


    }


    private  String maskMessage(String message){


        if(appliedPattern == null){
            return  message;

        }

        StringBuilder sb = new StringBuilder(message);
        Matcher matcher = appliedPattern.matcher(sb);
        while (matcher.find()){
            IntStream.rangeClosed(1,matcher.groupCount()).forEach(group ->{

                if(matcher.group(group) != null){
                    IntStream.range(matcher.start(group),
                            matcher.end(group)).forEach(i-> sb.setCharAt(i, '*'));

                }

            });


        }

        return sb.toString();


    }





    public  String doLayout(ILoggingEvent event){

        return maskMessage(super.doLayout(event));


    }














}
