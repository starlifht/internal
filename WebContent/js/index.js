// 
   // $(document).ready(function(){
        // $.ajax({ type: "POST", url: encodeURI("test_RedisAction_getStatus"),
// success: function(data) {
    // if(data==0){
        // // document.getElementsByTagName("a")[0].text="PassPort�������running";
        // // document.getElementsByTagName("img")[0].src="images/pro.gif";
        // document.getElementById("daohang").background="#00FF00 url(images/pro.gif) no-repeat fixed to";
               // alert("�����������");
// 
    // }else{
                // document.getElementsByTagName("img")[0].src="images/Go.png";
// 
        // alert("����Ѿ�ֹͣ");
    // }
// 
    // }});
   // });
//    
   
   
   function clearAllerror(){
     
    $.post("test_RedisAction_clearAllerror", function(data, textStatus) {
        this;
       
       }
    alert("���Redis������Ϣ");
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
    
    
