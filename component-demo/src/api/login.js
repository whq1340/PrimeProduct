import request from '@/utils/request'

export function login(username,password){
    return request({
        method: 'post',
        url: '/login',
        data: {
            username: username,
            password: password
        }
    })
}