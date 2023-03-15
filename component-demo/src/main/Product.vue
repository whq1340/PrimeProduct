<template>
    <div>
      <h1>商品{{ $route.params.id }}</h1>
      <h1>商品{{ id }}</h1>

    </div>
</template>

<script>

export default{
    name:'Main',
    props:['id'],
    components:{

    }
}
</script>