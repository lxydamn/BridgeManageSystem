import {createRouter, createWebHistory} from "vue-router"


const routes = [
    {
        path:'/',
        redirect:'/dashboard'
    },
    {
        path:'/index',
        redirect:'/dashboard'
    },
    {
        path: '/index',
        meta: {
            author:true,
        },
        component: () => import(/* webpackChunkName: "index" */ '../views/index.vue'),
        children: [
            {
                path:'/dashboard',
                name:'dashboard',
                meta: {
                    author:true,
                },
                component: () => import(/* webpackChunkName: "dashboard" */ '../views/dashboard.vue'),
            }
        ]
    },
    {
        path: '/login',
        name:'login',
        meta: {
            author:false,
        },
        component: () => import(/* webpackChunkName: "login" */ '../views/login.vue'),
        
    },
    {
        path: '/notfound',
        name:'notfound',
        meta: {
            author:false,
        },
        component: () => import(/* webpackChunkName: "404" */ '../views/404.vue'),
        
    },
    {
        path: "/:catchAll(.*)",
        redirect: "/notfound"
    }

];

const router = createRouter({
    history : createWebHistory(),
    routes,
})

router.beforeEach((to, _form, next) => {
    if (to.meta.author && !sessionStorage.getItem("is_login")) {
        next({name:'login'})
    } else {
        next()
    }
})

export default router