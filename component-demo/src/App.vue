<template>
  <div id="app">
    <!-- <img alt="web logo" src="./image/a1.jpg" width="50%"> -->
    <!-- 声明式链接跳转 -->
    <!-- <router-link to="/main">主界面</router-link>
    <router-link to="/my">我的</router-link> -->
    <!-- 占位符 -->
    <router-view></router-view>
    <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
    <!-- <Movie v-for="movie in movieList" :title="movie.title" :rate="movie.rate" :key="movie.id"></Movie> -->
    <!-- <h1>{{name}}</h1> -->
    <!-- <Hello></Hello> -->
  </div>
</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'
import Movie from './components/Movie.vue'
import Hello from './components/Hello.vue'
import axios from 'axios'
export default {
  name: 'App',
  components: {
    // HelloWorld
    Movie,
    Hello
  },
  data:function(){ 
    return{
      name:Movie.name,
      movieList:[
      {id:1,title:"金刚狼1",rate:3},
      {id:2,title:"金刚狼2",rate:4},
      {id:3,title:"金刚狼3",rate:6},
    ]
    }
  },
  //按生命周期顺序执行的
  // created:function(){
  //   console.log("app被创建了！")
  //   //一般网络请求在创建是发送
  //   axios.get("http://localhost:8088/user/trade").then(function(response){
  //     console.log(response)
  //   })
  // },
  mounted:function(){
    console.log("app被挂载了！")
  },
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
