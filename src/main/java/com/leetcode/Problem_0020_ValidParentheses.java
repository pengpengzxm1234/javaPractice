package com.leetcode;

import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

/**
 * leetcode高频讲解三
 * 括号（匹配）问题
 * 判断是否有效的符号组合
 * 有效，如（）{} []  (){}[], {[]}
 * 无效，如{（}）
 * 思路：利用一个栈，左边符号压栈，右边符号弹栈，
 *      弹出的和右边符号匹配，则匹配
 *      遍历到最后，栈里是空，合法
 * 如果只有一类符号，可以利用计数方法，遇到左边符号加一，遇到右边符号减一，
 * 只要减到0一下，不合法，如果到最后不是0也不合法
 */
public class Problem_0020_ValidParentheses {

    public static boolean isValid(String s){
        if(StringUtils.isBlank(s)){
            return true;
        }
        char[] str = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length;i++){
            char cha = str[i];
            if(cha == '(' || cha == '{' || cha == '['){
                stack.add(cha);
            }else {
                if(stack.isEmpty()){//没有东西弹出
                    return false;
                }
                char last = stack.pop();
                if((cha == ')' && last != '(')
                        || (cha == '}' && last != '{')
                        || (cha == ']' && last != '[')){
                    return false;
                }

            }
        }
        return stack.isEmpty();//最后栈为空，表示都匹配
    }
}
