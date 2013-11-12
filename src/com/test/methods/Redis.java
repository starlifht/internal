package com.test.methods;



import java.util.List;
import java.util.TreeSet;
import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;

public class Redis {
	private Jedis jedis ;
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
		jedis.expire(key, time);//10000Сʱ
	}
	public  String  getKey(String key){
		//jedis.set("runstate", "thisuc");
		//jedis.expire("runstate", 36000000);//10000Сʱ
		//System.out.println(jedis.keys("*"));//��ȡȫ��key
		//System.out.println(jedis.ttl("tn"));//��ȡ��Чʱ��
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
	public void infoToRedis(long time){
		String s=String.valueOf(time);
		jedis.set(s, APITools.errorInfo.toString());
		jedis.expire(s,24*3600*7);
		jedis.lpush("errorlist",s);
	}
	public String infoFromRedis(){
		  StringBuffer sb=new StringBuffer();
			 List<String> list = jedis.lrange("errorlist", 0, -1);
			  for(int i=0;i<list.size();i++){
				  String s=list.get(i);
				  if(jedis.exists(s)){					
				   sb.append(jedis.get(s));
				   }else{
					   jedis.lrem("errorlist", i, s);
				   }
			  }
		
		return sb.toString();
		
	}
	public void test(){
		jedis.lpush("rrr1", "1");
		jedis.lpush("rrr1", "2");
		jedis.lpush("rrr1", "3");
		jedis.lpush("rrr1", "4");
		jedis.lpush("rrr1", "5");
		jedis.lpush("rrr1", "6");
		  StringBuffer sb=new StringBuffer();
		 List<String> list = jedis.lrange("rrr1", 0, -1);
		  for(int i=0;i<list.size();i++){
			  String s=list.get(i);
			  if(jedis.exists(s)){
				
			   sb.append(jedis.get(s));}else{
				   jedis.lrem("errorlist", i, s);
			   }
		  }
		  
		
	}
	public static void main(String[] args) throws Exception {
		//String s=new FileOp().readFile("d:\\error.log").toString();
		//new Redis().setKey("runstate", "0");
		//new Redis().jedis.del("errorinfo");
//		Jedis jedis=new Redis().jedis;
//		jedis.sadd("testSet", "s1");
//		  jedis.sadd("testSet", "s2");
//		  jedis.sadd("testSet", "s3");
//		  jedis.sadd("testSet", "s4");
//		  jedis.sadd("testSet", "s5");
//		  
//		  //SREM key member�Ƴ������е�memberԪ�ء�
//		 jedis.srem("testSet", "s5");
//		  
//		  //SMEMBERS key���ؼ���key�е����г�Ա��
//		  Set set = jedis.smembers("testSet1");
//		  
//		  Iterator t1=set.iterator() ;
//		  while(t1.hasNext()){
//		   Object obj1=t1.next();
//		   System.out.println(obj1);
//		  }
		new Redis().test();
	
		//new Redis().jedis.flushAll();
		  
	}
}
