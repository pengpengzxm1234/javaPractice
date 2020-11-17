package com.algorithm.binaryTree;

import sun.rmi.server.InactiveGroupException;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.regex.Matcher;

/**
 * 二叉树遍历
 * 1、递归
 * 2、非递归
 * 先序(根、左、右)
 * 中序（左、根、右）
 * 后序（左、右、根）
 */
public class TraverseBinaryTree {
    /**
     * 定义节点类
     */
    static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    /**
     * 递归——先序遍历二叉树
     */
    public void preOrderRecur(Node head){
        if(null == head){
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    /**
     * 递归——中序遍历二叉树
     * @param head
     */
    public void inOrderRecur(Node head){
        if(null == head){
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    /**
     * 递归——后序
     * @param head
     */
    public void posOrderRecur(Node head){
        if(null == head){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    /**
     * 非递归——先序遍历
     * 利用栈来做到优先遍历左子树
     * @param head
     */
    public void preOrderUnRecur(Node head){
        System.out.print("pre_order:");
        if(null != head){
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()){
                head = stack.pop();
                System.out.print(head.value + " ");
                if(null != head.right){
                    stack.push(head.right);
                }
                if(null != head.left){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();

    }

    /**
     * 非递归——中序
     * @param head
     */
    public void inOrderUnRecur(Node head)throws Exception{
        System.out.print("in_order:");
        if(null != head){
            Stack<Node> stack = new Stack<>();
            while (head != null || !stack.isEmpty()){
                if(null != head){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    /**
     * 非递归——后序
     * 利用两个栈实现s1 s2
     * 将头节点压如s1，
     * 从s1中弹出节点记为cur，依次将cur的左节点、右节点压入s1.同时 cur 压入s2；重复这步骤，直到s1为空
     * （先从s1中弹出的会先压入s2中，这样在打印s2的时候，先弹出s1的那个节点就会后弹出，
     *   由于最后要先输出的是左节点，因此，左节点要先压入s1中，这样在s2中就能后入栈）
     * 打印s2；
     * @param head
     */
    public void postOrderUnRecur1(Node head){
        System.out.print("post_order:");
        if(null == head){return;}
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(head);
        while (!stack1.isEmpty()){
            head = stack1.pop();
            stack2.push(head);
            if(head.left != null){
                stack1.push(head.left);
            }
            if(head.right != null){
                stack1.push(head.right);
            }
        }
        while (!stack2.isEmpty()){
            System.out.print(stack2.pop().value + " ");
        }
        System.out.println();
    }

    /**
     * 非递归——后序遍历二叉树
     * 利用一个栈实现
     * @throws Exception
     * @Param head 最近一次被弹出并打印的节点
     *        c    栈顶节点
     *
     *  c的左节点不为空 h 对比 c的左、右节点，都不相同，则节点还未打印，此时将c的左节点入栈，
     *  c的右节点不为空 h 对比 c的右节点，值不相同，则有节点未打印，此时将c的右节点入栈
     *  上面两个条件都不符合，从站中弹出一个节点并打印，并将改节点赋值给h
     */
    public void postOrderUnRecur2(Node head){
        if(head == null){return;}
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        Node c = null;
        while (!stack.isEmpty()){
            c = stack.peek();
            if(c.left != null && head != c.left && head != c.right){
                stack.push(c.left);
            }else if(c.right != null && head != c.right){
                stack.push(c.right);
            }else {
                System.out.print(stack.pop().value + " ");
                head = c;
            }
        }
        System.out.println();
    }

    /**
     * morris 遍历 二叉树
     * 初始节点是cur是头节点，根据以下标准移动cur
     * 1、如果cur==null，过程停止，否则继续下面过程
     * 2、如果cur没有左子树，让cur向右移动，即令 cur = cur.right
     * 3、如果cur有左子树，则找到cur左子树上的最右节点，记为mostRight
     * 1）如果mostRight的right指针指向null，则令mostRight.right = cur,也就是让mostRight的right指针指向当前节点，然后让cur向左移动，即令 cur = cur.left
     * 2）如果mostRight的right指针指向cur，则令mostRight.right = null, 也就是让mostRight的right指针指向null，然后让cur向右移动，即令 cur = cur.right
     */
    public void morris(Node head){
        if(null == head){return;}
        Node cur = head;
        Node mostRight = null;
        while (cur != null){
            mostRight = cur.left;
            if(mostRight != null){//如果当前节点有左子树
                //找到左子树的最右节点
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                //从上面的while里出来后，mostRight就是cur左子树上最右的节点
                if(mostRight.right == null){//如果mostRight.right指向null
                    mostRight.right = cur;//让其指向cur
                    cur = cur.left;//cur向左移动
                    continue;//回到最外层的while，继续判断cur的情况
                }else {//如果mostRight.right指向cur
                    mostRight.right = null;
                }
            }
            //没有左子树，向右移动
            cur = cur.right;
        }
    }

    /**
     * morris先序遍历二叉树
     */
    public void morrisPre(Node head){
        if(null == head){return;}
        Node cur = head;
        Node mostRight = null;
        while (cur != null){
            mostRight = cur.left;
            if (mostRight != null){
                while (mostRight.right != null && mostRight.right!= cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = cur;
                    System.out.print(cur.value + " ");//打印行为
                    cur = cur.left;
                    continue;
                }else {
                    mostRight.right = null;
                }
            }else {
                System.out.print(cur.value + " ");
            }
            cur = cur.right;
        }
        System.out.println();
    }


    /**
     * morris中序遍历二叉树
     */
    public void morrisIn(Node head){
        if(null == head){return;}
        Node cur = head;
        Node mostRight = null;
        while (cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    mostRight.right = null;
                }
            }
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        System.out.println();
    }

    /**
     * morris后序遍历二叉树
     */
    public void morrisPos(Node head){
        if(null == head){return;}
        Node cur = head;
        Node mostRight = null;
        while (cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    mostRight.right = null;
                    printEdge(cur.left);
                }
            }
            cur = cur.right;
        }
        printEdge(head);
        System.out.println();
    }

    private void printEdge(Node head){
        Node tail = reverseEdge(head);
        Node cur  = tail;
        while (cur != null){
            System.out.print(cur.value + " ");
            cur = cur.right;
        }
        reverseEdge(tail);
    }

    private Node reverseEdge(Node from){
        Node pre = null;
        Node next = null;
        while (from != null){
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }

    /**
     * 二叉树最小深度
     * 递归方法（利用系统栈）
     * 额外空间为系统栈的高度
     * @param head
     */
    public Integer minDepth1(Node head){
        if(null == head){return 0;}
        return process(head, 1);
    }

    public Integer process(Node node, Integer level){
        if(node.left == null && node.right == null){//找到了叶子节点
            return level;
        }
        Integer ans = Integer.MAX_VALUE;
        //遍历所有的节点，找到叶子节点，并比较叶子节点高度，取小的
        if(node.left != null){
            ans = Math.min(process(node.left, level + 1), ans);
        }
        if(node.right != null){
            ans = Math.min(process(node.right, level + 1), ans);
        }

        return ans;
    }


    /************************************************************************
     *
     * 二叉树的序列化和反序列化
     *
     * 二叉树被记录成文件的过程叫做二叉树的序列化，通过文件内容重建原来二叉树的过程叫做二叉树的反序列化
     * 给定一个二叉树的头节点head，已知二叉树节点值的类型是32位整型，设计一种二叉树序列化和反序列化的方案
     **********************************************************************/

    /**
     * 方法一
     * 通过先序遍历实现序列化和反序列化
     *
     * 1、先序遍历序列化
     * 假设序列化的结果字符串为str，初始值str = "",
     * 先序遍历二叉树，如果遇到null节点，就在str的末尾加上“#！”， “#”表示这个节点为空，节点的值不存在
     * “！”表示一个值的结束，如果不在每个节点值后面加上“！”， 最后产生的结果会有歧义
     */
    public String serialByPre(Node head){
        if(head == null){return "#!";}
        String res = head.value + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }
    /**
     * 2、先序遍历反序列化
     */

    public Node reconByPreString(String preStr){
        String[] values = preStr.split("!");
        Queue<String> queue = new LinkedList<>();
        for(String value :  values){
            queue.offer(value);
        }
        return reconPreOrder(queue);
    }

    public Node reconPreOrder(Queue<String> queue){
        String value = queue.poll();
        if(value.equals("#")){
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }

    /**
     * 方法二：
     * 通过层遍历实现序列化和反序列化
     */
    public String serialByLevel(Node head){
        if(head == null){return "#";}
        String res = head.value + "!";
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()){
            head = queue.poll();
            if(head.left != null){
                res += head.left.value + "!";
                queue.offer(head.left);
            }else {
                res += "#!";
            }
            if(head.right != null){
                res += head.right.value + "!";
                queue.offer(head.right);
            }else {
                res += "#!";
            }
        }
        return res;
    }

    /**
     * 反序列化
     */
    public Node reconByLevelString(String levelStr){
        String[] values = levelStr.split("!");
        Queue<Node> queue = new LinkedList<>();
        int index = 0;
        Node head = generateNodeByString(values[index++]);
        if(head != null){
            queue.offer(head);
        }
        Node node = null;
        while (queue.isEmpty()){
            node = queue.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        return head;

    }

    public Node generateNodeByString(String value){
        if(value.equals("#")){
            return null;
        }
        return new Node(Integer.valueOf(value));
    }


    /***********************************
     *
     * 二叉树的按层打印
     *
     *************************************/
    public void printByLevel(Node head){
        if(head == null){return;}
        int level = 1;
        Node last = head;
        Node nLast = null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        System.out.print("Level " + (level++) + " : ");
        while (!queue.isEmpty()){
            head = queue.poll();
            System.out.print(head.value + " ");
            if(head.left != null){
                nLast = head.left;
                queue.offer(head.left);
            }
            if(head.right != null){
                nLast = head.right;
                queue.offer(head.right);
            }
            if(head == last && !queue.isEmpty()){
                System.out.print("\nLevel " + (level++) + " : ");
                last = nLast;
            }
        }
        System.out.println();
    }


    /**
     * ZigZag打印
     * level 1 from left to right
     * level 2 from right to left
     */
    public void printByZigZag(Node head){
        if(null == head){return;}
        Deque<Node> deque = new LinkedList<>();
        int level = 1;
        boolean lr  = true;
        Node last = head;
        Node nLast = null;
        deque.offerFirst(head);
        printLevelAndOrientation(level, lr);
        while (!deque.isEmpty()){
            if(lr){
                head = deque.pollFirst();
                if(head.left != null){
                    nLast = nLast == null ? head.left : nLast;
                    deque.offerLast(head.left);
                }
                if(head.right != null){
                    nLast = nLast == null ? head.right : nLast;
                    deque.offerLast(head.right);
                }
            }else {
                head = deque.pollLast();
                if(head.right != null){
                    nLast = nLast == null ? head.right : nLast;
                    deque.offerFirst(head.right);
                }
                if(head.left != null){
                    nLast = nLast == null ? head.left : nLast;
                    deque.offerFirst(head.left);
                }
            }
            System.out.print(head.value + " ");
            if(head == last && !deque.isEmpty()){
                lr = !lr;
                last = nLast;
                nLast = null;
                System.out.println();
                printLevelAndOrientation(level++, lr);
            }
        }
        System.out.println();
    }

    public void printLevelAndOrientation(int level, boolean lr){
        System.out.print("Level " + level + " from");
        System.out.print(lr ? "left to right: " : "right to left: ");
    }

    /****************************************************8
     *
     * 判断一颗二叉树是否为搜索二叉树和完全二叉树
     * 1、搜索二叉树概念：一棵树的左子树都小于父节点，右子树大于父节点，所有子树都成立
     * 2、平衡二叉树概念：二叉树的每一层从左到右都是满的，中间无间隔
     *
     **************************************************/

    /**
     * 判断是否搜索二叉树——morris中序遍历判断 搜索二叉树的中序遍历结果是从小到大有序的
     * 1、判断一颗二叉树是否为搜索二叉树，只要改写一个二叉树中序遍历，在遍历的过程中看节点值是否都满足递增的即可
     * 2、Morris遍历分调整二叉树结构和恢复二叉树结构两个阶段。因此,当发现节点节点的值时降序时，不能直接返回false，
     * 这么做可能会跳过恢复阶段，从而破坏二叉树的结构
     * @param head
     * @return
     * pre 根节点
     */
    public boolean isBST(Node head){
        if(null == head){return true;}
        boolean res = true;
        Node pre = null;
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null){
            cur2 = cur1.left;
            if(cur2 != null){
                while (cur2.right != null && cur2.right != cur1){
                    cur2 = cur2.right;
                }
                if(cur2.right == null){
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                }else {
                    cur2.right = null;
                }
            }
            if(pre != null && pre.value > cur1.value){
                res = false;
            }
            pre = cur1;
            cur1 = cur1.right;
        }
        return res;
    }

    /**
     * 判断是否完全二叉树 实现标准
     * 1、按层遍历，从每层的左边向右边依次遍历所有的节点
     * 2、如果当前节点有右孩子节点，但没有左孩子节点，则直接返回false
     * 3、当前节点并不是左右孩子全有，那么之后的节点必须都为叶子节点，否则返回false
     * 4、遍历过程中如果部返回false,则遍历结束后返回true
     * @param head
     * @return
     */
    public boolean isCBT(Node head){
        if(null == head){return true;}
        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;//标记后续节点是否都应该时叶子节点 false 不是 true 是
        Node l = null;
        Node r = null;
        queue.offer(head);
        while (!queue.isEmpty()){
            head = queue.poll();
            l = head.left;
            r = head.right;
            //判断节点之间是否有间隔，有间隔则不是完全二叉树
            if((leaf && (l != null || r != null)) || (l == null && r != null)){
                return false;
            }
            if(null != l){
                queue.offer(l);
            }
            if(null != r){
                queue.offer(r);
            }else {
                leaf = true;
            }
        }
        return true;
    }

    /**
     * 找到二叉树中的最大搜索二叉子树
     * Q:给定一颗二叉树的头节点head，已知其中所有节点的值都不同，找到含有节点最多的搜索二叉子树，并返回这课子树的头节点
     */

    public Node getMaxBST(Node node){
        return process(node).maxBSTHead;
    }

    /**
     * 树形dp套路：（利用分析可能性求解在二叉树上做类似动态规划的问题）
     * 使用前提：如果题目是S规则，则求解流程可以定成以每一个节点为头节点的子树在S规则下的每一个答案，并且最终答案一定在其中
     * 就是利用递归函数设计一个二叉树后续遍历的过程：先遍历左子树收集信息，然后是右子树收集信息，最后再头节点做信息整合。
     * 第一步：以某个节点x为头节点的子树中，分析答案有哪些可能性，并且这种分析是以x的左子树、x的右子树和x整棵树的角度来考虑的可能性
     * 第二步：根据第一步的可能性分析，列出所需要的信息
     * 第三步：合并第二步的信息，对左树和右树提出同样的要求，并写出信息结构
     * 第四步：设计递归函数，递归函数是处理以x为头节点的情况下的答案，包括设计递归的base case，默认直接得到左树和右树的信息，以及把可能性做整合，并且要
     *        返回第三步的信息结构
     */
    class ReturnType{
        public Node maxBSTHead;
        public int maxBSTSize;
        public int max;
        public int min;

        public ReturnType(Node maxBSTHead, int maxBSTSize, int min, int max) {
            this.maxBSTHead = maxBSTHead;
            this.maxBSTSize = maxBSTSize;
            this.max = max;
            this.min = min;
        }
    }

    public ReturnType process(Node x){
        //base case:如果子树是空的
        //最小值为系统最大
        //最大值为系统最小
        if(x == null){
            return new ReturnType(null, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        //默认直接得到左树全部信息
        ReturnType lDate = process(x.left);
        //默认直接得到右树全部信息
        ReturnType rData = process(x.right);
        //以下为信息整合
        //同时对以x为头节点的子树也做同样的要求，也需要返回如ReturnType描述的全部信息
        //以x为头节点的子树的最小值是：左树最小，右树最小以及x的值三者中最小的
        int min = Math.min(x.value, Math.min(lDate.min, rData.min));
        //以x为头节点的子树的最大值是：左树最大，右树最大以及x的值三者中最大的
        int max = Math.max(x.value, Math.max(lDate.max, lDate.max));
        //如果只考虑可能性一、可能性二，则以x为头节点的子树的最大搜索二叉树大小
        int maxBSTSize = Math.max(lDate.maxBSTSize, rData.maxBSTSize);
        //如果只考虑可能性一、可能性二，则以x为头节点的子树的最大搜索二叉树头节点
        Node maxBSTHead = lDate.maxBSTSize >= rData.maxBSTSize ? lDate.maxBSTHead : rData.maxBSTHead;
        //利用收集的信息，可以判断是否存在第三种可能性
        if(lDate.maxBSTHead == x.left && rData.maxBSTHead == x.right
                && x.value > lDate.max && x.value < rData.min){
            maxBSTSize = lDate.maxBSTSize + rData.maxBSTSize + 1;
            maxBSTHead = x;
        }
        return new ReturnType(maxBSTHead, maxBSTSize, min, max);
    }


    /**
     * 判断二叉树是否为平衡二叉树
     * 平衡二叉树性质：要么是一颗空树，要么任何一个节点的左右子树高度差的绝对值不超过1
     * 使用树形dp套路：
     * 第一步：以某个节点x为头节点的子树中，分析答案有哪些可能性，并且这种分析是以x的左子树、x的右子树和x整棵树的角度来考虑可能性
     *       可能性一：如果左子树是不平衡的，则以x为头节点的树就是不平衡的
     *       可能性二：如果右子树是不平衡的，则以x为投加点的树就是不平衡的
     *       可能性三：如果x的左子树和右子树高度差超过1，则以x为头节点的树就是不平衡的
     *       可能性四：如果上面的可能性都没中，那么以x为头节点的树是平衡的
     * 第二步：根据第一步的可能性分析，列出所有需要的信息。左子树和右子树都要知道各自是否是平衡的，以及高度这两个信息
     * 第三步：根据第二步信息汇总
     * 第四步：设计递归函数
     */

    public boolean isBalanced(Node head){
        return process1(head).isBalanced;
    }

    /**
     * 汇总后的信息类
     */
    class ReturnType1{
        public boolean isBalanced;
        public int height;

        public ReturnType1(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    /**
     * 判断平衡二叉树递归方法
     * @param x
     * @return
     */
    public ReturnType1 process1(Node x){
        if(x == null){
            return new ReturnType1(true, 0);
        }
        ReturnType1 lData = process1(x.left);
        ReturnType1 rData = process1(x.right);
        int height = Math.max(lData.height, rData.height) + 1;
        boolean isBalanced = lData.isBalanced && rData.isBalanced && Math.abs(lData.height - rData.height) < 2;
        return new ReturnType1(isBalanced, height);
    }

    /********************
     *
     * 通过有序数组生成平衡搜索二叉树
     * 问题1、给定一个数组arr，已知其中没有重复值，判断arr是否可能是节点类型为整型的搜索二叉树后续遍历的结果
     * 问题2、如果整型数组arr中没有重复值，且已知是一颗搜索二叉树的后续遍历结果，通过数组arr重构二叉树
     *************************/

    /**
     * 问题1解法：
     * 后续遍历，数组中最后一个节点是根节点；
     * 根据搜索二叉树的特点，比后序数组最后一个元素小的数组会在数组的左边，比后序数组最后一个元素大的数组会在数组的右边
     * 左边数组相当于数组的左子树，右边数组相当于数组的右子树，只要递归的进行如上判断即可
     */
    public boolean isPostArray(int[] arr){
        return isPost(arr, 0, arr.length - 1);
    }

    public boolean isPost(int[] arr, int start, int end){
        if(start == end){return true;}
        int less = -1;//比根节点小的数组的最后一位
        int more = end;//比根节点大的数组的第一位
        for(int i= start; i< end; i++){
            if(arr[end] > arr[i]){
                less = i;
            }else {
                more = more == end ? i : more;
            }
        }
        if(less == -1 || more == end){//所有节点都在左子树或者都在右子树
            return isPost(arr, start, end - 1);
        }
        if(less != more - 1){//如果是平衡二叉树的后序遍历，less和more应该是相临的
            return false;
        }
        return isPost(arr, start, less) && isPost(arr, more, end - 1);
    }

    /**
     * 问题2解法：
     * 一颗树的后序数组最后一个值为二叉树头节点，数组做部分都比头节点的值小，用来生成头节点的左子树
     * 剩下的部分用来生成右子树
     */
    public Node posArrayToBST(int[] posArr){
        if(null == posArr){return null;}
        return posToBST(posArr, 0, posArr.length - 1);
    }

    public Node posToBST(int[] posArr, int start, int end){
        if(start > end){return null;}
        Node head = new Node(posArr[end]);
        int less = -1;
        int more = end;
        for(int i=start; i< end; i++){
            if(posArr[end] > posArr[i]){
                less = i;
            }else {
                more = more == end ? i : more;
            }
        }
        head.left = posToBST(posArr, start, less);
        head.right = posToBST(posArr, more, end - 1);
        return head;
    }


    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args)throws Exception{
        Node node = new TraverseBinaryTree.Node(5);
        node.left = new TraverseBinaryTree.Node(3);
        node.right = new TraverseBinaryTree.Node(6);
        node.right.right = new TraverseBinaryTree.Node(7);
        TraverseBinaryTree tree = new TraverseBinaryTree();
       /* tree.preOrderRecur(node);
        tree.posOrderRecur(node);
        */
        //tree.inOrderRecur(node);
        tree.preOrderUnRecur(node);
        tree.morrisPre(node);
        System.out.println(tree.serialByPre(node));
        System.out.println();
        tree.inOrderUnRecur(node);
        tree.morrisIn(node);
        tree.postOrderUnRecur1(node);
        tree.postOrderUnRecur2(node);
        tree.morrisPos(node);
        System.out.print(tree.minDepth1(node));
        System.out.println();
        tree.printByLevel(node);
        tree.printByZigZag(node);
    }
}
