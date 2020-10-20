// package com.li.utils;
//
// import com.li.service.IAccountService;
// import com.li.service.impl.AccountServiceImpl;
//
// import java.lang.reflect.InvocationHandler;
// import java.lang.reflect.Method;
// import java.lang.reflect.Proxy;
//
// // @Component("proxy")
// public class ProxyAccount {
//     // @Resource(name = "accountService")
//     AccountServiceImpl service = null;
//
//     // @Bean(name = "proxyAccount")
//     public IAccountService createProxy(){
//         return (IAccountService) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), new InvocationHandler() {
//             @Override
//             public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                 Object valObj = null;
//
//                 if((method.getName()).equals("deleteAccount")){
//                     return method.invoke(service,args);
//                 }
//
//                 System.out.println("代理中..........");
//                 valObj = method.invoke(service, args);
//                 System.out.println("代理结束.........");
//                 return valObj;
//             }
//         });
//     }
//
// }
//
//
