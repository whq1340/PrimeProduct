import axios from 'axios'

const service=axios.create({

    baseURL:"http://localhost:8088",

    timeout:5000     //访问超时的时间限制

})
export default service