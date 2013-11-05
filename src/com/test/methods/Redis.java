package com.test.methods;

import java.io.File;

import redis.clients.jedis.Jedis;

public class Redis {
	private  Jedis jedis ;
	public Redis(){
		 jedis = new Jedis("10.16.24.1", 1032) ;
		jedis.auth("45d15b8367ca7ebf371cf23059c88bbc");
	}
	public  void setKey(String key,String value){
		
		jedis.set(key, value);
	
	}
	public  void expire(String key,int time){
		jedis.expire(key, time);//10000小时
	}
	public  String  getKey(String key){
		//jedis.set("runstate", "thisuc");
		//jedis.expire("runstate", 36000000);//10000小时
		//System.out.println(jedis.keys("*"));//获取全部key
		//System.out.println(jedis.ttl("tn"));//获取有效时间
		//System.out.println(jedis.get("tn"));
		return jedis.get(key);	
	}
	
	public static void main(String[] args) throws Exception {
		String s=new FileOp().readFile("d:\\error.log").toString();
		new Redis().setKey("runstate", "0");
		System.out.print(new Redis().getKey("runstate"));
	}
}
