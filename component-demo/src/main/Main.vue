<template>
    <div>
      <h1>主界面</h1>
      <router-link to="/main/tradeManage">商品管理</router-link>
      <router-link to="/main/userManage">用户管理</router-link>
       <!-- router-link占位符 -->
      <router-view></router-view>
      
    </div>
</template>

<script>



export default{
    name:'Main',
    components:{
    
}
}
</script>