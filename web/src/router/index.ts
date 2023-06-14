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
						/* webpackChunkName: "dashboard" */ "../views/dashboard.vue"
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
						/* webpackChunkName: "dashboard" */ "../views/dashboard.vue"
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
			import(/* webpackChunkName: "login" */ "../views/prevent.vue"),
	},
	{
		path: "/notfound",
		name: "notfound",
		meta: {
			author: 0,
		},
		component: () =>
			import(/* webpackChunkName: "404" */ "../views/404.vue"),
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
	} else if (
		sessionStorage.getItem("is_login") &&
		userStore.account != "114514" &&
		to.meta.author == 2
	) {
		next({ name: "prevent" });
	} else {
		next();
	}
});

export default router;
