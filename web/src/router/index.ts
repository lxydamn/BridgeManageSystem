import {createRouter, createWebHistory} from "vue-router"


const routes = [
    {
        path:'/',
        redirect:'/index'
    },
    {
        path: '/index',
        component: () => import(/* webpackChunkName: "index" */ '../views/index.vue')
    },
    {
        path: '/login',
        component: () => import(/* webpackChunkName: "login" */ '../views/login.vue')
    },
    {
        path: '/register',
        component: () => import(/* webpackChunkName: "register" */ '../views/register.vue')
    },

];

const router = createRouter({
    history : createWebHistory(),
    routes,
})

export default router