window.addEventListener('load',()=>{
   const message=document.getElementById('message');
   if (message){
       setTimeout(()=>{
           message.remove()
       },2000)
   }
});