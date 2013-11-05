// 
   // $(document).ready(function(){
        // $.ajax({ type: "POST", url: encodeURI("test_RedisAction_getStatus"),
// success: function(data) {
    // if(data==0){
        // // document.getElementsByTagName("a")[0].text="PassPort监控正在running";
        // // document.getElementsByTagName("img")[0].src="images/pro.gif";
        // document.getElementById("daohang").background="#00FF00 url(images/pro.gif) no-repeat fixed to";
               // alert("监控正在运行");
// 
    // }else{
                // document.getElementsByTagName("img")[0].src="images/Go.png";
// 
        // alert("监控已经停止");
    // }
// 
    // }});
   // });
//    
   
   
   function api(){
     
    $.post("test_runCheck_doCheck", function(data, textStatus) {
        this;
        alert("启动成功");
       }
       ); 
        
        
    }
    function getRunstate(){
        var status;
       $.post("test_Status_getStatus", function(data, textStatus) {
        this;
        status =data;
        if (status=="0") 
        { 
            alert("true");
        }else{
            alert(status)
        }
    
        });  
        
       
    }
    
    
