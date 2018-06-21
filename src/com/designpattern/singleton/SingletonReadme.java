package com.designpattern.singleton;

/**
 * 1. 懒汉模式 - 线程不安全
 * 描述：实现方式简单，但不支持多线程，因为没有加锁synchronized,严格意义上讲不是单例模式
 *
 * ******************************************************
 *       public class Singleton{
 *             private static Singleton instance;
 *             private Singleton(){}
 *
 *             public static Singleton getInstance(){
 *                 if(instance == null){
 *                     instance = new Singleton();
 *                 }
 *                 return instance;
 *             }
 *         }
 * ******************************************************
 *
 * 2.懒汉模式 - 线程安全
 * 描述：支持多线程，但效率低。 优点：第一次调用才初始化，避免内存浪费。缺点：必须加锁synchronized才能保证单例，但加锁会影响效率
 *
 * **********************************************************
 *        public class Singleton{
 *             private static Singleton instance;
 *             private Singleton(){}
 *             public static synchronized Singleton getInstance(){
 *                 if(instance == null){
 *                     instance = new Singleton();
 *                 }
 *                 return instance;
 *             }
 *         }
 * **********************************************************
 *
 *
 * 3.饿汉式 - 线程安全
 * 描述：比较常用，但容易产生垃圾对象。优点：没有加锁，执行效率高。缺点：类加载时就初始化，浪费内存
 *  它基于classloader机制避免了多线程的同步问题，但instance在类加载时就实例化，虽然导致类装载的原因有多种，在单例模式中大多数都是调用getInstance()
 *  方法，但是也不能确定有其他方式导致类装载。
 *
 * ************************************************************
 *        public class Singleton{
 *             private static Singleton instance = new Singleton();
 *             private Singleton(){}
 *             public static Singleton getInstance(){
 *                 return instance;
 *             }
 *         }
 * ************************************************************
 *
 * 4.双检锁/双重检验锁（DCL, double-checked locking）
 * lazy初始化：是
 * 线程安全：是
 * 描述：采用双锁机制，安全且在多线程情况下能保持高性能
 * ************************************************************
 *        public class Singleton{
 *             private volatile static Singleton instance;
 *             private Singleton(){}
 *             public static Singleton getInstance(){
 *                 if(instance == null){
 *                     synchronized (Singleton.class){
 *                         if(instance == null){
 *                             instance = new Singleton();
 *                         }
 *                     }
 *                 }
 *                 return instance;
 *             }
 *         }
 * ************************************************************
 *
 * 5.登记式/静态内部类
 * lazy初始化：是
 * 线程安全：是
 * 描述：效果同双锁机制，但实现较简单。对静态域使用延迟初始化，应该使用这种方式而不是双锁方式。
 * 这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
 * 这种方式同样利用了classloader机制来保证初始化instance时只有一个线程，与第三种方式不同的是：第三种方式只要Singleton类被装载了，
 *      那么instance就会被实例化（没有达到lazy loading的效果），而这种方式即使Singleton被装载了，也不一定被初始化。因为SingletonHolder
 *      类没有被主动使用，只有通过显示调用getInstance方法时，才会显示装载SingletonHolder类，从而实例化instance.
 *
 * ************************************************************
 *         public class Singleton{
 *             private static class SingletonHolder{
 *                 private static final Singleton INSTANCE = new Singleton();
 *             }
 *             private Singleton(){}
 *
 *             public static final Singleton getInstance(){
 *                 return SingletonHolder.INSTANCE;
 *             }
 *         }
 * ************************************************************
 *
 * 6.枚举方式
 * lazy初始化：否
 * 线程安全：是
 * 描述：实现单例模式的最佳方式，自动支持序列机制，绝对防止多次实例化。
 * 该方式是Effecitve java作者Josh Bloch提倡的方式，不仅能避免多线程同步问题，而且还自动支持序列化机制。但是实际工作中很少用
 *
 * **********************************************
 *        public enum Singleton{
 *             INSTANCE;
 *             public void whateverMethod(){
 *
 *             }
 *         }
 * **********************************************
 *
 *  经验总结：一般情况，不建议使用第1种和第2种懒汉方式，建议使用第3种饿汉方式。只有在要明确实现lazy loading效果时，才会
 *      使用第5种登记方式。如果涉及到反序列化创建对象时，可以尝试使用第6种枚举方式。如果有其他特殊需求可以考虑使用第4种
 *      双检锁方式。
 *
 */


public class SingletonReadme {
}
