package com.test.methods;


import net.sf.json.JSONArray;

import redis.clients.jedis.Jedis;

public class Redis {
	private  Jedis jedis ;
	private String ip;
	private String port;
	public Redis() throws Exception{
		getIPandPort() ;
		 jedis = new Jedis(ip, Integer.valueOf(port)) ;
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
	public void  getIPandPort() throws Exception{
		
		String s=CommonTools.HttpGet("http://sceapi.apps.sohuno.com/api/redis/release?uid=1008");
		JSONArray jsonArray = JSONArray.fromObject(s);
		ip =jsonArray.getJSONObject(0).get("ip").toString();
		port=jsonArray.getJSONObject(0).get("port").toString();
	
		
		
	}
	public boolean exits(String key){
			return jedis.exists(key);
	}
	public void append(String key,String value){
		jedis.append(key, value);
	}
	public static void main(String[] args) throws Exception {
		//String s=new FileOp().readFile("d:\\error.log").toString();
		//new Redis().setKey("runstate", "0");
		//new Redis().jedis.del("errorinfo");
		System.out.print(new Redis().jedis.ttl("errorinfo"));
	}
}
