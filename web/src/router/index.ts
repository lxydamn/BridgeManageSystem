import { createRouter, createWebHistory } from "vue-router";
import { useUserStore } from "../store/user";

const routes = [
	{
		path: "/",
		redirect: "/dashboard",
	},
	{
		path: "/index",
		redirect: "/dashboard",
	},
	{
		path: "/admin",
		redirect: "/admin/dashboard",
	},
	{
		path: "/index",
		meta: {
			author: 1,
		},
		component: () =>
			import(/* webpackChunkName: "index" */ "../views/index.vue"),
		children: [
			{
				path: "/dashboard",
				name: "dashboard",
				meta: {
					author: 1,
				},
				component: () =>
					import(
						/* webpackChunkName: "dashboard" */ "../views/user/dashboard.vue"
					),
			},
			{
				path: "/bridge",
				name: "bridge",
				meta: {
					author: 1,
				},
				component: () =>
					import(
						/* webpackChunkName: "bridge" */ "../views/user/bridge.vue"
					),
			},
			{
				path: "/data/basic",
				name: "basicCard",
				meta: {
					author: 1,
				},
				component: () =>
					import(
						/* webpackChunkName: "bridge" */ "../views/user/basicCard.vue"
					),
			},
			{
				path: "/data/init",
				name: "initCard",
				meta: {
					author: 1,
				},
				component: () =>
					import(
						/* webpackChunkName: "bridge" */ "../views/user/initCard.vue"
					),
			},
			{
				path: "/data/peri",
				name: "periCard",
				meta: {
					author: 1,
				},
				component: () =>
					import(
						/* webpackChunkName: "bridge" */ "../views/user/periCard.vue"
					),
			},
			{
				path: "information/",
				name: "informationIndex",
				meta: {
					author: 1,
				},
				component: () =>
					import(
						/* webpackChunkName: "bridge" */ "../views/user/informationIndex.vue"
						),
			},
		],
	}, //  admin 管理
	{
		path: "/admin",
		meta: {
			author: 2,
		},
		component: () =>
			import(
				/* webpackChunkName: "index" */ "../views/admin/adminIndex.vue"
			),
		children: [
			{
				path: "/admin/dashboard",
				name: "admin",
				meta: {
					author: 2,
				},
				component: () =>
					import(
						/* webpackChunkName: "dashboard" */ "../views/admin/adminboard.vue"
					),
			},
			{
				path: "/admin/user",
				name: "adminUser",
				meta: {
					author: 2,
				},
				component: () =>
					import(
						/* webpackChunkName: "dashboard" */ "../views/admin/user.vue"
					),
			},
			{
				path: "/admin/unit",
				name: "adminUnit",
				meta: {
					author: 2,
				},
				component: () =>
					import(
						/* webpackChunkName: "dashboard" */ "../views/admin/unit.vue"
					),
			},
			{
				path: "/admin/route",
				name: "adminRoute",
				meta: {
					author: 2,
				},
				component: () =>
					import(
						/* webpackChunkName: "dashboard" */ "../views/admin/route.vue"
					),
			},
			{
				path: "/admin/type",
				name: "adminType",
				meta: {
					author: 2,
				},
				component: () =>
					import(
						/* webpackChunkName: "dashboard" */ "../views/admin/type.vue"
					),
			},
			{
				path: "/admin/part",
				name: "adminPart",
				meta: {
					author: 2,
				},
				component: () =>
					import(
						/* webpackChunkName: "dashboard" */ "../views/admin/part.vue"
					),
			},
			{
				path: "/admin/typeComponent",
				name: "adminTypeComponent",
				meta: {
					author: 2,
				},
				component: () =>
					import(
						/* webpackChunkName: "dashboard" */ "../views/admin/typeComponent.vue"
					),
			},
			{
				path: "/admin/component",
				name: "adminComponent",
				meta: {
					author: 2,
				},
				component: () =>
					import(
						/* webpackChunkName: "dashboard" */ "../views/admin/component.vue"
					),
			},
		],
	},
	{
		path: "/login",
		name: "login",
		meta: {
			author: 0,
		},
		component: () =>
			import(/* webpackChunkName: "login" */ "../views/login.vue"),
	},
	{
		path: "/prevent",
		name: "prevent",
		meta: {
			author: 0,
		},
		component: () =>
			import(/* webpackChunkName: "login" */ "../views/error/prevent.vue"),
	},
	{
		path: "/notfound",
		name: "notfound",
		meta: {
			author: 0,
		},
		component: () =>
			import(/* webpackChunkName: "404" */ "../views/error/404.vue"),
	},
	{
		path: "/:catchAll(.*)",
		redirect: "/notfound",
	},
];

const router = createRouter({
	history: createWebHistory(),
	routes,
});

router.beforeEach((to, _form, next) => {
	const userStore = useUserStore();
	if (to.meta.author != 0 && !sessionStorage.getItem("is_login")) {
		next({ name: "login" });
	} else if ( // 管理员界面权限控制
		sessionStorage.getItem("is_login") &&
		userStore.account != "114514" &&
		to.meta.author == 2
	) {
		next({ name: "prevent" });
	} else if( // 用户权限控制
		sessionStorage.getItem("is_login") &&
		userStore.account == "114514" &&
		to.meta.author == 1
	){
		next({ name: "admin" });
	} else if (sessionStorage.getItem("is_login") && to.name === 'login') {
		if (userStore.account === '114514') {
			next({name:'admin'})
		} else {
			next({name:'dashboard'})
		}
	} else {
		next();
	}
});

export default router;
