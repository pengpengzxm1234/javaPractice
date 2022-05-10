package com.action;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

import com.alibaba.fastjson.JSONObject;

public class BigDecimalTest {

    public void caculation(){
        Long end = 120L;
        Long now = 100L;
        Long extendTime = 10L;
        Integer expire = BigDecimal.valueOf(end).subtract(BigDecimal.valueOf(now)).add(new BigDecimal(extendTime)).intValue();
        System.out.println(expire);
    }

    public void round(){
        BigDecimal bigDecimal = new BigDecimal(12.1).setScale(0, BigDecimal.ROUND_CEILING);
        System.out.println(bigDecimal.toString());
    }

    public void nullDNull(){
        Integer one = null;
        Integer two = null;
        System.out.println(one - two);
    }

    public void testTs(){
        JSONObject object1 = new JSONObject();
        object1.put("name", "shuxue");
        object1.put("score", 12);

        JSONObject object2 = new JSONObject();
        object2.put("name", "shuxue1");
        object2.put("score", 12.8);
        try {
            Question question = JSONObject.parseObject(object1.toJSONString(), Question.class);
            newQuestion newQuestion = JSONObject.parseObject(object1.toJSONString(), newQuestion.class);
            System.out.println(JSONObject.toJSONString(question));
            System.out.println(JSONObject.toJSONString(newQuestion));


            Question question1 = JSONObject.parseObject(object2.toJSONString(), Question.class);
            newQuestion newQuestion1 = JSONObject.parseObject(object2.toJSONString(), newQuestion.class);
            System.out.println(JSONObject.toJSONString(question1));
            System.out.println(JSONObject.toJSONString(newQuestion1));
        }catch(Exception e){
            e.printStackTrace();
        }


    }

    public static class Question{
        private String name;
        private BigDecimal score;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public BigDecimal getScore() {
            return score;
        }

        public void setScore(BigDecimal score) {
            this.score = score;
        }
    }

    public static class newQuestion{
        private String name;
        private Integer score;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getScore() {
            return score;
        }

        public void setScore(Integer score) {
            this.score = score;
        }
    }

    public static void main(String[] args) {
        BigDecimalTest test = new BigDecimalTest();
//        test.caculation();
       // test.nullDNull();
        test.round();
    }
}
